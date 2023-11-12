package core.handling;

import core.model.exception.InvalidSensorNameException;
import core.model.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler({InvalidSensorNameException.class})
    public ResponseEntity<?> handleFieldException(final InvalidSensorNameException e) {
        return new ResponseEntity<>(new CustomResponse(e.getMessage()), HttpStatus.CONFLICT);
    }
}