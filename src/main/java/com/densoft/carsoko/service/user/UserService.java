package com.densoft.carsoko.service.user;

import com.densoft.carsoko.dto.SignUpDto;
import com.densoft.carsoko.model.User;

import java.util.Optional;

public interface UserService {

    void createUser(SignUpDto signUpDto);
}
