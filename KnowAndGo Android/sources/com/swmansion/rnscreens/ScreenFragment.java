package com.swmansion.rnscreens;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerModule;

public class ScreenFragment extends Fragment {
    protected Screen mScreenView;

    protected static View recycleView(View view) {
        ViewParent parent = view.getParent();
        if (parent != null) {
            ViewGroup viewGroup = (ViewGroup) parent;
            viewGroup.endViewTransition(view);
            viewGroup.removeView(view);
        }
        view.setVisibility(0);
        return view;
    }

    public ScreenFragment() {
        throw new IllegalStateException("Screen fragments should never be restored");
    }

    @SuppressLint({"ValidFragment"})
    public ScreenFragment(Screen screen) {
        this.mScreenView = screen;
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mScreenView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        frameLayout.addView(recycleView(this.mScreenView));
        return frameLayout;
    }

    public Screen getScreen() {
        return this.mScreenView;
    }

    private void dispatchOnAppear() {
        ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenAppearEvent(this.mScreenView.getId()));
    }

    public void onViewAnimationEnd() {
        dispatchOnAppear();
    }

    public void onDestroy() {
        super.onDestroy();
        ScreenContainer container = this.mScreenView.getContainer();
        if (container == null || !container.hasScreen(this)) {
            ((UIManagerModule) ((ReactContext) this.mScreenView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ScreenDismissedEvent(this.mScreenView.getId()));
        }
    }
}
