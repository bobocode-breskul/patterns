package com.bobocode;

import java.util.concurrent.ThreadLocalRandom;

public class IpRestrictionHandler extends BaseHandler {
    private final String className = this.getClass().getSimpleName();

    @Override
    public void handle(String request) {
        System.out.println("[%s] Ip restriction filter...".formatted(className));
        super.validateRequest(request);

        if (isRestricted(request)) {
            System.out.println("[%s] Ip is restricted!".formatted(className));
            throw new IllegalArgumentException("Restricted ip!");
        }

        super.handle(request);
    }

    private boolean isRestricted(String request) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
