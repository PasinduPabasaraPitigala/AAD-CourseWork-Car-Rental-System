package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.HotelDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelControllerInterface {

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveHotel(@RequestBody HotelDTO hotelDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody HotelDTO hotelDTO);

    @GetMapping(path = "/search", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("hotelId") String hotelId);

    @DeleteMapping(path = "/delete", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("hotelId") String hotelId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
