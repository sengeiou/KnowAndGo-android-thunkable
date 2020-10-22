package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.C1956a;
import com.google.android.play.core.tasks.C2171j;

public class AssetPackException extends C2171j {
    @AssetPackErrorCode

    /* renamed from: a */
    private final int f293a;

    AssetPackException(@AssetPackErrorCode int i) {
        super(String.format("Asset Pack Download Error(%d): %s", new Object[]{Integer.valueOf(i), C1956a.m538a(i)}));
        if (i != 0) {
            this.f293a = i;
            return;
        }
        throw new IllegalArgumentException("errorCode should not be 0.");
    }

    @AssetPackErrorCode
    public int getErrorCode() {
        return this.f293a;
    }
}
