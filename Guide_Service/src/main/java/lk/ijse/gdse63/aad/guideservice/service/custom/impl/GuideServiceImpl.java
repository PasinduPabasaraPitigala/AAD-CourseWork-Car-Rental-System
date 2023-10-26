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
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> search(String id) {
        Optional<Guide>guideEntity=guideRepo.findById(id);
        if (guideEntity.isPresent()){
            return createAndSendResponse(HttpStatus.FOUND.value(),"Success service",modelMapper.map(guideEntity.get(),GuideDTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_EXTENDED.value(), "Error",null);
    }

    @Override
    public ResponseEntity<Response> save(GuideDTO guideDto) {
        if (search(guideDto.getGuideID()).getBody().getData()==null){
            guideRepo.save(modelMapper.map(guideDto,Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(),"Success", null);
        }
        throw new RuntimeException(" no save guide");
    }

    @Override
    public ResponseEntity<Response> update(GuideDTO guideDto) {
        if (search(guideDto.getGuideID()).getBody().getData()!=null){
            guideRepo.save(modelMapper.map(guideDto,Guide.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Success",null);
        }
        throw new RuntimeException("No update found guide");
    }

    @Override
    public ResponseEntity<Response> findByGuideName(String guideName) {
        Optional<Guide> guideEntity = guideRepo.findByGuideName(guideName);
        if (guideEntity.isPresent()) {
            return createAndSendResponse(HttpStatus.OK.value(), "Hotel Successfully retrieved!", modelMapper.map(guideEntity.get(), GuideDTO.class));

        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Hotel Not Found!", null);
    }


    @Override
    public ResponseEntity<Response> delete(String id) {
        if (search(id).getBody().getData()!=null){
            guideRepo.deleteById(id);
            return createAndSendResponse(HttpStatus.OK.value(),"Sucess delete guide",null);
        }
        throw new RuntimeException("no delete in guide");
    }

    @Override
    public ResponseEntity<Response> getAll() {
        List<Guide>guideEntities=guideRepo.findAll();
        if (guideEntities.isEmpty()){
            ArrayList<GuideDTO>arrayList=new ArrayList<>();
            guideEntities.forEach(guideEntity -> {
                arrayList.add(modelMapper.map(guideEntity,GuideDTO.class));
            });
            return createAndSendResponse(HttpStatus.OK.value(), "Find all Success",null);
        }
        throw new RuntimeException("Find guide all error");
    }

    @Override
    public ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(msg);
        response.setData(data);
        System.out.println("Status Code : " + statusCode);
        System.out.println("Sent : " + HttpStatus.valueOf(statusCode));

        return new ResponseEntity<Response>(response, HttpStatusCode.valueOf(statusCode));

    }

}
