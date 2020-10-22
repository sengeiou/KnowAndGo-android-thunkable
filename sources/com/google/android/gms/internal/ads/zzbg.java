package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import java.nio.ByteBuffer;
import java.util.Date;
import kotlin.UByte;

public final class zzbg extends zzdst {
    private Date zzcq;
    private Date zzcr;
    private long zzcs;
    private long zzct;
    private double zzcu = 1.0d;
    private float zzcv = 1.0f;
    private zzdtd zzcw = zzdtd.zzhuc;
    private long zzcx;
    private int zzcy;
    private int zzcz;
    private int zzda;
    private int zzdb;
    private int zzdc;
    private int zzdd;

    public zzbg() {
        super("mvhd");
    }

    public final long zzr() {
        return this.zzcs;
    }

    public final long getDuration() {
        return this.zzct;
    }

    public final void zzg(ByteBuffer byteBuffer) {
        zzo(byteBuffer);
        if (getVersion() == 1) {
            this.zzcq = zzdsy.zzfx(zzbc.zzc(byteBuffer));
            this.zzcr = zzdsy.zzfx(zzbc.zzc(byteBuffer));
            this.zzcs = zzbc.zza(byteBuffer);
            this.zzct = zzbc.zzc(byteBuffer);
        } else {
            this.zzcq = zzdsy.zzfx(zzbc.zza(byteBuffer));
            this.zzcr = zzdsy.zzfx(zzbc.zza(byteBuffer));
            this.zzcs = zzbc.zza(byteBuffer);
            this.zzct = zzbc.zza(byteBuffer);
        }
        this.zzcu = zzbc.zzd(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzcv = ((float) ((short) ((bArr[1] & UByte.MAX_VALUE) | ((short) (0 | ((bArr[0] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK)))))) / 256.0f;
        zzbc.zzb(byteBuffer);
        zzbc.zza(byteBuffer);
        zzbc.zza(byteBuffer);
        this.zzcw = zzdtd.zzp(byteBuffer);
        this.zzcy = byteBuffer.getInt();
        this.zzcz = byteBuffer.getInt();
        this.zzda = byteBuffer.getInt();
        this.zzdb = byteBuffer.getInt();
        this.zzdc = byteBuffer.getInt();
        this.zzdd = byteBuffer.getInt();
        this.zzcx = zzbc.zza(byteBuffer);
    }

    public final String toString() {
        return "MovieHeaderBox[" + "creationTime=" + this.zzcq + ";" + "modificationTime=" + this.zzcr + ";" + "timescale=" + this.zzcs + ";" + "duration=" + this.zzct + ";" + "rate=" + this.zzcu + ";" + "volume=" + this.zzcv + ";" + "matrix=" + this.zzcw + ";" + "nextTrackId=" + this.zzcx + "]";
    }
}
