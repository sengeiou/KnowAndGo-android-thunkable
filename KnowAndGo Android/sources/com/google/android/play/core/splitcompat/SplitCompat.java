package com.google.android.play.core.splitcompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.play.core.internal.C1995as;
import com.google.android.play.core.internal.C1996at;
import com.google.android.play.core.internal.C1998av;
import com.google.android.play.core.internal.C2018bo;
import com.google.android.play.core.splitinstall.C2135l;
import com.google.android.play.core.splitinstall.C2139o;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class SplitCompat {

    /* renamed from: a */
    private static final AtomicReference<SplitCompat> f821a = new AtomicReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C2083c f822b;

    /* renamed from: c */
    private final Set<String> f823c = new HashSet();

    /* renamed from: d */
    private final C2081a f824d;

    private SplitCompat(Context context) {
        try {
            this.f822b = new C2083c(context);
            this.f824d = new C2081a(this.f822b);
        } catch (PackageManager.NameNotFoundException e) {
            throw new C2018bo((Throwable) e);
        }
    }

    /* renamed from: a */
    public static boolean m862a() {
        return f821a.get() != null;
    }

    /* renamed from: a */
    public static boolean m863a(Context context) {
        return m864a(context, true);
    }

    /* renamed from: a */
    private static boolean m864a(Context context, boolean z) {
        if (m867b()) {
            return false;
        }
        boolean compareAndSet = f821a.compareAndSet((Object) null, new SplitCompat(context));
        SplitCompat splitCompat = f821a.get();
        if (compareAndSet) {
            C2135l.f928a.mo33766a(new C1995as(context, C2096p.m909a(), new C1996at(context, splitCompat.f822b, new C1998av(), (byte[]) null), splitCompat.f822b, new C2096p()));
            C2139o.m997a(new C2092l(splitCompat));
            C2096p.m909a().execute(new C2093m(context));
        }
        try {
            splitCompat.m866b(context, z);
            return true;
        } catch (Exception e) {
            Log.e("SplitCompat", "Error installing additional splits", e);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a7 A[SYNTHETIC, Splitter:B:81:0x01a7] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void m866b(android.content.Context r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            if (r10 == 0) goto L_0x000c
            com.google.android.play.core.splitcompat.c r0 = r8.f822b     // Catch:{ all -> 0x0009 }
            r0.mo33685a()     // Catch:{ all -> 0x0009 }
            goto L_0x0018
        L_0x0009:
            r9 = move-exception
            goto L_0x024d
        L_0x000c:
            java.util.concurrent.Executor r0 = com.google.android.play.core.splitcompat.C2096p.m909a()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.n r1 = new com.google.android.play.core.splitcompat.n     // Catch:{ all -> 0x0009 }
            r1.<init>(r8)     // Catch:{ all -> 0x0009 }
            r0.execute(r1)     // Catch:{ all -> 0x0009 }
        L_0x0018:
            java.lang.String r0 = r9.getPackageName()     // Catch:{ all -> 0x0009 }
            r1 = 0
            android.content.pm.PackageManager r2 = r9.getPackageManager()     // Catch:{ NameNotFoundException -> 0x023b }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x023b }
            java.lang.String[] r3 = r2.splitNames     // Catch:{ NameNotFoundException -> 0x023b }
            if (r3 != 0) goto L_0x002f
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ NameNotFoundException -> 0x023b }
            r2.<init>()     // Catch:{ NameNotFoundException -> 0x023b }
            goto L_0x0035
        L_0x002f:
            java.lang.String[] r2 = r2.splitNames     // Catch:{ NameNotFoundException -> 0x023b }
            java.util.List r2 = java.util.Arrays.asList(r2)     // Catch:{ NameNotFoundException -> 0x023b }
        L_0x0035:
            com.google.android.play.core.splitcompat.c r0 = r8.f822b     // Catch:{ all -> 0x0009 }
            java.util.Set r0 = r0.mo33691d()     // Catch:{ all -> 0x0009 }
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0009 }
            r3.<init>()     // Catch:{ all -> 0x0009 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0009 }
        L_0x0044:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x0069
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2097q) r5     // Catch:{ all -> 0x0009 }
            java.lang.String r5 = r5.mo33705b()     // Catch:{ all -> 0x0009 }
            boolean r6 = r2.contains(r5)     // Catch:{ all -> 0x0009 }
            if (r6 == 0) goto L_0x0044
            if (r10 == 0) goto L_0x0062
            com.google.android.play.core.splitcompat.c r6 = r8.f822b     // Catch:{ all -> 0x0009 }
            r6.mo33695f(r5)     // Catch:{ all -> 0x0009 }
            goto L_0x0065
        L_0x0062:
            r3.add(r5)     // Catch:{ all -> 0x0009 }
        L_0x0065:
            r4.remove()     // Catch:{ all -> 0x0009 }
            goto L_0x0044
        L_0x0069:
            boolean r4 = r3.isEmpty()     // Catch:{ all -> 0x0009 }
            if (r4 != 0) goto L_0x007b
            java.util.concurrent.Executor r4 = com.google.android.play.core.splitcompat.C2096p.m909a()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.o r5 = new com.google.android.play.core.splitcompat.o     // Catch:{ all -> 0x0009 }
            r5.<init>(r8, r3)     // Catch:{ all -> 0x0009 }
            r4.execute(r5)     // Catch:{ all -> 0x0009 }
        L_0x007b:
            java.util.HashSet r3 = new java.util.HashSet     // Catch:{ all -> 0x0009 }
            r3.<init>()     // Catch:{ all -> 0x0009 }
            java.util.Iterator r4 = r0.iterator()     // Catch:{ all -> 0x0009 }
        L_0x0084:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x009e
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2097q) r5     // Catch:{ all -> 0x0009 }
            java.lang.String r5 = r5.mo33705b()     // Catch:{ all -> 0x0009 }
            boolean r6 = com.google.android.play.core.splitinstall.C2140p.m999b(r5)     // Catch:{ all -> 0x0009 }
            if (r6 != 0) goto L_0x0084
            r3.add(r5)     // Catch:{ all -> 0x0009 }
            goto L_0x0084
        L_0x009e:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0009 }
        L_0x00a2:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x0009 }
            if (r4 == 0) goto L_0x00b8
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x0009 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x0009 }
            boolean r5 = com.google.android.play.core.splitinstall.C2140p.m999b(r4)     // Catch:{ all -> 0x0009 }
            if (r5 != 0) goto L_0x00a2
            r3.add(r4)     // Catch:{ all -> 0x0009 }
            goto L_0x00a2
        L_0x00b8:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ all -> 0x0009 }
            int r4 = r0.size()     // Catch:{ all -> 0x0009 }
            r2.<init>(r4)     // Catch:{ all -> 0x0009 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0009 }
        L_0x00c5:
            boolean r4 = r0.hasNext()     // Catch:{ all -> 0x0009 }
            if (r4 == 0) goto L_0x00fb
            java.lang.Object r4 = r0.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r4 = (com.google.android.play.core.splitcompat.C2097q) r4     // Catch:{ all -> 0x0009 }
            java.lang.String r5 = r4.mo33705b()     // Catch:{ all -> 0x0009 }
            boolean r5 = com.google.android.play.core.splitinstall.C2140p.m998a(r5)     // Catch:{ all -> 0x0009 }
            if (r5 != 0) goto L_0x00f7
            java.lang.String r5 = r4.mo33705b()     // Catch:{ all -> 0x0009 }
            boolean r6 = com.google.android.play.core.splitinstall.C2140p.m998a(r5)     // Catch:{ all -> 0x0009 }
            if (r6 == 0) goto L_0x00e8
            java.lang.String r5 = ""
            goto L_0x00f1
        L_0x00e8:
            java.lang.String r6 = "\\.config\\."
            r7 = 2
            java.lang.String[] r5 = r5.split(r6, r7)     // Catch:{ all -> 0x0009 }
            r5 = r5[r1]     // Catch:{ all -> 0x0009 }
        L_0x00f1:
            boolean r5 = r3.contains(r5)     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x00c5
        L_0x00f7:
            r2.add(r4)     // Catch:{ all -> 0x0009 }
            goto L_0x00c5
        L_0x00fb:
            com.google.android.play.core.splitcompat.k r0 = new com.google.android.play.core.splitcompat.k     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.c r1 = r8.f822b     // Catch:{ all -> 0x0009 }
            r0.<init>(r1)     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.internal.au r1 = com.google.android.play.core.internal.C1998av.m628a()     // Catch:{ all -> 0x0009 }
            java.lang.ClassLoader r3 = r9.getClassLoader()     // Catch:{ all -> 0x0009 }
            if (r10 == 0) goto L_0x0114
            java.util.Set r0 = r0.mo33698a()     // Catch:{ all -> 0x0009 }
            r1.mo33569a(r3, r0)     // Catch:{ all -> 0x0009 }
            goto L_0x0132
        L_0x0114:
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0009 }
        L_0x0118:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x0132
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2097q) r5     // Catch:{ all -> 0x0009 }
            java.util.Set r5 = r0.mo33699a(r5)     // Catch:{ all -> 0x0009 }
            if (r5 != 0) goto L_0x012e
            r4.remove()     // Catch:{ all -> 0x0009 }
            goto L_0x0118
        L_0x012e:
            r1.mo33569a(r3, r5)     // Catch:{ all -> 0x0009 }
            goto L_0x0118
        L_0x0132:
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ all -> 0x0009 }
            r0.<init>()     // Catch:{ all -> 0x0009 }
            java.util.Iterator r4 = r2.iterator()     // Catch:{ all -> 0x0009 }
        L_0x013b:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0009 }
            if (r5 == 0) goto L_0x01b0
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r5 = (com.google.android.play.core.splitcompat.C2097q) r5     // Catch:{ all -> 0x0009 }
            java.util.zip.ZipFile r6 = new java.util.zip.ZipFile     // Catch:{ IOException -> 0x01a3 }
            java.io.File r7 = r5.mo33704a()     // Catch:{ IOException -> 0x01a3 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x01a3 }
            java.lang.String r7 = "classes.dex"
            java.util.zip.ZipEntry r7 = r6.getEntry(r7)     // Catch:{ IOException -> 0x01a1 }
            r6.close()     // Catch:{ IOException -> 0x01a1 }
            if (r7 == 0) goto L_0x0199
            com.google.android.play.core.splitcompat.c r6 = r8.f822b     // Catch:{ all -> 0x0009 }
            java.lang.String r7 = r5.mo33705b()     // Catch:{ all -> 0x0009 }
            java.io.File r6 = r6.mo33690c((java.lang.String) r7)     // Catch:{ all -> 0x0009 }
            java.io.File r7 = r5.mo33704a()     // Catch:{ all -> 0x0009 }
            boolean r6 = r1.mo33570a(r3, r6, r7, r10)     // Catch:{ all -> 0x0009 }
            if (r6 == 0) goto L_0x0170
            goto L_0x0199
        L_0x0170:
            java.io.File r5 = r5.mo33704a()     // Catch:{ all -> 0x0009 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0009 }
            java.lang.String r6 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0009 }
            int r6 = r6.length()     // Catch:{ all -> 0x0009 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0009 }
            int r6 = r6 + 24
            r7.<init>(r6)     // Catch:{ all -> 0x0009 }
            java.lang.String r6 = "split was not installed "
            r7.append(r6)     // Catch:{ all -> 0x0009 }
            r7.append(r5)     // Catch:{ all -> 0x0009 }
            java.lang.String r5 = "SplitCompat"
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0009 }
            android.util.Log.w(r5, r6)     // Catch:{ all -> 0x0009 }
            goto L_0x013b
        L_0x0199:
            java.io.File r5 = r5.mo33704a()     // Catch:{ all -> 0x0009 }
            r0.add(r5)     // Catch:{ all -> 0x0009 }
            goto L_0x013b
        L_0x01a1:
            r9 = move-exception
            goto L_0x01a5
        L_0x01a3:
            r9 = move-exception
            r6 = 0
        L_0x01a5:
            if (r6 == 0) goto L_0x01af
            r6.close()     // Catch:{ IOException -> 0x01ab }
            goto L_0x01af
        L_0x01ab:
            r10 = move-exception
            com.google.android.play.core.internal.C2039ci.m739a(r9, r10)     // Catch:{ all -> 0x0009 }
        L_0x01af:
            throw r9     // Catch:{ all -> 0x0009 }
        L_0x01b0:
            com.google.android.play.core.splitcompat.C2081a.m869b(r9, r0)     // Catch:{ all -> 0x0009 }
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ all -> 0x0009 }
            r9.<init>()     // Catch:{ all -> 0x0009 }
            java.util.Iterator r10 = r2.iterator()     // Catch:{ all -> 0x0009 }
        L_0x01bc:
            boolean r1 = r10.hasNext()     // Catch:{ all -> 0x0009 }
            if (r1 == 0) goto L_0x022d
            java.lang.Object r1 = r10.next()     // Catch:{ all -> 0x0009 }
            com.google.android.play.core.splitcompat.q r1 = (com.google.android.play.core.splitcompat.C2097q) r1     // Catch:{ all -> 0x0009 }
            java.io.File r2 = r1.mo33704a()     // Catch:{ all -> 0x0009 }
            boolean r2 = r0.contains(r2)     // Catch:{ all -> 0x0009 }
            if (r2 == 0) goto L_0x0203
            java.lang.String r2 = r1.mo33705b()     // Catch:{ all -> 0x0009 }
            java.lang.String r3 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0009 }
            int r3 = r3.length()     // Catch:{ all -> 0x0009 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0009 }
            int r3 = r3 + 30
            r4.<init>(r3)     // Catch:{ all -> 0x0009 }
            java.lang.String r3 = "Split '"
            r4.append(r3)     // Catch:{ all -> 0x0009 }
            r4.append(r2)     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = "' installation emulated"
            r4.append(r2)     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = "SplitCompat"
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0009 }
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = r1.mo33705b()     // Catch:{ all -> 0x0009 }
            r9.add(r1)     // Catch:{ all -> 0x0009 }
            goto L_0x01bc
        L_0x0203:
            java.lang.String r1 = r1.mo33705b()     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0009 }
            int r2 = r2.length()     // Catch:{ all -> 0x0009 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0009 }
            int r2 = r2 + 35
            r3.<init>(r2)     // Catch:{ all -> 0x0009 }
            java.lang.String r2 = "Split '"
            r3.append(r2)     // Catch:{ all -> 0x0009 }
            r3.append(r1)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "' installation not emulated."
            r3.append(r1)     // Catch:{ all -> 0x0009 }
            java.lang.String r1 = "SplitCompat"
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0009 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0009 }
            goto L_0x01bc
        L_0x022d:
            java.util.Set<java.lang.String> r10 = r8.f823c     // Catch:{ all -> 0x0009 }
            monitor-enter(r10)     // Catch:{ all -> 0x0009 }
            java.util.Set<java.lang.String> r0 = r8.f823c     // Catch:{ all -> 0x0238 }
            r0.addAll(r9)     // Catch:{ all -> 0x0238 }
            monitor-exit(r10)     // Catch:{ all -> 0x0238 }
            monitor-exit(r8)
            return
        L_0x0238:
            r9 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0238 }
            throw r9     // Catch:{ all -> 0x0009 }
        L_0x023b:
            r9 = move-exception
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x0009 }
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0009 }
            r2[r1] = r0     // Catch:{ all -> 0x0009 }
            java.lang.String r0 = "Cannot load data for application '%s'"
            java.lang.String r0 = java.lang.String.format(r0, r2)     // Catch:{ all -> 0x0009 }
            r10.<init>(r0, r9)     // Catch:{ all -> 0x0009 }
            throw r10     // Catch:{ all -> 0x0009 }
        L_0x024d:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.splitcompat.SplitCompat.m866b(android.content.Context, boolean):void");
    }

    /* renamed from: b */
    private static boolean m867b() {
        return Build.VERSION.SDK_INT < 21;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final Set<String> m868c() {
        HashSet hashSet;
        synchronized (this.f823c) {
            hashSet = new HashSet(this.f823c);
        }
        return hashSet;
    }

    public static boolean install(@NonNull Context context) {
        return m864a(context, false);
    }

    public static boolean installActivity(@NonNull Context context) {
        if (m867b()) {
            return false;
        }
        SplitCompat splitCompat = f821a.get();
        if (splitCompat != null) {
            return splitCompat.f824d.mo33680a(context, splitCompat.m868c());
        }
        throw new IllegalStateException("SplitCompat.installActivity can only be called if SplitCompat.install is first called at startup on application context.");
    }
}
