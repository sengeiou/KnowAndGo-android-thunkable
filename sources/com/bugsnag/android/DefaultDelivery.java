package com.bugsnag.android;

import androidx.annotation.NonNull;

class DefaultDelivery implements Delivery {
    private static final int HTTP_REQUEST_FAILED = 0;
    private final Connectivity connectivity;

    DefaultDelivery(Connectivity connectivity2) {
        this.connectivity = connectivity2;
    }

    public void deliver(@NonNull SessionTrackingPayload sessionTrackingPayload, @NonNull Configuration configuration) throws DeliveryFailureException {
        int deliver = deliver(configuration.getSessionEndpoint(), sessionTrackingPayload, configuration.getSessionApiHeaders());
        if (deliver != 202) {
            Logger.warn("Session API request failed with status " + deliver, (Throwable) null);
            return;
        }
        Logger.info("Completed session tracking request");
    }

    public void deliver(@NonNull Report report, @NonNull Configuration configuration) throws DeliveryFailureException {
        int deliver = deliver(configuration.getEndpoint(), report, configuration.getErrorApiHeaders());
        if (deliver / 100 != 2) {
            Logger.warn("Error API request failed with status " + deliver, (Throwable) null);
            return;
        }
        Logger.info("Completed error API request");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.net.URLConnection] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int deliver(java.lang.String r6, com.bugsnag.android.JsonStream.Streamable r7, java.util.Map<java.lang.String, java.lang.String> r8) throws com.bugsnag.android.DeliveryFailureException {
        /*
            r5 = this;
            com.bugsnag.android.Connectivity r0 = r5.connectivity
            r1 = 0
            if (r0 == 0) goto L_0x0016
            com.bugsnag.android.Connectivity r0 = r5.connectivity
            boolean r0 = r0.hasNetworkConnection()
            if (r0 == 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            com.bugsnag.android.DeliveryFailureException r6 = new com.bugsnag.android.DeliveryFailureException
            java.lang.String r7 = "No network connection available"
            r6.<init>(r7, r1)
            throw r6
        L_0x0016:
            r0 = 0
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0098, Exception -> 0x008e }
            r2.<init>(r6)     // Catch:{ IOException -> 0x0098, Exception -> 0x008e }
            java.net.URLConnection r6 = r2.openConnection()     // Catch:{ IOException -> 0x0098, Exception -> 0x008e }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ IOException -> 0x0098, Exception -> 0x008e }
            r2 = 1
            r6.setDoOutput(r2)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            r6.setChunkedStreamingMode(r0)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/json"
            r6.addRequestProperty(r2, r3)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
        L_0x0038:
            boolean r2 = r8.hasNext()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            if (r2 == 0) goto L_0x0054
            java.lang.Object r2 = r8.next()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            r6.addRequestProperty(r3, r2)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            goto L_0x0038
        L_0x0054:
            java.io.OutputStream r8 = r6.getOutputStream()     // Catch:{ all -> 0x007e }
            java.lang.String r2 = "UTF-8"
            java.nio.charset.Charset r2 = java.nio.charset.Charset.forName(r2)     // Catch:{ all -> 0x007e }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x007e }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x007e }
            r4.<init>(r8, r2)     // Catch:{ all -> 0x007e }
            r3.<init>(r4)     // Catch:{ all -> 0x007e }
            com.bugsnag.android.JsonStream r8 = new com.bugsnag.android.JsonStream     // Catch:{ all -> 0x007e }
            r8.<init>(r3)     // Catch:{ all -> 0x007e }
            r7.toStream(r8)     // Catch:{ all -> 0x007b }
            com.bugsnag.android.IOUtils.closeQuietly(r8)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            int r7 = r6.getResponseCode()     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            com.bugsnag.android.IOUtils.close(r6)
            return r7
        L_0x007b:
            r7 = move-exception
            r1 = r8
            goto L_0x007f
        L_0x007e:
            r7 = move-exception
        L_0x007f:
            com.bugsnag.android.IOUtils.closeQuietly(r1)     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
            throw r7     // Catch:{ IOException -> 0x0088, Exception -> 0x0085, all -> 0x0083 }
        L_0x0083:
            r7 = move-exception
            goto L_0x00a1
        L_0x0085:
            r7 = move-exception
            r1 = r6
            goto L_0x008f
        L_0x0088:
            r7 = move-exception
            r1 = r6
            goto L_0x0099
        L_0x008b:
            r7 = move-exception
            r6 = r1
            goto L_0x00a1
        L_0x008e:
            r7 = move-exception
        L_0x008f:
            java.lang.String r6 = "Unexpected error delivering payload"
            com.bugsnag.android.Logger.warn(r6, r7)     // Catch:{ all -> 0x008b }
            com.bugsnag.android.IOUtils.close(r1)
            return r0
        L_0x0098:
            r7 = move-exception
        L_0x0099:
            com.bugsnag.android.DeliveryFailureException r6 = new com.bugsnag.android.DeliveryFailureException     // Catch:{ all -> 0x008b }
            java.lang.String r8 = "IOException encountered in request"
            r6.<init>(r8, r7)     // Catch:{ all -> 0x008b }
            throw r6     // Catch:{ all -> 0x008b }
        L_0x00a1:
            com.bugsnag.android.IOUtils.close(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.DefaultDelivery.deliver(java.lang.String, com.bugsnag.android.JsonStream$Streamable, java.util.Map):int");
    }
}
