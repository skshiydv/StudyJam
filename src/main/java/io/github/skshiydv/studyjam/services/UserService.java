package io.github.skshiydv.studyjam.services;
import io.github.skshiydv.studyjam.dto.LoginDto;
import io.github.skshiydv.studyjam.dto.RegisterDto;
import io.github.skshiydv.studyjam.dto.UserEntityDto;
import io.github.skshiydv.studyjam.entities.UserEntity;

import java.util.List;

public interface UserService {
    String saveUser(RegisterDto user );
    List<UserEntityDto> getUsers();
    UserEntity findUserByUsername(String username);
    UserEntity getUser(LoginDto user);
    String verifyUser(LoginDto user);
}
