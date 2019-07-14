package com.randombeer.exception;

public class RandomBeerException extends RuntimeException{

    public RandomBeerException() {
        super();
    }

    public RandomBeerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RandomBeerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RandomBeerException(String message) {
        super(message);
    }

    public RandomBeerException(Throwable cause) {
        super(cause);
    }

    
}
