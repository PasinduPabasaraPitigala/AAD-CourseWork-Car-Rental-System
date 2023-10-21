package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.dto.PackageDetailDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.PackageDetail;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/packagedetail")
@CrossOrigin
public class PackageDetailController {
    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;


}