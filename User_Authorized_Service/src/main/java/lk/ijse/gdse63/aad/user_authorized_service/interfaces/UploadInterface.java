package lk.ijse.gdse63.aad.user_authorized_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("upload-service")
public interface UploadInterface {
    @PostMapping(path = "/upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleUploads(@RequestParam("imageFile") MultipartFile imageFile);
}
