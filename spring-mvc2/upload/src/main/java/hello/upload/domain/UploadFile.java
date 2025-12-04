package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {
    private String uploadFileName;
    private String storeFileName; //저장소의 이름 (사용자들이 똑같은 이름 설정하더라도 저장소에선 확인할 수 있어야함)

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
