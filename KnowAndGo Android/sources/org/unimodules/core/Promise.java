package org.unimodules.core;

import org.unimodules.core.interfaces.CodedThrowable;

public abstract class Promise {
    private static String UNKNOWN_ERROR = "E_UNKNOWN_ERROR";

    public abstract void reject(String str, String str2, Throwable th);

    public abstract void resolve(Object obj);

    public void reject(Throwable th) {
        if (th instanceof CodedThrowable) {
            CodedThrowable codedThrowable = (CodedThrowable) th;
            reject(codedThrowable.getCode(), codedThrowable.getMessage(), th);
            return;
        }
        reject(UNKNOWN_ERROR, th);
    }

    public void reject(String str, String str2) {
        reject(str, str2, (Throwable) null);
    }

    public void reject(String str, Throwable th) {
        reject(str, th.getMessage(), th);
    }
}
