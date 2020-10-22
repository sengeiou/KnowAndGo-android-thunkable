package p022fi.iki.elonen;

/* renamed from: fi.iki.elonen.WebServerPluginInfo */
public interface WebServerPluginInfo {
    String[] getIndexFilesForMimeType(String str);

    String[] getMimeTypes();

    WebServerPlugin getWebServerPlugin(String str);
}
