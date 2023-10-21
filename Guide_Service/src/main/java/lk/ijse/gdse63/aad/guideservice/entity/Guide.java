package lk.ijse.gdse63.aad.guideservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Guide {
    @Id
    private String guideId;
    private String guideName;
    private String guideAddress;
    private int guideAge;
    private String gender;
    private int guideContact;
    private String guideImageLocation;
    private String guideNICImageLocation;
    private String guideIDImageLocation;
    private String guideExperience;
    private String manDayValue;
    private String remarks;
}
