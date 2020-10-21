package com.google.android.gms.vision.internal;

import androidx.annotation.Keep;
import com.google.android.gms.flags.Flag;

@Keep
/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class Flags {
    private static final Flag<Boolean> zzdk = Flag.define(0, "vision:product_barcode_value_logging_enabled", (Boolean) true);

    private Flags() {
    }
}
