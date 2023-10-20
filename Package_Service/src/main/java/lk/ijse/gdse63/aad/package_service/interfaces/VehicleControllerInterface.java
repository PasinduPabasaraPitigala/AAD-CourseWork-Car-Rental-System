package lk.ijse.gdse63.aad.package_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleControllerInterface {
    @PutMapping( value = "/getVehicleIds")
    public void getVehicleIds(@RequestBody List<String> VehicleIds);
}
