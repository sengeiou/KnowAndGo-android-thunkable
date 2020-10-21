package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.views.text.ReactFontManager;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import java.util.ArrayList;

public class ScreenStackHeaderConfig extends ViewGroup {
    private boolean mBackButtonInCustomView;
    private View.OnClickListener mBackClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            ScreenStackFragment access$000 = ScreenStackHeaderConfig.this.getScreenFragment();
            if (access$000 != null) {
                ScreenStack access$100 = ScreenStackHeaderConfig.this.getScreenStack();
                if (access$100 == null || access$100.getRootScreen() != access$000.getScreen()) {
                    access$000.dismiss();
                    return;
                }
                Fragment parentFragment = access$000.getParentFragment();
                if (parentFragment instanceof ScreenStackFragment) {
                    ((ScreenStackFragment) parentFragment).dismiss();
                }
            }
        }
    };
    private int mBackgroundColor;
    private final ArrayList<ScreenStackHeaderSubview> mConfigSubviews = new ArrayList<>(3);
    private int mDefaultStartInset;
    private int mDefaultStartInsetWithNavigation;
    private boolean mDestroyed;
    private boolean mIsAttachedToWindow = false;
    private boolean mIsBackButtonHidden;
    private boolean mIsHidden;
    private boolean mIsShadowHidden;
    private boolean mIsTopInsetEnabled = true;
    private int mTintColor;
    private String mTitle;
    private int mTitleColor;
    private String mTitleFontFamily;
    private float mTitleFontSize;
    private final Toolbar mToolbar;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public ScreenStackHeaderConfig(Context context) {
        super(context);
        setVisibility(8);
        this.mToolbar = new Toolbar(context);
        this.mDefaultStartInset = this.mToolbar.getContentInsetStart();
        this.mDefaultStartInsetWithNavigation = this.mToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16843827, typedValue, true)) {
            this.mToolbar.setBackgroundColor(typedValue.data);
        }
    }

    public void destroy() {
        this.mDestroyed = true;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsAttachedToWindow = true;
        onUpdate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mIsAttachedToWindow = false;
    }

    private Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public ScreenStack getScreenStack() {
        Screen screen = getScreen();
        if (screen == null) {
            return null;
        }
        ScreenContainer container = screen.getContainer();
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    /* access modifiers changed from: private */
    public ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        ScreenFragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    public void onUpdate() {
        boolean z;
        AppCompatActivity appCompatActivity;
        Drawable navigationIcon;
        Screen screen = (Screen) getParent();
        ScreenStack screenStack = getScreenStack();
        if (screenStack == null || screenStack.getTopScreen() == screen) {
            z = true;
        } else {
            z = false;
        }
        if (this.mIsAttachedToWindow && z && !this.mDestroyed && (appCompatActivity = (AppCompatActivity) getScreenFragment().getActivity()) != null) {
            if (!this.mIsHidden) {
                if (this.mToolbar.getParent() == null) {
                    getScreenFragment().setToolbar(this.mToolbar);
                }
                if (this.mIsTopInsetEnabled) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        this.mToolbar.setPadding(0, getRootWindowInsets().getSystemWindowInsetTop(), 0, 0);
                    } else {
                        this.mToolbar.setPadding(0, (int) (getResources().getDisplayMetrics().density * 25.0f), 0, 0);
                    }
                } else if (this.mToolbar.getPaddingTop() > 0) {
                    this.mToolbar.setPadding(0, 0, 0, 0);
                }
                appCompatActivity.setSupportActionBar(this.mToolbar);
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                this.mToolbar.setContentInsetStartWithNavigation(this.mDefaultStartInsetWithNavigation);
                this.mToolbar.setContentInsetsRelative(this.mDefaultStartInset, this.mDefaultStartInset);
                supportActionBar.setDisplayHomeAsUpEnabled(getScreenFragment().canNavigateBack() && !this.mIsBackButtonHidden);
                this.mToolbar.setNavigationOnClickListener(this.mBackClickListener);
                getScreenFragment().setToolbarShadowHidden(this.mIsShadowHidden);
                supportActionBar.setTitle((CharSequence) this.mTitle);
                if (TextUtils.isEmpty(this.mTitle)) {
                    this.mToolbar.setContentInsetStartWithNavigation(0);
                }
                TextView titleTextView = getTitleTextView();
                if (this.mTitleColor != 0) {
                    this.mToolbar.setTitleTextColor(this.mTitleColor);
                }
                if (titleTextView != null) {
                    if (this.mTitleFontFamily != null) {
                        titleTextView.setTypeface(ReactFontManager.getInstance().getTypeface(this.mTitleFontFamily, 0, getContext().getAssets()));
                    }
                    if (this.mTitleFontSize > 0.0f) {
                        titleTextView.setTextSize(this.mTitleFontSize);
                    }
                }
                if (this.mBackgroundColor != 0) {
                    this.mToolbar.setBackgroundColor(this.mBackgroundColor);
                }
                if (!(this.mTintColor == 0 || (navigationIcon = this.mToolbar.getNavigationIcon()) == null)) {
                    navigationIcon.setColorFilter(this.mTintColor, PorterDuff.Mode.SRC_ATOP);
                }
                for (int childCount = this.mToolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                    if (this.mToolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                        this.mToolbar.removeViewAt(childCount);
                    }
                }
                int size = this.mConfigSubviews.size();
                for (int i = 0; i < size; i++) {
                    ScreenStackHeaderSubview screenStackHeaderSubview = this.mConfigSubviews.get(i);
                    ScreenStackHeaderSubview.Type type = screenStackHeaderSubview.getType();
                    if (type == ScreenStackHeaderSubview.Type.BACK) {
                        View childAt = screenStackHeaderSubview.getChildAt(0);
                        if (childAt instanceof ImageView) {
                            supportActionBar.setHomeAsUpIndicator(((ImageView) childAt).getDrawable());
                        } else {
                            throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                        }
                    } else {
                        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-2, -1);
                        switch (type) {
                            case LEFT:
                                if (!this.mBackButtonInCustomView) {
                                    this.mToolbar.setNavigationIcon((Drawable) null);
                                }
                                this.mToolbar.setTitle((CharSequence) null);
                                layoutParams.gravity = 3;
                                break;
                            case RIGHT:
                                layoutParams.gravity = 5;
                                break;
                            case CENTER:
                                layoutParams.width = -1;
                                layoutParams.gravity = 1;
                                this.mToolbar.setTitle((CharSequence) null);
                                break;
                        }
                        screenStackHeaderSubview.setLayoutParams(layoutParams);
                        this.mToolbar.addView(screenStackHeaderSubview);
                    }
                }
            } else if (this.mToolbar.getParent() != null) {
                getScreenFragment().removeToolbar();
            }
        }
    }

    private void maybeUpdate() {
        if (getParent() != null && !this.mDestroyed) {
            onUpdate();
        }
    }

    public ScreenStackHeaderSubview getConfigSubview(int i) {
        return this.mConfigSubviews.get(i);
    }

    public int getConfigSubviewsCount() {
        return this.mConfigSubviews.size();
    }

    public void removeConfigSubview(int i) {
        this.mConfigSubviews.remove(i);
        maybeUpdate();
    }

    public void removeAllConfigSubviews() {
        this.mConfigSubviews.clear();
        maybeUpdate();
    }

    public void addConfigSubview(ScreenStackHeaderSubview screenStackHeaderSubview, int i) {
        this.mConfigSubviews.add(i, screenStackHeaderSubview);
        maybeUpdate();
    }

    private TextView getTitleTextView() {
        int childCount = this.mToolbar.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mToolbar.getChildAt(i);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (textView.getText().equals(this.mToolbar.getTitle())) {
                    return textView;
                }
            }
        }
        return null;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setTitleFontFamily(String str) {
        this.mTitleFontFamily = str;
    }

    public void setTitleFontSize(float f) {
        this.mTitleFontSize = f;
    }

    public void setTitleColor(int i) {
        this.mTitleColor = i;
    }

    public void setTintColor(int i) {
        this.mTintColor = i;
    }

    public void setTopInsetEnabled(boolean z) {
        this.mIsTopInsetEnabled = z;
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setHideShadow(boolean z) {
        this.mIsShadowHidden = z;
    }

    public void setHideBackButton(boolean z) {
        this.mIsBackButtonHidden = z;
    }

    public void setHidden(boolean z) {
        this.mIsHidden = z;
    }

    public void setBackButtonInCustomView(boolean z) {
        this.mBackButtonInCustomView = z;
    }
}
