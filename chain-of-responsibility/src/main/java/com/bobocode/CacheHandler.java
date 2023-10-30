package com.bobocode;

import java.util.concurrent.ThreadLocalRandom;

public class CacheHandler extends BaseHandler {
    private final String className = this.getClass().getSimpleName();

    @Override
    public void handle(String request) {
        System.out.println("[%s] Cache filter...".formatted(className));
        super.validateRequest(request);

        if (isCacheable(request)) {
            System.out.println("[%s] Value stored to the cache".formatted(className));
        }

        super.handle(request);
    }

    private boolean isCacheable(String request) {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
