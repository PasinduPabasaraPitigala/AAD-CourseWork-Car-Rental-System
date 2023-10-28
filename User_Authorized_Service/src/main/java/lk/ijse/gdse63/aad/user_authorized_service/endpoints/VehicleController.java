package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.VehicleDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.VehicleControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vehicle")
@CrossOrigin
public class VehicleController {
    @Autowired
    private VehicleControllerInterface  vehicleControllerInterface;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody   VehicleDTO vehicleDTO) {
        return  vehicleControllerInterface.addVehicle(vehicleDTO);

    }
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody   VehicleDTO vehicleDTO) {
        return  vehicleControllerInterface.updateVehicle(vehicleDTO);

    }
    @GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE,params = "vehicleID")
    public ResponseEntity<Response>getVehicle(@RequestParam("vehicleID")String vehicleID){
        return  vehicleControllerInterface.searchVehicle(vehicleID);

    }

    @DeleteMapping(path = "/delete",produces = MediaType.APPLICATION_JSON_VALUE,params = "vehicleID")
    public ResponseEntity<Response>deleteVehicle(@RequestParam("vehicleID")String vehicleID){
        return  vehicleControllerInterface.deleteVehicle(vehicleID);

    }
    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAll(){
        return  vehicleControllerInterface.getAllVehicles();

    }
    @GetMapping(path = "/getVehicleByBrand",params = "vehicleBrand",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getVehicleByBrand(@RequestParam("vehicleBrand")String vehicleBrand){
        return  vehicleControllerInterface.getVehicleByBrand(vehicleBrand);

    }
}