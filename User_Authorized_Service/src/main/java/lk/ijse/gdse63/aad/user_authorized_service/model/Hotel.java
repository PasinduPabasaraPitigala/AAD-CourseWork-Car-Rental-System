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

    private String hotelId;
    private String hotelName;
    private String hotelCategory;
    private String hotelLocation;
    private String hotelLocationWithCoordinates;
    private String hotelImageLocation;
    private String hotelContactEmail;
    private String hotelContact1;
    private String hotelContact2;
    private double fullBoardWithACLuxuryRoomDouble;
    private double halfBoardWithACLuxuryRoomDouble;
    private double fullBoardWithACLuxuryRoomTriple;
    private double halfBoardWithACLuxuryRoomTriple;
    private boolean isPetsAllowed;
    private double hotelFee;
    private String cancellationCriteria;
    private String remarks;

    private String packageId;
}
