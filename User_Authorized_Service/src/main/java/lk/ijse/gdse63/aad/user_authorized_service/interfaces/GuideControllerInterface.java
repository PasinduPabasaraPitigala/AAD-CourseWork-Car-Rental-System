package lk.ijse.gdse63.aad.user_authorized_service.interfaces;


import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "GUIDE-SERVICE")
public interface GuideControllerInterface {
    @PostMapping(path = "/saveGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveGuide(@RequestBody GuideDTO guideDTO);
    @PutMapping(path = "/updateGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateGuide(@RequestBody GuideDTO guideDTO);
    @GetMapping(path = "/getGuide",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getGuide(@RequestParam("guideID")String guideID);
    @DeleteMapping(path = "/deleteGuide",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteGuide(@RequestParam("guideID")String guideID);
    @GetMapping(path = "/getAllGuides",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllGuides();
    @GetMapping(path = "/getGuideByGuideName",produces = MediaType.APPLICATION_JSON_VALUE,params="guideName")
    public ResponseEntity<Response> getGuideBuGuideName(@RequestParam("guideName")String guideName);

}
