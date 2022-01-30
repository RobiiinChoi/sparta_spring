package com.sparta.week1.service;

import com.sparta.week1.domain.Person;
import com.sparta.week1.domain.PersonRepository;
import com.sparta.week1.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id, PersonRequestDto requestDto){
        Person person1 = personRepository.findById(id).orElseThrow(
                ()->new IllegalArgumentException("해당 아이디가 존재하지 않습니다")
        );
        person1.update(requestDto);
        return person1.getId();
    };

}
