package expo.modules.p020av.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import org.unimodules.core.ModuleRegistry;

@SuppressLint({"ViewConstructor"})
/* renamed from: expo.modules.av.video.VideoViewWrapper */
public class VideoViewWrapper extends FrameLayout {
    private final Runnable mLayoutRunnable = new Runnable() {
        public void run() {
            VideoViewWrapper.this.measure(View.MeasureSpec.makeMeasureSpec(VideoViewWrapper.this.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(VideoViewWrapper.this.getHeight(), 1073741824));
            VideoViewWrapper.this.layout(VideoViewWrapper.this.getLeft(), VideoViewWrapper.this.getTop(), VideoViewWrapper.this.getRight(), VideoViewWrapper.this.getBottom());
        }
    };
    private VideoView mVideoView = null;

    public VideoViewWrapper(@NonNull Context context, ModuleRegistry moduleRegistry) {
        super(context);
        this.mVideoView = new VideoView(context, this, moduleRegistry);
        addView(this.mVideoView, generateDefaultLayoutParams());
    }

    public VideoView getVideoViewInstance() {
        return this.mVideoView;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.mLayoutRunnable);
    }
}
