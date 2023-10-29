package lk.ijse.gdse63.aad.hotelservice.endpoints;

import lk.ijse.gdse63.aad.hotelservice.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotelservice.interfaces.PackagesControllerInterface;
import lk.ijse.gdse63.aad.hotelservice.response.Response;
import lk.ijse.gdse63.aad.hotelservice.service.custom.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotel")
@CrossOrigin
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private PackagesControllerInterface packagesControllerInterface;



    @PostMapping(path = "h_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody HotelDTO hotelDto){
        System.out.println("Hotel save working");
        return hotelService.add(hotelDto);
    }

    @PutMapping(path = "h_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody HotelDTO hotelDto){
        System.out.println("Hotel update working");
        return hotelService.update(hotelDto);
    }

    @DeleteMapping(path = "H_Delete",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete( @RequestParam("H_ID") String H_ID){
        ResponseEntity<Response> response = search(H_ID);
        HotelDTO hotelDTO = (HotelDTO) response.getBody().getData();
        hotelService.delete(H_ID);
        return packagesControllerInterface.deleteHotelID(hotelDTO.getPackageId(),hotelDTO.getHotelId());
    }
    @GetMapping(path = "/getAllHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAllHotels(){
        return hotelService.getAll();

    }
    @DeleteMapping(path = "/deleteAllHotels",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>deleteAllHotels(@RequestBody List<String> hotelIDs){
        return hotelService.deleteAllHotels(hotelIDs);

    }
    @GetMapping(path = "/getHotelByHotelName",params = "hotelName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getHotelByName(@RequestParam("hotelName")String hotelName){
        return hotelService.findByHotelName(hotelName);


    }
    @GetMapping(path = "H_search",params = "H_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("H_ID") String H_ID){
        return hotelService.search(H_ID);
    }



}
