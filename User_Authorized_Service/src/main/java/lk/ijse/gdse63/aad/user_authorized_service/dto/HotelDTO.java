package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HotelDTO  implements Serializable, SuperDTO {

    private String hotelID;
    private String hotelName;
    private String hotelCategory;
    private String location;
    private String locationCoordinate;
    private String hotelEmail;
    private String contactNumber01;
    private String getContactNumber02;
    private boolean petsStatus;
    //Pets allowed or not
    private String FullBoarddoublehotelFee;
    private String HalfBoardDoublehotelFee;
    private String FullBoardTriplehotelFee;
    private String HalfBoardTriplehotelFee;

    private String CancellationCriteria;



    private String remark;
    private String package_id;
}