package client.util;

/**
 * @author lxg
 * @create 2018-06-11 15:52
 * @desc
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.*;


/**
 * Created by cuboo on 2016/10/15.
 */
public class RSAsignature {
    public static final String DEFAULT_CODING = "utf-8";

    /**
     * 解密
     * @author lmiky
     * @date 2014-2-25
     * @param encrypted
     * @param seed
     * @return
     * @throws Exception
     */
    private static String decrypt(String encrypted, String seed) throws Exception {
        byte[] keyb = seed.getBytes(DEFAULT_CODING);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(keyb);
        SecretKeySpec skey = new SecretKeySpec(thedigest, "AES");
        Cipher dcipher = Cipher.getInstance("AES");
        dcipher.init(Cipher.DECRYPT_MODE, skey);

        byte[] clearbyte = dcipher.doFinal(toByte(encrypted));
        return new String(clearbyte);
    }

    /**
     * 加密
     * @author lmiky
     * @date 2014-2-25
     * @param content
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String content, String key) throws Exception {
        byte[] input = content.getBytes(DEFAULT_CODING);

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] thedigest = md.digest(key.getBytes(DEFAULT_CODING));
        SecretKeySpec skc = new SecretKeySpec(thedigest, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skc);

        byte[] cipherText = new byte[cipher.getOutputSize(input.length)];
        int ctLength = cipher.update(input, 0, input.length, cipherText, 0);
        ctLength += cipher.doFinal(cipherText, ctLength);

        return parseByte2HexStr(cipherText);
    }


    /**
     * 字符串转字节数组
     * @author lmiky
     * @date 2014-2-25
     * @param hexString
     * @return
     */
    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }

    /**
     * 字节转16进制数组
     * @author lmiky
     * @date 2014-2-25
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String s = "{\"transaction\":{\"expiration\":\"2018-06-11T06:33:21\",\"ref_block_num\":2887,\"ref_block_prefix\":1261777383,\"net_usage_words\":0,\"max_cpu_usage_ms\":0,\"delay_sec\":0,\"context_free_actions\":[],\"actions\":[{\"account\":\"eosio\",\"name\":\"vote\",\"authorization\":[{\"actor\":\"beijing333\",\"permission\":\"active\"}],\"data\":\"00c018834df79c3a000075c025f53055102700000000000004454f5300000000\"}],\"transaction_extensions\":[],\"fee\":\"0.0100 EOS\"}}";
        String privacy = "5J6yuHCG8TRYPiuXdbTypShgeQkhY59AantTKechgK6gr98zZ7J";
        System.out.print(encrypt(s, privacy));
        //System.out.println(AESForNodejs.encrypt("fsadfsdafsdafsdafsadfsadfsadf", "1234fghjnmlkiuhA"));
        //System.out.println(AESForNodejs.decrypt("5b8e85b7a86ad15a275a7cb61fe4c0606005e8741f68797718a3e90d74b5092a", "1234fghjnmlkiuhA"));
    }
}