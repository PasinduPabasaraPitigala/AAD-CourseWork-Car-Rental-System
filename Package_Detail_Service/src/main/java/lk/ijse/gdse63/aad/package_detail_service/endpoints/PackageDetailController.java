package lk.ijse.gdse63.aad.package_detail_service.endpoints;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;
import lk.ijse.gdse63.aad.package_detail_service.service.custom.PackageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin("http://localhost:8081")
public class PackageDetailController {

/*    @GetMapping(path = "/demo")
    public String getHello(){
        return "Heeeii";
    }*/

    @Autowired
    private PackageDetailService packageDetailService;

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePackageDetail(@RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailService.save(packageDetailDTO);
    }
    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetailDTO packageDetailDTO) {
        return packageDetailService.update(packageDetailDTO);
    }

    @GetMapping(path = "/search", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.search(packageDetailId);
    }

    @DeleteMapping(path = "/delete", params = "hotelId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.delete(packageDetailId);
    }

    @GetMapping(path = "/getPackageDetail")
    public PackageDetailDTO getPackageDetail(@RequestParam("packageDetailId") String packageDetailId) {
        return packageDetailService.getPackageDetail(packageDetailId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return packageDetailService.getAll();
    }
}
