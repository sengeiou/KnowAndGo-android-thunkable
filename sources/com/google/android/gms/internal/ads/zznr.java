package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzpo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zznr {
    private static final zzpu zzazn = new zzns();
    private static final Pattern zzazo = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zzaty = -1;
    public int zzatz = -1;

    public final boolean zzb(zzpo zzpo) {
        for (int i = 0; i < zzpo.length(); i++) {
            zzpo.zza zzbc = zzpo.zzbc(i);
            if (zzbc instanceof zzps) {
                zzps zzps = (zzps) zzbc;
                if (zzd(zzps.description, zzps.zzbhy)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean zzd(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = zzazo.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.zzaty = parseInt;
                    this.zzatz = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public final boolean zzii() {
        return (this.zzaty == -1 || this.zzatz == -1) ? false : true;
    }
}
