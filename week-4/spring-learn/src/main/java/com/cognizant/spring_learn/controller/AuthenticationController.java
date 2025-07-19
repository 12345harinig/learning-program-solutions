package com.cognizant.spring_learn.controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start /authenticate");
        LOGGER.debug("Authorization Header: {}", authHeader);

        String user = getUser(authHeader);
        String token = generateJwt(user);

        Map<String, String> map = new HashMap<>();
        map.put("token", token);

        LOGGER.info("End /authenticate");
        return map;
    }

    private String getUser(String authHeader) {
        LOGGER.info("Start getUser()");
        String encoded = authHeader.substring("Basic ".length());
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes);
        LOGGER.debug("Decoded credentials: {}", decoded);
        String user = decoded.split(":")[0];
        LOGGER.info("End getUser()");
        return user;
    }

    private String generateJwt(String user) {
        LOGGER.info("Start generateJwt()");
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000)); // 20 min
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        String token = builder.compact();
        LOGGER.debug("Generated Token: {}", token);
        LOGGER.info("End generateJwt()");
        return token;
    }
}
