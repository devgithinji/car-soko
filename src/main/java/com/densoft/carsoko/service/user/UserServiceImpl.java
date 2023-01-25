package com.densoft.carsoko.service.user;

import com.densoft.carsoko.dto.SignUpDto;
import com.densoft.carsoko.model.User;
import com.densoft.carsoko.repo.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void createUser(SignUpDto signUpDto) {
        if (userRepository.findUserByEmail(signUpDto.getEmail()).isPresent())
            throw new UsernameNotFoundException("email is already taken");
        if (userRepository.findUserByPhone(signUpDto.getPhone()).isPresent())
            throw new UsernameNotFoundException("phone number is already taken");
        User user = new User(signUpDto.getName(), signUpDto.getEmail(), signUpDto.getPhone(), passwordEncoder.encode(signUpDto.getPassword()), signUpDto.getLocation());
        user.setRole("ROLE_USER");
        userRepository.save(user);
    }
}
