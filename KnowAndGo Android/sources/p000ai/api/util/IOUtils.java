package p000ai.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* renamed from: ai.api.util.IOUtils */
public class IOUtils {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static void writeAll(String str, OutputStream outputStream, Charset charset) throws IOException {
        writeAll(str, outputStream, charset.name());
    }

    public static void writeAll(String str, OutputStream outputStream, String str2) throws IOException {
        if (str != null && str.length() > 0) {
            outputStream.write(str.getBytes(str2));
        }
    }

    public static void writeAll(String str, OutputStream outputStream) throws IOException {
        writeAll(str, outputStream, "UTF-8");
    }

    public static String readAll(InputStream inputStream, Charset charset) throws IOException {
        return readAll(inputStream, charset.name());
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
    public static java.lang.String readAll(java.io.InputStream r1, java.lang.String r2) throws java.io.IOException {
        /*
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            r0.<init>(r1, r2)
            java.lang.String r1 = readAll((java.io.InputStreamReader) r0)     // Catch:{ Throwable -> 0x0010, all -> 0x000d }
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
        throw new UnsupportedOperationException("Method not decompiled: p000ai.api.util.IOUtils.readAll(java.io.InputStream, java.lang.String):java.lang.String");
    }

    public static String readAll(InputStream inputStream) throws IOException {
        return readAll(inputStream, "UTF-8");
    }

    public static String readAll(InputStreamReader inputStreamReader) throws IOException {
        StringWriter stringWriter = new StringWriter();
        copy(inputStreamReader, stringWriter);
        return stringWriter.toString();
    }

    private static long copy(Reader reader, Writer writer) throws IOException {
        return copy(reader, writer, new char[4096]);
    }

    private static long copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        long j = 0;
        int read = reader.read(cArr);
        while (read > 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }
}
