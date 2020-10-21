package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzbcq extends FrameLayout implements zzbcn {
    private final zzbdf zzebt;
    private final FrameLayout zzebu;
    private final zzadi zzebv;
    private final zzbdh zzebw;
    private final long zzebx;
    @Nullable
    private zzbco zzeby;
    private boolean zzebz;
    private boolean zzeca;
    private boolean zzecb;
    private boolean zzecc;
    private long zzecd;
    private long zzece;
    private String zzecf;
    private String[] zzecg;
    private Bitmap zzech;
    private ImageView zzeci;
    private boolean zzecj;

    public static void zzb(zzbdf zzbdf) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
        zzbdf.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzbdf zzbdf, Map<String, List<Map<String, Object>>> map) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("mimeTypes", map);
        zzbdf.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    public static void zza(zzbdf zzbdf, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
        hashMap.put("error", str);
        zzbdf.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbcq(Context context, zzbdf zzbdf, int i, boolean z, zzadi zzadi, zzbde zzbde) {
        super(context);
        Context context2 = context;
        zzbdf zzbdf2 = zzbdf;
        this.zzebt = zzbdf2;
        zzadi zzadi2 = zzadi;
        this.zzebv = zzadi2;
        this.zzebu = new FrameLayout(context);
        addView(this.zzebu, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbdf.zzye());
        this.zzeby = zzbdf.zzye().zzbqs.zza(context, zzbdf2, i, z, zzadi2, zzbde);
        if (this.zzeby != null) {
            this.zzebu.addView(this.zzeby, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcmd)).booleanValue()) {
                zzxs();
            }
        }
        this.zzeci = new ImageView(context);
        this.zzebx = ((Long) zzyt.zzpe().zzd(zzacu.zzcmh)).longValue();
        this.zzecc = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcmf)).booleanValue();
        if (this.zzebv != null) {
            this.zzebv.zzh("spinner_used", this.zzecc ? "1" : "0");
        }
        this.zzebw = new zzbdh(this);
        if (this.zzeby != null) {
            this.zzeby.zza(this);
        }
        if (this.zzeby == null) {
            zzl("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
            layoutParams.setMargins(i, i2, 0, 0);
            this.zzebu.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public final void zzc(String str, String[] strArr) {
        this.zzecf = str;
        this.zzecg = strArr;
    }

    public final void zza(float f, float f2) {
        if (this.zzeby != null) {
            this.zzeby.zza(f, f2);
        }
    }

    public final void zzfr() {
        if (this.zzeby != null) {
            if (!TextUtils.isEmpty(this.zzecf)) {
                this.zzeby.zzb(this.zzecf, this.zzecg);
            } else {
                zzd("no_src", new String[0]);
            }
        }
    }

    public final void pause() {
        if (this.zzeby != null) {
            this.zzeby.pause();
        }
    }

    public final void play() {
        if (this.zzeby != null) {
            this.zzeby.play();
        }
    }

    public final void seekTo(int i) {
        if (this.zzeby != null) {
            this.zzeby.seekTo(i);
        }
    }

    public final void zzxq() {
        if (this.zzeby != null) {
            zzbco zzbco = this.zzeby;
            zzbco.zzebs.setMuted(true);
            zzbco.zzxk();
        }
    }

    public final void zzxr() {
        if (this.zzeby != null) {
            zzbco zzbco = this.zzeby;
            zzbco.zzebs.setMuted(false);
            zzbco.zzxk();
        }
    }

    public final void setVolume(float f) {
        if (this.zzeby != null) {
            zzbco zzbco = this.zzeby;
            zzbco.zzebs.setVolume(f);
            zzbco.zzxk();
        }
    }

    public final void zzcy(int i) {
        this.zzeby.zzcy(i);
    }

    public final void zzcz(int i) {
        this.zzeby.zzcz(i);
    }

    public final void zzda(int i) {
        this.zzeby.zzda(i);
    }

    public final void zzdb(int i) {
        this.zzeby.zzdb(i);
    }

    public final void zzdc(int i) {
        this.zzeby.zzdc(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        if (this.zzeby != null) {
            this.zzeby.dispatchTouchEvent(motionEvent);
        }
    }

    @TargetApi(14)
    public final void zzxs() {
        if (this.zzeby != null) {
            TextView textView = new TextView(this.zzeby.getContext());
            String valueOf = String.valueOf(this.zzeby.zzxg());
            textView.setText(valueOf.length() != 0 ? "AdMob - ".concat(valueOf) : new String("AdMob - "));
            textView.setTextColor(SupportMenu.CATEGORY_MASK);
            textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
            this.zzebu.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
            this.zzebu.bringChildToFront(textView);
        }
    }

    public final void zzxl() {
        this.zzebw.resume();
        zzaxi.zzdvv.post(new zzbct(this));
    }

    public final void zzhd() {
        if (this.zzeby != null && this.zzece == 0) {
            zzd("canplaythrough", "duration", String.valueOf(((float) this.zzeby.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzeby.getVideoWidth()), "videoHeight", String.valueOf(this.zzeby.getVideoHeight()));
        }
    }

    public final void zzxm() {
        if (this.zzebt.zzyd() != null && !this.zzeca) {
            this.zzecb = (this.zzebt.zzyd().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzecb) {
                this.zzebt.zzyd().getWindow().addFlags(128);
                this.zzeca = true;
            }
        }
        this.zzebz = true;
    }

    public final void onPaused() {
        zzd("pause", new String[0]);
        zzxv();
        this.zzebz = false;
    }

    public final void zzxn() {
        zzd("ended", new String[0]);
        zzxv();
    }

    public final void zzl(String str, @Nullable String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    public final void zzxo() {
        if (this.zzecj && this.zzech != null && !zzxu()) {
            this.zzeci.setImageBitmap(this.zzech);
            this.zzeci.invalidate();
            this.zzebu.addView(this.zzeci, new FrameLayout.LayoutParams(-1, -1));
            this.zzebu.bringChildToFront(this.zzeci);
        }
        this.zzebw.pause();
        this.zzece = this.zzecd;
        zzaxi.zzdvv.post(new zzbcu(this));
    }

    public final void destroy() {
        this.zzebw.pause();
        if (this.zzeby != null) {
            this.zzeby.stop();
        }
        zzxv();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzebw.pause();
            if (this.zzeby != null) {
                zzbco zzbco = this.zzeby;
                Executor executor = zzbbm.zzeae;
                zzbco.getClass();
                executor.execute(zzbcr.zza(zzbco));
            }
        } finally {
            super.finalize();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzxt() {
        if (this.zzeby != null) {
            long currentPosition = (long) this.zzeby.getCurrentPosition();
            if (this.zzecd != currentPosition && currentPosition > 0) {
                zzd("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
                this.zzecd = currentPosition;
            }
        }
    }

    public final void zzxp() {
        if (this.zzebz && zzxu()) {
            this.zzebu.removeView(this.zzeci);
        }
        if (this.zzech != null) {
            long elapsedRealtime = zzk.zzln().elapsedRealtime();
            if (this.zzeby.getBitmap(this.zzech) != null) {
                this.zzecj = true;
            }
            long elapsedRealtime2 = zzk.zzln().elapsedRealtime() - elapsedRealtime;
            if (zzawz.zzvj()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(elapsedRealtime2);
                sb.append("ms");
                zzawz.zzds(sb.toString());
            }
            if (elapsedRealtime2 > this.zzebx) {
                zzawz.zzep("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzecc = false;
                this.zzech = null;
                if (this.zzebv != null) {
                    this.zzebv.zzh("spinner_jank", Long.toString(elapsedRealtime2));
                }
            }
        }
    }

    public final void zzk(int i, int i2) {
        if (this.zzecc) {
            int max = Math.max(i / ((Integer) zzyt.zzpe().zzd(zzacu.zzcmg)).intValue(), 1);
            int max2 = Math.max(i2 / ((Integer) zzyt.zzpe().zzd(zzacu.zzcmg)).intValue(), 1);
            if (this.zzech == null || this.zzech.getWidth() != max || this.zzech.getHeight() != max2) {
                this.zzech = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.zzecj = false;
            }
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzebw.resume();
        } else {
            this.zzebw.pause();
            this.zzece = this.zzecd;
        }
        zzaxi.zzdvv.post(new zzbcs(this, z));
    }

    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzebw.resume();
            z = true;
        } else {
            this.zzebw.pause();
            this.zzece = this.zzecd;
            z = false;
        }
        zzaxi.zzdvv.post(new zzbcv(this, z));
    }

    private final boolean zzxu() {
        return this.zzeci.getParent() != null;
    }

    /* access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                hashMap.put(str2, str3);
                str2 = null;
            }
        }
        this.zzebt.zza("onVideoEvent", (Map<String, ?>) hashMap);
    }

    private final void zzxv() {
        if (this.zzebt.zzyd() != null && this.zzeca && !this.zzecb) {
            this.zzebt.zzyd().getWindow().clearFlags(128);
            this.zzeca = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzan(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }
}
