package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzhx extends zzhw {
    private final Map<UUID, byte[]> zzaho = new HashMap();

    public zzhx(String str) {
        super(str);
    }

    public final void putAll(Map<UUID, byte[]> map) {
        this.zzaho.putAll(map);
    }
}
