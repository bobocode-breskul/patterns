package com.bobocode;

public interface Handler {

    void handle (String request);
    void setNext(Handler handler);
}
