package lk.ijse.gdse63.aad.package_detail_service.interfaces;

import lk.ijse.gdse63.aad.vehicleservice.dto.VehicleDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleControllerInterface {
    @GetMapping(path = "/getVehicle")
    public VehicleDTO getVehicle(@RequestParam("vehicleId") String vehicleId);
}
