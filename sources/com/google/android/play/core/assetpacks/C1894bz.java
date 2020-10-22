package com.google.android.play.core.assetpacks;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.bz */
final class C1894bz {

    /* renamed from: a */
    private final Map<String, Double> f503a = new HashMap();

    C1894bz() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized double mo33435a(String str, C1913cr crVar) {
        double d;
        d = (((double) ((C1887bs) crVar).f462e) + 1.0d) / ((double) ((C1887bs) crVar).f463f);
        this.f503a.put(str, Double.valueOf(d));
        return d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final synchronized void mo33436a(String str) {
        this.f503a.put(str, Double.valueOf(0.0d));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final synchronized double mo33437b(String str) {
        Double d = this.f503a.get(str);
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }
}
