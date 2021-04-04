package com.daniel.cursomc.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@org.springframework.stereotype.Component
public class JWTUtil {
	
	@Value("${jwt.secret}") // valor q ta no aplicatiob propreties
	private String secret;

	@Value("${jwt.expiration}") // valor q ta no aplicatiob propreties
	private Long expiration;
	
	public String generateToken(String username) { //gerando token
		return Jwts.builder()
				.setSubject(username) // usuário
				.setExpiration(new Date(System.currentTimeMillis() + expiration))// horpario do sistema + expiração
				.signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret.getBytes()) // como assinar o token e qual segredo
				.compact();
	}
	
	public boolean tokenValido(String token) {
		Claims claims = getClaims(token);//claims é umtipo de jwt q reinvidica coisas, nesse caso usuario
		if (claims != null) {
			String username = claims.getSubject();//retorna usuario
			Date expirationDate = claims.getExpiration(); // data de expiração 
			Date now = new Date(System.currentTimeMillis()); // data atual pra ver se o token ta expirado
			if (username != null && expirationDate != null && now.before(expirationDate)) { // instante atual é anterior a data de expiração
				return true;
			}
		}
		return false;
	}

	public String getUsername(String token) { // usuaro a partir do token
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}
	
	private Claims getClaims(String token) {
		try {
			return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();//passando chave, passando token de argumento
		}
		catch (Exception e) {
			return null;
		}
	}
}