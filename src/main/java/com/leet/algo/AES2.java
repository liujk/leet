package com.leet.algo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author wxy
 * @since 2019/5/27.
 */
public class AES2 {
    private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
    private static Charset utf8 = Charset.forName("utf-8");

    public AES2() {
    }

    /**
     * 加密
     * @param encryptString sign
     * @param encryptKey app_key
     * @return
     */
    public static String encrypt(String encryptString, String encryptKey) {
        String returnValue;
        try {
            if (encryptKey.length() != 32) {
                encryptKey = getMessageDigest(encryptKey);
            }

            Key key = generateKey(encryptKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(1, key);
            byte[] encrypt = cipher.doFinal(encryptString.getBytes(utf8));
            returnValue = new String(Base64.getEncoder().encode(encrypt), utf8);
        } catch (Exception var6) {
            var6.printStackTrace();
            returnValue = "";
        }

        return returnValue;
    }

    public static String decrypt(String decryptString, String decryptKey) {
        String returnValue;
        try {
            if (decryptKey.length() != 32) {
                decryptKey = getMessageDigest(decryptKey);
            }

            Key key = generateKey(decryptKey);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(2, key);
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(decryptString));
            returnValue = (new String(decrypt, utf8)).trim();
        } catch (Exception var6) {
            var6.printStackTrace();
            returnValue = "";
        }

        return returnValue;
    }

    private static Key generateKey(String key) throws Exception {
        try {
            int keyLength = 256;
            byte[] keyBytes = new byte[keyLength / 8];
            Arrays.fill(keyBytes, (byte) 0);
            byte[] passwordBytes = key.getBytes("UTF-8");
            int len = passwordBytes.length < keyBytes.length ? passwordBytes.length : keyBytes.length;
            System.arraycopy(passwordBytes, 0, keyBytes, 0, len);
            return new SecretKeySpec(keyBytes, "AES");
        } catch (Exception var5) {
            var5.printStackTrace();
            throw var5;
        }
    }

    public static final String getMessageDigest(byte[] buffer) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(buffer);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;

            for (int i = 0; i < j; ++i) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 15];
                str[k++] = hexDigits[byte0 & 15];
            }

            return new String(str);
        } catch (Exception var9) {
            return null;
        }
    }

    public static String getMessageDigest(String str) {
        return getMessageDigest(str.getBytes(Charset.forName("utf-8")));
    }
}
