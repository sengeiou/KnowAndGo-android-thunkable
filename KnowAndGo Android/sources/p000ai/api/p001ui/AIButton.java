package p000ai.api.p001ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.List;
import p000ai.api.AIListener;
import p000ai.api.AIServiceException;
import p000ai.api.C0001R;
import p000ai.api.PartialResultsListener;
import p000ai.api.RequestExtras;
import p000ai.api.android.AIConfiguration;
import p000ai.api.android.AIService;
import p000ai.api.model.AIError;
import p000ai.api.model.AIRequest;
import p000ai.api.model.AIResponse;
import p000ai.api.services.GoogleRecognitionServiceImpl;

/* renamed from: ai.api.ui.AIButton */
public class AIButton extends SoundLevelButton implements AIListener {
    protected static final int[] STATE_INITIALIZING_TTS = {C0001R.attr.state_initializing_tts};
    protected static final int[] STATE_SPEAKING = {C0001R.attr.state_speaking};
    protected static final int[] STATE_WAITING = {C0001R.attr.state_waiting};
    private static final String TAG = "ai.api.ui.AIButton";
    private AIService aiService;
    private final WaitingAnimation animation = new WaitingAnimation();
    private boolean animationSecondPhase = false;
    /* access modifiers changed from: private */
    public float animationStage = 0.0f;
    private volatile MicState currentState = MicState.normal;
    /* access modifiers changed from: private */
    public PartialResultsListener partialResultsListener;
    private AIButtonListener resultsListener;

    /* renamed from: ai.api.ui.AIButton$AIButtonListener */
    public interface AIButtonListener {
        void onCancelled();

        void onError(AIError aIError);

        void onResult(AIResponse aIResponse);
    }

    public void onResult(AIResponse aIResponse) {
        post(new Runnable() {
            public void run() {
                AIButton.this.changeState(MicState.normal);
            }
        });
        if (this.resultsListener != null) {
            this.resultsListener.onResult(aIResponse);
        }
    }

    public void onError(AIError aIError) {
        post(new Runnable() {
            public void run() {
                AIButton.this.changeState(MicState.normal);
            }
        });
        if (this.resultsListener != null) {
            this.resultsListener.onError(aIError);
        }
    }

    public void onAudioLevel(float f) {
        setSoundLevel(f);
    }

    public void onListeningStarted() {
        post(new Runnable() {
            public void run() {
                AIButton.this.changeState(MicState.listening);
            }
        });
    }

    public void onListeningCanceled() {
        post(new Runnable() {
            public void run() {
                AIButton.this.changeState(MicState.normal);
            }
        });
        if (this.resultsListener != null) {
            this.resultsListener.onCancelled();
        }
    }

    public void onListeningFinished() {
        post(new Runnable() {
            public void run() {
                AIButton.this.changeState(MicState.busy);
            }
        });
    }

    /* renamed from: ai.api.ui.AIButton$MicState */
    public enum MicState {
        normal,
        busy,
        listening,
        speaking,
        initializingTts;

        public static MicState fromAttrs(TypedArray typedArray) {
            if (typedArray.getBoolean(C0001R.styleable.SoundLevelButton_state_listening, false)) {
                return listening;
            }
            if (typedArray.getBoolean(C0001R.styleable.SoundLevelButton_state_waiting, false)) {
                return busy;
            }
            if (typedArray.getBoolean(C0001R.styleable.SoundLevelButton_state_speaking, false)) {
                return speaking;
            }
            if (typedArray.getBoolean(C0001R.styleable.SoundLevelButton_state_initializing_tts, false)) {
                return initializingTts;
            }
            return normal;
        }
    }

    public AIButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public AIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public AIButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0001R.styleable.SoundLevelButton);
            try {
                this.currentState = MicState.fromAttrs(obtainStyledAttributes);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public void initialize(AIConfiguration aIConfiguration) {
        this.aiService = AIService.getService(getContext(), aIConfiguration);
        this.aiService.setListener(this);
        if (this.aiService instanceof GoogleRecognitionServiceImpl) {
            ((GoogleRecognitionServiceImpl) this.aiService).setPartialResultsListener(new PartialResultsListener() {
                public void onPartialResults(List<String> list) {
                    if (AIButton.this.partialResultsListener != null) {
                        AIButton.this.partialResultsListener.onPartialResults(list);
                    }
                }
            });
        }
    }

    public void setResultsListener(AIButtonListener aIButtonListener) {
        this.resultsListener = aIButtonListener;
    }

    public void setPartialResultsListener(PartialResultsListener partialResultsListener2) {
        this.partialResultsListener = partialResultsListener2;
    }

    public void startListening() {
        startListening((RequestExtras) null);
    }

    public void startListening(RequestExtras requestExtras) {
        if (this.aiService == null) {
            throw new IllegalStateException("Call initialize method before usage");
        } else if (this.currentState == MicState.normal) {
            this.aiService.startListening(requestExtras);
        }
    }

    public AIResponse textRequest(AIRequest aIRequest) throws AIServiceException {
        if (this.aiService != null) {
            return this.aiService.textRequest(aIRequest);
        }
        throw new IllegalStateException("Call initialize method before usage");
    }

    public AIResponse textRequest(String str) throws AIServiceException {
        return textRequest(new AIRequest(str));
    }

    public AIService getAIService() {
        return this.aiService;
    }

    /* access modifiers changed from: protected */
    public void onClick(View view) {
        super.onClick(view);
        if (this.aiService != null) {
            switch (this.currentState) {
                case normal:
                    this.aiService.startListening();
                    return;
                case busy:
                    this.aiService.cancel();
                    return;
                default:
                    this.aiService.stopListening();
                    return;
            }
        }
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.currentState != null) {
            switch (this.currentState) {
                case busy:
                    mergeDrawableStates(onCreateDrawableState, STATE_WAITING);
                    break;
                case listening:
                    mergeDrawableStates(onCreateDrawableState, STATE_LISTENING);
                    break;
                case speaking:
                    mergeDrawableStates(onCreateDrawableState, STATE_SPEAKING);
                    break;
                case initializingTts:
                    mergeDrawableStates(onCreateDrawableState, STATE_INITIALIZING_TTS);
                    break;
            }
        }
        return onCreateDrawableState;
    }

    public void resume() {
        if (this.aiService != null) {
            this.aiService.resume();
        }
    }

    public void pause() {
        cancelListening();
        if (this.aiService != null) {
            this.aiService.pause();
        }
    }

    private void cancelListening() {
        if (this.aiService != null && this.currentState != MicState.normal) {
            this.aiService.cancel();
            changeState(MicState.normal);
        }
    }

    /* access modifiers changed from: protected */
    public void changeState(MicState micState) {
        switch (micState) {
            case normal:
                stopProcessingAnimation();
                setDrawSoundLevel(false);
                break;
            case busy:
                startProcessingAnimation();
                setDrawSoundLevel(false);
                break;
            case listening:
                stopProcessingAnimation();
                setDrawSoundLevel(true);
                break;
            case speaking:
                stopProcessingAnimation();
                setDrawSoundLevel(false);
                break;
            case initializingTts:
                stopProcessingAnimation();
                setDrawSoundLevel(false);
                break;
        }
        this.currentState = micState;
        refreshDrawableState();
    }

    /* access modifiers changed from: protected */
    public MicState getCurrentState() {
        return this.currentState;
    }

    private void startProcessingAnimation() {
        setDrawCenter(true);
        this.animationSecondPhase = false;
        startAnimation(this.animation);
    }

    private void stopProcessingAnimation() {
        setDrawCenter(false);
        clearAnimation();
        this.animationStage = 0.0f;
        this.animationSecondPhase = false;
        postInvalidate();
    }

    /* access modifiers changed from: protected */
    public String getDebugState() {
        return super.getDebugState() + "\nst:" + this.currentState;
    }

    /* renamed from: ai.api.ui.AIButton$WaitingAnimation */
    private class WaitingAnimation extends Animation {
        protected WaitingAnimation() {
            setDuration(1500);
            setRepeatCount(-1);
            setRepeatMode(1);
            setInterpolator(new LinearInterpolator());
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f, Transformation transformation) {
            float unused = AIButton.this.animationStage = f;
            AIButton.this.invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        float f2 = 0.0f;
        if (this.animationStage > 0.0f || this.animationSecondPhase) {
            float width = ((float) getWidth()) / 2.0f;
            float minRadius = getMinRadius() * 1.25f;
            float f3 = width - minRadius;
            float f4 = width + minRadius;
            RectF rectF = new RectF(f3, f3, f4, f4);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(C0001R.C0002color.icon_orange_color));
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) dpToPixels(getContext(), 4.0f));
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setAntiAlias(true);
            if (((double) this.animationStage) >= 0.5d || this.animationSecondPhase) {
                f2 = (this.animationStage - 0.5f) * 360.0f;
                this.animationSecondPhase = true;
                f = 180.0f;
            } else {
                f = this.animationStage * 360.0f;
            }
            canvas.drawArc(rectF, f2 + 270.0f, f, false, paint);
        }
    }

    private static int dpToPixels(Context context, float f) {
        return Math.round(TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()));
    }
}
