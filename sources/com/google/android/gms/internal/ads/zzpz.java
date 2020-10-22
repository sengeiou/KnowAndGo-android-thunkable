package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C1470C;
import java.io.IOException;

final class zzpz implements zznp, zzqj, zzqv, zzsf<zzqe> {
    /* access modifiers changed from: private */
    public final Handler handler;
    private final Uri uri;
    private final Handler zzabq;
    /* access modifiers changed from: private */
    public boolean zzacf;
    private long zzack;
    private boolean zzacs;
    /* access modifiers changed from: private */
    public final SparseArray<zzqt> zzaif;
    private final int zzaig;
    private boolean zzaii;
    private int zzaik;
    private boolean[] zzain;
    private long zzaip;
    private long zzaiq;
    private boolean zzaiz;
    private final zzrv zzazi;
    /* access modifiers changed from: private */
    public final zzqi zzbia;
    private final zzqm zzbib;
    private final zzrt zzbic;
    /* access modifiers changed from: private */
    public final String zzbid;
    /* access modifiers changed from: private */
    public final long zzbie;
    private final zzse zzbif = new zzse("Loader:ExtractorMediaPeriod");
    private final zzqf zzbig;
    private final zzsm zzbih;
    private final Runnable zzbii;
    /* access modifiers changed from: private */
    public final Runnable zzbij;
    /* access modifiers changed from: private */
    public zzqk zzbik;
    private zznu zzbil;
    private boolean zzbim;
    private boolean zzbin;
    private zzrb zzbio;
    private boolean[] zzbip;
    private boolean zzbiq;
    private int zzbir;
    private long zzcd;

    public zzpz(Uri uri2, zzrv zzrv, zznn[] zznnArr, int i, Handler handler2, zzqi zzqi, zzqm zzqm, zzrt zzrt, String str, int i2) {
        this.uri = uri2;
        this.zzazi = zzrv;
        this.zzaig = i;
        this.zzabq = handler2;
        this.zzbia = zzqi;
        this.zzbib = zzqm;
        this.zzbic = zzrt;
        this.zzbid = str;
        this.zzbie = (long) i2;
        this.zzbig = new zzqf(zznnArr, this);
        this.zzbih = new zzsm();
        this.zzbii = new zzqa(this);
        this.zzbij = new zzqb(this);
        this.handler = new Handler();
        this.zzaiq = C1470C.TIME_UNSET;
        this.zzaif = new SparseArray<>();
        this.zzcd = -1;
    }

    public final void zzem(long j) {
    }

    public final void release() {
        this.zzbif.zza((Runnable) new zzqc(this, this.zzbig));
        this.handler.removeCallbacksAndMessages((Object) null);
        this.zzacf = true;
    }

    public final void zza(zzqk zzqk, long j) {
        this.zzbik = zzqk;
        this.zzbih.zzjx();
        startLoading();
    }

    public final void zziy() throws IOException {
        this.zzbif.zzbm(Integer.MIN_VALUE);
    }

    public final zzrb zziz() {
        return this.zzbio;
    }

    public final long zza(zzrm[] zzrmArr, boolean[] zArr, zzqw[] zzqwArr, boolean[] zArr2, long j) {
        zzsk.checkState(this.zzacs);
        for (int i = 0; i < zzrmArr.length; i++) {
            if (zzqwArr[i] != null && (zzrmArr[i] == null || !zArr[i])) {
                int zza = zzqwArr[i].track;
                zzsk.checkState(this.zzain[zza]);
                this.zzaik--;
                this.zzain[zza] = false;
                this.zzaif.valueAt(zza).disable();
                zzqwArr[i] = null;
            }
        }
        boolean z = false;
        for (int i2 = 0; i2 < zzrmArr.length; i2++) {
            if (zzqwArr[i2] == null && zzrmArr[i2] != null) {
                zzrm zzrm = zzrmArr[i2];
                zzsk.checkState(zzrm.length() == 1);
                zzsk.checkState(zzrm.zzbh(0) == 0);
                int zza2 = this.zzbio.zza(zzrm.zzjr());
                zzsk.checkState(!this.zzain[zza2]);
                this.zzaik++;
                this.zzain[zza2] = true;
                zzqwArr[i2] = new zzqg(this, zza2);
                zArr2[i2] = true;
                z = true;
            }
        }
        if (!this.zzbim) {
            int size = this.zzaif.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (!this.zzain[i3]) {
                    this.zzaif.valueAt(i3).disable();
                }
            }
        }
        if (this.zzaik == 0) {
            this.zzbin = false;
            if (this.zzbif.isLoading()) {
                this.zzbif.zzgb();
            }
        } else if (!this.zzbim ? j != 0 : z) {
            j = zzen(j);
            for (int i4 = 0; i4 < zzqwArr.length; i4++) {
                if (zzqwArr[i4] != null) {
                    zArr2[i4] = true;
                }
            }
        }
        this.zzbim = true;
        return j;
    }

    public final boolean zzel(long j) {
        if (this.zzaiz) {
            return false;
        }
        if (this.zzacs && this.zzaik == 0) {
            return false;
        }
        boolean zzjx = this.zzbih.zzjx();
        if (this.zzbif.isLoading()) {
            return zzjx;
        }
        startLoading();
        return true;
    }

    public final long zzix() {
        if (this.zzaik == 0) {
            return Long.MIN_VALUE;
        }
        return zzdu();
    }

    public final long zzja() {
        if (!this.zzbin) {
            return C1470C.TIME_UNSET;
        }
        this.zzbin = false;
        return this.zzaip;
    }

    public final long zzdu() {
        long j;
        if (this.zzaiz) {
            return Long.MIN_VALUE;
        }
        if (zzfo()) {
            return this.zzaiq;
        }
        if (this.zzbiq) {
            j = Long.MAX_VALUE;
            int size = this.zzaif.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbip[i]) {
                    j = Math.min(j, this.zzaif.valueAt(i).zzje());
                }
            }
        } else {
            j = zzje();
        }
        return j == Long.MIN_VALUE ? this.zzaip : j;
    }

    public final long zzen(long j) {
        if (!this.zzbil.zzfc()) {
            j = 0;
        }
        this.zzaip = j;
        int size = this.zzaif.size();
        boolean z = !zzfo();
        int i = 0;
        while (z && i < size) {
            if (this.zzain[i]) {
                z = this.zzaif.valueAt(i).zzh(j, false);
            }
            i++;
        }
        if (!z) {
            this.zzaiq = j;
            this.zzaiz = false;
            if (this.zzbif.isLoading()) {
                this.zzbif.zzgb();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzaif.valueAt(i2).zzk(this.zzain[i2]);
                }
            }
        }
        this.zzbin = false;
        return j;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbd(int i) {
        if (!this.zzaiz) {
            return !zzfo() && this.zzaif.valueAt(i).zzjk();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzjb() throws IOException {
        this.zzbif.zzbm(Integer.MIN_VALUE);
    }

    /* access modifiers changed from: package-private */
    public final int zza(int i, zzlj zzlj, zznd zznd, boolean z) {
        if (this.zzbin || zzfo()) {
            return -3;
        }
        return this.zzaif.valueAt(i).zza(zzlj, zznd, z, this.zzaiz, this.zzaip);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i, long j) {
        zzqt valueAt = this.zzaif.valueAt(i);
        if (!this.zzaiz || j <= valueAt.zzje()) {
            valueAt.zzh(j, true);
        } else {
            valueAt.zzjn();
        }
    }

    public final zznw zzd(int i, int i2) {
        zzqt zzqt = this.zzaif.get(i);
        if (zzqt != null) {
            return zzqt;
        }
        zzqt zzqt2 = new zzqt(this.zzbic);
        zzqt2.zza(this);
        this.zzaif.put(i, zzqt2);
        return zzqt2;
    }

    public final void zzfi() {
        this.zzaii = true;
        this.handler.post(this.zzbii);
    }

    public final void zza(zznu zznu) {
        this.zzbil = zznu;
        this.handler.post(this.zzbii);
    }

    public final void zzf(zzlh zzlh) {
        this.handler.post(this.zzbii);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public final void zzjc() {
        /*
            r8 = this;
            boolean r0 = r8.zzacf
            if (r0 != 0) goto L_0x009e
            boolean r0 = r8.zzacs
            if (r0 != 0) goto L_0x009e
            com.google.android.gms.internal.ads.zznu r0 = r8.zzbil
            if (r0 == 0) goto L_0x009e
            boolean r0 = r8.zzaii
            if (r0 != 0) goto L_0x0012
            goto L_0x009e
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzqt> r0 = r8.zzaif
            int r0 = r0.size()
            r1 = 0
            r2 = 0
        L_0x001a:
            if (r2 >= r0) goto L_0x002e
            android.util.SparseArray<com.google.android.gms.internal.ads.zzqt> r3 = r8.zzaif
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzqt r3 = (com.google.android.gms.internal.ads.zzqt) r3
            com.google.android.gms.internal.ads.zzlh r3 = r3.zzjl()
            if (r3 != 0) goto L_0x002b
            return
        L_0x002b:
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002e:
            com.google.android.gms.internal.ads.zzsm r2 = r8.zzbih
            r2.zzjy()
            com.google.android.gms.internal.ads.zzra[] r2 = new com.google.android.gms.internal.ads.zzra[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzbip = r3
            boolean[] r3 = new boolean[r0]
            r8.zzain = r3
            com.google.android.gms.internal.ads.zznu r3 = r8.zzbil
            long r3 = r3.getDurationUs()
            r8.zzack = r3
            r3 = 0
        L_0x0046:
            r4 = 1
            if (r3 >= r0) goto L_0x007c
            android.util.SparseArray<com.google.android.gms.internal.ads.zzqt> r5 = r8.zzaif
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzqt r5 = (com.google.android.gms.internal.ads.zzqt) r5
            com.google.android.gms.internal.ads.zzlh r5 = r5.zzjl()
            com.google.android.gms.internal.ads.zzra r6 = new com.google.android.gms.internal.ads.zzra
            com.google.android.gms.internal.ads.zzlh[] r7 = new com.google.android.gms.internal.ads.zzlh[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzatq
            boolean r6 = com.google.android.gms.internal.ads.zzsp.zzbf(r5)
            if (r6 != 0) goto L_0x0070
            boolean r5 = com.google.android.gms.internal.ads.zzsp.zzav(r5)
            if (r5 == 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r4 = 0
        L_0x0070:
            boolean[] r5 = r8.zzbip
            r5[r3] = r4
            boolean r5 = r8.zzbiq
            r4 = r4 | r5
            r8.zzbiq = r4
            int r3 = r3 + 1
            goto L_0x0046
        L_0x007c:
            com.google.android.gms.internal.ads.zzrb r0 = new com.google.android.gms.internal.ads.zzrb
            r0.<init>(r2)
            r8.zzbio = r0
            r8.zzacs = r4
            com.google.android.gms.internal.ads.zzqm r0 = r8.zzbib
            com.google.android.gms.internal.ads.zzqz r1 = new com.google.android.gms.internal.ads.zzqz
            long r2 = r8.zzack
            com.google.android.gms.internal.ads.zznu r4 = r8.zzbil
            boolean r4 = r4.zzfc()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zzb(r1, r2)
            com.google.android.gms.internal.ads.zzqk r0 = r8.zzbik
            r0.zza(r8)
            return
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpz.zzjc():void");
    }

    private final void zza(zzqe zzqe) {
        if (this.zzcd == -1) {
            this.zzcd = zzqe.zzcd;
        }
    }

    private final void startLoading() {
        zzqe zzqe = new zzqe(this, this.uri, this.zzazi, this.zzbig, this.zzbih);
        if (this.zzacs) {
            zzsk.checkState(zzfo());
            if (this.zzack == C1470C.TIME_UNSET || this.zzaiq < this.zzack) {
                zzqe.zzf(this.zzbil.zzdq(this.zzaiq), this.zzaiq);
                this.zzaiq = C1470C.TIME_UNSET;
            } else {
                this.zzaiz = true;
                this.zzaiq = C1470C.TIME_UNSET;
                return;
            }
        }
        this.zzbir = zzjd();
        int i = this.zzaig;
        if (i == -1) {
            i = (this.zzacs && this.zzcd == -1 && (this.zzbil == null || this.zzbil.getDurationUs() == C1470C.TIME_UNSET)) ? 6 : 3;
        }
        this.zzbif.zza(zzqe, this, i);
    }

    private final int zzjd() {
        int size = this.zzaif.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.zzaif.valueAt(i2).zzjj();
        }
        return i;
    }

    private final long zzje() {
        int size = this.zzaif.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.zzaif.valueAt(i).zzje());
        }
        return j;
    }

    private final boolean zzfo() {
        return this.zzaiq != C1470C.TIME_UNSET;
    }

    public final /* synthetic */ int zza(zzsh zzsh, long j, long j2, IOException iOException) {
        zzqe zzqe = (zzqe) zzsh;
        zza(zzqe);
        if (!(this.zzabq == null || this.zzbia == null)) {
            this.zzabq.post(new zzqd(this, iOException));
        }
        if (iOException instanceof zzrc) {
            return 3;
        }
        boolean z = zzjd() > this.zzbir;
        if (this.zzcd == -1 && (this.zzbil == null || this.zzbil.getDurationUs() == C1470C.TIME_UNSET)) {
            this.zzaip = 0;
            this.zzbin = this.zzacs;
            int size = this.zzaif.size();
            for (int i = 0; i < size; i++) {
                this.zzaif.valueAt(i).zzk(!this.zzacs || this.zzain[i]);
            }
            zzqe.zzf(0, 0);
        }
        this.zzbir = zzjd();
        return z ? 1 : 0;
    }

    public final /* synthetic */ void zza(zzsh zzsh, long j, long j2, boolean z) {
        zza((zzqe) zzsh);
        if (!z && this.zzaik > 0) {
            int size = this.zzaif.size();
            for (int i = 0; i < size; i++) {
                this.zzaif.valueAt(i).zzk(this.zzain[i]);
            }
            this.zzbik.zza(this);
        }
    }

    public final /* synthetic */ void zza(zzsh zzsh, long j, long j2) {
        zza((zzqe) zzsh);
        this.zzaiz = true;
        if (this.zzack == C1470C.TIME_UNSET) {
            long zzje = zzje();
            this.zzack = zzje == Long.MIN_VALUE ? 0 : zzje + 10000;
            this.zzbib.zzb(new zzqz(this.zzack, this.zzbil.zzfc()), (Object) null);
        }
        this.zzbik.zza(this);
    }
}
