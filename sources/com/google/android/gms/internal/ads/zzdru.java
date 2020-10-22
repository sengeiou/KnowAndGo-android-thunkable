package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class zzdru implements Cloneable {
    private Object value;
    private zzdrs<?, ?> zzhnu;
    private List<Object> zzhnv = new ArrayList();

    zzdru() {
    }

    /* access modifiers changed from: package-private */
    public final int zzor() {
        if (this.value == null) {
            Iterator<Object> it = this.zzhnv.iterator();
            if (!it.hasNext()) {
                return 0;
            }
            it.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdrp zzdrp) throws IOException {
        if (this.value == null) {
            Iterator<Object> it = this.zzhnv.iterator();
            if (it.hasNext()) {
                it.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdru)) {
            return false;
        }
        zzdru zzdru = (zzdru) obj;
        if (this.value == null || zzdru.value == null) {
            if (this.zzhnv != null && zzdru.zzhnv != null) {
                return this.zzhnv.equals(zzdru.zzhnv);
            }
            try {
                return Arrays.equals(toByteArray(), zzdru.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzhnu != zzdru.zzhnu) {
            return false;
        } else {
            if (!this.zzhnu.zzhnp.isArray()) {
                return this.value.equals(zzdru.value);
            }
            if (this.value instanceof byte[]) {
                return Arrays.equals((byte[]) this.value, (byte[]) zzdru.value);
            }
            if (this.value instanceof int[]) {
                return Arrays.equals((int[]) this.value, (int[]) zzdru.value);
            }
            if (this.value instanceof long[]) {
                return Arrays.equals((long[]) this.value, (long[]) zzdru.value);
            }
            if (this.value instanceof float[]) {
                return Arrays.equals((float[]) this.value, (float[]) zzdru.value);
            }
            if (this.value instanceof double[]) {
                return Arrays.equals((double[]) this.value, (double[]) zzdru.value);
            }
            if (this.value instanceof boolean[]) {
                return Arrays.equals((boolean[]) this.value, (boolean[]) zzdru.value);
            }
            return Arrays.deepEquals((Object[]) this.value, (Object[]) zzdru.value);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzor()];
        zza(zzdrp.zzaf(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbam */
    public final zzdru clone() {
        zzdru zzdru = new zzdru();
        try {
            zzdru.zzhnu = this.zzhnu;
            if (this.zzhnv == null) {
                zzdru.zzhnv = null;
            } else {
                zzdru.zzhnv.addAll(this.zzhnv);
            }
            if (this.value != null) {
                if (this.value instanceof zzdrw) {
                    zzdru.value = (zzdrw) ((zzdrw) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzdru.value = ((byte[]) this.value).clone();
                } else {
                    int i = 0;
                    if (this.value instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.value;
                        byte[][] bArr2 = new byte[bArr.length][];
                        zzdru.value = bArr2;
                        while (i < bArr.length) {
                            bArr2[i] = (byte[]) bArr[i].clone();
                            i++;
                        }
                    } else if (this.value instanceof boolean[]) {
                        zzdru.value = ((boolean[]) this.value).clone();
                    } else if (this.value instanceof int[]) {
                        zzdru.value = ((int[]) this.value).clone();
                    } else if (this.value instanceof long[]) {
                        zzdru.value = ((long[]) this.value).clone();
                    } else if (this.value instanceof float[]) {
                        zzdru.value = ((float[]) this.value).clone();
                    } else if (this.value instanceof double[]) {
                        zzdru.value = ((double[]) this.value).clone();
                    } else if (this.value instanceof zzdrw[]) {
                        zzdrw[] zzdrwArr = (zzdrw[]) this.value;
                        zzdrw[] zzdrwArr2 = new zzdrw[zzdrwArr.length];
                        zzdru.value = zzdrwArr2;
                        while (i < zzdrwArr.length) {
                            zzdrwArr2[i] = (zzdrw) zzdrwArr[i].clone();
                            i++;
                        }
                    }
                }
            }
            return zzdru;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
