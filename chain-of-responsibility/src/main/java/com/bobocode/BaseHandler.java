package com.bobocode;

public abstract class BaseHandler implements Handler {
    protected Handler next;

    @Override
    public void handle(String request) {
        validateRequest(request);
        if (next != null) {
            next.handle(request);
        }
    }

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    protected void validateRequest(String request) {
        if (request == null || request.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid request");
        }
    }
}
