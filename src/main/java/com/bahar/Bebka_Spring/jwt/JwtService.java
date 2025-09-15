package com.bahar.Bebka_Spring.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${spring.security.jwt.secret-key}")
    private String SECRET_KEY;

    // 🔹 Token üretme
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())                 // Kullanıcı adı
                .setIssuedAt(new Date())                               // Token oluşturulma tarihi
                .setExpiration(new Date(System.currentTimeMillis()     // Bitiş tarihi (24 saat)
                        + 1000 * 60 * 60 * 24))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)   // İmzalama algoritması
                .compact();
    }

    // 🔹 Token içinden bilgileri çekmek için genel metot
    public <T> T extractClaims(String token, Function<Claims, T> claimsFunction) {
        Claims claims = Jwts
                .parserBuilder()
                .setSigningKey(getSigningKey())   // Token doğrulamak için secret key
                .build()
                .parseClaimsJws(token)            // Token’ı çözümle
                .getBody();
        return claimsFunction.apply(claims);
    }

    // 🔹 Token’dan username çekmek
    public String getUsernameByToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }

    // 🔹 Token geçerli mi kontrol et
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUsernameByToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    // 🔹 Token süresi bitmiş mi
    public boolean isTokenExpired(String token) {
        Date expirationDate = extractClaims(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }

    // 🔹 Secret Key Base64 çözülüp anahtar haline getirilir
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}