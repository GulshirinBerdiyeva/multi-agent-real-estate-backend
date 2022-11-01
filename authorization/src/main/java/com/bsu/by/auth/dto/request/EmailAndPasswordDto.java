package com.bsu.by.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailAndPasswordDto {
    @NotNull
    @Schema(example = "admin@tut.by")
    @Pattern(
            regexp = RegexConstants.EMAIL_REGEX,
            message = "Valid email is required"
    )
    private String email;

    @NotNull
    @Schema(example = "Qwerty!")
    @Pattern(
            regexp = RegexConstants.PASSWORD_REGEX,
            message = "Password must contain at least one character from at least three character groups " +
                    "{Upper/Lower 'Eng' letters, digits, special symbols}"
    )
    private String password;
}
