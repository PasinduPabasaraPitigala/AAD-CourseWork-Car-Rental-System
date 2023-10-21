package lk.ijse.gdse63.aad.package_detail_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PackageDetail {
    @Id

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
