package com.facebook.react.modules.sound;

import android.media.AudioManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.exoplayer2.util.MimeTypes;

@ReactModule(name = "SoundManager")
public class SoundManagerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "SoundManager";

    public String getName() {
        return NAME;
    }

    public SoundManagerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void playTouchSound() {
        AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager != null) {
            audioManager.playSoundEffect(0);
        }
    }
}
