package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PackageDetailControllerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/packagedetail")
@CrossOrigin
public class PackageDetailController {
    @Autowired
    private PackageDetailControllerInterface packageDetailControllerInterface;


}