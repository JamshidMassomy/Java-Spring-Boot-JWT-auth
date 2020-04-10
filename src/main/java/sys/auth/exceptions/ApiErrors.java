package sys.auth.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

public class ApiErrors {
    private HttpStatus httpStatus;
    private String Message;
    private String DebugMessage;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private LocalDateTime timeStampt;

    public void setMessage(String message) {
        Message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    private ApiErrors() {
        timeStampt=LocalDateTime.now();
    }
    ApiErrors(HttpStatus httpStatus) {
        this();
        this.httpStatus = httpStatus;

    }
    ApiErrors(HttpStatus httpStatus,Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.Message = "Unexpected Error";
        this.DebugMessage=ex.getLocalizedMessage();
    }
    ApiErrors(HttpStatus httpStatus, String message,Throwable ex) {
        this();
        this.httpStatus = httpStatus;
        this.Message = message;
        this.DebugMessage=ex.getLocalizedMessage();
    }
}
