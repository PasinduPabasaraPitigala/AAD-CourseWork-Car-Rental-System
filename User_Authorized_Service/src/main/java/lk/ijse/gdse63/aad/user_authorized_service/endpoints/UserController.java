package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.user_authorized_service.service.custom.UserDetailsServicee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserDetailsServicee userDetailsServicee;
    @GetMapping(path = "/getUserByUserName", produces = MediaType.APPLICATION_JSON_VALUE, params = {"username","password"})
    public ResponseEntity<Response> getUserByUserName(@RequestParam("username") String username, @RequestParam("password")String password) {
        return  userDetailsServicee.getUserByUserName(username,password);

    }
}
