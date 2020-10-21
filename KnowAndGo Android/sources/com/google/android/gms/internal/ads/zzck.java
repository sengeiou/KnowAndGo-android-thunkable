package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

final class zzck implements Runnable {
    private zzck() {
    }

    public final void run() {
        try {
            MessageDigest unused = zzci.zznk = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            zzci.zznn.countDown();
        }
    }
}
