package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDetailDTO implements SuperDTO, Serializable {
    private String packageDetailsId;
    private String packageId;
    private String packageCategory;
    private String hotelId;
    private String vehicleId;
    private Date startDate;
    private Date endDate;
    private int noOfDays;
    private String travelArea;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private  boolean petsStatus;
    private  boolean guideStatus;
    private String guideId;
    private  double totalPackageValue;
    private  String userId;
    private double paidValue;
    private String remarks;
}