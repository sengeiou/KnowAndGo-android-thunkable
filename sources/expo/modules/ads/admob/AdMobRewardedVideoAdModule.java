package expo.modules.ads.admob;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.arguments.ReadableArguments;
import org.unimodules.core.interfaces.ActivityProvider;
import org.unimodules.core.interfaces.ExpoMethod;
import org.unimodules.core.interfaces.services.EventEmitter;

public class AdMobRewardedVideoAdModule extends ExportedModule implements RewardedVideoAdListener {
    /* access modifiers changed from: private */
    public ActivityProvider mActivityProvider;
    /* access modifiers changed from: private */
    public String mAdUnitID;
    private EventEmitter mEventEmitter;
    /* access modifiers changed from: private */
    public Promise mRequestAdPromise;
    /* access modifiers changed from: private */
    public RewardedVideoAd mRewardedVideoAd;
    /* access modifiers changed from: private */
    public Promise mShowAdPromise;

    public String getName() {
        return "ExpoAdsAdMobRewardedVideoAdManager";
    }

    public enum Events {
        DID_REWARD("rewardedVideoDidRewardUser"),
        DID_LOAD("rewardedVideoDidLoad"),
        DID_FAIL_TO_LOAD("rewardedVideoDidFailToLoad"),
        DID_OPEN("rewardedVideoDidOpen"),
        DID_START("rewardedVideoDidStart"),
        DID_COMPLETE("rewardedVideoDidComplete"),
        DID_CLOSE("rewardedVideoDidClose"),
        WILL_LEAVE_APPLICATION("rewardedVideoWillLeaveApplication");
        
        private final String mName;

        private Events(String str) {
            this.mName = str;
        }

        public String toString() {
            return this.mName;
        }
    }

    public AdMobRewardedVideoAdModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mEventEmitter = (EventEmitter) moduleRegistry.getModule(EventEmitter.class);
        this.mActivityProvider = (ActivityProvider) moduleRegistry.getModule(ActivityProvider.class);
    }

    public void onRewarded(RewardItem rewardItem) {
        Bundle bundle = new Bundle();
        bundle.putInt("amount", rewardItem.getAmount());
        bundle.putString("type", rewardItem.getType());
        sendEvent(Events.DID_REWARD.toString(), bundle);
    }

    public void onRewardedVideoAdLoaded() {
        sendEvent(Events.DID_LOAD.toString(), new Bundle());
        this.mRequestAdPromise.resolve((Object) null);
    }

    public void onRewardedVideoAdOpened() {
        sendEvent(Events.DID_OPEN.toString(), new Bundle());
    }

    public void onRewardedVideoStarted() {
        sendEvent(Events.DID_START.toString(), new Bundle());
    }

    public void onRewardedVideoAdClosed() {
        sendEvent(Events.DID_CLOSE.toString(), new Bundle());
    }

    public void onRewardedVideoAdLeftApplication() {
        sendEvent(Events.WILL_LEAVE_APPLICATION.toString(), new Bundle());
    }

    public void onRewardedVideoCompleted() {
        sendEvent(Events.DID_COMPLETE.toString(), new Bundle());
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
        sendEvent(Events.DID_FAIL_TO_LOAD.toString(), AdMobUtils.createEventForAdFailedToLoad(i));
        this.mRequestAdPromise.reject("E_AD_REQUEST_FAILED", AdMobUtils.errorStringForAdFailedCode(i), (Throwable) null);
    }

    private void sendEvent(String str, Bundle bundle) {
        this.mEventEmitter.emit(str, bundle);
    }

    @ExpoMethod
    public void setAdUnitID(String str, Promise promise) {
        this.mAdUnitID = str;
        promise.resolve((Object) null);
    }

    @ExpoMethod
    public void requestAd(final ReadableArguments readableArguments, final Promise promise) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                RewardedVideoAd unused = AdMobRewardedVideoAdModule.this.mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(AdMobRewardedVideoAdModule.this.mActivityProvider.getCurrentActivity());
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.setRewardedVideoAdListener(AdMobRewardedVideoAdModule.this);
                if (AdMobRewardedVideoAdModule.this.mRewardedVideoAd.isLoaded()) {
                    promise.reject("E_AD_ALREADY_LOADED", "Ad is already loaded.", (Throwable) null);
                    return;
                }
                Promise unused2 = AdMobRewardedVideoAdModule.this.mRequestAdPromise = promise;
                AdRequest.Builder addNetworkExtrasBundle = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, readableArguments.toBundle());
                String testDeviceID = AdMobModule.getTestDeviceID();
                if (testDeviceID != null) {
                    addNetworkExtrasBundle = addNetworkExtrasBundle.addTestDevice(testDeviceID);
                }
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.loadAd(AdMobRewardedVideoAdModule.this.mAdUnitID, addNetworkExtrasBundle.build());
            }
        });
    }

    @ExpoMethod
    public void showAd(final Promise promise) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                if (AdMobRewardedVideoAdModule.this.mRewardedVideoAd == null || !AdMobRewardedVideoAdModule.this.mRewardedVideoAd.isLoaded()) {
                    promise.reject("E_AD_NOT_READY", "Ad is not ready.", (Throwable) null);
                    return;
                }
                Promise unused = AdMobRewardedVideoAdModule.this.mShowAdPromise = promise;
                AdMobRewardedVideoAdModule.this.mRewardedVideoAd.show();
            }
        });
    }

    @ExpoMethod
    public void getIsReady(final Promise promise) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                promise.resolve(Boolean.valueOf(AdMobRewardedVideoAdModule.this.mRewardedVideoAd != null && AdMobRewardedVideoAdModule.this.mRewardedVideoAd.isLoaded()));
            }
        });
    }
}
