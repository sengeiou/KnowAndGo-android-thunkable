package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.List;
import p022fi.iki.elonen.NanoHTTPD;

@zzard
public final class zzayb {
    private Handler handler;
    private int state;
    private String zzbsx;
    private String zzchk;
    private String zzdks;
    @Nullable
    private String zzdod;
    private int zzdwe;
    private PointF zzdwf;
    private PointF zzdwg;
    private Runnable zzdwh;
    private final Context zzlj;

    public zzayb(Context context) {
        this.state = 0;
        this.zzdwh = new zzayc(this);
        this.zzlj = context;
        this.zzdwe = ViewConfiguration.get(context).getScaledTouchSlop();
        zzk.zzlu().zzwr();
        this.handler = zzk.zzlu().getHandler();
    }

    public zzayb(Context context, String str) {
        this(context);
        this.zzdks = str;
    }

    public final void zzd(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int historySize = motionEvent.getHistorySize();
        int pointerCount = motionEvent.getPointerCount();
        if (actionMasked == 0) {
            this.state = 0;
            this.zzdwf = new PointF(motionEvent.getX(0), motionEvent.getY(0));
        } else if (this.state != -1) {
            boolean z = true;
            if (this.state == 0 && actionMasked == 5) {
                this.state = 5;
                this.zzdwg = new PointF(motionEvent.getX(1), motionEvent.getY(1));
                this.handler.postDelayed(this.zzdwh, ((Long) zzyt.zzpe().zzd(zzacu.zzcua)).longValue());
            } else if (this.state == 5) {
                if (pointerCount == 2) {
                    if (actionMasked == 2) {
                        boolean z2 = false;
                        for (int i = 0; i < historySize; i++) {
                            if (!zza(motionEvent.getHistoricalX(0, i), motionEvent.getHistoricalY(0, i), motionEvent.getHistoricalX(1, i), motionEvent.getHistoricalY(1, i))) {
                                z2 = true;
                            }
                        }
                        if (zza(motionEvent.getX(), motionEvent.getY(), motionEvent.getX(1), motionEvent.getY(1))) {
                            z = z2;
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    this.state = -1;
                    this.handler.removeCallbacks(this.zzdwh);
                }
            }
        }
    }

    private final boolean zza(float f, float f2, float f3, float f4) {
        return Math.abs(this.zzdwf.x - f) < ((float) this.zzdwe) && Math.abs(this.zzdwf.y - f2) < ((float) this.zzdwe) && Math.abs(this.zzdwg.x - f3) < ((float) this.zzdwe) && Math.abs(this.zzdwg.y - f4) < ((float) this.zzdwe);
    }

    public final void showDialog() {
        try {
            if (!(this.zzlj instanceof Activity)) {
                zzawz.zzeo("Can not create dialog without Activity Context");
                return;
            }
            String str = !TextUtils.isEmpty(zzk.zzlq().zzwn()) ? "Creative Preview (Enabled)" : "Creative Preview";
            String str2 = zzk.zzlq().zzwo() ? "Troubleshooting (Enabled)" : "Troubleshooting";
            ArrayList arrayList = new ArrayList();
            int zza = zza((List<String>) arrayList, "Ad Information", true);
            int zza2 = zza((List<String>) arrayList, str, true);
            int zza3 = zza((List<String>) arrayList, str2, true);
            AlertDialog.Builder builder = new AlertDialog.Builder(this.zzlj, zzk.zzli().zzwi());
            builder.setTitle("Select a Debug Mode").setItems((CharSequence[]) arrayList.toArray(new String[0]), new zzayd(this, zza, zza2, zza3));
            builder.create().show();
        } catch (WindowManager.BadTokenException e) {
            zzawz.zza("", e);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzchk = str;
    }

    public final void zzp(String str) {
        this.zzbsx = str;
    }

    public final void zzee(String str) {
        this.zzdks = str;
    }

    public final void zzef(String str) {
        this.zzdod = str;
    }

    private static int zza(List<String> list, String str, boolean z) {
        list.add(str);
        return list.size() - 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("{Dialog: ");
        sb.append(this.zzdks);
        sb.append(",DebugSignal: ");
        sb.append(this.zzdod);
        sb.append(",AFMA Version: ");
        sb.append(this.zzbsx);
        sb.append(",Ad Unit ID: ");
        sb.append(this.zzchk);
        sb.append("}");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzwk() {
        zzk.zzlq().zza(this.zzlj, this.zzchk, this.zzbsx, this.zzdod);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzwl() {
        zzk.zzlq().zze(this.zzlj, this.zzchk, this.zzbsx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str, DialogInterface dialogInterface, int i) {
        zzk.zzlg();
        zzaxi.zza(this.zzlj, Intent.createChooser(new Intent("android.intent.action.SEND").setType(NanoHTTPD.MIME_PLAINTEXT).putExtra("android.intent.extra.TEXT", str), "Share via"));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x006e, code lost:
        if (android.text.TextUtils.isEmpty(r1) == false) goto L_0x0073;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(int r1, int r2, int r3, android.content.DialogInterface r4, int r5) {
        /*
            r0 = this;
            if (r5 != r1) goto L_0x009b
            android.content.Context r1 = r0.zzlj
            boolean r1 = r1 instanceof android.app.Activity
            if (r1 != 0) goto L_0x000e
            java.lang.String r1 = "Can not create dialog without Activity Context"
            com.google.android.gms.internal.ads.zzawz.zzeo(r1)
            return
        L_0x000e:
            java.lang.String r1 = r0.zzdks
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0071
            java.lang.String r2 = "\\+"
            java.lang.String r3 = "%20"
            java.lang.String r1 = r1.replaceAll(r2, r3)
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r1 = r2.encodedQuery(r1)
            android.net.Uri r1 = r1.build()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.ads.internal.zzk.zzlg()
            java.util.Map r1 = com.google.android.gms.internal.ads.zzaxi.zzi((android.net.Uri) r1)
            java.util.Set r3 = r1.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x003f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0062
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r5 = " = "
            r2.append(r5)
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            r2.append(r4)
            java.lang.String r4 = "\n\n"
            r2.append(r4)
            goto L_0x003f
        L_0x0062:
            java.lang.String r1 = r2.toString()
            java.lang.String r1 = r1.trim()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            java.lang.String r1 = "No debug information"
        L_0x0073:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r3 = r0.zzlj
            r2.<init>(r3)
            r2.setMessage(r1)
            java.lang.String r3 = "Ad Information"
            r2.setTitle(r3)
            java.lang.String r3 = "Share"
            com.google.android.gms.internal.ads.zzaye r4 = new com.google.android.gms.internal.ads.zzaye
            r4.<init>(r0, r1)
            r2.setPositiveButton(r3, r4)
            java.lang.String r1 = "Close"
            android.content.DialogInterface$OnClickListener r3 = com.google.android.gms.internal.ads.zzayf.zzdwm
            r2.setNegativeButton(r1, r3)
            android.app.AlertDialog r1 = r2.create()
            r1.show()
            return
        L_0x009b:
            if (r5 != r2) goto L_0x00ab
            java.lang.String r1 = "Debug mode [Creative Preview] selected."
            com.google.android.gms.internal.ads.zzawz.zzdp(r1)
            com.google.android.gms.internal.ads.zzayg r1 = new com.google.android.gms.internal.ads.zzayg
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.zzc(r1)
            return
        L_0x00ab:
            if (r5 != r3) goto L_0x00ba
            java.lang.String r1 = "Debug mode [Troubleshooting] selected."
            com.google.android.gms.internal.ads.zzawz.zzdp(r1)
            com.google.android.gms.internal.ads.zzayh r1 = new com.google.android.gms.internal.ads.zzayh
            r1.<init>(r0)
            com.google.android.gms.internal.ads.zzaxg.zzc(r1)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayb.zza(int, int, int, android.content.DialogInterface, int):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzwm() {
        this.state = 4;
        showDialog();
    }
}
