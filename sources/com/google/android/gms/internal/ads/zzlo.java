package com.google.android.gms.internal.ads;

import java.io.IOException;

public interface zzlo extends zzkx {
    void disable();

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws zzku;

    void stop() throws zzku;

    void zza(zzlq zzlq, zzlh[] zzlhArr, zzqw zzqw, long j, boolean z, long j2) throws zzku;

    void zza(zzlh[] zzlhArr, zzqw zzqw, long j) throws zzku;

    void zzc(long j, long j2) throws zzku;

    void zzdx(long j) throws zzku;

    boolean zzdx();

    zzlp zzgi();

    zzso zzgj();

    zzqw zzgk();

    boolean zzgl();

    void zzgm();

    boolean zzgn();

    void zzgo() throws IOException;
}
