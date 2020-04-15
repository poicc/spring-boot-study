package com.soft1851.springboot.jwt.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.soft1851.springboot.jwt.util.MD5Util;

import java.util.Date;

/**
 * @ClassName Encrypt
 * @Description TODO
 * @Author mq_xu
 * @Date 2020/4/15
 * @Version 1.0
 */
public class Encrypt {
    /**
     * 生成加密后的token
     *
     * @param isVip    是不是VIP,true表示是VIP，false表示不是VIP。
     * @param username 用户名
     * @param name     姓名
     * @return 加密后的token
     */
    public String getToken(final boolean isVip, final String username,
                           final String name) {
        String token = null;
        try {
//            Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
            Date expiresAt = new Date(System.currentTimeMillis() + 30L * 1000L);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("isVip", isVip)
                    .withClaim("username", username)
                    .withClaim("name", name)
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法, mySecret是用来加密数字签名的密钥。
                    .sign(Algorithm.HMAC256(MD5Util.md5Hex("mySecret")));
        } catch (Exception exception) {
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        return token;
    }
}
