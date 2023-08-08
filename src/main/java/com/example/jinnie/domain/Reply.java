package com.example.jinnie.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Reply", indexes = {
        @Index(name = "idx_reply_board_bno", columnList = "board_bno")
}) //쿼리 조건으로 자주 사용되는 칼럼에 인덱스를 생성해둠. @Table 어노테이션을 이용하여 인덱스를 지정할 수 있다.
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board") //참조하는 객체를 사용하지 않도록 exclude 속성값을 지정한다
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rno;

    @ManyToOne(fetch = FetchType.LAZY)
    //ManyToOne 연관관계, fetch 속성은 반드시 LAZY로 지정한다.
    //LAZY(지연로딩) : 필요한 순간까지 데이터베이스와 연결하지 않는 방식으로 동작
    private Board board;

    private String replyText;

    private String replyer;

    public void change(String replyText){
        //제목과 내용을 업데이트 하기위한 메소드
        this.replyText = replyText;
    }


}
