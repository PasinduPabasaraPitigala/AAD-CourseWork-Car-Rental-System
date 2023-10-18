package lk.ijse.gdse63.aad.paymentservice.dto;

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
    private String packageDeatilsId;
}
