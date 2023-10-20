package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.user_authorized_service.model.PackageDetail;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "PACKAGEDETAIL-SERVICE")
public interface PackageDetailControllerInterface {

    @PostMapping(path = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePackageDetail(@RequestBody PackageDetailDTO packageDetailDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PackageDetailDTO packageDetailDTO) ;

    @GetMapping(path = "/search", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("packageDetailId") String packageDetailId);

    @DeleteMapping(path = "/delete", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("packageDetailId") String packageDetailId);

    @GetMapping(path = "/getPackageDetail", params = "packageDetailId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<PackageDetail> getPackageDetail(@RequestParam("packageDetailId") String packageDetailId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
