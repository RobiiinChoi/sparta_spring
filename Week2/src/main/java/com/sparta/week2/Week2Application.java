package com.sparta.week2;

import com.sparta.week2.domain.Course;
import com.sparta.week2.domain.CourseRepository;
import com.sparta.week2.domain.CourseRequestDto;
import com.sparta.week2.service.CourseService;
import lombok.Getter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

// 현업에서 API 생성 후 각종 툴로 테스트 및 기능 확인 -> ARC

@EnableJpaAuditing // Jpa가 감시하여 시간에 대해 자동으로 값 입력
@SpringBootApplication
public class Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week2Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(CourseRepository courserepository, CourseService courseService){
        return (args) -> {
            courserepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courserepository.findAll();
            for(int i =0; i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequestDto requestDto = new CourseRequestDto("웹 개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto);
            courseList = courserepository.findAll();
            for(int i = 0; i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            // courserepository.deleteAll();
        };
    }
}
