package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PackagesDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackagesControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.Packages;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packages")
@CrossOrigin
public class PackagesController {
    @Autowired
    private PackagesControllerInterface packagesControllerInterface;

    @PostMapping(path = "/save",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>add(@RequestBody PackagesDTO packagesDTO){
        return  packagesControllerInterface.save(packagesDTO);

    }
    @PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>update(@RequestBody PackagesDTO packagesDTO){
        return packagesControllerInterface.update(packagesDTO);

    }
    @GetMapping(path = "/search",produces = MediaType.APPLICATION_JSON_VALUE,params = "packageID")
    public ResponseEntity<Response>search(@RequestParam("packageID")String packageID){
        return packagesControllerInterface.search(packageID);

    }
    @DeleteMapping(path = "/delete",produces = MediaType.APPLICATION_JSON_VALUE,params = "packageID")
    public ResponseEntity<Response>delete(@RequestParam("packageID")String packageID){
        System.out.println("packageID = " + packageID);
        return packagesControllerInterface.delete(packageID);

    }
    @GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getAll(){
        return  packagesControllerInterface.getAllPackages();

    }
    @GetMapping(path = "/getAllIDs")
    public List<String>getAllPackageIDs(){
        return packagesControllerInterface.getAllPackageIDs();
    }
    @GetMapping(path = "/getPackageByCategory",produces = MediaType.APPLICATION_JSON_VALUE,params = "category")
    public ResponseEntity<Response>getPackageByCategory(@RequestParam("category")String category){
        return  packagesControllerInterface.getPackageByCategory(category);

    }
}