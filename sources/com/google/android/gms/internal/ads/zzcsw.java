package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcsw implements Callable {
    private final zzcsv zzghe;

    zzcsw(zzcsv zzcsv) {
        this.zzghe = zzcsv;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzcsv zzcsv = this.zzghe;
        zzk.zzlg();
        zzuu zzvk = zzk.zzlk().zzvc().zzvk();
        Bundle bundle = null;
        if (!(zzvk == null || zzvk == null || (zzk.zzlk().zzvc().zzvl() && zzk.zzlk().zzvc().zzvn()))) {
            if (zzvk.zzmz()) {
                zzvk.wakeup();
            }
            zzuo zzmx = zzvk.zzmx();
            if (zzmx != null) {
                str2 = zzmx.zzmm();
                str = zzmx.zzmn();
                str3 = zzmx.zzmo();
                if (str2 != null) {
                    zzk.zzlk().zzvc().zzdt(str2);
                }
                if (str3 != null) {
                    zzk.zzlk().zzvc().zzdu(str3);
                }
            } else {
                str2 = zzk.zzlk().zzvc().zzvm();
                str3 = zzk.zzlk().zzvc().zzvo();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (str3 != null && !zzk.zzlk().zzvc().zzvn()) {
                bundle2.putString("v_fp_vertical", str3);
            }
            if (str2 != null && !zzk.zzlk().zzvc().zzvl()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzcsu(bundle);
    }
}
