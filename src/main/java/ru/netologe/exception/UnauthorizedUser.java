package ru.netologe.exception;

import ch.qos.logback.core.net.SocketConnector;

public class UnauthorizedUser extends RuntimeException {
    public UnauthorizedUser(String msg) {
        super(msg);
    }

}
