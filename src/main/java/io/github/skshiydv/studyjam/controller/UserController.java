package io.github.skshiydv.studyjam.controller;

import io.github.skshiydv.studyjam.dto.UserEntityDto;
import io.github.skshiydv.studyjam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;


    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/all-users")
    public List<UserEntityDto> getAllUsers() {
        return userService.getUsers();
    }
}
