package com.sparta.week1_lecture.controller;

import com.sparta.week1_lecture.prac.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson(){
        Person person = new Person();
        person.setAddress("경기");
        person.setAge(34);
        person.setJob("job");
        person.setName("RobinChoi");
        return person;
    }
}
