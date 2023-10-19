package lk.ijse.gdse63.aad.vehicleservice.service.custom.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.vehicleservice.dto.VehicleDTO;
import lk.ijse.gdse63.aad.vehicleservice.entity.Vehicle;
import lk.ijse.gdse63.aad.vehicleservice.interfaces.PackagesControllerInterface;
import lk.ijse.gdse63.aad.vehicleservice.repo.VehicleRepo;
import lk.ijse.gdse63.aad.vehicleservice.response.Response;
import lk.ijse.gdse63.aad.vehicleservice.service.custom.VehicleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private PackagesControllerInterface packagesControllerInterface;


    @Override
    public Response saveVehicle(VehicleDTO vehicleDTO) {
        if (search(vehicleDTO.getVehicleID()).getData() == null) {
            packagesControllerInterface.getVehicleIds(vehicleDTO.getVehicleID(),vehicleDTO.getPackageId());

            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully saved!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");

    }

    @Override
    public Response update(VehicleDTO vehicleDTO) {
        if (search(vehicleDTO.getVehicleID()).getData() != null) {
            vehicleRepo.save(modelMapper.map(vehicleDTO, Vehicle.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully updated!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            Optional<Vehicle> vehicle = vehicleRepo.findById(s);
            packagesControllerInterface.getVehicleIdsForDeleteHotel(vehicle.get().getVehicleID(),vehicle.get().getPackageId());

            vehicleRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle Successfully deleted!", null);
        }
        throw new RuntimeException("Vehicle does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Vehicle> vehicle = vehicleRepo.findById(s);
        if (vehicle.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "vehicle Successfully retrieved!", modelMapper.map(vehicle.get(), VehicleDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "vehicle does not exists!", null);
    }

    @Override
    public VehicleDTO getVehicle(String s) {
        Optional<Vehicle> vehicle= vehicleRepo.findById(s);

        if (vehicle.isPresent()) {
            System.out.println(vehicle.get());
            return modelMapper.map(vehicle.get(), VehicleDTO.class);
        }
        throw new RuntimeException("vehicle cannot found!!!");
    }


    @Override
    public Response getAll() {
        List<Vehicle> vehicles = vehicleRepo.findAll();
        if (!vehicles.isEmpty()) {
            ArrayList<VehicleDTO> vehicles_dtos = new ArrayList<>();
            vehicles.forEach((vehicless) -> {
                vehicles_dtos.add(modelMapper.map(vehicless, VehicleDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Vehicles Successfully retrieved!", vehicles_dtos);
        }
        throw new RuntimeException("No Vehicles found in the database!");
    }

    @Override
    public Response deleteVehicles(List<String> vehicleIds) {
        System.out.println(vehicleIds);
        for (String vehicleId : vehicleIds) {
            vehicleRepo.deleteById(vehicleId);
            return createAndSendResponse(HttpStatus.OK.value(), "Vehicle"+vehicleId+" deleted!", null);
        }
        return createAndSendResponse(HttpStatus.OK.value(), "ooppsss!", null);
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }




}
