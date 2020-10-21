package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

@zzard
public final class zzbae {
    public static <T> T zza(Context context, String str, zzbaf<IBinder, T> zzbaf) throws zzbag {
        try {
            return zzbaf.apply(zzbm(context).instantiate(str));
        } catch (Exception e) {
            throw new zzbag(e);
        }
    }

    public static Context zzbl(Context context) throws zzbag {
        return zzbm(context).getModuleContext();
    }

    private static DynamiteModule zzbm(Context context) throws zzbag {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzbag(e);
        }
    }
}
