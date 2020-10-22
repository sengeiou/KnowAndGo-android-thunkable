package okhttp3.internal.cache;

import java.io.IOException;
import okhttp3.C3873Response;
import okhttp3.Request;

public interface InternalCache {
    C3873Response get(Request request) throws IOException;

    CacheRequest put(C3873Response response) throws IOException;

    void remove(Request request) throws IOException;

    void trackConditionalCacheHit();

    void trackResponse(CacheStrategy cacheStrategy);

    void update(C3873Response response, C3873Response response2);
}
