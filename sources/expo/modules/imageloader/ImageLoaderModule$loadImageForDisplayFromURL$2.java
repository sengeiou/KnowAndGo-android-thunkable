package expo.modules.imageloader;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.unimodules.interfaces.imageloader.ImageLoader;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\b\u0001\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0014J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, mo39786d2 = {"expo/modules/imageloader/ImageLoaderModule$loadImageForDisplayFromURL$2", "Lcom/facebook/imagepipeline/datasource/BaseBitmapDataSubscriber;", "onFailureImpl", "", "dataSource", "Lcom/facebook/datasource/DataSource;", "Lcom/facebook/common/references/CloseableReference;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "onNewResultImpl", "bitmap", "Landroid/graphics/Bitmap;", "expo-image-loader_release"}, mo39787k = 1, mo39788mv = {1, 1, 15})
/* compiled from: ImageLoaderModule.kt */
public final class ImageLoaderModule$loadImageForDisplayFromURL$2 extends BaseBitmapDataSubscriber {
    final /* synthetic */ ImageLoader.ResultListener $resultListener;

    ImageLoaderModule$loadImageForDisplayFromURL$2(ImageLoader.ResultListener resultListener) {
        this.$resultListener = resultListener;
    }

    /* access modifiers changed from: protected */
    public void onNewResultImpl(@Nullable Bitmap bitmap) {
        if (bitmap != null) {
            this.$resultListener.onSuccess(bitmap);
        } else {
            this.$resultListener.onFailure(new Exception("Loaded bitmap is null"));
        }
    }

    /* access modifiers changed from: protected */
    public void onFailureImpl(@NotNull @NonNull DataSource<CloseableReference<CloseableImage>> dataSource) {
        Intrinsics.checkParameterIsNotNull(dataSource, "dataSource");
        this.$resultListener.onFailure(dataSource.getFailureCause());
    }
}
