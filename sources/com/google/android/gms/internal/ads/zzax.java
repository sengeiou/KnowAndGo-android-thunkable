package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;

public class zzax extends zzr<String> {
    private final Object mLock = new Object();
    @GuardedBy("mLock")
    @Nullable
    private zzaa<String> zzcm;

    public zzax(int i, String str, zzaa<String> zzaa, @Nullable zzz zzz) {
        super(i, str, zzz);
        this.zzcm = zzaa;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzh */
    public void zza(String str) {
        zzaa<String> zzaa;
        synchronized (this.mLock) {
            zzaa = this.zzcm;
        }
        if (zzaa != null) {
            zzaa.zzb(str);
        }
    }

    /* access modifiers changed from: protected */
    public final zzy<String> zza(zzp zzp) {
        String str;
        try {
            byte[] bArr = zzp.data;
            String str2 = "ISO-8859-1";
            String str3 = zzp.zzab.get("Content-Type");
            if (str3 != null) {
                String[] split = str3.split(";", 0);
                int i = 1;
                while (true) {
                    if (i >= split.length) {
                        break;
                    }
                    String[] split2 = split[i].trim().split("=", 0);
                    if (split2.length == 2 && split2[0].equals("charset")) {
                        str2 = split2[1];
                        break;
                    }
                    i++;
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzp.data);
        }
        return zzy.zza(str, zzaq.zzb(zzp));
    }
}
