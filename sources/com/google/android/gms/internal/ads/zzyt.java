package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

@zzard
public final class zzyt {
    private static zzyt zzcid = new zzyt();
    private final zzazt zzcie;
    private final zzyh zzcif;
    private final String zzcig;
    private final zzacp zzcih;
    private final zzacq zzcii;
    private final zzacr zzcij;
    private final zzbai zzcik;
    private final Random zzcil;
    private final WeakHashMap<Object, String> zzcim;

    protected zzyt() {
        this(new zzazt(), new zzyh(new zzxx(), new zzxw(), new zzabk(), new zzagk(), new zzatf(), new zzauj(), new zzaqf(), new zzagl()), new zzacp(), new zzacq(), new zzacr(), zzazt.zzwz(), new zzbai(0, 15000000, true), new Random(), new WeakHashMap());
    }

    private zzyt(zzazt zzazt, zzyh zzyh, zzacp zzacp, zzacq zzacq, zzacr zzacr, String str, zzbai zzbai, Random random, WeakHashMap<Object, String> weakHashMap) {
        this.zzcie = zzazt;
        this.zzcif = zzyh;
        this.zzcih = zzacp;
        this.zzcii = zzacq;
        this.zzcij = zzacr;
        this.zzcig = str;
        this.zzcik = zzbai;
        this.zzcil = random;
        this.zzcim = weakHashMap;
    }

    public static zzazt zzpa() {
        return zzcid.zzcie;
    }

    public static zzyh zzpb() {
        return zzcid.zzcif;
    }

    public static zzacq zzpc() {
        return zzcid.zzcii;
    }

    public static zzacp zzpd() {
        return zzcid.zzcih;
    }

    public static zzacr zzpe() {
        return zzcid.zzcij;
    }

    public static String zzpf() {
        return zzcid.zzcig;
    }

    public static zzbai zzpg() {
        return zzcid.zzcik;
    }

    public static Random zzph() {
        return zzcid.zzcil;
    }
}
