package com.sparta.week3.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MemoRequestDto {

    private final String username;
    private final String contents;

}
