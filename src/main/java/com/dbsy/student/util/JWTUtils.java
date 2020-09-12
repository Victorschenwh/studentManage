package com.dbsy.student.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static String SIGNATURE = "1315456eyJ0eXAiOiJKV1QiLCnk;l'.'';'llkjhugyghgjkgffl;l[ls[lgkojfvjovzklvfvoiusjfi0wir90824748r8wefsidjcmdlmcl;smzdlvmsl;zd/msdkij;ifuweur84r8774rihifjaopkgf5g464h41gf5h15g4b86s4g51r5g45s" +
            "JhbGciOiJIUzI1NiJ9.eyJzdHVkZW50SWQiOjIsImlkIjozLCJleHAiOjE1OTk5MDAzMTl9.9_rCXgTyOz0-2CzWonUPcBCHqWS3OzAtLp8f3a9kjihugyftdrseadgvhvfxea34479u09i09u89frdesa3yvlxmlfdogeig9eu8yer" +
            "jnvmxclv,xlmblmglbdxkpokhokn;h,n;,hn;kdkpksgb;,b,zlvmkfmvkfjokofkpsdkfpskdfkodfadfnsjdnasdnadaspdkpakfofisdjifjsivfuvnfbvfhvisjdvodjcokdpcksdlmfwlmri4u23i403_8264595";

    public static String getToken(Map<String, Integer> map) {
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

    public static Map<String, Claim> parseToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SIGNATURE);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Map<String, Claim> claims = jwt.getClaims();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }

}
