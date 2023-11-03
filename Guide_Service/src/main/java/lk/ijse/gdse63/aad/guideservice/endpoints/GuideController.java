package lk.ijse.gdse63.aad.guideservice.endpoints;

import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.guideservice.response.Response;
import lk.ijse.gdse63.aad.guideservice.service.custom.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


@CrossOrigin
@RestController
@RequestMapping("api/v1/guide")
public class GuideController {

    @Autowired
    private GuideService guideService;

    @PostMapping(path = "Gsave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveGuide(@RequestBody GuideDTO guideDto){
        System.out.println("Guide save controller"+guideDto.toString());
        return guideService.save(guideDto);

    }

    @GetMapping(path = "Gget",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(  @RequestParam("guideID") String guideID){
        System.out.println("Guide search"+guideID);
        return guideService.search(guideID);
    }

    @PutMapping(path = "Gput",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update( @RequestBody GuideDTO guideDto){
        System.out.println("update guide"+guideDto.toString());
        return guideService.update(guideDto);
    }

    @DeleteMapping(path = "Gdelete",params = "guideID",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@RequestParam("guideID") String guideID){
        System.out.println("Guide delete ok"+guideID);
        return guideService.delete(guideID);
    }

    @GetMapping(path = "/getGuideByGuideName",params = "guideName",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>getGuideByName(@RequestParam("guideName")String guideName){
        return guideService.findByGuideName(guideName);


    }
}

