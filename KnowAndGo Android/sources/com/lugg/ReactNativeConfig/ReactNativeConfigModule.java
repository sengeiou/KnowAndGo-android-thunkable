package com.lugg.ReactNativeConfig;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class ReactNativeConfigModule extends ReactContextBaseJavaModule {
    public String getName() {
        return "ReactNativeConfigModule";
    }

    public ReactNativeConfigModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:5|6) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r1 = getReactApplicationContext().getApplicationContext().getPackageName();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, java.lang.Object> getConstants() {
        /*
            r8 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.facebook.react.bridge.ReactApplicationContext r1 = r8.getReactApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0073 }
            android.content.res.Resources r2 = r1.getResources()     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r3 = "build_config_package"
            java.lang.String r4 = "string"
            java.lang.String r5 = r1.getPackageName()     // Catch:{ ClassNotFoundException -> 0x0073 }
            int r2 = r2.getIdentifier(r3, r4, r5)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r1 = r1.getString(r2)     // Catch:{ NotFoundException -> 0x001e }
            goto L_0x002a
        L_0x001e:
            com.facebook.react.bridge.ReactApplicationContext r1 = r8.getReactApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0073 }
            android.content.Context r1 = r1.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ ClassNotFoundException -> 0x0073 }
        L_0x002a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0073 }
            r2.<init>()     // Catch:{ ClassNotFoundException -> 0x0073 }
            r2.append(r1)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r1 = ".BuildConfig"
            r2.append(r1)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r1 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()     // Catch:{ ClassNotFoundException -> 0x0073 }
            int r2 = r1.length     // Catch:{ ClassNotFoundException -> 0x0073 }
            r3 = 0
        L_0x0045:
            if (r3 >= r2) goto L_0x007a
            r4 = r1[r3]     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r5 = r4.getName()     // Catch:{ IllegalAccessException -> 0x0056 }
            r6 = 0
            java.lang.Object r6 = r4.get(r6)     // Catch:{ IllegalAccessException -> 0x0056 }
            r0.put(r5, r6)     // Catch:{ IllegalAccessException -> 0x0056 }
            goto L_0x0070
        L_0x0056:
            java.lang.String r5 = "ReactNative"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0073 }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r7 = "ReactConfig: Could not access BuildConfig field "
            r6.append(r7)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x0073 }
            r6.append(r4)     // Catch:{ ClassNotFoundException -> 0x0073 }
            java.lang.String r4 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x0073 }
            android.util.Log.d(r5, r4)     // Catch:{ ClassNotFoundException -> 0x0073 }
        L_0x0070:
            int r3 = r3 + 1
            goto L_0x0045
        L_0x0073:
            java.lang.String r1 = "ReactNative"
            java.lang.String r2 = "ReactConfig: Could not find BuildConfig class"
            android.util.Log.d(r1, r2)
        L_0x007a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lugg.ReactNativeConfig.ReactNativeConfigModule.getConstants():java.util.Map");
    }
}
