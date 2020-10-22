package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

@zzard
public final class zzaqa extends zzaqb implements zzaho<zzbgz> {
    private float density;
    private int rotation;
    private final WindowManager zzbtf;
    private final zzbgz zzdbs;
    private final zzacf zzdiv;
    private DisplayMetrics zzdiw;
    private int zzdix = -1;
    private int zzdiy = -1;
    private int zzdiz = -1;
    private int zzdja = -1;
    private int zzdjb = -1;
    private int zzdjc = -1;
    private final Context zzlj;

    public zzaqa(zzbgz zzbgz, Context context, zzacf zzacf) {
        super(zzbgz);
        this.zzdbs = zzbgz;
        this.zzlj = context;
        this.zzdiv = zzacf;
        this.zzbtf = (WindowManager) context.getSystemService("window");
    }

    public final void zzj(int i, int i2) {
        int i3 = 0;
        if (this.zzlj instanceof Activity) {
            i3 = zzk.zzlg().zzf((Activity) this.zzlj)[0];
        }
        if (this.zzdbs.zzaag() == null || !this.zzdbs.zzaag().zzabx()) {
            this.zzdjb = zzyt.zzpa().zzb(this.zzlj, this.zzdbs.getWidth());
            this.zzdjc = zzyt.zzpa().zzb(this.zzlj, this.zzdbs.getHeight());
        }
        zzb(i, i2 - i3, this.zzdjb, this.zzdjc);
        this.zzdbs.zzaai().zzi(i, i2);
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        this.zzdiw = new DisplayMetrics();
        Display defaultDisplay = this.zzbtf.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzdiw);
        this.density = this.zzdiw.density;
        this.rotation = defaultDisplay.getRotation();
        zzyt.zzpa();
        this.zzdix = zzazt.zzb(this.zzdiw, this.zzdiw.widthPixels);
        zzyt.zzpa();
        this.zzdiy = zzazt.zzb(this.zzdiw, this.zzdiw.heightPixels);
        Activity zzyd = this.zzdbs.zzyd();
        if (zzyd == null || zzyd.getWindow() == null) {
            this.zzdiz = this.zzdix;
            this.zzdja = this.zzdiy;
        } else {
            zzk.zzlg();
            int[] zzd = zzaxi.zzd(zzyd);
            zzyt.zzpa();
            this.zzdiz = zzazt.zzb(this.zzdiw, zzd[0]);
            zzyt.zzpa();
            this.zzdja = zzazt.zzb(this.zzdiw, zzd[1]);
        }
        if (this.zzdbs.zzaag().zzabx()) {
            this.zzdjb = this.zzdix;
            this.zzdjc = this.zzdiy;
        } else {
            this.zzdbs.measure(0, 0);
        }
        zza(this.zzdix, this.zzdiy, this.zzdiz, this.zzdja, this.density, this.rotation);
        this.zzdbs.zza("onDeviceFeaturesReceived", new zzapx(new zzapz().zzy(this.zzdiv.zzqi()).zzx(this.zzdiv.zzqj()).zzz(this.zzdiv.zzql()).zzaa(this.zzdiv.zzqk()).zzab(true)).toJson());
        int[] iArr = new int[2];
        this.zzdbs.getLocationOnScreen(iArr);
        zzj(zzyt.zzpa().zzb(this.zzlj, iArr[0]), zzyt.zzpa().zzb(this.zzlj, iArr[1]));
        if (zzawz.isLoggable(2)) {
            zzawz.zzeo("Dispatching Ready Event.");
        }
        zzdi(this.zzdbs.zzyh().zzbsx);
    }
}
