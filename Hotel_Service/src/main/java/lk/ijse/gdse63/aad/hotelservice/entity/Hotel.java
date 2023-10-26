package lk.ijse.gdse63.aad.hotelservice.entity;

import jakarta.persistence.*;
import lk.ijse.gdse63.aad.hotelservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table
@Builder
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
