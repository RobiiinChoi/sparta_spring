package com.sparta.week2.controller;

import com.sparta.week2.domain.Course;
import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDto;
import com.sparta.week2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping("/api/courses")
    public List<Course> getCourse(){
        return courseRepository.findAll();
    }

    // PostMapping을 통해, 같은 주소라도 방식이 다름을 구분한다
    @PostMapping("/api/courses") // RequestBody라는 어노테이션이 붙여 RequestBody라는 형태로 받아줘야함
    public Course createCourse(@RequestBody CourseRequestDto requestDto){
        // requestDto는 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름 필요
        // 그 정보를 가져오는 것

        // 저장하는 것은 DTO가 아니라 Course이니, Dto의 정보를 course에 담아야 한다.
        // 잠시 뒤 새로운 생성자를 만든다
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장, 그 결과를 반환
        return courseRepository.save(course);
    }

    // api 내의 id의 값만 수정하는 것이기 때문에 해당 id를 패스에서 가져온다는 의미로 @PathVariable 어노테이션 사용
    @PutMapping("/api/courses/{id}")
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto){
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id){
        courseRepository.deleteById(id);
        return id;
    }

}
