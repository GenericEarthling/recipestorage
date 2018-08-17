package com.atomic.recipestorage.service;

import java.util.Date;
import static java.util.Collections.emptyList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationService {
	
	// define the expiration time of the token in milliseconds (1 day)
	static final long EXPIRATIONTIME = 864_000_00;	
	static final String SIGNINKEY = "SecretKey";	
	static final String PREFIX = "Bearer";

	static public void addToken(HttpServletResponse response, String username) {
		String JwtToken = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME ))
				.signWith(SignatureAlgorithm.HS512, SIGNINKEY)
				.compact();
		response.addHeader("Authorization", PREFIX + " " + JwtToken);
		response.addHeader("Access-Control-Expose-Headers", "Authorization");
	}
	
	// get token from Authorization header
	static public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey(SIGNINKEY)
					.parseClaimsJws(token.replace(PREFIX, ""))
					.getBody()
					.getSubject();
			if (user != null)
				return new UsernamePasswordAuthenticationToken(user, null, emptyList());
		}
		return null;
	}
}
