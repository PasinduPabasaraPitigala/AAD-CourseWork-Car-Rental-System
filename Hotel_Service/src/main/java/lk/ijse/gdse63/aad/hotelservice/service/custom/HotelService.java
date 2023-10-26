package lk.ijse.gdse63.aad.hotelservice.service.custom;

import lk.ijse.gdse63.aad.hotelservice.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotelservice.response.Response;
import lk.ijse.gdse63.aad.hotelservice.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService extends SuperService<HotelDTO,String> {
    ResponseEntity<Response> deleteAllHotels(List<String> hotelIDList);
    ResponseEntity<Response> findByHotelName(String hotelName);
}
