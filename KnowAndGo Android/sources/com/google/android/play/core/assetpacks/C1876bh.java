package com.google.android.play.core.assetpacks;

import com.google.android.play.core.assetpacks.model.AssetPackErrorCode;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;

/* renamed from: com.google.android.play.core.assetpacks.bh */
final class C1876bh extends AssetPackState {

    /* renamed from: a */
    private final String f412a;

    /* renamed from: b */
    private final int f413b;

    /* renamed from: c */
    private final int f414c;

    /* renamed from: d */
    private final long f415d;

    /* renamed from: e */
    private final long f416e;

    /* renamed from: f */
    private final int f417f;

    C1876bh(String str, int i, int i2, long j, long j2, int i3) {
        if (str != null) {
            this.f412a = str;
            this.f413b = i;
            this.f414c = i2;
            this.f415d = j;
            this.f416e = j2;
            this.f417f = i3;
            return;
        }
        throw new NullPointerException("Null name");
    }

    public final long bytesDownloaded() {
        return this.f415d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AssetPackState) {
            AssetPackState assetPackState = (AssetPackState) obj;
            return this.f412a.equals(assetPackState.name()) && this.f413b == assetPackState.status() && this.f414c == assetPackState.errorCode() && this.f415d == assetPackState.bytesDownloaded() && this.f416e == assetPackState.totalBytesToDownload() && this.f417f == assetPackState.transferProgressPercentage();
        }
    }

    @AssetPackErrorCode
    public final int errorCode() {
        return this.f414c;
    }

    public final int hashCode() {
        int hashCode = this.f412a.hashCode();
        int i = this.f413b;
        int i2 = this.f414c;
        long j = this.f415d;
        long j2 = this.f416e;
        return ((((((((((hashCode ^ 1000003) * 1000003) ^ i) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f417f;
    }

    public final String name() {
        return this.f412a;
    }

    @AssetPackStatus
    public final int status() {
        return this.f413b;
    }

    public final String toString() {
        String str = this.f412a;
        int i = this.f413b;
        int i2 = this.f414c;
        long j = this.f415d;
        long j2 = this.f416e;
        int i3 = this.f417f;
        StringBuilder sb = new StringBuilder(str.length() + 185);
        sb.append("AssetPackState{name=");
        sb.append(str);
        sb.append(", status=");
        sb.append(i);
        sb.append(", errorCode=");
        sb.append(i2);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", transferProgressPercentage=");
        sb.append(i3);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f416e;
    }

    public final int transferProgressPercentage() {
        return this.f417f;
    }
}
