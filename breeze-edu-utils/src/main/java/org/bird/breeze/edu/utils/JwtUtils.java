package org.bird.breeze.edu.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

@Configuration
@Component
public class JwtUtils {

    @Value("${audience.clientId}")
    private String audience;
    @Value("${audience.base64Secret}")
    private String base64Security;
    @Value("${audience.name}")
    private String issuer;
    @Value("${audience.expiresSecond}")
    private int ttlMillis;

    /**
     * 解析jwt
     */
    public Claims parseJWT(String jsonWebToken){
        try
        {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        }
        catch(Exception ex)
        {
            return null;
        }
    }

    /**
     * 构建jwt
     */
    public String createJWT(Integer userId, Object userInfo,Object role)
    {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .claim("role", role)
                .claim("userInfo", userInfo)
                .claim("userId", userId)
                .setIssuer(issuer)
                .setAudience(audience)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

    public String checkExprieAndUpdate(Claims claims){
        Date now = new Date();
        Date autDate = claims.getExpiration();
        if( autDate.getTime() - now.getTime() < ttlMillis/3 ){
            return createJWT((Integer) claims.get("userId"), claims.get("userInfo"),claims.get("role"));
        }
        return null;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    public String getBase64Security() {
        return base64Security;
    }

    public void setBase64Security(String base64Security) {
        this.base64Security = base64Security;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public int getTtlMillis() {
        return ttlMillis;
    }

    public void setTtlMillis(int ttlMillis) {
        this.ttlMillis = ttlMillis;
    }
}
