package com.densoft.carsoko.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {
    private String email;
    private String name;
    private String token;
}
