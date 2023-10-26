package lk.ijse.gdse63.aad.guideservice.service;

import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lk.ijse.gdse63.aad.guideservice.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends GuideDTO,ID>{
    ResponseEntity<Response> search(String id);

    ResponseEntity <Response>save(T t);

    ResponseEntity <Response> update(T t);

    ResponseEntity<Response> findByGuideName(String guideName);

    ResponseEntity <Response> delete(String id);

    ResponseEntity <Response>getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);
}
