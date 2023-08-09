package com.example.jinnie.dto.upload;

/*
여러 개의 파일이 업로드 되면 업로드 결과도 여러 개 발생하게 되고 여러 정보를 반환해야 하므로
별도의 DTO를 구성해서 반환한다.
UploadResultDTO의 getLink()는 나중에 JSON으로 처리될 때 link 라는 속성으로 자동 처리된다.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadResultDTO {

    private String uuid;

    private String fileName;

    private boolean img;

    public String getLink(){
        if(img){
            return "s_" + uuid + "_" + fileName; //이미지인 경우 썸네일
        } else {
            return uuid + "_" + fileName;
        }
    }
}
