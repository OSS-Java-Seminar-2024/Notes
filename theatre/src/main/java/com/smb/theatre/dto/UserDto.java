package com.smb.theatre.dto;

// To transfer the data between the controller layer and the view layer.

import com.smb.theatre.controller.auth.PasswordMatches;
import com.smb.theatre.controller.auth.ValidEmail;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@PasswordMatches
public class UserDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String username;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    private String password;
    private String matchingPassword;

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLastName() { return lastName; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return password; }

    public String getMatchingPassword() { return matchingPassword; }

    public String getUsername() { return username; }

    @Override
    public String toString() {
        return "UserDto [username=" + username + ", password=" + password + ", fullname="
                + firstName + " " + lastName + "]";
    }
}
