package lk.ijse.gdse63.aad.hotelservice.service.custom;

import lk.ijse.gdse63.aad.hotelservice.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotelservice.response.Response;
import lk.ijse.gdse63.aad.hotelservice.service.SuperService;

public interface HotelService extends SuperService<HotelDTO,String> {
    Response createAndSendResponse(int statusCode, String message, Object data);
}
