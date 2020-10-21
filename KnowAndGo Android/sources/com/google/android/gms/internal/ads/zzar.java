package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzar {
    private final int zzcf;
    private final List<zzl> zzcg;
    private final int zzch;
    private final InputStream zzci;

    public zzar(int i, List<zzl> list) {
        this(i, list, -1, (InputStream) null);
    }

    public zzar(int i, List<zzl> list, int i2, InputStream inputStream) {
        this.zzcf = i;
        this.zzcg = list;
        this.zzch = i2;
        this.zzci = inputStream;
    }

    public final int getStatusCode() {
        return this.zzcf;
    }

    public final List<zzl> zzq() {
        return Collections.unmodifiableList(this.zzcg);
    }

    public final int getContentLength() {
        return this.zzch;
    }

    public final InputStream getContent() {
        return this.zzci;
    }
}
