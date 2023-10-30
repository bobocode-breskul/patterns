package com.bobocode;

public class NoOpHandler extends BaseHandler{

    private final String className = this.getClass().getSimpleName();

    @Override
    public void handle(String request) {
        System.out.println("[%s] No operation filter...".formatted(className));
        super.handle(request);

    }
}
