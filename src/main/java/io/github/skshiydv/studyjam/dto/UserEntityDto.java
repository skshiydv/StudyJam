package io.github.skshiydv.studyjam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDto {
    private String username;
    private String email;
    private String password;
}
