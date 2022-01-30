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
            // 객체 삽입 (insert)
            Course course1 = new Course("웹개발의 봄", "남병관");
            // 객체 저장
            repository.save(course1);

            // 객체 전체 찾아서 리스트 형태로 반환
            List<Course> courseList = repository.findAll();

            // 리트스 출력
            for (int i = 0; i<courseList.size(); i++ ){
                Course c = courseList.get(i);
                System.out.println(c.getTitle());
                System.out.println(c.getTutor());
            }
        };
    }
}
