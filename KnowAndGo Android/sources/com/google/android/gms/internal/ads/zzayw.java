package com.google.android.gms.internal.ads;

final class zzayw implements zzz {
    private final /* synthetic */ String zzdli;
    private final /* synthetic */ zzayz zzdxk;

    zzayw(zzayu zzayu, String str, zzayz zzayz) {
        this.zzdli = str;
        this.zzdxk = zzayz;
    }

    public final void zzd(zzaf zzaf) {
        String str = this.zzdli;
        String zzaf2 = zzaf.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(zzaf2).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(zzaf2);
        zzawz.zzep(sb.toString());
        this.zzdxk.zzb(null);
    }
}
