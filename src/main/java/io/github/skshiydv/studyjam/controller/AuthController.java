package io.github.skshiydv.studyjam.controller;


import io.github.skshiydv.studyjam.dto.LoginDto;
import io.github.skshiydv.studyjam.dto.RegisterDto;
import io.github.skshiydv.studyjam.entities.UserEntity;
import io.github.skshiydv.studyjam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userService.findUserByUsername(registerDto.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");

        }
        String res = userService.saveUser(registerDto);
        return ResponseEntity.ok(res);

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDtoDto) {
        UserEntity user = userService.getUser(loginDtoDto);
        if (user == null) {
            String res=userService.verifyUser(loginDtoDto);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
        }
        return ResponseEntity.ok("Login successful");
    }
}
