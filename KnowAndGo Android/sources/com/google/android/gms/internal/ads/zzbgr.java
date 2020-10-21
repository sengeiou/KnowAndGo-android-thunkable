package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.p002v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import org.apache.logging.log4j.message.ParameterizedMessage;

@TargetApi(11)
@zzard
public final class zzbgr extends WebChromeClient {
    private final zzbgz zzdbs;

    public zzbgr(zzbgz zzbgz) {
        this.zzdbs = zzbgz;
    }

    private final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzb zzaax;
        try {
            if (this.zzdbs == null || this.zzdbs.zzaai() == null || this.zzdbs.zzaai().zzaax() == null || (zzaax = this.zzdbs.zzaai().zzaax()) == null || zzaax.zzkx()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzbgx(jsPromptResult, editText)).setNegativeButton(17039360, new zzbgw(jsPromptResult)).setOnCancelListener(new zzbgv(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzbgu(jsResult)).setNegativeButton(17039360, new zzbgt(jsResult)).setOnCancelListener(new zzbgs(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(str3).length());
            sb.append("window.");
            sb.append(str);
            sb.append("('");
            sb.append(str3);
            sb.append("')");
            zzaax.zzbk(sb.toString());
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzawz.zzd("Fail to display Dialog.", e);
        }
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zzdbs.zzaaj() != null) {
            webView2.setWebViewClient(this.zzdbs.zzaaj());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            zzawz.zzep("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzd zzaae = ((zzbgz) webView).zzaae();
        if (zzaae == null) {
            zzawz.zzep("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzaae.close();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb.append("JS: ");
        sb.append(message);
        sb.append(" (");
        sb.append(sourceId);
        sb.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        sb.append(lineNumber);
        sb.append(")");
        String sb2 = sb.toString();
        if (sb2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        switch (zzbgy.zzeja[consoleMessage.messageLevel().ordinal()]) {
            case 1:
                zzawz.zzen(sb2);
                break;
            case 2:
                zzawz.zzep(sb2);
                break;
            case 3:
            case 4:
                zzawz.zzeo(sb2);
                break;
            case 5:
                zzawz.zzdp(sb2);
                break;
            default:
                zzawz.zzeo(sb2);
                break;
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = 5242880 - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j != 0) {
            if (j2 == 0) {
                j = Math.min(j + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), 1048576);
            } else if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        } else if (j2 > j4 || j2 > 1048576) {
            j2 = 0;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onHideCustomView() {
        zzd zzaae = this.zzdbs.zzaae();
        if (zzaae == null) {
            zzawz.zzep("Could not get ad overlay when hiding custom view.");
        } else {
            zzaae.zzte();
        }
    }

    private static Context zza(WebView webView) {
        if (!(webView instanceof zzbgz)) {
            return webView.getContext();
        }
        zzbgz zzbgz = (zzbgz) webView;
        Activity zzyd = zzbgz.zzyd();
        if (zzyd != null) {
            return zzyd;
        }
        return zzbgz.getContext();
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zza(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zza(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j, long j2, WebStorage.QuotaUpdater quotaUpdater) {
        long j3 = j + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (5242880 - j2 < j3) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j3);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        zzd zzaae = this.zzdbs.zzaae();
        if (zzaae == null) {
            zzawz.zzep("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzaae.zza(view, customViewCallback);
        zzaae.setRequestedOrientation(i);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzk.zzlg();
            if (!zzaxi.zzp(this.zzdbs.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzk.zzlg();
                if (!zzaxi.zzp(this.zzdbs.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    @TargetApi(21)
    public final void onPermissionRequest(PermissionRequest permissionRequest) {
        if (PlatformVersion.isAtLeastLollipop()) {
            if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcol)).booleanValue()) {
                if (this.zzdbs == null || this.zzdbs.zzaai() == null || this.zzdbs.zzaai().zzabj() == null) {
                    super.onPermissionRequest(permissionRequest);
                    return;
                }
                String[] zza = this.zzdbs.zzaai().zzabj().zza(permissionRequest.getResources());
                if (zza.length > 0) {
                    permissionRequest.grant(zza);
                    return;
                } else {
                    permissionRequest.deny();
                    return;
                }
            }
        }
        super.onPermissionRequest(permissionRequest);
    }
}
