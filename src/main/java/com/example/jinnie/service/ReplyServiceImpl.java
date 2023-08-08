package com.example.jinnie.service;

import com.example.jinnie.domain.Board;
import com.example.jinnie.domain.Reply;
import com.example.jinnie.dto.ReplyDTO;
import com.example.jinnie.repository.BoardRepository;
import com.example.jinnie.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService{

    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override
    public void register(ReplyDTO replyDTO) {
        log.info(replyDTO);
//        Long bno = replyDTO.getBno();
        Reply reply = modelMapper.map(replyDTO, Reply.class);
//        Optional<Board> result = boardRepository.findById(bno);
//        reply.setBoard(result.orElseThrow());

//        log.info(reply);
        replyRepository.save(reply);
//        log.info(reply.getBoard());
    }

    @Override
    public ReplyDTO readOne(Long rno) {
        Optional<Reply> result = replyRepository.findById(rno);
        Reply reply = result.orElseThrow();
        ReplyDTO replyDTO = modelMapper.map(reply, ReplyDTO.class);
        return replyDTO;
    }

    @Override
    public void modify(ReplyDTO replyDTO) {
        Optional<Reply> result = replyRepository.findById(replyDTO.getBno());
        Reply reply = result.orElseThrow();
        reply.change(replyDTO.getReplyText());
        replyRepository.save(reply);

    }

    @Override
    public void remove(Long rno) {
        replyRepository.deleteById(rno);
    }

    @Override
    public List<ReplyDTO> readAll(Long bno) {
        List<Reply> result = replyRepository.listOfReplies(bno);
        List<ReplyDTO> dtoList = result.stream()
                .map(reply -> modelMapper.map(reply, ReplyDTO.class)).collect(Collectors.toList());

        return dtoList;
    }
}
