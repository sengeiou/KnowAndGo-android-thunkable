package com.uxcam.internals;

import java.nio.ByteBuffer;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* renamed from: com.uxcam.internals.jc */
public class C3288jc extends C3255hx {

    /* renamed from: a */
    public int f2687a;

    /* renamed from: b */
    public int f2688b;

    public C3288jc() {
        super(new C3277ir("pasp"));
    }

    /* renamed from: a */
    public static String m2304a() {
        return "pasp";
    }

    /* renamed from: a */
    public final void mo38539a(StringBuilder sb) {
        super.mo38539a(sb);
        sb.append(": " + this.f2687a + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.f2688b);
    }

    /* renamed from: a */
    public final void mo38506a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(this.f2687a);
        byteBuffer.putInt(this.f2688b);
    }
}
