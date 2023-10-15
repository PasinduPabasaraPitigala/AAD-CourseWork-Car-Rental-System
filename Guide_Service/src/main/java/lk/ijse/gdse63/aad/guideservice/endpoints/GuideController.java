package lk.ijse.gdse63.aad.guideservice.endpoints;

import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.guideservice.response.Response;
import lk.ijse.gdse63.aad.guideservice.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("")
@CrossOrigin
public class GuideController {
    @GetMapping(path = "/demo")
    public String getHello() {
        return "Hiii";
    }

    @Autowired
    private GuideService guideService;

    @PostMapping(path = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response saveGuide(@RequestBody GuideDTO guideDTO){
        return guideService.save(guideDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody GuideDTO guideDTO) {
        return guideService.update(guideDTO);
    }

    @GetMapping(path = "/search", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("guideId") String guideId) {
        return guideService.search(guideId);
    }

    @DeleteMapping(path = "/delete", params = "guideId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("guideId") String guideId) {
        return guideService.delete(guideId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return guideService.getAll();
    }
}

