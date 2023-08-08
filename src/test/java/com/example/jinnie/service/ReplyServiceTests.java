package com.example.jinnie.service;

import com.example.jinnie.dto.ReplyDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class ReplyServiceTests {

    @Autowired
    private ReplyService replyService;

    @Test
    public void insertTest(){
        ReplyDTO replyDTO = ReplyDTO.builder()
                .bno(10L)
                .replyText("테스트")
                .replyer("작성자")
                .build();

        replyService.register(replyDTO);
    }

}
