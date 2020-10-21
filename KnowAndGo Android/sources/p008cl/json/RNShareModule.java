package p008cl.json;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import p008cl.json.social.EmailShare;
import p008cl.json.social.FacebookPagesManagerShare;
import p008cl.json.social.FacebookShare;
import p008cl.json.social.GenericShare;
import p008cl.json.social.GooglePlusShare;
import p008cl.json.social.InstagramShare;
import p008cl.json.social.LinkedinShare;
import p008cl.json.social.MessengerShare;
import p008cl.json.social.PinterestShare;
import p008cl.json.social.SMSShare;
import p008cl.json.social.ShareIntent;
import p008cl.json.social.SnapChatShare;
import p008cl.json.social.TargetChosenReceiver;
import p008cl.json.social.TwitterShare;
import p008cl.json.social.WhatsAppShare;

/* renamed from: cl.json.RNShareModule */
public class RNShareModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    public static final int SHARE_REQUEST_CODE = 16845;
    private final ReactApplicationContext reactContext;

    public String getName() {
        return "RNShare";
    }

    public void onNewIntent(Intent intent) {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 16845 && i2 == 0) {
            TargetChosenReceiver.sendCallback(true, false, "CANCELED");
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
    }

    /* renamed from: cl.json.RNShareModule$SHARES */
    private enum SHARES {
        facebook,
        generic,
        pagesmanager,
        twitter,
        whatsapp,
        instagram,
        googleplus,
        email,
        pinterest,
        messenger,
        snapchat,
        sms,
        linkedin;

        public static ShareIntent getShareClass(String str, ReactApplicationContext reactApplicationContext) {
            switch (valueOf(str)) {
                case generic:
                    return new GenericShare(reactApplicationContext);
                case facebook:
                    return new FacebookShare(reactApplicationContext);
                case pagesmanager:
                    return new FacebookPagesManagerShare(reactApplicationContext);
                case twitter:
                    return new TwitterShare(reactApplicationContext);
                case whatsapp:
                    return new WhatsAppShare(reactApplicationContext);
                case instagram:
                    return new InstagramShare(reactApplicationContext);
                case googleplus:
                    return new GooglePlusShare(reactApplicationContext);
                case email:
                    return new EmailShare(reactApplicationContext);
                case pinterest:
                    return new PinterestShare(reactApplicationContext);
                case sms:
                    return new SMSShare(reactApplicationContext);
                case snapchat:
                    return new SnapChatShare(reactApplicationContext);
                case messenger:
                    return new MessengerShare(reactApplicationContext);
                case linkedin:
                    return new LinkedinShare(reactApplicationContext);
                default:
                    return null;
            }
        }
    }

    public RNShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
        this.reactContext = reactApplicationContext;
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        for (SHARES shares : SHARES.values()) {
            hashMap.put(shares.toString().toUpperCase(), shares.toString());
        }
        return hashMap;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, @androidx.annotation.Nullable Callback callback, @androidx.annotation.Nullable Callback callback2) {
        TargetChosenReceiver.registerCallbacks(callback2, callback);
        try {
            new GenericShare(this.reactContext).open(readableMap);
        } catch (ActivityNotFoundException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            TargetChosenReceiver.sendCallback(false, "not_available");
        } catch (Exception e2) {
            System.out.println("ERROR");
            System.out.println(e2.getMessage());
            TargetChosenReceiver.sendCallback(false, e2.getMessage());
        }
    }

    @ReactMethod
    public void shareSingle(ReadableMap readableMap, @androidx.annotation.Nullable Callback callback, @androidx.annotation.Nullable Callback callback2) {
        System.out.println("SHARE SINGLE METHOD");
        TargetChosenReceiver.registerCallbacks(callback2, callback);
        if (ShareIntent.hasValidKey(NotificationCompat.CATEGORY_SOCIAL, readableMap)) {
            try {
                ShareIntent shareClass = SHARES.getShareClass(readableMap.getString(NotificationCompat.CATEGORY_SOCIAL), this.reactContext);
                if (shareClass == null || !(shareClass instanceof ShareIntent)) {
                    throw new ActivityNotFoundException("Invalid share activity");
                }
                shareClass.open(readableMap);
            } catch (ActivityNotFoundException e) {
                System.out.println("ERROR");
                System.out.println(e.getMessage());
                TargetChosenReceiver.sendCallback(false, e.getMessage());
            } catch (Exception e2) {
                System.out.println("ERROR");
                System.out.println(e2.getMessage());
                TargetChosenReceiver.sendCallback(false, e2.getMessage());
            }
        } else {
            TargetChosenReceiver.sendCallback(false, "key 'social' missing in options");
        }
    }

    @ReactMethod
    public void isPackageInstalled(String str, @androidx.annotation.Nullable Callback callback, @androidx.annotation.Nullable Callback callback2) {
        try {
            callback2.invoke(Boolean.valueOf(ShareIntent.isPackageInstalled(str, this.reactContext)));
        } catch (Exception e) {
            PrintStream printStream = System.out;
            printStream.println("Error: " + e.getMessage());
            callback.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void isBase64File(String str, @androidx.annotation.Nullable Callback callback, @androidx.annotation.Nullable Callback callback2) {
        try {
            String scheme = Uri.parse(str).getScheme();
            if (scheme == null || !scheme.equals("data")) {
                callback2.invoke(false);
                return;
            }
            callback2.invoke(true);
        } catch (Exception e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
            callback.invoke(e.getMessage());
        }
    }
}
