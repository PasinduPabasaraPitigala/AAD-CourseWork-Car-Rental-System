package lk.ijse.gdse63.aad.paymentservice.repo;

import lk.ijse.gdse63.aad.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, String> {

}
