package lk.ijse.gdse63.aad.user_authorized_service.endpoints;

import lk.ijse.gdse63.aad.user_authorized_service.dto.PaymentDTO;
import lk.ijse.gdse63.aad.user_authorized_service.interfaces.PaymentControllerInterface;
import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Payment")
@CrossOrigin
public class PaymentController {

    @Autowired
    private PaymentControllerInterface paymentControllerInterface;

    @GetMapping(path = "PGet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("PayID") String PayID){
        System.out.println("payment search");
        return  paymentControllerInterface.search(PayID);
    }

    @PostMapping(path = "PSave",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody PaymentDTO paymentDto){
        System.out.println("save payment");
        return  paymentControllerInterface.save(paymentDto);
    }

    @PutMapping(path = "Pput",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response update(@RequestBody PaymentDTO paymentDto){
        System.out.println("put payment");
        return  paymentControllerInterface.save(paymentDto);
    }

    @DeleteMapping(path = "Pdelet",params = "PayID",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("PayID") String PayID){
        System.out.println("PayID delete ok");
        return  paymentControllerInterface.delete(PayID);
    }


}
