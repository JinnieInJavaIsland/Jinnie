package com.example.jinnie.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
@MappedSuperclass 을 사용하여, 공통으로 사용되는 칼럼들을 클래스의 상속을 이용하여 손쉽게 처리한다.
공통 칼럼 예 : 생성된 시각, 수정 시각 등등
 */

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
// AuditingEntityListeners를 적용하면 엔티티가 데이터베이스에 추가되거나 변경될 때 자동으로 시간 값을 지정할 수 있다.
// AuditingEntityListeners를 활성화 시키기 위해서는 메인 프로젝트(JinnieApplication)에 설정을 추가해야한다
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name = "regdate", updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column(name = "moddate")
    private LocalDateTime modDate;
}
