package lk.ijse.gdse63.aad.guideservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GuideDTO implements Serializable{


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


}
