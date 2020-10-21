package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class zzai extends zzaj {
    private final zzas zzbp;

    zzai(zzas zzas) {
        this.zzbp = zzas;
    }

    public final zzar zza(zzr<?> zzr, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse zzb = this.zzbp.zzb(zzr, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            ArrayList arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzar(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new zzar(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            StringBuilder sb = new StringBuilder(40);
            sb.append("Response too large: ");
            sb.append(contentLength);
            throw new IOException(sb.toString());
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
