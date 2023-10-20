package lk.ijse.gdse63.aad.package_service.service.Custom.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.entity.Package;
import lk.ijse.gdse63.aad.package_service.interfaces.HotelControllerInterface;
import lk.ijse.gdse63.aad.package_service.interfaces.VehicleControllerInterface;
import lk.ijse.gdse63.aad.package_service.repo.PackageRepo;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.Custom.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PackageRepo packageRepo;

    private List<String> vehicleList;

    private List<String> hotelList;

    @Autowired
    private VehicleControllerInterface vehicleControllerInterface;

    @Autowired
    private HotelControllerInterface hotelControllerInterface;


    @Override
    public Response save(PackageDTO packageDTO) {
        if (search(packageDTO.getPackageId()).getData() == null) {
            packageRepo.save(modelMapper.map(packageDTO, Package.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully saved!", null);
        }
        throw new RuntimeException("Package does not exists!");

    }

    @Override
    public Response update(PackageDTO packageDTO) {
        if (search(packageDTO.getPackageId()).getData() != null) {
            packageRepo.save(modelMapper.map(packageDTO, Package.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully updated!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response delete(String id) {
        if (search(id).getData() != null) {
            System.out.println(search(id).getData());

            Optional<Package> packages = packageRepo.findById(id);
            System.out.println(packages.get());

//            Packages packages = modelMapper.map(search(s).getData(), Packages.class);
//            System.out.println(packages);
            vehicleControllerInterface.getVehicleIds(packages.get().getVehicleList());
            hotelControllerInterface.getHotelIds(packages.get().getHotelsList());

            packageRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(), "Package Successfully deleted!", null);
        }
        throw new RuntimeException("Package does not exists!");
    }

    @Override
    public Response search(String id) {
        Optional<Package> packages = packageRepo.findById(id);
        if (packages.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Package Successfully retrieved!", modelMapper.map(packages.get(), PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Package does not exists!", null);
    }

    @Override
    public PackageDTO getPackage(String id) {
        Optional<Package> packages = packageRepo.findById(id);

        if (packages.isPresent()) {
            System.out.println(packages.get());
            return modelMapper.map(packages.get(), PackageDTO.class);
        }
        throw new RuntimeException("package cannot found!!!");
    }

    @Override
    public Response saveVehicleIds(String Vehicleid, String Packageid) {
        System.out.println("ygutfytfyrdtry");
        Optional<Package> packages = packageRepo.findById(Packageid);
        if(packages.isPresent()){
            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
            packages.get().getVehicleList().add(Vehicleid);
            System.out.println(packages);
            System.out.println(packages.get().getVehicleList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("Package is not found!");
    }

    @Override
    public Response saveHotelIds(String Hotelid, String Packageid) {
        System.out.println("ygutfytfyrdtry");
        Optional<Package> packages = packageRepo.findById(Packageid);
        if(packages.isPresent()){
            System.out.println("yguuuuuuuuuuuuuuuuuuuuuuuuy");
            packages.get().getHotelsList().add(Hotelid);
            System.out.println(packages.get());
            System.out.println(packages.get().getHotelsList());
            return createAndSendResponse(HttpStatus.FOUND.value(), "Success!(", null);
        }
        throw new RuntimeException("Package is not found!");
    }

    @Override
    public Response getAll() {
        List<Package> packages = packageRepo.findAll();
        if (!packages.isEmpty()) {
            ArrayList<PackageDTO> packages_dtos = new ArrayList<>();
            packages.forEach((packagess) -> {
                packages_dtos.add(modelMapper.map(packagess, PackageDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Packages Successfully retrieved!", packages_dtos);
        }
        throw new RuntimeException("No Packages found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }

    @Override
    public Response deleteHotelFromPackage(String hotelID, String packageid) {
        Optional<Package> packages = packageRepo.findById(packageid);
        boolean remove = packages.get().getHotelsList().remove(hotelID);
        System.out.println(remove);
        if (remove == true){
            return createAndSendResponse(HttpStatus.FOUND.value(), "Successfully removed HotelId!", null);
        }
        return createAndSendResponse(HttpStatus.FOUND.value(), "cannot remove HotelId!;(", null);
    }

    @Override
    public Response deleteVehicleFromPackage(String vehicleID, String packageid) {
        Optional<Package> packages = packageRepo.findById(packageid);
        boolean remove = packages.get().getVehicleList().remove(vehicleID);
        System.out.println(remove);
        if (remove == true){
            return createAndSendResponse(HttpStatus.FOUND.value(), "Successfully removed VehicleId!", null);
        }
        return createAndSendResponse(HttpStatus.FOUND.value(), "cannot remove VehicleId!;(", null);
    }
}
