package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDetailDTO implements Serializable {
    private int packageID;
    private String packageCategory;
    private String travelDuration;
    private String travelArea;
    private String remark;
    private int noOfAdults;
    private int noOfChildren;
    private int totalHeadCount;
    private boolean isPetsAllowed;
    private boolean isGuideNeeded;
    private double packageValue;
    private double packagePaidValue;
    private int hotelID;
    private int vehicleID;
    private int userID;
    private int guideID;
}