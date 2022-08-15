package org.project.plantstore.exception;

public class NotEnoughPlantException extends RuntimeException {

    public NotEnoughPlantException() {
        super();
    }

    public NotEnoughPlantException(String message) {
        super(message);
    }

    public NotEnoughPlantException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughPlantException(Throwable cause) {
        super(cause);
    }

    public NotEnoughPlantException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

