package com.example.jinnie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/*
    댓글을 위한 DTO
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReplyDTO {
    private Long rno; //댓글 고유 번호

    @NotNull
    private Long bno;  //댓글이 달릴 게시물의 고유번호

    @NotEmpty
    private String replyText; // 댓글 내용

    @NotEmpty
    private String replyer; //댓글 작성자

    private LocalDateTime regDate, modDate; //작성시각, 수정시각
}
