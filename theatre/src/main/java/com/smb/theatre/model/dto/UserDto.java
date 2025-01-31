package com.smb.theatre.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String username;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    private String matchingPassword;

    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    private String role;

}
