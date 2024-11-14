package com.leet.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @description
 * @author jkliu
 * @create 2024-01-30 09:14
 **/
public class PayEncryptUtil {
    private static final String KEY_ALGORITHM = "AES";
    private static final String CHAR_SET = "UTF-8";

    /**
     * AES的密钥长度
     */
    private static final Integer SECRET_KEY_LENGTH = 128;

    /**
     * AES加密操作
     *
     * @param content  待加密内容
     * @param password 密钥
     * @return 返回Base64转码后的加密数据
     */
    public static String encrypt(String content, String password) {
        if (StringUtils.isAnyEmpty(content, password)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = content.getBytes(CHAR_SET);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(password));
            byte[] encryptByte = cipher.doFinal(byteContent);
            return Base64.encodeBase64String(encryptByte);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * AES解密操作
     *
     * @param encryptContent 加密的密文
     * @param password       解密的密钥
     */
    public static String decrypt(String encryptContent, String password) {
        if (StringUtils.isAnyEmpty(encryptContent, password)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, getSecretKey(password));
            byte[] result = cipher.doFinal(Base64.decodeBase64(encryptContent));
            return new String(result, CHAR_SET);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 根据自定义密钥生成AES密钥：
     *
     * @param password 自定义密钥
     */
    private static SecretKeySpec getSecretKey(final String password) throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(password.getBytes());
        keyGenerator.init(SECRET_KEY_LENGTH, random);
        SecretKey secretKey = keyGenerator.generateKey();
        return new SecretKeySpec(secretKey.getEncoded(), KEY_ALGORITHM);
    }
}
