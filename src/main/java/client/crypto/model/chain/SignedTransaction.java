/*
 * Copyright (c) 2017-2018 PLACTAL.
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package client.crypto.model.chain;

import client.crypto.model.types.EosByteWriter;
import client.crypto.model.types.TypeChainId;
import client.crypto.util.HexUtils;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import client.crypto.digest.Sha256;
import client.crypto.ec.EcDsa;
import client.crypto.ec.EcSignature;
import client.crypto.ec.EosPrivateKey;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by swapnibble on 2017-09-11.
 */

public class SignedTransaction extends Transaction {

    @Expose
    private List<String> signatures = null;

    @Expose
    private List<String> context_free_data = new ArrayList<>();

    public SignedTransaction() {
        super();
    }

    public SignedTransaction(SignedTransaction anotherTxn) {
        super(anotherTxn);
        this.signatures = deepCopyOnlyContainer(anotherTxn.signatures);
        this.context_free_data = context_free_data;
    }

    public List<String> getSignatures() {
        return signatures;
    }

    public void putSignatures(List<String> signatures) {
        this.signatures = signatures;
    }

    public int getCtxFreeDataCount() {
        return (context_free_data == null) ? 0 : context_free_data.size();
    }

    public List<String> getCtxFreeData() {
        return context_free_data;
    }

    private Sha256 getDigestForSignature(TypeChainId chainId) {
        EosByteWriter writer = new EosByteWriter(255);
        ////
        System.out.println("chainId: " + Arrays.toString(chainId.getBytes()));
        ////
        writer.putBytes(chainId.getBytes());
        pack(writer);
        writer.putBytes(getCfdHash());

        ////
        System.out.println("////sign before");
        byte[] arr = writer.toBytes();
        short[] shorts = new short[arr.length];
        for(int i = 0 ;i < arr.length - 1; i++){
            shorts[i] = getUint8(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(shorts));
        System.out.println("////");
        ////

        Sha256 sha256 = Sha256.from(writer.toBytes());
        System.out.println("sha256_data: "+HexUtils.toHex(sha256.getBytes()));
        return Sha256.from(writer.toBytes());
    }

    public static void main(String[] args){
        short s = (short)(23411  & 0xFFFF);
        //System.out.println("short : " + Arrays);
    }

    private byte[] getCfdHash() {
        if (context_free_data.size() <= 0 ) {
            return Sha256.ZERO_HASH.getBytes();
        }

        EosByteWriter writer = new EosByteWriter(255);

        writer.putVariableUInt( context_free_data.size());

        for ( String hexData : context_free_data) {
            byte[] rawData = HexUtils.toBytes( hexData);
            writer.putVariableUInt( rawData.length);
            writer.putBytes( rawData);
        }

        return Sha256.from( writer.toBytes()).getBytes();
    }

    public short getUint8(short s) {
        return (short) (s & 0x00ff);
    }

    public void sign(EosPrivateKey privateKey, TypeChainId chainId) {
        if (null == this.signatures) {
            this.signatures = new ArrayList<>();
        }
        EcSignature signature = EcDsa.sign(getDigestForSignature(chainId), privateKey);
        this.signatures.add(signature.toString());
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
