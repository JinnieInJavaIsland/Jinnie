package com.example.jinnie.service;

/*
BoardService를 구현하여 실제 로직을 작동시키는 BoardServiceImpl 클래스
 */

import com.example.jinnie.domain.Board;
import com.example.jinnie.dto.BoardDTO;
import com.example.jinnie.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service //서비스 계층이라는 것을 알리기 위한 스프링의 빈 어노테이션
@Log4j2
@RequiredArgsConstructor
@Transactional
//@Transactional
//목적 : 오류로부터 복구를 허용하고 데이터베이스를 일관성있게 유지하는 안정적인 작업 단위를 제공한다.
//동시 접근하는 여러 프로그램 간 격리를 제공한다
//데이터 처리 중 오류 발생시 roll back
public class BoardServiceImpl implements BoardService{

    private final ModelMapper modelMapper;
    private final BoardRepository boardRepository;

    @Override //게시물 등록
    public Long register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        Long bno = boardRepository.save(board).getBno();
        return bno;
    }

    @Override //게시물 단건 조회
    public BoardDTO readOne(Long bno) {
        Optional<Board> result = boardRepository.findById(bno);
        Board board = result.orElseThrow(); //(bno 게시물 데이터 )값이 존재하면 그 값을 리턴하고 존재하지 않으면 익셉션 던지기
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override // 게시물 수정
    public void modify(BoardDTO boardDTO) {
        Optional<Board> result = boardRepository.findById(boardDTO.getBno());
        //DTO(파라미터)의 bno를 가진 게시물을 찾아서 저장
        Board board = result.orElseThrow();
        board.change(boardDTO.getTitle(), boardDTO.getContent());
        boardRepository.save(board);
    }

    @Override //게시물 삭제
    public void remove(Long bno) {
        boardRepository.deleteById(bno);
    }

    @Override
    public List<BoardDTO> readAll() {

        List<Board> result = boardRepository.findAll();
        List<BoardDTO> dtoList = result.stream()
                .map(board -> modelMapper.map(board,BoardDTO.class)).collect(Collectors.toList());

        return dtoList;
    }
}
