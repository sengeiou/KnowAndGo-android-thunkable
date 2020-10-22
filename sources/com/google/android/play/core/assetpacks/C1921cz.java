package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.exoplayer2.C1470C;
import com.google.android.play.core.assetpacks.model.AssetPackStatus;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.C1982af;
import com.google.android.play.core.internal.C1998av;
import com.google.android.play.core.internal.C2040cj;
import com.google.android.play.core.internal.C2049h;
import com.google.android.play.core.tasks.C2170i;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.google.android.play.core.assetpacks.cz */
final class C1921cz implements C1966w {

    /* renamed from: a */
    private static final C1982af f573a = new C1982af("FakeAssetPackService");

    /* renamed from: h */
    private static final AtomicInteger f574h = new AtomicInteger(1);

    /* renamed from: b */
    private final String f575b;

    /* renamed from: c */
    private final C1864aw f576c;

    /* renamed from: d */
    private final C1894bz f577d;

    /* renamed from: e */
    private final Context f578e;

    /* renamed from: f */
    private final C1934dl f579f;

    /* renamed from: g */
    private final C2040cj<Executor> f580g;

    /* renamed from: i */
    private final Handler f581i = new Handler(Looper.getMainLooper());

    C1921cz(File file, C1864aw awVar, C1894bz bzVar, Context context, C1934dl dlVar, C2040cj<Executor> cjVar) {
        this.f575b = file.getAbsolutePath();
        this.f576c = awVar;
        this.f577d = bzVar;
        this.f578e = context;
        this.f579f = dlVar;
        this.f580g = cjVar;
    }

    /* renamed from: a */
    static long m446a(@AssetPackStatus int i, long j) {
        switch (i) {
            case 2:
                return j / 2;
            case 3:
            case 4:
                return j;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private final AssetPackState m447a(String str, @AssetPackStatus int i) throws LocalTestingException {
        long j = 0;
        for (File length : m450b(str)) {
            j += length.length();
        }
        String str2 = str;
        return AssetPackState.m261a(str, i, 0, m446a(i, j), j, this.f577d.mo33437b(str));
    }

    /* renamed from: a */
    private static String m448a(File file) throws LocalTestingException {
        try {
            return C1924db.m470a((List<File>) Arrays.asList(new File[]{file}));
        } catch (NoSuchAlgorithmException e) {
            throw new LocalTestingException("SHA256 algorithm not supported.", e);
        } catch (IOException e2) {
            throw new LocalTestingException(String.format("Could not digest file: %s.", new Object[]{file}), e2);
        }
    }

    /* renamed from: a */
    private final void m449a(int i, String str, @AssetPackStatus int i2) throws LocalTestingException {
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.f579f.mo33478a());
        bundle.putInt("session_id", i);
        File[] b = m450b(str);
        ArrayList arrayList = new ArrayList();
        long j = 0;
        for (File file : b) {
            j += file.length();
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(i2 == 3 ? new Intent().setData(Uri.EMPTY) : null);
            String a = C1998av.m629a(file);
            bundle.putParcelableArrayList(C2049h.m758a("chunk_intents", str, a), arrayList2);
            bundle.putString(C2049h.m758a("uncompressed_hash_sha256", str, a), m448a(file));
            bundle.putLong(C2049h.m758a("uncompressed_size", str, a), file.length());
            arrayList.add(a);
        }
        bundle.putStringArrayList(C2049h.m757a("slice_ids", str), arrayList);
        bundle.putLong(C2049h.m757a("pack_version", str), (long) this.f579f.mo33478a());
        bundle.putInt(C2049h.m757a("status", str), i2);
        bundle.putInt(C2049h.m757a("error_code", str), 0);
        bundle.putLong(C2049h.m757a("bytes_downloaded", str), m446a(i2, j));
        bundle.putLong(C2049h.m757a("total_bytes_to_download", str), j);
        bundle.putStringArrayList("pack_names", new ArrayList(Arrays.asList(new String[]{str})));
        bundle.putLong("bytes_downloaded", m446a(i2, j));
        bundle.putLong("total_bytes_to_download", j);
        this.f581i.post(new C1920cy(this, new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE").putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle)));
    }

    /* renamed from: b */
    private final File[] m450b(String str) throws LocalTestingException {
        File file = new File(this.f575b);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles(new C1919cx(str));
            if (listFiles != null) {
                if (r1 != 0) {
                    for (File a : listFiles) {
                        if (C1998av.m629a(a).equals(str)) {
                            return listFiles;
                        }
                    }
                    throw new LocalTestingException(String.format("No master slice available for pack '%s'.", new Object[]{str}));
                }
                throw new LocalTestingException(String.format("No APKs available for pack '%s'.", new Object[]{str}));
            }
            throw new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", new Object[]{str}));
        }
        throw new LocalTestingException(String.format("Local testing directory '%s' not found.", new Object[]{file}));
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo33353a(List<String> list, C1867az azVar, Map<String, Long> map) {
        f573a.mo33553c("getPackStates(%s)", list);
        C2170i iVar = new C2170i();
        this.f580g.mo33606a().execute(new C1917cv(this, list, azVar, iVar));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<AssetPackStates> mo33354a(List<String> list, List<String> list2, Map<String, Long> map) {
        f573a.mo33553c("startDownload(%s)", list2);
        C2170i iVar = new C2170i();
        this.f580g.mo33606a().execute(new C1916cu(this, list2, iVar, list));
        return iVar.mo33805a();
    }

    /* renamed from: a */
    public final Task<List<String>> mo33355a(Map<String, Long> map) {
        f573a.mo33553c("syncPacks()", new Object[0]);
        return Tasks.m1053a(new ArrayList());
    }

    /* renamed from: a */
    public final void mo33356a() {
        f573a.mo33553c("keepAlive", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33357a(int i) {
        f573a.mo33553c("notifySessionFailed", new Object[0]);
    }

    /* renamed from: a */
    public final void mo33358a(int i, String str) {
        f573a.mo33553c("notifyModuleCompleted", new Object[0]);
        this.f580g.mo33606a().execute(new C1918cw(this, i, str));
    }

    /* renamed from: a */
    public final void mo33359a(int i, String str, String str2, int i2) {
        f573a.mo33553c("notifyChunkTransferred", new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33462a(Intent intent) {
        this.f576c.mo33265a(this.f578e, intent);
    }

    /* renamed from: a */
    public final void mo33360a(String str) {
        f573a.mo33553c("removePack(%s)", str);
    }

    /* renamed from: a */
    public final void mo33361a(List<String> list) {
        f573a.mo33553c("cancelDownload(%s)", list);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33463a(List list, C1867az azVar, C2170i iVar) {
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                AssetPackState a = m447a(str, azVar.mo33369a(8, str));
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
            } catch (LocalTestingException e) {
                iVar.mo33806a((Exception) e);
                return;
            }
        }
        iVar.mo33807a(AssetPackStates.m262a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33464a(List list, C2170i iVar, List list2) {
        List list3 = list;
        C2170i iVar2 = iVar;
        HashMap hashMap = new HashMap();
        int size = list.size();
        long j = 0;
        int i = 0;
        while (i < size) {
            String str = (String) list3.get(i);
            try {
                AssetPackState a = m447a(str, 1);
                j += a.totalBytesToDownload();
                hashMap.put(str, a);
                i++;
            } catch (LocalTestingException e) {
                iVar2.mo33806a((Exception) e);
                return;
            }
        }
        int size2 = list.size();
        int i2 = 0;
        while (i2 < size2) {
            String str2 = (String) list3.get(i2);
            try {
                int andIncrement = f574h.getAndIncrement();
                m449a(andIncrement, str2, 1);
                m449a(andIncrement, str2, 2);
                m449a(andIncrement, str2, 3);
                i2++;
            } catch (LocalTestingException e2) {
                iVar2.mo33806a((Exception) e2);
                return;
            }
        }
        int size3 = list2.size();
        for (int i3 = 0; i3 < size3; i3++) {
            String str3 = (String) list2.get(i3);
            hashMap.put(str3, AssetPackState.m261a(str3, 4, 0, 0, 0, 0.0d));
        }
        iVar2.mo33807a(AssetPackStates.m262a(j, (Map<String, AssetPackState>) hashMap));
    }

    /* renamed from: b */
    public final Task<ParcelFileDescriptor> mo33362b(int i, String str, String str2, int i2) {
        f573a.mo33553c("getChunkFileDescriptor(session=%d, %s, %s, %d)", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
        C2170i iVar = new C2170i();
        try {
            for (File file : m450b(str)) {
                if (C1998av.m629a(file).equals(str2)) {
                    iVar.mo33807a(ParcelFileDescriptor.open(file, C1470C.ENCODING_PCM_MU_LAW));
                    return iVar.mo33805a();
                }
            }
            throw new LocalTestingException(String.format("Local testing slice for '%s' not found.", new Object[]{str2}));
        } catch (FileNotFoundException e) {
            f573a.mo33554d("getChunkFileDescriptor failed", e);
            iVar.mo33806a((Exception) new LocalTestingException("Asset Slice file not found.", e));
        } catch (LocalTestingException e2) {
            f573a.mo33554d("getChunkFileDescriptor failed", e2);
            iVar.mo33806a((Exception) e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final /* synthetic */ void mo33465b(int i, String str) {
        try {
            m449a(i, str, 4);
        } catch (LocalTestingException e) {
            f573a.mo33554d("notifyModuleCompleted failed", e);
        }
    }
}
