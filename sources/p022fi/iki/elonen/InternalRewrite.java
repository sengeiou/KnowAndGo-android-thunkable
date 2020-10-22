package p022fi.iki.elonen;

import java.io.ByteArrayInputStream;
import java.util.Map;
import p022fi.iki.elonen.NanoHTTPD;

/* renamed from: fi.iki.elonen.InternalRewrite */
public class InternalRewrite extends NanoHTTPD.C3566Response {
    private final Map<String, String> headers;
    private final String uri;

    public InternalRewrite(Map<String, String> map, String str) {
        super(NanoHTTPD.C3566Response.Status.OK, NanoHTTPD.MIME_HTML, new ByteArrayInputStream(new byte[0]), 0);
        this.headers = map;
        this.uri = str;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public String getUri() {
        return this.uri;
    }
}
