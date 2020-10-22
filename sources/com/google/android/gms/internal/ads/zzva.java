package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@ParametersAreNonnullByDefault
@zzard
public abstract class zzva {
    @Nullable
    private static MessageDigest zzbvv;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbl(String str);

    /* access modifiers changed from: protected */
    @Nullable
    public final MessageDigest zznf() {
        synchronized (this.mLock) {
            if (zzbvv != null) {
                MessageDigest messageDigest = zzbvv;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbvv = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbvv;
            return messageDigest2;
        }
    }
}
