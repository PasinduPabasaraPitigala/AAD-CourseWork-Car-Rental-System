package lk.ijse.gdse63.aad.guideservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Guide {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String guideID;

    private String guideName;

    private String guideAddress;

    private String guideAge;

    private String guideGender;

    private String guidePICIMGLocation;

    private String guideNICIMGLocation;

    private String guideIDIMGLocation;

    private String guideExperience;

    private int manDayValue;


    private String remark;

    //others
    private String package_id;
}
