package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C1982af;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.google.android.play.core.assetpacks.dv */
final class C1944dv {

    /* renamed from: a */
    private static final C1982af f660a = new C1982af("VerifySliceTaskHandler");

    /* renamed from: b */
    private final C1870bb f661b;

    C1944dv(C1870bb bbVar) {
        this.f661b = bbVar;
    }

    /* renamed from: a */
    private final void m515a(C1943du duVar, File file) {
        try {
            File f = this.f661b.mo33397f(duVar.f551k, duVar.f656a, duVar.f657b, duVar.f658c);
            if (f.exists()) {
                try {
                    if (C1924db.m470a(C1942dt.m513a(file, f)).equals(duVar.f659d)) {
                        f660a.mo33553c("Verification of slice %s of pack %s successful.", duVar.f658c, duVar.f551k);
                        return;
                    }
                    throw new C1890bv(String.format("Verification failed for slice %s.", new Object[]{duVar.f658c}), duVar.f550j);
                } catch (NoSuchAlgorithmException e) {
                    throw new C1890bv("SHA256 algorithm not supported.", e, duVar.f550j);
                } catch (IOException e2) {
                    throw new C1890bv(String.format("Could not digest file during verification for slice %s.", new Object[]{duVar.f658c}), e2, duVar.f550j);
                }
            } else {
                throw new C1890bv(String.format("Cannot find metadata files for slice %s.", new Object[]{duVar.f658c}), duVar.f550j);
            }
        } catch (IOException e3) {
            throw new C1890bv(String.format("Could not reconstruct slice archive during verification for slice %s.", new Object[]{duVar.f658c}), e3, duVar.f550j);
        }
    }

    /* renamed from: a */
    public final void mo33502a(C1943du duVar) {
        File a = this.f661b.mo33375a(duVar.f551k, duVar.f656a, duVar.f657b, duVar.f658c);
        if (a.exists()) {
            m515a(duVar, a);
            File b = this.f661b.mo33382b(duVar.f551k, duVar.f656a, duVar.f657b, duVar.f658c);
            if (!b.exists()) {
                b.mkdirs();
            }
            if (!a.renameTo(b)) {
                throw new C1890bv(String.format("Failed to move slice %s after verification.", new Object[]{duVar.f658c}), duVar.f550j);
            }
            return;
        }
        throw new C1890bv(String.format("Cannot find unverified files for slice %s.", new Object[]{duVar.f658c}), duVar.f550j);
    }
}
