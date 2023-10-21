package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackagesDTO implements Serializable, SuperDTO {
    private String packageId;
    private String packageCategory;
    private String vehicleCategory;
    private String hotelCategory;
    private String hotelIdList;
    private String vehicleIdList;
}