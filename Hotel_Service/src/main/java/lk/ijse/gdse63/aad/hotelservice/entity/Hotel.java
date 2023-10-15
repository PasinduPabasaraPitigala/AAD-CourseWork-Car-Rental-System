package lk.ijse.gdse63.aad.hotelservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lk.ijse.gdse63.aad.hotelservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel {
    @Id
        private String hotelId;
        private String packageId;
        private String hotelName;
        private String hotelCategory;
        private String hotelLocation;
        private String hotelLocationWithCordinates;
        private String hotelContactEmail;
        private String hotelContactNumber;
        private String petsAllowedOrNot;
        private String hotelFee;
        private String cancellationCriteria;
        private String Remark;
}
