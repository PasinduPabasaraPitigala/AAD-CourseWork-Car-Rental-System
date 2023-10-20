package lk.ijse.gdse63.aad.package_service.endpoints;

import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.Custom.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8081")
public class PackageController {
/*
    @GetMapping(path = "/demo")
    public String getHello(){
        return "Heeeii";
    }
*/

    @Autowired
    private PackageService packageService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDTO packageDTO){
        return packageService.save(packageDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDTO packageDTO) {
        return packageService.update(packageDTO);
    }

    @GetMapping(path = "/search", params = "packageId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageId") String packageId) {
        return packageService.search(packageId);
    }

    @DeleteMapping(path = "/delete", params = "packageId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageId") String packageId) {
        return packageService.delete(packageId);
    }
    @PutMapping( value = "/getVehicleId",params = {"vehicleID","packageID"})
    public Response getVehicleIds(@RequestParam("vehicleID") String Vehicleid, @RequestParam("packageID") String Packageid){
        return packageService.saveVehicleIds(Vehicleid,Packageid);
    }

    @PutMapping( value = "/getHotelId",params = {"hotelID","packageID"})
    public Response getHotelIds(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid){
        return packageService.saveHotelIds(HotelID,Packageid);
    }

    @GetMapping(path = "/getPackage", params = "packagesId")
    public PackageDTO getPackage(@RequestParam("packagesId") String packagesId) {
        return packageService.getPackage(packagesId);
    }

    @PutMapping( value = "/getHotelIdsForDelete",params = {"hotelID","packageID"})
    public Response getHotelIdsForDeleteHotel(@RequestParam("hotelID") String HotelID, @RequestParam("packageID") String Packageid){
        return packageService.deleteHotelFromPackage(HotelID,Packageid);
    }

    @PutMapping( value = "/getVehicleIdsForDelete",params = {"vehicleID","packageID"})
    public Response getVehicleIdsForDeleteHotel(@RequestParam("vehicleID") String VehicleID, @RequestParam("packageID") String Packageid){
        return packageService.deleteVehicleFromPackage(VehicleID,Packageid);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packageService.getAll();
    }
}
