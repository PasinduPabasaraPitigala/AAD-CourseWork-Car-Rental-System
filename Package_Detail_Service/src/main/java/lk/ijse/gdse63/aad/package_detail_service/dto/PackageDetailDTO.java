package lk.ijse.gdse63.aad.package_detail_service.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PackageDetailDTO implements Serializable,SuperDTO {
    private String packageDetailId;

}
