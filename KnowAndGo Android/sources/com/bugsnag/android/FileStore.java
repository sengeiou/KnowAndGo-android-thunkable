package com.bugsnag.android;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.JsonStream.Streamable;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class FileStore<T extends JsonStream.Streamable> {
    private final Comparator<File> comparator;
    @NonNull
    protected final Configuration config;
    protected final Delegate delegate;
    final Lock lock = new ReentrantLock();
    private final int maxStoreCount;
    final Collection<File> queuedFiles = new ConcurrentSkipListSet();
    @Nullable
    final String storeDirectory;

    interface Delegate {
        void onErrorIOFailure(Exception exc, File file, String str);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public abstract String getFilename(Object obj);

    FileStore(@NonNull Configuration configuration, @NonNull Context context, String str, int i, Comparator<File> comparator2, Delegate delegate2) {
        this.config = configuration;
        this.maxStoreCount = i;
        this.comparator = comparator2;
        this.delegate = delegate2;
        String str2 = null;
        try {
            String str3 = context.getCacheDir().getAbsolutePath() + str;
            File file = new File(str3);
            file.mkdirs();
            if (!file.exists()) {
                Logger.warn("Could not prepare file storage directory");
            } else {
                str2 = str3;
            }
        } catch (Exception e) {
            Logger.warn("Could not prepare file storage directory", e);
        }
        this.storeDirectory = str2;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[Catch:{ all -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052 A[SYNTHETIC, Splitter:B:24:0x0052] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006c A[SYNTHETIC, Splitter:B:32:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void enqueueContentForDelivery(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.storeDirectory
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.String r0 = r8.getFilename(r9)
            r8.discardOldestFileIfNeeded()
            java.util.concurrent.locks.Lock r1 = r8.lock
            r1.lock()
            r1 = 0
            r2 = 0
            r3 = 1
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x003c }
            r4.<init>(r0)     // Catch:{ Exception -> 0x003c }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x003c }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x003c }
            java.lang.String r7 = "UTF-8"
            r6.<init>(r4, r7)     // Catch:{ Exception -> 0x003c }
            r5.<init>(r6)     // Catch:{ Exception -> 0x003c }
            r5.write(r9)     // Catch:{ Exception -> 0x0037, all -> 0x0034 }
            r5.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x0064
        L_0x002c:
            r9 = move-exception
            java.lang.String r1 = "Failed to close unsent payload writer (%s) "
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r0
            goto L_0x005d
        L_0x0034:
            r9 = move-exception
            r1 = r5
            goto L_0x006a
        L_0x0037:
            r9 = move-exception
            r1 = r5
            goto L_0x003d
        L_0x003a:
            r9 = move-exception
            goto L_0x006a
        L_0x003c:
            r9 = move-exception
        L_0x003d:
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x003a }
            r4.<init>(r0)     // Catch:{ all -> 0x003a }
            com.bugsnag.android.FileStore$Delegate r5 = r8.delegate     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x004d
            com.bugsnag.android.FileStore$Delegate r5 = r8.delegate     // Catch:{ all -> 0x003a }
            java.lang.String r6 = "NDK Crash report copy"
            r5.onErrorIOFailure(r9, r4, r6)     // Catch:{ all -> 0x003a }
        L_0x004d:
            com.bugsnag.android.IOUtils.deleteFile(r4)     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0064
            r1.close()     // Catch:{ Exception -> 0x0056 }
            goto L_0x0064
        L_0x0056:
            r9 = move-exception
            java.lang.String r1 = "Failed to close unsent payload writer (%s) "
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r0
        L_0x005d:
            java.lang.String r0 = java.lang.String.format(r1, r3)
            com.bugsnag.android.Logger.warn(r0, r9)
        L_0x0064:
            java.util.concurrent.locks.Lock r9 = r8.lock
            r9.unlock()
            return
        L_0x006a:
            if (r1 == 0) goto L_0x007e
            r1.close()     // Catch:{ Exception -> 0x0070 }
            goto L_0x007e
        L_0x0070:
            r1 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r2] = r0
            java.lang.String r0 = "Failed to close unsent payload writer (%s) "
            java.lang.String r0 = java.lang.String.format(r0, r3)
            com.bugsnag.android.Logger.warn(r0, r1)
        L_0x007e:
            java.util.concurrent.locks.Lock r0 = r8.lock
            r0.unlock()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.FileStore.enqueueContentForDelivery(java.lang.String):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.util.concurrent.locks.Lock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.util.concurrent.locks.Lock} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: com.bugsnag.android.JsonStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: java.util.concurrent.locks.Lock} */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v15 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055 A[Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047, all -> 0x0070 }] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String write(@androidx.annotation.NonNull com.bugsnag.android.JsonStream.Streamable r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.storeDirectory
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r6.discardOldestFileIfNeeded()
            java.lang.String r0 = r6.getFilename(r7)
            java.util.concurrent.locks.Lock r2 = r6.lock
            r2.lock()
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            java.lang.String r5 = "UTF-8"
            r4.<init>(r2, r5)     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            com.bugsnag.android.JsonStream r2 = new com.bugsnag.android.JsonStream     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0060, Exception -> 0x004a, all -> 0x0047 }
            r2.value((com.bugsnag.android.JsonStream.Streamable) r7)     // Catch:{ FileNotFoundException -> 0x0045, Exception -> 0x0043 }
            java.lang.String r7 = "Saved unsent payload to disk (%s) "
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ FileNotFoundException -> 0x0045, Exception -> 0x0043 }
            r4 = 0
            r3[r4] = r0     // Catch:{ FileNotFoundException -> 0x0045, Exception -> 0x0043 }
            java.lang.String r7 = java.lang.String.format(r7, r3)     // Catch:{ FileNotFoundException -> 0x0045, Exception -> 0x0043 }
            com.bugsnag.android.Logger.info(r7)     // Catch:{ FileNotFoundException -> 0x0045, Exception -> 0x0043 }
            com.bugsnag.android.IOUtils.closeQuietly(r2)
            java.util.concurrent.locks.Lock r7 = r6.lock
            r7.unlock()
            return r0
        L_0x0043:
            r7 = move-exception
            goto L_0x004c
        L_0x0045:
            r7 = move-exception
            goto L_0x0062
        L_0x0047:
            r7 = move-exception
            r2 = r1
            goto L_0x0071
        L_0x004a:
            r7 = move-exception
            r2 = r1
        L_0x004c:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0070 }
            r3.<init>(r0)     // Catch:{ all -> 0x0070 }
            com.bugsnag.android.FileStore$Delegate r0 = r6.delegate     // Catch:{ all -> 0x0070 }
            if (r0 == 0) goto L_0x005c
            com.bugsnag.android.FileStore$Delegate r0 = r6.delegate     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "Crash report serialization"
            r0.onErrorIOFailure(r7, r3, r4)     // Catch:{ all -> 0x0070 }
        L_0x005c:
            com.bugsnag.android.IOUtils.deleteFile(r3)     // Catch:{ all -> 0x0070 }
            goto L_0x0067
        L_0x0060:
            r7 = move-exception
            r2 = r1
        L_0x0062:
            java.lang.String r0 = "Ignoring FileNotFoundException - unable to create file"
            com.bugsnag.android.Logger.warn(r0, r7)     // Catch:{ all -> 0x0070 }
        L_0x0067:
            com.bugsnag.android.IOUtils.closeQuietly(r2)
            java.util.concurrent.locks.Lock r7 = r6.lock
            r7.unlock()
            return r1
        L_0x0070:
            r7 = move-exception
        L_0x0071:
            com.bugsnag.android.IOUtils.closeQuietly(r2)
            java.util.concurrent.locks.Lock r0 = r6.lock
            r0.unlock()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.FileStore.write(com.bugsnag.android.JsonStream$Streamable):java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public void discardOldestFileIfNeeded() {
        File[] listFiles;
        File file = new File(this.storeDirectory);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length >= this.maxStoreCount) {
            Arrays.sort(listFiles, this.comparator);
            for (int i = 0; i < listFiles.length && listFiles.length >= this.maxStoreCount; i++) {
                File file2 = listFiles[i];
                if (!this.queuedFiles.contains(file2)) {
                    Logger.warn(String.format("Discarding oldest error as stored error limit reached (%s)", new Object[]{file2.getPath()}));
                    deleteStoredFiles(Collections.singleton(file2));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public List<File> findStoredFiles() {
        File[] listFiles;
        this.lock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            if (this.storeDirectory != null) {
                File file = new File(this.storeDirectory);
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        if (file2.length() == 0) {
                            if (!file2.delete()) {
                                file2.deleteOnExit();
                            }
                        } else if (file2.isFile() && !this.queuedFiles.contains(file2)) {
                            arrayList.add(file2);
                        }
                    }
                }
            }
            this.queuedFiles.addAll(arrayList);
            return arrayList;
        } finally {
            this.lock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void cancelQueuedFiles(Collection<File> collection) {
        this.lock.lock();
        if (collection != null) {
            try {
                this.queuedFiles.removeAll(collection);
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }

    /* access modifiers changed from: package-private */
    public void deleteStoredFiles(Collection<File> collection) {
        this.lock.lock();
        if (collection != null) {
            try {
                this.queuedFiles.removeAll(collection);
                for (File next : collection) {
                    if (!next.delete()) {
                        next.deleteOnExit();
                    }
                }
            } catch (Throwable th) {
                this.lock.unlock();
                throw th;
            }
        }
        this.lock.unlock();
    }
}
