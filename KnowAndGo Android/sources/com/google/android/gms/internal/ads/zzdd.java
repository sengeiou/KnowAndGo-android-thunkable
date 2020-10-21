package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzbk;
import com.google.android.gms.internal.ads.zzbp;
import java.util.LinkedList;

public abstract class zzdd implements zzdc {
    protected static volatile zzdy zzvd;
    protected MotionEvent zzvj;
    protected LinkedList<MotionEvent> zzvk = new LinkedList<>();
    protected long zzvl = 0;
    protected long zzvm = 0;
    protected long zzvn = 0;
    protected long zzvo = 0;
    protected long zzvp = 0;
    protected long zzvq = 0;
    protected long zzvr = 0;
    protected double zzvs;
    private double zzvt;
    private double zzvu;
    protected float zzvv;
    protected float zzvw;
    protected float zzvx;
    protected float zzvy;
    private boolean zzvz = false;
    protected boolean zzwa = false;
    protected DisplayMetrics zzwb;

    protected zzdd(Context context) {
        try {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrm)).booleanValue()) {
                zzci.zzcb();
            } else {
                zzed.zzb(zzvd);
            }
            this.zzwb = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzdv;

    /* access modifiers changed from: protected */
    public abstract zzbp.zza.C4378zza zza(Context context, View view, Activity activity);

    /* access modifiers changed from: protected */
    public abstract zzbp.zza.C4378zza zza(Context context, zzbk.zza zza);

    /* access modifiers changed from: protected */
    public abstract zzee zzb(MotionEvent motionEvent) throws zzdv;

    public void zzb(View view) {
    }

    public final String zza(Context context) {
        if (zzef.isMainThread()) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcro)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, (String) null, false, (View) null, (Activity) null, (byte[]) null);
    }

    public final String zza(Context context, byte[] bArr) {
        if (zzef.isMainThread()) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcro)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return zza(context, (String) null, false, (View) null, (Activity) null, bArr);
    }

    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, (Activity) null);
    }

    public final String zza(Context context, String str, View view, Activity activity) {
        return zza(context, str, true, view, activity, (byte[]) null);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.view.MotionEvent r13) {
        /*
            r12 = this;
            boolean r0 = r12.zzvz
            r1 = 0
            if (r0 == 0) goto L_0x0035
            r2 = 0
            r12.zzvo = r2
            r12.zzvn = r2
            r12.zzvm = r2
            r12.zzvl = r2
            r12.zzvp = r2
            r12.zzvr = r2
            r12.zzvq = r2
            java.util.LinkedList<android.view.MotionEvent> r0 = r12.zzvk
            java.util.Iterator r0 = r0.iterator()
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r0.next()
            android.view.MotionEvent r2 = (android.view.MotionEvent) r2
            r2.recycle()
            goto L_0x001b
        L_0x002b:
            java.util.LinkedList<android.view.MotionEvent> r0 = r12.zzvk
            r0.clear()
            r0 = 0
            r12.zzvj = r0
            r12.zzvz = r1
        L_0x0035:
            int r0 = r13.getAction()
            switch(r0) {
                case 0: goto L_0x0062;
                case 1: goto L_0x003d;
                case 2: goto L_0x003d;
                default: goto L_0x003c;
            }
        L_0x003c:
            goto L_0x0074
        L_0x003d:
            float r0 = r13.getRawX()
            double r2 = (double) r0
            float r0 = r13.getRawY()
            double r4 = (double) r0
            double r6 = r12.zzvt
            double r6 = r2 - r6
            double r8 = r12.zzvu
            double r8 = r4 - r8
            double r10 = r12.zzvs
            double r6 = r6 * r6
            double r8 = r8 * r8
            double r6 = r6 + r8
            double r6 = java.lang.Math.sqrt(r6)
            double r10 = r10 + r6
            r12.zzvs = r10
            r12.zzvt = r2
            r12.zzvu = r4
            goto L_0x0074
        L_0x0062:
            r2 = 0
            r12.zzvs = r2
            float r0 = r13.getRawX()
            double r2 = (double) r0
            r12.zzvt = r2
            float r0 = r13.getRawY()
            double r2 = (double) r0
            r12.zzvu = r2
        L_0x0074:
            int r0 = r13.getAction()
            r2 = 1
            r4 = 1
            switch(r0) {
                case 0: goto L_0x0113;
                case 1: goto L_0x00dd;
                case 2: goto L_0x0087;
                case 3: goto L_0x0080;
                default: goto L_0x007e;
            }
        L_0x007e:
            goto L_0x0130
        L_0x0080:
            long r0 = r12.zzvo
            long r0 = r0 + r2
            r12.zzvo = r0
            goto L_0x0130
        L_0x0087:
            long r2 = r12.zzvm
            int r0 = r13.getHistorySize()
            int r0 = r0 + r4
            long r5 = (long) r0
            long r2 = r2 + r5
            r12.zzvm = r2
            com.google.android.gms.internal.ads.zzee r13 = r12.zzb((android.view.MotionEvent) r13)     // Catch:{ zzdv -> 0x0130 }
            if (r13 == 0) goto L_0x00a2
            java.lang.Long r0 = r13.zzye     // Catch:{ zzdv -> 0x0130 }
            if (r0 == 0) goto L_0x00a2
            java.lang.Long r0 = r13.zzyh     // Catch:{ zzdv -> 0x0130 }
            if (r0 == 0) goto L_0x00a2
            r0 = 1
            goto L_0x00a3
        L_0x00a2:
            r0 = 0
        L_0x00a3:
            if (r0 == 0) goto L_0x00b8
            long r2 = r12.zzvq     // Catch:{ zzdv -> 0x0130 }
            java.lang.Long r0 = r13.zzye     // Catch:{ zzdv -> 0x0130 }
            long r5 = r0.longValue()     // Catch:{ zzdv -> 0x0130 }
            java.lang.Long r0 = r13.zzyh     // Catch:{ zzdv -> 0x0130 }
            long r7 = r0.longValue()     // Catch:{ zzdv -> 0x0130 }
            r0 = 0
            long r5 = r5 + r7
            long r2 = r2 + r5
            r12.zzvq = r2     // Catch:{ zzdv -> 0x0130 }
        L_0x00b8:
            android.util.DisplayMetrics r0 = r12.zzwb     // Catch:{ zzdv -> 0x0130 }
            if (r0 == 0) goto L_0x00c7
            if (r13 == 0) goto L_0x00c7
            java.lang.Long r0 = r13.zzyf     // Catch:{ zzdv -> 0x0130 }
            if (r0 == 0) goto L_0x00c7
            java.lang.Long r0 = r13.zzyi     // Catch:{ zzdv -> 0x0130 }
            if (r0 == 0) goto L_0x00c7
            r1 = 1
        L_0x00c7:
            if (r1 == 0) goto L_0x0130
            long r0 = r12.zzvr     // Catch:{ zzdv -> 0x0130 }
            java.lang.Long r2 = r13.zzyf     // Catch:{ zzdv -> 0x0130 }
            long r2 = r2.longValue()     // Catch:{ zzdv -> 0x0130 }
            java.lang.Long r13 = r13.zzyi     // Catch:{ zzdv -> 0x0130 }
            long r5 = r13.longValue()     // Catch:{ zzdv -> 0x0130 }
            r13 = 0
            long r2 = r2 + r5
            long r0 = r0 + r2
            r12.zzvr = r0     // Catch:{ zzdv -> 0x0130 }
            goto L_0x0130
        L_0x00dd:
            android.view.MotionEvent r13 = android.view.MotionEvent.obtain(r13)
            r12.zzvj = r13
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzvk
            android.view.MotionEvent r0 = r12.zzvj
            r13.add(r0)
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzvk
            int r13 = r13.size()
            r0 = 6
            if (r13 <= r0) goto L_0x00fe
            java.util.LinkedList<android.view.MotionEvent> r13 = r12.zzvk
            java.lang.Object r13 = r13.remove()
            android.view.MotionEvent r13 = (android.view.MotionEvent) r13
            r13.recycle()
        L_0x00fe:
            long r0 = r12.zzvn
            long r0 = r0 + r2
            r12.zzvn = r0
            java.lang.Throwable r13 = new java.lang.Throwable     // Catch:{ zzdv -> 0x0130 }
            r13.<init>()     // Catch:{ zzdv -> 0x0130 }
            java.lang.StackTraceElement[] r13 = r13.getStackTrace()     // Catch:{ zzdv -> 0x0130 }
            long r0 = r12.zza((java.lang.StackTraceElement[]) r13)     // Catch:{ zzdv -> 0x0130 }
            r12.zzvp = r0     // Catch:{ zzdv -> 0x0130 }
            goto L_0x0130
        L_0x0113:
            float r0 = r13.getX()
            r12.zzvv = r0
            float r0 = r13.getY()
            r12.zzvw = r0
            float r0 = r13.getRawX()
            r12.zzvx = r0
            float r13 = r13.getRawY()
            r12.zzvy = r13
            long r0 = r12.zzvl
            long r0 = r0 + r2
            r12.zzvl = r0
        L_0x0130:
            r12.zzwa = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zza(android.view.MotionEvent):void");
    }

    public final void zza(int i, int i2, int i3) {
        if (this.zzvj != null) {
            this.zzvj.recycle();
        }
        if (this.zzwb != null) {
            this.zzvj = MotionEvent.obtain(0, (long) i3, 1, this.zzwb.density * ((float) i), this.zzwb.density * ((float) i2), 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.zzvj = null;
        }
        this.zzwa = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0035 A[SYNTHETIC, Splitter:B:16:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0044 A[SYNTHETIC, Splitter:B:25:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b A[Catch:{ Exception -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0077 A[SYNTHETIC, Splitter:B:40:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zza(android.content.Context r10, java.lang.String r11, boolean r12, android.view.View r13, android.app.Activity r14, byte[] r15) {
        /*
            r9 = this;
            r0 = 0
            if (r15 == 0) goto L_0x000f
            int r1 = r15.length
            if (r1 <= 0) goto L_0x000f
            com.google.android.gms.internal.ads.zzdno r1 = com.google.android.gms.internal.ads.zzdno.zzaxe()     // Catch:{ zzdok -> 0x000f }
            com.google.android.gms.internal.ads.zzbk$zza r15 = com.google.android.gms.internal.ads.zzbk.zza.zza(r15, r1)     // Catch:{ zzdok -> 0x000f }
            goto L_0x0010
        L_0x000f:
            r15 = r0
        L_0x0010:
            com.google.android.gms.internal.ads.zzdy r1 = zzvd
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzacj<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzacu.zzcrc
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.zzpe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzdy r1 = zzvd
            com.google.android.gms.internal.ads.zzda r1 = r1.zzcm()
            goto L_0x002e
        L_0x002d:
            r1 = r0
        L_0x002e:
            long r2 = java.lang.System.currentTimeMillis()
            r8 = -1
            if (r12 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzbp$zza$zza r10 = r9.zza((android.content.Context) r10, (android.view.View) r13, (android.app.Activity) r14)     // Catch:{ Exception -> 0x0041 }
            r13 = 1
            r9.zzvz = r13     // Catch:{ Exception -> 0x003d }
            goto L_0x0048
        L_0x003d:
            r13 = move-exception
            r0 = r10
            r7 = r13
            goto L_0x005c
        L_0x0041:
            r10 = move-exception
            r7 = r10
            goto L_0x005c
        L_0x0044:
            com.google.android.gms.internal.ads.zzbp$zza$zza r10 = r9.zza((android.content.Context) r10, (com.google.android.gms.internal.ads.zzbk.zza) r15)     // Catch:{ Exception -> 0x0041 }
        L_0x0048:
            r0 = r10
            if (r1 == 0) goto L_0x0071
            if (r12 == 0) goto L_0x0050
            r10 = 1002(0x3ea, float:1.404E-42)
            goto L_0x0052
        L_0x0050:
            r10 = 1000(0x3e8, float:1.401E-42)
        L_0x0052:
            long r13 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0041 }
            r15 = 0
            long r13 = r13 - r2
            r1.zza(r10, r8, r13)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0071
        L_0x005c:
            if (r1 == 0) goto L_0x0071
            if (r12 == 0) goto L_0x0063
            r10 = 1003(0x3eb, float:1.406E-42)
            goto L_0x0065
        L_0x0063:
            r10 = 1001(0x3e9, float:1.403E-42)
        L_0x0065:
            r4 = -1
            long r13 = java.lang.System.currentTimeMillis()
            long r5 = r13 - r2
            r2 = r1
            r3 = r10
            r2.zza(r3, r4, r5, r7)
        L_0x0071:
            long r13 = java.lang.System.currentTimeMillis()
            if (r0 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzdpk r10 = r0.zzaya()     // Catch:{ Exception -> 0x00a5 }
            com.google.android.gms.internal.ads.zzdob r10 = (com.google.android.gms.internal.ads.zzdob) r10     // Catch:{ Exception -> 0x00a5 }
            com.google.android.gms.internal.ads.zzbp$zza r10 = (com.google.android.gms.internal.ads.zzbp.zza) r10     // Catch:{ Exception -> 0x00a5 }
            int r10 = r10.zzaxj()     // Catch:{ Exception -> 0x00a5 }
            if (r10 != 0) goto L_0x0086
            goto L_0x00a8
        L_0x0086:
            com.google.android.gms.internal.ads.zzdpk r10 = r0.zzaya()     // Catch:{ Exception -> 0x00a5 }
            com.google.android.gms.internal.ads.zzdob r10 = (com.google.android.gms.internal.ads.zzdob) r10     // Catch:{ Exception -> 0x00a5 }
            com.google.android.gms.internal.ads.zzbp$zza r10 = (com.google.android.gms.internal.ads.zzbp.zza) r10     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r10 = com.google.android.gms.internal.ads.zzci.zzj(r10, r11)     // Catch:{ Exception -> 0x00a5 }
            if (r1 == 0) goto L_0x00cb
            if (r12 == 0) goto L_0x0099
            r11 = 1006(0x3ee, float:1.41E-42)
            goto L_0x009b
        L_0x0099:
            r11 = 1004(0x3ec, float:1.407E-42)
        L_0x009b:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a5 }
            r15 = 0
            long r2 = r2 - r13
            r1.zza(r11, r8, r2)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00cb
        L_0x00a5:
            r10 = move-exception
            r7 = r10
            goto L_0x00ae
        L_0x00a8:
            r10 = 5
            java.lang.String r10 = java.lang.Integer.toString(r10)     // Catch:{ Exception -> 0x00a5 }
            goto L_0x00cb
        L_0x00ae:
            r10 = 7
            java.lang.String r10 = java.lang.Integer.toString(r10)
            if (r1 == 0) goto L_0x00cb
            if (r12 == 0) goto L_0x00bc
            r11 = 1007(0x3ef, float:1.411E-42)
            r3 = 1007(0x3ef, float:1.411E-42)
            goto L_0x00c0
        L_0x00bc:
            r11 = 1005(0x3ed, float:1.408E-42)
            r3 = 1005(0x3ed, float:1.408E-42)
        L_0x00c0:
            r4 = -1
            long r11 = java.lang.System.currentTimeMillis()
            long r5 = r11 - r13
            r2 = r1
            r2.zza(r3, r4, r5, r7)
        L_0x00cb:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdd.zza(android.content.Context, java.lang.String, boolean, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }
}
