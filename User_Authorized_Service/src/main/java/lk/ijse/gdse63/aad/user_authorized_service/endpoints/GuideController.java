package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import feign.Response;
import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/guide")
@CrossOrigin
public class GuideController {
    @Autowired
    private GuideControllerInterface guideControllerInterface;

    @GetMapping(path = "/demo")
    String getHello(){
        return "lla";
    }

    @PostMapping(path = "/sg",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuideDTO guideDTO){
        return  guideControllerInterface.saveGuide(guideDTO);
    }

    @PutMapping(path = "/updateGuide", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuideDTO guideDTO) {
        return guideControllerInterface.update(guideDTO);
    }

    @GetMapping(path = "/searchGuide", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId) {
        return guideControllerInterface.search(guideId);
    }

    @DeleteMapping(path = "/deleteGuide", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId) {
        return guideControllerInterface.delete(guideId);
    }

    @GetMapping(path = "/fetchAllGuides", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return guideControllerInterface.getAll();
    }

}
