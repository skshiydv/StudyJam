package io.github.skshiydv.studyjam.controller;


import io.github.skshiydv.studyjam.dto.LoginDto;
import io.github.skshiydv.studyjam.dto.RegisterDto;
import io.github.skshiydv.studyjam.services.JwtService;
import io.github.skshiydv.studyjam.services.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
    private final JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userService.findUserByUsername(registerDto.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");

        }
        String res = userService.saveUser(registerDto);
        return ResponseEntity.ok(res);

    }

    //    @PostMapping("/login")

    //    public ResponseEntity<String> login(@RequestBody LoginDto loginDtoDto) {
//        UserEntity user = userService.getUser(loginDtoDto);
//        if (user == null) {
//            String res=userService.verifyUser(loginDtoDto);
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
//        }
//        return ResponseEntity.ok("Login successful");
//    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDtoDto, HttpServletResponse response) {
        String token = userService.getUser(loginDtoDto);
        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(24 * 60 * 60);
        response.addCookie(jwtCookie);
        return ResponseEntity.ok(token);
    }
}
