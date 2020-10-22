package com.uxcam;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.SupportMapFragment;
import com.uxcam.internals.C2928ab;
import com.uxcam.internals.C2952an;
import com.uxcam.internals.C3183fy;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class UXCam {
    public static void addScreenNameToIgnore(String str) {
        C2928ab.m1132d(str);
    }

    public static void addScreenNamesToIgnore(List list) {
        C2928ab.m1117a(list);
    }

    @Deprecated
    public static void addTagWithProperties(String str) {
        logEvent(str);
    }

    @Deprecated
    public static void addTagWithProperties(String str, Map map) {
        logEvent(str, map);
    }

    @Deprecated
    public static void addTagWithProperties(String str, JSONObject jSONObject) {
        logEvent(str, jSONObject);
    }

    public static void addVerificationListener(OnVerificationListener onVerificationListener) {
        try {
            C2928ab.m1105a().mo37988a(onVerificationListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void allowShortBreakForAnotherApp() {
        C2928ab.m1136e(true);
    }

    public static void allowShortBreakForAnotherApp(int i) {
        C2928ab.m1106a(i);
    }

    public static void allowShortBreakForAnotherApp(boolean z) {
        C2928ab.m1136e(z);
    }

    public static void attachUnsupportedView(MapFragment mapFragment) {
        C2928ab.m1111a(mapFragment);
    }

    public static void attachUnsupportedView(MapView mapView) {
        C2928ab.m1112a(mapView);
    }

    public static void attachUnsupportedView(SupportMapFragment supportMapFragment) {
        C2928ab.m1113a(supportMapFragment);
    }

    public static void attachWebviewInterface(WebView webView) {
        C2928ab.m1110a(webView);
    }

    public static void cancelCurrentSession() {
        C2952an.f1333q = true;
        stopSessionAndUploadData();
    }

    @Deprecated
    public static void cancelRecording() {
        cancelCurrentSession();
    }

    public static void deletePendingUploads() {
        C2928ab.m1149o();
    }

    public static boolean getMultiSessionRecord() {
        return C2928ab.f1217g;
    }

    @Deprecated
    public static void identify(String str) {
        C2928ab.m1105a().mo37991c(str);
    }

    @Deprecated
    public static void ignoreRecording() {
        cancelCurrentSession();
    }

    public static boolean isRecording() {
        try {
            return C2928ab.m1144j();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void logEvent(String str) {
        try {
            C2928ab.m1116a(str, (Map) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logEvent(String str, Map map) {
        try {
            C2928ab.m1116a(str, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void logEvent(String str, JSONObject jSONObject) {
        try {
            C2928ab.m1116a(str, C3183fy.m2033a(jSONObject));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void markSessionAsFavorite() {
        setSessionProperty("kUXCam_isFavourite", "true");
    }

    public static void occludeAllTextFields(boolean z) {
        C2928ab.m1127b(z);
    }

    @Deprecated
    public static void occludeAllTextView() {
        occludeAllTextFields(true);
    }

    public static void occludeRectsOnNextFrame(JSONArray jSONArray) {
        C2928ab.m1118a(jSONArray);
    }

    public static void occludeSensitiveScreen(boolean z) {
        try {
            C2928ab.m1119a(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void occludeSensitiveScreen(boolean z, boolean z2) {
        try {
            C2928ab.m1121a(z, z2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void occludeSensitiveView(View view) {
        try {
            C2928ab.m1109a(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void occludeSensitiveViewWithoutGesture(View view) {
        try {
            C2928ab.m1123b(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void optIn() {
        optInOverall();
    }

    public static void optInOverall() {
        C2928ab.m1133d(false);
        C2928ab.f1218h = true;
    }

    public static boolean optInOverallStatus() {
        return C2928ab.m1148n();
    }

    @Deprecated
    public static boolean optInStatus() {
        return optInOverallStatus();
    }

    public static boolean optInVideoRecordingStatus() {
        return C2928ab.m1147m();
    }

    public static void optIntoVideoRecording() {
        C2928ab.m1145k();
    }

    @Deprecated
    public static void optOut() {
        optOutOverall();
    }

    public static void optOutOfVideoRecording() {
        C2928ab.m1146l();
    }

    public static void optOutOverall() {
        C2928ab.m1133d(true);
        C2928ab.f1218h = false;
    }

    @Deprecated
    public static boolean optStatus() {
        return optInStatus();
    }

    @Deprecated
    public static void pause() {
        pauseScreenRecording();
    }

    public static void pauseScreenRecording() {
        try {
            occludeSensitiveScreen(true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static int pendingSessionCount() {
        return pendingUploads();
    }

    public static int pendingUploads() {
        return C3183fy.m2056i();
    }

    public static void pluginType(String str, String str2) {
        C2928ab.m1125b(str, str2);
    }

    public static void removeAllScreenNamesToIgnore() {
        C2928ab.m1151q();
    }

    public static void removeScreenNameToIgnore(String str) {
        C2928ab.m1135e(str);
    }

    public static void removeScreenNamesToIgnore(List list) {
        C2928ab.m1126b(list);
    }

    public static void removeVerificationListener(OnVerificationListener onVerificationListener) {
        try {
            C2928ab.m1105a().f1233f.remove(onVerificationListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void resume() {
        resumeScreenRecording();
    }

    public static void resumeScreenRecording() {
        try {
            occludeSensitiveScreen(false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void resumeShortBreakForAnotherApp() {
        C2928ab.m1150p();
    }

    public static List screenNamesBeingIgnored() {
        return C2928ab.m1152r();
    }

    public static void setAutomaticScreenNameTagging(boolean z) {
        try {
            C2928ab.m1130c(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMultiSessionRecord(boolean z) {
        C2928ab.f1217g = z;
    }

    public static void setPushNotificationToken(String str) {
        C2928ab.m1138f(str);
    }

    public static void setSessionProperty(String str, float f) {
        C2928ab.m1105a().mo37990b(str, (Object) Float.valueOf(f));
    }

    public static void setSessionProperty(String str, int i) {
        C2928ab.m1105a().mo37990b(str, (Object) Integer.valueOf(i));
    }

    public static void setSessionProperty(String str, String str2) {
        C2928ab.m1105a().mo37990b(str, (Object) str2);
    }

    public static void setSessionProperty(String str, boolean z) {
        C2928ab.m1105a().mo37990b(str, (Object) Boolean.valueOf(z));
    }

    public static void setUserIdentity(String str) {
        C2928ab.m1105a().mo37991c(str);
    }

    public static void setUserProperty(String str, float f) {
        C2928ab.m1105a().mo37989a(str, (Object) Float.valueOf(f));
    }

    public static void setUserProperty(String str, int i) {
        C2928ab.m1105a().mo37989a(str, (Object) Integer.valueOf(i));
    }

    public static void setUserProperty(String str, String str2) {
        C2928ab.m1105a().mo37989a(str, (Object) str2);
    }

    public static void setUserProperty(String str, boolean z) {
        C2928ab.m1105a().mo37989a(str, (Object) Boolean.valueOf(z));
    }

    public static void startApplicationWithKeyForCordova(Activity activity, String str) {
        try {
            C2928ab.m1107a(activity, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void startApplicationWithKeyForCordova(Activity activity, String str, String str2) {
        try {
            C2952an.f1320d = str2;
            C2928ab.m1107a(activity, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startNewSession() {
        C2928ab.m1128c();
    }

    public static void startWithKey(String str) {
        try {
            C2928ab.m1114a(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void startWithKey(String str, OnVerificationListener onVerificationListener) {
        try {
            C2928ab.m1114a(str);
            C2928ab.m1105a().mo37988a(onVerificationListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void startWithKey(String str, String str2) {
        try {
            C2928ab.m1115a(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void startWithKey(String str, String str2, OnVerificationListener onVerificationListener) {
        try {
            C2928ab.m1115a(str, str2);
            C2928ab.m1105a().mo37988a(onVerificationListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void startWithKeyForAppcelerator(Activity activity, String str) {
        try {
            C2928ab.m1107a(activity, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void startWithKeyForAppcelerator(Activity activity, String str, String str2) {
        try {
            C2952an.f1320d = str2;
            C2928ab.m1107a(activity, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void stopApplicationAndUploadData() {
        try {
            stopSessionAndUploadData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopSessionAndUploadData() {
        try {
            C2928ab.m1134e();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void tagScreenName(String str) {
        try {
            C2928ab.m1124b(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public static void tagUsersName(String str) {
        identify(str);
    }

    public static void unOccludeSensitiveView(View view) {
        try {
            C2928ab.m1129c(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String urlForCurrentSession() {
        try {
            return C2928ab.m1142h();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String urlForCurrentUser() {
        try {
            return C2928ab.m1143i();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
