package com.google.android.play.core.splitinstall.testing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.internal.C1981ae;
import com.google.android.play.core.internal.C1998av;
import com.google.android.play.core.internal.C2027bx;
import com.google.android.play.core.splitcompat.C2096p;
import com.google.android.play.core.splitinstall.C2128e;
import com.google.android.play.core.splitinstall.C2131h;
import com.google.android.play.core.splitinstall.C2135l;
import com.google.android.play.core.splitinstall.C2140p;
import com.google.android.play.core.splitinstall.SplitInstallException;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallSessionState;
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener;
import com.google.android.play.core.tasks.Task;
import com.google.android.play.core.tasks.Tasks;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FakeSplitInstallManager implements SplitInstallManager {

    /* renamed from: a */
    public static final /* synthetic */ int f948a = 0;

    /* renamed from: c */
    private static final long f949c = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b */
    private final Handler f950b;

    /* renamed from: d */
    private final Context f951d;

    /* renamed from: e */
    private final C2140p f952e;

    /* renamed from: f */
    private final C2027bx f953f;

    /* renamed from: g */
    private final C1981ae<SplitInstallSessionState> f954g;

    /* renamed from: h */
    private final Executor f955h;

    /* renamed from: i */
    private final C2128e f956i;

    /* renamed from: j */
    private final File f957j;

    /* renamed from: k */
    private final AtomicReference<SplitInstallSessionState> f958k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Set<String> f959l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public final Set<String> f960m;

    /* renamed from: n */
    private final AtomicBoolean f961n;

    /* renamed from: o */
    private final C2145a f962o;

    @Deprecated
    public FakeSplitInstallManager(Context context, File file) {
        this(context, file, new C2140p(context, context.getPackageName()));
    }

    FakeSplitInstallManager(Context context, @Nullable File file, C2140p pVar) {
        Executor a = C2096p.m909a();
        C2027bx bxVar = new C2027bx(context);
        C2145a aVar = C2145a.f964a;
        this.f950b = new Handler(Looper.getMainLooper());
        this.f958k = new AtomicReference<>();
        this.f959l = Collections.synchronizedSet(new HashSet());
        this.f960m = Collections.synchronizedSet(new HashSet());
        this.f961n = new AtomicBoolean(false);
        this.f951d = context;
        this.f957j = file;
        this.f952e = pVar;
        this.f955h = a;
        this.f953f = bxVar;
        this.f962o = aVar;
        this.f954g = new C1981ae<>();
        this.f956i = C2135l.f928a;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m1014a(int i, SplitInstallSessionState splitInstallSessionState) {
        int status;
        if (splitInstallSessionState != null && i == splitInstallSessionState.sessionId() && ((status = splitInstallSessionState.status()) == 1 || status == 2 || status == 8 || status == 9 || status == 7)) {
            return SplitInstallSessionState.create(i, 7, splitInstallSessionState.errorCode(), splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.moduleNames(), splitInstallSessionState.languages());
        }
        throw new SplitInstallException(-3);
    }

    @Nullable
    /* renamed from: a */
    private final synchronized SplitInstallSessionState m1015a(C2154j jVar) {
        SplitInstallSessionState c = m1028c();
        SplitInstallSessionState a = jVar.mo33777a(c);
        if (this.f958k.compareAndSet(c, a)) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    static final /* synthetic */ SplitInstallSessionState m1016a(Integer num, int i, int i2, Long l, Long l2, List list, List list2, SplitInstallSessionState splitInstallSessionState) {
        SplitInstallSessionState create = splitInstallSessionState == null ? SplitInstallSessionState.create(0, 0, 0, 0, 0, new ArrayList(), new ArrayList()) : splitInstallSessionState;
        return SplitInstallSessionState.create(num == null ? create.sessionId() : num.intValue(), i, i2, l == null ? create.bytesDownloaded() : l.longValue(), l2 == null ? create.totalBytesToDownload() : l2.longValue(), list == null ? create.moduleNames() : list, list2 == null ? create.languages() : list2);
    }

    /* renamed from: a */
    private static String m1017a(String str) {
        return str.split("\\.config\\.", 2)[0];
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m1022a(List<Intent> list, List<String> list2, List<String> list3, long j, boolean z) {
        List<Intent> list4 = list;
        this.f956i.mo33762a().mo33566a(list, new C2153i(this, list2, list3, j, z, list));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m1023a(int i) {
        return m1024a(6, i, (Long) null, (Long) null, (List<String>) null, (Integer) null, (List<String>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m1024a(int i, int i2, @Nullable Long l, @Nullable Long l2, @Nullable List<String> list, @Nullable Integer num, @Nullable List<String> list2) {
        SplitInstallSessionState a = m1015a((C2154j) new C2146b(num, i, i2, l, l2, list, list2));
        if (a == null) {
            return false;
        }
        m1027b(a);
        return true;
    }

    /* renamed from: b */
    private final void m1027b(SplitInstallSessionState splitInstallSessionState) {
        this.f950b.post(new C2150f(this, splitInstallSessionState));
    }

    @Nullable
    /* renamed from: c */
    private final SplitInstallSessionState m1028c() {
        return this.f958k.get();
    }

    /* renamed from: d */
    private final C2131h m1029d() {
        C2131h c = this.f952e.mo33769c();
        if (c != null) {
            return c;
        }
        throw new IllegalStateException("Language information could not be found. Make sure you are using the target application context, not the tests context, and the app is built as a bundle.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final File mo33771a() {
        return this.f957j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33772a(long j, List list, List list2, List list3) {
        long j2 = j;
        long j3 = j2 / 3;
        long j4 = 0;
        int i = 0;
        while (i < 3) {
            j4 = Math.min(j2, j4 + j3);
            m1024a(2, 0, Long.valueOf(j4), Long.valueOf(j), (List<String>) null, (Integer) null, (List<String>) null);
            SystemClock.sleep(f949c);
            SplitInstallSessionState c = m1028c();
            if (c.status() != 9 && c.status() != 7 && c.status() != 6) {
                i++;
            } else {
                return;
            }
        }
        this.f955h.execute(new C2152h(this, list, list2, list3, j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33773a(SplitInstallSessionState splitInstallSessionState) {
        this.f954g.mo33548a(splitInstallSessionState);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33774a(List list, List list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            File file = (File) list.get(i);
            String a = C1998av.m629a(file);
            Uri fromFile = Uri.fromFile(file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, this.f951d.getContentResolver().getType(fromFile));
            intent.addFlags(1);
            intent.putExtra("module_name", m1017a(a));
            intent.putExtra("split_id", a);
            arrayList.add(intent);
            arrayList2.add(m1017a(C1998av.m629a(file)));
        }
        SplitInstallSessionState c = m1028c();
        if (c != null) {
            this.f955h.execute(new C2151g(this, c.totalBytesToDownload(), arrayList, arrayList2, list2));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final /* synthetic */ void mo33775a(List list, List list2, List list3, long j) {
        if (this.f961n.get()) {
            m1023a(-6);
        } else {
            m1022a((List<Intent>) list, (List<String>) list2, (List<String>) list3, j, false);
        }
    }

    public final Task<Void> cancelInstall(int i) {
        try {
            SplitInstallSessionState a = m1015a((C2154j) new C2149e(i));
            if (a != null) {
                m1027b(a);
            }
            return Tasks.m1053a(null);
        } catch (SplitInstallException e) {
            return Tasks.m1052a((Exception) e);
        }
    }

    public final Task<Void> deferredInstall(List<String> list) {
        return Tasks.m1052a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageInstall(List<Locale> list) {
        return Tasks.m1052a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredLanguageUninstall(List<Locale> list) {
        return Tasks.m1052a((Exception) new SplitInstallException(-5));
    }

    public final Task<Void> deferredUninstall(List<String> list) {
        return Tasks.m1052a((Exception) new SplitInstallException(-5));
    }

    public final Set<String> getInstalledLanguages() {
        return new HashSet(this.f960m);
    }

    public final Set<String> getInstalledModules() {
        return new HashSet(this.f959l);
    }

    public final Task<SplitInstallSessionState> getSessionState(int i) {
        SplitInstallSessionState c = m1028c();
        return (c == null || c.sessionId() != i) ? Tasks.m1052a((Exception) new SplitInstallException(-4)) : Tasks.m1053a(c);
    }

    public final Task<List<SplitInstallSessionState>> getSessionStates() {
        SplitInstallSessionState c = m1028c();
        return Tasks.m1053a(c != null ? Collections.singletonList(c) : Collections.emptyList());
    }

    public final void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f954g.mo33547a(splitInstallStateUpdatedListener);
    }

    public void setShouldNetworkError(boolean z) {
        this.f961n.set(z);
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, Activity activity, int i) throws IntentSender.SendIntentException {
        return false;
    }

    public final boolean startConfirmationDialogForResult(SplitInstallSessionState splitInstallSessionState, IntentSenderForResultStarter intentSenderForResultStarter, int i) throws IntentSender.SendIntentException {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0133, code lost:
        if (r4.contains(r15) == false) goto L_0x013a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.play.core.tasks.Task<java.lang.Integer> startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest r22) {
        /*
            r21 = this;
            r9 = r21
            com.google.android.play.core.splitinstall.testing.d r0 = new com.google.android.play.core.splitinstall.testing.d     // Catch:{ SplitInstallException -> 0x022c }
            r1 = r22
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x022c }
            com.google.android.play.core.splitinstall.SplitInstallSessionState r0 = r9.m1015a((com.google.android.play.core.splitinstall.testing.C2154j) r0)     // Catch:{ SplitInstallException -> 0x022c }
            if (r0 == 0) goto L_0x0220
            int r0 = r0.sessionId()     // Catch:{ SplitInstallException -> 0x022c }
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r2 = r22.getLanguages()
            java.util.Iterator r2 = r2.iterator()
        L_0x0020:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0034
            java.lang.Object r3 = r2.next()
            java.util.Locale r3 = (java.util.Locale) r3
            java.lang.String r3 = r3.getLanguage()
            r10.add(r3)
            goto L_0x0020
        L_0x0034:
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            java.io.File r3 = r9.f957j
            java.io.File[] r3 = r3.listFiles()
            if (r3 != 0) goto L_0x0058
            java.lang.String r0 = "FakeSplitInstallManager"
            java.lang.String r1 = "Specified splits directory does not exist."
            android.util.Log.w(r0, r1)
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -5
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m1052a((java.lang.Exception) r0)
            return r0
        L_0x0058:
            int r4 = r3.length
            r8 = 0
            r12 = 0
        L_0x005c:
            if (r8 >= r4) goto L_0x019f
            r14 = r3[r8]
            java.lang.String r15 = com.google.android.play.core.internal.C1998av.m629a(r14)
            java.lang.String r5 = m1017a((java.lang.String) r15)
            java.util.List r6 = r22.getModuleNames()
            boolean r5 = r6.contains(r5)
            if (r5 == 0) goto L_0x0136
            java.lang.String r5 = m1017a((java.lang.String) r15)
            java.util.HashSet r6 = new java.util.HashSet
            com.google.android.play.core.internal.bx r7 = r9.f953f
            java.util.List r7 = r7.mo33599a()
            r6.<init>(r7)
            com.google.android.play.core.splitinstall.h r7 = r21.m1029d()
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r16 = 0
            r1[r16] = r5
            java.util.List r1 = java.util.Arrays.asList(r1)
            java.util.Map r1 = r7.mo33765a(r1)
            java.util.HashSet r5 = new java.util.HashSet
            r5.<init>()
            java.util.Collection r7 = r1.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a1:
            boolean r17 = r7.hasNext()
            if (r17 == 0) goto L_0x00b7
            java.lang.Object r17 = r7.next()
            r18 = r3
            r3 = r17
            java.util.Set r3 = (java.util.Set) r3
            r5.addAll(r3)
            r3 = r18
            goto L_0x00a1
        L_0x00b7:
            r18 = r3
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x00c2:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00f0
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            r19 = r4
            java.lang.String r4 = "_"
            boolean r4 = r7.contains(r4)
            if (r4 == 0) goto L_0x00e5
            java.lang.String r4 = "_"
            r20 = r6
            r6 = -1
            java.lang.String[] r4 = r7.split(r4, r6)
            r6 = 0
            r7 = r4[r6]
            goto L_0x00e8
        L_0x00e5:
            r20 = r6
            r6 = 0
        L_0x00e8:
            r3.add(r7)
            r4 = r19
            r6 = r20
            goto L_0x00c2
        L_0x00f0:
            r19 = r4
            r6 = 0
            java.util.Set<java.lang.String> r4 = r9.f960m
            r3.addAll(r4)
            r3.addAll(r10)
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0108:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0129
            java.lang.Object r7 = r1.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r6 = r7.getKey()
            boolean r6 = r3.contains(r6)
            if (r6 == 0) goto L_0x0127
            java.lang.Object r6 = r7.getValue()
            java.util.Collection r6 = (java.util.Collection) r6
            r4.addAll(r6)
        L_0x0127:
            r6 = 0
            goto L_0x0108
        L_0x0129:
            boolean r1 = r5.contains(r15)
            if (r1 == 0) goto L_0x0186
            boolean r1 = r4.contains(r15)
            if (r1 == 0) goto L_0x013a
            goto L_0x0186
        L_0x0136:
            r18 = r3
            r19 = r4
        L_0x013a:
            java.util.List r1 = r22.getLanguages()
            java.util.ArrayList r3 = new java.util.ArrayList
            java.util.Set<java.lang.String> r4 = r9.f959l
            r3.<init>(r4)
            java.lang.String r4 = ""
            java.lang.String r5 = "base"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5}
            java.util.List r4 = java.util.Arrays.asList(r4)
            r3.addAll(r4)
            com.google.android.play.core.splitinstall.h r4 = r21.m1029d()
            java.util.Map r3 = r4.mo33765a(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x0160:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x0195
            java.lang.Object r4 = r1.next()
            java.util.Locale r4 = (java.util.Locale) r4
            java.lang.String r5 = r4.getLanguage()
            boolean r5 = r3.containsKey(r5)
            if (r5 == 0) goto L_0x0160
            java.lang.String r4 = r4.getLanguage()
            java.lang.Object r4 = r3.get(r4)
            java.util.Set r4 = (java.util.Set) r4
            boolean r4 = r4.contains(r15)
            if (r4 == 0) goto L_0x0160
        L_0x0186:
            long r3 = r14.length()
            long r12 = r12 + r3
            java.lang.String r1 = com.google.android.play.core.internal.C1998av.m629a(r14)
            r2.add(r1)
            r11.add(r14)
        L_0x0195:
            int r8 = r8 + 1
            r3 = r18
            r4 = r19
            r1 = r22
            goto L_0x005c
        L_0x019f:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            java.util.List r3 = r22.getModuleNames()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r4 = r4 + 21
            int r4 = r4 + r5
            r6.<init>(r4)
            java.lang.String r4 = "availableSplits"
            r6.append(r4)
            r6.append(r1)
            java.lang.String r1 = " want "
            r6.append(r1)
            r6.append(r3)
            java.lang.String r1 = "FakeSplitInstallManager"
            java.lang.String r3 = r6.toString()
            android.util.Log.i(r1, r3)
            java.util.HashSet r1 = new java.util.HashSet
            java.util.List r3 = r22.getModuleNames()
            r1.<init>(r3)
            boolean r1 = r2.containsAll(r1)
            if (r1 != 0) goto L_0x01f6
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException
            r1 = -2
            r0.<init>(r1)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m1052a((java.lang.Exception) r0)
            return r0
        L_0x01f6:
            r1 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r1)
            java.lang.Long r5 = java.lang.Long.valueOf(r12)
            java.util.List r6 = r22.getModuleNames()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2 = 1
            r3 = 0
            r1 = r21
            r7 = r0
            r8 = r10
            r1.m1024a(r2, r3, r4, r5, r6, r7, r8)
            java.util.concurrent.Executor r1 = r9.f955h
            com.google.android.play.core.splitinstall.testing.c r2 = new com.google.android.play.core.splitinstall.testing.c
            r2.<init>(r9, r11, r10)
            r1.execute(r2)
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m1053a(r0)
            return r0
        L_0x0220:
            com.google.android.play.core.splitinstall.SplitInstallException r0 = new com.google.android.play.core.splitinstall.SplitInstallException     // Catch:{ SplitInstallException -> 0x022c }
            r1 = -100
            r0.<init>(r1)     // Catch:{ SplitInstallException -> 0x022c }
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m1052a((java.lang.Exception) r0)     // Catch:{ SplitInstallException -> 0x022c }
            return r0
        L_0x022c:
            r0 = move-exception
            com.google.android.play.core.tasks.Task r0 = com.google.android.play.core.tasks.Tasks.m1052a((java.lang.Exception) r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitinstall.testing.FakeSplitInstallManager.startInstall(com.google.android.play.core.splitinstall.SplitInstallRequest):com.google.android.play.core.tasks.Task");
    }

    public final void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener) {
        this.f954g.mo33549b(splitInstallStateUpdatedListener);
    }
}
