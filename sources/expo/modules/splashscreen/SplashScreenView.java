package expo.modules.splashscreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo39786d2 = {"Lexpo/modules/splashscreen/SplashScreenView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "resizeMode", "Lexpo/modules/splashscreen/SplashScreenImageResizeMode;", "splashScreenResourcesProvider", "Lexpo/modules/splashscreen/SplashScreenResourcesProvider;", "(Landroid/content/Context;Lexpo/modules/splashscreen/SplashScreenImageResizeMode;Lexpo/modules/splashscreen/SplashScreenResourcesProvider;)V", "imageView", "Landroid/widget/ImageView;", "expo-splash-screen_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
@SuppressLint({"ViewConstructor"})
/* compiled from: SplashScreenView.kt */
public final class SplashScreenView extends RelativeLayout {
    private final ImageView imageView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashScreenView(@NotNull Context context, @NotNull SplashScreenImageResizeMode splashScreenImageResizeMode, @NotNull SplashScreenResourcesProvider splashScreenResourcesProvider) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(splashScreenImageResizeMode, ViewProps.RESIZE_MODE);
        Intrinsics.checkParameterIsNotNull(splashScreenResourcesProvider, "splashScreenResourcesProvider");
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.imageView = imageView2;
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setBackgroundColor(splashScreenResourcesProvider.getBackgroundColor(context));
        addView(this.imageView);
        this.imageView.setImageResource(splashScreenResourcesProvider.getImageResource(context));
        this.imageView.setScaleType(splashScreenImageResizeMode.getScaleType());
        switch (splashScreenImageResizeMode) {
            case CONTAIN:
                this.imageView.setAdjustViewBounds(true);
                return;
            default:
                return;
        }
    }
}
