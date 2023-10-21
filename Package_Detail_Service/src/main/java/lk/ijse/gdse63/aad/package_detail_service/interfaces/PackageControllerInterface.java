package lk.ijse.gdse63.aad.package_detail_service.interfaces;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackagesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "PACKAGE-SERVICE")
public interface PackageControllerInterface {
    @GetMapping(path = "/getPackage", params = "packagesId")
    public PackagesDTO getPackage(@RequestParam("packagesId") String packagesId);
}
