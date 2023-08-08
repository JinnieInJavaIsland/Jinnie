package com.example.jinnie.repository;

import com.example.jinnie.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
Board와 별도로 CRUD 처리하기 때문에 별도의 Repository를 작성한다
 */
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    @Query("select r from Reply r where r.board.bno = :bno")
    List<Reply> listOfReplies(Long bno);
    //bno를 참조하여 댓글 리스트를 얻기위한 @Query 메소드와 List 를 리턴값으로 가지는 메소드 선언

}
