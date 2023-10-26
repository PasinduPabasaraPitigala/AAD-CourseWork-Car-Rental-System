package lk.ijse.gdse63.aad.hotelservice.service;

import lk.ijse.gdse63.aad.hotelservice.dto.SuperDTO;
import lk.ijse.gdse63.aad.hotelservice.response.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SuperService <T extends SuperDTO,ID> {
    ResponseEntity<Response> add(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> search(ID id);

    ResponseEntity<Response> delete(ID id);

    ResponseEntity<Response> getAll();
    ResponseEntity<Response> createAndSendResponse(int statusCode,String msg,Object data);
}
