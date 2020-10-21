package com.uxcam.internals;

/* renamed from: com.uxcam.internals.dm */
public enum C3070dm {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8);
    

    /* renamed from: g */
    public final int f1936g;

    private C3070dm(int i) {
        this.f1936g = i;
    }

    /* renamed from: a */
    public static C3070dm m1541a(int i) {
        for (C3070dm dmVar : values()) {
            if (dmVar.f1936g == i) {
                return dmVar;
            }
        }
        return null;
    }
}
