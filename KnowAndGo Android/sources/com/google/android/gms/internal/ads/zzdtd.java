package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzdtd {
    public static final zzdtd zzhuc = new zzdtd(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdtd zzhud = new zzdtd(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdtd zzhue = new zzdtd(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzdtd zzhuf = new zzdtd(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a */
    private final double f176a;

    /* renamed from: b */
    private final double f177b;

    /* renamed from: c */
    private final double f178c;

    /* renamed from: d */
    private final double f179d;

    /* renamed from: w */
    private final double f180w;
    private final double zzhty;
    private final double zzhtz;
    private final double zzhua;
    private final double zzhub;

    private zzdtd(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.zzhty = d5;
        this.zzhtz = d6;
        this.f180w = d7;
        this.f176a = d;
        this.f177b = d2;
        this.f178c = d3;
        this.f179d = d4;
        this.zzhua = d8;
        this.zzhub = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzdtd zzdtd = (zzdtd) obj;
        return Double.compare(zzdtd.f176a, this.f176a) == 0 && Double.compare(zzdtd.f177b, this.f177b) == 0 && Double.compare(zzdtd.f178c, this.f178c) == 0 && Double.compare(zzdtd.f179d, this.f179d) == 0 && Double.compare(zzdtd.zzhua, this.zzhua) == 0 && Double.compare(zzdtd.zzhub, this.zzhub) == 0 && Double.compare(zzdtd.zzhty, this.zzhty) == 0 && Double.compare(zzdtd.zzhtz, this.zzhtz) == 0 && Double.compare(zzdtd.f180w, this.f180w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzhty);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzhtz);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f180w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f176a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f177b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f178c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f179d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzhua);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzhub);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) ((doubleToLongBits9 >>> 32) ^ doubleToLongBits9));
    }

    public final String toString() {
        if (equals(zzhuc)) {
            return "Rotate 0°";
        }
        if (equals(zzhud)) {
            return "Rotate 90°";
        }
        if (equals(zzhue)) {
            return "Rotate 180°";
        }
        if (equals(zzhuf)) {
            return "Rotate 270°";
        }
        double d = this.zzhty;
        double d2 = this.zzhtz;
        double d3 = this.f180w;
        double d4 = this.f176a;
        double d5 = this.f177b;
        double d6 = this.f178c;
        double d7 = this.f179d;
        double d8 = this.zzhua;
        double d9 = this.zzhub;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    public static zzdtd zzp(ByteBuffer byteBuffer) {
        double zzd = zzbc.zzd(byteBuffer);
        double zzd2 = zzbc.zzd(byteBuffer);
        double zze = zzbc.zze(byteBuffer);
        return new zzdtd(zzd, zzd2, zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer), zze, zzbc.zze(byteBuffer), zzbc.zze(byteBuffer), zzbc.zzd(byteBuffer), zzbc.zzd(byteBuffer));
    }
}
