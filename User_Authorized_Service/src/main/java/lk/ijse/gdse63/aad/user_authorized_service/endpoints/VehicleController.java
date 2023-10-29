package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import jakarta.validation.Valid;
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

    @GetMapping("/check")
    public String getCheck_vehicle(){
        return "Vehicle API run";
    }


    @PostMapping(path = "vSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@Valid @RequestBody  VehicleDTO vehicleDto){
        System.out.println("vehicle save working");
        return  vehicleControllerInterface.save(vehicleDto);
    }

    @PutMapping(path = "/Vput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody  VehicleDTO vehicleDto){
        System.out.println("VehicleDto update working in user");
        System.out.println(vehicleDto.toString());
        return vehicleControllerInterface.update(vehicleDto);
    }


    @DeleteMapping(path = "V_delete",params ="Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete( @RequestParam("Vehicle_ID") String vehicleID){
        return  vehicleControllerInterface.delete(vehicleID);
    }

    @GetMapping(path = "V_search",params = "Vehicle_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search( @RequestParam("Vehicle_ID") String Vehicle_ID){
        return   vehicleControllerInterface.search(Vehicle_ID);
    }

//for package testing

    @PostMapping("/getvehi")
    public ResponseEntity <String> getAllVehicles( @RequestParam String id) {
        // Return the data as a response
        return ResponseEntity.ok(id);
    }


}