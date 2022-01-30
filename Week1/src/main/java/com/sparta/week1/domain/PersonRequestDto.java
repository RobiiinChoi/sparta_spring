package com.sparta.week1.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PersonRequestDto {
    private final Long id;
    private final String name;
    private final int age;
    private final String address;
    private final String job;
}
