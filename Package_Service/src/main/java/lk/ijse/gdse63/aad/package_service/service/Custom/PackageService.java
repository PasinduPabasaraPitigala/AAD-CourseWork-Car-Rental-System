package lk.ijse.gdse63.aad.package_service.service.Custom;

import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;
import lk.ijse.gdse63.aad.package_service.service.SuperService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

public interface PackageService extends SuperService<PackageDTO,String> {

}
