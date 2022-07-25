package com.leet.algo;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class AES {
    private static final String AES_ECB_PKCS5_PADDING = "AES/ECB/PKCS5Padding";
    private static Charset utf8 = Charset.forName("utf-8");
    private Cipher cipher;

    public AES(String keyStr) {
        Key key = null;
        try {
            key = generateKey(keyStr);
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String encryptString, String encryptKey) {
        String returnValue;
        try {
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

    public String decrypt(String decryptString) {
        if (decryptString == null || decryptString.equals("")) {
            return "";
        }

        try {
//            decryptString = URLDecoder.decode(decryptString, "UTF-8");
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(decryptString));
            return (new String(decrypt, utf8)).trim();
        } catch (Exception var6) {
            var6.printStackTrace();
            return "";
        }

    }

    private static Key generateKey(String key) throws Exception {
        try {
//            int keyLength = 256;
            int keyLength = 128;
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

    public static class MD5 {
        private MD5() {
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

    /*
    public static void main(String[] args) {
        AES aes = new AES("yu23wp$@yh3416rf");

        System.out.println(aes.encrypt("13703582383", "yu23wp$@yh3416rf"));
        System.out.println(aes.decrypt("7iXShf9wYHPCvqqHyDZIeA=="));
//        System.out.println(aes.decrypt("yVvI6/9Uw9QLUf5ENbK9yg=="));
    }
     */
}
