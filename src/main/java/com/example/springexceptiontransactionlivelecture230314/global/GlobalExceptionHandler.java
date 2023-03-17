package com.example.springexceptiontransactionlivelecture230314.global;

import com.example.springexceptiontransactionlivelecture230314.exception.CourseNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.exception.UserNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.exception.UserUnmatchedPasswordException;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // User
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFound(UserNotFoundException ex) {
        JsonObject json = new JsonObject();
        json.addProperty("msg", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }

    @ExceptionHandler(UserUnmatchedPasswordException.class)
    public ResponseEntity<?> UserUnmatchedPassword(UserUnmatchedPasswordException ex) {
        JsonObject json = new JsonObject();
        json.addProperty("msg", ex.getMessage());
        json.addProperty("security", "Security Check Plz");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }

    // Course
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> courseNotFound(CourseNotFoundException ex) {
        JsonObject json = new JsonObject();
        json.addProperty("msg", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
    }

}
