package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

@zzard
public abstract class zzacj<T> {
    private final String zzcc;
    private final int zzckg;
    private final T zzckh;

    private zzacj(int i, String str, T t) {
        this.zzckg = i;
        this.zzcc = str;
        this.zzckh = t;
        zzyt.zzpd().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract T zza(JSONObject jSONObject);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    public final String getKey() {
        return this.zzcc;
    }

    public final T zzqm() {
        return this.zzckh;
    }

    public static zzacj<Boolean> zza(int i, String str, Boolean bool) {
        return new zzack(i, str, bool);
    }

    public static zzacj<Integer> zza(int i, String str, int i2) {
        return new zzacl(i, str, Integer.valueOf(i2));
    }

    public static zzacj<Long> zza(int i, String str, long j) {
        return new zzacm(i, str, Long.valueOf(j));
    }

    public static zzacj<Float> zza(int i, String str, float f) {
        return new zzacn(i, str, Float.valueOf(f));
    }

    public static zzacj<String> zza(int i, String str, String str2) {
        return new zzaco(i, str, str2);
    }

    public static zzacj<String> zzb(int i, String str) {
        zzacj<String> zza = zza(i, str, (String) null);
        zzyt.zzpd().zzb(zza);
        return zza;
    }

    public static zzacj<String> zzc(int i, String str) {
        zzacj<String> zza = zza(i, str, (String) null);
        zzyt.zzpd().zzc(zza);
        return zza;
    }

    public final int getSource() {
        return this.zzckg;
    }

    /* synthetic */ zzacj(int i, String str, Object obj, zzack zzack) {
        this(i, str, obj);
    }
}
