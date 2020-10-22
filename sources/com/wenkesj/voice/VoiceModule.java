package com.wenkesj.voice;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.SpeechRecognizer;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.onesignal.OneSignalDbContract;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;

public class VoiceModule extends ReactContextBaseJavaModule implements RecognitionListener {
    /* access modifiers changed from: private */
    public boolean isRecognizing = false;
    private String locale = null;
    final ReactApplicationContext reactContext;
    /* access modifiers changed from: private */
    public SpeechRecognizer speech = null;

    public static String getErrorText(int i) {
        switch (i) {
            case 1:
                return "Network timeout";
            case 2:
                return "Network error";
            case 3:
                return "Audio recording error";
            case 4:
                return "error from server";
            case 5:
                return "Client side error";
            case 6:
                return "No speech input";
            case 7:
                return "No match";
            case 8:
                return "RecognitionService busy";
            case 9:
                return "Insufficient permissions";
            default:
                return "Didn't understand, please try again.";
        }
    }

    public String getName() {
        return "RCTVoice";
    }

    public void onEvent(int i, Bundle bundle) {
    }

    public VoiceModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    private String getLocale(String str) {
        if (str == null || str.equals("")) {
            return Locale.getDefault().toString();
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0125, code lost:
        if (r4.equals("LANGUAGE_MODEL_WEB_SEARCH") == false) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0148  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void startListening(com.facebook.react.bridge.ReadableMap r9) {
        /*
            r8 = this;
            android.speech.SpeechRecognizer r0 = r8.speech
            if (r0 == 0) goto L_0x000c
            android.speech.SpeechRecognizer r0 = r8.speech
            r0.destroy()
            r0 = 0
            r8.speech = r0
        L_0x000c:
            java.lang.String r0 = "RECOGNIZER_ENGINE"
            boolean r0 = r9.hasKey(r0)
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L_0x004b
            java.lang.String r0 = "RECOGNIZER_ENGINE"
            java.lang.String r0 = r9.getString(r0)
            int r3 = r0.hashCode()
            r4 = 2108052025(0x7da65239, float:2.7634846E37)
            if (r3 == r4) goto L_0x0026
            goto L_0x0030
        L_0x0026:
            java.lang.String r3 = "GOOGLE"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0030
            r0 = 0
            goto L_0x0031
        L_0x0030:
            r0 = -1
        L_0x0031:
            if (r0 == 0) goto L_0x003c
            com.facebook.react.bridge.ReactApplicationContext r0 = r8.reactContext
            android.speech.SpeechRecognizer r0 = android.speech.SpeechRecognizer.createSpeechRecognizer(r0)
            r8.speech = r0
            goto L_0x0053
        L_0x003c:
            com.facebook.react.bridge.ReactApplicationContext r0 = r8.reactContext
            java.lang.String r3 = "com.google.android.googlequicksearchbox/com.google.android.voicesearch.serviceapi.GoogleRecognitionService"
            android.content.ComponentName r3 = android.content.ComponentName.unflattenFromString(r3)
            android.speech.SpeechRecognizer r0 = android.speech.SpeechRecognizer.createSpeechRecognizer(r0, r3)
            r8.speech = r0
            goto L_0x0053
        L_0x004b:
            com.facebook.react.bridge.ReactApplicationContext r0 = r8.reactContext
            android.speech.SpeechRecognizer r0 = android.speech.SpeechRecognizer.createSpeechRecognizer(r0)
            r8.speech = r0
        L_0x0053:
            android.speech.SpeechRecognizer r0 = r8.speech
            r0.setRecognitionListener(r8)
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "android.speech.action.RECOGNIZE_SPEECH"
            r0.<init>(r3)
            com.facebook.react.bridge.ReadableMapKeySetIterator r3 = r9.keySetIterator()
        L_0x0063:
            boolean r4 = r3.hasNextKey()
            if (r4 == 0) goto L_0x0151
            java.lang.String r4 = r3.nextKey()
            int r5 = r4.hashCode()
            r6 = 1
            switch(r5) {
                case -799376495: goto L_0x00a8;
                case -530349781: goto L_0x009e;
                case -136377678: goto L_0x0094;
                case 1189324300: goto L_0x008a;
                case 1326635678: goto L_0x0080;
                case 2061034665: goto L_0x0076;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x00b2
        L_0x0076:
            java.lang.String r5 = "EXTRA_PARTIAL_RESULTS"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 2
            goto L_0x00b3
        L_0x0080:
            java.lang.String r5 = "EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 4
            goto L_0x00b3
        L_0x008a:
            java.lang.String r5 = "EXTRA_MAX_RESULTS"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 1
            goto L_0x00b3
        L_0x0094:
            java.lang.String r5 = "EXTRA_SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 5
            goto L_0x00b3
        L_0x009e:
            java.lang.String r5 = "EXTRA_SPEECH_INPUT_MINIMUM_LENGTH_MILLIS"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 3
            goto L_0x00b3
        L_0x00a8:
            java.lang.String r5 = "EXTRA_LANGUAGE_MODEL"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x00b2
            r5 = 0
            goto L_0x00b3
        L_0x00b2:
            r5 = -1
        L_0x00b3:
            switch(r5) {
                case 0: goto L_0x010c;
                case 1: goto L_0x00f9;
                case 2: goto L_0x00ee;
                case 3: goto L_0x00db;
                case 4: goto L_0x00c9;
                case 5: goto L_0x00b7;
                default: goto L_0x00b6;
            }
        L_0x00b6:
            goto L_0x0063
        L_0x00b7:
            double r4 = r9.getDouble(r4)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r5 = "android.speech.extras.SPEECH_INPUT_POSSIBLY_COMPLETE_SILENCE_LENGTH_MILLIS"
            int r4 = r4.intValue()
            r0.putExtra(r5, r4)
            goto L_0x0063
        L_0x00c9:
            double r4 = r9.getDouble(r4)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r5 = "android.speech.extras.SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS"
            int r4 = r4.intValue()
            r0.putExtra(r5, r4)
            goto L_0x0063
        L_0x00db:
            double r4 = r9.getDouble(r4)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r5 = "android.speech.extras.SPEECH_INPUT_MINIMUM_LENGTH_MILLIS"
            int r4 = r4.intValue()
            r0.putExtra(r5, r4)
            goto L_0x0063
        L_0x00ee:
            java.lang.String r5 = "android.speech.extra.PARTIAL_RESULTS"
            boolean r4 = r9.getBoolean(r4)
            r0.putExtra(r5, r4)
            goto L_0x0063
        L_0x00f9:
            double r4 = r9.getDouble(r4)
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            java.lang.String r5 = "android.speech.extra.MAX_RESULTS"
            int r4 = r4.intValue()
            r0.putExtra(r5, r4)
            goto L_0x0063
        L_0x010c:
            java.lang.String r4 = r9.getString(r4)
            int r5 = r4.hashCode()
            r7 = -874741222(0xffffffffcbdc821a, float:-2.8902452E7)
            if (r5 == r7) goto L_0x0128
            r7 = 1951040016(0x744a8210, float:6.4177365E31)
            if (r5 == r7) goto L_0x011f
            goto L_0x0132
        L_0x011f:
            java.lang.String r5 = "LANGUAGE_MODEL_WEB_SEARCH"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0132
            goto L_0x0133
        L_0x0128:
            java.lang.String r5 = "LANGUAGE_MODEL_FREE_FORM"
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0132
            r6 = 0
            goto L_0x0133
        L_0x0132:
            r6 = -1
        L_0x0133:
            switch(r6) {
                case 0: goto L_0x0148;
                case 1: goto L_0x013f;
                default: goto L_0x0136;
            }
        L_0x0136:
            java.lang.String r4 = "android.speech.extra.LANGUAGE_MODEL"
            java.lang.String r5 = "free_form"
            r0.putExtra(r4, r5)
            goto L_0x0063
        L_0x013f:
            java.lang.String r4 = "android.speech.extra.LANGUAGE_MODEL"
            java.lang.String r5 = "web_search"
            r0.putExtra(r4, r5)
            goto L_0x0063
        L_0x0148:
            java.lang.String r4 = "android.speech.extra.LANGUAGE_MODEL"
            java.lang.String r5 = "free_form"
            r0.putExtra(r4, r5)
            goto L_0x0063
        L_0x0151:
            java.lang.String r9 = "android.speech.extra.LANGUAGE"
            java.lang.String r1 = r8.locale
            java.lang.String r1 = r8.getLocale(r1)
            r0.putExtra(r9, r1)
            android.speech.SpeechRecognizer r9 = r8.speech
            r9.startListening(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wenkesj.voice.VoiceModule.startListening(com.facebook.react.bridge.ReadableMap):void");
    }

    /* access modifiers changed from: private */
    public void startSpeechWithPermissions(String str, final ReadableMap readableMap, final Callback callback) {
        this.locale = str;
        new Handler(this.reactContext.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    VoiceModule.this.startListening(readableMap);
                    boolean unused = VoiceModule.this.isRecognizing = true;
                    callback.invoke(false);
                } catch (Exception e) {
                    callback.invoke(e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void startSpeech(final String str, final ReadableMap readableMap, final Callback callback) {
        if (isPermissionGranted() || !readableMap.getBoolean("REQUEST_PERMISSIONS_AUTO")) {
            startSpeechWithPermissions(str, readableMap, callback);
            return;
        }
        String[] strArr = {"android.permission.RECORD_AUDIO"};
        if (getCurrentActivity() != null) {
            ((PermissionAwareActivity) getCurrentActivity()).requestPermissions(strArr, 1, new PermissionListener() {
                public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
                    boolean z = true;
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        z = z && (iArr[i2] == 0);
                    }
                    VoiceModule.this.startSpeechWithPermissions(str, readableMap, callback);
                    return z;
                }
            });
        }
    }

    @ReactMethod
    public void stopSpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    if (VoiceModule.this.speech != null) {
                        VoiceModule.this.speech.stopListening();
                    }
                    boolean unused = VoiceModule.this.isRecognizing = false;
                    callback.invoke(false);
                } catch (Exception e) {
                    callback.invoke(e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void cancelSpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    if (VoiceModule.this.speech != null) {
                        VoiceModule.this.speech.cancel();
                    }
                    boolean unused = VoiceModule.this.isRecognizing = false;
                    callback.invoke(false);
                } catch (Exception e) {
                    callback.invoke(e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void destroySpeech(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    if (VoiceModule.this.speech != null) {
                        VoiceModule.this.speech.destroy();
                    }
                    SpeechRecognizer unused = VoiceModule.this.speech = null;
                    boolean unused2 = VoiceModule.this.isRecognizing = false;
                    callback.invoke(false);
                } catch (Exception e) {
                    callback.invoke(e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void isSpeechAvailable(final Callback callback) {
        new Handler(this.reactContext.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Boolean valueOf = Boolean.valueOf(SpeechRecognizer.isRecognitionAvailable(this.reactContext));
                    callback.invoke(valueOf, false);
                } catch (Exception e) {
                    callback.invoke(false, e.getMessage());
                }
            }
        });
    }

    @ReactMethod
    public void getSpeechRecognitionServices(Promise promise) {
        List<ResolveInfo> queryIntentServices = this.reactContext.getPackageManager().queryIntentServices(new Intent("android.speech.RecognitionService"), 0);
        WritableArray createArray = Arguments.createArray();
        for (ResolveInfo resolveInfo : queryIntentServices) {
            createArray.pushString(resolveInfo.serviceInfo.packageName);
        }
        promise.resolve(createArray);
    }

    private boolean isPermissionGranted() {
        return getReactApplicationContext().checkCallingOrSelfPermission("android.permission.RECORD_AUDIO") == 0;
    }

    @ReactMethod
    public void isRecognizing(Callback callback) {
        callback.invoke(Boolean.valueOf(this.isRecognizing));
    }

    private void sendEvent(String str, @Nullable WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
    }

    public void onBeginningOfSpeech() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechStart", createMap);
        Log.d("ASR", "onBeginningOfSpeech()");
    }

    public void onBufferReceived(byte[] bArr) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechRecognized", createMap);
        Log.d("ASR", "onBufferReceived()");
    }

    public void onEndOfSpeech() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechEnd", createMap);
        Log.d("ASR", "onEndOfSpeech()");
        this.isRecognizing = false;
    }

    public void onError(int i) {
        String format = String.format("%d/%s", new Object[]{Integer.valueOf(i), getErrorText(i)});
        WritableMap createMap = Arguments.createMap();
        createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, format);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putMap("error", createMap);
        sendEvent("onSpeechError", createMap2);
        Log.d("ASR", "onError() - " + format);
    }

    public void onPartialResults(Bundle bundle) {
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = bundle.getStringArrayList("results_recognition").iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("value", createArray);
        sendEvent("onSpeechPartialResults", createMap);
        Log.d("ASR", "onPartialResults()");
    }

    public void onReadyForSpeech(Bundle bundle) {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("error", false);
        sendEvent("onSpeechStart", createMap);
        Log.d("ASR", "onReadyForSpeech()");
    }

    public void onResults(Bundle bundle) {
        WritableArray createArray = Arguments.createArray();
        Iterator<String> it = bundle.getStringArrayList("results_recognition").iterator();
        while (it.hasNext()) {
            createArray.pushString(it.next());
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putArray("value", createArray);
        sendEvent("onSpeechResults", createMap);
        Log.d("ASR", "onResults()");
    }

    public void onRmsChanged(float f) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("value", (double) f);
        sendEvent("onSpeechVolumeChanged", createMap);
    }
}
