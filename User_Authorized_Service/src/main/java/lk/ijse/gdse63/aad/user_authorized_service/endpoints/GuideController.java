package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.GuideControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin
public class GuideController {
    @Autowired
    private GuideControllerInterface guideControllerInterface;


    @PostMapping(path = "/saveGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> saveGuide(@RequestBody  GuideDTO guideDTO){
        return  guideControllerInterface.saveGuide(guideDTO);
    }
    @PutMapping(path = "/updateGuide",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateGuide(@RequestBody  GuideDTO guideDTO){
        return  guideControllerInterface.updateGuide(guideDTO);
    }
    @GetMapping(path = "/getGuide",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getGuide(@RequestParam("guideID")String guideID){
        return  guideControllerInterface.getGuide(guideID);
    }
    @DeleteMapping(path = "/deleteGuide",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> deleteGuide(@RequestParam("guideID")String guideID){
        return  guideControllerInterface.deleteGuide(guideID);
    }
    @GetMapping(path = "/getAllGuides",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getAllGuides(){
        return  guideControllerInterface.getAllGuides();
    }
    @GetMapping(path = "/getByName",produces = MediaType.APPLICATION_JSON_VALUE,params="guideName")
    public ResponseEntity<Response> getGuideBuGuideName(@RequestParam("guideName")String guideName){
        System.out.println("Guide Name : "+guideName);
        return  guideControllerInterface.getGuideBuGuideName(guideName);
    }

}
