package com.google.android.play.core.splitinstall;

import com.google.android.play.core.splitinstall.model.C2137a;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.tasks.C2171j;

public class SplitInstallException extends C2171j {
    @SplitInstallErrorCode

    /* renamed from: a */
    private final int f853a;

    public SplitInstallException(@SplitInstallErrorCode int i) {
        super(String.format("Split Install Error(%d): %s", new Object[]{Integer.valueOf(i), C2137a.m994a(i)}));
        if (i != 0) {
            this.f853a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @SplitInstallErrorCode
    public int getErrorCode() {
        return this.f853a;
    }
}
