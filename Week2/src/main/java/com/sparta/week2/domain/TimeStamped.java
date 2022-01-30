package com.sparta.week2.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass // 상속했을 때 컬럼으로 인식하게 함
@EntityListeners(AuditingEntityListener.class) // 생성, 수정 시간을 자동으로
public abstract class TimeStamped {

    @CreatedDate // 생성일자
    private LocalDateTime createdAt;

    @LastModifiedDate // 마지막 수정일자
    private LocalDateTime modifiedAt;
}
