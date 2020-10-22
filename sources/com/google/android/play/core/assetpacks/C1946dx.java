package com.google.android.play.core.assetpacks;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.dx */
final class C1946dx {

    /* renamed from: a */
    private final String f663a;

    /* renamed from: b */
    private final long f664b;

    /* renamed from: c */
    private final int f665c;

    /* renamed from: d */
    private final boolean f666d;

    /* renamed from: e */
    private final boolean f667e;

    /* renamed from: f */
    private final byte[] f668f;

    C1946dx() {
    }

    C1946dx(@Nullable String str, long j, int i, boolean z, boolean z2, @Nullable byte[] bArr) {
        this();
        this.f663a = str;
        this.f664b = j;
        this.f665c = i;
        this.f666d = z;
        this.f667e = z2;
        this.f668f = bArr;
    }

    /* renamed from: a */
    static C1946dx m518a(@Nullable String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C1946dx(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final boolean mo33503a() {
        if (mo33505c() == null) {
            return false;
        }
        return mo33505c().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo33504b() {
        return mo33507e() == 0;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: c */
    public String mo33505c() {
        return this.f663a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo33506d() {
        return this.f664b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo33507e() {
        return this.f665c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C1946dx) {
            C1946dx dxVar = (C1946dx) obj;
            String str = this.f663a;
            if (str != null ? str.equals(dxVar.mo33505c()) : dxVar.mo33505c() == null) {
                if (this.f664b == dxVar.mo33506d() && this.f665c == dxVar.mo33507e() && this.f666d == dxVar.mo33509f() && this.f667e == dxVar.mo33510g()) {
                    if (Arrays.equals(this.f668f, dxVar instanceof C1946dx ? dxVar.f668f : dxVar.mo33511h())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo33509f() {
        return this.f666d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo33510g() {
        return this.f667e;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: h */
    public byte[] mo33511h() {
        return this.f668f;
    }

    public int hashCode() {
        String str = this.f663a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f664b;
        int i = 1231;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f665c) * 1000003) ^ (true != this.f666d ? 1237 : 1231)) * 1000003;
        if (true != this.f667e) {
            i = 1237;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f668f);
    }

    public String toString() {
        String str = this.f663a;
        long j = this.f664b;
        int i = this.f665c;
        boolean z = this.f666d;
        boolean z2 = this.f667e;
        String arrays = Arrays.toString(this.f668f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
