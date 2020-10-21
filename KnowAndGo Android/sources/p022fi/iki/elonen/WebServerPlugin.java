package p022fi.iki.elonen;

import java.io.File;
import java.util.Map;
import p022fi.iki.elonen.NanoHTTPD;

/* renamed from: fi.iki.elonen.WebServerPlugin */
public interface WebServerPlugin {
    boolean canServeUri(String str, File file);

    void initialize(Map<String, String> map);

    NanoHTTPD.C3566Response serveFile(String str, Map<String, String> map, NanoHTTPD.IHTTPSession iHTTPSession, File file, String str2);
}
