package lk.ijse.gdse63.aad.user_authorized_service.endpoints;



import lk.ijse.gdse63.aad.user_authorized_service.dto.GuideDTO;
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


    @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody GuideDTO guideDto){
        System.out.println("Guide save"+guideDto.toString());
        return  guideControllerInterface.saveGuide(guideDto);

    }

    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response get(@RequestParam("guideID") String guideID){
        System.out.println("Guide search"+guideID);
        return  guideControllerInterface.get(guideID);
    }

    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(  @RequestBody GuideDTO guideDto){
        System.out.println("update guide"+guideDto.toString());
        return  guideControllerInterface.saveGuide(guideDto);
    }

    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(   @RequestParam("guideID") String guideID) {
        System.out.println("Guide delete ok" + guideID);
        return guideControllerInterface.delete(guideID);
    }

}
