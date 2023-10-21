package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PackagesDTO;
import lk.ijse.gdse63.aad.user_authorized_service.model.Packages;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackagesControllerInterface {
    @PostMapping(path = "/savePackage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> save(@RequestBody PackagesDTO packagesDTO);
    @PutMapping(path = "/updatePackage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> update(@RequestBody PackagesDTO packagesDTO);
    @GetMapping(path = "/searchPackage", produces = MediaType.APPLICATION_JSON_VALUE, params = "packageID")
    public ResponseEntity<Response> search(@RequestParam("packageID") String packageID);
    @DeleteMapping(path = "/deletePackage", produces = MediaType.APPLICATION_JSON_VALUE, params = "packageID")
    public ResponseEntity<Response> delete(@RequestParam("packageID") String packageID);
    @GetMapping(path = "/getAllPackages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllPackages();
    @GetMapping(path = "/getAllPackageIDs")
    public List<String> getAllPackageIDs();

    @GetMapping(path = "/getPackageByCategory",produces = MediaType.APPLICATION_JSON_VALUE,params = "category")
    public ResponseEntity<Response>getPackageByCategory(@RequestParam("category")String category) ;
}
