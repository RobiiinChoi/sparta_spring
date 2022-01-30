package com.sparta.week2.domain;

import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.*;


@NoArgsConstructor // 기본 생성자 대신 생성
@Entity // 테이블임을 노티
public class Course extends TimeStamped{

    @Id // ID(PK)
    @GeneratedValue(strategy = GenerationType.AUTO) // auto_increasement 처리리
    private Long id;

    @Column(nullable = false) // db 컬럼값, 반드시 존재해야 함
    private String title;

    @Column(nullable = false)
    private String tutor;

    public String getTitle() {
        return title;
    }

    public String getTutor() {
        return tutor;
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }
}