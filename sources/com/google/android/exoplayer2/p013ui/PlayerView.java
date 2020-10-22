package com.google.android.exoplayer2.p013ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.p013ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.p013ui.PlayerControlView;
import com.google.android.exoplayer2.p013ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.p013ui.spherical.SphericalSurfaceView;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.ui.PlayerView */
public class PlayerView extends FrameLayout {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private static final int SURFACE_TYPE_MONO360_VIEW = 3;
    private static final int SURFACE_TYPE_NONE = 0;
    private static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    private static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    private final ImageView artworkView;
    @Nullable
    private final View bufferingView;
    private final ComponentListener componentListener;
    /* access modifiers changed from: private */
    public final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    /* access modifiers changed from: private */
    public boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    @Nullable
    private CharSequence customErrorMessage;
    @Nullable
    private Drawable defaultArtwork;
    @Nullable
    private ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider;
    @Nullable
    private final TextView errorMessageView;
    private boolean keepContentOnPlayerReset;
    private final FrameLayout overlayFrameLayout;
    /* access modifiers changed from: private */
    public Player player;
    private int showBuffering;
    /* access modifiers changed from: private */
    public final View shutterView;
    /* access modifiers changed from: private */
    public final SubtitleView subtitleView;
    /* access modifiers changed from: private */
    public final View surfaceView;
    /* access modifiers changed from: private */
    public int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.android.exoplayer2.ui.PlayerView$ShowBuffering */
    public @interface ShowBuffering {
    }

    @SuppressLint({"InlinedApi"})
    private boolean isDpadKey(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public PlayerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        int i2;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        int i7;
        boolean z6;
        boolean z7;
        Context context2 = context;
        AttributeSet attributeSet2 = attributeSet;
        if (isInEditMode()) {
            this.contentFrame = null;
            this.shutterView = null;
            this.surfaceView = null;
            this.artworkView = null;
            this.subtitleView = null;
            this.bufferingView = null;
            this.errorMessageView = null;
            this.controller = null;
            this.componentListener = null;
            this.overlayFrameLayout = null;
            ImageView imageView = new ImageView(context2);
            if (Util.SDK_INT >= 23) {
                configureEditModeLogoV23(getResources(), imageView);
            } else {
                configureEditModeLogo(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = C1581R.layout.exo_player_view;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C1581R.styleable.PlayerView, 0, 0);
            try {
                z4 = obtainStyledAttributes.hasValue(C1581R.styleable.PlayerView_shutter_background_color);
                i5 = obtainStyledAttributes.getColor(C1581R.styleable.PlayerView_shutter_background_color, 0);
                int resourceId = obtainStyledAttributes.getResourceId(C1581R.styleable.PlayerView_player_layout_id, i8);
                z3 = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_use_artwork, true);
                i4 = obtainStyledAttributes.getResourceId(C1581R.styleable.PlayerView_default_artwork, 0);
                boolean z8 = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_use_controller, true);
                i3 = obtainStyledAttributes.getInt(C1581R.styleable.PlayerView_surface_type, 1);
                i2 = obtainStyledAttributes.getInt(C1581R.styleable.PlayerView_resize_mode, 0);
                int i9 = obtainStyledAttributes.getInt(C1581R.styleable.PlayerView_show_timeout, 5000);
                boolean z9 = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_hide_on_touch, true);
                boolean z10 = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_auto_show, true);
                int i10 = resourceId;
                i7 = obtainStyledAttributes.getInteger(C1581R.styleable.PlayerView_show_buffering, 0);
                boolean z11 = z9;
                this.keepContentOnPlayerReset = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_keep_content_on_player_reset, this.keepContentOnPlayerReset);
                boolean z12 = obtainStyledAttributes.getBoolean(C1581R.styleable.PlayerView_hide_during_ads, true);
                obtainStyledAttributes.recycle();
                z5 = z10;
                z = z8;
                z2 = z12;
                i6 = i9;
                i8 = i10;
                z6 = z11;
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z6 = true;
            i7 = 0;
            i6 = 5000;
            z5 = true;
            z4 = false;
            i5 = 0;
            z3 = true;
            i4 = 0;
            z2 = true;
            i3 = 1;
            i2 = 0;
            z = true;
        }
        LayoutInflater.from(context).inflate(i8, this);
        this.componentListener = new ComponentListener();
        setDescendantFocusability(262144);
        this.contentFrame = (AspectRatioFrameLayout) findViewById(C1581R.C1584id.exo_content_frame);
        if (this.contentFrame != null) {
            setResizeModeRaw(this.contentFrame, i2);
        }
        this.shutterView = findViewById(C1581R.C1584id.exo_shutter);
        if (this.shutterView != null && z4) {
            this.shutterView.setBackgroundColor(i5);
        }
        if (this.contentFrame == null || i3 == 0) {
            this.surfaceView = null;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            switch (i3) {
                case 2:
                    this.surfaceView = new TextureView(context2);
                    break;
                case 3:
                    Assertions.checkState(Util.SDK_INT >= 15);
                    SphericalSurfaceView sphericalSurfaceView = new SphericalSurfaceView(context2);
                    sphericalSurfaceView.setSurfaceListener(this.componentListener);
                    sphericalSurfaceView.setSingleTapListener(this.componentListener);
                    this.surfaceView = sphericalSurfaceView;
                    break;
                default:
                    this.surfaceView = new SurfaceView(context2);
                    break;
            }
            this.surfaceView.setLayoutParams(layoutParams);
            this.contentFrame.addView(this.surfaceView, 0);
        }
        this.overlayFrameLayout = (FrameLayout) findViewById(C1581R.C1584id.exo_overlay);
        this.artworkView = (ImageView) findViewById(C1581R.C1584id.exo_artwork);
        this.useArtwork = z3 && this.artworkView != null;
        if (i4 != 0) {
            this.defaultArtwork = ContextCompat.getDrawable(getContext(), i4);
        }
        this.subtitleView = (SubtitleView) findViewById(C1581R.C1584id.exo_subtitles);
        if (this.subtitleView != null) {
            this.subtitleView.setUserDefaultStyle();
            this.subtitleView.setUserDefaultTextSize();
        }
        this.bufferingView = findViewById(C1581R.C1584id.exo_buffering);
        if (this.bufferingView != null) {
            this.bufferingView.setVisibility(8);
        }
        this.showBuffering = i7;
        this.errorMessageView = (TextView) findViewById(C1581R.C1584id.exo_error_message);
        if (this.errorMessageView != null) {
            this.errorMessageView.setVisibility(8);
        }
        PlayerControlView playerControlView = (PlayerControlView) findViewById(C1581R.C1584id.exo_controller);
        View findViewById = findViewById(C1581R.C1584id.exo_controller_placeholder);
        if (playerControlView != null) {
            this.controller = playerControlView;
            z7 = false;
        } else if (findViewById != null) {
            z7 = false;
            this.controller = new PlayerControlView(context2, (AttributeSet) null, 0, attributeSet2);
            this.controller.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(this.controller, indexOfChild);
        } else {
            z7 = false;
            this.controller = null;
        }
        this.controllerShowTimeoutMs = this.controller == null ? 0 : i6;
        this.controllerHideOnTouch = z6;
        this.controllerAutoShow = z5;
        this.controllerHideDuringAds = z2;
        if (z && this.controller != null) {
            z7 = true;
        }
        this.useController = z7;
        hideController();
    }

    public static void switchTargetView(@NonNull Player player2, @Nullable PlayerView playerView, @Nullable PlayerView playerView2) {
        if (playerView != playerView2) {
            if (playerView2 != null) {
                playerView2.setPlayer(player2);
            }
            if (playerView != null) {
                playerView.setPlayer((Player) null);
            }
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(@Nullable Player player2) {
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        Assertions.checkArgument(player2 == null || player2.getApplicationLooper() == Looper.getMainLooper());
        if (this.player != player2) {
            if (this.player != null) {
                this.player.removeListener(this.componentListener);
                Player.VideoComponent videoComponent = this.player.getVideoComponent();
                if (videoComponent != null) {
                    videoComponent.removeVideoListener(this.componentListener);
                    if (this.surfaceView instanceof TextureView) {
                        videoComponent.clearVideoTextureView((TextureView) this.surfaceView);
                    } else if (this.surfaceView instanceof SphericalSurfaceView) {
                        ((SphericalSurfaceView) this.surfaceView).setVideoComponent((Player.VideoComponent) null);
                    } else if (this.surfaceView instanceof SurfaceView) {
                        videoComponent.clearVideoSurfaceView((SurfaceView) this.surfaceView);
                    }
                }
                Player.TextComponent textComponent = this.player.getTextComponent();
                if (textComponent != null) {
                    textComponent.removeTextOutput(this.componentListener);
                }
            }
            this.player = player2;
            if (this.useController) {
                this.controller.setPlayer(player2);
            }
            if (this.subtitleView != null) {
                this.subtitleView.setCues((List<Cue>) null);
            }
            updateBuffering();
            updateErrorMessage();
            updateForCurrentTrackSelections(true);
            if (player2 != null) {
                Player.VideoComponent videoComponent2 = player2.getVideoComponent();
                if (videoComponent2 != null) {
                    if (this.surfaceView instanceof TextureView) {
                        videoComponent2.setVideoTextureView((TextureView) this.surfaceView);
                    } else if (this.surfaceView instanceof SphericalSurfaceView) {
                        ((SphericalSurfaceView) this.surfaceView).setVideoComponent(videoComponent2);
                    } else if (this.surfaceView instanceof SurfaceView) {
                        videoComponent2.setVideoSurfaceView((SurfaceView) this.surfaceView);
                    }
                    videoComponent2.addVideoListener(this.componentListener);
                }
                Player.TextComponent textComponent2 = player2.getTextComponent();
                if (textComponent2 != null) {
                    textComponent2.addTextOutput(this.componentListener);
                }
                player2.addListener(this.componentListener);
                maybeShowController(false);
                return;
            }
            hideController();
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.surfaceView instanceof SurfaceView) {
            this.surfaceView.setVisibility(i);
        }
    }

    public void setResizeMode(int i) {
        Assertions.checkState(this.contentFrame != null);
        this.contentFrame.setResizeMode(i);
    }

    public int getResizeMode() {
        Assertions.checkState(this.contentFrame != null);
        return this.contentFrame.getResizeMode();
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public void setUseArtwork(boolean z) {
        Assertions.checkState(!z || this.artworkView != null);
        if (this.useArtwork != z) {
            this.useArtwork = z;
            updateForCurrentTrackSelections(false);
        }
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    @Deprecated
    public void setDefaultArtwork(@Nullable Bitmap bitmap) {
        BitmapDrawable bitmapDrawable;
        if (bitmap == null) {
            bitmapDrawable = null;
        } else {
            bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        }
        setDefaultArtwork((Drawable) bitmapDrawable);
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.defaultArtwork != drawable) {
            this.defaultArtwork = drawable;
            updateForCurrentTrackSelections(false);
        }
    }

    public boolean getUseController() {
        return this.useController;
    }

    public void setUseController(boolean z) {
        Assertions.checkState(!z || this.controller != null);
        if (this.useController != z) {
            this.useController = z;
            if (z) {
                this.controller.setPlayer(this.player);
            } else if (this.controller != null) {
                this.controller.hide();
                this.controller.setPlayer((Player) null);
            }
        }
    }

    public void setShutterBackgroundColor(int i) {
        if (this.shutterView != null) {
            this.shutterView.setBackgroundColor(i);
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.keepContentOnPlayerReset != z) {
            this.keepContentOnPlayerReset = z;
            updateForCurrentTrackSelections(false);
        }
    }

    @Deprecated
    public void setShowBuffering(boolean z) {
        setShowBuffering(z ? 1 : 0);
    }

    public void setShowBuffering(int i) {
        if (this.showBuffering != i) {
            this.showBuffering = i;
            updateBuffering();
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super ExoPlaybackException> errorMessageProvider2) {
        if (this.errorMessageProvider != errorMessageProvider2) {
            this.errorMessageProvider = errorMessageProvider2;
            updateErrorMessage();
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        Assertions.checkState(this.errorMessageView != null);
        this.customErrorMessage = charSequence;
        updateErrorMessage();
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.player == null || !this.player.isPlayingAd()) {
            boolean z = false;
            if ((isDpadKey(keyEvent.getKeyCode()) && this.useController && !this.controller.isVisible()) || dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
                z = true;
            }
            if (z) {
                maybeShowController(true);
            }
            return z;
        }
        this.overlayFrameLayout.requestFocus();
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        return this.useController && this.controller.dispatchMediaKeyEvent(keyEvent);
    }

    public boolean isControllerVisible() {
        return this.controller != null && this.controller.isVisible();
    }

    public void showController() {
        showController(shouldShowControllerIndefinitely());
    }

    public void hideController() {
        if (this.controller != null) {
            this.controller.hide();
        }
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public void setControllerShowTimeoutMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controllerShowTimeoutMs = i;
        if (this.controller.isVisible()) {
            showController();
        }
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public void setControllerHideOnTouch(boolean z) {
        Assertions.checkState(this.controller != null);
        this.controllerHideOnTouch = z;
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public void setControllerAutoShow(boolean z) {
        this.controllerAutoShow = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.controllerHideDuringAds = z;
    }

    public void setControllerVisibilityListener(PlayerControlView.VisibilityListener visibilityListener) {
        Assertions.checkState(this.controller != null);
        this.controller.setVisibilityListener(visibilityListener);
    }

    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer) {
        Assertions.checkState(this.controller != null);
        this.controller.setPlaybackPreparer(playbackPreparer);
    }

    public void setControlDispatcher(@Nullable ControlDispatcher controlDispatcher) {
        Assertions.checkState(this.controller != null);
        this.controller.setControlDispatcher(controlDispatcher);
    }

    public void setRewindIncrementMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controller.setRewindIncrementMs(i);
    }

    public void setFastForwardIncrementMs(int i) {
        Assertions.checkState(this.controller != null);
        this.controller.setFastForwardIncrementMs(i);
    }

    public void setRepeatToggleModes(int i) {
        Assertions.checkState(this.controller != null);
        this.controller.setRepeatToggleModes(i);
    }

    public void setShowShuffleButton(boolean z) {
        Assertions.checkState(this.controller != null);
        this.controller.setShowShuffleButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        Assertions.checkState(this.controller != null);
        this.controller.setShowMultiWindowTimeBar(z);
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        Assertions.checkState(this.controller != null);
        this.controller.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        Assertions.checkState(this.contentFrame != null);
        this.contentFrame.setAspectRatioListener(aspectRatioListener);
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        return toggleControllerVisibility();
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.useController || this.player == null) {
            return false;
        }
        maybeShowController(true);
        return true;
    }

    public void onResume() {
        if (this.surfaceView instanceof SphericalSurfaceView) {
            ((SphericalSurfaceView) this.surfaceView).onResume();
        }
    }

    public void onPause() {
        if (this.surfaceView instanceof SphericalSurfaceView) {
            ((SphericalSurfaceView) this.surfaceView).onPause();
        }
    }

    /* access modifiers changed from: private */
    public boolean toggleControllerVisibility() {
        if (!this.useController || this.player == null) {
            return false;
        }
        if (!this.controller.isVisible()) {
            maybeShowController(true);
        } else if (this.controllerHideOnTouch) {
            this.controller.hide();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void maybeShowController(boolean z) {
        if ((!isPlayingAd() || !this.controllerHideDuringAds) && this.useController) {
            boolean z2 = this.controller.isVisible() && this.controller.getShowTimeoutMs() <= 0;
            boolean shouldShowControllerIndefinitely = shouldShowControllerIndefinitely();
            if (z || z2 || shouldShowControllerIndefinitely) {
                showController(shouldShowControllerIndefinitely);
            }
        }
    }

    private boolean shouldShowControllerIndefinitely() {
        if (this.player == null) {
            return true;
        }
        int playbackState = this.player.getPlaybackState();
        if (!this.controllerAutoShow || (playbackState != 1 && playbackState != 4 && this.player.getPlayWhenReady())) {
            return false;
        }
        return true;
    }

    private void showController(boolean z) {
        if (this.useController) {
            this.controller.setShowTimeoutMs(z ? 0 : this.controllerShowTimeoutMs);
            this.controller.show();
        }
    }

    /* access modifiers changed from: private */
    public boolean isPlayingAd() {
        return this.player != null && this.player.isPlayingAd() && this.player.getPlayWhenReady();
    }

    /* access modifiers changed from: private */
    public void updateForCurrentTrackSelections(boolean z) {
        if (this.player != null && !this.player.getCurrentTrackGroups().isEmpty()) {
            if (z && !this.keepContentOnPlayerReset) {
                closeShutter();
            }
            TrackSelectionArray currentTrackSelections = this.player.getCurrentTrackSelections();
            int i = 0;
            while (i < currentTrackSelections.length) {
                if (this.player.getRendererType(i) != 2 || currentTrackSelections.get(i) == null) {
                    i++;
                } else {
                    hideArtwork();
                    return;
                }
            }
            closeShutter();
            if (this.useArtwork) {
                for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                    TrackSelection trackSelection = currentTrackSelections.get(i2);
                    if (trackSelection != null) {
                        int i3 = 0;
                        while (i3 < trackSelection.length()) {
                            Metadata metadata = trackSelection.getFormat(i3).metadata;
                            if (metadata == null || !setArtworkFromMetadata(metadata)) {
                                i3++;
                            } else {
                                return;
                            }
                        }
                        continue;
                    }
                }
                if (setDrawableArtwork(this.defaultArtwork)) {
                    return;
                }
            }
            hideArtwork();
        } else if (!this.keepContentOnPlayerReset) {
            hideArtwork();
            closeShutter();
        }
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) entry).pictureData;
                return setDrawableArtwork(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
        }
        return false;
    }

    private boolean setDrawableArtwork(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                if (this.contentFrame != null) {
                    this.contentFrame.setAspectRatio(((float) intrinsicWidth) / ((float) intrinsicHeight));
                }
                this.artworkView.setImageDrawable(drawable);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private void hideArtwork() {
        if (this.artworkView != null) {
            this.artworkView.setImageResource(17170445);
            this.artworkView.setVisibility(4);
        }
    }

    private void closeShutter() {
        if (this.shutterView != null) {
            this.shutterView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void updateBuffering() {
        if (this.bufferingView != null) {
            boolean z = true;
            int i = 0;
            if (this.player == null || this.player.getPlaybackState() != 2 || (this.showBuffering != 2 && (this.showBuffering != 1 || !this.player.getPlayWhenReady()))) {
                z = false;
            }
            View view = this.bufferingView;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public void updateErrorMessage() {
        if (this.errorMessageView == null) {
            return;
        }
        if (this.customErrorMessage != null) {
            this.errorMessageView.setText(this.customErrorMessage);
            this.errorMessageView.setVisibility(0);
            return;
        }
        ExoPlaybackException exoPlaybackException = null;
        if (!(this.player == null || this.player.getPlaybackState() != 1 || this.errorMessageProvider == null)) {
            exoPlaybackException = this.player.getPlaybackError();
        }
        if (exoPlaybackException != null) {
            this.errorMessageView.setText((CharSequence) this.errorMessageProvider.getErrorMessage(exoPlaybackException).second);
            this.errorMessageView.setVisibility(0);
            return;
        }
        this.errorMessageView.setVisibility(8);
    }

    @TargetApi(23)
    private static void configureEditModeLogoV23(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(C1581R.C1583drawable.exo_edit_mode_logo, (Resources.Theme) null));
        imageView.setBackgroundColor(resources.getColor(C1581R.C1582color.exo_edit_mode_background_color, (Resources.Theme) null));
    }

    private static void configureEditModeLogo(Resources resources, ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(C1581R.C1583drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(C1581R.C1582color.exo_edit_mode_background_color));
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    /* access modifiers changed from: private */
    public static void applyTextureViewRotation(TextureView textureView, int i) {
        float width = (float) textureView.getWidth();
        float height = (float) textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i == 0) {
            textureView.setTransform((Matrix) null);
            return;
        }
        Matrix matrix = new Matrix();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        matrix.postRotate((float) i, f, f2);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        textureView.setTransform(matrix);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerView$ComponentListener */
    private final class ComponentListener implements Player.EventListener, TextOutput, VideoListener, View.OnLayoutChangeListener, SphericalSurfaceView.SurfaceListener, SingleTapListener {
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        public /* synthetic */ void onRepeatModeChanged(int i) {
            Player.EventListener.CC.$default$onRepeatModeChanged(this, i);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            VideoListener.CC.$default$onSurfaceSizeChanged(this, i, i2);
        }

        public /* synthetic */ void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i) {
            Player.EventListener.CC.$default$onTimelineChanged(this, timeline, obj, i);
        }

        private ComponentListener() {
        }

        public void onCues(List<Cue> list) {
            if (PlayerView.this.subtitleView != null) {
                PlayerView.this.subtitleView.onCues(list);
            }
        }

        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            if (PlayerView.this.contentFrame != null) {
                float f2 = (i2 == 0 || i == 0) ? 1.0f : (((float) i) * f) / ((float) i2);
                if (PlayerView.this.surfaceView instanceof TextureView) {
                    if (i3 == 90 || i3 == 270) {
                        f2 = 1.0f / f2;
                    }
                    if (PlayerView.this.textureViewRotation != 0) {
                        PlayerView.this.surfaceView.removeOnLayoutChangeListener(this);
                    }
                    int unused = PlayerView.this.textureViewRotation = i3;
                    if (PlayerView.this.textureViewRotation != 0) {
                        PlayerView.this.surfaceView.addOnLayoutChangeListener(this);
                    }
                    PlayerView.applyTextureViewRotation((TextureView) PlayerView.this.surfaceView, PlayerView.this.textureViewRotation);
                } else if (PlayerView.this.surfaceView instanceof SphericalSurfaceView) {
                    f2 = 0.0f;
                }
                PlayerView.this.contentFrame.setAspectRatio(f2);
            }
        }

        public void onRenderedFirstFrame() {
            if (PlayerView.this.shutterView != null) {
                PlayerView.this.shutterView.setVisibility(4);
            }
        }

        public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            PlayerView.this.updateForCurrentTrackSelections(false);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            PlayerView.this.updateBuffering();
            PlayerView.this.updateErrorMessage();
            if (!PlayerView.this.isPlayingAd() || !PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.maybeShowController(false);
            } else {
                PlayerView.this.hideController();
            }
        }

        public void onPositionDiscontinuity(int i) {
            if (PlayerView.this.isPlayingAd() && PlayerView.this.controllerHideDuringAds) {
                PlayerView.this.hideController();
            }
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.applyTextureViewRotation((TextureView) view, PlayerView.this.textureViewRotation);
        }

        public void surfaceChanged(@Nullable Surface surface) {
            Player.VideoComponent videoComponent;
            if (PlayerView.this.player != null && (videoComponent = PlayerView.this.player.getVideoComponent()) != null) {
                videoComponent.setVideoSurface(surface);
            }
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return PlayerView.this.toggleControllerVisibility();
        }
    }
}
