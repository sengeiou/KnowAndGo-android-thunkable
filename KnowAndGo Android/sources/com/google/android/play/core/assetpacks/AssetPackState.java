package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.internal.C2049h;

public abstract class AssetPackState {
    /* renamed from: a */
    static AssetPackState m260a(Bundle bundle, String str, C1894bz bzVar, C1867az azVar) {
        return m261a(str, azVar.mo33369a(bundle.getInt(C2049h.m757a("status", str)), str), bundle.getInt(C2049h.m757a("error_code", str)), bundle.getLong(C2049h.m757a("bytes_downloaded", str)), bundle.getLong(C2049h.m757a("total_bytes_to_download", str)), bzVar.mo33437b(str));
    }

    /* renamed from: a */
    public static AssetPackState m261a(@NonNull String str, @AssetPackStatus int i, @AssetPackErrorCode int i2, long j, long j2, double d) {
        return new C1876bh(str, i, i2, j, j2, (int) Math.rint(100.0d * d));
    }

    public abstract long bytesDownloaded();

    @AssetPackErrorCode
    public abstract int errorCode();

    public abstract String name();

    @AssetPackStatus
    public abstract int status();

    public abstract long totalBytesToDownload();

    public abstract int transferProgressPercentage();
}
