package io.github.skshiydv.studyjam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
    @NonNull
    private String username;
    @NonNull
    private String email;
    @NonNull
    private String password;
}
