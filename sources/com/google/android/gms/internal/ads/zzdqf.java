package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzdqf extends zzdqe<FieldDescriptorType, Object> {
    zzdqf(int i) {
        super(i, (zzdqf) null);
    }

    public final void zzavj() {
        if (!isImmutable()) {
            for (int i = 0; i < zzazp(); i++) {
                Map.Entry zzgz = zzgz(i);
                if (((zzdnu) zzgz.getKey()).zzaxn()) {
                    zzgz.setValue(Collections.unmodifiableList((List) zzgz.getValue()));
                }
            }
            for (Map.Entry entry : zzazq()) {
                if (((zzdnu) entry.getKey()).zzaxn()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzavj();
    }
}
