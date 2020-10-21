package com.imagepicker.media;

import android.webkit.MimeTypeMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ViewProps;
import java.io.File;

public class ImageConfig {
    public final int maxHeight;
    public final int maxWidth;
    @Nullable
    public final File original;
    public final int quality;
    @Nullable
    public final File resized;
    public final int rotation;
    public final boolean saveToCameraRoll;

    public ImageConfig(@Nullable File file, @Nullable File file2, int i, int i2, int i3, int i4, boolean z) {
        this.original = file;
        this.resized = file2;
        this.maxWidth = i;
        this.maxHeight = i2;
        this.quality = i3;
        this.rotation = i4;
        this.saveToCameraRoll = z;
    }

    @NonNull
    public ImageConfig withMaxWidth(int i) {
        return new ImageConfig(this.original, this.resized, i, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withMaxHeight(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, i, this.quality, this.rotation, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withQuality(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, i, this.rotation, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withRotation(int i) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, this.quality, i, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withOriginalFile(@Nullable File file) {
        if (file != null) {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(file.getAbsolutePath());
            int i = this.quality;
            boolean contains = fileExtensionFromUrl.contains("gif");
        }
        return new ImageConfig(file, this.resized, this.maxWidth, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withResizedFile(@Nullable File file) {
        return new ImageConfig(this.original, file, this.maxWidth, this.maxHeight, this.quality, this.rotation, this.saveToCameraRoll);
    }

    @NonNull
    public ImageConfig withSaveToCameraRoll(@Nullable boolean z) {
        return new ImageConfig(this.original, this.resized, this.maxWidth, this.maxHeight, this.quality, this.rotation, z);
    }

    @NonNull
    public ImageConfig updateFromOptions(@NonNull ReadableMap readableMap) {
        boolean z;
        int i = readableMap.hasKey(ViewProps.MAX_WIDTH) ? (int) readableMap.getDouble(ViewProps.MAX_WIDTH) : 0;
        int i2 = readableMap.hasKey(ViewProps.MAX_HEIGHT) ? (int) readableMap.getDouble(ViewProps.MAX_HEIGHT) : 0;
        int i3 = readableMap.hasKey("quality") ? (int) (readableMap.getDouble("quality") * 100.0d) : 100;
        int i4 = readableMap.hasKey(ViewProps.ROTATION) ? (int) readableMap.getDouble(ViewProps.ROTATION) : 0;
        if (readableMap.hasKey("storageOptions")) {
            ReadableMap map = readableMap.getMap("storageOptions");
            if (map.hasKey("cameraRoll")) {
                z = map.getBoolean("cameraRoll");
                return new ImageConfig(this.original, this.resized, i, i2, i3, i4, z);
            }
        }
        z = false;
        return new ImageConfig(this.original, this.resized, i, i2, i3, i4, z);
    }

    public boolean useOriginal(int i, int i2, int i3) {
        return ((i < this.maxWidth && this.maxWidth > 0) || this.maxWidth == 0) && ((i2 < this.maxHeight && this.maxHeight > 0) || this.maxHeight == 0) && this.quality == 100 && (this.rotation == 0 || i3 == this.rotation);
    }

    public File getActualFile() {
        return this.resized != null ? this.resized : this.original;
    }
}
