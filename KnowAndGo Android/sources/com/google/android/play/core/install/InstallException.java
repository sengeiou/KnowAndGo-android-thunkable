package com.google.android.play.core.install;

import com.google.android.play.core.install.model.C1975a;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.tasks.C2171j;

public class InstallException extends C2171j {
    @InstallErrorCode

    /* renamed from: a */
    private final int f718a;

    public InstallException(@InstallErrorCode int i) {
        super(String.format("Install Error(%d): %s", new Object[]{Integer.valueOf(i), C1975a.m575a(i)}));
        if (i != 0) {
            this.f718a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @InstallErrorCode
    public int getErrorCode() {
        return this.f718a;
    }
}
