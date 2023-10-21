package lk.ijse.gdse63.aad.user_authorized_service.service.custom;

import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.SuperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface UserDetailsServicee extends SuperService<UserDetailsDTO,String> {
    ResponseEntity<Response> createAndSendResponse(int statusCode, String message, Object data);
    String  handleUploads(MultipartFile imageFile);
    ResponseEntity<Response>getUserByUserName(String username,String password);
    Boolean passwordValidator(String password,String hashedPassword);
}

