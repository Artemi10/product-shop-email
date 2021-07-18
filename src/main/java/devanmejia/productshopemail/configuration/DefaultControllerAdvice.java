package devanmejia.productshopemail.configuration;

import devanmejia.productshopemail.exception.DecodeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.mail.MessagingException;

@ControllerAdvice
public class DefaultControllerAdvice {

    @ExceptionHandler(MessagingException.class)
    public ResponseEntity<String> handleException(MessagingException e) {
        String responseMsg = e.getMessage();
        e.printStackTrace();
        return new ResponseEntity<>(responseMsg, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DecodeException.class)
    public ResponseEntity<String> handleException(DecodeException e) {
        e.printStackTrace();
        String responseMsg = e.getMessage();
        return new ResponseEntity<>(responseMsg, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
