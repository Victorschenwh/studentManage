package com.dbsy.student.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static String SIGNATURE = "1315456264595";

    public static String getToken(Map<String, String> map) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v) -> builder.withClaim(k, v));
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SIGNATURE));
        return token;
    }

    public static boolean checkToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SIGNATURE)).build().verify(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
