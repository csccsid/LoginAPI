package com.loginapi.loginapi.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Date;

public class jwtutil
{
    /*
    有效时间30分钟
    载荷内容：用户account
     */
    public static String createtoken(int userId, String account)
    {
        //有效期30分钟
        Calendar nowtime = Calendar.getInstance();
        nowtime.add(Calendar.MINUTE,30);
        Date expiresDate = nowtime.getTime();

        return JWT.create().withAudience(String.valueOf(userId))   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userAccount", account)    //载荷
                .sign(Algorithm.HMAC256(userId+"LoginAPI"));   //加密

    }

}
