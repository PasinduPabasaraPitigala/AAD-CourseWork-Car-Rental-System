package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.custom.UserDetailsServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/auth")
@CrossOrigin
public class AuthController {
    @Autowired
    private Response response;

    @Autowired
    private UserDetailsServicee userDetailsServicee;

    @PostMapping(path = "/getAuth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAuth(@RequestBody UserDetailsDTO userDTO) {
        System.out.println(userDTO.toString());
        return  userDetailsServicee.add(userDTO);
    }

    @PostMapping(path = "/uploadImage",params = "userId")
    public ResponseEntity<Response> uploadImage(@RequestParam("imageFile") MultipartFile imageFile, @RequestParam("userId") String userId) {
        ResponseEntity<Response> user =  userDetailsServicee.search(userId);

        UserDetailsDTO userData = (UserDetailsDTO) user.getBody().getData();
        if(userData!=null){
            userData.setUserImageLocation( userDetailsServicee.handleUploads(imageFile));
            return  userDetailsServicee.update(userData);
        }
        throw new RuntimeException("User not found!");




    }
}
