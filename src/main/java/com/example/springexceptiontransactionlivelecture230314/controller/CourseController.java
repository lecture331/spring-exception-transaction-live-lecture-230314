package com.example.springexceptiontransactionlivelecture230314.controller;

import com.example.springexceptiontransactionlivelecture230314.dto.CourseRequestDto;
import com.example.springexceptiontransactionlivelecture230314.entity.Course;
import com.example.springexceptiontransactionlivelecture230314.exception.CourseNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.service.CourseService;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @PostMapping("/save")
    public Course saveCourse(@RequestBody CourseRequestDto requestDto) {
        return courseService.saveCourse(requestDto);
    }

    @GetMapping("/list")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @PutMapping("/update/{id}")
    public Course updateCourse(@RequestBody CourseRequestDto requestDto, @PathVariable Long id) {
        return courseService.updateCourse(requestDto, id);
    }

//    @ExceptionHandler(CourseNotFoundException.class)
//    public ResponseEntity<?> courseNotFound(CourseNotFoundException ex) {
//        JsonObject json = new JsonObject();
//        json.addProperty("msg", ex.getMessage());
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(json);
//    }
}
