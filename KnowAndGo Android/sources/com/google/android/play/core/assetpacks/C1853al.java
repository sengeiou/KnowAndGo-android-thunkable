package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2170i;

/* renamed from: com.google.android.play.core.assetpacks.al */
final class C1853al extends C1852ak<ParcelFileDescriptor> {
    C1853al(C1859ar arVar, C2170i<ParcelFileDescriptor> iVar) {
        super(arVar, iVar);
    }

    /* renamed from: b */
    public final void mo33349b(Bundle bundle, Bundle bundle2) throws RemoteException {
        super.mo33349b(bundle, bundle2);
        this.f342a.mo33809b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
