package com.uxcam.internals;

import com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnit;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.NALUnitType;
import com.uxcam.video.screen.codec.codecs.h264.p018io.model.SeqParameterSet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.gj */
public final class C3213gj {
    /* renamed from: a */
    private static int m2141a(SeqParameterSet seqParameterSet) {
        return (seqParameterSet.pic_height_in_map_units_minus1 + 1) << (seqParameterSet.frame_mbs_only_flag ^ true ? 1 : 0);
    }

    /* renamed from: a */
    public static C3292jf m2142a(List list, List list2) {
        SeqParameterSet d = m2148d(C3229gz.m2199a((ByteBuffer) list.get(0)));
        C3221gr grVar = new C3221gr(d.profile_idc, d.level_idc, list, list2);
        int i = (d.pic_width_in_mbs_minus1 + 1) << 4;
        int a = m2141a(d) << 4;
        if (d.frame_cropping_flag) {
            i -= (d.frame_crop_right_offset + d.frame_crop_left_offset) << d.chroma_format_idc.f2522n[1];
        }
        if (d.frame_cropping_flag) {
            a -= (d.frame_crop_bottom_offset + d.frame_crop_top_offset) << d.chroma_format_idc.f2523o[1];
        }
        C3307jr a2 = C3313jv.m2350a("avc1", new C3242hl(i, a), "JCodec");
        a2.mo38546a((C3255hx) grVar);
        return a2;
    }

    /* renamed from: a */
    public static void m2143a(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        int position = duplicate2.position();
        while (true) {
            ByteBuffer b = m2146b(duplicate);
            if (b != null) {
                duplicate2.position(position);
                duplicate2.putInt(b.remaining());
                position += b.remaining() + 4;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static final void m2144a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte b = byteBuffer.get();
        byte b2 = byteBuffer.get();
        byteBuffer2.put(b);
        byteBuffer2.put(b2);
        while (byteBuffer.hasRemaining()) {
            byte b3 = byteBuffer.get();
            if (b == 0 && b2 == 0 && (b3 & UByte.MAX_VALUE) <= 3) {
                byteBuffer2.put((byte) 3);
                b = 3;
            } else {
                b = b2;
            }
            byteBuffer2.put(b3);
            b2 = b3;
        }
    }

    /* renamed from: a */
    public static void m2145a(ByteBuffer byteBuffer, List list, List list2) {
        ByteBuffer b;
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (duplicate.hasRemaining() && (b = m2146b(duplicate)) != null) {
            NALUnit read = NALUnit.read(b);
            if (read.type == NALUnitType.PPS) {
                if (list2 != null) {
                    list2.add(b);
                }
            } else if (read.type == NALUnitType.SPS) {
                if (list != null) {
                    list.add(b);
                }
            } else if (read.type == NALUnitType.IDR_SLICE || read.type == NALUnitType.NON_IDR_SLICE) {
                return;
            }
            byteBuffer.position(duplicate.position());
        }
    }

    /* renamed from: b */
    private static ByteBuffer m2146b(ByteBuffer byteBuffer) {
        byte b = -1;
        if (byteBuffer.hasRemaining()) {
            byte b2 = -1;
            while (true) {
                if (!byteBuffer.hasRemaining()) {
                    break;
                }
                b2 = (b2 << 8) | (byteBuffer.get() & UByte.MAX_VALUE);
                if ((b2 & UByte.MAX_VALUE) == 1) {
                    byteBuffer.position(byteBuffer.position());
                    break;
                }
            }
        }
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int position = byteBuffer.position();
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.BIG_ENDIAN);
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            b = (b << 8) | (byteBuffer.get() & UByte.MAX_VALUE);
            if ((b & UByte.MAX_VALUE) == 1) {
                byteBuffer.position(byteBuffer.position() - (b == 1 ? 4 : 3));
                slice.limit(byteBuffer.position() - position);
            }
        }
        return slice;
    }

    /* renamed from: c */
    private static void m2147c(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer.duplicate();
            byte b = duplicate.get();
            duplicate2.put(b);
            byte b2 = duplicate.get();
            duplicate2.put(b2);
            while (duplicate.hasRemaining()) {
                byte b3 = duplicate.get();
                if (b != 0 || b2 != 0 || b3 != 3) {
                    duplicate2.put(b3);
                }
                b = b2;
                b2 = b3;
            }
            byteBuffer.limit(duplicate2.position());
        }
    }

    /* renamed from: d */
    private static SeqParameterSet m2148d(ByteBuffer byteBuffer) {
        ByteBuffer a = C3229gz.m2199a(byteBuffer);
        m2147c(a);
        return SeqParameterSet.read(a);
    }
}
