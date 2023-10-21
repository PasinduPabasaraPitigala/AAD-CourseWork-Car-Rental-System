package lk.ijse.gdse63.aad.package_detail_service.interfaces;

import lk.ijse.gdse63.aad.package_detail_service.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelControllerInterface {
    @GetMapping(path = "/getHotel")
    public HotelDTO getHotel(@RequestParam("hotelId") String hotelId);
}