package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

@zzard
public final class zzacp {
    private final Collection<zzacj<?>> zzcki = new ArrayList();
    private final Collection<zzacj<String>> zzckj = new ArrayList();
    private final Collection<zzacj<String>> zzckk = new ArrayList();

    public final void zza(zzacj zzacj) {
        this.zzcki.add(zzacj);
    }

    public final void zzb(zzacj<String> zzacj) {
        this.zzckj.add(zzacj);
    }

    public final void zzc(zzacj<String> zzacj) {
        this.zzckk.add(zzacj);
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzacj next : this.zzcki) {
            if (next.getSource() == 1) {
                next.zza(editor, next.zza(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbad.zzen("Flag Json is null.");
        }
    }

    public final List<String> zzqn() {
        ArrayList arrayList = new ArrayList();
        for (zzacj<String> zzd : this.zzckj) {
            String str = (String) zzyt.zzpe().zzd(zzd);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> zzqo() {
        List<String> zzqn = zzqn();
        for (zzacj<String> zzd : this.zzckk) {
            String str = (String) zzyt.zzpe().zzd(zzd);
            if (str != null) {
                zzqn.add(str);
            }
        }
        return zzqn;
    }
}
