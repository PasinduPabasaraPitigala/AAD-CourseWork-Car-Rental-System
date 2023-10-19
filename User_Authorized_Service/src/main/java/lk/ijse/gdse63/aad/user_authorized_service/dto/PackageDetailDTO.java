package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDetailDTO implements SuperDTO, Serializable {
    private String packageDetailId;
    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean withPetsOrNot;
    private boolean isGuideIncluded;
    private double packageValue;
    private double paidValue;
    private String vehicleId;
    private String hotelId;
    private String guideId;
    private String packageId;
    private String userId;
}