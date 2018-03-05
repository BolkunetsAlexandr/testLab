package com.senla.bolkunets.virtualtestlab.security.services;

import com.senla.bolkunets.virtualtestlab.security.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultJwtBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Value("${token.secret}")
    private String secretKey;

    public TokenServiceImpl(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username, String password) throws UsernameNotFoundException {
        if(username == null || password ==  null){
            return null;
        }

        User userDetails = (User) userDetailsService.loadUserByUsername(username);

        if(!password.equals(userDetails.getPassword())){
            throw new UsernameNotFoundException("password not equals");
        }

        Date currentTime = new Date();

        Map<String, Object> claimsToken = new HashMap<>();
        claimsToken.put("userId", userDetails.getUserId());
        claimsToken.put("username", userDetails.getUsername());
        claimsToken.put("timeCreationToken", currentTime.getTime());
        claimsToken.put("role", userDetails.getRole().getAuthority());

        JwtBuilder jwtBuilder = Jwts.builder()
                                    .setExpiration(currentTime)
                                    .setClaims(claimsToken)
                                    .signWith(SignatureAlgorithm.RS512,secretKey);

        return jwtBuilder.compact();
    }
}
