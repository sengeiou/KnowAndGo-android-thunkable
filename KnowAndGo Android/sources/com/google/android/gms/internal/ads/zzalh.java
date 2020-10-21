package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

@zzard
public final class zzalh implements zzajq, zzalg {
    private final zzalf zzddc;
    private final HashSet<AbstractMap.SimpleEntry<String, zzaho<? super zzalf>>> zzddd = new HashSet<>();

    public zzalh(zzalf zzalf) {
        this.zzddc = zzalf;
    }

    public final void zza(String str, Map map) {
        zzajr.zza((zzajq) this, str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zza((zzajq) this, str, jSONObject);
    }

    public final void zzi(String str, String str2) {
        zzajr.zza((zzajq) this, str, str2);
    }

    public final void zzco(String str) {
        this.zzddc.zzco(str);
    }

    public final void zza(String str, zzaho<? super zzalf> zzaho) {
        this.zzddc.zza(str, zzaho);
        this.zzddd.add(new AbstractMap.SimpleEntry(str, zzaho));
    }

    public final void zzb(String str, zzaho<? super zzalf> zzaho) {
        this.zzddc.zzb(str, zzaho);
        this.zzddd.remove(new AbstractMap.SimpleEntry(str, zzaho));
    }

    public final void zzsb() {
        Iterator<AbstractMap.SimpleEntry<String, zzaho<? super zzalf>>> it = this.zzddd.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry next = it.next();
            String valueOf = String.valueOf(((zzaho) next.getValue()).toString());
            zzawz.zzds(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzddc.zzb((String) next.getKey(), (zzaho) next.getValue());
        }
        this.zzddd.clear();
    }
}
