package lk.ijse.gdse63.aad.hotelservice.service;

import lk.ijse.gdse63.aad.hotelservice.dto.HotelDTO;
import lk.ijse.gdse63.aad.hotelservice.response.Response;

public interface SuperService <T extends HotelDTO,ID> {
    Response save(HotelDTO hotelDTO);

    Response update(HotelDTO hotelDTO);

    Response search(String hotelId);

    Response delete(String hotelId);

    Response getAll();
}
