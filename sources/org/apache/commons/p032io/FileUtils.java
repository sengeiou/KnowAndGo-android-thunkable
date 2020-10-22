package org.apache.commons.p032io;

import com.facebook.common.util.UriUtil;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.CRC32;
import org.apache.commons.p032io.filefilter.DirectoryFileFilter;
import org.apache.commons.p032io.filefilter.FalseFileFilter;
import org.apache.commons.p032io.filefilter.FileFilterUtils;
import org.apache.commons.p032io.filefilter.IOFileFilter;
import org.apache.commons.p032io.filefilter.SuffixFileFilter;
import org.apache.commons.p032io.filefilter.TrueFileFilter;

/* renamed from: org.apache.commons.io.FileUtils */
public class FileUtils {
    public static final File[] EMPTY_FILE_ARRAY = new File[0];
    private static final long FILE_COPY_BUFFER_SIZE = 31457280;
    public static final long ONE_EB = 1152921504606846976L;
    public static final BigInteger ONE_EB_BI = ONE_KB_BI.multiply(ONE_PB_BI);
    public static final long ONE_GB = 1073741824;
    public static final BigInteger ONE_GB_BI = ONE_KB_BI.multiply(ONE_MB_BI);
    public static final long ONE_KB = 1024;
    public static final BigInteger ONE_KB_BI = BigInteger.valueOf(1024);
    public static final long ONE_MB = 1048576;
    public static final BigInteger ONE_MB_BI = ONE_KB_BI.multiply(ONE_KB_BI);
    public static final long ONE_PB = 1125899906842624L;
    public static final BigInteger ONE_PB_BI = ONE_KB_BI.multiply(ONE_TB_BI);
    public static final long ONE_TB = 1099511627776L;
    public static final BigInteger ONE_TB_BI = ONE_KB_BI.multiply(ONE_GB_BI);
    public static final BigInteger ONE_YB = ONE_KB_BI.multiply(ONE_ZB);
    public static final BigInteger ONE_ZB = BigInteger.valueOf(1024).multiply(BigInteger.valueOf(ONE_EB));

    public static File getFile(File file, String... strArr) {
        if (file == null) {
            throw new NullPointerException("directory must not be null");
        } else if (strArr != null) {
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                i++;
                file = new File(file, strArr[i]);
            }
            return file;
        } else {
            throw new NullPointerException("names must not be null");
        }
    }

    public static File getFile(String... strArr) {
        if (strArr != null) {
            File file = null;
            for (String str : strArr) {
                if (file == null) {
                    file = new File(str);
                } else {
                    file = new File(file, str);
                }
            }
            return file;
        }
        throw new NullPointerException("names must not be null");
    }

    public static String getTempDirectoryPath() {
        return System.getProperty("java.io.tmpdir");
    }

    public static File getTempDirectory() {
        return new File(getTempDirectoryPath());
    }

    public static String getUserDirectoryPath() {
        return System.getProperty("user.home");
    }

    public static File getUserDirectory() {
        return new File(getUserDirectoryPath());
    }

    public static FileInputStream openInputStream(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (file.canRead()) {
            return new FileInputStream(file);
        } else {
            throw new IOException("File '" + file + "' cannot be read");
        }
    }

    public static FileOutputStream openOutputStream(File file) throws IOException {
        return openOutputStream(file, false);
    }

    public static FileOutputStream openOutputStream(File file, boolean z) throws IOException {
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        return new FileOutputStream(file, z);
    }

    public static String byteCountToDisplaySize(BigInteger bigInteger) {
        if (bigInteger.divide(ONE_EB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_EB_BI)) + " EB";
        } else if (bigInteger.divide(ONE_PB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_PB_BI)) + " PB";
        } else if (bigInteger.divide(ONE_TB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_TB_BI)) + " TB";
        } else if (bigInteger.divide(ONE_GB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_GB_BI)) + " GB";
        } else if (bigInteger.divide(ONE_MB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_MB_BI)) + " MB";
        } else if (bigInteger.divide(ONE_KB_BI).compareTo(BigInteger.ZERO) > 0) {
            return String.valueOf(bigInteger.divide(ONE_KB_BI)) + " KB";
        } else {
            return String.valueOf(bigInteger) + " bytes";
        }
    }

    public static String byteCountToDisplaySize(long j) {
        return byteCountToDisplaySize(BigInteger.valueOf(j));
    }

    public static void touch(File file) throws IOException {
        if (!file.exists()) {
            openOutputStream(file).close();
        }
        if (!file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to set the last modification time for " + file);
        }
    }

    public static File[] convertFileCollectionToFileArray(Collection<File> collection) {
        return (File[]) collection.toArray(new File[collection.size()]);
    }

    private static void innerListFiles(Collection<File> collection, File file, IOFileFilter iOFileFilter, boolean z) {
        File[] listFiles = file.listFiles(iOFileFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z) {
                        collection.add(file2);
                    }
                    innerListFiles(collection, file2, iOFileFilter, z);
                } else {
                    collection.add(file2);
                }
            }
        }
    }

    public static Collection<File> listFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        innerListFiles(linkedList, file, FileFilterUtils.m2494or(upEffectiveFileFilter, upEffectiveDirFilter), false);
        return linkedList;
    }

    private static void validateListFilesParameters(File file, IOFileFilter iOFileFilter) {
        if (!file.isDirectory()) {
            throw new IllegalArgumentException("Parameter 'directory' is not a directory: " + file);
        } else if (iOFileFilter == null) {
            throw new NullPointerException("Parameter 'fileFilter' is null");
        }
    }

    private static IOFileFilter setUpEffectiveFileFilter(IOFileFilter iOFileFilter) {
        return FileFilterUtils.and(iOFileFilter, FileFilterUtils.notFileFilter(DirectoryFileFilter.INSTANCE));
    }

    private static IOFileFilter setUpEffectiveDirFilter(IOFileFilter iOFileFilter) {
        if (iOFileFilter == null) {
            return FalseFileFilter.INSTANCE;
        }
        return FileFilterUtils.and(iOFileFilter, DirectoryFileFilter.INSTANCE);
    }

    public static Collection<File> listFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        validateListFilesParameters(file, iOFileFilter);
        IOFileFilter upEffectiveFileFilter = setUpEffectiveFileFilter(iOFileFilter);
        IOFileFilter upEffectiveDirFilter = setUpEffectiveDirFilter(iOFileFilter2);
        LinkedList linkedList = new LinkedList();
        if (file.isDirectory()) {
            linkedList.add(file);
        }
        innerListFiles(linkedList, file, FileFilterUtils.m2494or(upEffectiveFileFilter, upEffectiveDirFilter), true);
        return linkedList;
    }

    public static Iterator<File> iterateFiles(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFiles(file, iOFileFilter, iOFileFilter2).iterator();
    }

    public static Iterator<File> iterateFilesAndDirs(File file, IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        return listFilesAndDirs(file, iOFileFilter, iOFileFilter2).iterator();
    }

    private static String[] toSuffixes(String[] strArr) {
        String[] strArr2 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr2[i] = "." + strArr[i];
        }
        return strArr2;
    }

    public static Collection<File> listFiles(File file, String[] strArr, boolean z) {
        IOFileFilter iOFileFilter;
        if (strArr == null) {
            iOFileFilter = TrueFileFilter.INSTANCE;
        } else {
            iOFileFilter = new SuffixFileFilter(toSuffixes(strArr));
        }
        return listFiles(file, iOFileFilter, z ? TrueFileFilter.INSTANCE : FalseFileFilter.INSTANCE);
    }

    public static Iterator<File> iterateFiles(File file, String[] strArr, boolean z) {
        return listFiles(file, strArr, z).iterator();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0053, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        r7 = r2;
        r2 = r9;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0066, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006a, code lost:
        if (r8 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0071, code lost:
        r8.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0075, code lost:
        r0.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEquals(java.io.File r8, java.io.File r9) throws java.io.IOException {
        /*
            boolean r0 = r8.exists()
            boolean r1 = r9.exists()
            r2 = 0
            if (r0 == r1) goto L_0x000c
            return r2
        L_0x000c:
            r1 = 1
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            boolean r0 = r8.isDirectory()
            if (r0 != 0) goto L_0x0079
            boolean r0 = r9.isDirectory()
            if (r0 != 0) goto L_0x0079
            long r3 = r8.length()
            long r5 = r9.length()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0029
            return r2
        L_0x0029:
            java.io.File r0 = r8.getCanonicalFile()
            java.io.File r2 = r9.getCanonicalFile()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0038
            return r1
        L_0x0038:
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r8)
            r8 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0068 }
            r1.<init>(r9)     // Catch:{ Throwable -> 0x0068 }
            boolean r9 = org.apache.commons.p032io.IOUtils.contentEquals((java.io.InputStream) r0, (java.io.InputStream) r1)     // Catch:{ Throwable -> 0x0051, all -> 0x004e }
            r1.close()     // Catch:{ Throwable -> 0x0068 }
            r0.close()
            return r9
        L_0x004e:
            r9 = move-exception
            r2 = r8
            goto L_0x0057
        L_0x0051:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r2 = move-exception
            r7 = r2
            r2 = r9
            r9 = r7
        L_0x0057:
            if (r2 == 0) goto L_0x0062
            r1.close()     // Catch:{ Throwable -> 0x005d }
            goto L_0x0065
        L_0x005d:
            r1 = move-exception
            r2.addSuppressed(r1)     // Catch:{ Throwable -> 0x0068 }
            goto L_0x0065
        L_0x0062:
            r1.close()     // Catch:{ Throwable -> 0x0068 }
        L_0x0065:
            throw r9     // Catch:{ Throwable -> 0x0068 }
        L_0x0066:
            r9 = move-exception
            goto L_0x006a
        L_0x0068:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0066 }
        L_0x006a:
            if (r8 == 0) goto L_0x0075
            r0.close()     // Catch:{ Throwable -> 0x0070 }
            goto L_0x0078
        L_0x0070:
            r0 = move-exception
            r8.addSuppressed(r0)
            goto L_0x0078
        L_0x0075:
            r0.close()
        L_0x0078:
            throw r9
        L_0x0079:
            java.io.IOException r8 = new java.io.IOException
            java.lang.String r9 = "Can't compare directories, only files"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.contentEquals(java.io.File, java.io.File):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0072, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0073, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0077, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0078, code lost:
        r3 = r1;
        r1 = r5;
        r5 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean contentEqualsIgnoreEOL(java.io.File r4, java.io.File r5, java.lang.String r6) throws java.io.IOException {
        /*
            boolean r0 = r4.exists()
            boolean r1 = r5.exists()
            if (r0 == r1) goto L_0x000c
            r4 = 0
            return r4
        L_0x000c:
            r1 = 1
            if (r0 != 0) goto L_0x0010
            return r1
        L_0x0010:
            boolean r0 = r4.isDirectory()
            if (r0 != 0) goto L_0x009a
            boolean r0 = r5.isDirectory()
            if (r0 != 0) goto L_0x009a
            java.io.File r0 = r4.getCanonicalFile()
            java.io.File r2 = r5.getCanonicalFile()
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002b
            return r1
        L_0x002b:
            if (r6 != 0) goto L_0x003c
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r4)
            java.nio.charset.Charset r4 = java.nio.charset.Charset.defaultCharset()
            r0.<init>(r1, r4)
            goto L_0x0046
        L_0x003c:
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r4)
            r0.<init>(r1, r6)
        L_0x0046:
            r4 = 0
            if (r6 != 0) goto L_0x005c
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x005a }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x005a }
            r1.<init>(r5)     // Catch:{ Throwable -> 0x005a }
            java.nio.charset.Charset r5 = java.nio.charset.Charset.defaultCharset()     // Catch:{ Throwable -> 0x005a }
            r6.<init>(r1, r5)     // Catch:{ Throwable -> 0x005a }
            goto L_0x0067
        L_0x0058:
            r5 = move-exception
            goto L_0x008b
        L_0x005a:
            r4 = move-exception
            goto L_0x008a
        L_0x005c:
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Throwable -> 0x005a }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x005a }
            r2.<init>(r5)     // Catch:{ Throwable -> 0x005a }
            r1.<init>(r2, r6)     // Catch:{ Throwable -> 0x005a }
            r6 = r1
        L_0x0067:
            boolean r5 = org.apache.commons.p032io.IOUtils.contentEqualsIgnoreEOL(r0, r6)     // Catch:{ Throwable -> 0x0075, all -> 0x0072 }
            r6.close()     // Catch:{ Throwable -> 0x005a }
            r0.close()
            return r5
        L_0x0072:
            r5 = move-exception
            r1 = r4
            goto L_0x007b
        L_0x0075:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r1 = move-exception
            r3 = r1
            r1 = r5
            r5 = r3
        L_0x007b:
            if (r1 == 0) goto L_0x0086
            r6.close()     // Catch:{ Throwable -> 0x0081 }
            goto L_0x0089
        L_0x0081:
            r6 = move-exception
            r1.addSuppressed(r6)     // Catch:{ Throwable -> 0x005a }
            goto L_0x0089
        L_0x0086:
            r6.close()     // Catch:{ Throwable -> 0x005a }
        L_0x0089:
            throw r5     // Catch:{ Throwable -> 0x005a }
        L_0x008a:
            throw r4     // Catch:{ all -> 0x0058 }
        L_0x008b:
            if (r4 == 0) goto L_0x0096
            r0.close()     // Catch:{ Throwable -> 0x0091 }
            goto L_0x0099
        L_0x0091:
            r6 = move-exception
            r4.addSuppressed(r6)
            goto L_0x0099
        L_0x0096:
            r0.close()
        L_0x0099:
            throw r5
        L_0x009a:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "Can't compare directories, only files"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.contentEqualsIgnoreEOL(java.io.File, java.io.File, java.lang.String):boolean");
    }

    public static File toFile(URL url) {
        if (url == null || !UriUtil.LOCAL_FILE_SCHEME.equalsIgnoreCase(url.getProtocol())) {
            return null;
        }
        return new File(decodeUrl(url.getFile().replace(IOUtils.DIR_SEPARATOR_UNIX, File.separatorChar)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        if (r3.position() > 0) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0061, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0074, code lost:
        throw r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007c, code lost:
        r3.flip();
        r2.append(java.nio.charset.StandardCharsets.UTF_8.decode(r3).toString());
        r3.clear();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a A[ExcHandler: all (r8v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:8:0x0024] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String decodeUrl(java.lang.String r8) {
        /*
            if (r8 == 0) goto L_0x009f
            r0 = 37
            int r1 = r8.indexOf(r0)
            if (r1 < 0) goto L_0x009f
            int r1 = r8.length()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r1)
            r4 = 0
        L_0x0018:
            if (r4 >= r1) goto L_0x009b
            char r5 = r8.charAt(r4)
            if (r5 != r0) goto L_0x008f
        L_0x0020:
            int r5 = r4 + 1
            int r6 = r4 + 3
            java.lang.String r5 = r8.substring(r5, r6)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r7 = 16
            int r5 = java.lang.Integer.parseInt(r5, r7)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            byte r5 = (byte) r5     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            r3.put(r5)     // Catch:{ RuntimeException -> 0x0075, all -> 0x005a }
            if (r6 >= r1) goto L_0x003f
            char r4 = r8.charAt(r6)     // Catch:{ RuntimeException -> 0x003d, all -> 0x005a }
            if (r4 == r0) goto L_0x003b
            goto L_0x003f
        L_0x003b:
            r4 = r6
            goto L_0x0020
        L_0x003d:
            r4 = r6
            goto L_0x0076
        L_0x003f:
            int r4 = r3.position()
            if (r4 <= 0) goto L_0x0058
            r3.flip()
            java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r4 = r4.decode(r3)
            java.lang.String r4 = r4.toString()
            r2.append(r4)
            r3.clear()
        L_0x0058:
            r4 = r6
            goto L_0x0018
        L_0x005a:
            r8 = move-exception
            int r0 = r3.position()
            if (r0 <= 0) goto L_0x0074
            r3.flip()
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r0 = r0.decode(r3)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            r3.clear()
        L_0x0074:
            throw r8
        L_0x0075:
        L_0x0076:
            int r5 = r3.position()
            if (r5 <= 0) goto L_0x008f
            r3.flip()
            java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8
            java.nio.CharBuffer r5 = r5.decode(r3)
            java.lang.String r5 = r5.toString()
            r2.append(r5)
            r3.clear()
        L_0x008f:
            int r5 = r4 + 1
            char r4 = r8.charAt(r4)
            r2.append(r4)
            r4 = r5
            goto L_0x0018
        L_0x009b:
            java.lang.String r8 = r2.toString()
        L_0x009f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.decodeUrl(java.lang.String):java.lang.String");
    }

    public static File[] toFiles(URL[] urlArr) {
        if (urlArr == null || urlArr.length == 0) {
            return EMPTY_FILE_ARRAY;
        }
        File[] fileArr = new File[urlArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            URL url = urlArr[i];
            if (url != null) {
                if (url.getProtocol().equals(UriUtil.LOCAL_FILE_SCHEME)) {
                    fileArr[i] = toFile(url);
                } else {
                    throw new IllegalArgumentException("URL could not be converted to a File: " + url);
                }
            }
        }
        return fileArr;
    }

    public static URL[] toURLs(File[] fileArr) throws IOException {
        URL[] urlArr = new URL[fileArr.length];
        for (int i = 0; i < urlArr.length; i++) {
            urlArr[i] = fileArr[i].toURI().toURL();
        }
        return urlArr;
    }

    public static void copyFileToDirectory(File file, File file2) throws IOException {
        copyFileToDirectory(file, file2, true);
    }

    public static void copyFileToDirectory(File file, File file2, boolean z) throws IOException {
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file2.exists() || file2.isDirectory()) {
            copyFile(file, new File(file2, file.getName()), z);
        } else {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        copyFile(file, file2, true);
    }

    public static void copyFile(File file, File file2, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is a directory");
        } else if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            File parentFile = file2.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            } else if (!file2.exists() || file2.canWrite()) {
                doCopyFile(file, file2, z);
            } else {
                throw new IOException("Destination '" + file2 + "' exists but is read-only");
            }
        } else {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copyFile(java.io.File r1, java.io.OutputStream r2) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            long r1 = org.apache.commons.p032io.IOUtils.copyLarge((java.io.InputStream) r0, (java.io.OutputStream) r2)     // Catch:{ Throwable -> 0x0010, all -> 0x000d }
            r0.close()
            return r1
        L_0x000d:
            r1 = move-exception
            r2 = 0
            goto L_0x0013
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
        L_0x0013:
            if (r2 == 0) goto L_0x001e
            r0.close()     // Catch:{ Throwable -> 0x0019 }
            goto L_0x0021
        L_0x0019:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0021
        L_0x001e:
            r0.close()
        L_0x0021:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.copyFile(java.io.File, java.io.OutputStream):long");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00da, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00db, code lost:
        r1 = r0;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00df, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00e2, code lost:
        r4 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00f4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00f5, code lost:
        r1 = r0;
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x00f8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00fb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x00fc, code lost:
        r4 = r1;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00da A[ExcHandler: all (r0v11 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:11:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f4 A[ExcHandler: all (r0v7 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x0037] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doCopyFile(java.io.File r19, java.io.File r20, boolean r21) throws java.io.IOException {
        /*
            r0 = r19
            r1 = r20
            boolean r2 = r20.exists()
            if (r2 == 0) goto L_0x002d
            boolean r2 = r20.isDirectory()
            if (r2 != 0) goto L_0x0011
            goto L_0x002d
        L_0x0011:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Destination '"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "' exists but is a directory"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        L_0x002d:
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r0)
            r3 = 0
            java.nio.channels.FileChannel r10 = r2.getChannel()     // Catch:{ Throwable -> 0x0113 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
            r11.<init>(r1)     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
            java.nio.channels.FileChannel r12 = r11.getChannel()     // Catch:{ Throwable -> 0x00de, all -> 0x00da }
            long r13 = r10.size()     // Catch:{ Throwable -> 0x00c2, all -> 0x00be }
            r15 = 0
            r17 = r15
        L_0x0048:
            int r4 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r4 >= 0) goto L_0x0069
            long r4 = r13 - r17
            r6 = 31457280(0x1e00000, double:1.55419614E-316)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0057
            r8 = r6
            goto L_0x0058
        L_0x0057:
            r8 = r4
        L_0x0058:
            r4 = r12
            r5 = r10
            r6 = r17
            long r4 = r4.transferFrom(r5, r6, r8)     // Catch:{ Throwable -> 0x00c2, all -> 0x00be }
            int r6 = (r4 > r15 ? 1 : (r4 == r15 ? 0 : -1))
            if (r6 != 0) goto L_0x0065
            goto L_0x0069
        L_0x0065:
            r6 = 0
            long r17 = r17 + r4
            goto L_0x0048
        L_0x0069:
            if (r12 == 0) goto L_0x006e
            r12.close()     // Catch:{ Throwable -> 0x00de, all -> 0x00da }
        L_0x006e:
            r11.close()     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
            if (r10 == 0) goto L_0x0076
            r10.close()     // Catch:{ Throwable -> 0x0113 }
        L_0x0076:
            r2.close()
            long r2 = r19.length()
            long r4 = r20.length()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x008f
            if (r21 == 0) goto L_0x008e
            long r2 = r19.lastModified()
            r1.setLastModified(r2)
        L_0x008e:
            return
        L_0x008f:
            java.io.IOException r6 = new java.io.IOException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to copy full contents from '"
            r7.append(r8)
            r7.append(r0)
            java.lang.String r0 = "' to '"
            r7.append(r0)
            r7.append(r1)
            java.lang.String r0 = "' Expected length: "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r0 = " Actual: "
            r7.append(r0)
            r7.append(r4)
            java.lang.String r0 = r7.toString()
            r6.<init>(r0)
            throw r6
        L_0x00be:
            r0 = move-exception
            r1 = r0
            r4 = r3
            goto L_0x00c8
        L_0x00c2:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00c5 }
        L_0x00c5:
            r0 = move-exception
            r4 = r1
            r1 = r0
        L_0x00c8:
            if (r12 == 0) goto L_0x00d9
            if (r4 == 0) goto L_0x00d6
            r12.close()     // Catch:{ Throwable -> 0x00d0, all -> 0x00da }
            goto L_0x00d9
        L_0x00d0:
            r0 = move-exception
            r5 = r0
            r4.addSuppressed(r5)     // Catch:{ Throwable -> 0x00de, all -> 0x00da }
            goto L_0x00d9
        L_0x00d6:
            r12.close()     // Catch:{ Throwable -> 0x00de, all -> 0x00da }
        L_0x00d9:
            throw r1     // Catch:{ Throwable -> 0x00de, all -> 0x00da }
        L_0x00da:
            r0 = move-exception
            r1 = r0
            r4 = r3
            goto L_0x00e4
        L_0x00de:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00e1 }
        L_0x00e1:
            r0 = move-exception
            r4 = r1
            r1 = r0
        L_0x00e4:
            if (r4 == 0) goto L_0x00f0
            r11.close()     // Catch:{ Throwable -> 0x00ea, all -> 0x00f4 }
            goto L_0x00f3
        L_0x00ea:
            r0 = move-exception
            r5 = r0
            r4.addSuppressed(r5)     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
            goto L_0x00f3
        L_0x00f0:
            r11.close()     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
        L_0x00f3:
            throw r1     // Catch:{ Throwable -> 0x00f8, all -> 0x00f4 }
        L_0x00f4:
            r0 = move-exception
            r1 = r0
            r4 = r3
            goto L_0x00fe
        L_0x00f8:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r0 = move-exception
            r4 = r1
            r1 = r0
        L_0x00fe:
            if (r10 == 0) goto L_0x010f
            if (r4 == 0) goto L_0x010c
            r10.close()     // Catch:{ Throwable -> 0x0106 }
            goto L_0x010f
        L_0x0106:
            r0 = move-exception
            r5 = r0
            r4.addSuppressed(r5)     // Catch:{ Throwable -> 0x0113 }
            goto L_0x010f
        L_0x010c:
            r10.close()     // Catch:{ Throwable -> 0x0113 }
        L_0x010f:
            throw r1     // Catch:{ Throwable -> 0x0113 }
        L_0x0110:
            r0 = move-exception
            r1 = r0
            goto L_0x0116
        L_0x0113:
            r0 = move-exception
            r3 = r0
            throw r3     // Catch:{ all -> 0x0110 }
        L_0x0116:
            if (r3 == 0) goto L_0x0122
            r2.close()     // Catch:{ Throwable -> 0x011c }
            goto L_0x0125
        L_0x011c:
            r0 = move-exception
            r2 = r0
            r3.addSuppressed(r2)
            goto L_0x0125
        L_0x0122:
            r2.close()
        L_0x0125:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.doCopyFile(java.io.File, java.io.File, boolean):void");
    }

    public static void copyDirectoryToDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file.exists() && !file.isDirectory()) {
            throw new IllegalArgumentException("Source '" + file2 + "' is not a directory");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file2.exists() || file2.isDirectory()) {
            copyDirectory(file, new File(file2, file.getName()), true);
        } else {
            throw new IllegalArgumentException("Destination '" + file2 + "' is not a directory");
        }
    }

    public static void copyDirectory(File file, File file2) throws IOException {
        copyDirectory(file, file2, true);
    }

    public static void copyDirectory(File file, File file2, boolean z) throws IOException {
        copyDirectory(file, file2, (FileFilter) null, z);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter) throws IOException {
        copyDirectory(file, file2, fileFilter, true);
    }

    public static void copyDirectory(File file, File file2, FileFilter fileFilter, boolean z) throws IOException {
        checkFileRequirements(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        } else if (!file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            ArrayList arrayList = null;
            if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
                File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
                if (listFiles != null && listFiles.length > 0) {
                    arrayList = new ArrayList(listFiles.length);
                    for (File name : listFiles) {
                        arrayList.add(new File(file2, name.getName()).getCanonicalPath());
                    }
                }
            }
            doCopyDirectory(file, file2, fileFilter, z, arrayList);
        } else {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
    }

    private static void checkFileRequirements(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        }
    }

    private static void doCopyDirectory(File file, File file2, FileFilter fileFilter, boolean z, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles != null) {
            if (file2.exists()) {
                if (!file2.isDirectory()) {
                    throw new IOException("Destination '" + file2 + "' exists but is not a directory");
                }
            } else if (!file2.mkdirs() && !file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' directory cannot be created");
            }
            if (file2.canWrite()) {
                for (File file3 : listFiles) {
                    File file4 = new File(file2, file3.getName());
                    if (list == null || !list.contains(file3.getCanonicalPath())) {
                        if (file3.isDirectory()) {
                            doCopyDirectory(file3, file4, fileFilter, z, list);
                        } else {
                            doCopyFile(file3, file4, z);
                        }
                    }
                }
                if (z) {
                    file2.setLastModified(file.lastModified());
                    return;
                }
                return;
            }
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        throw new IOException("Failed to list contents of " + file);
    }

    public static void copyURLToFile(URL url, File file) throws IOException {
        copyInputStreamToFile(url.openStream(), file);
    }

    public static void copyURLToFile(URL url, File file, int i, int i2) throws IOException {
        URLConnection openConnection = url.openConnection();
        openConnection.setConnectTimeout(i);
        openConnection.setReadTimeout(i2);
        copyInputStreamToFile(openConnection.getInputStream(), file);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0009, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000e, code lost:
        r2 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyInputStreamToFile(java.io.InputStream r1, java.io.File r2) throws java.io.IOException {
        /*
            copyToFile(r1, r2)     // Catch:{ Throwable -> 0x000c, all -> 0x0009 }
            if (r1 == 0) goto L_0x0008
            r1.close()
        L_0x0008:
            return
        L_0x0009:
            r2 = move-exception
            r0 = 0
            goto L_0x000f
        L_0x000c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x000e }
        L_0x000e:
            r2 = move-exception
        L_0x000f:
            if (r1 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001c
            r1.close()     // Catch:{ Throwable -> 0x0017 }
            goto L_0x001f
        L_0x0017:
            r1 = move-exception
            r0.addSuppressed(r1)
            goto L_0x001f
        L_0x001c:
            r1.close()
        L_0x001f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.copyInputStreamToFile(java.io.InputStream, java.io.File):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0018, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0019, code lost:
        r3 = r2;
        r2 = r1;
        r1 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToFile(java.io.InputStream r4, java.io.File r5) throws java.io.IOException {
        /*
            r0 = 0
            java.io.FileOutputStream r5 = openOutputStream(r5)     // Catch:{ Throwable -> 0x002f }
            org.apache.commons.p032io.IOUtils.copy((java.io.InputStream) r4, (java.io.OutputStream) r5)     // Catch:{ Throwable -> 0x0016, all -> 0x0013 }
            if (r5 == 0) goto L_0x000d
            r5.close()     // Catch:{ Throwable -> 0x002f }
        L_0x000d:
            if (r4 == 0) goto L_0x0012
            r4.close()
        L_0x0012:
            return
        L_0x0013:
            r1 = move-exception
            r2 = r0
            goto L_0x001c
        L_0x0016:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0018 }
        L_0x0018:
            r2 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
        L_0x001c:
            if (r5 == 0) goto L_0x002c
            if (r2 == 0) goto L_0x0029
            r5.close()     // Catch:{ Throwable -> 0x0024 }
            goto L_0x002c
        L_0x0024:
            r5 = move-exception
            r2.addSuppressed(r5)     // Catch:{ Throwable -> 0x002f }
            goto L_0x002c
        L_0x0029:
            r5.close()     // Catch:{ Throwable -> 0x002f }
        L_0x002c:
            throw r1     // Catch:{ Throwable -> 0x002f }
        L_0x002d:
            r5 = move-exception
            goto L_0x0032
        L_0x002f:
            r5 = move-exception
            r0 = r5
            throw r0     // Catch:{ all -> 0x002d }
        L_0x0032:
            if (r4 == 0) goto L_0x0042
            if (r0 == 0) goto L_0x003f
            r4.close()     // Catch:{ Throwable -> 0x003a }
            goto L_0x0042
        L_0x003a:
            r4 = move-exception
            r0.addSuppressed(r4)
            goto L_0x0042
        L_0x003f:
            r4.close()
        L_0x0042:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.copyToFile(java.io.InputStream, java.io.File):void");
    }

    public static void copyToDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file.isFile()) {
            copyFileToDirectory(file, file2);
        } else if (file.isDirectory()) {
            copyDirectoryToDirectory(file, file2);
        } else {
            throw new IOException("The source " + file + " does not exist");
        }
    }

    public static void copyToDirectory(Iterable<File> iterable, File file) throws IOException {
        if (iterable != null) {
            for (File copyFileToDirectory : iterable) {
                copyFileToDirectory(copyFileToDirectory, file);
            }
            return;
        }
        throw new NullPointerException("Sources must not be null");
    }

    public static void deleteDirectory(File file) throws IOException {
        if (file.exists()) {
            if (!isSymlink(file)) {
                cleanDirectory(file);
            }
            if (!file.delete()) {
                throw new IOException("Unable to delete directory " + file + ".");
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:3|4|(1:6)|7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x000d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean deleteQuietly(java.io.File r2) {
        /*
            r0 = 0
            if (r2 != 0) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r2.isDirectory()     // Catch:{ Exception -> 0x000d }
            if (r1 == 0) goto L_0x000d
            cleanDirectory(r2)     // Catch:{ Exception -> 0x000d }
        L_0x000d:
            boolean r2 = r2.delete()     // Catch:{ Exception -> 0x0012 }
            return r2
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.deleteQuietly(java.io.File):boolean");
    }

    public static boolean directoryContains(File file, File file2) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("Directory must not be null");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + file);
        } else if (file2 != null && file.exists() && file2.exists()) {
            return FilenameUtils.directoryContains(file.getCanonicalPath(), file2.getCanonicalPath());
        } else {
            return false;
        }
    }

    public static void cleanDirectory(File file) throws IOException {
        IOException e = null;
        for (File forceDelete : verifiedListFiles(file)) {
            try {
                forceDelete(forceDelete);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    private static File[] verifiedListFiles(File file) throws IOException {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                return listFiles;
            }
            throw new IOException("Failed to list contents of " + file);
        } else {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean waitFor(File file, int i) {
        long currentTimeMillis = System.currentTimeMillis() + (((long) i) * 1000);
        boolean z = false;
        while (!file.exists()) {
            try {
                long currentTimeMillis2 = currentTimeMillis - System.currentTimeMillis();
                if (currentTimeMillis2 < 0) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    return false;
                }
                try {
                    Thread.sleep(Math.min(100, currentTimeMillis2));
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Exception unused2) {
                }
            } finally {
                if (z) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return true;
    }

    public static String readFileToString(File file, Charset charset) throws IOException {
        Throwable th;
        FileInputStream openInputStream = openInputStream(file);
        try {
            String iOUtils = IOUtils.toString((InputStream) openInputStream, Charsets.toCharset(charset));
            if (openInputStream != null) {
                openInputStream.close();
            }
            return iOUtils;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static String readFileToString(File file, String str) throws IOException {
        return readFileToString(file, Charsets.toCharset(str));
    }

    @Deprecated
    public static String readFileToString(File file) throws IOException {
        return readFileToString(file, Charset.defaultCharset());
    }

    public static byte[] readFileToByteArray(File file) throws IOException {
        Throwable th;
        FileInputStream openInputStream = openInputStream(file);
        try {
            long length = file.length();
            byte[] byteArray = length > 0 ? IOUtils.toByteArray((InputStream) openInputStream, length) : IOUtils.toByteArray((InputStream) openInputStream);
            if (openInputStream != null) {
                openInputStream.close();
            }
            return byteArray;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        Throwable th;
        FileInputStream openInputStream = openInputStream(file);
        try {
            List<String> readLines = IOUtils.readLines((InputStream) openInputStream, Charsets.toCharset(charset));
            if (openInputStream != null) {
                openInputStream.close();
            }
            return readLines;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public static List<String> readLines(File file, String str) throws IOException {
        return readLines(file, Charsets.toCharset(str));
    }

    @Deprecated
    public static List<String> readLines(File file) throws IOException {
        return readLines(file, Charset.defaultCharset());
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x000f A[SYNTHETIC, Splitter:B:9:0x000f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.apache.commons.p032io.LineIterator lineIterator(java.io.File r0, java.lang.String r1) throws java.io.IOException {
        /*
            java.io.FileInputStream r0 = openInputStream(r0)     // Catch:{ IOException | RuntimeException -> 0x000b }
            org.apache.commons.io.LineIterator r1 = org.apache.commons.p032io.IOUtils.lineIterator((java.io.InputStream) r0, (java.lang.String) r1)     // Catch:{ IOException | RuntimeException -> 0x0009 }
            return r1
        L_0x0009:
            r1 = move-exception
            goto L_0x000d
        L_0x000b:
            r1 = move-exception
            r0 = 0
        L_0x000d:
            if (r0 == 0) goto L_0x0017
            r0.close()     // Catch:{ IOException -> 0x0013 }
            goto L_0x0017
        L_0x0013:
            r0 = move-exception
            r1.addSuppressed(r0)
        L_0x0017:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.lineIterator(java.io.File, java.lang.String):org.apache.commons.io.LineIterator");
    }

    public static LineIterator lineIterator(File file) throws IOException {
        return lineIterator(file, (String) null);
    }

    public static void writeStringToFile(File file, String str, Charset charset) throws IOException {
        writeStringToFile(file, str, charset, false);
    }

    public static void writeStringToFile(File file, String str, String str2) throws IOException {
        writeStringToFile(file, str, str2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeStringToFile(java.io.File r0, java.lang.String r1, java.nio.charset.Charset r2, boolean r3) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r3)
            org.apache.commons.p032io.IOUtils.write((java.lang.String) r1, (java.io.OutputStream) r0, (java.nio.charset.Charset) r2)     // Catch:{ Throwable -> 0x0010, all -> 0x000d }
            if (r0 == 0) goto L_0x000c
            r0.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            r2 = 0
            goto L_0x0013
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
        L_0x0013:
            if (r0 == 0) goto L_0x0023
            if (r2 == 0) goto L_0x0020
            r0.close()     // Catch:{ Throwable -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0023
        L_0x0020:
            r0.close()
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.writeStringToFile(java.io.File, java.lang.String, java.nio.charset.Charset, boolean):void");
    }

    public static void writeStringToFile(File file, String str, String str2, boolean z) throws IOException {
        writeStringToFile(file, str, Charsets.toCharset(str2), z);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), false);
    }

    @Deprecated
    public static void writeStringToFile(File file, String str, boolean z) throws IOException {
        writeStringToFile(file, str, Charset.defaultCharset(), z);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), false);
    }

    @Deprecated
    public static void write(File file, CharSequence charSequence, boolean z) throws IOException {
        write(file, charSequence, Charset.defaultCharset(), z);
    }

    public static void write(File file, CharSequence charSequence, Charset charset) throws IOException {
        write(file, charSequence, charset, false);
    }

    public static void write(File file, CharSequence charSequence, String str) throws IOException {
        write(file, charSequence, str, false);
    }

    public static void write(File file, CharSequence charSequence, Charset charset, boolean z) throws IOException {
        writeStringToFile(file, charSequence == null ? null : charSequence.toString(), charset, z);
    }

    public static void write(File file, CharSequence charSequence, String str, boolean z) throws IOException {
        write(file, charSequence, Charsets.toCharset(str), z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr) throws IOException {
        writeByteArrayToFile(file, bArr, false);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, boolean z) throws IOException {
        writeByteArrayToFile(file, bArr, 0, bArr.length, z);
    }

    public static void writeByteArrayToFile(File file, byte[] bArr, int i, int i2) throws IOException {
        writeByteArrayToFile(file, bArr, i, i2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeByteArrayToFile(java.io.File r0, byte[] r1, int r2, int r3, boolean r4) throws java.io.IOException {
        /*
            java.io.FileOutputStream r0 = openOutputStream(r0, r4)
            r0.write(r1, r2, r3)     // Catch:{ Throwable -> 0x0010, all -> 0x000d }
            if (r0 == 0) goto L_0x000c
            r0.close()
        L_0x000c:
            return
        L_0x000d:
            r1 = move-exception
            r2 = 0
            goto L_0x0013
        L_0x0010:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0012 }
        L_0x0012:
            r1 = move-exception
        L_0x0013:
            if (r0 == 0) goto L_0x0023
            if (r2 == 0) goto L_0x0020
            r0.close()     // Catch:{ Throwable -> 0x001b }
            goto L_0x0023
        L_0x001b:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x0023
        L_0x0020:
            r0.close()
        L_0x0023:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.writeByteArrayToFile(java.io.File, byte[], int, int, boolean):void");
    }

    public static void writeLines(File file, String str, Collection<?> collection) throws IOException {
        writeLines(file, str, collection, (String) null, false);
    }

    public static void writeLines(File file, String str, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, str, collection, (String) null, z);
    }

    public static void writeLines(File file, Collection<?> collection) throws IOException {
        writeLines(file, (String) null, collection, (String) null, false);
    }

    public static void writeLines(File file, Collection<?> collection, boolean z) throws IOException {
        writeLines(file, (String) null, collection, (String) null, z);
    }

    public static void writeLines(File file, String str, Collection<?> collection, String str2) throws IOException {
        writeLines(file, str, collection, str2, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r2 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeLines(java.io.File r1, java.lang.String r2, java.util.Collection<?> r3, java.lang.String r4, boolean r5) throws java.io.IOException {
        /*
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream
            java.io.FileOutputStream r1 = openOutputStream(r1, r5)
            r0.<init>(r1)
            org.apache.commons.p032io.IOUtils.writeLines((java.util.Collection<?>) r3, (java.lang.String) r4, (java.io.OutputStream) r0, (java.lang.String) r2)     // Catch:{ Throwable -> 0x0013, all -> 0x0010 }
            r0.close()
            return
        L_0x0010:
            r1 = move-exception
            r2 = 0
            goto L_0x0016
        L_0x0013:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0015 }
        L_0x0015:
            r1 = move-exception
        L_0x0016:
            if (r2 == 0) goto L_0x0021
            r0.close()     // Catch:{ Throwable -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r3 = move-exception
            r2.addSuppressed(r3)
            goto L_0x0024
        L_0x0021:
            r0.close()
        L_0x0024:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.writeLines(java.io.File, java.lang.String, java.util.Collection, java.lang.String, boolean):void");
    }

    public static void writeLines(File file, Collection<?> collection, String str) throws IOException {
        writeLines(file, (String) null, collection, str, false);
    }

    public static void writeLines(File file, Collection<?> collection, String str, boolean z) throws IOException {
        writeLines(file, (String) null, collection, str, z);
    }

    public static void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectory(file);
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (!exists) {
            throw new FileNotFoundException("File does not exist: " + file);
        }
        throw new IOException("Unable to delete file: " + file);
    }

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File file) throws IOException {
        if (file.exists()) {
            file.deleteOnExit();
            if (!isSymlink(file)) {
                cleanDirectoryOnExit(file);
            }
        }
    }

    private static void cleanDirectoryOnExit(File file) throws IOException {
        IOException e = null;
        for (File forceDeleteOnExit : verifiedListFiles(file)) {
            try {
                forceDeleteOnExit(forceDeleteOnExit);
            } catch (IOException e2) {
                e = e2;
            }
        }
        if (e != null) {
            throw e;
        }
    }

    public static void forceMkdir(File file) throws IOException {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
            }
        } else if (!file.mkdirs() && !file.isDirectory()) {
            throw new IOException("Unable to create directory " + file);
        }
    }

    public static void forceMkdirParent(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            forceMkdir(parentFile);
        }
    }

    public static long sizeOf(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            return sizeOfDirectory0(file);
        } else {
            return file.length();
        }
    }

    public static BigInteger sizeOfAsBigInteger(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (file.isDirectory()) {
            return sizeOfDirectoryBig0(file);
        } else {
            return BigInteger.valueOf(file.length());
        }
    }

    public static long sizeOfDirectory(File file) {
        checkDirectory(file);
        return sizeOfDirectory0(file);
    }

    private static long sizeOfDirectory0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return 0;
        }
        long j = 0;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    j += sizeOf0(file2);
                    if (j < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            } catch (IOException unused) {
            }
        }
        return j;
    }

    private static long sizeOf0(File file) {
        if (file.isDirectory()) {
            return sizeOfDirectory0(file);
        }
        return file.length();
    }

    public static BigInteger sizeOfDirectoryAsBigInteger(File file) {
        checkDirectory(file);
        return sizeOfDirectoryBig0(file);
    }

    private static BigInteger sizeOfDirectoryBig0(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return BigInteger.ZERO;
        }
        BigInteger bigInteger = BigInteger.ZERO;
        for (File file2 : listFiles) {
            try {
                if (!isSymlink(file2)) {
                    bigInteger = bigInteger.add(sizeOfBig0(file2));
                }
            } catch (IOException unused) {
            }
        }
        return bigInteger;
    }

    private static BigInteger sizeOfBig0(File file) {
        if (file.isDirectory()) {
            return sizeOfDirectoryBig0(file);
        }
        return BigInteger.valueOf(file.length());
    }

    private static void checkDirectory(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        } else if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
    }

    public static boolean isFileNewer(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileNewer(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileNewer(File file, Date date) {
        if (date != null) {
            return isFileNewer(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileNewer(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        } else if (file.exists() && file.lastModified() > j) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFileOlder(File file, File file2) {
        if (file2 == null) {
            throw new IllegalArgumentException("No specified reference file");
        } else if (file2.exists()) {
            return isFileOlder(file, file2.lastModified());
        } else {
            throw new IllegalArgumentException("The reference file '" + file2 + "' doesn't exist");
        }
    }

    public static boolean isFileOlder(File file, Date date) {
        if (date != null) {
            return isFileOlder(file, date.getTime());
        }
        throw new IllegalArgumentException("No specified date");
    }

    public static boolean isFileOlder(File file, long j) {
        if (file == null) {
            throw new IllegalArgumentException("No specified file");
        } else if (file.exists() && file.lastModified() < j) {
            return true;
        } else {
            return false;
        }
    }

    public static long checksumCRC32(File file) throws IOException {
        CRC32 crc32 = new CRC32();
        checksum(file, crc32);
        return crc32.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0021, code lost:
        if (r2 != null) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0027, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        r2.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002c, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r3 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.zip.Checksum checksum(java.io.File r2, java.util.zip.Checksum r3) throws java.io.IOException {
        /*
            boolean r0 = r2.isDirectory()
            if (r0 != 0) goto L_0x0030
            java.util.zip.CheckedInputStream r0 = new java.util.zip.CheckedInputStream
            java.io.FileInputStream r1 = new java.io.FileInputStream
            r1.<init>(r2)
            r0.<init>(r1, r3)
            r2 = 0
            org.apache.commons.io.output.NullOutputStream r1 = new org.apache.commons.io.output.NullOutputStream     // Catch:{ Throwable -> 0x001f }
            r1.<init>()     // Catch:{ Throwable -> 0x001f }
            org.apache.commons.p032io.IOUtils.copy((java.io.InputStream) r0, (java.io.OutputStream) r1)     // Catch:{ Throwable -> 0x001f }
            r0.close()
            return r3
        L_0x001d:
            r3 = move-exception
            goto L_0x0021
        L_0x001f:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001d }
        L_0x0021:
            if (r2 == 0) goto L_0x002c
            r0.close()     // Catch:{ Throwable -> 0x0027 }
            goto L_0x002f
        L_0x0027:
            r0 = move-exception
            r2.addSuppressed(r0)
            goto L_0x002f
        L_0x002c:
            r0.close()
        L_0x002f:
            throw r3
        L_0x0030:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Checksums can't be computed on directories"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.p032io.FileUtils.checksum(java.io.File, java.util.zip.Checksum):java.util.zip.Checksum");
    }

    public static void moveDirectory(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' is not a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (!file.renameTo(file2)) {
            String canonicalPath = file2.getCanonicalPath();
            if (!canonicalPath.startsWith(file.getCanonicalPath() + File.separator)) {
                copyDirectory(file, file2);
                deleteDirectory(file);
                if (file.exists()) {
                    throw new IOException("Failed to delete original directory '" + file + "' after copy to '" + file2 + "'");
                }
                return;
            }
            throw new IOException("Cannot move directory: " + file + " to a subdirectory of itself: " + file2);
        }
    }

    public static void moveDirectoryToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 != null) {
            if (!file2.exists() && z) {
                file2.mkdirs();
            }
            if (!file2.exists()) {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
            } else if (file2.isDirectory()) {
                moveDirectory(file, new File(file2, file.getName()));
            } else {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            }
        } else {
            throw new NullPointerException("Destination directory must not be null");
        }
    }

    public static void moveFile(File file, File file2) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            throw new IOException("Source '" + file + "' is a directory");
        } else if (file2.exists()) {
            throw new FileExistsException("Destination '" + file2 + "' already exists");
        } else if (file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' is a directory");
        } else if (!file.renameTo(file2)) {
            copyFile(file, file2);
            if (!file.delete()) {
                deleteQuietly(file2);
                throw new IOException("Failed to delete original file '" + file + "' after copy to '" + file2 + "'");
            }
        }
    }

    public static void moveFileToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 != null) {
            if (!file2.exists() && z) {
                file2.mkdirs();
            }
            if (!file2.exists()) {
                throw new FileNotFoundException("Destination directory '" + file2 + "' does not exist [createDestDir=" + z + "]");
            } else if (file2.isDirectory()) {
                moveFile(file, new File(file2, file.getName()));
            } else {
                throw new IOException("Destination '" + file2 + "' is not a directory");
            }
        } else {
            throw new NullPointerException("Destination directory must not be null");
        }
    }

    public static void moveToDirectory(File file, File file2, boolean z) throws IOException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        } else if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        } else if (!file.exists()) {
            throw new FileNotFoundException("Source '" + file + "' does not exist");
        } else if (file.isDirectory()) {
            moveDirectoryToDirectory(file, file2, z);
        } else {
            moveFileToDirectory(file, file2, z);
        }
    }

    public static boolean isSymlink(File file) throws IOException {
        if (file != null) {
            return Files.isSymbolicLink(file.toPath());
        }
        throw new NullPointerException("File must not be null");
    }
}
