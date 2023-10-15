package lk.ijse.gdse63.aad.guideservice.service.custom.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.guideservice.entity.Guide;
import lk.ijse.gdse63.aad.guideservice.repo.GuideRepo;
import lk.ijse.gdse63.aad.guideservice.response.Response;
import lk.ijse.gdse63.aad.guideservice.service.custom.GuideService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuideServiceImpl implements GuideService {
    @Autowired
    private Response response;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private GuideRepo guideRepo;

    @Override
    @PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(GuideDTO guideDTO) {
        if (search(guideDTO.getGuideId()).getData() == null) {
            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully saved!", null);
        }
        throw new RuntimeException("Guide already exists!");
    }

    @Override
    public Response update(GuideDTO guideDTO) {
        if (search(guideDTO.getGuideId()).getData() != null) {
            guideRepo.save(modelMapper.map(guideDTO, Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully updated!", null);
        }
        throw new RuntimeException("Guide does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            guideRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Guide Successfully deleted!", null);
        }
        throw new RuntimeException("Guide does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<Guide> guide = guideRepo.findById(s);
        if (guide.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guide Successfully retrieved!", modelMapper.map(guide.get(), GuideDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Guide does not exists!", null);
    }

    @Override
    public Response getAll() {
        List<Guide> guides = guideRepo.findAll();
        if (!guides.isEmpty()) {
            ArrayList<GuideDTO> guides_dtos = new ArrayList<>();
            guides.forEach((guidess) -> {
                guides_dtos.add(modelMapper.map(guidess, GuideDTO.class));
            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Guides Successfully retrieved!", guides_dtos);
        }
        throw new RuntimeException("No Guides found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
