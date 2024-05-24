package com.golamrabbiazad.fullstackcarhouse.domain;

import com.golamrabbiazad.fullstackcarhouse.JwtService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "Auth", description = "Authentication Api")
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody AccountCredentials accountCredentials) {
        UsernamePasswordAuthenticationToken credential = new UsernamePasswordAuthenticationToken(accountCredentials.username(), accountCredentials.password());
        Authentication auth = authenticationManager.authenticate(credential);

        // Generate token
        String jwts = jwtService.getToken(auth.getName());

        Map<String, String> res = new HashMap<>();
        res.put("token", jwts);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
                .header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
                .contentType(MediaType.APPLICATION_JSON)
                .body(res);
    }
}
