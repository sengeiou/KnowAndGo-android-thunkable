package com.onesignal;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.onesignal.OneSignal;
import java.lang.ref.WeakReference;
import java.util.List;

class OSSystemConditionController {
    private static final String TAG = OSSystemConditionController.class.getCanonicalName();
    /* access modifiers changed from: private */
    public final OSSystemConditionObserver systemConditionObserver;

    interface OSSystemConditionObserver {
        void systemConditionChanged();
    }

    OSSystemConditionController(OSSystemConditionObserver oSSystemConditionObserver) {
        this.systemConditionObserver = oSSystemConditionObserver;
    }

    /* access modifiers changed from: package-private */
    public boolean systemConditionsAvailable() {
        if (ActivityLifecycleHandler.curActivity == null) {
            OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "OSSystemConditionObserver curActivity null");
            return false;
        }
        try {
            if (isDialogFragmentShowing(ActivityLifecycleHandler.curActivity)) {
                OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "OSSystemConditionObserver dialog fragment detected");
                return false;
            }
        } catch (NoClassDefFoundError e) {
            OneSignal.LOG_LEVEL log_level = OneSignal.LOG_LEVEL.INFO;
            OneSignal.onesignalLog(log_level, "AppCompatActivity is not used in this app, skipping 'isDialogFragmentShowing' check: " + e);
        }
        boolean isKeyboardUp = OSViewUtils.isKeyboardUp(new WeakReference(ActivityLifecycleHandler.curActivity));
        if (isKeyboardUp) {
            ActivityLifecycleHandler.setSystemConditionObserver(TAG, this.systemConditionObserver);
            OneSignal.onesignalLog(OneSignal.LOG_LEVEL.WARN, "OSSystemConditionObserver keyboard up detected");
        }
        return !isKeyboardUp;
    }

    /* access modifiers changed from: package-private */
    public boolean isDialogFragmentShowing(Context context) throws NoClassDefFoundError {
        if (context instanceof AppCompatActivity) {
            final FragmentManager supportFragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
            supportFragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
                public void onFragmentDetached(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment) {
                    super.onFragmentDetached(fragmentManager, fragment);
                    if (fragment instanceof DialogFragment) {
                        supportFragmentManager.unregisterFragmentLifecycleCallbacks(this);
                        OSSystemConditionController.this.systemConditionObserver.systemConditionChanged();
                    }
                }
            }, true);
            List<Fragment> fragments = supportFragmentManager.getFragments();
            int size = fragments.size();
            if (size > 0) {
                Fragment fragment = fragments.get(size - 1);
                if (!fragment.isVisible() || !(fragment instanceof DialogFragment)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
