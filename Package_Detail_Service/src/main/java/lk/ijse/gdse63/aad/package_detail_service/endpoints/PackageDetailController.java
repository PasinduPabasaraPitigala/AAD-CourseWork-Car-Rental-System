package lk.ijse.gdse63.aad.package_detail_service.endpoints;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;
import lk.ijse.gdse63.aad.package_detail_service.service.custom.PackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/packageDetails")
@CrossOrigin(origins = "http://localhost:8090")
public class PackageDetailController {
    @Autowired
    private PackageDetailService packageDetailsService;


    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackageDetailDTO packageDetailsDto){
        return packageDetailsService.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackageDetailDTO packageDetailsDto){
        return packageDetailsService.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> delete(@RequestParam("PkID") String PkID){
        return packageDetailsService.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> search(@RequestParam("PkID")String PkID){
        return packageDetailsService.search(PkID);
    }
}
