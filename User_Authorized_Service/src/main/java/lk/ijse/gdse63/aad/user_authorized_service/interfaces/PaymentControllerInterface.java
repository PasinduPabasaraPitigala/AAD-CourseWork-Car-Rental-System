package lk.ijse.gdse63.aad.user_authorized_service.interfaces;



import lk.ijse.gdse63.aad.user_authorized_service.dto.PaymentDTO;
import lk.ijse.gdse63.aad.user_authorized_service.model.Payment;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentControllerInterface {
    @PostMapping(path = "/sp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePayment(@RequestBody PaymentDTO paymentDTO);

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDTO);

    @GetMapping(path = "/search", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("paymentId") String paymentId);

    @DeleteMapping(path = "/delete", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("paymentId") String paymentId);

    @GetMapping(path = "/getPayment", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Payment> getPayment(@RequestParam("paymentId") String paymentId);

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll();
}
