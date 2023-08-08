package com.example.jinnie.controller;

import com.example.jinnie.domain.Reply;
import com.example.jinnie.dto.ReplyDTO;
import com.example.jinnie.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RestController를 이용하면 메소드의 모든 리턴 값은 JSON이나 XML등으로 처리된다
@RequestMapping("/replies")
@RequiredArgsConstructor
@Log4j2
public class ReplyController {

    private final ReplyService replyService;
    private final ModelMapper modelMapper;

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)

    //consumes : JSON 타입의 데이터를 처리하는 메소드임을 명시한다
    public void register(@Valid @RequestBody ReplyDTO replyDTO, BindingResult bindingResult) throws BindException {
        //@Valid : 검증을 위함
        //@RequestBody : JSON 문자열을 ReplyDTO로 변환하기 위함

        log.info(" [POST] ---------- [Reply register]");
        log.info(replyDTO);

        if (bindingResult.hasErrors()) {
            throw new BindException(bindingResult);
        }
        //BindingResult를 파라미터로 추가하고, 문제 있을 때는 BindException을 throw

        replyService.register(replyDTO);


    }

    @GetMapping(value = "/list")
    public List<ReplyDTO> getAll(Long bno) {
        log.info(" [GET] ---------- [Reply list]");
        return replyService.readAll(bno);
    }

    @DeleteMapping(value = "/{rno}")
    public void remove(Long rno){
        log.info(" [DELETE] ............. [Reply remove]");
        replyService.remove(rno);

    }




}
