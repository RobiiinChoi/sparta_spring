package com.sparta.week2;

import com.sparta.week2.domain.Course;
import com.sparta.week2.domain.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing // Jpa가 감시하여 시간에 대해 자동으로 값 입력
@SpringBootApplication
public class Week2Application {

    public static void main(String[] args) {
        SpringApplication.run(Week2Application.class, args);
    }


    @Bean
    public CommandLineRunner demo(CourseRepository repository){
        return (args) -> {
            repository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            // 데이터 전부 조회
            List<Course> courseList = repository.findAll();
            for (int i=0; i<courseList.size();i++){
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            // 아이디 조회 or Exception Handling
            Course course = repository.findById(1L).orElseThrow(
                    () -> new NullPointerException("해당 아이디가 존재하지 않습니다")
           );
        };
    }
}
