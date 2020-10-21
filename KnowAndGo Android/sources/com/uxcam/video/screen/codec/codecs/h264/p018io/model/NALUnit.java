package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

import java.nio.ByteBuffer;
import kotlin.UByte;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.NALUnit */
public class NALUnit {
    public int nal_ref_idc;
    public NALUnitType type;

    public NALUnit(NALUnitType nALUnitType, int i) {
        this.type = nALUnitType;
        this.nal_ref_idc = i;
    }

    public static NALUnit read(ByteBuffer byteBuffer) {
        byte b = byteBuffer.get() & UByte.MAX_VALUE;
        return new NALUnit(NALUnitType.fromValue(b & 31), (b >> 5) & 3);
    }

    public void write(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) (this.type.getValue() | (this.nal_ref_idc << 5)));
    }
}
