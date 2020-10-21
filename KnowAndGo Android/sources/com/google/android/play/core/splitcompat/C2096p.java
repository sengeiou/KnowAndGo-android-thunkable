package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.util.Base64;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* renamed from: com.google.android.play.core.splitcompat.p */
public final class C2096p {
    @Nullable

    /* renamed from: a */
    private static ThreadPoolExecutor f850a;

    /* renamed from: a */
    public static Context m907a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }

    /* renamed from: a */
    public static String m908a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
            instance.update(bArr);
            return Base64.encodeToString(instance.digest(), 11);
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static Executor m909a() {
        if (f850a == null) {
            f850a = new ThreadPoolExecutor(1, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), new C2082b());
            f850a.allowCoreThreadTimeOut(true);
        }
        return f850a;
    }
}
