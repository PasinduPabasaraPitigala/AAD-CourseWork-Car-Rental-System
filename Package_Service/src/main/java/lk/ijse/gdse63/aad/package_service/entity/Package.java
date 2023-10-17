package lk.ijse.gdse63.aad.package_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Package {
    @Id
    private String packageId;
    private String packageCategory;
    private String vehicleCategory;
    private String hotelCategory;
}
