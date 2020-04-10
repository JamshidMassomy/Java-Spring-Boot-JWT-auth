package sys.auth.exceptions;

public abstract class ApiSubErrors {
}

class ApiValidationError extends ApiSubErrors {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}