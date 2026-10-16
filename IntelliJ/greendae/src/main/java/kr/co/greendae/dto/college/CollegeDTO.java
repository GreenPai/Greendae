package kr.co.greendae.dto.college;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CollegeDTO {

    private String name;       // 대학 이름
    private String engName;    // 대학 영어 이름
    private String title;      // 소개 제목
    private String content;    // 소개 내용
    
    // 이미지를 위한 필드1
    private MultipartFile image;
    private String oName;
    private String sName;

    public boolean isValid() {
        if (name == null || name.isBlank()) return false;
        if (engName == null || engName.isBlank()) return false;
        if (title == null || title.isBlank()) return false;
        if (content == null || content.isBlank()) return false;

        if (image == null || image.isEmpty()){
            log.info("파일에 대한 오류가 발생했습니다.");
            return false;
        }

        return true;
    }

}
