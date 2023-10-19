package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lk.ijse.gdse63.aad.guideservice.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO implements SuperDTO, Serializable {
    private String paymentId;
    private String paymentDate;
    private String paymentAmount;
    private String userId;
    private String packageDetailsId;
}
