package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/packagedetail")
@CrossOrigin
public class PackageDetailController {
    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;
    @GetMapping("check")
    public String getCheck(){
        return "Checked OK packageDetails";
    }

    @PostMapping(path = "save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PackageDetailDTO packageDetailsDto){
        return  packageDetailControllerInterface.save(packageDetailsDto);
    }

    @PutMapping(path = "put",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetailDTO packageDetailsDto){
        return  packageDetailControllerInterface.update(packageDetailsDto);
    }


    @DeleteMapping(path = "delete",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PkID") String PkID){
        return   packageDetailControllerInterface.delete(PkID);
    }

    @GetMapping(path = "get",params = "PkID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PkID")String PkID){
        return   packageDetailControllerInterface.search(PkID);
    }

}