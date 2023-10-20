package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import lk.ijse.gdse63.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse63.aad.vehicleservice.entity.Vehicle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "VEHICLE-SERVICE")
public interface VehicleControllerInterface {
    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveVehicle(@RequestBody VehicleDTO vehicleDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody VehicleDTO vehicleDTO);

    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("vehicleId") String vehicleId);

    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("vehicleId") String vehicleId);

    @GetMapping(path = "/getPackage", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Vehicle> getVehicle(@RequestParam("vehicleId") String vehicleId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
