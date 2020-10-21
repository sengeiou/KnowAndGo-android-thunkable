package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.TimeUnit;

@zzard
public final class zzbdg {
    private final zzbai zzdld;
    private final String zzdlx;
    @Nullable
    private final zzadi zzebv;
    private boolean zzebz;
    @Nullable
    private final zzadg zzeem;
    private final zzayq zzeen = new zzayt().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzwq();
    private final long[] zzeeo;
    private final String[] zzeep;
    private boolean zzeeq = false;
    private boolean zzeer = false;
    private boolean zzees = false;
    private boolean zzeet = false;
    private zzbco zzeeu;
    private boolean zzeev;
    private boolean zzeew;
    private long zzeex = -1;
    private final Context zzlj;

    public zzbdg(Context context, zzbai zzbai, String str, @Nullable zzadi zzadi, @Nullable zzadg zzadg) {
        this.zzlj = context;
        this.zzdld = zzbai;
        this.zzdlx = str;
        this.zzebv = zzadi;
        this.zzeem = zzadg;
        String str2 = (String) zzyt.zzpe().zzd(zzacu.zzcmb);
        if (str2 == null) {
            this.zzeep = new String[0];
            this.zzeeo = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzeep = new String[split.length];
        this.zzeeo = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzeeo[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzawz.zzd("Unable to parse frame hash target time number.", e);
                this.zzeeo[i] = -1;
            }
        }
    }

    public final void zzb(zzbco zzbco) {
        zzadb.zza(this.zzebv, this.zzeem, "vpc2");
        this.zzeeq = true;
        if (this.zzebv != null) {
            this.zzebv.zzh("vpn", zzbco.zzxg());
        }
        this.zzeeu = zzbco;
    }

    public final void zzhd() {
        if (this.zzeeq && !this.zzeer) {
            zzadb.zza(this.zzebv, this.zzeem, "vfr2");
            this.zzeer = true;
        }
    }

    public final void onStop() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcma)).booleanValue() && !this.zzeev) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzdlx);
            bundle.putString("player", this.zzeeu.zzxg());
            for (zzays next : this.zzeen.zzwp()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(next.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(next.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(next.zzdxd));
            }
            for (int i = 0; i < this.zzeeo.length; i++) {
                String str = this.zzeep[i];
                if (str != null) {
                    String valueOf5 = String.valueOf(Long.valueOf(this.zzeeo[i]));
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf5).length() + 3);
                    sb.append("fh_");
                    sb.append(valueOf5);
                    bundle.putString(sb.toString(), str);
                }
            }
            zzk.zzlg().zza(this.zzlj, this.zzdld.zzbsx, "gmob-apps", bundle, true);
            this.zzeev = true;
        }
    }

    public final void zzc(zzbco zzbco) {
        if (this.zzees && !this.zzeet) {
            if (zzawz.zzvj() && !this.zzeet) {
                zzawz.zzds("VideoMetricsMixin first frame");
            }
            zzadb.zza(this.zzebv, this.zzeem, "vff2");
            this.zzeet = true;
        }
        long nanoTime = zzk.zzln().nanoTime();
        if (this.zzebz && this.zzeew && this.zzeex != -1) {
            this.zzeen.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzeex)));
        }
        this.zzeew = this.zzebz;
        this.zzeex = nanoTime;
        long longValue = ((Long) zzyt.zzpe().zzd(zzacu.zzcmc)).longValue();
        long currentPosition = (long) zzbco.getCurrentPosition();
        int i = 0;
        while (i < this.zzeep.length) {
            if (this.zzeep[i] != null || longValue <= Math.abs(currentPosition - this.zzeeo[i])) {
                zzbco zzbco2 = zzbco;
                i++;
            } else {
                String[] strArr = this.zzeep;
                int i2 = 8;
                Bitmap bitmap = zzbco.getBitmap(8, 8);
                long j = 63;
                int i3 = 0;
                long j2 = 0;
                while (i3 < i2) {
                    long j3 = j;
                    long j4 = j2;
                    int i4 = 0;
                    while (i4 < i2) {
                        int pixel = bitmap.getPixel(i4, i3);
                        j4 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1 : 0) << ((int) j3);
                        i4++;
                        j3--;
                        i2 = 8;
                    }
                    i3++;
                    j2 = j4;
                    i2 = 8;
                    j = j3;
                }
                strArr[i] = String.format("%016X", new Object[]{Long.valueOf(j2)});
                return;
            }
        }
    }

    public final void zzyl() {
        this.zzebz = true;
        if (this.zzeer && !this.zzees) {
            zzadb.zza(this.zzebv, this.zzeem, "vfp2");
            this.zzees = true;
        }
    }

    public final void zzym() {
        this.zzebz = false;
    }
}
