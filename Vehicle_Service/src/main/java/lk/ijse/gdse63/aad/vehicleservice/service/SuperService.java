package lk.ijse.gdse63.aad.vehicleservice.service;

import lk.ijse.gdse63.aad.vehicleservice.dto.SuperDTO;
import lk.ijse.gdse63.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse63.aad.vehicleservice.response.Response;

import java.util.List;

public interface SuperService <T extends SuperDTO,ID>{
    Response saveVehicle(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    VehicleDTO getVehicle(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);

    Response deleteVehicles(List<String> vehicleIds);
}
