package com.google.android.gms.internal.ads;

import android.os.Environment;
import android.util.Base64;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzwl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@zzard
public final class zzwj {
    private final zzwo zzbxk;
    @GuardedBy("this")
    private final zzxn zzbxl;
    private final boolean zzbxm;

    public static zzwj zznl() {
        return new zzwj();
    }

    public zzwj(zzwo zzwo) {
        this.zzbxk = zzwo;
        this.zzbxm = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue();
        this.zzbxl = new zzxn();
        zznm();
    }

    private zzwj() {
        this.zzbxm = false;
        this.zzbxk = new zzwo();
        this.zzbxl = new zzxn();
        zznm();
    }

    public final synchronized void zza(zzwl.zza.zzb zzb) {
        if (this.zzbxm) {
            if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcum)).booleanValue()) {
                zzc(zzb);
            } else {
                zzb(zzb);
            }
        }
    }

    private final synchronized void zzb(zzwl.zza.zzb zzb) {
        this.zzbxl.zzcfh = zznn();
        this.zzbxk.zzg(zzdrw.zza((zzdrw) this.zzbxl)).zzby(zzb.zzac()).zzdj();
        String valueOf = String.valueOf(Integer.toString(zzb.zzac(), 10));
        zzawz.zzds(valueOf.length() != 0 ? "Logging Event with event code : ".concat(valueOf) : new String("Logging Event with event code : "));
    }

    private final synchronized void zzc(zzwl.zza.zzb zzb) {
        FileOutputStream fileOutputStream;
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            try {
                fileOutputStream = new FileOutputStream(new File(externalStorageDirectory, "clearcut_events.txt"), true);
                try {
                    fileOutputStream.write(zzd(zzb).getBytes());
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                        zzawz.zzds("Could not close Clearcut output stream.");
                    }
                } catch (IOException unused2) {
                    zzawz.zzds("Could not write Clearcut to file.");
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused3) {
                        zzawz.zzds("Could not close Clearcut output stream.");
                    }
                }
            } catch (FileNotFoundException unused4) {
                zzawz.zzds("Could not find file for Clearcut");
            } catch (Throwable th) {
                try {
                    fileOutputStream.close();
                } catch (IOException unused5) {
                    zzawz.zzds("Could not close Clearcut output stream.");
                }
                throw th;
            }
        }
    }

    private final synchronized String zzd(zzwl.zza.zzb zzb) {
        return String.format("id=%s,timestamp=%s,event=%s,data=%s\n", new Object[]{this.zzbxl.zzcfd, Long.valueOf(zzk.zzln().elapsedRealtime()), Integer.valueOf(zzb.zzac()), Base64.encodeToString(zzdrw.zza((zzdrw) this.zzbxl), 3)});
    }

    public final synchronized void zza(zzwk zzwk) {
        if (this.zzbxm) {
            try {
                zzwk.zza(this.zzbxl);
            } catch (NullPointerException e) {
                zzk.zzlk().zza(e, "AdMobClearcutLogger.modify");
            }
        }
    }

    private final synchronized void zznm() {
        this.zzbxl.zzcfl = new zzxj();
        this.zzbxl.zzcfl.zzceh = new zzxk();
        this.zzbxl.zzcfi = new zzxl();
    }

    private static long[] zznn() {
        int i;
        List<String> zzqo = zzacu.zzqo();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = zzqo.iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            String[] split = it.next().split(",");
            int length = split.length;
            while (i < length) {
                try {
                    arrayList.add(Long.valueOf(split[i]));
                } catch (NumberFormatException unused) {
                    zzawz.zzds("Experiment ID is not a number");
                }
                i++;
            }
        }
        long[] jArr = new long[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            jArr[i2] = ((Long) obj).longValue();
            i2++;
        }
        return jArr;
    }
}
