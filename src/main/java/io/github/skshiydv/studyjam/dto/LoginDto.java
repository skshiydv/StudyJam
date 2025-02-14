package io.github.skshiydv.studyjam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
