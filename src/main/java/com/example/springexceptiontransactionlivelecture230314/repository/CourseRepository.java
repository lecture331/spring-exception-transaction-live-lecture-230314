package com.example.springexceptiontransactionlivelecture230314.repository;

import com.example.springexceptiontransactionlivelecture230314.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
