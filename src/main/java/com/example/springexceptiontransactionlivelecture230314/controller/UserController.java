package com.example.springexceptiontransactionlivelecture230314.controller;

import com.example.springexceptiontransactionlivelecture230314.dto.UserRequestDto;
import com.example.springexceptiontransactionlivelecture230314.entity.User;
import com.example.springexceptiontransactionlivelecture230314.exception.UserNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.exception.UserUnmatchedPasswordException;
import com.example.springexceptiontransactionlivelecture230314.service.UserService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestBody UserRequestDto requestDto) {
        return userService.saveUser(requestDto);
    }

    @PutMapping("/update")
    public User updateNickname(@RequestBody UserRequestDto requestDto) {
        return userService.updateNickname(requestDto);
    }

//    @ExceptionHandler(UserNotFoundException.class)
//    public ResponseEntity<?> userNotFound(UserNotFoundException ex) {
//        JsonObject json = new JsonObject();
//        json.addProperty("msg", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
//    }
//
//    @ExceptionHandler(UserUnmatchedPasswordException.class)
//    public ResponseEntity<?> UserUnmatchedPassword(UserUnmatchedPasswordException ex) {
//        JsonObject json = new JsonObject();
//        json.addProperty("msg", ex.getMessage());
//        json.addProperty("security", "Security Check Plz");
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
//    }


}
