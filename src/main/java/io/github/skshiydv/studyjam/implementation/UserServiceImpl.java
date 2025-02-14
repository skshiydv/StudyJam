package io.github.skshiydv.studyjam.implementation;

import io.github.skshiydv.studyjam.dto.LoginDto;
import io.github.skshiydv.studyjam.dto.RegisterDto;
import io.github.skshiydv.studyjam.dto.UserEntityDto;
import io.github.skshiydv.studyjam.entities.UserEntity;
import io.github.skshiydv.studyjam.repositories.UserRepository;
import io.github.skshiydv.studyjam.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public String saveUser(RegisterDto user) {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "User already exists";
        }
        if (user.getPassword().length() < 6) {
            return "Password must be at least 6 characters";
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setUsername(user.getUsername());
        userRepository.save(userEntity);
        return "User saved successfully";
    }

    @Override
    public List<UserEntityDto> getUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream().map(this::MapUserEntityToDto).collect(Collectors.toList());
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public UserEntity getUser(LoginDto user) {
        if(verifyUser(user).equals("User Verified")) {
            return userRepository.findByUsername(user.getUsername());
        }
        return null;
    }

@Override
    public String verifyUser(LoginDto user) {
        UserEntity userEntity = findUserByUsername(user.getUsername());
        if (userEntity == null) {
            return "User not found";
        }
        if(!passwordEncoder.matches(user.getPassword(), userEntity.getPassword())) {
            return "Wrong password";
        }
        return "User Verified";
    }


    private UserEntityDto MapUserEntityToDto(UserEntity userEntity) {
        return new UserEntityDto(userEntity.getUsername(), userEntity.getEmail(), userEntity.getPassword());
    }
}
