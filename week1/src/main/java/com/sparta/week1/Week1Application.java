package com.sparta.week1;

import com.sparta.week1.domain.Person;
import com.sparta.week1.domain.PersonRepository;
import com.sparta.week1.domain.PersonRequestDto;
import com.sparta.week1.prac.Course;
import com.sparta.week1.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class Week1Application {

    public static void main(String[] args) {
        SpringApplication.run(Week1Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository personRepository, PersonService personService) {
        return (args) -> {
            personRepository.save(new Person("Jason", 35, "Seoul", "Developer"));

            System.out.println("데이터 인쇄");
            List<Person> personList = personRepository.findAll();
            for (int i = 0; i < personList.size(); i++) {
                Person person = personList.get(i);
                System.out.println(person.getId());
                System.out.println(person.getName());
                System.out.println(person.getAge());
                System.out.println(person.getAddress());
                System.out.println(person.getJob());
            }

            // courserepository.deleteAll();
        };
    }
}
