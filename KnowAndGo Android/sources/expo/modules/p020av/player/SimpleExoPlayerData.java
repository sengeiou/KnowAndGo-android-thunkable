package expo.modules.p020av.player;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.AdaptiveMediaSourceEventListener;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.dash.DashChunkSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import expo.modules.p020av.AVManagerInterface;
import expo.modules.p020av.AudioFocusNotAcquiredException;
import expo.modules.p020av.player.PlayerData;
import expo.modules.p020av.player.datasource.DataSourceFactoryProvider;
import java.io.IOException;
import java.util.Map;
import org.unimodules.core.Promise;

/* renamed from: expo.modules.av.player.SimpleExoPlayerData */
class SimpleExoPlayerData extends PlayerData implements Player.EventListener, ExtractorMediaSource.EventListener, SimpleExoPlayer.VideoListener, AdaptiveMediaSourceEventListener {
    private static final String IMPLEMENTATION_NAME = "SimpleExoPlayer";
    private boolean mFirstFrameRendered = false;
    private boolean mIsLoading = true;
    private boolean mIsLooping = false;
    private Integer mLastPlaybackState = null;
    private PlayerData.LoadCompletionListener mLoadCompletionListener = null;
    private String mOverridingExtension;
    private Context mReactContext;
    private SimpleExoPlayer mSimpleExoPlayer = null;
    private Pair<Integer, Integer> mVideoWidthHeight = null;

    /* access modifiers changed from: package-private */
    public String getImplementationName() {
        return IMPLEMENTATION_NAME;
    }

    public void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData, IOException iOException, boolean z) {
    }

    public void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.LoadEventInfo loadEventInfo, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    public void onMediaPeriodCreated(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    public void onMediaPeriodReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    public void onReadingStarted(int i, MediaSource.MediaPeriodId mediaPeriodId) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
        VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
    }

    public /* synthetic */ void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i) {
        Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    public void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaSourceEventListener.MediaLoadData mediaLoadData) {
    }

    SimpleExoPlayerData(AVManagerInterface aVManagerInterface, Context context, Uri uri, String str, Map<String, Object> map) {
        super(aVManagerInterface, uri, map);
        this.mReactContext = context;
        this.mOverridingExtension = str;
    }

    public void load(Bundle bundle, PlayerData.LoadCompletionListener loadCompletionListener) {
        this.mLoadCompletionListener = loadCompletionListener;
        Handler handler = new Handler();
        DefaultBandwidthMeter defaultBandwidthMeter = new DefaultBandwidthMeter();
        this.mSimpleExoPlayer = ExoPlayerFactory.newSimpleInstance(this.mAVModule.getContext(), (RenderersFactory) new DefaultRenderersFactory(this.mAVModule.getContext()), (TrackSelector) new DefaultTrackSelector((TrackSelection.Factory) new AdaptiveTrackSelection.Factory()), (LoadControl) new DefaultLoadControl(), (DrmSessionManager<FrameworkMediaCrypto>) null, (BandwidthMeter) defaultBandwidthMeter);
        this.mSimpleExoPlayer.addListener(this);
        this.mSimpleExoPlayer.addVideoListener(this);
        try {
            this.mSimpleExoPlayer.prepare(buildMediaSource(this.mUri, this.mOverridingExtension, handler, ((DataSourceFactoryProvider) this.mAVModule.getModuleRegistry().getModule(DataSourceFactoryProvider.class)).createFactory(this.mReactContext, this.mAVModule.getModuleRegistry(), Util.getUserAgent(this.mAVModule.getContext(), "yourApplicationName"), this.mRequestHeaders, defaultBandwidthMeter.getTransferListener())));
            setStatus(bundle, (Promise) null);
        } catch (IllegalStateException e) {
            onFatalError(e);
        }
    }

    public synchronized void release() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.release();
            this.mSimpleExoPlayer = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldContinueUpdatingProgress() {
        return this.mSimpleExoPlayer != null && this.mSimpleExoPlayer.getPlayWhenReady();
    }

    /* access modifiers changed from: package-private */
    public void playPlayerWithRateAndMuteIfNecessary() throws AudioFocusNotAcquiredException {
        if (this.mSimpleExoPlayer != null && shouldPlayerPlay()) {
            if (!this.mIsMuted) {
                this.mAVModule.acquireAudioFocus();
            }
            updateVolumeMuteAndDuck();
            this.mSimpleExoPlayer.setPlaybackParameters(new PlaybackParameters(this.mRate, this.mShouldCorrectPitch ? 1.0f : this.mRate));
            this.mSimpleExoPlayer.setPlayWhenReady(this.mShouldPlay);
            beginUpdatingProgressIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public void applyNewStatus(Integer num, Boolean bool) throws AudioFocusNotAcquiredException, IllegalStateException {
        if (this.mSimpleExoPlayer != null) {
            if (bool != null) {
                this.mIsLooping = bool.booleanValue();
                if (this.mIsLooping) {
                    this.mSimpleExoPlayer.setRepeatMode(2);
                } else {
                    this.mSimpleExoPlayer.setRepeatMode(0);
                }
            }
            if (!shouldPlayerPlay()) {
                this.mSimpleExoPlayer.setPlayWhenReady(false);
                stopUpdatingProgressIfNecessary();
            }
            updateVolumeMuteAndDuck();
            if (num != null) {
                this.mSimpleExoPlayer.seekTo((long) num.intValue());
            }
            playPlayerWithRateAndMuteIfNecessary();
            return;
        }
        throw new IllegalStateException("mSimpleExoPlayer is null!");
    }

    /* access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.mSimpleExoPlayer != null;
    }

    /* access modifiers changed from: package-private */
    public void getExtraStatusFields(Bundle bundle) {
        int duration = (int) this.mSimpleExoPlayer.getDuration();
        bundle.putInt("durationMillis", duration);
        bundle.putInt("positionMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.getCurrentPosition()), 0, Integer.valueOf(duration)));
        bundle.putInt("playableDurationMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.getBufferedPosition()), 0, Integer.valueOf(duration)));
        boolean z = true;
        bundle.putBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH, this.mSimpleExoPlayer.getPlayWhenReady() && this.mSimpleExoPlayer.getPlaybackState() == 3);
        if (!this.mIsLoading && this.mSimpleExoPlayer.getPlaybackState() != 2) {
            z = false;
        }
        bundle.putBoolean("isBuffering", z);
        bundle.putBoolean("isLooping", this.mIsLooping);
    }

    public Pair<Integer, Integer> getVideoWidthHeight() {
        return this.mVideoWidthHeight != null ? this.mVideoWidthHeight : new Pair<>(0, 0);
    }

    public void tryUpdateVideoSurface(Surface surface) {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.setVideoSurface(surface);
        }
    }

    public int getAudioSessionId() {
        if (this.mSimpleExoPlayer != null) {
            return this.mSimpleExoPlayer.getAudioSessionId();
        }
        return 0;
    }

    public void pauseImmediately() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.setPlayWhenReady(false);
        }
        stopUpdatingProgressIfNecessary();
    }

    public boolean requiresAudioFocus() {
        return this.mSimpleExoPlayer != null && (this.mSimpleExoPlayer.getPlayWhenReady() || shouldPlayerPlay()) && !this.mIsMuted;
    }

    public void updateVolumeMuteAndDuck() {
        if (this.mSimpleExoPlayer != null) {
            this.mSimpleExoPlayer.setVolume(this.mAVModule.getVolumeForDuckAndFocus(this.mIsMuted, this.mVolume));
        }
    }

    public void onLoadingChanged(boolean z) {
        this.mIsLoading = z;
        callStatusUpdateListener();
    }

    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 3 && this.mLoadCompletionListener != null) {
            PlayerData.LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadSuccess(getStatus());
        }
        if (this.mLastPlaybackState == null || i == this.mLastPlaybackState.intValue() || i != 4) {
            callStatusUpdateListener();
        } else {
            callStatusUpdateListenerWithDidJustFinish();
        }
        this.mLastPlaybackState = Integer.valueOf(i);
    }

    public void onPlayerError(ExoPlaybackException exoPlaybackException) {
        onFatalError(exoPlaybackException.getCause());
    }

    public void onPositionDiscontinuity(int i) {
        if (i == 0) {
            callStatusUpdateListenerWithDidJustFinish();
        }
    }

    public void onLoadError(IOException iOException) {
        if (this.mLoadCompletionListener != null) {
            PlayerData.LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadError(iOException.toString());
        }
    }

    private void onFatalError(Throwable th) {
        if (this.mLoadCompletionListener != null) {
            PlayerData.LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadError(th.toString());
        } else {
            PlayerData.ErrorListener errorListener = this.mErrorListener;
            errorListener.onError("Player error: " + th.getMessage());
        }
        release();
    }

    public void onVideoSizeChanged(int i, int i2, int i3, float f) {
        this.mVideoWidthHeight = new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        if (this.mFirstFrameRendered && this.mVideoSizeUpdateListener != null) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
    }

    public void onRenderedFirstFrame() {
        if (!(this.mFirstFrameRendered || this.mVideoWidthHeight == null || this.mVideoSizeUpdateListener == null)) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
        this.mFirstFrameRendered = true;
    }

    private MediaSource buildMediaSource(Uri uri, String str, Handler handler, DataSource.Factory factory) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = String.valueOf(uri);
        } else {
            str2 = "." + str;
        }
        int inferContentType = Util.inferContentType(str2);
        switch (inferContentType) {
            case 0:
                return new DashMediaSource(uri, factory, (DashChunkSource.Factory) new DefaultDashChunkSource.Factory(factory), handler, (MediaSourceEventListener) this);
            case 1:
                return new SsMediaSource(uri, factory, (SsChunkSource.Factory) new DefaultSsChunkSource.Factory(factory), handler, (MediaSourceEventListener) this);
            case 2:
                return new HlsMediaSource(uri, factory, handler, this);
            case 3:
                return new ExtractorMediaSource(uri, factory, new DefaultExtractorsFactory(), handler, this);
            default:
                throw new IllegalStateException("Content of this type is unsupported at the moment. Unsupported type: " + inferContentType);
        }
    }
}
