package com.nursery.controller;

import com.nursery.model.Employee;
import com.nursery.model.Parent;
import com.nursery.model.RegisterDTO;
import com.nursery.model.User;
import com.nursery.security.CustomUserDetails;
import com.nursery.security.CustomUserDetailsService;
import com.nursery.security.JwtUtil;
import com.nursery.service.RegisterService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @PostMapping("/login")
    public ResponseEntity<LoginRequest> login(@RequestBody LoginRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        // Input validation
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        try {
            CustomUserDetails userDetails = (CustomUserDetails) userDetailsService.loadUserByUsername(username);

            if (userDetails != null && passwordEncoder.matches(password, userDetails.getPassword())) {
                final String jwt = jwtUtil.generateToken(userDetails.getUsername());

                String role = userDetails.getAuthorities().iterator().next().getAuthority();
                User user = (User) userDetails.getUser();

                LoginRequest loginResponse = new LoginRequest(jwt, user, role);

                return ResponseEntity.ok(loginResponse);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (UsernameNotFoundException e) {
            logger.error("Username not found: {}", username, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        } catch (Exception e) {
            logger.error("Internal server error during login", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "*")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDTO registerDTO) {
        try {
            registerService.registerUser(registerDTO);
            return ResponseEntity.ok("Registration successful.");
        } catch (Exception e) {
            logger.error("Internal server error during registration", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Registration failed.");
        }
    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class LoginRequest {
    private String jwt;
    private Long id;
    private String lastName;
    private String password;
    private String firstName;
    private String username;
    private String email;
    private String role;
    private String address;
    private String phoneNumber;
    private String experience;
    private Integer salary;
    private String fidelity;

    public LoginRequest(String jwt, User user, String role) {
        this.jwt = jwt;
        this.id = user.getId();
        this.lastName = user.getLastName();
        this.firstName = user.getFirstName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.role = role;
        this.address = user.getAddress();
        this.phoneNumber = user.getPhone();

        if (user instanceof Employee) {
            this.experience = ((Employee) user).getExperience();
            this.salary = ((Employee) user).getSalary();
        } else if (user instanceof Parent) {
            this.fidelity = ((Parent) user).getFidelity();
        }
    }
}
