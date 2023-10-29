package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PackagesDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackagesControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/packages")
@CrossOrigin
public class PackagesController {
    @Autowired
    private PackagesControllerInterface packagesControllerInterface;


    @GetMapping("/check")
    public String getCheck_package(){
        return "Package API Running";
    }

    @PostMapping(path = "/P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackagesDTO packageDto){
        System.out.println("Package save working");
        return   packagesControllerInterface.save(packageDto);
    }

    @PutMapping(path = "/P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody  PackagesDTO packageDto){
        System.out.println("Package update working");
        return   packagesControllerInterface.update(packageDto);
    }

    @DeleteMapping(path = "/P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("P_id") String packageId){
        return   packagesControllerInterface.delete(packageId);
    }

    @GetMapping(path = "/P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response  search(@RequestParam("Package_ID") String packageID){
        return  packagesControllerInterface.search(packageID);
    }

}