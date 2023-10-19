package lk.ijse.gdse63.aad.user_authorized_service.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Packages {
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

