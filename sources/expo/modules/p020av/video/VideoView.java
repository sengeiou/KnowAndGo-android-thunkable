package expo.modules.p020av.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.yqritc.scalablevideoview.ScalableType;
import expo.modules.p020av.AVManagerInterface;
import expo.modules.p020av.AudioEventHandler;
import expo.modules.p020av.player.PlayerData;
import expo.modules.p020av.player.PlayerDataControl;
import expo.modules.p020av.video.VideoViewManager;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.arguments.ReadableArguments;
import org.unimodules.core.interfaces.services.EventEmitter;

@SuppressLint({"ViewConstructor"})
/* renamed from: expo.modules.av.video.VideoView */
public class VideoView extends FrameLayout implements AudioEventHandler, FullscreenVideoPlayerPresentationChangeListener, PlayerData.FullscreenPresenter {
    private final AVManagerInterface mAVModule;
    /* access modifiers changed from: private */
    public EventEmitter mEventEmitter;
    private FullscreenVideoPlayer mFullscreenPlayer = null;
    private FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenPlayerPresentationChangeProgressListener = null;
    /* access modifiers changed from: private */
    public FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
    /* access modifiers changed from: private */
    public boolean mIsLoaded = false;
    /* access modifiers changed from: private */
    public MediaController mMediaController = null;
    /* access modifiers changed from: private */
    public final Runnable mMediaControllerUpdater = new Runnable() {
        public void run() {
            if (VideoView.this.mMediaController != null) {
                VideoView.this.mMediaController.updateControls();
            }
        }
    };
    private Boolean mOverridingUseNativeControls = null;
    /* access modifiers changed from: private */
    public PlayerData mPlayerData = null;
    /* access modifiers changed from: private */
    public ScalableType mResizeMode = ScalableType.LEFT_TOP;
    /* access modifiers changed from: private */
    public boolean mShouldShowFullscreenPlayerOnLoad = false;
    private Bundle mStatusToSet = new Bundle();
    /* access modifiers changed from: private */
    public final PlayerData.StatusUpdateListener mStatusUpdateListener = new PlayerData.StatusUpdateListener() {
        public void onStatusUpdate(Bundle bundle) {
            VideoView.this.post(VideoView.this.mMediaControllerUpdater);
            VideoView.this.mEventEmitter.emit(VideoView.this.getReactId(), VideoViewManager.Events.EVENT_STATUS_UPDATE.toString(), bundle);
        }
    };
    private boolean mUseNativeControls = false;
    /* access modifiers changed from: private */
    public VideoTextureView mVideoTextureView = null;
    private VideoViewWrapper mVideoViewWrapper;
    /* access modifiers changed from: private */
    public Pair<Integer, Integer> mVideoWidthHeight = null;

    public VideoView(@NonNull Context context, VideoViewWrapper videoViewWrapper, ModuleRegistry moduleRegistry) {
        super(context);
        this.mVideoViewWrapper = videoViewWrapper;
        this.mEventEmitter = (EventEmitter) moduleRegistry.getModule(EventEmitter.class);
        this.mAVModule = (AVManagerInterface) moduleRegistry.getModule(AVManagerInterface.class);
        this.mAVModule.registerVideoViewForAudioLifecycle(this);
        this.mVideoTextureView = new VideoTextureView(context, this);
        addView(this.mVideoTextureView, generateDefaultLayoutParams());
        this.mFullscreenPlayer = new FullscreenVideoPlayer(context, this, moduleRegistry);
        this.mFullscreenPlayer.setUpdateListener(this);
        this.mMediaController = new MediaController(getContext());
        this.mMediaController.setAnchorView(this);
        maybeUpdateMediaControllerForUseNativeControls();
    }

    public void unloadPlayerAndMediaController() {
        ensureFullscreenPlayerIsDismissed();
        if (this.mMediaController != null) {
            this.mMediaController.hide();
            this.mMediaController.setEnabled(false);
            this.mMediaController.setAnchorView((ViewGroup) null);
            this.mMediaController = null;
        }
        if (this.mPlayerData != null) {
            this.mPlayerData.release();
            this.mPlayerData = null;
        }
        this.mIsLoaded = false;
    }

    /* access modifiers changed from: package-private */
    public void onDropViewInstance() {
        this.mAVModule.unregisterVideoViewForAudioLifecycle(this);
        unloadPlayerAndMediaController();
    }

    /* access modifiers changed from: private */
    public void callOnError(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("error", str);
        this.mEventEmitter.emit(getReactId(), VideoViewManager.Events.EVENT_ERROR.toString(), bundle);
    }

    /* access modifiers changed from: private */
    public void callOnReadyForDisplay(Pair<Integer, Integer> pair) {
        if (pair != null && this.mIsLoaded) {
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            if (intValue != 0 && intValue2 != 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("width", intValue);
                bundle.putInt("height", intValue2);
                bundle.putString("orientation", intValue > intValue2 ? "landscape" : "portrait");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("naturalSize", bundle);
                bundle2.putBundle("status", this.mPlayerData.getStatus());
                this.mEventEmitter.emit(getReactId(), VideoViewManager.Events.EVENT_READY_FOR_DISPLAY.toString(), bundle2);
            }
        }
    }

    public void maybeUpdateMediaControllerForUseNativeControls() {
        maybeUpdateMediaControllerForUseNativeControls(true);
    }

    public void maybeUpdateMediaControllerForUseNativeControls(boolean z) {
        if (this.mPlayerData != null && this.mMediaController != null) {
            this.mMediaController.updateControls();
            this.mMediaController.setEnabled(shouldUseNativeControls());
            if (!shouldUseNativeControls() || !z) {
                this.mMediaController.hide();
            } else {
                this.mMediaController.show();
            }
        }
    }

    public void ensureFullscreenPlayerIsPresented() {
        ensureFullscreenPlayerIsPresented((FullscreenVideoPlayerPresentationChangeProgressListener) null);
    }

    public void ensureFullscreenPlayerIsPresented(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(true, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else if (!isBeingPresentedFullscreen()) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
            }
            this.mFullscreenPlayer.show();
        } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
        }
    }

    public void ensureFullscreenPlayerIsDismissed() {
        ensureFullscreenPlayerIsDismissed((FullscreenVideoPlayerPresentationChangeProgressListener) null);
    }

    public void ensureFullscreenPlayerIsDismissed(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(false, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else if (isBeingPresentedFullscreen()) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
            }
            this.mFullscreenPlayer.dismiss();
        } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
        }
    }

    private void saveFullscreenPlayerStateForOnLoad(boolean z, FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        this.mShouldShowFullscreenPlayerOnLoad = z;
        if (this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
            this.mFullscreenVideoPlayerPresentationOnLoadChangeListener.onFullscreenPlayerPresentationInterrupted();
        }
        this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = fullscreenVideoPlayerPresentationChangeProgressListener;
    }

    public void onFullscreenPlayerWillPresent() {
        callFullscreenCallbackWithUpdate(VideoViewManager.FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_PRESENT);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerWillPresent();
        }
    }

    public void onFullscreenPlayerDidPresent() {
        this.mMediaController.updateControls();
        callFullscreenCallbackWithUpdate(VideoViewManager.FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_PRESENT);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    public void onFullscreenPlayerWillDismiss() {
        callFullscreenCallbackWithUpdate(VideoViewManager.FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_DISMISS);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerWillDismiss();
        }
    }

    public void onFullscreenPlayerDidDismiss() {
        this.mMediaController.updateControls();
        callFullscreenCallbackWithUpdate(VideoViewManager.FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_DISMISS);
        if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            this.mFullscreenPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    private void callFullscreenCallbackWithUpdate(VideoViewManager.FullscreenPlayerUpdate fullscreenPlayerUpdate) {
        Bundle bundle = new Bundle();
        bundle.putInt("fullscreenUpdate", fullscreenPlayerUpdate.getValue());
        bundle.putBundle("status", getStatus());
        this.mEventEmitter.emit(getReactId(), VideoViewManager.Events.EVENT_FULLSCREEN_PLAYER_UPDATE.toString(), bundle);
    }

    public void setStatus(ReadableArguments readableArguments, Promise promise) {
        Bundle bundle = readableArguments.toBundle();
        this.mStatusToSet.putAll(bundle);
        if (this.mPlayerData != null) {
            new Bundle().putAll(this.mStatusToSet);
            this.mStatusToSet = new Bundle();
            this.mPlayerData.setStatus(bundle, promise);
        } else if (promise != null) {
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    public Bundle getStatus() {
        return this.mPlayerData == null ? PlayerData.getUnloadedStatus() : this.mPlayerData.getStatus();
    }

    private boolean shouldUseNativeControls() {
        if (this.mOverridingUseNativeControls != null) {
            return this.mOverridingUseNativeControls.booleanValue();
        }
        return this.mUseNativeControls;
    }

    /* access modifiers changed from: package-private */
    public void setOverridingUseNativeControls(Boolean bool) {
        this.mOverridingUseNativeControls = bool;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    /* access modifiers changed from: package-private */
    public void setUseNativeControls(boolean z) {
        this.mUseNativeControls = z;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    public void setSource(ReadableArguments readableArguments, ReadableArguments readableArguments2, final Promise promise) {
        String str = null;
        if (this.mPlayerData != null) {
            this.mStatusToSet.putAll(this.mPlayerData.getStatus());
            this.mPlayerData.release();
            this.mPlayerData = null;
            this.mIsLoaded = false;
        }
        if (readableArguments2 != null) {
            this.mStatusToSet.putAll(readableArguments2.toBundle());
        }
        if (readableArguments != null) {
            str = readableArguments.getString("uri");
        }
        if (str != null) {
            this.mEventEmitter.emit(getReactId(), VideoViewManager.Events.EVENT_LOAD_START.toString(), new Bundle());
            Bundle bundle = new Bundle();
            bundle.putAll(this.mStatusToSet);
            this.mStatusToSet = new Bundle();
            this.mPlayerData = PlayerData.createUnloadedPlayerData(this.mAVModule, getContext(), readableArguments, bundle);
            this.mPlayerData.setErrorListener(new PlayerData.ErrorListener() {
                public void onError(String str) {
                    VideoView.this.unloadPlayerAndMediaController();
                    VideoView.this.callOnError(str);
                }
            });
            this.mPlayerData.setVideoSizeUpdateListener(new PlayerData.VideoSizeUpdateListener() {
                public void onVideoSizeUpdate(Pair<Integer, Integer> pair) {
                    VideoView.this.mVideoTextureView.scaleVideoSize(pair, VideoView.this.mResizeMode);
                    Pair unused = VideoView.this.mVideoWidthHeight = pair;
                    VideoView.this.callOnReadyForDisplay(pair);
                }
            });
            this.mPlayerData.setFullscreenPresenter(this);
            this.mPlayerData.load(bundle, new PlayerData.LoadCompletionListener() {
                public void onLoadSuccess(Bundle bundle) {
                    boolean unused = VideoView.this.mIsLoaded = true;
                    VideoView.this.mVideoTextureView.scaleVideoSize(VideoView.this.mPlayerData.getVideoWidthHeight(), VideoView.this.mResizeMode);
                    if (VideoView.this.mVideoTextureView.isAttachedToWindow()) {
                        VideoView.this.mPlayerData.tryUpdateVideoSurface(VideoView.this.mVideoTextureView.getSurface());
                    }
                    if (promise != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putAll(bundle);
                        promise.resolve(bundle2);
                    }
                    VideoView.this.mPlayerData.setStatusUpdateListener(VideoView.this.mStatusUpdateListener);
                    VideoView.this.mMediaController.setMediaPlayer(new PlayerDataControl(VideoView.this.mPlayerData));
                    VideoView.this.mMediaController.setAnchorView(VideoView.this);
                    VideoView.this.maybeUpdateMediaControllerForUseNativeControls(false);
                    VideoView.this.mEventEmitter.emit(VideoView.this.getReactId(), VideoViewManager.Events.EVENT_LOAD.toString(), bundle);
                    if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                        FullscreenVideoPlayerPresentationChangeProgressListener access$1200 = VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener;
                        FullscreenVideoPlayerPresentationChangeProgressListener unused2 = VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                        if (VideoView.this.mShouldShowFullscreenPlayerOnLoad) {
                            VideoView.this.ensureFullscreenPlayerIsPresented(access$1200);
                        } else {
                            VideoView.this.ensureFullscreenPlayerIsDismissed(access$1200);
                        }
                    }
                    VideoView.this.callOnReadyForDisplay(VideoView.this.mVideoWidthHeight);
                }

                public void onLoadError(String str) {
                    if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                        VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener.onFullscreenPlayerPresentationError(str);
                        FullscreenVideoPlayerPresentationChangeProgressListener unused = VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                    }
                    boolean unused2 = VideoView.this.mShouldShowFullscreenPlayerOnLoad = false;
                    VideoView.this.unloadPlayerAndMediaController();
                    if (promise != null) {
                        promise.reject("E_VIDEO_NOTCREATED", str);
                    }
                    VideoView.this.callOnError(str);
                }
            });
        } else if (promise != null) {
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    /* access modifiers changed from: package-private */
    public void setResizeMode(ScalableType scalableType) {
        this.mResizeMode = scalableType;
        if (this.mPlayerData != null) {
            this.mVideoTextureView.scaleVideoSize(this.mPlayerData.getVideoWidthHeight(), this.mResizeMode);
        }
    }

    /* access modifiers changed from: private */
    public int getReactId() {
        return this.mVideoViewWrapper.getId();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (shouldUseNativeControls() && this.mMediaController != null) {
            this.mMediaController.show();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"DrawAllocation"})
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && this.mPlayerData != null) {
            this.mVideoTextureView.scaleVideoSize(this.mPlayerData.getVideoWidthHeight(), this.mResizeMode);
        }
    }

    public void tryUpdateVideoSurface(Surface surface) {
        if (this.mPlayerData != null) {
            this.mPlayerData.tryUpdateVideoSurface(surface);
        }
    }

    public void pauseImmediately() {
        if (this.mPlayerData != null) {
            this.mPlayerData.pauseImmediately();
        }
    }

    public boolean requiresAudioFocus() {
        return this.mPlayerData != null && this.mPlayerData.requiresAudioFocus();
    }

    public void updateVolumeMuteAndDuck() {
        if (this.mPlayerData != null) {
            this.mPlayerData.updateVolumeMuteAndDuck();
        }
    }

    public void handleAudioFocusInterruptionBegan() {
        if (this.mPlayerData != null) {
            this.mPlayerData.handleAudioFocusInterruptionBegan();
        }
    }

    public void handleAudioFocusGained() {
        if (this.mPlayerData != null) {
            this.mPlayerData.handleAudioFocusGained();
        }
    }

    public void onPause() {
        if (this.mPlayerData != null) {
            ensureFullscreenPlayerIsDismissed();
            this.mPlayerData.onPause();
        }
    }

    public void onResume() {
        if (this.mPlayerData != null) {
            this.mPlayerData.onResume();
        }
    }

    public boolean isBeingPresentedFullscreen() {
        return this.mFullscreenPlayer.isShowing();
    }

    public void setFullscreenMode(boolean z) {
        if (z) {
            ensureFullscreenPlayerIsPresented();
        } else {
            ensureFullscreenPlayerIsDismissed();
        }
    }
}
