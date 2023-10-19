package lk.ijse.gdse63.aad.user_authorized_service.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Response {
    private int statusCode;
    private String message;
    private Object data;


}
