package lk.ijse.gdse63.aad.user_authorized_service.endpoints;


import lk.ijse.gdse63.aad.user_authorized_service.dto.PaymentDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PaymentControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.model.Payment;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/payment")
@CrossOrigin
public class PaymentController {
    @Autowired
    private PaymentControllerInterface paymentControllerInterface;

    @PostMapping(path = "/sp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentControllerInterface.savePayment(paymentDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDTO) {
        return paymentControllerInterface.update(paymentDTO);
    }

    @GetMapping(path = "/search", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("paymentId") String paymentId) {
        return paymentControllerInterface.search(paymentId);
    }

    @DeleteMapping(path = "/delete", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("paymentId") String paymentId) {
        return paymentControllerInterface.delete(paymentId);
    }

    @GetMapping(path = "/getPayment", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Payment> getPayment(@RequestParam("paymentId") String paymentId) {
        return paymentControllerInterface.getPayment(paymentId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return paymentControllerInterface.getAll();
    }
}
