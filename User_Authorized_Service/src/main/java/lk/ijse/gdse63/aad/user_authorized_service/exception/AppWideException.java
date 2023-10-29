package lk.ijse.gdse63.aad.user_authorized_service.exception;


import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin
public class AppWideException{

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({RuntimeException.class})
    public Response handleException(RuntimeException e){
    return new Response(500,e.getLocalizedMessage(),null);
}

}
