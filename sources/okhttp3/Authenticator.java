package okhttp3;

import java.io.IOException;
import javax.annotation.Nullable;

public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() {
        public Request authenticate(@Nullable Route route, C3873Response response) {
            return null;
        }
    };

    @Nullable
    Request authenticate(@Nullable Route route, C3873Response response) throws IOException;
}
