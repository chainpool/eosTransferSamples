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
package client.crypto.model.api;

/**
 * Created by swapnibble on 2017-09-08.
 */

import com.google.gson.annotations.Expose;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EosChainInfo {

    private String server_version;

    private Integer head_block_num;

    private Integer last_irreversible_block_num;

    private String head_block_id;

    private String head_block_time;

    private String head_block_producer;

    private String chain_id;

    private long virtual_block_cpu_limit;

   
    private long virtual_block_net_limit;

   
    private long block_cpu_limit;

   
    private long block_net_limit;


    public Integer getHeadBlockNum() {
        return head_block_num;
    }

    public void setHeadBlockNum(Integer headBlockNum) {
        this.head_block_num = headBlockNum;
    }

    public Integer getLastIrreversibleBlockNum() {
        return last_irreversible_block_num;
    }

    public void setLastIrreversibleBlockNum(Integer lastIrreversibleBlockNum) {
        this.last_irreversible_block_num = lastIrreversibleBlockNum;
    }

    public String getHeadBlockId() {
        return head_block_id;
    }

    public void setHeadBlockId(String headBlockId) {
        this.head_block_id = headBlockId;
    }

    public String getHeadBlockTime() {
        return head_block_time;
    }

    public void setHeadBlockTime(String headBlockTime) {
        this.head_block_time = headBlockTime;
    }

    public String getTimeAfterHeadBlockTime(int diffInMilSec) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        try {
            Date date = sdf.parse( this.head_block_time);

            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add( Calendar.MILLISECOND, diffInMilSec);
            date = c.getTime();

            return sdf.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
            return this.head_block_time;
        }
    }

    public String getHeadBlockProducer() {
        return head_block_producer;
    }

    public void setHeadBlockProducer(String headBlockProducer) {
        this.head_block_producer = headBlockProducer;
    }


    public String getBrief(){
        return    "server_version: "  + server_version
                + "\nhead block num: " + head_block_num
                + "\nlast irreversible block: " + last_irreversible_block_num
                + "\nhead block time: " + head_block_time
                + "\nhead block producer: " + head_block_producer ;
    }

    public String getChain_id() {
        return chain_id;
    }

    public void setChain_id(String chain_id) {
        this.chain_id = chain_id;
    }

    public String getServer_version() {
        return server_version;
    }

    public void setServer_version(String server_version) {
        this.server_version = server_version;
    }

    public Integer getHead_block_num() {
        return head_block_num;
    }

    public void setHead_block_num(Integer head_block_num) {
        this.head_block_num = head_block_num;
    }

    public Integer getLast_irreversible_block_num() {
        return last_irreversible_block_num;
    }

    public void setLast_irreversible_block_num(Integer last_irreversible_block_num) {
        this.last_irreversible_block_num = last_irreversible_block_num;
    }

    public String getHead_block_id() {
        return head_block_id;
    }

    public void setHead_block_id(String head_block_id) {
        this.head_block_id = head_block_id;
    }

    public String getHead_block_time() {
        return head_block_time;
    }

    public void setHead_block_time(String head_block_time) {
        this.head_block_time = head_block_time;
    }

    public String getHead_block_producer() {
        return head_block_producer;
    }

    public void setHead_block_producer(String head_block_producer) {
        this.head_block_producer = head_block_producer;
    }

    public long getVirtual_block_cpu_limit() {
        return virtual_block_cpu_limit;
    }

    public void setVirtual_block_cpu_limit(long virtual_block_cpu_limit) {
        this.virtual_block_cpu_limit = virtual_block_cpu_limit;
    }

    public long getVirtual_block_net_limit() {
        return virtual_block_net_limit;
    }

    public void setVirtual_block_net_limit(long virtual_block_net_limit) {
        this.virtual_block_net_limit = virtual_block_net_limit;
    }

    public long getBlock_cpu_limit() {
        return block_cpu_limit;
    }

    public void setBlock_cpu_limit(long block_cpu_limit) {
        this.block_cpu_limit = block_cpu_limit;
    }

    public long getBlock_net_limit() {
        return block_net_limit;
    }

    public void setBlock_net_limit(long block_net_limit) {
        this.block_net_limit = block_net_limit;
    }
}
