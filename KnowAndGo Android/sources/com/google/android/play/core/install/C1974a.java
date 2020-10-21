package com.google.android.play.core.install;

import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

/* renamed from: com.google.android.play.core.install.a */
final class C1974a extends InstallState {

    /* renamed from: a */
    private final int f719a;

    /* renamed from: b */
    private final long f720b;

    /* renamed from: c */
    private final long f721c;

    /* renamed from: d */
    private final int f722d;

    /* renamed from: e */
    private final String f723e;

    C1974a(int i, long j, long j2, int i2, String str) {
        this.f719a = i;
        this.f720b = j;
        this.f721c = j2;
        this.f722d = i2;
        if (str != null) {
            this.f723e = str;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    public final long bytesDownloaded() {
        return this.f720b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            return this.f719a == installState.installStatus() && this.f720b == installState.bytesDownloaded() && this.f721c == installState.totalBytesToDownload() && this.f722d == installState.installErrorCode() && this.f723e.equals(installState.packageName());
        }
    }

    public final int hashCode() {
        int i = this.f719a;
        long j = this.f720b;
        long j2 = this.f721c;
        return ((((((((i ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f722d) * 1000003) ^ this.f723e.hashCode();
    }

    @InstallErrorCode
    public final int installErrorCode() {
        return this.f722d;
    }

    @InstallStatus
    public final int installStatus() {
        return this.f719a;
    }

    public final String packageName() {
        return this.f723e;
    }

    public final String toString() {
        int i = this.f719a;
        long j = this.f720b;
        long j2 = this.f721c;
        int i2 = this.f722d;
        String str = this.f723e;
        StringBuilder sb = new StringBuilder(str.length() + 164);
        sb.append("InstallState{installStatus=");
        sb.append(i);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", installErrorCode=");
        sb.append(i2);
        sb.append(", packageName=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f721c;
    }
}
