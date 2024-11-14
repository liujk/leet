package com.leet.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @description
 * @author jkliu
 * @create 2024-01-30 15:04
 **/
public class GenXinEncryptUtil {
    public static int MAX_ENCRYPT_BLOCK = 117;
    public static int MAX_DECRYPT_BLOCK = 128;

    public static String decrypt(String keyText, String text) throws Exception {
        return decrypt(keyText, text, "UTF-8");
    }
    /**
     * 私钥解密
     *
     * @param keyText
     * @param text
     * @return
     * @throws Exception
     */
    public static String decrypt(String keyText, String text, String charset) throws Exception {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec5 = new PKCS8EncodedKeySpec(Base64.decodeBase64(keyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec5);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        byte[] encryptedData = StringUtils.isEmpty(charset) ? Base64.decodeBase64(text.getBytes()) :Base64.decodeBase64(text.getBytes(charset));
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();

        return StringUtils.isEmpty(charset) ? new String(decryptedData) : new String(decryptedData, charset);
    }

    public static String encrypt(String keyText, String text) throws Exception {
        return encrypt(keyText, text, "UTF-8");
    }

    /**
     * 公钥加密
     *
     * @param keyText
     * @param text
     * @return
     */
    public static String encrypt(String keyText, String text, String charset) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec2 = new X509EncodedKeySpec(Base64.decodeBase64(keyText));
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec2);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] data = StringUtils.isEmpty(charset) ? text.getBytes() : text.getBytes(charset);
        int inputLen = data.length;
        byte[] cache;
        int offSet = 0;
        int i = 0;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }

        byte[] outByte=out.toByteArray();
        byte[] encryptedData = Base64.encodeBase64(outByte);
        out.close();

        return StringUtils.isEmpty(charset) ? new String(encryptedData) : new String(encryptedData, charset);
    }

    /**
     * 构建RSA密钥对
     *
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static RSAKeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
        String publicKeyString = Base64.encodeBase64String(rsaPublicKey.getEncoded());
        String privateKeyString = Base64.encodeBase64String(rsaPrivateKey.getEncoded());

        System.out.println("PublicKey:" + publicKeyString);
        System.out.println("PrivateKey:" + privateKeyString);

        RSAKeyPair rsaKeyPair = new RSAKeyPair(publicKeyString, privateKeyString);
        return rsaKeyPair;
    }

    public static void main(String[] args) {
        try {
            generateKeyPair();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * RSA密钥对对象
     */
    public static class RSAKeyPair {

        private String publicKey;
        private String privateKey;

        public RSAKeyPair(String publicKey, String privateKey) {
            this.publicKey = publicKey;
            this.privateKey = privateKey;
        }

        public String getPublicKey() {
            return publicKey;
        }

        public String getPrivateKey() {
            return privateKey;
        }
    }
}
