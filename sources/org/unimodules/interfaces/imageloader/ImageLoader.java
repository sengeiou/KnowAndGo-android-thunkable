package org.unimodules.interfaces.imageloader;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.Future;

public interface ImageLoader {

    public interface ResultListener {
        void onFailure(@Nullable Throwable th);

        void onSuccess(@NonNull Bitmap bitmap);
    }

    Future<Bitmap> loadImageForDisplayFromURL(@NonNull String str);

    void loadImageForDisplayFromURL(@NonNull String str, ResultListener resultListener);

    Future<Bitmap> loadImageForManipulationFromURL(@NonNull String str);

    void loadImageForManipulationFromURL(@NonNull String str, ResultListener resultListener);
}
