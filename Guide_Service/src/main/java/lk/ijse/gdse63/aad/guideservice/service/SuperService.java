package lk.ijse.gdse63.aad.guideservice.service;

import lk.ijse.gdse63.aad.guideservice.dto.GuideDTO;
import lk.ijse.gdse63.aad.guideservice.response.Response;

public interface SuperService<T extends GuideDTO,ID>{
    Response save(T t);

    Response update(T t);

    Response search(ID id);

    Response delete(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode,String message , Object data);
}
