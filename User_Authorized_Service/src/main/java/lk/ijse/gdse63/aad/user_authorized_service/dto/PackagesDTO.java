package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackagesDTO implements Serializable{
    private String package_id;
    private String hotel_id;
    private String vehical_id;
}