package expo.modules.imageloader;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.unimodules.interfaces.imageloader.ImageLoader;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo39786d2 = {"expo/modules/imageloader/ImageLoaderModule$loadImageForDisplayFromURL$1", "Lorg/unimodules/interfaces/imageloader/ImageLoader$ResultListener;", "onFailure", "", "cause", "", "onSuccess", "bitmap", "Landroid/graphics/Bitmap;", "expo-image-loader_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ImageLoaderModule.kt */
public final class ImageLoaderModule$loadImageForDisplayFromURL$1 implements ImageLoader.ResultListener {
    final /* synthetic */ SimpleSettableFuture $future;

    ImageLoaderModule$loadImageForDisplayFromURL$1(SimpleSettableFuture simpleSettableFuture) {
        this.$future = simpleSettableFuture;
    }

    public void onSuccess(@NotNull Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "bitmap");
        this.$future.set(bitmap);
    }

    public void onFailure(@Nullable @androidx.annotation.Nullable Throwable th) {
        this.$future.setException(new ExecutionException(th));
    }
}
