package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import feign.Response;
import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserDetailsServicee userDetailsServicee;
/*
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userDetailsServicee.save(userDetailsDTO);
    }*/

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody UserDetailsDTO userDetailsDTO) {
        return userDetailsServicee.update(userDetailsDTO);
    }

    @GetMapping(path = "/search", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("userId") String guideId) {
        return userDetailsServicee.search(guideId);
    }

    @DeleteMapping(path = "/delete", params = "userId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("userId") String guideId) {
        return userDetailsServicee.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return userDetailsServicee.getAll();
    }
}
