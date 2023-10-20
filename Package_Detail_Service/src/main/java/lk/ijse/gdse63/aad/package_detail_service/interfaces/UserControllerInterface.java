package lk.ijse.gdse63.aad.package_detail_service.interfaces;

import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "USER-AUTH-SERVICE")
public interface UserControllerInterface {
    @GetMapping(path = "/getUserDetail")
    public UserDetailsDTO getUserDetail(@RequestParam("userDetailId") String userDetailId);
}