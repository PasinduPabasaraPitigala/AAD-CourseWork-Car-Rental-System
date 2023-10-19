package lk.ijse.gdse63.aad.user_authorized_service.interfaces;

import com.google.common.net.MediaType;
import feign.Response;
import lk.ijse.gdse63.aad.user_authorized_service.dto.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

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
