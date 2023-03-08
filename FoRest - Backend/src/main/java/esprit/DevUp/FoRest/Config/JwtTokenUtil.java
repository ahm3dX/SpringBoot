package esprit.DevUp.FoRest.Config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import esprit.DevUp.FoRest.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Configuration
public class JwtTokenUtil {

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	@Value("${jwt.secret}")
	private String jwtSecret;

	@Value("${jwt.ms}")
	private String jwtExpirationMs;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	private Key key;

	@PostConstruct
	public void init() {
		this.key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}

	public Claims getAllClaimsFromToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody();
	}

	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	public String generate(String username, String type) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("username", username);		
		return doGenerateToken(claims, username, type);
	}

	private String doGenerateToken(Map<String, Object> claims, String username, String type) {
		long expirationTimeLong;
		expirationTimeLong = Long.parseLong(jwtExpirationMs) * 1000;
		final Date createdDate = new Date();
		final Date expirationDate = new Date(createdDate.getTime() + expirationTimeLong);

		return Jwts.builder().setClaims(claims).setSubject(username.toString()).setIssuedAt(createdDate).setExpiration(expirationDate).signWith(key).compact();
	}

	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	
	public String getIdFromToken(String token) {
		token = token.startsWith("Bearer ") ? token.substring(7, token.length()) : token;
		Claims cc = jwtUtil.getAllClaimsFromToken(token);
		return cc.get("username").toString();
	}
}

