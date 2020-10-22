package com.facebook.soloader;

import android.content.Context;
import com.facebook.soloader.UnpackingSoSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public final class ExoSoSource extends UnpackingSoSource {
    public ExoSoSource(Context context, String str) {
        super(context, str);
    }

    /* access modifiers changed from: protected */
    public UnpackingSoSource.Unpacker makeUnpacker() throws IOException {
        return new ExoUnpacker(this, this);
    }

    private final class ExoUnpacker extends UnpackingSoSource.Unpacker {
        /* access modifiers changed from: private */
        public final FileDso[] mDsos;
        final /* synthetic */ ExoSoSource this$0;

        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            r11.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e6, code lost:
            r10.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fd, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            r8.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x0107, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0108, code lost:
            r2 = r0;
            r8 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
            r10.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:0x0116, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0117, code lost:
            r8.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:63:0x011c, code lost:
            r10.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0107 A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:7:0x0063] */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x0112 A[SYNTHETIC, Splitter:B:59:0x0112] */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x011c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        ExoUnpacker(com.facebook.soloader.ExoSoSource r18, com.facebook.soloader.UnpackingSoSource r19) throws java.io.IOException {
            /*
                r17 = this;
                r1 = r17
                r0 = r18
                r1.this$0 = r0
                r17.<init>()
                android.content.Context r0 = r0.mContext
                java.io.File r2 = new java.io.File
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "/data/local/tmp/exopackage/"
                r3.append(r4)
                java.lang.String r0 = r0.getPackageName()
                r3.append(r0)
                java.lang.String r0 = "/native-libs/"
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r2.<init>(r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.LinkedHashSet r3 = new java.util.LinkedHashSet
                r3.<init>()
                java.lang.String[] r4 = com.facebook.soloader.SysUtil.getSupportedAbis()
                int r5 = r4.length
                r6 = 0
                r7 = 0
            L_0x003b:
                if (r7 >= r5) goto L_0x0120
                r8 = r4[r7]
                java.io.File r9 = new java.io.File
                r9.<init>(r2, r8)
                boolean r10 = r9.isDirectory()
                if (r10 != 0) goto L_0x004c
                goto L_0x00e9
            L_0x004c:
                r3.add(r8)
                java.io.File r8 = new java.io.File
                java.lang.String r10 = "metadata.txt"
                r8.<init>(r9, r10)
                boolean r10 = r8.isFile()
                if (r10 != 0) goto L_0x005e
                goto L_0x00e9
            L_0x005e:
                java.io.FileReader r10 = new java.io.FileReader
                r10.<init>(r8)
                java.io.BufferedReader r11 = new java.io.BufferedReader     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
                r11.<init>(r10)     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            L_0x0068:
                java.lang.String r12 = r11.readLine()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                if (r12 == 0) goto L_0x00e3
                int r13 = r12.length()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                if (r13 != 0) goto L_0x0075
                goto L_0x0068
            L_0x0075:
                r13 = 32
                int r13 = r12.indexOf(r13)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r14 = -1
                if (r13 == r14) goto L_0x00c7
                java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r14.<init>()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r15 = r12.substring(r6, r13)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r14.append(r15)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r15 = ".so"
                r14.append(r15)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r14 = r14.toString()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                int r15 = r0.size()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            L_0x0097:
                if (r6 >= r15) goto L_0x00ae
                java.lang.Object r16 = r0.get(r6)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r8 = r16
                com.facebook.soloader.ExoSoSource$FileDso r8 = (com.facebook.soloader.ExoSoSource.FileDso) r8     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r8 = r8.name     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                boolean r8 = r8.equals(r14)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                if (r8 == 0) goto L_0x00ab
                r6 = 1
                goto L_0x00af
            L_0x00ab:
                int r6 = r6 + 1
                goto L_0x0097
            L_0x00ae:
                r6 = 0
            L_0x00af:
                if (r6 == 0) goto L_0x00b3
            L_0x00b1:
                r6 = 0
                goto L_0x0068
            L_0x00b3:
                int r13 = r13 + 1
                java.lang.String r6 = r12.substring(r13)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                com.facebook.soloader.ExoSoSource$FileDso r8 = new com.facebook.soloader.ExoSoSource$FileDso     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.io.File r12 = new java.io.File     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r12.<init>(r9, r6)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r8.<init>(r14, r6, r12)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r0.add(r8)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                goto L_0x00b1
            L_0x00c7:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r2.<init>()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r3 = "illegal line in exopackage metadata: ["
                r2.append(r3)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r2.append(r12)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r3 = "]"
                r2.append(r3)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                java.lang.String r2 = r2.toString()     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                r0.<init>(r2)     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
                throw r0     // Catch:{ Throwable -> 0x00f2, all -> 0x00ee }
            L_0x00e3:
                r11.close()     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
                r10.close()
            L_0x00e9:
                int r7 = r7 + 1
                r6 = 0
                goto L_0x003b
            L_0x00ee:
                r0 = move-exception
                r2 = r0
                r8 = 0
                goto L_0x00f7
            L_0x00f2:
                r0 = move-exception
                r8 = r0
                throw r8     // Catch:{ all -> 0x00f5 }
            L_0x00f5:
                r0 = move-exception
                r2 = r0
            L_0x00f7:
                if (r8 == 0) goto L_0x0103
                r11.close()     // Catch:{ Throwable -> 0x00fd, all -> 0x0107 }
                goto L_0x0106
            L_0x00fd:
                r0 = move-exception
                r3 = r0
                r8.addSuppressed(r3)     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
                goto L_0x0106
            L_0x0103:
                r11.close()     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            L_0x0106:
                throw r2     // Catch:{ Throwable -> 0x010b, all -> 0x0107 }
            L_0x0107:
                r0 = move-exception
                r2 = r0
                r8 = 0
                goto L_0x0110
            L_0x010b:
                r0 = move-exception
                r8 = r0
                throw r8     // Catch:{ all -> 0x010e }
            L_0x010e:
                r0 = move-exception
                r2 = r0
            L_0x0110:
                if (r8 == 0) goto L_0x011c
                r10.close()     // Catch:{ Throwable -> 0x0116 }
                goto L_0x011f
            L_0x0116:
                r0 = move-exception
                r3 = r0
                r8.addSuppressed(r3)
                goto L_0x011f
            L_0x011c:
                r10.close()
            L_0x011f:
                throw r2
            L_0x0120:
                int r2 = r3.size()
                java.lang.String[] r2 = new java.lang.String[r2]
                java.lang.Object[] r2 = r3.toArray(r2)
                java.lang.String[] r2 = (java.lang.String[]) r2
                r3 = r19
                r3.setSoSourceAbis(r2)
                int r2 = r0.size()
                com.facebook.soloader.ExoSoSource$FileDso[] r2 = new com.facebook.soloader.ExoSoSource.FileDso[r2]
                java.lang.Object[] r0 = r0.toArray(r2)
                com.facebook.soloader.ExoSoSource$FileDso[] r0 = (com.facebook.soloader.ExoSoSource.FileDso[]) r0
                r1.mDsos = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.ExoSoSource.ExoUnpacker.<init>(com.facebook.soloader.ExoSoSource, com.facebook.soloader.UnpackingSoSource):void");
        }

        /* access modifiers changed from: protected */
        public UnpackingSoSource.DsoManifest getDsoManifest() throws IOException {
            return new UnpackingSoSource.DsoManifest(this.mDsos);
        }

        /* access modifiers changed from: protected */
        public UnpackingSoSource.InputDsoIterator openDsoIterator() throws IOException {
            return new FileBackedInputDsoIterator();
        }

        private final class FileBackedInputDsoIterator extends UnpackingSoSource.InputDsoIterator {
            private int mCurrentDso;

            private FileBackedInputDsoIterator() {
            }

            public boolean hasNext() {
                return this.mCurrentDso < ExoUnpacker.this.mDsos.length;
            }

            public UnpackingSoSource.InputDso next() throws IOException {
                FileDso[] access$100 = ExoUnpacker.this.mDsos;
                int i = this.mCurrentDso;
                this.mCurrentDso = i + 1;
                FileDso fileDso = access$100[i];
                FileInputStream fileInputStream = new FileInputStream(fileDso.backingFile);
                try {
                    return new UnpackingSoSource.InputDso(fileDso, fileInputStream);
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            }
        }
    }

    private static final class FileDso extends UnpackingSoSource.Dso {
        final File backingFile;

        FileDso(String str, String str2, File file) {
            super(str, str2);
            this.backingFile = file;
        }
    }
}
