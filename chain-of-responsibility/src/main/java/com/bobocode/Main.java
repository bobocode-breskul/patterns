package com.bobocode;

public class Main {
    public static void main(String[] args) {
        String request = """
                "firstName": "John",
                "lastName": "Doe" 
                """;

        var authHandler = new AuthHandler();
        var ipRestrictionHandler = new IpRestrictionHandler();
        var cacheHandler = new CacheHandler();
        var noOpHandler = new NoOpHandler();

        authHandler.setNext(ipRestrictionHandler);
        ipRestrictionHandler.setNext(cacheHandler);
        cacheHandler.setNext(noOpHandler);

        authHandler.handle(request);
    }
}