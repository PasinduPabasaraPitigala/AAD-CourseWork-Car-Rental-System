package lk.ijse.gdse63.aad.user_authorized_service.interfaces;

import feign.Response;
import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "GUIDE-SERVICE")
public interface GuideControllerInterface {
    @GetMapping(path = "/demo")
    String getHello();

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuideDTO guideDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuideDTO guideDTO);

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId);

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();

}
