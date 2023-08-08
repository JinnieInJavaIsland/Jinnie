package com.example.jinnie.service;

import com.example.jinnie.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    void register(ReplyDTO replyDTO);

    ReplyDTO readOne(Long rno);

    void modify(ReplyDTO replyDTO);

    void remove(Long rno);

    List<ReplyDTO> readAll(Long bno);
}
