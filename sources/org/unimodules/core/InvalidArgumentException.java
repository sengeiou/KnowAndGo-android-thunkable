package org.unimodules.core;

public class InvalidArgumentException extends Exception {
    public InvalidArgumentException() {
    }

    public InvalidArgumentException(String str) {
        super(str);
    }

    public InvalidArgumentException(Throwable th) {
        super(th);
    }

    public InvalidArgumentException(String str, Throwable th) {
        super(str, th);
    }
}
