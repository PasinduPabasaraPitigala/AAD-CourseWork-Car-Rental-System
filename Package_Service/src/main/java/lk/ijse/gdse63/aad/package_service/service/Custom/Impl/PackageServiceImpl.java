package lk.ijse.gdse63.aad.package_service.service.Custom.Impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.entity.Package;
import lk.ijse.gdse63.aad.package_service.interfaces.PackageServiceInterface;
import lk.ijse.gdse63.aad.package_service.repo.PackageRepo;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.Custom.PackageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PackageServiceImpl implements PackageService {
    @Autowired
    private PackageRepo packageRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Response response;



    //Rest templet for communication other servers
    //Fientclient , Service Discovery we use

    @Autowired
    private PackageServiceInterface packageServiceInterface;






    //-------------------------------------------------------



    @Override
    public ResponseEntity<Response> search(String id) {
        Optional<Package>packageEntity=packageRepo.findById(id);
        if (packageEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value() ,"success",modelMapper.map(packageEntity.get(),PackageDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(),"eorr",null);
    }

    @Override
    public ResponseEntity<Response> save(PackageDTO packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData()==null){
            packageRepo.save(modelMapper.map(packageDto,Package.class));
            return createAndSendResponse(HttpStatus.OK.value(),null,"Save OK");
        }
        throw new RuntimeException("Package not exits");
    }

    @Override
    public ResponseEntity<Response>  update(PackageDTO packageDto) {
        if (search(packageDto.getPackage_id()).getBody().getData() !=null){
            packageRepo.save(modelMapper.map(packageDto,Package.class));
            return createAndSendResponse(HttpStatus.OK.value(), null,"Update OK!");
        }
        throw new RuntimeException("No found!");

    }

    @Override
    public ResponseEntity<Response>  delete(String id) {
        if (search(id).getBody().getData()!=null){
            packageRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(),null,"Delete OK");
        }
        throw new RuntimeException("Not found!");
    }

    @Override
    public ResponseEntity<Response>  getAll() {
        List<Package>packageEntities=packageRepo.findAll();
        if (!packageEntities.isEmpty()){
            ArrayList<PackageDTO> packageDtos=new ArrayList<>();
            packageEntities.forEach(packageEntity -> {
                packageDtos.add(modelMapper.map(packageEntity,PackageDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success", packageDtos);
        }
        throw new RuntimeException("No found all");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));

    }






    // testing
    public ResponseEntity<String> createVehicles(@RequestBody String id) {
        // You should pass the id to your Feign client to retrieve vehicle data
        List<String> vehicles = Collections.singletonList(packageServiceInterface.getAllVehicles(id).getBody());

        Package packageEntity=new Package();
        packageEntity.setVehical_id(Collections.singletonList("V0124445"));
        // Here you can add logic to process the 'vehicles' data
        packageRepo.save(packageEntity);

        // If creation is successful, return a success response
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
}
