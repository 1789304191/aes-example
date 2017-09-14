package v2ch09.aes;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;


/**
 * Created by Maggie on 2017/9/12.
 */
public class AESWORDTEST {

    public static final String KEY_ALGORITHM = "AES";

    public static final String KEY_LENGTH="128";

    public static final String ENCODING = "UTF-8";

    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        String base64InputStr=Base64Coder.encode2String("12345678");
        System.out.println("====base64加密后的字符串===="+base64InputStr);
        String inputData = Base64Coder.decode2String(base64InputStr);
        System.out.println("====base64解密后的字符串===="+inputData);
        //base64解密后的密钥
        byte[] key = Base64Coder.decode("UfDRP6UVzJMKi9+Jw5vGug==");
        //base64解密后的待加密字段
        byte[] outputData = Base64Coder.decode(base64InputStr);
        System.out.println("====AES加密后的字符串再通过base64加密字符串===="+Base64Coder.encode(encrypt(outputData,key)));
        System.out.println("====AES解密后的字符串===="+new String(decrypt(encrypt(outputData,key),key), ENCODING));

    }

    public static byte[] initKey(int keyLength) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(keyLength);
        SecretKey key = kg.generateKey();
        return key.getEncoded();
    }

    /**
     * 生成AES密钥并用base64加密
     * 如UfDRP6UVzJMKi9+Jw5vGug==
     */
    public static String generateKey() throws Exception {
        byte[] b=Base64.encodeBase64(initKey(Integer.valueOf(KEY_LENGTH)));
        return new String(b, ENCODING);
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, k);
        return cipher.doFinal(data);
    }

    private static Key toKey(byte[] key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key, KEY_ALGORITHM);
        return secretKey;
    }


}
