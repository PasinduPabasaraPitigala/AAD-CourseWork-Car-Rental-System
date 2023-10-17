package lk.ijse.gdse63.aad.package_detail_service.service.custom;

import lk.ijse.gdse63.aad.package_detail_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.package_detail_service.response.Response;
import lk.ijse.gdse63.aad.package_detail_service.service.SuperService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

public interface PackageDetailService extends SuperService<PackageDetailDTO, String> {


}
