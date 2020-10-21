package com.uxcam.internals;

import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.hm */
public final class C3243hm {

    /* renamed from: a */
    public short f2545a;

    /* renamed from: b */
    public byte f2546b;

    /* renamed from: c */
    public byte f2547c;

    /* renamed from: d */
    public byte f2548d;

    /* renamed from: e */
    public boolean f2549e;

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d:%02d:%02d", new Object[]{Short.valueOf(this.f2545a), Byte.valueOf(this.f2546b), Byte.valueOf(this.f2547c)}));
        sb.append(this.f2549e ? ";" : ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(String.format("%02d", new Object[]{Byte.valueOf(this.f2548d)}));
        return sb.toString();
    }
}
