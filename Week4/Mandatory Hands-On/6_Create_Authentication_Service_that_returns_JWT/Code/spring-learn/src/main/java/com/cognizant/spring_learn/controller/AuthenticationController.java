package com.cognizant.spring_learn.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    public static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public Map<String,String> authenticate(@RequestHeader("Authorization") String authHeader){
        LOGGER.info("START /authenticate ...");
        LOGGER.debug("Authentication Header : {}",authHeader);

        String user = getUser(authHeader);
        LOGGER.debug("Extracted username : {}",user);

        String jwtToken = generateJwt(user);
        LOGGER.debug("Generated JWT token : {}",jwtToken);

        Map<String,String> mp = new HashMap<>();
        mp.put("token",jwtToken);
        LOGGER.info("END /authenticate ...");
        return mp;
    }

    private String getUser(String authHeader){
        LOGGER.info("START getUser() ...");

        if(authHeader == null || !authHeader.startsWith("Basic ")){
            LOGGER.warn("AuthHeader missing or invalid.");
            return "Unknown";
        }

        try {
            String base64Credentials = authHeader.substring("Basic ".length());
            byte[] decodedBytes = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(decodedBytes);
            LOGGER.debug("Decoded credentials: {}", credentials);

            // Split into [username, password]
            String[] parts = credentials.split(":", 2);
            return parts[0]; // return only the username
        } catch (Exception e) {
            LOGGER.error("Failed to decode Authorization header", e);
            return "unknown";
        }
    }

    private String generateJwt(String user){
        LOGGER.debug("START generateJwt for user: {}", user);
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);

        // Set the token issue time as current time
        builder.setIssuedAt(new Date());
        // Set the token expiry as 20 minutes from now
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

        String token = builder.compact();
        LOGGER.debug("END generateJwt");
        return token;
    }
}
