package com.example.jinnie.service;

/*
서비스 계층을 위한 BoardService 인터페이스
 */

import com.example.jinnie.dto.BoardDTO;

import java.util.List;

public interface BoardService {

    Long register(BoardDTO boardDTO);

    BoardDTO readOne(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    List<BoardDTO> readAll();

}
