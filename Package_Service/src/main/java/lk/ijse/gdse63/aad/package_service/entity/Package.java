package lk.ijse.gdse63.aad.package_service.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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


    @ElementCollection
    private List<String> hotelsList;

    @ElementCollection
    private List<String> vehicleList;
}
