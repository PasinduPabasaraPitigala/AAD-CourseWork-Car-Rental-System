package lk.ijse.gdse63.aad.vehicleservice.endpoints;


import lk.ijse.gdse63.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse63.aad.vehicleservice.response.Response;
import lk.ijse.gdse63.aad.vehicleservice.service.custom.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8081")
public class VehicleController {
    @Autowired
    private Response response;

    @Autowired
    private VehicleService vehicleService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response saveVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.saveVehicle(vehicleDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.update(vehicleDTO);
    }

    @GetMapping(path = "/search", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.search(vehicleId);
    }

    @DeleteMapping(path = "/delete", params = "vehicleId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.delete(vehicleId);
    }

    @GetMapping(path = "/getVehicle")
    public VehicleDTO getVehicle(@RequestParam("vehicleId") String vehicleId) {
        return vehicleService.getVehicle(vehicleId);
    }

    @PutMapping( value = "/getVehicleIds")
    public Response getVehicleIds(@RequestBody List<String> VehicleIds){
        return vehicleService.deleteVehicles(VehicleIds);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return vehicleService.getAll();
    }
}
