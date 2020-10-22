package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C2028by;
import com.google.android.play.core.internal.C2063v;
import com.google.android.play.core.internal.C2066y;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.b */
final class C1868b extends C2063v {

    /* renamed from: a */
    private final C1982af f389a = new C1982af("AssetPackExtractionService");

    /* renamed from: b */
    private final Context f390b;

    /* renamed from: c */
    private final AssetPackExtractionService f391c;

    /* renamed from: d */
    private final C1870bb f392d;

    C1868b(Context context, AssetPackExtractionService assetPackExtractionService, C1870bb bbVar) {
        this.f390b = context;
        this.f391c = assetPackExtractionService;
        this.f392d = bbVar;
    }

    /* renamed from: a */
    public final void mo33370a(Bundle bundle, C2066y yVar) throws RemoteException {
        String[] packagesForUid;
        this.f389a.mo33550a("updateServiceState AIDL call", new Object[0]);
        if (!C2028by.m725a(this.f390b) || (packagesForUid = this.f390b.getPackageManager().getPackagesForUid(Binder.getCallingUid())) == null || !Arrays.asList(packagesForUid).contains("com.android.vending")) {
            yVar.mo33650a(new Bundle());
            this.f391c.mo33311a();
            return;
        }
        yVar.mo33651a(this.f391c.mo33310a(bundle), new Bundle());
    }

    /* renamed from: a */
    public final void mo33371a(C2066y yVar) throws RemoteException {
        this.f392d.mo33398f();
        yVar.mo33652b(new Bundle());
    }
}
