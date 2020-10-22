package com.google.android.play.core.common;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.play.core.common.a */
public final class C1971a {

    /* renamed from: a */
    private final Map<String, Object> f716a = new HashMap();

    /* renamed from: a */
    public final synchronized void mo33531a(Bundle bundle) {
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && this.f716a.get(str) == null) {
                this.f716a.put(str, obj);
            }
        }
    }

    /* renamed from: a */
    public final synchronized boolean mo33532a() {
        Object obj = this.f716a.get("usingExtractorStream");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
