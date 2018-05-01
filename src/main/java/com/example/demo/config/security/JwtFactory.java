package com.example.demo.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 3:25
 */
@Component
public class JwtFactory {

    //외부에 노출되어서는 안되는 Key
    private static String signingKey = "jwttest";

    public String generateToken(MemberContext context) {

        String token = null;

        try {
            token = JWT.create()
                    .withIssuer("securityDemo")
                    .withClaim("USERNAME", context.getUsername())
                    .withClaim("USER_ROLE", context.getAuthorities().toString())
                    .sign(generateAlgorithm());

        } catch (Exception e) {

        }

        return token;
    }

    private Algorithm generateAlgorithm() throws UnsupportedEncodingException {
        return Algorithm.HMAC256(signingKey);
    }

}
