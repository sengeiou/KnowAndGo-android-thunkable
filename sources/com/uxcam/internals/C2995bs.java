package com.uxcam.internals;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.uxcam.internals.bs */
public interface C2995bs {

    /* renamed from: a */
    public static final C2995bs f1596a = new C2995bs() {
        /* renamed from: a */
        public final List mo38103a(String str) {
            if (str != null) {
                return Arrays.asList(InetAddress.getAllByName(str));
            }
            throw new UnknownHostException("hostname == null");
        }
    };

    /* renamed from: a */
    List mo38103a(String str);
}
