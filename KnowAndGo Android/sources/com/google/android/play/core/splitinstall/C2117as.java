package com.google.android.play.core.splitinstall;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.tasks.C2170i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.splitinstall.as */
final class C2117as extends C2119au<List<SplitInstallSessionState>> {
    C2117as(C2120av avVar, C2170i<List<SplitInstallSessionState>> iVar) {
        super(avVar, iVar);
    }

    /* renamed from: a */
    public final void mo33591a(List<Bundle> list) throws RemoteException {
        super.mo33591a(list);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(SplitInstallSessionState.m914a(list.get(i)));
        }
        this.f897a.mo33809b(arrayList);
    }
}
