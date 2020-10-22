package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.C3873Response;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okio.Sink;

public interface HttpCodec {
    public static final int DISCARD_STREAM_TIMEOUT_MILLIS = 100;

    void cancel();

    Sink createRequestBody(Request request, long j);

    void finishRequest() throws IOException;

    void flushRequest() throws IOException;

    ResponseBody openResponseBody(C3873Response response) throws IOException;

    C3873Response.Builder readResponseHeaders(boolean z) throws IOException;

    void writeRequestHeaders(Request request) throws IOException;
}
