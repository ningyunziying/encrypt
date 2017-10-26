package com.ningyunziying.encryt;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class DESEncrypt {
    static final String DEFAULT_CHARSET = "UTF-8";

    public static String encrypt(@NotNull String key, @NotNull String content, @NotNull String charSet) {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey;
        try {
            desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, keyFactory.generateSecret(desKey), random);
            byte[] byteContent = content.getBytes(charSet);
            String des_encrypt = new String(new Base64().encode(cipher.doFinal(byteContent)));
            return des_encrypt;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encrypt(@NotNull String key, @NotNull String content) {
        return encrypt(key, content, DEFAULT_CHARSET);
    }

    public static String decrypt(@NotNull String key, @NotNull String content, @NotNull String charSet) {
        SecureRandom random = new SecureRandom();
        DESKeySpec desKey = null;
        try {
            desKey = new DESKeySpec(key.getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, keyFactory.generateSecret(desKey), random);
            byte[] byteContent = new Base64().decode(content);
            String des_decrypt = new String(cipher.doFinal(byteContent), charSet);
            return des_decrypt;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(@NotNull String key, @NotNull String content) {
        return decrypt(key, content, DEFAULT_CHARSET);
    }
}
