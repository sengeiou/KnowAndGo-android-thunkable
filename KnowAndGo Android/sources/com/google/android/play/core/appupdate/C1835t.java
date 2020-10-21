package com.google.android.play.core.appupdate;

import android.app.PendingIntent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;

/* renamed from: com.google.android.play.core.appupdate.t */
final class C1835t extends AppUpdateInfo {

    /* renamed from: a */
    private final String f253a;

    /* renamed from: b */
    private final int f254b;

    /* renamed from: c */
    private final int f255c;

    /* renamed from: d */
    private final int f256d;

    /* renamed from: e */
    private final Integer f257e;

    /* renamed from: f */
    private final int f258f;

    /* renamed from: g */
    private final long f259g;

    /* renamed from: h */
    private final long f260h;

    /* renamed from: i */
    private final long f261i;

    /* renamed from: j */
    private final long f262j;

    /* renamed from: k */
    private final PendingIntent f263k;

    /* renamed from: l */
    private final PendingIntent f264l;

    /* renamed from: m */
    private final PendingIntent f265m;

    /* renamed from: n */
    private final PendingIntent f266n;

    C1835t(String str, int i, int i2, int i3, @Nullable Integer num, int i4, long j, long j2, long j3, long j4, @Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable PendingIntent pendingIntent3, @Nullable PendingIntent pendingIntent4) {
        String str2 = str;
        if (str2 != null) {
            this.f253a = str2;
            this.f254b = i;
            this.f255c = i2;
            this.f256d = i3;
            this.f257e = num;
            this.f258f = i4;
            this.f259g = j;
            this.f260h = j2;
            this.f261i = j3;
            this.f262j = j4;
            this.f263k = pendingIntent;
            this.f264l = pendingIntent2;
            this.f265m = pendingIntent3;
            this.f266n = pendingIntent4;
            return;
        }
        throw new NullPointerException("Null packageName");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final long mo33234a() {
        return this.f261i;
    }

    public final int availableVersionCode() {
        return this.f254b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final long mo33237b() {
        return this.f262j;
    }

    public final long bytesDownloaded() {
        return this.f259g;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public final PendingIntent mo33239c() {
        return this.f263k;
    }

    @Nullable
    public final Integer clientVersionStalenessDays() {
        return this.f257e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: d */
    public final PendingIntent mo33241d() {
        return this.f264l;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: e */
    public final PendingIntent mo33242e() {
        return this.f265m;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r1 = r7.f257e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        r1 = r7.f263k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0089, code lost:
        r1 = r7.f264l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x009e, code lost:
        r1 = r7.f265m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00b3, code lost:
        r1 = r7.f266n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.appupdate.AppUpdateInfo
            r2 = 0
            if (r1 == 0) goto L_0x00ca
            com.google.android.play.core.appupdate.AppUpdateInfo r8 = (com.google.android.play.core.appupdate.AppUpdateInfo) r8
            java.lang.String r1 = r7.f253a
            java.lang.String r3 = r8.packageName()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ca
            int r1 = r7.f254b
            int r3 = r8.availableVersionCode()
            if (r1 != r3) goto L_0x00ca
            int r1 = r7.f255c
            int r3 = r8.updateAvailability()
            if (r1 != r3) goto L_0x00ca
            int r1 = r7.f256d
            int r3 = r8.installStatus()
            if (r1 != r3) goto L_0x00ca
            java.lang.Integer r1 = r7.f257e
            if (r1 != 0) goto L_0x003a
            java.lang.Integer r1 = r8.clientVersionStalenessDays()
            if (r1 != 0) goto L_0x00ca
            goto L_0x0044
        L_0x003a:
            java.lang.Integer r3 = r8.clientVersionStalenessDays()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ca
        L_0x0044:
            int r1 = r7.f258f
            int r3 = r8.updatePriority()
            if (r1 != r3) goto L_0x00ca
            long r3 = r7.f259g
            long r5 = r8.bytesDownloaded()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00ca
            long r3 = r7.f260h
            long r5 = r8.totalBytesToDownload()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00ca
            long r3 = r7.f261i
            long r5 = r8.mo33234a()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00ca
            long r3 = r7.f262j
            long r5 = r8.mo33237b()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x00ca
            android.app.PendingIntent r1 = r7.f263k
            if (r1 != 0) goto L_0x007f
            android.app.PendingIntent r1 = r8.mo33239c()
            if (r1 != 0) goto L_0x00ca
            goto L_0x0089
        L_0x007f:
            android.app.PendingIntent r3 = r8.mo33239c()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ca
        L_0x0089:
            android.app.PendingIntent r1 = r7.f264l
            if (r1 != 0) goto L_0x0094
            android.app.PendingIntent r1 = r8.mo33241d()
            if (r1 != 0) goto L_0x00ca
            goto L_0x009e
        L_0x0094:
            android.app.PendingIntent r3 = r8.mo33241d()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ca
        L_0x009e:
            android.app.PendingIntent r1 = r7.f265m
            if (r1 != 0) goto L_0x00a9
            android.app.PendingIntent r1 = r8.mo33242e()
            if (r1 != 0) goto L_0x00ca
            goto L_0x00b3
        L_0x00a9:
            android.app.PendingIntent r3 = r8.mo33242e()
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x00ca
        L_0x00b3:
            android.app.PendingIntent r1 = r7.f266n
            if (r1 != 0) goto L_0x00be
            android.app.PendingIntent r8 = r8.mo33243f()
            if (r8 != 0) goto L_0x00ca
            goto L_0x00c9
        L_0x00be:
            android.app.PendingIntent r8 = r8.mo33243f()
            boolean r8 = r1.equals(r8)
            if (r8 != 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            return r0
        L_0x00ca:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.appupdate.C1835t.equals(java.lang.Object):boolean");
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: f */
    public final PendingIntent mo33243f() {
        return this.f266n;
    }

    public final int hashCode() {
        int hashCode = (((((((this.f253a.hashCode() ^ 1000003) * 1000003) ^ this.f254b) * 1000003) ^ this.f255c) * 1000003) ^ this.f256d) * 1000003;
        Integer num = this.f257e;
        int i = 0;
        int hashCode2 = num == null ? 0 : num.hashCode();
        int i2 = this.f258f;
        long j = this.f259g;
        long j2 = this.f260h;
        long j3 = this.f261i;
        long j4 = this.f262j;
        int i3 = (((((((((((hashCode ^ hashCode2) * 1000003) ^ i2) * 1000003) ^ ((int) ((j >>> 32) ^ j))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        PendingIntent pendingIntent = this.f263k;
        int hashCode3 = (i3 ^ (pendingIntent == null ? 0 : pendingIntent.hashCode())) * 1000003;
        PendingIntent pendingIntent2 = this.f264l;
        int hashCode4 = (hashCode3 ^ (pendingIntent2 == null ? 0 : pendingIntent2.hashCode())) * 1000003;
        PendingIntent pendingIntent3 = this.f265m;
        int hashCode5 = (hashCode4 ^ (pendingIntent3 == null ? 0 : pendingIntent3.hashCode())) * 1000003;
        PendingIntent pendingIntent4 = this.f266n;
        if (pendingIntent4 != null) {
            i = pendingIntent4.hashCode();
        }
        return hashCode5 ^ i;
    }

    @InstallStatus
    public final int installStatus() {
        return this.f256d;
    }

    @NonNull
    public final String packageName() {
        return this.f253a;
    }

    public final String toString() {
        String str = this.f253a;
        int i = this.f254b;
        int i2 = this.f255c;
        int i3 = this.f256d;
        String valueOf = String.valueOf(this.f257e);
        int i4 = this.f258f;
        long j = this.f259g;
        long j2 = this.f260h;
        long j3 = this.f261i;
        long j4 = this.f262j;
        String valueOf2 = String.valueOf(this.f263k);
        long j5 = j4;
        String valueOf3 = String.valueOf(this.f264l);
        String valueOf4 = String.valueOf(this.f265m);
        long j6 = j3;
        String valueOf5 = String.valueOf(this.f266n);
        int length = str.length();
        int length2 = String.valueOf(valueOf).length();
        int length3 = String.valueOf(valueOf2).length();
        int length4 = String.valueOf(valueOf3).length();
        StringBuilder sb = new StringBuilder(length + 463 + length2 + length3 + length4 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length());
        sb.append("AppUpdateInfo{packageName=");
        sb.append(str);
        sb.append(", availableVersionCode=");
        sb.append(i);
        sb.append(", updateAvailability=");
        sb.append(i2);
        sb.append(", installStatus=");
        sb.append(i3);
        sb.append(", clientVersionStalenessDays=");
        sb.append(valueOf);
        sb.append(", updatePriority=");
        sb.append(i4);
        sb.append(", bytesDownloaded=");
        sb.append(j);
        sb.append(", totalBytesToDownload=");
        sb.append(j2);
        sb.append(", additionalSpaceRequired=");
        sb.append(j6);
        sb.append(", assetPackStorageSize=");
        sb.append(j5);
        sb.append(", immediateUpdateIntent=");
        sb.append(valueOf2);
        sb.append(", flexibleUpdateIntent=");
        sb.append(valueOf3);
        sb.append(", immediateDestructiveUpdateIntent=");
        sb.append(valueOf4);
        sb.append(", flexibleDestructiveUpdateIntent=");
        sb.append(valueOf5);
        sb.append("}");
        return sb.toString();
    }

    public final long totalBytesToDownload() {
        return this.f260h;
    }

    @UpdateAvailability
    public final int updateAvailability() {
        return this.f255c;
    }

    public final int updatePriority() {
        return this.f258f;
    }
}
