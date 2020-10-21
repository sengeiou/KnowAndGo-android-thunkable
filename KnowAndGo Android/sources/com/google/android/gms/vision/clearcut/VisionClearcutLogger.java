package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzds;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.vision.C1638L;

@Keep
/* compiled from: com.google.android.gms:play-services-vision-common@@19.0.0 */
public class VisionClearcutLogger {
    private final ClearcutLogger zzbv;
    private boolean zzbw = true;

    public VisionClearcutLogger(Context context) {
        this.zzbv = new ClearcutLogger(context, "VISION", (String) null);
    }

    public final void zzb(int i, zzea.zzo zzo) {
        byte[] byteArray = zzo.toByteArray();
        if (i < 0 || i > 3) {
            C1638L.m200i("Illegal event code: %d", Integer.valueOf(i));
            return;
        }
        try {
            if (this.zzbw) {
                this.zzbv.newEvent(byteArray).setEventCode(i).log();
                return;
            }
            zzea.zzo.zza zzdi = zzea.zzo.zzdi();
            try {
                zzdi.zza(byteArray, 0, byteArray.length, zzgd.zzfm());
                C1638L.m198e("Would have logged:\n%s", zzdi.toString());
            } catch (Exception e) {
                C1638L.m199e(e, "Parsing error", new Object[0]);
            }
        } catch (Exception e2) {
            zzds.zza(e2);
            C1638L.m199e(e2, "Failed to log", new Object[0]);
        }
    }
}
