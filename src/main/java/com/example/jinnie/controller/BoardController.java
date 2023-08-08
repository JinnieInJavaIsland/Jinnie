package com.example.jinnie.controller;

import com.example.jinnie.domain.Board;
import com.example.jinnie.dto.BoardDTO;
import com.example.jinnie.repository.BoardRepository;
import com.example.jinnie.repository.ReplyRepository;
import com.example.jinnie.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {

    private final BoardService boardService;
    private final ModelMapper modelMapper;
    private final ReplyRepository replyRepository;

    @GetMapping(value = "/list")
    public List<BoardDTO> boardList() {

        log.info(" [GET] ---------- [list]");
        return boardService.readAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void register(@Valid @RequestBody BoardDTO boardDTO, BindingResult bindingResult)throws BindException {
        log.info(" [POST] ---------- [register]");
        log.info(boardDTO);

        if(bindingResult.hasErrors()){
            throw new BindException(bindingResult);
        }

        boardService.register(boardDTO);
    }

    @GetMapping(value = "/{bno}")
    public BoardDTO readOne(Long bno){
        log.info(" [GET] ---------- [read]");
        return boardService.readOne(bno);
    }

    @PutMapping(value = "/{bno}")
    public void update(BoardDTO boardDTO) {
        log.info(" [PUT] ---------- [update]");
        boardService.modify(boardDTO);
    }

    @DeleteMapping(value = "/{bno}")
    public void remove(Long bno) {
        log.info(" [DELETE] ---------- [delete]");
        replyRepository.deleteAll(replyRepository.listOfReplies(bno));
        boardService.remove(bno);
    }



}
