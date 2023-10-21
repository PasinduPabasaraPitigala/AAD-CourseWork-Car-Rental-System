package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.user_authorized_service.model.PackageDetail;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "PACKAGEDETAIL-SERVICE")
public interface PackageDetailControllerInterface {


}
