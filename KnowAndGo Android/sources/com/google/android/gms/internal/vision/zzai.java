package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@19.0.0 */
public final class zzai extends zzn<zzy> {
    private final zzah zzef;

    public zzai(Context context, zzah zzah) {
        super(context, "TextNativeHandle", "ocr");
        this.zzef = zzah;
        zzp();
    }

    public final zzac[] zza(Bitmap bitmap, zzp zzp, zzae zzae) {
        if (!isOperational()) {
            return new zzac[0];
        }
        try {
            return ((zzy) zzp()).zza(ObjectWrapper.wrap(bitmap), zzp, zzae);
        } catch (RemoteException e) {
            Log.e("TextNativeHandle", "Error calling native text recognizer", e);
            return new zzac[0];
        }
    }

    /* access modifiers changed from: protected */
    public final void zzn() throws RemoteException {
        ((zzy) zzp()).zzq();
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object zza(com.google.android.gms.dynamite.DynamiteModule r4, android.content.Context r5) throws android.os.RemoteException, com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r3 = this;
            java.lang.String r0 = "com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator"
            android.os.IBinder r4 = r4.instantiate(r0)
            r0 = 0
            if (r4 != 0) goto L_0x000b
            r4 = r0
            goto L_0x001f
        L_0x000b:
            java.lang.String r1 = "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.vision.zzaa
            if (r2 == 0) goto L_0x0019
            r4 = r1
            com.google.android.gms.internal.vision.zzaa r4 = (com.google.android.gms.internal.vision.zzaa) r4
            goto L_0x001f
        L_0x0019:
            com.google.android.gms.internal.vision.zzz r1 = new com.google.android.gms.internal.vision.zzz
            r1.<init>(r4)
            r4 = r1
        L_0x001f:
            if (r4 != 0) goto L_0x0022
            return r0
        L_0x0022:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)
            com.google.android.gms.internal.vision.zzah r0 = r3.zzef
            com.google.android.gms.internal.vision.zzy r4 = r4.zza(r5, r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzai.zza(com.google.android.gms.dynamite.DynamiteModule, android.content.Context):java.lang.Object");
    }
}
