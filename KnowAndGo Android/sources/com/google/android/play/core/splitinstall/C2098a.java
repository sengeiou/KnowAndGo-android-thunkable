package com.google.android.play.core.splitinstall;

import android.app.PendingIntent;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.a */
final class C2098a extends SplitInstallSessionState {

    /* renamed from: a */
    private final int f859a;

    /* renamed from: b */
    private final int f860b;

    /* renamed from: c */
    private final int f861c;

    /* renamed from: d */
    private final long f862d;

    /* renamed from: e */
    private final long f863e;

    /* renamed from: f */
    private final List<String> f864f;

    /* renamed from: g */
    private final List<String> f865g;

    /* renamed from: h */
    private final PendingIntent f866h;

    /* renamed from: i */
    private final List<Intent> f867i;

    C2098a(int i, int i2, int i3, long j, long j2, @Nullable List<String> list, @Nullable List<String> list2, @Nullable PendingIntent pendingIntent, @Nullable List<Intent> list3) {
        this.f859a = i;
        this.f860b = i2;
        this.f861c = i3;
        this.f862d = j;
        this.f863e = j2;
        this.f864f = list;
        this.f865g = list2;
        this.f866h = pendingIntent;
        this.f867i = list3;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public final List<String> mo33729a() {
        return this.f864f;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: b */
    public final List<String> mo33730b() {
        return this.f865g;
    }

    public final long bytesDownloaded() {
        return this.f862d;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public final List<Intent> mo33732c() {
        return this.f867i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        r1 = r7.f864f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        r1 = r7.f865g;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        r1 = r7.f866h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0076, code lost:
        r1 = r7.f867i;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.splitinstall.SplitInstallSessionState
            r2 = 0
            if (r1 == 0) goto L_0x008d
            com.google.android.play.core.splitinstall.SplitInstallSessionState r8 = (com.google.android.play.core.splitinstall.SplitInstallSessionState) r8
            int r1 = r7.f859a
            int r3 = r8.sessionId()
            if (r1 != r3) goto L_0x008d
            int r1 = r7.f860b
            int r3 = r8.status()
            if (r1 != r3) goto L_0x008d
            int r1 = r7.f861c
            int r3 = r8.errorCode()
            if (r1 != r3) goto L_0x008d
            long r3 = r7.f862d
            long r5 = r8.bytesDownloaded()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x008d
            long r3 = r7.f863e
            long r5 = r8.totalBytesToDownload()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x008d
            java.util.List<java.lang.String> r1 = r7.f864f
            if (r1 != 0) goto L_0x0042
            java.util.List r1 = r8.mo33729a()
            if (r1 != 0) goto L_0x008d
            goto L_0x004c
        L_0x0042:
            java.util.List r3 = r8.mo33729a()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x004c:
            java.util.List<java.lang.String> r1 = r7.f865g
            if (r1 != 0) goto L_0x0057
            java.util.List r1 = r8.mo33730b()
            if (r1 != 0) goto L_0x008d
            goto L_0x0061
        L_0x0057:
            java.util.List r3 = r8.mo33730b()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x0061:
            android.app.PendingIntent r1 = r7.f866h
            if (r1 != 0) goto L_0x006c
            android.app.PendingIntent r1 = r8.resolutionIntent()
            if (r1 != 0) goto L_0x008d
            goto L_0x0076
        L_0x006c:
            android.app.PendingIntent r3 = r8.resolutionIntent()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x008d
        L_0x0076:
            java.util.List<android.content.Intent> r1 = r7.f867i
            if (r1 != 0) goto L_0x0081
            java.util.List r8 = r8.mo33732c()
            if (r8 != 0) goto L_0x008d
            goto L_0x008c
        L_0x0081:
            java.util.List r8 = r8.mo33732c()
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            return r0
        L_0x008d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.C2098a.equals(java.lang.Object):boolean");
    }

    @SplitInstallErrorCode
    public final int errorCode() {
        return this.f861c;
    }

    public final int hashCode() {
        int i = this.f859a;
        int i2 = this.f860b;
        int i3 = this.f861c;
        long j = this.f862d;
        long j2 = this.f863e;
        int i4 = (((((((((i ^ 1000003) * 1000003) ^ i2) * 1000003) ^ i3) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        List<String> list = this.f864f;
        int i5 = 0;
        int hashCode = (i4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<String> list2 = this.f865g;
        int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        PendingIntent pendingIntent = this.f866h;
        int hashCode3 = (hashCode2 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        List<Intent> list3 = this.f867i;
        if (list3 != null) {
            i5 = list3.hashCode();
        }
        return hashCode3 ^ i5;
    }

    @Deprecated
    @Nullable
    public final PendingIntent resolutionIntent() {
        return this.f866h;
    }

    public final int sessionId() {
        return this.f859a;
    }

    @SplitInstallSessionStatus
    public final int status() {
        return this.f860b;
    }

    public final String toString() {
        int i = this.f859a;
        int i2 = this.f860b;
        int i3 = this.f861c;
        long j = this.f862d;
        long j2 = this.f863e;
        String valueOf = String.valueOf(this.f864f);
        String valueOf2 = String.valueOf(this.f865g);
        String valueOf3 = String.valueOf(this.f866h);
        String valueOf4 = String.valueOf(this.f867i);
        int length = String.valueOf(valueOf).length();
        int length2 = String.valueOf(valueOf2).length();
        StringBuilder sb = new StringBuilder(length + 251 + length2 + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("SplitInstallSessionState{sessionId=");
        sb.append(i);
        sb.append(", status=");
        sb.append(i2);
        sb.append(", errorCode=");
        sb.append(i3);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", moduleNamesNullable=");
        sb.append(valueOf);
        sb.append(", languagesNullable=");
        sb.append(valueOf2);
        sb.append(", resolutionIntent=");
        sb.append(valueOf3);
        sb.append(", splitFileIntents=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f863e;
    }
}
