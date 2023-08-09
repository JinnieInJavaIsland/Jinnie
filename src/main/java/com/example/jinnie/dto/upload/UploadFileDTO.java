package com.example.jinnie.dto.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/*
파일 업로드를 위한 DTO 클래스
 */

@Data
public class UploadFileDTO {

    private List<MultipartFile> files;
}
