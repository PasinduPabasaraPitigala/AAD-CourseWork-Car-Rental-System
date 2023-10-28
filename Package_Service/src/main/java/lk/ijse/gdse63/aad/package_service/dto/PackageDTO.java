package lk.ijse.gdse63.aad.package_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PackageDTO implements Serializable,SuperDTO {
    private String package_id;
    private String  vehical_list;
    private String hotel_list;
    private String user_list;
    private String guideID;
    private String packageCategory;
}
