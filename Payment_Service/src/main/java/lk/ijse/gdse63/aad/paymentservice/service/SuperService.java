package lk.ijse.gdse63.aad.paymentservice.service;

import lk.ijse.gdse63.aad.paymentservice.dto.PaymentDTO;
import lk.ijse.gdse63.aad.paymentservice.dto.SuperDTO;
import lk.ijse.gdse63.aad.paymentservice.response.Response;

public interface SuperService<T extends SuperDTO,ID > {
    Response savePayment(T t);

    Response update(T t);

    Response delete(ID id);

    Response search(ID id);

    PaymentDTO getPayment(ID id);

    Response getAll();

    Response createAndSendResponse(int statusCode, String message, Object data);
}
