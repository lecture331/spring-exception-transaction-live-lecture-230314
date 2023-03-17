package com.example.springexceptiontransactionlivelecture230314.service;

import com.example.springexceptiontransactionlivelecture230314.dto.UserRequestDto;
import com.example.springexceptiontransactionlivelecture230314.entity.User;
import com.example.springexceptiontransactionlivelecture230314.exception.UserNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.exception.UserUnmatchedPasswordException;
import com.example.springexceptiontransactionlivelecture230314.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final MessageSource messageSource;


    public User saveUser(UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    public User updateNickname(UserRequestDto requestDto) {

        User user = userRepository.findByUsername(requestDto.getUsername()).orElseThrow(
                () -> new UserNotFoundException(messageSource.getMessage(
                        "user.not.found",
                        null,
                        "Not Found",
                        Locale.getDefault()
                ))
        );

        if(!user.getPassword().equals(requestDto.getPassword())) {
            throw new UserUnmatchedPasswordException(messageSource.getMessage(
                    "user.pwd.unmatch",
                    null,
                    Locale.getDefault()
            ));
        }

        user.updateNickname(requestDto.getNickname());

        return user;
    }
}
