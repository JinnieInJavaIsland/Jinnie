package com.example.jinnie.repository;

import com.example.jinnie.domain.Board;
import com.example.jinnie.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {
    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert() {
        Long bno = 100L;

        Board board = Board.builder()
                .bno(bno)
                .build();

        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글1")
                .replyer("작성자1")
                .build();
        replyRepository.save(reply);

    }


    @Test
    public void testBoardReplies(){
        Long bno = 100L;

        List<Reply> result = replyRepository.listOfReplies(bno);
        for(Reply reply : result){
            log.info(reply);
        }
    }

    @Test
    public void testUpdate(){
        Long rno = 1L;
        Optional<Reply> result = replyRepository.findById(rno);
        Reply reply = result.orElseThrow();
        reply.change("update reply");
        replyRepository.save(reply);
    }

    @Test
    public void testDelete(){
        replyRepository.deleteById(1L);
    }

}

