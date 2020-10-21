package p000ai.api.android;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import java.util.TimeZone;
import p000ai.api.AIServiceContext;

/* renamed from: ai.api.android.AIDataService */
public class AIDataService extends p000ai.api.AIDataService {
    public static final String TAG = "ai.api.android.AIDataService";
    @NonNull
    private final AIConfiguration config;
    @NonNull
    private final Context context;
    @NonNull
    private final Gson gson = GsonFactory.getGson();

    public AIDataService(@NonNull Context context2, @NonNull AIConfiguration aIConfiguration) {
        super(aIConfiguration, new AIAndroidServiceContext(context2));
        this.context = context2;
        this.config = aIConfiguration;
    }

    /* renamed from: ai.api.android.AIDataService$AIAndroidServiceContext */
    private static class AIAndroidServiceContext implements AIServiceContext {
        private final String sessionId;

        public AIAndroidServiceContext(Context context) {
            this.sessionId = SessionIdStorage.getSessionId(context);
        }

        public String getSessionId() {
            return this.sessionId;
        }

        public TimeZone getTimeZone() {
            return TimeZone.getDefault();
        }
    }
}
