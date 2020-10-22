package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

final class zzci {
    private static boolean zznj = false;
    /* access modifiers changed from: private */
    public static MessageDigest zznk;
    private static final Object zznl = new Object();
    private static final Object zznm = new Object();
    static CountDownLatch zznn = new CountDownLatch(1);

    static void zzcb() {
        synchronized (zznm) {
            if (!zznj) {
                zznj = true;
                new Thread(new zzck()).start();
            }
        }
    }

    private static MessageDigest zzcc() {
        boolean z;
        zzcb();
        try {
            z = zznn.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && zznk != null) {
            return zznk;
        }
        return null;
    }

    static String zzj(zzbp.zza zza, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArr;
        byte[] byteArray = zza.toByteArray();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcrm)).booleanValue()) {
            Vector<byte[]> zza2 = zza(byteArray, 255);
            if (zza2 == null || zza2.size() == 0) {
                bArr = zza(zza(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray(), str, true);
            } else {
                zzbp.zzg.zza zzbk = zzbp.zzg.zzbk();
                Iterator<byte[]> it = zza2.iterator();
                while (it.hasNext()) {
                    zzbk.zzn(zzdmr.zzz(zza(it.next(), str, false)));
                }
                zzbk.zzo(zzdmr.zzz(zzb(byteArray)));
                bArr = ((zzbp.zzg) ((zzdob) zzbk.zzaya())).toByteArray();
            }
        } else if (zzed.zzya != null) {
            bArr = ((zzbp.zzg) ((zzdob) zzbp.zzg.zzbk().zzn(zzdmr.zzz(zzed.zzya.zzc(byteArray, str != null ? str.getBytes() : new byte[0]))).zzb(zzbw.TINK_HYBRID).zzaya())).toByteArray();
        } else {
            throw new GeneralSecurityException();
        }
        return zzcg.zza(bArr, true);
    }

    private static Vector<byte[]> zza(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i3, bArr.length - i3 > 255 ? i3 + 255 : bArr.length));
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static zzbp.zza zza(zzbp.zza.zzd zzd) {
        zzbp.zza.C4378zza zzam = zzbp.zza.zzam();
        zzam.zzau((long) zzd.zzac());
        return (zzbp.zza) ((zzdob) zzam.zzaya());
    }

    private static byte[] zza(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArr2;
        int i = z ? 239 : 255;
        if (bArr.length > i) {
            bArr = zza(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).toByteArray();
        }
        if (bArr.length < i) {
            byte[] bArr3 = new byte[(i - bArr.length)];
            new SecureRandom().nextBytes(bArr3);
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).put(bArr3).array();
        } else {
            bArr2 = ByteBuffer.allocate(i + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            bArr2 = ByteBuffer.allocate(256).put(zzb(bArr2)).put(bArr2).array();
        }
        byte[] bArr4 = new byte[256];
        for (zzcn zza : new zzcl().zzvb) {
            zza.zza(bArr2, bArr4);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdmh(str.getBytes("UTF-8")).zzy(bArr4);
        }
        return bArr4;
    }

    public static byte[] zzb(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (zznl) {
            MessageDigest zzcc = zzcc();
            if (zzcc != null) {
                zzcc.reset();
                zzcc.update(bArr);
                digest = zznk.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    static String zza(String str, String str2, boolean z) {
        byte[] zzb = zzb(str, str2, true);
        if (zzb != null) {
            return zzcg.zza(zzb, true);
        }
        return Integer.toString(7);
    }

    private static byte[] zzb(String str, String str2, boolean z) {
        byte[] bArr;
        zzbp.zzc.zza zzaw = zzbp.zzc.zzaw();
        try {
            if (str.length() < 3) {
                bArr = str.getBytes("ISO-8859-1");
            } else {
                bArr = zzcg.zza(str, true);
            }
            zzaw.zzc(zzdmr.zzz(bArr));
            zzaw.zzd(zzdmr.zzz(str2.length() < 3 ? str2.getBytes("ISO-8859-1") : zzcg.zza(str2, true)));
            return ((zzbp.zzc) ((zzdob) zzaw.zzaya())).toByteArray();
        } catch (UnsupportedEncodingException | GeneralSecurityException unused) {
            return null;
        }
    }
}
