package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO  implements Serializable, SuperDTO {
    private String hotelID;
    private String hotelName;
    private String hotelCatageory;
    private String hotelLocation;
    private String hotelLocationWithCoordinates;
    private String hotelEmail;
    private String hotelContactNumber;
    private boolean isPetsAllowed;
    private double FullBoardDoublehotelFee;
    private double HalfBoardDoublehotelFee;
    private double FullBoardTriplehotelFee;
    private double HalfBoardTriplehotelFee;
    private String cancellationCriteria;

    private String packageId;
}