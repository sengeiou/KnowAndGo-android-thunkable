package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.Nullable;

@TargetApi(19)
public final class zzced {
    @Nullable
    private PopupWindow zzftr;
    @Nullable
    private Context zzlj;

    public final void zza(Context context, View view) {
        if (PlatformVersion.isAtLeastKitKat() && !PlatformVersion.isAtLeastLollipop()) {
            this.zzftr = zzb(context, view);
            if (this.zzftr == null) {
                context = null;
            }
            this.zzlj = context;
        }
    }

    public final void zzajo() {
        if (this.zzlj != null && this.zzftr != null) {
            if (!(this.zzlj instanceof Activity) || !((Activity) this.zzlj).isDestroyed()) {
                if (this.zzftr.isShowing()) {
                    this.zzftr.dismiss();
                }
                this.zzlj = null;
                this.zzftr = null;
                return;
            }
            this.zzlj = null;
            this.zzftr = null;
        }
    }

    private static PopupWindow zzb(Context context, View view) {
        Window window = context instanceof Activity ? ((Activity) context).getWindow() : null;
        if (window == null || window.getDecorView() == null || ((Activity) context).isDestroyed()) {
            return null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.addView(view, -1, -1);
        PopupWindow popupWindow = new PopupWindow(frameLayout, 1, 1, false);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setClippingEnabled(false);
        zzawz.zzdp("Displaying the 1x1 popup off the screen.");
        try {
            popupWindow.showAtLocation(window.getDecorView(), 0, -1, -1);
            return popupWindow;
        } catch (Exception unused) {
            return null;
        }
    }
}
