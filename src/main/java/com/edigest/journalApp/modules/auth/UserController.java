package com.edigest.journalApp.modules.auth;

import com.edigest.journalApp.modules.auth.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class UserController {
    @Autowired
    public UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody RegisterRequest request) {
        HashMap<String, Object> Response = new HashMap<>();
        try {
            UserEntity user = new UserEntity();

            user.setUserName(request.getUserName());
            user.setEmail(request.getEmail());
            user.setPassWord(passwordEncoder.encode(request.getPassword()));
            user.setCreatedAt(LocalDateTime.now());

            user.setPolicyAcceptedAt(request.getPolicyAcceptedAt());
            user.setTermAcceptedAt(request.getTermAcceptedAt());

            Optional<Boolean> data = userService.createUser(user);
            if (!data.orElse(false)){
                Response.put("success", false);
                Response.put("message", "Registration failed");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response);
            }
            Response.put("success", true);
            Response.put("message", "Registration successfull");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response);
        } catch (Exception e) {
            Response.put("success", false);
            Response.put("message", "Registration failed");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response);
        }
    }
}
