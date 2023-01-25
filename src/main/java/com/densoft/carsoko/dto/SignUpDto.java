package com.densoft.carsoko.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SignUpDto {
    @NotBlank(message = "name is required")
    private String name;
    @NotBlank(message = "email is required")
    @Email(message = "invalid email")
    private String email;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "phone is required")
    private String phone;
    @NotBlank(message = "location is required")
    private String location;
}
