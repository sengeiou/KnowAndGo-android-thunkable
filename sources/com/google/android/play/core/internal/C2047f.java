package com.google.android.play.core.internal;

import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;

/* renamed from: com.google.android.play.core.internal.f */
final class C2047f extends C2048g {

    /* renamed from: a */
    private final byte[] f786a;

    public C2047f(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.f786a = bArr;
    }

    public final byte[] getEncoded() throws CertificateEncodingException {
        return this.f786a;
    }
}
