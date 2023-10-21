package lk.ijse.gdse63.aad.user_authorized_service.advisor;



import lk.ijse.gdse63.aad.user_authorized_service.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
@CrossOrigin
public class GlobalExceptionHandler {
    @Autowired
    private Response response;
    @ExceptionHandler({Exception.class})
    public Response handleExceptions(Exception exception){
        System.out.println("Real exception : "+exception.getLocalizedMessage());
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        response.setMessage("Auth Server threw an exception : "+exception.getLocalizedMessage());
        response.setData(null);
        return response;

    }

    @ExceptionHandler({UsernameNotFoundException.class})
    public Response handleExceptions(UsernameNotFoundException exception){
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Server threw an exception : "+exception.getLocalizedMessage());
        response.setData(null);
        return response;

    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response handleExceptions(MethodArgumentNotValidException exception){
        HashMap<String, String> errors = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Server threw an exception : "+exception.getLocalizedMessage());
        response.setData(errors);
        return response;

    }

}
