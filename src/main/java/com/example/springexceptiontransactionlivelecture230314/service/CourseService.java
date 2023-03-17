package com.example.springexceptiontransactionlivelecture230314.service;

import com.example.springexceptiontransactionlivelecture230314.dto.CourseRequestDto;
import com.example.springexceptiontransactionlivelecture230314.entity.Course;
import com.example.springexceptiontransactionlivelecture230314.exception.CourseNotFoundException;
import com.example.springexceptiontransactionlivelecture230314.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final MessageSource messageSource;

    public Course saveCourse(CourseRequestDto requestDto) {
        Course course = new Course(requestDto);
        return courseRepository.save(course);
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(CourseRequestDto requestDto, Long id) {
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new CourseNotFoundException(
                        messageSource.getMessage(
                        "course.not.found",
                        null,
                        "Not Found",
                        Locale.getDefault()
                        )
                )
        );

        course.update(requestDto);

        return course;
    }
}
