package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2061t;
import com.google.android.play.core.tasks.C2170i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.ak */
class C1852ak<T> extends C2061t {

    /* renamed from: a */
    final C2170i<T> f342a;

    /* renamed from: b */
    final /* synthetic */ C1859ar f343b;

    C1852ak(C1859ar arVar, C2170i<T> iVar) {
        this.f343b = arVar;
        this.f342a = iVar;
    }

    C1852ak(C1859ar arVar, C2170i iVar, byte[] bArr) {
        this(arVar, iVar);
    }

    C1852ak(C1859ar arVar, C2170i iVar, char[] cArr) {
        this(arVar, iVar);
    }

    C1852ak(C1859ar arVar, C2170i iVar, int[] iArr) {
        this(arVar, iVar);
    }

    C1852ak(C1859ar arVar, C2170i iVar, short[] sArr) {
        this(arVar, iVar);
    }

    /* renamed from: a */
    public void mo33340a() {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onCancelDownloads()", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33341a(int i) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onCancelDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo33342a(int i, Bundle bundle) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onStartDownload(%d)", Integer.valueOf(i));
    }

    /* renamed from: a */
    public void mo33343a(Bundle bundle) {
        this.f343b.f358e.mo33561a();
        int i = bundle.getInt("error_code");
        C1859ar.f354a.mo33552b("onError(%d)", Integer.valueOf(i));
        this.f342a.mo33808b((Exception) new AssetPackException(i));
    }

    /* renamed from: a */
    public void mo33344a(Bundle bundle, Bundle bundle2) {
        this.f343b.f359f.mo33561a();
        C1859ar.f354a.mo33553c("onKeepAlive(%b)", Boolean.valueOf(bundle.getBoolean("keep_alive")));
    }

    /* renamed from: a */
    public void mo33345a(List<Bundle> list) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onGetSessionStates", new Object[0]);
    }

    /* renamed from: b */
    public void mo33346b() {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onRemoveModule()", new Object[0]);
    }

    /* renamed from: b */
    public final void mo33347b(int i) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onGetSession(%d)", Integer.valueOf(i));
    }

    /* renamed from: b */
    public void mo33348b(Bundle bundle) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onNotifyChunkTransferred(%s, %s, %d, session=%d)", bundle.getString("module_name"), bundle.getString("slice_id"), Integer.valueOf(bundle.getInt("chunk_number")), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: b */
    public void mo33349b(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onGetChunkFileDescriptor", new Object[0]);
    }

    /* renamed from: c */
    public void mo33350c(Bundle bundle) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onNotifyModuleCompleted(%s, sessionId=%d)", bundle.getString("module_name"), Integer.valueOf(bundle.getInt("session_id")));
    }

    /* renamed from: c */
    public void mo33351c(Bundle bundle, Bundle bundle2) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onRequestDownloadInfo()", new Object[0]);
    }

    /* renamed from: d */
    public void mo33352d(Bundle bundle) {
        this.f343b.f358e.mo33561a();
        C1859ar.f354a.mo33553c("onNotifySessionFailed(%d)", Integer.valueOf(bundle.getInt("session_id")));
    }
}
