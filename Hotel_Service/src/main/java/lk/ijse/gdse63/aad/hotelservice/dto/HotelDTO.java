package lk.ijse.gdse63.aad.hotelservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelDTO implements Serializable,SuperDTO {
    private String hotelId;
    private String packageId;
    private String hotelName;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelLocationWithCordinates;
    private String hotelContactEmail;
    private String hotelContactNumber;
    private String petsAllowedOrNot;
    private String hotelFee;
    private String cancellationCriteria;
    private String Remark;

}
