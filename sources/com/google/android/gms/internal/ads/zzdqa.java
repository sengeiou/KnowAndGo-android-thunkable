package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzdqa {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzdqb<T> zzdqb, zzdno zzdno) throws IOException;

    <T> void zza(List<T> list, zzdqb<T> zzdqb, zzdno zzdno) throws IOException;

    <K, V> void zza(Map<K, V> map, zzdpd<K, V> zzdpd, zzdno zzdno) throws IOException;

    long zzavv() throws IOException;

    long zzavw() throws IOException;

    int zzavx() throws IOException;

    long zzavy() throws IOException;

    int zzavz() throws IOException;

    boolean zzawa() throws IOException;

    String zzawb() throws IOException;

    zzdmr zzawc() throws IOException;

    int zzawd() throws IOException;

    int zzawe() throws IOException;

    int zzawf() throws IOException;

    long zzawg() throws IOException;

    int zzawh() throws IOException;

    long zzawi() throws IOException;

    int zzaws() throws IOException;

    boolean zzawt() throws IOException;

    @Deprecated
    <T> T zzb(zzdqb<T> zzdqb, zzdno zzdno) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzdqb<T> zzdqb, zzdno zzdno) throws IOException;

    void zzi(List<Double> list) throws IOException;

    void zzj(List<Float> list) throws IOException;

    void zzk(List<Long> list) throws IOException;

    void zzl(List<Long> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Long> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Boolean> list) throws IOException;

    void zzq(List<String> list) throws IOException;

    void zzr(List<zzdmr> list) throws IOException;

    void zzs(List<Integer> list) throws IOException;

    void zzt(List<Integer> list) throws IOException;

    void zzu(List<Integer> list) throws IOException;

    void zzv(List<Long> list) throws IOException;

    void zzw(List<Integer> list) throws IOException;

    void zzx(List<Long> list) throws IOException;
}
