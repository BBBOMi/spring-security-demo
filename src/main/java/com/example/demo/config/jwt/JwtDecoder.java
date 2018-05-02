package com.example.demo.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.demo.advice.JwtException;
import com.example.demo.config.security.MemberContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Created By iljun
 * User : iljun
 * Date : 18. 5. 1
 * Time: 오후 5:08
 */
@Component
@Slf4j
public class JwtDecoder {

    private static String signingKey = "jwttest";

    public MemberContext decodeJwt(String token) {
        DecodedJWT decodedJWT = isValidToken(token).orElseThrow(() -> new JwtException("변조된 토큰입니다."));

        String username = decodedJWT.getClaim("USERNAME").asString();
        String role = decodedJWT.getClaim("USER_ROLE").asString();

        return new MemberContext(username,"empty",role);
    }

    private Optional<DecodedJWT> isValidToken(String token) {

        DecodedJWT jwt = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(signingKey);
            JWTVerifier verifier = JWT.require(algorithm).build();

            jwt = verifier.verify(token);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return Optional.ofNullable(jwt);
    }

}
