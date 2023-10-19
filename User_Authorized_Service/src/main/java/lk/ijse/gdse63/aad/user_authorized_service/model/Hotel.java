package lk.ijse.gdse63.aad.user_authorized_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    @Id
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
