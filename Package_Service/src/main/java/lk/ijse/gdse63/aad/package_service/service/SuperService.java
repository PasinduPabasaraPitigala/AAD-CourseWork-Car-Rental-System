package lk.ijse.gdse63.aad.package_service.service;


import lk.ijse.gdse63.aad.package_service.dto.PackageDTO;
import lk.ijse.gdse63.aad.package_service.dto.SuperDTO;
import lk.ijse.gdse63.aad.package_service.response.Response;
import org.springframework.http.ResponseEntity;

public interface SuperService<T extends SuperDTO,ID> {
    ResponseEntity<Response> search(String id);

    ResponseEntity<Response> save(T t);

    ResponseEntity<Response> update(T t);

    ResponseEntity<Response> delete(String id);

    ResponseEntity<Response> getAll();

    ResponseEntity<Response> createAndSendResponse(int statusCode, String msg, Object data);

}
