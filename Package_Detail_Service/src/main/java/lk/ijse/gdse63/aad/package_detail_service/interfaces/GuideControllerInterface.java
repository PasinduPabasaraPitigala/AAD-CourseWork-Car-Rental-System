package lk.ijse.gdse63.aad.package_detail_service.interfaces;

import lk.ijse.gdse63.aad.package_detail_service.dto.GuideDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "GUIDE-SERVICE")
public interface GuideControllerInterface {
    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public GuideDTO getGuideDTO(@RequestParam("guideId") String guideId);
}
