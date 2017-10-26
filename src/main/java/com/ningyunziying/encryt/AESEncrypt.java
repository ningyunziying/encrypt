package com.ningyunziying.encryt;



import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class AESEncrypt {
    static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 加密
     *
     * @param key     key
     * @param content 加密内容
     * @return 密文
     */
    public static String encrypt(@NotNull String key, @NotNull String content) {
        return encrypt(key, content, DEFAULT_CHARSET);
    }

    public static String encrypt(@NotNull String key, @NotNull String content, @NotNull String charSet) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keyGen.init(128, new SecureRandom(key.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key = keyGen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey _key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, _key);
            //8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = content.getBytes(charSet);
            //9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            //10.将加密后的数据转换为字符串
            //这里用Base64中会找不到包
            //解决办法：
            //在项目的Build path中先移除JRE System Library，再添加库JRE System Library，重新编译后就一切正常了。
            String AES_encode = new String(new Base64().encode(byte_AES));
            //11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param key     key
     * @param content 解密内容
     * @return 解密字符串
     */
    public static String decrypt(@NotNull String key, @NotNull String content) {
        return decrypt(key, content, DEFAULT_CHARSET);
    }

    public static String decrypt(@NotNull String key, @NotNull String content, @NotNull String charSet) {
        try {
            //1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //2.根据ecnodeRules规则初始化密钥生成器
            //生成一个128位的随机源,根据传入的字节数组
            keyGen.init(128, new SecureRandom(key.getBytes()));
            //3.产生原始对称密钥
            SecretKey original_key = keyGen.generateKey();
            //4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            //5.根据字节数组生成AES密钥
            SecretKey _key = new SecretKeySpec(raw, "AES");
            //6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            //7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, _key);
            //8.将加密并编码后的内容解码成字节数组
            byte[] byte_content = new Base64().decode(content);
            /*
             * 解密
             */
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, charSet);
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
