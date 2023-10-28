package lk.ijse.gdse63.aad.user_authorized_service.dto;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
public class PaymentDTO implements Serializable {
    private String payID;
    private int DailyIncome;
    private int AnnualIncome;
    private int MonthlyIncome;
    private int WeeklyIncome;

}
