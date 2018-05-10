# encrypt
## java常用加密算法
``` java
public static void main(String[] args) throws Exception {

        String keyPath = "F:/tmp/";

        String privateKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDNKcM/Xq92wH+4Di00kw+Hkq5wqsf5YWItB7lGxB5ma+wyd70RoChEHO/0TFMqLKCFsXMv671NkorygKWE1m9kIeHFaw8FBeJsajPvTVP1P7WGSr7HXc6pGYEMC+vjCsiUMJaZtDKqBX3/GUzTTs5K3ZlOaupxIv4gzuszHCxk8wEPTIVw0idcTC2+57AsY4dgZPp8zv2b+wDxiLJ/AkzpHF/Ws6Sq5kEU1Ezv+he/OGSJikFy1hEGh+gxZ74dEvcZEQBlyP7GWUp4F7vudFPPXta4GYkGq0cFjkI3UMb8HA7ZSG5gwvKpVZGxfB3Ge3ktP3sFA6EbcZkyHWygksV7AgMBAAECggEBAL20aySScd51euN+wFAH12k9uWzWjZhLctM+fBQyTgXYrwuvajT9CZ6Jv1r+pDuwDjHw9hiOe3laEn7Pc71T5qYJKlE4gCfd3BLxVNpmf0abxUbKoIOKewgjXA7+ivxiQTu9fdPcKqjJ8UpLY51UFi5ln1dCR0ub1q4Rhqu41lf0LQAIC7Pyl82O/oz22//PJfs0Va44B+JQ5/Y6HxWWkdQPJQheZnY1OuaJ6zlNQN4ppvgg6bpPLL+XzFrdfL/yJprZQABpcUFrVXbdg7uV2MXyaXDGdimMgWqT0brp+0TyOcedH9zXljxOZK8Ly8R1603BWvwa+XEn6r6obpxuolECgYEA+/y8nJEOPtaf4dHXep9dA75wYyp8yOjdEf2BYU6NRe+qK0O8rg3f4uwC9MmemVrPzYuooWA/1c3WmtjLxsO9F2VeoWr5yejT8vrAoobcEzd+U5vEG91iFQCZLknoZk+NThuOWuaNRTYmGBvzvd1dYXmT/VuEoe8RvKpL23X0hHMCgYEA0G4j93CuVbmCJxAzbuMYOWGoRrDJRL0VWRsQAoSOOX4Q0m2y2SyvK2uIHR/R8Yu/weab7zevzmDekm9VXShLMjtLjT5aWZoiLTBdqEfiHKB28MGvWWYodKojYZZb6ziGkBE0BtZ80mbrSZZ6Gugb9dB4PYyb8voHmGdpa2VXgNkCgYEA3i5dO4tmzR8+f8UfQl5rjBaJT9axihBQhEFKp7q0M9r65wTlw242XwYMITv43GzG1wxyFkAgaOsCcyv+mPYTryJRSvBg6Jei8hYIbgWM3GDMwPmR86PCjJQnfDnscPFpvVnsrdek7katVgqnYlxhrsWdKAJess1xjTF2iz246GMCgYArEkeeb4unLWGm/uMSDB3KZdLnYMsGyGgr9Lq3OntFiDajtYWa+W/tchg7pIK2/qEOyb/5jDFpXX1BF361dIkthTFUq8jx8TcUzYTdLJWeQs6xa+T3fXPov+v106OFFTZBeTyeGR7MP/ZpS45KFyMIBh+C4JatfFurc9tGFTgi6QKBgQC94RsU1+9l0F9bR8rjaO95tLh0LH+x1jH8287+VNPrz53+8rXMqHsIwFTcF9bpbUkFotvTdHJgsK5VIOwLPFu4z+M6OHKBKB3AUFclR7ktaZ6s9tWy5XjeVIlKbUEGoJ5DGw/Ob+2Lrmh9gekMVTxFseMg2VHMywodGpPImDJn9w==";

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzSnDP16vdsB/uA4tNJMPh5KucKrH+WFiLQe5RsQeZmvsMne9EaAoRBzv9ExTKiyghbFzL+u9TZKK8oClhNZvZCHhxWsPBQXibGoz701T9T+1hkq+x13OqRmBDAvr4wrIlDCWmbQyqgV9/xlM007OSt2ZTmrqcSL+IM7rMxwsZPMBD0yFcNInXEwtvuewLGOHYGT6fM79m/sA8YiyfwJM6Rxf1rOkquZBFNRM7/oXvzhkiYpBctYRBofoMWe+HRL3GREAZcj+xllKeBe77nRTz17WuBmJBqtHBY5CN1DG/BwO2UhuYMLyqVWRsXwdxnt5LT97BQOhG3GZMh1soJLFewIDAQAB";

        //RSAEncrypt.genKeyPair(keyPath,2048);

        System.out.println("--------------公钥加密私钥解密过程-------------------");
        String plainText = "demo_公钥加密私钥解密";
        //公钥加密过程
        byte[] cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), plainText.getBytes());
        String cipher = Base64.encode(cipherData);
        //私钥解密过程
        byte[] res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), Base64.decode(cipher));
        String reStr = new String(res);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + cipher);
        System.out.println("解密：" + reStr);
        System.out.println();
    
        System.out.println("--------------私钥加密公钥解密过程-------------------");
        plainText = "demo_私钥加密公钥解密";
        //私钥加密过程
        cipherData = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(RSAEncrypt.loadPrivateKeyByFile(keyPath)), plainText.getBytes());
        cipher = Base64.encode(cipherData);
        //公钥解密过程
        res = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(RSAEncrypt.loadPublicKeyByFile(keyPath)), Base64.decode(cipher));
        reStr = new String(res);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + cipher);
        System.out.println("解密：" + reStr);
        System.out.println();
    
        System.out.println("--------------公钥加密私钥解密过程 2-------------------");
        plainText = "demo_公钥加密私钥解密";
        //公钥加密过程
        String cipherDataStr = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), plainText);
        //私钥解密过程
        String resStr = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), cipherDataStr);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + cipherDataStr);
        System.out.println("解密：" + resStr);
        System.out.println();
    
        System.out.println("--------------私钥加密公钥解密过程 2-------------------");
        plainText = "demo_私钥加密公钥解密";
        //私钥加密过程
        cipherDataStr = RSAEncrypt.encrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), plainText);
        //公钥解密过程
        resStr = RSAEncrypt.decrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), cipherDataStr);
        System.out.println("原文：" + plainText);
        System.out.println("加密：" + cipherDataStr);
        System.out.println("解密：" + resStr);
        System.out.println();
        System.out.println("---------------私钥签名过程------------------");
        String content = "demo_这是用于签名的原始数据";
        String signStr = RSASignature.sign(content, RSAEncrypt.loadPrivateKeyByFile(keyPath));
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signStr);
        System.out.println();
    
        System.out.println("---------------公钥校验签名------------------");
        System.out.println("签名原串：" + content);
        System.out.println("签名串：" + signStr);
    
        System.out.println("验签结果：" + RSASignature.check(content, signStr, RSAEncrypt.loadPublicKeyByFile(keyPath)));
        System.out.println();
    
        System.out.println("---------------AES加密与解密------------------");
        String kkk = "123";
        String cont = "ABCDEFG中文!@#$%^&*()_+";
        String encodeContent = AESEncrypt.encrypt(kkk, cont);
        System.out.println("AES加密原串：" + cont);
        System.out.println("AES加密串：" + encodeContent);
        System.out.println("AES解密串：" + AESEncrypt.decrypt(kkk, encodeContent));
        System.out.println();
    
        System.out.println("---------------DES加密与解密------------------");
        kkk = "12345678";
        cont = "ABCDEFG中文!@#$%^&*()_+";
        encodeContent = DESEncrypt.encrypt(kkk, cont);
        System.out.println("DES加密原串：" + cont);
        System.out.println("DES加密串：" + encodeContent);
        System.out.println("DES解密串：" + DESEncrypt.decrypt(kkk, encodeContent));
        System.out.println();
    
        System.out.println("---------------MD5加密------------------");
        cont = "ABCDEFG中文!@#$%^&*()_+";
        encodeContent = MD5Encrypt.encrypt(cont);
        System.out.println("DES加密原串：" + cont);
        System.out.println("MD5加密串：" + encodeContent);
        System.out.println();
    
        String slat = "slat";
        encodeContent = MD5Encrypt.encrypt(cont, slat);
        System.out.println("MD5加盐加密原串：" + cont);
        System.out.println("MD5加盐加密串：" + encodeContent);
        System.out.println();
    
        encodeContent = MD5Encrypt.encrypt(cont, 5);
        System.out.println("MD5 5次加密原串：" + cont);
        System.out.println("MD5 5次加密串：" + encodeContent);
        System.out.println();
    
        System.out.println("---------------SHA加密------------------");
        encodeContent = SHAEncrypt.encrypt(cont);
        System.out.println("SHA加密原串：" + cont);
        System.out.println("SHA 默认 加密串：" + encodeContent);
        System.out.println();
        encodeContent = SHAEncrypt.encrypt(cont,SHAEncrypt.SHA_224);
        System.out.println("SHA加密原串：" + cont);
        System.out.println("SHA SHA_224 加密串：" + encodeContent);
        System.out.println();
    
        encodeContent = SHAEncrypt.encrypt(cont,SHAEncrypt.SHA_256);
        System.out.println("SHA加密原串：" + cont);
        System.out.println("SHA SHA_256 加密串：" + encodeContent);
        System.out.println();
    
        encodeContent = SHAEncrypt.encrypt(cont,SHAEncrypt.SHA_384);
        System.out.println("SHA加密原串：" + cont);
        System.out.println("SHA SHA_384 加密串：" + encodeContent);
        System.out.println();
        
        encodeContent = SHAEncrypt.encrypt(cont,SHAEncrypt.SHA_512);
        System.out.println("SHA加密原串：" + cont);
        System.out.println("SHA SHA_512 加密串：" + encodeContent);
        System.out.println();
    } 
```
以下是运行结果
```
--------------公钥加密私钥解密过程-------------------
原文：demo_公钥加密私钥解密
加密：GnRLTFD/vlKlkdfh/jHgy1kghrlhvMzH+RSkxYTiKviozPbbOTVmUTxEOqryeJ8iMJXVS7HSizyQ
8EsZbcDOqHNpwiQ5yDdjKA0RjmRjaS4L3cHFZjbvcHgNM+I++MaWkTPxxnArkk9bcHPH2VSA2nEk
Vhd2J+/DRrYNBSRbnJ+wL153k0CU7+WouGtuHkk4lmKPbhQneH8TCfPb9cl3rQx8AxvTdZfa73N0
9WB1LStLRdrjmhDbJ6C8ONyMReXt16qibDWZZDIhATnxJcvsFMy4YW1gd4yk5uln1wSBXaJOGJLU
8R4ZqacW0VkW48ouGdvIMR6td8XuZqTt5ADVuA==
解密：demo_公钥加密私钥解密

--------------私钥加密公钥解密过程-------------------
原文：demo_私钥加密公钥解密
加密：bihQROft2P9BP3t3aFFq8YLMsW0CIJkSenJpivot0xyYfvCngBPUUP/rneq8UD3+X+2fPevzCPrX
TVHi/F0GLDsfb404tHamb21yAbGu+Bq839q/D7ELWSdd1cveRQcd5sI9dQe+5YgLCLZBCHiVfIpg
OAh7QUddt+t0icpYfy4=
解密：demo_私钥加密公钥解密

--------------公钥加密私钥解密过程 2-------------------
原文：demo_公钥加密私钥解密
加密：rMyUTuCB16t2jtNkhkZy0RO2kxP4sjDR2Y8IOoJEOE3oqdEl6FA3quW3dcBjqdC8RE2poN70bx2ojVQTLu5mCi7LDrcOWbO1iRTQdRNgU3nbs5Q+2ExbWMsHUQdL0hLV/BjYu7R+3UdHVlYyXNVZ7qR112qHKMQmZKigp/asHgvTJp9Bef7WZoRuqDlD8r9vdnpLfqpDnIzshdA7zxbCpphyyYIC/GZ3MceE/sBhArHyfFCfNrUWxiMD0GfWEUhdv2kuNshui2mhSSOQTkDuHnYwZOtuiY9/urndaGiShpSfXkJdWrfStFI2ZOBhQV7GyJzrZAOw+6Swz3ivFScvxg==
解密：demo_公钥加密私钥解密

--------------私钥加密公钥解密过程 2-------------------
原文：demo_私钥加密公钥解密
加密：VGc/JGNY/TRUDUx2VLzLy/+AhnCULPFSCiwxSU37GxzrgTWFIRmby/4GzGKNwWrxoilOJ1VG+jCGStOGhBhPZ87ViJQnk9tzeaVCvTaJP/SwDKqp2qZd4vzdlMKtYb4BNJ+VjuNoHEkAPWzS7q9jm7rubZ5P6PLq/aAEBCab7vkZYbXI3rLnVckby94vSDLNygDhGZ3wpiekycLSENMM1uvNWamXmvx6ljkk0T2mGO8cLCmPxvffpBnQUrhJ8rUvW6oNsoFTU8lIZgRwOrR7Lm7hFqjegMp/AQW/60pEItzFwgQ4WidlOF1GxkvDEB++0iNi2FrIuQCaUTnapsL1EA==
解密：demo_私钥加密公钥解密

---------------私钥签名过程------------------
签名原串：demo_这是用于签名的原始数据
签名串：mNXPhBDa4Q1Vv6PJDFqEAl0kRkb1HVRpwaFf9Ab8IvM75sifm7I35oxWaqPtb6pq34ZHO/a5/cW80ul0luwlsLh3HrS5zNQT/HdJD/Pgd8DYQFB3v7Q7HfnFEWTUgMed9hRvRW2hRayWZSfF8VKsXwKxEjwAWRgocqarZ2HBVdI=

---------------公钥校验签名------------------
签名原串：demo_这是用于签名的原始数据
签名串：mNXPhBDa4Q1Vv6PJDFqEAl0kRkb1HVRpwaFf9Ab8IvM75sifm7I35oxWaqPtb6pq34ZHO/a5/cW80ul0luwlsLh3HrS5zNQT/HdJD/Pgd8DYQFB3v7Q7HfnFEWTUgMed9hRvRW2hRayWZSfF8VKsXwKxEjwAWRgocqarZ2HBVdI=
验签结果：true

---------------AES加密与解密------------------
AES加密原串：ABCDEFG中文!@#$%^&*()_+
AES加密串：ybxSBFhyJIYZEWKA/61p/cR2KDy8B6rJOXpvuBm1n3g=
AES解密串：ABCDEFG中文!@#$%^&*()_+

---------------DES加密与解密------------------
DES加密原串：ABCDEFG中文!@#$%^&*()_+
DES加密串：WI/oIqMBjS08eO7FSOE3KHvBvLjjE8d3W2BHC9MbFQU=
DES解密串：ABCDEFG中文!@#$%^&*()_+

---------------MD5加密------------------
DES加密原串：ABCDEFG中文!@#$%^&*()_+
MD5加密串：1a42722975ebcf9c626055fa0bac1afd

MD5加盐加密原串：ABCDEFG中文!@#$%^&*()_+
MD5加盐加密串：05c5f6201a105cd5c8e88d49dd9df288

MD5 5次加密原串：ABCDEFG中文!@#$%^&*()_+
MD5 5次加密串：61aa93d1c59c9f1615f3cea315f671a0

---------------SHA加密------------------
SHA加密原串：ABCDEFG中文!@#$%^&*()_+
SHA 默认 加密串：1322138018e16cc44dcefd94c053fcd563e446f8a84d979a3af1c78d78a7db23

SHA加密原串：ABCDEFG中文!@#$%^&*()_+
SHA SHA_224 加密串：3ade28bce9af6232b50644fb3a8aa042061c852d6732f6648ecc9c1b

SHA加密原串：ABCDEFG中文!@#$%^&*()_+
SHA SHA_256 加密串：1322138018e16cc44dcefd94c053fcd563e446f8a84d979a3af1c78d78a7db23

SHA加密原串：ABCDEFG中文!@#$%^&*()_+
SHA SHA_384 加密串：943f1b10ddc84b27373c414efa44e875370fb247e3a8fb874ea2cb0066cd5578a0c93c9f5de2c6c4bec3ce0348d83397

SHA加密原串：ABCDEFG中文!@#$%^&*()_+
SHA SHA_512 加密串：99e562d02c33973326b6839bf4434394329b6f1df14ff58e44d902a9b4c82ce25db2fa136568be4b40d2befae3e59e7a70595c45d2f0d22d47c64947068b1c10
```
