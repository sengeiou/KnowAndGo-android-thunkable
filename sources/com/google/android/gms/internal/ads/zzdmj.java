package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdmi;
import com.google.android.gms.internal.ads.zzdmj;
import java.io.IOException;

public abstract class zzdmj<MessageType extends zzdmi<MessageType, BuilderType>, BuilderType extends zzdmj<MessageType, BuilderType>> implements zzdpl {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzdnd zzdnd, zzdno zzdno) throws IOException;

    /* renamed from: zzavh */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzdno zzdno) throws zzdok {
        try {
            zzdnd zzc = zzdnd.zzc(bArr, 0, i2, false);
            zza(zzc, zzdno);
            zzc.zzfp(0);
            return this;
        } catch (zzdok e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf("byte array").length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ zzdpl zzi(zzdpk zzdpk) {
        if (zzaxv().getClass().isInstance(zzdpk)) {
            return zza((zzdmi) zzdpk);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
