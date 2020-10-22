package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.Nullable;
import java.util.List;

/* renamed from: com.uxcam.internals.ag */
public class C2942ag implements Window.Callback {

    /* renamed from: a */
    Window.Callback f1259a;

    public C2942ag(Window.Callback callback) {
        this.f1259a = callback;
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.f1259a.dispatchGenericMotionEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        try {
            if (keyEvent.getAction() == 1) {
                keyEvent.getKeyCode();
            }
        } catch (Exception unused) {
            try {
                C2970bc.m1233a("UXWindowCallback");
            } catch (Exception unused2) {
                C2970bc.m1233a("UXWindowCallback");
                return false;
            }
        }
        if (this.f1259a != null) {
            return this.f1259a.dispatchKeyEvent(keyEvent);
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        return this.f1259a.dispatchKeyShortcutEvent(keyEvent);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.f1259a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        try {
            if (C2928ab.m1137f() != null) {
                C2928ab.m1137f().mo38010a(motionEvent);
            }
        } catch (Exception unused) {
            C2970bc.m1233a("UXWindowCallback");
        }
        try {
            z = this.f1259a.dispatchTouchEvent(motionEvent);
        } catch (Exception unused2) {
            C2970bc.m1233a("UXWindowCallback");
            z = false;
        }
        C3166fl.f2274a = z;
        return z;
    }

    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.f1259a.dispatchTrackballEvent(motionEvent);
    }

    @SuppressLint({"NewApi"})
    public void onActionModeFinished(ActionMode actionMode) {
        this.f1259a.onActionModeFinished(actionMode);
    }

    @SuppressLint({"NewApi"})
    public void onActionModeStarted(ActionMode actionMode) {
        this.f1259a.onActionModeStarted(actionMode);
    }

    public void onAttachedToWindow() {
        this.f1259a.onAttachedToWindow();
    }

    public void onContentChanged() {
        this.f1259a.onContentChanged();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        return this.f1259a.onCreatePanelMenu(i, menu);
    }

    public View onCreatePanelView(int i) {
        return this.f1259a.onCreatePanelView(i);
    }

    public void onDetachedFromWindow() {
        this.f1259a.onDetachedFromWindow();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        try {
            return this.f1259a.onMenuItemSelected(i, menuItem);
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return this.f1259a.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        this.f1259a.onPanelClosed(i, menu);
    }

    public void onPointerCaptureChanged(boolean z) {
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        return this.f1259a.onPreparePanel(i, view, menu);
    }

    public void onProvideKeyboardShortcuts(List list, @Nullable Menu menu, int i) {
    }

    public boolean onSearchRequested() {
        return this.f1259a.onSearchRequested();
    }

    public boolean onSearchRequested(SearchEvent searchEvent) {
        return false;
    }

    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.f1259a.onWindowAttributesChanged(layoutParams);
    }

    public void onWindowFocusChanged(boolean z) {
        this.f1259a.onWindowFocusChanged(z);
    }

    @TargetApi(11)
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return this.f1259a.onWindowStartingActionMode(callback);
    }

    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        return null;
    }
}
