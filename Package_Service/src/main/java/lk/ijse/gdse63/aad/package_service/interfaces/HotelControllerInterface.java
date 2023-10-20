package lk.ijse.gdse63.aad.package_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelControllerInterface {
    @PutMapping( value = "/getHotelIds")
    public void getHotelIds(@RequestBody List<String> HotelIds);
}

