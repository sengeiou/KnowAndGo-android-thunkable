package com.google.android.play.core.internal;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.play.core.splitcompat.C2083c;
import com.google.android.play.core.splitcompat.C2096p;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.C2127d;
import com.google.android.play.core.splitinstall.C2129f;
import com.google.android.play.core.splitinstall.model.SplitInstallErrorCode;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: com.google.android.play.core.internal.as */
public final class C1995as implements C2129f {

    /* renamed from: a */
    private final Context f753a;

    /* renamed from: b */
    private final C2083c f754b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C1996at f755c;

    /* renamed from: d */
    private final Executor f756d;

    /* renamed from: e */
    private final C2096p f757e;

    public C1995as(Context context, Executor executor, C1996at atVar, C2083c cVar, C2096p pVar) {
        this.f753a = context;
        this.f754b = cVar;
        this.f755c = atVar;
        this.f756d = executor;
        this.f757e = pVar;
    }

    @SplitInstallErrorCode
    @Nullable
    /* renamed from: a */
    private final Integer m619a(List<Intent> list) {
        FileChannel channel;
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        try {
            channel = new RandomAccessFile(this.f754b.mo33686b(), "rw").getChannel();
            Integer num = null;
            try {
                fileLock = channel.tryLock();
            } catch (OverlappingFileLockException unused) {
                fileLock = null;
            }
            if (fileLock != null) {
                int i = -11;
                try {
                    Log.i("SplitCompat", "Copying splits.");
                    for (Intent next : list) {
                        String stringExtra = next.getStringExtra("split_id");
                        AssetFileDescriptor openAssetFileDescriptor = this.f753a.getContentResolver().openAssetFileDescriptor(next.getData(), "r");
                        File a = this.f754b.mo33683a(stringExtra);
                        if (!a.exists() || a.length() == openAssetFileDescriptor.getLength()) {
                            if (a.exists()) {
                            }
                        }
                        if (!this.f754b.mo33687b(stringExtra).exists()) {
                            BufferedInputStream bufferedInputStream = new BufferedInputStream(openAssetFileDescriptor.createInputStream());
                            try {
                                fileOutputStream = new FileOutputStream(a);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = bufferedInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.close();
                                bufferedInputStream.close();
                            } catch (Throwable th) {
                                bufferedInputStream.close();
                                throw th;
                            }
                        }
                    }
                    Log.i("SplitCompat", "Splits copied.");
                    try {
                        if (!this.f755c.mo33567a()) {
                            Log.e("SplitCompat", "Split verification failed.");
                        } else {
                            Log.i("SplitCompat", "Splits verified.");
                            i = 0;
                        }
                    } catch (Exception e) {
                        Log.e("SplitCompat", "Error verifying splits.", e);
                    }
                } catch (Exception e2) {
                    Log.e("SplitCompat", "Error copying splits.", e2);
                    i = -13;
                } catch (Throwable th2) {
                    C2039ci.m739a(th, th2);
                }
                num = Integer.valueOf(i);
                fileLock.release();
            }
            if (channel != null) {
                channel.close();
            }
            return num;
            throw th;
            throw th;
        } catch (Exception e3) {
            Log.e("SplitCompat", "Error locking files.", e3);
            return -13;
        } catch (Throwable th3) {
            C2039ci.m739a(th, th3);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m620a(C1995as asVar, C2127d dVar) {
        try {
            if (!SplitCompat.m863a(C2096p.m907a(asVar.f753a))) {
                Log.e("SplitCompat", "Emulating splits failed.");
                dVar.mo33760a(-12);
                return;
            }
            Log.i("SplitCompat", "Splits installed.");
            dVar.mo33759a();
        } catch (Exception e) {
            Log.e("SplitCompat", "Error emulating splits.", e);
            dVar.mo33760a(-12);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m621a(C1995as asVar, List list, C2127d dVar) {
        Integer a = asVar.m619a((List<Intent>) list);
        if (a != null) {
            if (a.intValue() == 0) {
                dVar.mo33761b();
            } else {
                dVar.mo33760a(a.intValue());
            }
        }
    }

    /* renamed from: a */
    public final void mo33566a(List<Intent> list, C2127d dVar) {
        if (SplitCompat.m862a()) {
            this.f756d.execute(new C1994ar(this, list, dVar));
            return;
        }
        throw new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
    }
}
