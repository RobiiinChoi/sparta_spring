package com.sparta.week1.controller;

import com.sparta.week1.prac.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public Course getCourse(){
        Course course = new Course();
        course.setTitle("웹개발의 봄");
        course.setDays(35);
        course.setTutor("남병관");
        return course;
    }
}
