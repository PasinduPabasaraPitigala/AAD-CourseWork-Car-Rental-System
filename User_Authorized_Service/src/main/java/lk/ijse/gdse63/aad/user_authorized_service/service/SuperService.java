package lk.ijse.gdse63.aad.user_authorized_service.service;

import feign.Response;
import lk.ijse.gdse63.aad.user_authorized_service.dto.UserDetailsDTO;

public interface SuperService<T extends UserDetailsDTO,ID >{
    Response save(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    UserDetailsDTO getUserDetails(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
