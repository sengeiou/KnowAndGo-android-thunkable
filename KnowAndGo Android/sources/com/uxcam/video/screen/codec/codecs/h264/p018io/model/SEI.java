package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

import com.uxcam.internals.C3219gp;
import com.uxcam.internals.C3232hc;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import kotlin.UByte;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.SEI */
public class SEI {
    public SEIMessage[] messages;

    /* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.SEI$SEIMessage */
    public static class SEIMessage {
        public byte[] payload;
        public int payloadSize;
        public int payloadType;

        public SEIMessage(int i, int i2, byte[] bArr) {
            this.payload = bArr;
            this.payloadType = i;
            this.payloadSize = i2;
        }
    }

    public SEI(SEIMessage[] sEIMessageArr) {
        this.messages = sEIMessageArr;
    }

    public static SEI read(ByteBuffer byteBuffer) {
        SEIMessage sei_message;
        ArrayList arrayList = new ArrayList();
        do {
            sei_message = sei_message(byteBuffer);
            if (sei_message != null) {
                arrayList.add(sei_message);
                continue;
            }
        } while (sei_message != null);
        return new SEI((SEIMessage[]) arrayList.toArray(new SEIMessage[0]));
    }

    private static SEIMessage sei_message(ByteBuffer byteBuffer) {
        byte b;
        byte b2;
        int i = 0;
        int i2 = 0;
        while (true) {
            b = byteBuffer.get() & UByte.MAX_VALUE;
            if (b != 255) {
                break;
            }
            i2 += 255;
        }
        if (b == -1) {
            return null;
        }
        int i3 = i2 + b;
        while (true) {
            b2 = byteBuffer.get() & UByte.MAX_VALUE;
            if (b2 != 255) {
                break;
            }
            i += 255;
        }
        if (b2 == -1) {
            return null;
        }
        int i4 = i + b2;
        byte[] sei_payload = sei_payload(i3, i4, byteBuffer);
        if (sei_payload.length != i4) {
            return null;
        }
        return new SEIMessage(i3, i4, sei_payload);
    }

    private static byte[] sei_payload(int i, int i2, ByteBuffer byteBuffer) {
        byte[] bArr = new byte[i2];
        byteBuffer.get(bArr);
        return bArr;
    }

    public void write(ByteBuffer byteBuffer) {
        C3219gp.m2180a(new C3232hc(byteBuffer));
    }
}
