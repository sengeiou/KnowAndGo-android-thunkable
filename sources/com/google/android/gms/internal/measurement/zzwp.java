package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzwp extends zzwo<FieldDescriptorType, Object> {
    zzwp(int i) {
        super(i, (zzwp) null);
    }

    public final void zzsw() {
        if (!isImmutable()) {
            for (int i = 0; i < zzyc(); i++) {
                Map.Entry zzbx = zzbx(i);
                if (((zzuh) zzbx.getKey()).zzwb()) {
                    zzbx.setValue(Collections.unmodifiableList((List) zzbx.getValue()));
                }
            }
            for (Map.Entry entry : zzyd()) {
                if (((zzuh) entry.getKey()).zzwb()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzsw();
    }
}
