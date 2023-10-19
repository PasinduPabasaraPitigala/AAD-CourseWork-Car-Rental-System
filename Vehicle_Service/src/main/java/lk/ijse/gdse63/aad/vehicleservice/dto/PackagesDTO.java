package lk.ijse.gdse63.aad.vehicleservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackagesDTO implements Serializable,SuperDTO {
    private String packageId;
    private String packageCategory;
    private String vehicleCategory;
    private String hotelCategory;
}
