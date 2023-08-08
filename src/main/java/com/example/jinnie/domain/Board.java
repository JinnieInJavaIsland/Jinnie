package com.example.jinnie.domain;

import lombok.*;

import javax.persistence.*;

/*
Spring Data JPA는 엔티티 객체를 이용해서 JPA를 이용한다.
즉 JPA를 이용할 때는 테이블과 SQL을 다루는 것이 아니라, 데이터에 해당하는 엔티티 라는 객체를 다루고, JPA로 이를
데이터 베이스와 연동해서 관리하게 된다.
엔티티 객체는 쉽게 말하면 PK(기본키)를 가지는 자바의 객체이다. 엔티티 객체는 고유 식별을 위해 @Id 어노테이션을 이용한다.
 */

@Entity //엔티티 클래스로 정의하기 위해서 반드시 @Entity 어노테이션 작성 필수
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity{

    @Id //엔티티 객체의 고유 식별 (구분)을 위한 @Id 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;
    /*
    <키 생성 전략>
    GenerationType.IDENTITY : 데이터베이스에 위임(MYSQL/MariaDB) - auto_increment
    GenerationType.SEQUENCE : 데이터베이스 시퀀스 오브젝트 사용(ORACLE)
    GenerationType.TABLE : 키 생성용 테이블 사용, 모든 DB에서 사용
    GenerationType.AUTO : 방언에 따라 자동 지정, 기본값
     */

    @Column(length = 500, nullable = false) //칼럼의 길이와 null 허용 여부
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    public void change(String title, String content){
        //제목과 내용을 업데이트 하기위한 메소드
        this.title = title;
        this.content = content;
    }
}
