package lk.ijse.gdse63.aad.paymentservice.endpoints;

import lk.ijse.gdse63.aad.paymentservice.dto.PaymentDTO;
import lk.ijse.gdse63.aad.paymentservice.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "http://localhost:8081")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping(path = "/sp", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response savePayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.update(paymentDTO);
    }

    @GetMapping(path = "/search", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("paymentId") String paymentId) {
        return paymentService.search(paymentId);
    }

    @DeleteMapping(path = "/delete", params = "paymentId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("paymentId") String paymentId) {
        return paymentService.delete(paymentId);
    }

    @GetMapping(path = "/getPayment")
    public PaymentDTO getPayment(@RequestParam("paymentId") String paymentId) {
        return paymentService.getPayment(paymentId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return paymentService.getAll();
    }
}
