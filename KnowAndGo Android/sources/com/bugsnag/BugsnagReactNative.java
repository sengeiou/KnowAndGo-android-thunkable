package com.bugsnag;

import android.content.Context;
import com.bugsnag.android.BreadcrumbType;
import com.bugsnag.android.Bugsnag;
import com.bugsnag.android.Client;
import com.bugsnag.android.Configuration;
import com.bugsnag.android.InternalHooks;
import com.bugsnag.android.JavaScriptException;
import com.bugsnag.android.Notifier;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class BugsnagReactNative extends ReactContextBaseJavaModule {
    public static final Logger logger = Logger.getLogger("bugsnag-react-native");
    private String bugsnagAndroidVersion = null;
    private String libraryVersion = null;
    private ReactContext reactContext;

    public String getName() {
        return "BugsnagReactNative";
    }

    public static ReactPackage getPackage() {
        return new BugsnagPackage();
    }

    public static Client start(Context context) {
        Client init = Bugsnag.init(context);
        init.setAutoCaptureSessions(false);
        return init;
    }

    public static Client startWithApiKey(Context context, String str) {
        Client init = Bugsnag.init(context, str);
        init.setAutoCaptureSessions(false);
        return init;
    }

    public static Client startWithConfiguration(Context context, Configuration configuration) {
        configuration.setAutoCaptureSessions(false);
        return Bugsnag.init(context, configuration);
    }

    public BugsnagReactNative(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @ReactMethod
    public void startSession() {
        Bugsnag.startSession();
    }

    @ReactMethod
    public void stopSession() {
        Bugsnag.stopSession();
    }

    @ReactMethod
    public void resumeSession() {
        Bugsnag.resumeSession();
    }

    @ReactMethod
    public void startWithOptions(ReadableMap readableMap) {
        Client client = getClient(readableMap.hasKey("apiKey") ? readableMap.getString("apiKey") : null);
        this.libraryVersion = readableMap.getString("version");
        this.bugsnagAndroidVersion = Notifier.getInstance().getVersion();
        configureRuntimeOptions(client, readableMap);
        InternalHooks.configureClient(client);
        logger.info(String.format("Initialized Bugsnag React Native %s/Android %s", new Object[]{this.libraryVersion, this.bugsnagAndroidVersion}));
    }

    @ReactMethod
    public void leaveBreadcrumb(ReadableMap readableMap) {
        Bugsnag.leaveBreadcrumb(readableMap.getString("name"), parseBreadcrumbType(readableMap.getString("type")), readStringMap(readableMap.getMap(TtmlNode.TAG_METADATA)));
    }

    @ReactMethod
    public void notify(ReadableMap readableMap, Promise promise) {
        if (!readableMap.hasKey("errorClass")) {
            logger.warning("Bugsnag could not notify: No error class");
        } else if (!readableMap.hasKey("stacktrace")) {
            logger.warning("Bugsnag could not notify: No stacktrace");
        } else {
            String string = readableMap.getString("errorClass");
            String string2 = readableMap.getString("errorMessage");
            String string3 = readableMap.getString("stacktrace");
            boolean z = false;
            logger.info(String.format("Sending exception: %s - %s %s\n", new Object[]{string, string2, string3}));
            JavaScriptException javaScriptException = new JavaScriptException(string, string2, string3);
            DiagnosticsCallback diagnosticsCallback = new DiagnosticsCallback(this.libraryVersion, this.bugsnagAndroidVersion, readableMap);
            HashMap hashMap = new HashMap();
            String string4 = readableMap.getString("severity");
            String string5 = readableMap.getString("severityReason");
            hashMap.put("severity", string4);
            hashMap.put("severityReason", string5);
            if (readableMap.hasKey("blocking") && readableMap.getBoolean("blocking")) {
                z = true;
            }
            Bugsnag.internalClientNotify(javaScriptException, hashMap, z, diagnosticsCallback);
            if (promise != null) {
                promise.resolve((Object) null);
            }
        }
    }

    @ReactMethod
    public void setUser(ReadableMap readableMap) {
        String str = null;
        String string = readableMap.hasKey("id") ? readableMap.getString("id") : null;
        String string2 = readableMap.hasKey("email") ? readableMap.getString("email") : null;
        if (readableMap.hasKey("name")) {
            str = readableMap.getString("name");
        }
        Bugsnag.setUser(string, string2, str);
    }

    @ReactMethod
    public void clearUser() {
        Bugsnag.clearUser();
    }

    private Map<String, String> readStringMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            ReadableMap map = readableMap.getMap(nextKey);
            String string = map.getString("type");
            char c = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1034364087) {
                if (hashCode != -891985903) {
                    if (hashCode != 107868) {
                        if (hashCode == 64711720 && string.equals("boolean")) {
                            c = 0;
                        }
                    } else if (string.equals("map")) {
                        c = 3;
                    }
                } else if (string.equals("string")) {
                    c = 2;
                }
            } else if (string.equals("number")) {
                c = 1;
            }
            switch (c) {
                case 0:
                    hashMap.put(nextKey, String.valueOf(map.getBoolean("value")));
                    break;
                case 1:
                    hashMap.put(nextKey, String.valueOf(map.getDouble("value")));
                    break;
                case 2:
                    hashMap.put(nextKey, map.getString("value"));
                    break;
                case 3:
                    hashMap.put(nextKey, String.valueOf(readStringMap(map.getMap("value"))));
                    break;
            }
        }
        return hashMap;
    }

    private Client getClient(String str) {
        try {
            return Bugsnag.getClient();
        } catch (IllegalStateException unused) {
            if (str != null) {
                return Bugsnag.init((Context) this.reactContext, str);
            }
            return Bugsnag.init(this.reactContext);
        }
    }

    private BreadcrumbType parseBreadcrumbType(String str) {
        for (BreadcrumbType breadcrumbType : BreadcrumbType.values()) {
            if (breadcrumbType.toString().equals(str)) {
                return breadcrumbType;
            }
        }
        return BreadcrumbType.MANUAL;
    }

    private void configureRuntimeOptions(Client client, ReadableMap readableMap) {
        ReadableArray array;
        String string;
        String string2;
        String string3;
        client.setIgnoreClasses("com.facebook.react.common.JavascriptException");
        Configuration config = client.getConfig();
        if (readableMap.hasKey("appVersion") && (string3 = readableMap.getString("appVersion")) != null && string3.length() > 0) {
            client.setAppVersion(string3);
        }
        String str = null;
        String string4 = readableMap.hasKey("endpoint") ? readableMap.getString("endpoint") : null;
        if (readableMap.hasKey("sessionsEndpoint")) {
            str = readableMap.getString("sessionsEndpoint");
        }
        if (string4 != null && string4.length() > 0) {
            config.setEndpoints(string4, str);
        } else if (str != null && str.length() > 0) {
            logger.warning("The session tracking endpoint should not be set without the error reporting endpoint.");
        }
        if (readableMap.hasKey("releaseStage") && (string2 = readableMap.getString("releaseStage")) != null && string2.length() > 0) {
            client.setReleaseStage(string2);
        }
        if (readableMap.hasKey("autoNotify")) {
            if (readableMap.getBoolean("autoNotify")) {
                client.enableExceptionHandler();
            } else {
                client.disableExceptionHandler();
            }
        }
        if (readableMap.hasKey("codeBundleId") && (string = readableMap.getString("codeBundleId")) != null && string.length() > 0) {
            client.addToTab("app", "codeBundleId", string);
        }
        if (readableMap.hasKey("notifyReleaseStages") && (array = readableMap.getArray("notifyReleaseStages")) != null && array.size() > 0) {
            String[] strArr = new String[array.size()];
            for (int i = 0; i < array.size(); i++) {
                strArr[i] = array.getString(i);
            }
            client.setNotifyReleaseStages(strArr);
        }
        if (readableMap.hasKey("automaticallyCollectBreadcrumbs")) {
            config.setAutomaticallyCollectBreadcrumbs(readableMap.getBoolean("automaticallyCollectBreadcrumbs"));
        }
        if (readableMap.hasKey("autoCaptureSessions")) {
            boolean z = readableMap.getBoolean("autoCaptureSessions");
            config.setAutoCaptureSessions(z);
            if (z) {
                client.resumeSession();
            }
        }
    }
}
