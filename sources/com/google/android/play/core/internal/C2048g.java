package com.google.android.play.core.internal;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Set;

/* renamed from: com.google.android.play.core.internal.g */
class C2048g extends X509Certificate {

    /* renamed from: a */
    private final X509Certificate f787a;

    public C2048g(X509Certificate x509Certificate) {
        this.f787a = x509Certificate;
    }

    public final void checkValidity() throws CertificateExpiredException, CertificateNotYetValidException {
        this.f787a.checkValidity();
    }

    public final void checkValidity(Date date) throws CertificateExpiredException, CertificateNotYetValidException {
        this.f787a.checkValidity(date);
    }

    public final int getBasicConstraints() {
        return this.f787a.getBasicConstraints();
    }

    public final Set<String> getCriticalExtensionOIDs() {
        return this.f787a.getCriticalExtensionOIDs();
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        return this.f787a.getEncoded();
    }

    public final byte[] getExtensionValue(String str) {
        return this.f787a.getExtensionValue(str);
    }

    public final Principal getIssuerDN() {
        return this.f787a.getIssuerDN();
    }

    public final boolean[] getIssuerUniqueID() {
        return this.f787a.getIssuerUniqueID();
    }

    public final boolean[] getKeyUsage() {
        return this.f787a.getKeyUsage();
    }

    public final Set<String> getNonCriticalExtensionOIDs() {
        return this.f787a.getNonCriticalExtensionOIDs();
    }

    public final Date getNotAfter() {
        return this.f787a.getNotAfter();
    }

    public final Date getNotBefore() {
        return this.f787a.getNotBefore();
    }

    public final PublicKey getPublicKey() {
        return this.f787a.getPublicKey();
    }

    public final BigInteger getSerialNumber() {
        return this.f787a.getSerialNumber();
    }

    public final String getSigAlgName() {
        return this.f787a.getSigAlgName();
    }

    public final String getSigAlgOID() {
        return this.f787a.getSigAlgOID();
    }

    public final byte[] getSigAlgParams() {
        return this.f787a.getSigAlgParams();
    }

    public final byte[] getSignature() {
        return this.f787a.getSignature();
    }

    public final Principal getSubjectDN() {
        return this.f787a.getSubjectDN();
    }

    public final boolean[] getSubjectUniqueID() {
        return this.f787a.getSubjectUniqueID();
    }

    public final byte[] getTBSCertificate() throws CertificateEncodingException {
        return this.f787a.getTBSCertificate();
    }

    public final int getVersion() {
        return this.f787a.getVersion();
    }

    public final boolean hasUnsupportedCriticalExtension() {
        return this.f787a.hasUnsupportedCriticalExtension();
    }

    public final String toString() {
        return this.f787a.toString();
    }

    public final void verify(PublicKey publicKey) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f787a.verify(publicKey);
    }

    public final void verify(PublicKey publicKey, String str) throws CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, SignatureException {
        this.f787a.verify(publicKey, str);
    }
}
