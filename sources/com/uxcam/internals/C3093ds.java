package com.uxcam.internals;

import com.uxcam.internals.C3072do;
import java.io.Closeable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.UByte;

/* renamed from: com.uxcam.internals.ds */
final class C3093ds implements Closeable {

    /* renamed from: a */
    static final Logger f2048a = Logger.getLogger(C3075dp.class.getName());

    /* renamed from: b */
    final C3132ep f2049b;

    /* renamed from: c */
    final boolean f2050c;

    /* renamed from: d */
    final C3072do.C3073aa f2051d = new C3072do.C3073aa(this.f2052e);

    /* renamed from: e */
    private final C3094aa f2052e = new C3094aa(this.f2049b);

    /* renamed from: com.uxcam.internals.ds$aa */
    static final class C3094aa implements C3148fc {

        /* renamed from: a */
        int f2053a;

        /* renamed from: b */
        byte f2054b;

        /* renamed from: c */
        int f2055c;

        /* renamed from: d */
        int f2056d;

        /* renamed from: e */
        short f2057e;

        /* renamed from: f */
        private final C3132ep f2058f;

        public C3094aa(C3132ep epVar) {
            this.f2058f = epVar;
        }

        /* renamed from: a */
        public final long mo38196a(C3130en enVar, long j) {
            while (this.f2056d == 0) {
                this.f2058f.mo38382f((long) this.f2057e);
                this.f2057e = 0;
                if ((this.f2054b & 4) != 0) {
                    return -1;
                }
                int i = this.f2055c;
                int a = C3093ds.m1610a(this.f2058f);
                this.f2056d = a;
                this.f2053a = a;
                byte e = (byte) (this.f2058f.mo38376e() & UByte.MAX_VALUE);
                this.f2054b = (byte) (this.f2058f.mo38376e() & UByte.MAX_VALUE);
                if (C3093ds.f2048a.isLoggable(Level.FINE)) {
                    C3093ds.f2048a.fine(C3075dp.m1563a(true, this.f2055c, this.f2053a, e, this.f2054b));
                }
                this.f2055c = this.f2058f.mo38383g() & Integer.MAX_VALUE;
                if (e != 9) {
                    throw C3075dp.m1564b("%s != TYPE_CONTINUATION", Byte.valueOf(e));
                } else if (this.f2055c != i) {
                    throw C3075dp.m1564b("TYPE_CONTINUATION streamId changed", new Object[0]);
                }
            }
            long a2 = this.f2058f.mo38196a(enVar, Math.min(j, (long) this.f2056d));
            if (a2 == -1) {
                return -1;
            }
            this.f2056d = (int) (((long) this.f2056d) - a2);
            return a2;
        }

        /* renamed from: a */
        public final C3149fd mo38197a() {
            return this.f2058f.mo38197a();
        }

        public final void close() {
        }
    }

    /* renamed from: com.uxcam.internals.ds$ab */
    interface C3095ab {
        /* renamed from: a */
        void mo38268a(int i);

        /* renamed from: a */
        void mo38269a(int i, long j);

        /* renamed from: a */
        void mo38270a(int i, C3070dm dmVar);

        /* renamed from: a */
        void mo38271a(int i, List list);

        /* renamed from: a */
        void mo38272a(C3106dy dyVar);

        /* renamed from: a */
        void mo38273a(boolean z, int i, int i2);

        /* renamed from: a */
        void mo38274a(boolean z, int i, C3132ep epVar, int i2);

        /* renamed from: a */
        void mo38275a(boolean z, int i, List list);
    }

    public C3093ds(C3132ep epVar, boolean z) {
        this.f2049b = epVar;
        this.f2050c = z;
    }

    /* renamed from: a */
    private static int m1609a(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw C3075dp.m1564b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    /* renamed from: a */
    static int m1610a(C3132ep epVar) {
        return (epVar.mo38376e() & UByte.MAX_VALUE) | ((epVar.mo38376e() & UByte.MAX_VALUE) << 16) | ((epVar.mo38376e() & UByte.MAX_VALUE) << 8);
    }

    /* renamed from: a */
    private List m1611a(int i, short s, byte b, int i2) {
        C3094aa aaVar = this.f2052e;
        this.f2052e.f2056d = i;
        aaVar.f2053a = i;
        this.f2052e.f2057e = s;
        this.f2052e.f2054b = b;
        this.f2052e.f2055c = i2;
        this.f2051d.mo38248a();
        return this.f2051d.mo38249b();
    }

    /* renamed from: a */
    private void m1612a() {
        this.f2049b.mo38383g();
        this.f2049b.mo38376e();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v15, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v28, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v33, resolved type: short} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v37, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v48, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v49, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo38276a(com.uxcam.internals.C3093ds.C3095ab r11) {
        /*
            r10 = this;
            r0 = 0
            com.uxcam.internals.ep r1 = r10.f2049b     // Catch:{ IOException -> 0x0291 }
            r2 = 9
            r1.mo38360a((long) r2)     // Catch:{ IOException -> 0x0291 }
            com.uxcam.internals.ep r1 = r10.f2049b
            int r1 = m1610a((com.uxcam.internals.C3132ep) r1)
            r2 = 1
            if (r1 < 0) goto L_0x0282
            r3 = 16384(0x4000, float:2.2959E-41)
            if (r1 > r3) goto L_0x0282
            com.uxcam.internals.ep r4 = r10.f2049b
            byte r4 = r4.mo38376e()
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            com.uxcam.internals.ep r5 = r10.f2049b
            byte r5 = r5.mo38376e()
            r5 = r5 & 255(0xff, float:3.57E-43)
            byte r5 = (byte) r5
            com.uxcam.internals.ep r6 = r10.f2049b
            int r6 = r6.mo38383g()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r6 = r6 & r7
            java.util.logging.Logger r8 = f2048a
            java.util.logging.Level r9 = java.util.logging.Level.FINE
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x0044
            java.util.logging.Logger r8 = f2048a
            java.lang.String r9 = com.uxcam.internals.C3075dp.m1563a(r2, r6, r1, r4, r5)
            r8.fine(r9)
        L_0x0044:
            r8 = 4
            r9 = 8
            switch(r4) {
                case 0: goto L_0x024d;
                case 1: goto L_0x0219;
                case 2: goto L_0x01f7;
                case 3: goto L_0x01bb;
                case 4: goto L_0x0135;
                case 5: goto L_0x0107;
                case 6: goto L_0x00d5;
                case 7: goto L_0x0088;
                case 8: goto L_0x0052;
                default: goto L_0x004a;
            }
        L_0x004a:
            com.uxcam.internals.ep r11 = r10.f2049b
            long r0 = (long) r1
        L_0x004d:
            r11.mo38382f(r0)
            goto L_0x0281
        L_0x0052:
            if (r1 != r8) goto L_0x0079
            com.uxcam.internals.ep r1 = r10.f2049b
            int r1 = r1.mo38383g()
            long r3 = (long) r1
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            long r3 = r3 & r7
            r7 = 0
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x006a
            r11.mo38269a((int) r6, (long) r3)
            goto L_0x0281
        L_0x006a:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r11[r0] = r1
            java.lang.String r0 = "windowSizeIncrement was 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0079:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_WINDOW_UPDATE length !=4: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0088:
            if (r1 < r9) goto L_0x00c6
            if (r6 != 0) goto L_0x00bd
            com.uxcam.internals.ep r3 = r10.f2049b
            int r3 = r3.mo38383g()
            com.uxcam.internals.ep r4 = r10.f2049b
            int r4 = r4.mo38383g()
            int r1 = r1 - r9
            com.uxcam.internals.dm r5 = com.uxcam.internals.C3070dm.m1541a(r4)
            if (r5 == 0) goto L_0x00ae
            com.uxcam.internals.eq r0 = com.uxcam.internals.C3133eq.f2160b
            if (r1 <= 0) goto L_0x00a9
            com.uxcam.internals.ep r0 = r10.f2049b
            long r4 = (long) r1
            r0.mo38370c(r4)
        L_0x00a9:
            r11.mo38268a((int) r3)
            goto L_0x0281
        L_0x00ae:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_GOAWAY unexpected error code: %d"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x00bd:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "TYPE_GOAWAY streamId != 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x00c6:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_GOAWAY length < 8: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x00d5:
            if (r1 != r9) goto L_0x00f8
            if (r6 != 0) goto L_0x00ef
            com.uxcam.internals.ep r1 = r10.f2049b
            int r1 = r1.mo38383g()
            com.uxcam.internals.ep r3 = r10.f2049b
            int r3 = r3.mo38383g()
            r4 = r5 & 1
            if (r4 == 0) goto L_0x00ea
            r0 = 1
        L_0x00ea:
            r11.mo38273a((boolean) r0, (int) r1, (int) r3)
            goto L_0x0281
        L_0x00ef:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "TYPE_PING streamId != 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x00f8:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_PING length != 8: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0107:
            if (r6 == 0) goto L_0x012c
            r3 = r5 & 8
            if (r3 == 0) goto L_0x0116
            com.uxcam.internals.ep r0 = r10.f2049b
            byte r0 = r0.mo38376e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x0116:
            com.uxcam.internals.ep r3 = r10.f2049b
            int r3 = r3.mo38383g()
            r3 = r3 & r7
            int r1 = r1 + -4
            int r1 = m1609a(r1, r5, r0)
            java.util.List r0 = r10.m1611a(r1, r0, r5, r6)
            r11.mo38271a((int) r3, (java.util.List) r0)
            goto L_0x0281
        L_0x012c:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0135:
            if (r6 != 0) goto L_0x01b2
            r4 = r5 & 1
            if (r4 == 0) goto L_0x0148
            if (r1 != 0) goto L_0x013f
            goto L_0x0281
        L_0x013f:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "FRAME_SIZE_ERROR ack frame should be empty!"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0148:
            int r4 = r1 % 6
            if (r4 != 0) goto L_0x01a3
            com.uxcam.internals.dy r4 = new com.uxcam.internals.dy
            r4.<init>()
            r5 = 0
        L_0x0152:
            if (r5 >= r1) goto L_0x019e
            com.uxcam.internals.ep r6 = r10.f2049b
            short r6 = r6.mo38381f()
            com.uxcam.internals.ep r7 = r10.f2049b
            int r7 = r7.mo38383g()
            switch(r6) {
                case 1: goto L_0x0198;
                case 2: goto L_0x018a;
                case 3: goto L_0x0188;
                case 4: goto L_0x017b;
                case 5: goto L_0x0164;
                default: goto L_0x0163;
            }
        L_0x0163:
            goto L_0x0198
        L_0x0164:
            if (r7 < r3) goto L_0x016c
            r9 = 16777215(0xffffff, float:2.3509886E-38)
            if (r7 > r9) goto L_0x016c
            goto L_0x0198
        L_0x016c:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r11[r0] = r1
            java.lang.String r0 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x017b:
            r6 = 7
            if (r7 < 0) goto L_0x017f
            goto L_0x0198
        L_0x017f:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0188:
            r6 = 4
            goto L_0x0198
        L_0x018a:
            if (r7 == 0) goto L_0x0198
            if (r7 != r2) goto L_0x018f
            goto L_0x0198
        L_0x018f:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0198:
            r4.mo38309a(r6, r7)
            int r5 = r5 + 6
            goto L_0x0152
        L_0x019e:
            r11.mo38272a((com.uxcam.internals.C3106dy) r4)
            goto L_0x0281
        L_0x01a3:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_SETTINGS length %% 6 != 0: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x01b2:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "TYPE_SETTINGS streamId != 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x01bb:
            if (r1 != r8) goto L_0x01e8
            if (r6 == 0) goto L_0x01df
            com.uxcam.internals.ep r1 = r10.f2049b
            int r1 = r1.mo38383g()
            com.uxcam.internals.dm r3 = com.uxcam.internals.C3070dm.m1541a(r1)
            if (r3 == 0) goto L_0x01d0
            r11.mo38270a((int) r6, (com.uxcam.internals.C3070dm) r3)
            goto L_0x0281
        L_0x01d0:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_RST_STREAM unexpected error code: %d"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x01df:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "TYPE_RST_STREAM streamId == 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x01e8:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_RST_STREAM length: %d != 4"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x01f7:
            r11 = 5
            if (r1 != r11) goto L_0x020a
            if (r6 == 0) goto L_0x0201
            r10.m1612a()
            goto L_0x0281
        L_0x0201:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "TYPE_PRIORITY streamId == 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x020a:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "TYPE_PRIORITY length: %d != 5"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0219:
            if (r6 == 0) goto L_0x0244
            r3 = r5 & 1
            if (r3 == 0) goto L_0x0221
            r3 = 1
            goto L_0x0222
        L_0x0221:
            r3 = 0
        L_0x0222:
            r4 = r5 & 8
            if (r4 == 0) goto L_0x022f
            com.uxcam.internals.ep r0 = r10.f2049b
            byte r0 = r0.mo38376e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x022f:
            r4 = r5 & 32
            if (r4 == 0) goto L_0x0238
            r10.m1612a()
            int r1 = r1 + -5
        L_0x0238:
            int r1 = m1609a(r1, r5, r0)
            java.util.List r0 = r10.m1611a(r1, r0, r5, r6)
            r11.mo38275a((boolean) r3, (int) r6, (java.util.List) r0)
            goto L_0x0281
        L_0x0244:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "PROTOCOL_ERROR: TYPE_HEADERS streamId == 0"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x024d:
            r3 = r5 & 1
            if (r3 == 0) goto L_0x0253
            r3 = 1
            goto L_0x0254
        L_0x0253:
            r3 = 0
        L_0x0254:
            r4 = r5 & 32
            if (r4 == 0) goto L_0x025a
            r4 = 1
            goto L_0x025b
        L_0x025a:
            r4 = 0
        L_0x025b:
            if (r4 != 0) goto L_0x0278
            r4 = r5 & 8
            if (r4 == 0) goto L_0x026a
            com.uxcam.internals.ep r0 = r10.f2049b
            byte r0 = r0.mo38376e()
            r0 = r0 & 255(0xff, float:3.57E-43)
            short r0 = (short) r0
        L_0x026a:
            int r1 = m1609a(r1, r5, r0)
            com.uxcam.internals.ep r4 = r10.f2049b
            r11.mo38274a(r3, r6, r4, r1)
            com.uxcam.internals.ep r11 = r10.f2049b
            long r0 = (long) r0
            goto L_0x004d
        L_0x0278:
            java.lang.Object[] r11 = new java.lang.Object[r0]
            java.lang.String r0 = "PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0281:
            return r2
        L_0x0282:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r11[r0] = r1
            java.lang.String r0 = "FRAME_SIZE_ERROR: %s"
            java.io.IOException r11 = com.uxcam.internals.C3075dp.m1564b(r0, r11)
            throw r11
        L_0x0291:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.C3093ds.mo38276a(com.uxcam.internals.ds$ab):boolean");
    }

    public final void close() {
        this.f2049b.close();
    }
}
