package com.bobocode;

import java.util.concurrent.ThreadLocalRandom;

public class AuthHandler extends BaseHandler {
    private final String className = this.getClass().getSimpleName();

    @Override
    public void handle(String request) {
        System.out.println("[%s] Authentication filter...".formatted(className));
        super.validateRequest(request);

        if (isValidCredentials()) {
            System.out.println("[%s] Request successfully authenticated...".formatted(className));
            super.handle(request);
        } else {
            System.out.println("[%s] Failed to authenticate!".formatted(className));
            throw new IllegalArgumentException("Invalid credentials");
        }
    }

    private boolean isValidCredentials() {
        System.out.println("[%s] Validating credentials...".formatted(className));
        return ThreadLocalRandom.current().nextBoolean();
    }
}
