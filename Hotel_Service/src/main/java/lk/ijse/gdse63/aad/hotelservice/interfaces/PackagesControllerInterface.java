package lk.ijse.gdse63.aad.hotelservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackagesControllerInterface {
    @PutMapping( value = "/getHotelId",params = {"hotelID","packageID"})
    public void getHotelIds(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid);

    @PutMapping( value = "/getHotelIdsForDelete",params = {"hotelID","packageID"})
    public void getHotelIdsForDeleteHotel(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid);
}
