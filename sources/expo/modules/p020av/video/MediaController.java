package expo.modules.p020av.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import expo.modules.p020av.C3410R;
import expo.modules.p020av.player.PlayerDataControl;
import java.lang.ref.WeakReference;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: expo.modules.av.video.MediaController */
public class MediaController extends FrameLayout {
    private static final int FADE_OUT = 1;
    private static final int SHOW_PROGRESS = 2;
    private static final int sDefaultTimeout = 3000;
    private ViewGroup mAnchor;
    private Context mContext;
    /* access modifiers changed from: private */
    public TextView mCurrentTime;
    /* access modifiers changed from: private */
    public boolean mDragging;
    private TextView mEndTime;
    private ImageButton mFastForwardButton;
    private View.OnClickListener mFfwdListener;
    private StringBuilder mFormatBuilder;
    private Formatter mFormatter;
    private boolean mFromXml;
    private ImageButton mFullscreenButton;
    private View.OnClickListener mFullscreenListener;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private boolean mListenersSet;
    private ImageButton mNextButton;
    private View.OnClickListener mNextListener;
    private ImageButton mPauseButton;
    private View.OnClickListener mPauseListener;
    /* access modifiers changed from: private */
    public PlayerDataControl mPlayer;
    private ImageButton mPrevButton;
    private View.OnClickListener mPrevListener;
    private ProgressBar mProgress;
    private View.OnClickListener mRewListener;
    private ImageButton mRewindButton;
    private View mRoot;
    private SeekBar.OnSeekBarChangeListener mSeekListener;
    /* access modifiers changed from: private */
    public boolean mShowing;
    private boolean mUseFastForward;

    public MediaController(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doPauseResume();
            }
        };
        this.mFullscreenListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doToggleFullscreen();
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.show(3600000);
                boolean unused = MediaController.this.mDragging = true;
                MediaController.this.mHandler.removeMessages(2);
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (MediaController.this.mPlayer != null && z) {
                    int duration = (int) ((((long) MediaController.this.mPlayer.getDuration()) * ((long) i)) / 1000);
                    MediaController.this.mPlayer.seekTo(duration);
                    if (MediaController.this.mCurrentTime != null) {
                        MediaController.this.mCurrentTime.setText(MediaController.this.stringForTime(duration));
                    }
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                boolean unused = MediaController.this.mDragging = false;
                int unused2 = MediaController.this.setProgress();
                MediaController.this.updatePausePlay();
                MediaController.this.show(3000);
                MediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() - 5000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mFfwdListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() + 15000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mRoot = null;
        this.mContext = context;
        this.mUseFastForward = true;
        this.mFromXml = true;
    }

    public MediaController(Context context, boolean z) {
        super(context);
        this.mHandler = new MessageHandler(this);
        this.mPauseListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doPauseResume();
            }
        };
        this.mFullscreenListener = new View.OnClickListener() {
            public void onClick(View view) {
                MediaController.this.show(3000);
                MediaController.this.doToggleFullscreen();
            }
        };
        this.mSeekListener = new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
                MediaController.this.show(3600000);
                boolean unused = MediaController.this.mDragging = true;
                MediaController.this.mHandler.removeMessages(2);
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (MediaController.this.mPlayer != null && z) {
                    int duration = (int) ((((long) MediaController.this.mPlayer.getDuration()) * ((long) i)) / 1000);
                    MediaController.this.mPlayer.seekTo(duration);
                    if (MediaController.this.mCurrentTime != null) {
                        MediaController.this.mCurrentTime.setText(MediaController.this.stringForTime(duration));
                    }
                }
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                boolean unused = MediaController.this.mDragging = false;
                int unused2 = MediaController.this.setProgress();
                MediaController.this.updatePausePlay();
                MediaController.this.show(3000);
                MediaController.this.mHandler.sendEmptyMessage(2);
            }
        };
        this.mRewListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() - 5000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mFfwdListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (MediaController.this.mPlayer != null) {
                    MediaController.this.mPlayer.seekTo(MediaController.this.mPlayer.getCurrentPosition() + 15000);
                    int unused = MediaController.this.setProgress();
                    MediaController.this.show(3000);
                }
            }
        };
        this.mContext = context;
        this.mUseFastForward = z;
    }

    public MediaController(Context context) {
        this(context, true);
    }

    public void onFinishInflate() {
        if (this.mRoot != null) {
            initControllerView(this.mRoot);
        }
        super.onFinishInflate();
    }

    public void setMediaPlayer(PlayerDataControl playerDataControl) {
        this.mPlayer = playerDataControl;
        updateControls();
    }

    public void updateControls() {
        setProgress();
        updatePausePlay();
        updateFullScreen();
    }

    public void setAnchorView(ViewGroup viewGroup) {
        this.mAnchor = viewGroup;
        if (this.mRoot == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            removeAllViews();
            addView(makeControllerView(), layoutParams);
        }
    }

    /* access modifiers changed from: protected */
    public View makeControllerView() {
        this.mRoot = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(C3410R.layout.expo_media_controller, (ViewGroup) null);
        initControllerView(this.mRoot);
        return this.mRoot;
    }

    private void initControllerView(View view) {
        this.mPauseButton = (ImageButton) view.findViewById(C3410R.C3413id.play_button);
        if (this.mPauseButton != null) {
            this.mPauseButton.requestFocus();
            this.mPauseButton.setOnClickListener(this.mPauseListener);
        }
        this.mFullscreenButton = (ImageButton) view.findViewById(C3410R.C3413id.fullscreen_mode_button);
        if (this.mFullscreenButton != null) {
            this.mFullscreenButton.requestFocus();
            this.mFullscreenButton.setOnClickListener(this.mFullscreenListener);
        }
        this.mFastForwardButton = (ImageButton) view.findViewById(C3410R.C3413id.fast_forward_button);
        int i = 0;
        if (this.mFastForwardButton != null) {
            this.mFastForwardButton.setOnClickListener(this.mFfwdListener);
            if (!this.mFromXml) {
                this.mFastForwardButton.setVisibility(this.mUseFastForward ? 0 : 8);
            }
        }
        this.mRewindButton = (ImageButton) view.findViewById(C3410R.C3413id.rewind_button);
        if (this.mRewindButton != null) {
            this.mRewindButton.setOnClickListener(this.mRewListener);
            if (!this.mFromXml) {
                ImageButton imageButton = this.mRewindButton;
                if (!this.mUseFastForward) {
                    i = 8;
                }
                imageButton.setVisibility(i);
            }
        }
        this.mNextButton = (ImageButton) view.findViewById(C3410R.C3413id.skip_next_button);
        if (this.mNextButton != null && !this.mFromXml && !this.mListenersSet) {
            this.mNextButton.setVisibility(8);
        }
        this.mPrevButton = (ImageButton) view.findViewById(C3410R.C3413id.skip_previous_button);
        if (this.mPrevButton != null && !this.mFromXml && !this.mListenersSet) {
            this.mPrevButton.setVisibility(8);
        }
        this.mProgress = (ProgressBar) view.findViewById(C3410R.C3413id.seek_bar);
        if (this.mProgress != null) {
            if (this.mProgress instanceof SeekBar) {
                ((SeekBar) this.mProgress).setOnSeekBarChangeListener(this.mSeekListener);
            }
            this.mProgress.setMax(1000);
        }
        this.mEndTime = (TextView) view.findViewById(C3410R.C3413id.end_time_text);
        this.mCurrentTime = (TextView) view.findViewById(C3410R.C3413id.current_time_text);
        this.mFormatBuilder = new StringBuilder();
        this.mFormatter = new Formatter(this.mFormatBuilder, Locale.getDefault());
        installPrevNextListeners();
    }

    public void show() {
        show(3000);
    }

    private void disableUnsupportedButtons() {
        if (this.mPlayer != null) {
            try {
                if (this.mPauseButton != null && !this.mPlayer.canPause()) {
                    this.mPauseButton.setEnabled(false);
                }
                if (this.mRewindButton != null && !this.mPlayer.canSeekBackward()) {
                    this.mRewindButton.setEnabled(false);
                }
                if (this.mFastForwardButton != null && !this.mPlayer.canSeekForward()) {
                    this.mFastForwardButton.setEnabled(false);
                }
            } catch (IncompatibleClassChangeError unused) {
            }
        }
    }

    public void show(int i) {
        if (!this.mShowing && this.mAnchor != null) {
            setProgress();
            if (this.mPauseButton != null) {
                this.mPauseButton.requestFocus();
            }
            disableUnsupportedButtons();
            this.mAnchor.addView(this, new FrameLayout.LayoutParams(-1, -1));
            this.mShowing = true;
        }
        updateControls();
        this.mHandler.sendEmptyMessage(2);
        Message obtainMessage = this.mHandler.obtainMessage(1);
        if (i != 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.sendMessageDelayed(obtainMessage, (long) i);
        }
    }

    public boolean isShowing() {
        return this.mShowing;
    }

    public void hide() {
        if (this.mAnchor != null) {
            try {
                this.mAnchor.removeView(this);
                this.mHandler.removeMessages(2);
            } catch (IllegalArgumentException unused) {
                Log.w("MediaController", "already removed");
            }
            this.mShowing = false;
        }
    }

    /* access modifiers changed from: private */
    public String stringForTime(int i) {
        int i2 = i / 1000;
        int i3 = i2 % 60;
        int i4 = (i2 / 60) % 60;
        int i5 = i2 / 3600;
        this.mFormatBuilder.setLength(0);
        if (i5 > 0) {
            return this.mFormatter.format("%d:%02d:%02d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
        }
        return this.mFormatter.format("%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)}).toString();
    }

    /* access modifiers changed from: private */
    public int setProgress() {
        if (this.mPlayer == null || this.mDragging) {
            return 0;
        }
        int currentPosition = this.mPlayer.getCurrentPosition();
        int duration = this.mPlayer.getDuration();
        if (this.mProgress != null) {
            if (duration > 0) {
                this.mProgress.setProgress((int) ((((long) currentPosition) * 1000) / ((long) duration)));
            }
            this.mProgress.setSecondaryProgress(this.mPlayer.getBufferPercentage() * 10);
        }
        if (this.mEndTime != null) {
            this.mEndTime.setText(stringForTime(duration));
        }
        if (this.mCurrentTime != null) {
            this.mCurrentTime.setText(stringForTime(currentPosition));
        }
        return currentPosition;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return true;
        }
        show(3000);
        return true;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        show(3000);
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (this.mPlayer == null || !isEnabled()) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z = keyEvent.getRepeatCount() == 0 && keyEvent.getAction() == 0;
        if (keyCode == 79 || keyCode == 85 || keyCode == 62) {
            if (z) {
                doPauseResume();
                show(3000);
                if (this.mPauseButton != null) {
                    this.mPauseButton.requestFocus();
                }
            }
            return true;
        } else if (keyCode == 126) {
            if (z && !this.mPlayer.isPlaying()) {
                this.mPlayer.start();
                updatePausePlay();
                show(3000);
            }
            return true;
        } else if (keyCode == 86 || keyCode == 127) {
            if (z && this.mPlayer.isPlaying()) {
                this.mPlayer.pause();
                updatePausePlay();
                show(3000);
            }
            return true;
        } else if (keyCode == 25 || keyCode == 24 || keyCode == 164) {
            return super.dispatchKeyEvent(keyEvent);
        } else {
            if (keyCode == 4 || keyCode == 82) {
                if (z) {
                    hide();
                }
                return true;
            }
            show(3000);
            return super.dispatchKeyEvent(keyEvent);
        }
    }

    public void updatePausePlay() {
        if (this.mRoot != null && this.mPauseButton != null && this.mPlayer != null) {
            if (this.mPlayer.isPlaying()) {
                this.mPauseButton.setImageResource(C3410R.C3412drawable.exo_controls_pause);
            } else {
                this.mPauseButton.setImageResource(C3410R.C3412drawable.exo_controls_play);
            }
        }
    }

    public void updateFullScreen() {
        if (this.mRoot != null && this.mFullscreenButton != null && this.mPlayer != null) {
            if (this.mPlayer.isFullscreen()) {
                this.mFullscreenButton.setImageResource(C3410R.C3412drawable.ic_fullscreen_exit_32dp);
            } else {
                this.mFullscreenButton.setImageResource(C3410R.C3412drawable.ic_fullscreen_32dp);
            }
        }
    }

    /* access modifiers changed from: private */
    public void doPauseResume() {
        if (this.mPlayer != null) {
            if (this.mPlayer.isPlaying()) {
                this.mPlayer.pause();
            } else {
                this.mPlayer.start();
            }
            updatePausePlay();
        }
    }

    /* access modifiers changed from: private */
    public void doToggleFullscreen() {
        if (this.mPlayer != null) {
            this.mPlayer.toggleFullscreen();
        }
    }

    public void setEnabled(boolean z) {
        if (this.mPauseButton != null) {
            this.mPauseButton.setEnabled(z);
        }
        if (this.mFastForwardButton != null) {
            this.mFastForwardButton.setEnabled(z);
        }
        if (this.mRewindButton != null) {
            this.mRewindButton.setEnabled(z);
        }
        boolean z2 = true;
        if (this.mNextButton != null) {
            this.mNextButton.setEnabled(z && this.mNextListener != null);
        }
        if (this.mPrevButton != null) {
            ImageButton imageButton = this.mPrevButton;
            if (!z || this.mPrevListener == null) {
                z2 = false;
            }
            imageButton.setEnabled(z2);
        }
        if (this.mProgress != null) {
            this.mProgress.setEnabled(z);
        }
        disableUnsupportedButtons();
        super.setEnabled(z);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(MediaController.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(MediaController.class.getName());
    }

    private void installPrevNextListeners() {
        boolean z = false;
        if (this.mNextButton != null) {
            this.mNextButton.setOnClickListener(this.mNextListener);
            this.mNextButton.setEnabled(this.mNextListener != null);
        }
        if (this.mPrevButton != null) {
            this.mPrevButton.setOnClickListener(this.mPrevListener);
            ImageButton imageButton = this.mPrevButton;
            if (this.mPrevListener != null) {
                z = true;
            }
            imageButton.setEnabled(z);
        }
    }

    public void setPrevNextListeners(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.mNextListener = onClickListener;
        this.mPrevListener = onClickListener2;
        this.mListenersSet = true;
        if (this.mRoot != null) {
            installPrevNextListeners();
            if (this.mNextButton != null && !this.mFromXml) {
                this.mNextButton.setVisibility(0);
            }
            if (this.mPrevButton != null && !this.mFromXml) {
                this.mPrevButton.setVisibility(0);
            }
        }
    }

    /* renamed from: expo.modules.av.video.MediaController$MessageHandler */
    private static class MessageHandler extends Handler {
        private final WeakReference<MediaController> mView;

        MessageHandler(MediaController mediaController) {
            this.mView = new WeakReference<>(mediaController);
        }

        public void handleMessage(Message message) {
            MediaController mediaController = (MediaController) this.mView.get();
            if (mediaController != null && mediaController.mPlayer != null) {
                switch (message.what) {
                    case 1:
                        mediaController.hide();
                        return;
                    case 2:
                        int access$700 = mediaController.setProgress();
                        if (!mediaController.mDragging && mediaController.mShowing && mediaController.mPlayer.isPlaying()) {
                            sendMessageDelayed(obtainMessage(2), (long) (1000 - (access$700 % 1000)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
