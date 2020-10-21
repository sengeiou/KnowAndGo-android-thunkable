package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class zzdsu implements zzbe, Closeable, Iterator<zzbd> {
    private static zzdtc zzcp = zzdtc.zzm(zzdsu.class);
    private static final zzbd zzhtq = new zzdsv("eof ");
    long zzbdz = 0;
    long zzbkn = 0;
    protected zzdsw zzhtn;
    protected zzba zzhtr;
    private zzbd zzhts = null;
    long zzhtt = 0;
    private List<zzbd> zzhtu = new ArrayList();

    public final List<zzbd> zzbbd() {
        if (this.zzhtn == null || this.zzhts == zzhtq) {
            return this.zzhtu;
        }
        return new zzdta(this.zzhtu, this);
    }

    public void zza(zzdsw zzdsw, long j, zzba zzba) throws IOException {
        this.zzhtn = zzdsw;
        long position = zzdsw.position();
        this.zzbkn = position;
        this.zzhtt = position;
        zzdsw.zzff(zzdsw.position() + j);
        this.zzbdz = zzdsw.position();
        this.zzhtr = zzba;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        if (this.zzhts == zzhtq) {
            return false;
        }
        if (this.zzhts != null) {
            return true;
        }
        try {
            this.zzhts = (zzbd) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzhts = zzhtq;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbbe */
    public final zzbd next() {
        zzbd zza;
        if (this.zzhts != null && this.zzhts != zzhtq) {
            zzbd zzbd = this.zzhts;
            this.zzhts = null;
            return zzbd;
        } else if (this.zzhtn == null || this.zzhtt >= this.zzbdz) {
            this.zzhts = zzhtq;
            throw new NoSuchElementException();
        } else {
            try {
                synchronized (this.zzhtn) {
                    this.zzhtn.zzff(this.zzhtt);
                    zza = this.zzhtr.zza(this.zzhtn, this);
                    this.zzhtt = this.zzhtn.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        for (int i = 0; i < this.zzhtu.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzhtu.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }

    public void close() throws IOException {
        this.zzhtn.close();
    }
}
