package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.c */
final class C2030c implements C2003b {

    /* renamed from: a */
    private final FileChannel f766a;

    /* renamed from: b */
    private final long f767b;

    /* renamed from: c */
    private final long f768c;

    public C2030c(FileChannel fileChannel, long j, long j2) {
        this.f766a = fileChannel;
        this.f767b = j;
        this.f768c = j2;
    }

    /* renamed from: a */
    public final long mo33542a() {
        return this.f768c;
    }

    /* renamed from: a */
    public final void mo33543a(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f766a.map(FileChannel.MapMode.READ_ONLY, this.f767b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
