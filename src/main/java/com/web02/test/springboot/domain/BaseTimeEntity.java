package com.web02.test.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass     // JPA Entity 클래스들이 BaseTimeEntity 상속할 경우 필드들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class)  //BaseTimeEntity에 Auditing 기능 포함
public abstract class BaseTimeEntity {
    // 모든 Entity 상위클래스로 Entity들의 createdDate,modifiedDate 자동 관리

    @CreatedDate  // Entity가 생성되어 저장될 때 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate   //조회한 .Entity 값 변경할 때 시간 자동저장
    private LocalDateTime modifiedDate;

}
