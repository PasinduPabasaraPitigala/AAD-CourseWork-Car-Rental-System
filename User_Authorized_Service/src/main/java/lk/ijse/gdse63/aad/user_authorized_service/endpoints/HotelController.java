package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


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

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveHotel(@RequestBody   HotelDTO hotelDTO){
        System.out.println("hotelDTO"+hotelDTO.toString());
        return  hotelControllerInterface.saveHotel(hotelDTO);

    }
    @PutMapping(path = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>updateHotel(@RequestBody HotelDTO hotelDTO){
        return  hotelControllerInterface.updateHotel(hotelDTO);

    }
    @GetMapping(path = "/search",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>searchHotel(@RequestParam("hotelID")String hotelID ){
        return  hotelControllerInterface.searchHotel(hotelID);

    }
    @DeleteMapping(path = "/delete",params = "hotelID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteHotel(@RequestParam("hotelID")String hotelID ){
        return  hotelControllerInterface.deleteHotel(hotelID);

    }
    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>searchHotel(){
        return  hotelControllerInterface.getAllHotels();

    }
    @GetMapping(path = "/getHotelByName",params = "hotelName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getHotelByNName(@RequestParam("hotelName") String hotelName) {
        return hotelControllerInterface.getHotelByName(hotelName);
    }
}
