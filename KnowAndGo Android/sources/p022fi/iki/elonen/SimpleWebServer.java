package p022fi.iki.elonen;

import androidx.core.p005os.EnvironmentCompat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.StringTokenizer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.p032io.IOUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import p022fi.iki.elonen.NanoHTTPD;
import p022fi.iki.elonen.util.ServerRunner;

/* renamed from: fi.iki.elonen.SimpleWebServer */
public class SimpleWebServer extends NanoHTTPD {
    public static final String ACCESS_CONTROL_ALLOW_HEADER_PROPERTY_NAME = "AccessControlAllowHeader";
    private static final String ALLOWED_METHODS = "GET, POST, PUT, DELETE, OPTIONS, HEAD";
    static final String DEFAULT_ALLOWED_HEADERS = "origin,accept,content-type";
    public static final List<String> INDEX_FILE_NAMES = new ArrayList<String>() {
        {
            add("index.html");
            add("index.htm");
        }
    };
    private static final String LICENCE;
    private static final int MAX_AGE = 151200;
    private static Map<String, WebServerPlugin> mimeTypeHandlers = new HashMap();
    private final String cors;
    private final boolean quiet;
    protected List<File> rootDirs;

    public void init() {
    }

    static {
        String str;
        mimeTypes();
        try {
            InputStream resourceAsStream = SimpleWebServer.class.getResourceAsStream("/LICENSE.txt");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = resourceAsStream.read(bArr);
                if (read < 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            str = byteArrayOutputStream.toString("UTF-8");
        } catch (Exception unused) {
            str = EnvironmentCompat.MEDIA_UNKNOWN;
        }
        LICENCE = str;
    }

    public static void main(String[] strArr) {
        Iterator<S> it;
        int indexOf;
        String[] strArr2 = strArr;
        ArrayList<File> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        String str = null;
        String str2 = null;
        int i = 8080;
        boolean z = false;
        for (int i2 = 0; i2 < strArr2.length; i2++) {
            if ("-h".equalsIgnoreCase(strArr2[i2]) || "--host".equalsIgnoreCase(strArr2[i2])) {
                str = strArr2[i2 + 1];
            } else if ("-p".equalsIgnoreCase(strArr2[i2]) || "--port".equalsIgnoreCase(strArr2[i2])) {
                i = Integer.parseInt(strArr2[i2 + 1]);
            } else if ("-q".equalsIgnoreCase(strArr2[i2]) || "--quiet".equalsIgnoreCase(strArr2[i2])) {
                z = true;
            } else if ("-d".equalsIgnoreCase(strArr2[i2]) || "--dir".equalsIgnoreCase(strArr2[i2])) {
                arrayList.add(new File(strArr2[i2 + 1]).getAbsoluteFile());
            } else if (strArr2[i2].startsWith("--cors")) {
                str2 = "*";
                int indexOf2 = strArr2[i2].indexOf(61);
                if (indexOf2 > 0) {
                    str2 = strArr2[i2].substring(indexOf2 + 1);
                }
            } else if ("--licence".equalsIgnoreCase(strArr2[i2])) {
                System.out.println(LICENCE + "\n");
            } else if (strArr2[i2].startsWith("-X:") && (indexOf = strArr2[i2].indexOf(61)) > 0) {
                hashMap.put(strArr2[i2].substring(0, indexOf), strArr2[i2].substring(indexOf + 1, strArr2[i2].length()));
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new File(".").getAbsoluteFile());
        }
        hashMap.put("host", str);
        hashMap.put("port", "" + i);
        hashMap.put("quiet", String.valueOf(z));
        StringBuilder sb = new StringBuilder();
        for (File file : arrayList) {
            if (sb.length() > 0) {
                sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            }
            try {
                sb.append(file.getCanonicalPath());
            } catch (IOException unused) {
            }
        }
        hashMap.put("home", sb.toString());
        Iterator<S> it2 = ServiceLoader.load(WebServerPluginInfo.class).iterator();
        while (it2.hasNext()) {
            WebServerPluginInfo webServerPluginInfo = (WebServerPluginInfo) it2.next();
            String[] mimeTypes = webServerPluginInfo.getMimeTypes();
            int length = mimeTypes.length;
            int i3 = 0;
            while (i3 < length) {
                String str3 = mimeTypes[i3];
                String[] indexFilesForMimeType = webServerPluginInfo.getIndexFilesForMimeType(str3);
                if (!z) {
                    System.out.print("# Found plugin for Mime type: \"" + str3 + "\"");
                    if (indexFilesForMimeType != null) {
                        System.out.print(" (serving index files: ");
                        int i4 = 0;
                        for (int length2 = indexFilesForMimeType.length; i4 < length2; length2 = length2) {
                            String str4 = indexFilesForMimeType[i4];
                            Iterator<S> it3 = it2;
                            System.out.print(str4 + StringUtils.SPACE);
                            i4++;
                            it2 = it3;
                        }
                    }
                    it = it2;
                    System.out.println(").");
                } else {
                    it = it2;
                }
                registerPluginForMimeType(indexFilesForMimeType, str3, webServerPluginInfo.getWebServerPlugin(str3), hashMap);
                i3++;
                it2 = it;
            }
        }
        ServerRunner.executeInstance(new SimpleWebServer(str, i, (List<File>) arrayList, z, str2));
    }

    protected static void registerPluginForMimeType(String[] strArr, String str, WebServerPlugin webServerPlugin, Map<String, String> map) {
        if (str != null && webServerPlugin != null) {
            if (strArr != null) {
                for (String str2 : strArr) {
                    int lastIndexOf = str2.lastIndexOf(46);
                    if (lastIndexOf >= 0) {
                        mimeTypes().put(str2.substring(lastIndexOf + 1).toLowerCase(), str);
                    }
                }
                INDEX_FILE_NAMES.addAll(Arrays.asList(strArr));
            }
            mimeTypeHandlers.put(str, webServerPlugin);
            webServerPlugin.initialize(map);
        }
    }

    public SimpleWebServer(String str, int i, File file, boolean z, String str2) {
        this(str, i, (List<File>) Collections.singletonList(file), z, str2);
    }

    public SimpleWebServer(String str, int i, File file, boolean z) {
        this(str, i, (List<File>) Collections.singletonList(file), z, (String) null);
    }

    public SimpleWebServer(String str, int i, List<File> list, boolean z) {
        this(str, i, list, z, (String) null);
    }

    public SimpleWebServer(String str, int i, List<File> list, boolean z, String str2) {
        super(str, i);
        this.quiet = z;
        this.cors = str2;
        this.rootDirs = new ArrayList(list);
        init();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r1 = mimeTypeHandlers.get(getMimeTypeForFile(r4));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean canServeUri(java.lang.String r4, java.io.File r5) {
        /*
            r3 = this;
            java.io.File r0 = new java.io.File
            r0.<init>(r5, r4)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x001d
            java.util.Map<java.lang.String, fi.iki.elonen.WebServerPlugin> r1 = mimeTypeHandlers
            java.lang.String r2 = getMimeTypeForFile(r4)
            java.lang.Object r1 = r1.get(r2)
            fi.iki.elonen.WebServerPlugin r1 = (p022fi.iki.elonen.WebServerPlugin) r1
            if (r1 == 0) goto L_0x001d
            boolean r0 = r1.canServeUri(r4, r5)
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p022fi.iki.elonen.SimpleWebServer.canServeUri(java.lang.String, java.io.File):boolean");
    }

    private String encodeUri(String str) {
        String str2;
        String str3 = "";
        StringTokenizer stringTokenizer = new StringTokenizer(str, "/ ", true);
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if ("/".equals(nextToken)) {
                str2 = str3 + "/";
            } else if (StringUtils.SPACE.equals(nextToken)) {
                str2 = str3 + "%20";
            } else {
                try {
                    str2 = str3 + URLEncoder.encode(nextToken, "UTF-8");
                } catch (UnsupportedEncodingException unused) {
                }
            }
            str3 = str2;
        }
        return str3;
    }

    private String findIndexFileInDirectory(File file) {
        for (String next : INDEX_FILE_NAMES) {
            if (new File(file, next).isFile()) {
                return next;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public NanoHTTPD.C3566Response getForbiddenResponse(String str) {
        NanoHTTPD.C3566Response.Status status = NanoHTTPD.C3566Response.Status.FORBIDDEN;
        return newFixedLengthResponse(status, NanoHTTPD.MIME_PLAINTEXT, "FORBIDDEN: " + str);
    }

    /* access modifiers changed from: protected */
    public NanoHTTPD.C3566Response getInternalErrorResponse(String str) {
        NanoHTTPD.C3566Response.Status status = NanoHTTPD.C3566Response.Status.INTERNAL_ERROR;
        return newFixedLengthResponse(status, NanoHTTPD.MIME_PLAINTEXT, "INTERNAL ERROR: " + str);
    }

    /* access modifiers changed from: protected */
    public NanoHTTPD.C3566Response getNotFoundResponse() {
        return newFixedLengthResponse(NanoHTTPD.C3566Response.Status.NOT_FOUND, NanoHTTPD.MIME_PLAINTEXT, "Error 404, file not found.");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0054, code lost:
        r0 = r12.substring(0, r12.length() - 1);
        r4 = r0.lastIndexOf(47);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String listDirectory(java.lang.String r12, java.io.File r13) {
        /*
            r11 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Directory "
            r0.append(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "<html><head><title>"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = "</title><style><!--\n"
            r2.append(r3)
            java.lang.String r3 = "span.dirname { font-weight: bold; }\n"
            r2.append(r3)
            java.lang.String r3 = "span.filesize { font-size: 75%; }\n"
            r2.append(r3)
            java.lang.String r3 = "// -->\n"
            r2.append(r3)
            java.lang.String r3 = "</style>"
            r2.append(r3)
            java.lang.String r3 = "</head><body><h1>"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "</h1>"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            int r0 = r12.length()
            r2 = 1
            if (r0 <= r2) goto L_0x0072
            int r0 = r12.length()
            int r0 = r0 - r2
            r3 = 0
            java.lang.String r0 = r12.substring(r3, r0)
            r4 = 47
            int r4 = r0.lastIndexOf(r4)
            if (r4 < 0) goto L_0x0072
            int r0 = r0.length()
            if (r4 >= r0) goto L_0x0072
            int r4 = r4 + r2
            java.lang.String r0 = r12.substring(r3, r4)
            goto L_0x0073
        L_0x0072:
            r0 = 0
        L_0x0073:
            fi.iki.elonen.SimpleWebServer$2 r2 = new fi.iki.elonen.SimpleWebServer$2
            r2.<init>()
            java.lang.String[] r2 = r13.list(r2)
            java.util.List r2 = java.util.Arrays.asList(r2)
            java.util.Collections.sort(r2)
            fi.iki.elonen.SimpleWebServer$3 r3 = new fi.iki.elonen.SimpleWebServer$3
            r3.<init>()
            java.lang.String[] r3 = r13.list(r3)
            java.util.List r3 = java.util.Arrays.asList(r3)
            java.util.Collections.sort(r3)
            if (r0 != 0) goto L_0x00a0
            int r4 = r3.size()
            int r5 = r2.size()
            int r4 = r4 + r5
            if (r4 <= 0) goto L_0x01b9
        L_0x00a0:
            java.lang.String r4 = "<ul>"
            r1.append(r4)
            if (r0 != 0) goto L_0x00ad
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x0110
        L_0x00ad:
            java.lang.String r4 = "<section class=\"directories\">"
            r1.append(r4)
            if (r0 == 0) goto L_0x00c1
            java.lang.String r4 = "<li><a rel=\"directory\" href=\""
            r1.append(r4)
            r1.append(r0)
            java.lang.String r0 = "\"><span class=\"dirname\">..</span></a></li>"
            r1.append(r0)
        L_0x00c1:
            java.util.Iterator r0 = r3.iterator()
        L_0x00c5:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x010b
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            java.lang.String r3 = "/"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            java.lang.String r4 = "<li><a rel=\"directory\" href=\""
            r1.append(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r4 = r11.encodeUri(r4)
            r1.append(r4)
            java.lang.String r4 = "\"><span class=\"dirname\">"
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = "</span></a></li>"
            r1.append(r3)
            goto L_0x00c5
        L_0x010b:
            java.lang.String r0 = "</section>"
            r1.append(r0)
        L_0x0110:
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x01b4
            java.lang.String r0 = "<section class=\"files\">"
            r1.append(r0)
            java.util.Iterator r0 = r2.iterator()
        L_0x011f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x01af
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "<li><a href=\""
            r1.append(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r12)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r11.encodeUri(r3)
            r1.append(r3)
            java.lang.String r3 = "\"><span class=\"filename\">"
            r1.append(r3)
            r1.append(r2)
            java.lang.String r3 = "</span></a>"
            r1.append(r3)
            java.io.File r3 = new java.io.File
            r3.<init>(r13, r2)
            long r2 = r3.length()
            java.lang.String r4 = "&nbsp;<span class=\"filesize\">("
            r1.append(r4)
            r4 = 1024(0x400, double:5.06E-321)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0170
            r1.append(r2)
            java.lang.String r2 = " bytes"
            r1.append(r2)
            goto L_0x01a8
        L_0x0170:
            r6 = 100
            r8 = 1048576(0x100000, double:5.180654E-318)
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 >= 0) goto L_0x0191
            long r8 = r2 / r4
            r1.append(r8)
            java.lang.String r8 = "."
            r1.append(r8)
            long r2 = r2 % r4
            r4 = 10
            long r2 = r2 / r4
            long r2 = r2 % r6
            r1.append(r2)
            java.lang.String r2 = " KB"
            r1.append(r2)
            goto L_0x01a8
        L_0x0191:
            long r4 = r2 / r8
            r1.append(r4)
            java.lang.String r4 = "."
            r1.append(r4)
            long r2 = r2 % r8
            r4 = 10000(0x2710, double:4.9407E-320)
            long r2 = r2 / r4
            long r2 = r2 % r6
            r1.append(r2)
            java.lang.String r2 = " MB"
            r1.append(r2)
        L_0x01a8:
            java.lang.String r2 = ")</span></li>"
            r1.append(r2)
            goto L_0x011f
        L_0x01af:
            java.lang.String r12 = "</section>"
            r1.append(r12)
        L_0x01b4:
            java.lang.String r12 = "</ul>"
            r1.append(r12)
        L_0x01b9:
            java.lang.String r12 = "</body></html>"
            r1.append(r12)
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p022fi.iki.elonen.SimpleWebServer.listDirectory(java.lang.String, java.io.File):java.lang.String");
    }

    public static NanoHTTPD.C3566Response newFixedLengthResponse(NanoHTTPD.C3566Response.IStatus iStatus, String str, String str2) {
        NanoHTTPD.C3566Response newFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(iStatus, str, str2);
        newFixedLengthResponse.addHeader("Accept-Ranges", "bytes");
        return newFixedLengthResponse;
    }

    private NanoHTTPD.C3566Response respond(Map<String, String> map, NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        NanoHTTPD.C3566Response response;
        if (this.cors == null || !NanoHTTPD.Method.OPTIONS.equals(iHTTPSession.getMethod())) {
            response = defaultRespond(map, iHTTPSession, str);
        } else {
            response = new NanoHTTPD.C3566Response(NanoHTTPD.C3566Response.Status.OK, NanoHTTPD.MIME_PLAINTEXT, (InputStream) null, 0);
        }
        return this.cors != null ? addCORSHeaders(map, response, this.cors) : response;
    }

    private NanoHTTPD.C3566Response defaultRespond(Map<String, String> map, NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        NanoHTTPD.C3566Response response;
        String replace = str.trim().replace(File.separatorChar, IOUtils.DIR_SEPARATOR_UNIX);
        boolean z = false;
        if (replace.indexOf(63) >= 0) {
            replace = replace.substring(0, replace.indexOf(63));
        }
        String str2 = replace;
        if (str2.contains("../")) {
            return getForbiddenResponse("Won't serve ../ for security reasons.");
        }
        File file = null;
        int i = 0;
        while (!z && i < this.rootDirs.size()) {
            file = this.rootDirs.get(i);
            z = canServeUri(str2, file);
            i++;
        }
        if (!z) {
            return getNotFoundResponse();
        }
        File file2 = new File(file, str2);
        if (file2.isDirectory() && !str2.endsWith("/")) {
            String str3 = str2 + "/";
            NanoHTTPD.C3566Response newFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.C3566Response.Status.REDIRECT, NanoHTTPD.MIME_HTML, "<html><body>Redirected: <a href=\"" + str3 + "\">" + str3 + "</a></body></html>");
            newFixedLengthResponse.addHeader("Location", str3);
            return newFixedLengthResponse;
        } else if (file2.isDirectory()) {
            String findIndexFileInDirectory = findIndexFileInDirectory(file2);
            if (findIndexFileInDirectory != null) {
                return respond(map, iHTTPSession, str2 + findIndexFileInDirectory);
            } else if (file2.canRead()) {
                return newFixedLengthResponse(NanoHTTPD.C3566Response.Status.OK, NanoHTTPD.MIME_HTML, listDirectory(str2, file2));
            } else {
                return getForbiddenResponse("No directory listing.");
            }
        } else {
            String mimeTypeForFile = getMimeTypeForFile(str2);
            WebServerPlugin webServerPlugin = mimeTypeHandlers.get(mimeTypeForFile);
            if (webServerPlugin == null || !webServerPlugin.canServeUri(str2, file)) {
                response = serveFile(str2, map, file2, mimeTypeForFile);
            } else {
                response = webServerPlugin.serveFile(str2, map, iHTTPSession, file2, mimeTypeForFile);
                if (response != null && (response instanceof InternalRewrite)) {
                    InternalRewrite internalRewrite = (InternalRewrite) response;
                    return respond(internalRewrite.getHeaders(), iHTTPSession, internalRewrite.getUri());
                }
            }
            return response != null ? response : getNotFoundResponse();
        }
    }

    public NanoHTTPD.C3566Response serve(NanoHTTPD.IHTTPSession iHTTPSession) {
        Map<String, String> headers = iHTTPSession.getHeaders();
        Map<String, String> parms = iHTTPSession.getParms();
        String uri = iHTTPSession.getUri();
        if (!this.quiet) {
            PrintStream printStream = System.out;
            printStream.println(iHTTPSession.getMethod() + " '" + uri + "' ");
            for (String next : headers.keySet()) {
                PrintStream printStream2 = System.out;
                printStream2.println("  HDR: '" + next + "' = '" + headers.get(next) + "'");
            }
            for (String next2 : parms.keySet()) {
                PrintStream printStream3 = System.out;
                printStream3.println("  PRM: '" + next2 + "' = '" + parms.get(next2) + "'");
            }
        }
        for (File next3 : this.rootDirs) {
            if (!next3.isDirectory()) {
                return getInternalErrorResponse("given path is not a directory (" + next3 + ").");
            }
        }
        return respond(Collections.unmodifiableMap(headers), iHTTPSession, uri);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0049, code lost:
        r7 = r7.substring("bytes=".length());
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a3 A[ADDED_TO_REGION, Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x012e A[ADDED_TO_REGION, Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015c A[ADDED_TO_REGION, Catch:{ IOException -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x016e A[ADDED_TO_REGION, Catch:{ IOException -> 0x019e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p022fi.iki.elonen.NanoHTTPD.C3566Response serveFile(java.lang.String r20, java.util.Map<java.lang.String, java.lang.String> r21, java.io.File r22, java.lang.String r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            r2 = r22
            r3 = r23
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r4.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = r22.getAbsolutePath()     // Catch:{ IOException -> 0x019e }
            r4.append(r5)     // Catch:{ IOException -> 0x019e }
            long r5 = r22.lastModified()     // Catch:{ IOException -> 0x019e }
            r4.append(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = ""
            r4.append(r5)     // Catch:{ IOException -> 0x019e }
            long r5 = r22.length()     // Catch:{ IOException -> 0x019e }
            r4.append(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x019e }
            int r4 = r4.hashCode()     // Catch:{ IOException -> 0x019e }
            java.lang.String r4 = java.lang.Integer.toHexString(r4)     // Catch:{ IOException -> 0x019e }
            r5 = -1
            java.lang.String r7 = "range"
            java.lang.Object r7 = r1.get(r7)     // Catch:{ IOException -> 0x019e }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x019e }
            r8 = 0
            r9 = 1
            if (r7 == 0) goto L_0x006e
            java.lang.String r12 = "bytes="
            boolean r12 = r7.startsWith(r12)     // Catch:{ IOException -> 0x019e }
            if (r12 == 0) goto L_0x006e
            java.lang.String r12 = "bytes="
            int r12 = r12.length()     // Catch:{ IOException -> 0x019e }
            java.lang.String r7 = r7.substring(r12)     // Catch:{ IOException -> 0x019e }
            r12 = 45
            int r12 = r7.indexOf(r12)     // Catch:{ IOException -> 0x019e }
            if (r12 <= 0) goto L_0x006e
            java.lang.String r13 = r7.substring(r8, r12)     // Catch:{ NumberFormatException -> 0x006e }
            long r13 = java.lang.Long.parseLong(r13)     // Catch:{ NumberFormatException -> 0x006e }
            int r12 = r12 + r9
            java.lang.String r12 = r7.substring(r12)     // Catch:{ NumberFormatException -> 0x0070 }
            long r15 = java.lang.Long.parseLong(r12)     // Catch:{ NumberFormatException -> 0x0070 }
            r5 = r15
            goto L_0x0070
        L_0x006e:
            r13 = 0
        L_0x0070:
            java.lang.String r12 = "if-range"
            java.lang.Object r12 = r1.get(r12)     // Catch:{ IOException -> 0x019e }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IOException -> 0x019e }
            if (r12 == 0) goto L_0x0083
            boolean r12 = r4.equals(r12)     // Catch:{ IOException -> 0x019e }
            if (r12 == 0) goto L_0x0081
            goto L_0x0083
        L_0x0081:
            r12 = 0
            goto L_0x0084
        L_0x0083:
            r12 = 1
        L_0x0084:
            java.lang.String r15 = "if-none-match"
            java.lang.Object r1 = r1.get(r15)     // Catch:{ IOException -> 0x019e }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x009d
            java.lang.String r15 = "*"
            boolean r15 = r15.equals(r1)     // Catch:{ IOException -> 0x019e }
            if (r15 != 0) goto L_0x009c
            boolean r1 = r1.equals(r4)     // Catch:{ IOException -> 0x019e }
            if (r1 == 0) goto L_0x009d
        L_0x009c:
            r8 = 1
        L_0x009d:
            long r10 = r22.length()     // Catch:{ IOException -> 0x019e }
            if (r12 == 0) goto L_0x012c
            if (r7 == 0) goto L_0x012c
            r15 = 0
            int r1 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r1 < 0) goto L_0x012c
            int r1 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x012c
            if (r8 == 0) goto L_0x00c0
            fi.iki.elonen.NanoHTTPD$Response$Status r1 = p022fi.iki.elonen.NanoHTTPD.C3566Response.Status.NOT_MODIFIED     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = ""
            fi.iki.elonen.NanoHTTPD$Response r1 = newFixedLengthResponse(r1, r3, r2)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x00c0:
            r7 = 1
            r15 = 0
            int r1 = (r5 > r15 ? 1 : (r5 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ca
            long r5 = r10 - r7
        L_0x00ca:
            r1 = 0
            long r17 = r5 - r13
            long r7 = r17 + r7
            int r1 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r1 >= 0) goto L_0x00d4
            r7 = r15
        L_0x00d4:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ IOException -> 0x019e }
            r1.<init>(r2)     // Catch:{ IOException -> 0x019e }
            r1.skip(r13)     // Catch:{ IOException -> 0x019e }
            fi.iki.elonen.NanoHTTPD$Response$Status r2 = p022fi.iki.elonen.NanoHTTPD.C3566Response.Status.PARTIAL_CONTENT     // Catch:{ IOException -> 0x019e }
            fi.iki.elonen.NanoHTTPD$Response r1 = newFixedLengthResponse(r2, r3, r1, r7)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "Accept-Ranges"
            java.lang.String r3 = "bytes"
            r1.addHeader(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "Content-Length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r3.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r9 = ""
            r3.append(r9)     // Catch:{ IOException -> 0x019e }
            r3.append(r7)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x019e }
            r1.addHeader(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "Content-Range"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r3.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r7 = "bytes "
            r3.append(r7)     // Catch:{ IOException -> 0x019e }
            r3.append(r13)     // Catch:{ IOException -> 0x019e }
            java.lang.String r7 = "-"
            r3.append(r7)     // Catch:{ IOException -> 0x019e }
            r3.append(r5)     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = "/"
            r3.append(r5)     // Catch:{ IOException -> 0x019e }
            r3.append(r10)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x019e }
            r1.addHeader(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x012c:
            if (r12 == 0) goto L_0x015a
            if (r7 == 0) goto L_0x015a
            int r1 = (r13 > r10 ? 1 : (r13 == r10 ? 0 : -1))
            if (r1 < 0) goto L_0x015a
            fi.iki.elonen.NanoHTTPD$Response$Status r1 = p022fi.iki.elonen.NanoHTTPD.C3566Response.Status.RANGE_NOT_SATISFIABLE     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "text/plain"
            java.lang.String r3 = ""
            fi.iki.elonen.NanoHTTPD$Response r1 = newFixedLengthResponse(r1, r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "Content-Range"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r3.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = "bytes */"
            r3.append(r5)     // Catch:{ IOException -> 0x019e }
            r3.append(r10)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x019e }
            r1.addHeader(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x015a:
            if (r7 != 0) goto L_0x016c
            if (r8 == 0) goto L_0x016c
            fi.iki.elonen.NanoHTTPD$Response$Status r1 = p022fi.iki.elonen.NanoHTTPD.C3566Response.Status.NOT_MODIFIED     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = ""
            fi.iki.elonen.NanoHTTPD$Response r1 = newFixedLengthResponse(r1, r3, r2)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x016c:
            if (r12 != 0) goto L_0x017e
            if (r8 == 0) goto L_0x017e
            fi.iki.elonen.NanoHTTPD$Response$Status r1 = p022fi.iki.elonen.NanoHTTPD.C3566Response.Status.NOT_MODIFIED     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = ""
            fi.iki.elonen.NanoHTTPD$Response r1 = newFixedLengthResponse(r1, r3, r2)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x017e:
            fi.iki.elonen.NanoHTTPD$Response r1 = r0.newFixedFileResponse(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "Content-Length"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x019e }
            r3.<init>()     // Catch:{ IOException -> 0x019e }
            java.lang.String r5 = ""
            r3.append(r5)     // Catch:{ IOException -> 0x019e }
            r3.append(r10)     // Catch:{ IOException -> 0x019e }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x019e }
            r1.addHeader(r2, r3)     // Catch:{ IOException -> 0x019e }
            java.lang.String r2 = "ETag"
            r1.addHeader(r2, r4)     // Catch:{ IOException -> 0x019e }
            goto L_0x01a4
        L_0x019e:
            java.lang.String r1 = "Reading file failed."
            fi.iki.elonen.NanoHTTPD$Response r1 = r0.getForbiddenResponse(r1)
        L_0x01a4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p022fi.iki.elonen.SimpleWebServer.serveFile(java.lang.String, java.util.Map, java.io.File, java.lang.String):fi.iki.elonen.NanoHTTPD$Response");
    }

    private NanoHTTPD.C3566Response newFixedFileResponse(File file, String str) throws FileNotFoundException {
        NanoHTTPD.C3566Response newFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.C3566Response.Status.OK, str, new FileInputStream(file), (long) ((int) file.length()));
        newFixedLengthResponse.addHeader("Accept-Ranges", "bytes");
        return newFixedLengthResponse;
    }

    /* access modifiers changed from: protected */
    public NanoHTTPD.C3566Response addCORSHeaders(Map<String, String> map, NanoHTTPD.C3566Response response, String str) {
        response.addHeader("Access-Control-Allow-Origin", str);
        response.addHeader("Access-Control-Allow-Headers", calculateAllowHeaders(map));
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", ALLOWED_METHODS);
        response.addHeader("Access-Control-Max-Age", "151200");
        return response;
    }

    private String calculateAllowHeaders(Map<String, String> map) {
        return System.getProperty(ACCESS_CONTROL_ALLOW_HEADER_PROPERTY_NAME, DEFAULT_ALLOWED_HEADERS);
    }
}
