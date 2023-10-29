package lk.ijse.gdse63.aad.vehicleservice.service.custom;


import lk.ijse.gdse63.aad.vehicleservice.dto.Vehicle_dto;
import lk.ijse.gdse63.aad.vehicleservice.res.Response;
import lk.ijse.gdse63.aad.vehicleservice.service.SuperService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface VehicleService  extends SuperService<Vehicle_dto,String> {
    ResponseEntity<Response> deleteAllVehicle(List<String> vehicleIDList);
    ResponseEntity<Response> findByVehicleName(String vehicleName);


}
