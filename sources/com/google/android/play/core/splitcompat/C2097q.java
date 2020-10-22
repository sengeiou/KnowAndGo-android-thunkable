package com.google.android.play.core.splitcompat;

import androidx.annotation.NonNull;
import java.io.File;

/* renamed from: com.google.android.play.core.splitcompat.q */
final class C2097q {

    /* renamed from: a */
    private final File f851a;

    /* renamed from: b */
    private final String f852b;

    C2097q() {
    }

    C2097q(File file, String str) {
        this();
        if (file != null) {
            this.f851a = file;
            if (str != null) {
                this.f852b = str;
                return;
            }
            throw new NullPointerException("Null splitId");
        }
        throw new NullPointerException("Null splitFile");
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public File mo33704a() {
        return this.f851a;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    /* renamed from: b */
    public String mo33705b() {
        return this.f852b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2097q) {
            C2097q qVar = (C2097q) obj;
            return this.f851a.equals(qVar.mo33704a()) && this.f852b.equals(qVar.mo33705b());
        }
    }

    public int hashCode() {
        return ((this.f851a.hashCode() ^ 1000003) * 1000003) ^ this.f852b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f851a);
        String str = this.f852b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
