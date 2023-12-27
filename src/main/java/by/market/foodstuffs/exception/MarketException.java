package by.market.foodstuffs.exception;

import org.springframework.http.HttpStatus;

public class MarketException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public MarketException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public MarketException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
