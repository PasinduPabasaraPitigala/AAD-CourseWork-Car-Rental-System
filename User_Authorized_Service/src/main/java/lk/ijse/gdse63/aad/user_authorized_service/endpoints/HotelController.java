package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import jakarta.validation.Valid;
import lk.ijse.gdse63.aad.user_authorized_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.HotelControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin
public class HotelController {

    @Autowired
    private HotelControllerInterface hotelControllerInterface;

    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody HotelDTO hotelDto){
        System.out.println("Hotel save working");
        return  hotelControllerInterface.save(hotelDto);
    }

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@Valid @RequestBody HotelDTO hotelDto){
        System.out.println("Hotel update working");
        return  hotelControllerInterface.update(hotelDto);
    }

    @DeleteMapping(path = "H_Delete",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@Valid @RequestParam("H_ID") String H_ID){
        return  hotelControllerInterface.delete(H_ID);
    }

    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@Valid @RequestParam("H_ID") String H_ID){
        return  hotelControllerInterface.search(H_ID);
    }
}
