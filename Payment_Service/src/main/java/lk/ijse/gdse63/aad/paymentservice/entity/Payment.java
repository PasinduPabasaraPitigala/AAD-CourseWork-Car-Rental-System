package lk.ijse.gdse63.aad.paymentservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Payment {
    @Id
    private String payID;
    private int DailyIncome;
    private int AnnualIncome;
    private int MonthlyIncome;
    private int WeeklyIncome;
}
