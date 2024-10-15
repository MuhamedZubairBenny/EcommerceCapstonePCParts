package za.ac.cput.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.User;
import za.ac.cput.dto.CustomerDto;
import za.ac.cput.dto.UserDto;
import za.ac.cput.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager){
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        try {
            userService.saveUser(userDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Optionally, return user details or token
            return ResponseEntity.ok(user); // Or any user info you want to return
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        // Clear the authentication information
        SecurityContextHolder.clearContext();
        // Optionally return a response indicating successful logout
        Map<String, String> response = new HashMap<>();
        response.put("message", "Logout successful");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto) {
        User updatedUser = userService.updateUser(userDto);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser); // Return the updated user details
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"); // Return 404 if user not found
        }
    }

    @GetMapping("/read/{id}")
    public User searchUserById(@PathVariable("id") Long id){return userService.findById(id);}

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        if (user != null) {
            return ResponseEntity.ok(user); // Return the found user
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return 404 if user not found
        }
    }


    @GetMapping("/me")
    public ResponseEntity<User> getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof User) {
                User user = (User) principal; // Assuming User is your user object

                // Convert User to DTO if necessary and return
                return ResponseEntity.ok(user); // Return the logged-in user's details
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Return 401 if principal is not User
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null); // Return 401 if not authenticated
    }


}


