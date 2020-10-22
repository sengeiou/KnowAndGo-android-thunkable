package com.futurepress.staticserver;

import java.io.File;
import java.io.IOException;
import p022fi.iki.elonen.NanoHTTPD;
import p022fi.iki.elonen.SimpleWebServer;

public class WebServer extends SimpleWebServer {
    public WebServer(String str, int i, File file) throws IOException {
        super(str, i, file, true, "*");
        mimeTypes().put("xhtml", "application/xhtml+xml");
        mimeTypes().put("opf", "application/oebps-package+xml");
        mimeTypes().put("ncx", "application/xml");
        mimeTypes().put("epub", "application/epub+zip");
        mimeTypes().put("otf", "application/x-font-otf");
        mimeTypes().put("ttf", "application/x-font-ttf");
        mimeTypes().put("js", "application/javascript");
        mimeTypes().put("svg", "image/svg+xml");
    }

    /* access modifiers changed from: protected */
    public boolean useGzipWhenAccepted(NanoHTTPD.C3566Response response) {
        return super.useGzipWhenAccepted(response) && response.getStatus() != NanoHTTPD.C3566Response.Status.NOT_MODIFIED;
    }
}
