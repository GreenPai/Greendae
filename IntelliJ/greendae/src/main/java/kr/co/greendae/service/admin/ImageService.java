package kr.co.greendae.service.admin;

import kr.co.greendae.dto.college.CollegeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class ImageService {


    @Value("${spring.servlet.multipart.location}")
    private String uploadDir;

    // 이미지 등록
    public CollegeDTO uploadImage(CollegeDTO collageDTO) {

        java.io.File fileUploadDir = new java.io.File(uploadDir);

        if (!fileUploadDir.exists()) {
            // 파일 업로드 디렉터리가 존재하지 않으면 생성
            fileUploadDir.mkdirs();
        }

        // 파일 업로드 디렉터리 시스템 경로 구하기
        String fileUploadPath = fileUploadDir.getAbsolutePath();

        MultipartFile multipartFile = collageDTO.getImage();

        if (!multipartFile.isEmpty()) {
            String oName = multipartFile.getOriginalFilename();
            String ext = oName.substring(oName.lastIndexOf("."));
            String sName = UUID.randomUUID().toString() + ext;

            // 파일 저장
            try {
                multipartFile.transferTo(new java.io.File(fileUploadPath, sName));
            } catch (IOException e) {
                log.error(e.getMessage());
            }

            collageDTO.setOName(oName);
            collageDTO.setSName(sName);

        }

        return collageDTO;

    }

}
