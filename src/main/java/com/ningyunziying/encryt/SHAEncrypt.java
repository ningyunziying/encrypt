package com.ningyunziying.encryt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAEncrypt {
    public final static String SHA_224 = "sha-224";
    public final static String SHA_256 = "sha-256";
    public final static String SHA_384 = "sha-384";
    public final static String SHA_512 = "sha-512";

    public static String encrypt(String string) {
        return encrypt(string, SHA_256);
    }

    public static String encrypt(String string, @NotNull String type) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (TextUtils.isEmpty(type)) {
            type = SHA_256;
        }
        try {
            MessageDigest md5 = MessageDigest.getInstance(type);
            byte[] bytes = md5.digest((string).getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (1 == temp.length()) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
