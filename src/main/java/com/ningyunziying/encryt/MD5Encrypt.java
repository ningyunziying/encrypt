package com.ningyunziying.encryt;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Encrypt {
    /**
     * MD5加密
     *
     * @param string 加密字符串
     * @return 加密结果字符串
     * @see #encrypt(String, String)
     */
    public static String encrypt(@NotNull String string) {
        return TextUtils.isEmpty(string) ? "" : encrypt(string, "");
    }

    /**
     * MD5加密(加盐)
     *
     * @param string 加密字符串
     * @param slat   加密盐值key
     * @return 加密结果字符串
     */
    public static String encrypt(@NotNull String string, @NotNull String slat) {
        if (TextUtils.isEmpty(string)) {
            return "";
        } else {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                byte[] bytes = md5.digest((string + slat).getBytes());
                String result = "";
                for (byte b : bytes) {
                    String temp = Integer.toHexString(b & 0xff);
                    if (temp.length() == 1) {
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


    /**
     * MD5加密(多次)
     *
     * @param string 加密字符串
     * @param times  重复加密次数
     * @return 加密结果字符串
     */
    public static String encrypt(@NotNull String string, @NotNull int times) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        String md5 = string;
        for (int i = 0; i < times; i++) md5 = encrypt(md5);
        return md5;
    }


    /**
     * MD5加密(文件)
     * 可用于文件校验。
     *
     * @param file 加密文件
     * @return md5 数值
     */
    public static String encrypt(@NotNull File file) {
        if (!file.isFile()) {
            return "";
        }
        MessageDigest digest = null;
        byte buffer[] = new byte[1024];
        int len;
        try (InputStream in = new FileInputStream(file)) {
            digest = MessageDigest.getInstance("MD5");
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInt = new BigInteger(1, digest.digest());
        return bigInt.toString(16);
    }
}
