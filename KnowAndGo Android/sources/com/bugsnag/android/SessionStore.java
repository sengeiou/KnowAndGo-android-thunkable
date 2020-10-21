package com.bugsnag.android;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.FileStore;
import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;

class SessionStore extends FileStore<Session> {
    static final Comparator<File> SESSION_COMPARATOR = new Comparator<File>() {
        public int compare(File file, File file2) {
            if (file == null && file2 == null) {
                return 0;
            }
            if (file == null) {
                return 1;
            }
            if (file2 == null) {
                return -1;
            }
            return file.getName().compareTo(file2.getName());
        }
    };

    SessionStore(@NonNull Configuration configuration, @NonNull Context context, @Nullable FileStore.Delegate delegate) {
        super(configuration, context, "/bugsnag-sessions/", 128, SESSION_COMPARATOR, delegate);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public String getFilename(Object obj) {
        return String.format(Locale.US, "%s%s%d.json", new Object[]{this.storeDirectory, UUID.randomUUID().toString(), Long.valueOf(System.currentTimeMillis())});
    }
}
