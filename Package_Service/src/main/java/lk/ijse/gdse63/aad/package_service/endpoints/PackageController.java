package lk.ijse.gdse63.aad.package_service.endpoints;

import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.Custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("packageService")
@CrossOrigin(origins = "http://localhost:8080")
public class PackageController {
/*
    @GetMapping(path = "/demo")
    public String getHello(){
        return "Heeeii";
    }
*/

    PackageController(){
        System.out.println("Package controller working on!!!");
    }

    @Autowired
    private PackageService packageService;



    @GetMapping("/check")
    public String getCheck_package(){
        return "Package API Running";
    }

    @PostMapping(path = "/P_save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackageDTO packageDto){
        System.out.println("Package save working");
        return packageService.save(packageDto);
    }

    @PutMapping(path = "/P_put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackageDTO packageDto){
        System.out.println("Package update working");
        return packageService.update(packageDto);
    }

    @DeleteMapping(path = "/P_dlt",params = "P_id",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("P_id") String packageId){
        return packageService.delete(packageId);
    }

    @GetMapping(path = "/P_search",params = "Package_ID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  search(@RequestParam("Package_ID") String packageID){
        return packageService.search(packageID);
    }
}
