package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocketFactory;

final class zzbew extends SSLSocketFactory {
    private SSLSocketFactory zzego = ((SSLSocketFactory) SSLSocketFactory.getDefault());
    private final /* synthetic */ zzbev zzegp;

    zzbew(zzbev zzbev) {
        this.zzegp = zzbev;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zzego.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zzego.getSupportedCipherSuites();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return zzb(this.zzego.createSocket(socket, str, i, z));
    }

    public final Socket createSocket(String str, int i) throws IOException {
        return zzb(this.zzego.createSocket(str, i));
    }

    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return zzb(this.zzego.createSocket(str, i, inetAddress, i2));
    }

    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return zzb(this.zzego.createSocket(inetAddress, i));
    }

    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return zzb(this.zzego.createSocket(inetAddress, i, inetAddress2, i2));
    }

    private final Socket zzb(Socket socket) throws SocketException {
        if (this.zzegp.zzegm > 0) {
            socket.setReceiveBufferSize(this.zzegp.zzegm);
        }
        this.zzegp.zza(socket);
        return socket;
    }
}
