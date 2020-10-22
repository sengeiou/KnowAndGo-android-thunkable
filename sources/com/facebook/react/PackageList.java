package com.facebook.react;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import com.RNFetchBlob.RNFetchBlobPackage;
import com.airbnb.android.react.lottie.LottiePackage;
import com.airbnb.android.react.maps.MapsPackage;
import com.bitgo.randombytes.RandomBytesPackage;
import com.bugsnag.BugsnagReactNative;
import com.clipsub.RNShake.RNShakeEventPackage;
import com.dooboolab.RNIap.RNIapPackage;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.shell.MainReactPackage;
import com.futurepress.staticserver.FPStaticServerPackage;
import com.geektime.rnonesignalandroid.ReactNativeOneSignalPackage;
import com.github.yamill.orientation.OrientationPackage;
import com.imagepicker.ImagePickerPackage;
import com.learnium.RNDeviceInfo.C2333RNDeviceInfo;
import com.lugg.ReactNativeConfig.ReactNativeConfigPackage;
import com.masteratul.exceptionhandler.ReactNativeExceptionHandlerPackage;
import com.ocetnik.timer.BackgroundTimerPackage;
import com.polidea.reactnativeble.BlePackage;
import com.reactcommunity.rndatetimepicker.RNDateTimePickerPackage;
import com.reactnativecommunity.netinfo.NetInfoPackage;
import com.reactnativecommunity.webview.RNCWebViewPackage;
import com.reactnativerate.RNRatePackage;
import com.rnfs.RNFSPackage;
import com.swmansion.gesturehandler.react.RNGestureHandlerPackage;
import com.swmansion.reanimated.ReanimatedPackage;
import com.swmansion.rnscreens.RNScreensPackage;
import com.uxcam.RNUxcamPackage;
import com.wenkesj.voice.VoicePackage;
import com.zmxv.RNSound.RNSoundPackage;
import java.util.ArrayList;
import java.util.Arrays;
import net.no_mad.tts.TextToSpeechPackage;
import p008cl.json.RNSharePackage;
import p009co.apptailor.googlesignin.RNGoogleSigninPackage;
import p019de.innfactory.apiai.RNApiAiPackage;
import p023fr.bamlab.rnimageresizer.ImageResizerPackage;
import p024io.expo.appearance.RNCAppearancePackage;

public class PackageList {
    private Application application;
    private MainPackageConfig mConfig;
    private ReactNativeHost reactNativeHost;

    public PackageList(ReactNativeHost reactNativeHost2) {
        this(reactNativeHost2, (MainPackageConfig) null);
    }

    public PackageList(Application application2) {
        this(application2, (MainPackageConfig) null);
    }

    public PackageList(ReactNativeHost reactNativeHost2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = reactNativeHost2;
        this.mConfig = mainPackageConfig;
    }

    public PackageList(Application application2, MainPackageConfig mainPackageConfig) {
        this.reactNativeHost = null;
        this.application = application2;
        this.mConfig = mainPackageConfig;
    }

    private ReactNativeHost getReactNativeHost() {
        return this.reactNativeHost;
    }

    private Resources getResources() {
        return getApplication().getResources();
    }

    private Application getApplication() {
        if (this.reactNativeHost == null) {
            return this.application;
        }
        return this.reactNativeHost.getApplication();
    }

    private Context getApplicationContext() {
        return getApplication().getApplicationContext();
    }

    public ArrayList<ReactPackage> getPackages() {
        return new ArrayList<>(Arrays.asList(new ReactPackage[]{new MainReactPackage(this.mConfig), new RNDateTimePickerPackage(), new RNGoogleSigninPackage(), new NetInfoPackage(), new VoicePackage(), BugsnagReactNative.getPackage(), new LottiePackage(), new RNCAppearancePackage(), new BackgroundTimerPackage(), new BlePackage(), new ReactNativeConfigPackage(), new C2333RNDeviceInfo(), new RNApiAiPackage(), new ReactNativeExceptionHandlerPackage(), new RNFSPackage(), new RNGestureHandlerPackage(), new RNIapPackage(), new ImagePickerPackage(), new ImageResizerPackage(), new MapsPackage(), new ReactNativeOneSignalPackage(), new OrientationPackage(), new RandomBytesPackage(), new RNRatePackage(), new ReanimatedPackage(), new RNScreensPackage(), new RNShakeEventPackage(), new RNSharePackage(), new RNSoundPackage(), new FPStaticServerPackage(), new TextToSpeechPackage(), new RNUxcamPackage(), new RNCWebViewPackage(), new RNFetchBlobPackage()}));
    }
}
