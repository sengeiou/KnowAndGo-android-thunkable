package com.google.android.material.bottomnavigation;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.C0064R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.C1641R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import java.util.HashSet;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class BottomNavigationMenuView extends ViewGroup implements MenuView {
    private static final long ACTIVE_ANIMATION_DURATION_MS = 115;
    private static final int[] CHECKED_STATE_SET = {16842912};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int ITEM_POOL_SIZE = 5;
    private final int activeItemMaxWidth;
    private final int activeItemMinWidth;
    @NonNull
    private SparseArray<BadgeDrawable> badgeDrawables;
    @Nullable
    private BottomNavigationItemView[] buttons;
    private final int inactiveItemMaxWidth;
    private final int inactiveItemMinWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private final int itemHeight;
    private boolean itemHorizontalTranslationEnabled;
    @Dimension
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private final Pools.Pool<BottomNavigationItemView> itemPool;
    @StyleRes
    private int itemTextAppearanceActive;
    @StyleRes
    private int itemTextAppearanceInactive;
    @Nullable
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    /* access modifiers changed from: private */
    public MenuBuilder menu;
    @NonNull
    private final View.OnClickListener onClickListener;
    /* access modifiers changed from: private */
    public BottomNavigationPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    @NonNull
    private final TransitionSet set;
    private int[] tempChildWidths;

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0008 A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isShifting(int r4, int r5) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            if (r4 != r2) goto L_0x000a
            r4 = 3
            if (r5 <= r4) goto L_0x000d
        L_0x0008:
            r0 = 1
            goto L_0x000d
        L_0x000a:
            if (r4 != 0) goto L_0x000d
            goto L_0x0008
        L_0x000d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomnavigation.BottomNavigationMenuView.isShifting(int, int):boolean");
    }

    private boolean isValidId(int i) {
        return i != -1;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public BottomNavigationMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public BottomNavigationMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.itemPool = new Pools.SynchronizedPool(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray<>(5);
        Resources resources = getResources();
        this.inactiveItemMaxWidth = resources.getDimensionPixelSize(C1641R.dimen.design_bottom_navigation_item_max_width);
        this.inactiveItemMinWidth = resources.getDimensionPixelSize(C1641R.dimen.design_bottom_navigation_item_min_width);
        this.activeItemMaxWidth = resources.getDimensionPixelSize(C1641R.dimen.design_bottom_navigation_active_item_max_width);
        this.activeItemMinWidth = resources.getDimensionPixelSize(C1641R.dimen.design_bottom_navigation_active_item_min_width);
        this.itemHeight = resources.getDimensionPixelSize(C1641R.dimen.design_bottom_navigation_height);
        this.itemTextColorDefault = createDefaultColorStateList(16842808);
        this.set = new AutoTransition();
        this.set.setOrdering(0);
        this.set.setDuration((long) ACTIVE_ANIMATION_DURATION_MS);
        this.set.setInterpolator((TimeInterpolator) new FastOutSlowInInterpolator());
        this.set.addTransition(new TextScale());
        this.onClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                MenuItemImpl itemData = ((BottomNavigationItemView) view).getItemData();
                if (!BottomNavigationMenuView.this.menu.performItemAction(itemData, BottomNavigationMenuView.this.presenter, 0)) {
                    itemData.setChecked(true);
                }
            }
        };
        this.tempChildWidths = new int[5];
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.menu = menuBuilder;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.itemHeight, 1073741824);
        if (!isShifting(this.labelVisibilityMode, size2) || !this.itemHorizontalTranslationEnabled) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.activeItemMaxWidth);
            int i3 = size - (size2 * min);
            for (int i4 = 0; i4 < childCount; i4++) {
                if (getChildAt(i4).getVisibility() != 8) {
                    this.tempChildWidths[i4] = min;
                    if (i3 > 0) {
                        int[] iArr = this.tempChildWidths;
                        iArr[i4] = iArr[i4] + 1;
                        i3--;
                    }
                } else {
                    this.tempChildWidths[i4] = 0;
                }
            }
        } else {
            View childAt = getChildAt(this.selectedItemPosition);
            int i5 = this.activeItemMinWidth;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.activeItemMaxWidth, Integer.MIN_VALUE), makeMeasureSpec);
                i5 = Math.max(i5, childAt.getMeasuredWidth());
            }
            int i6 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.inactiveItemMinWidth * i6), Math.min(i5, this.activeItemMaxWidth));
            int i7 = size - min2;
            int min3 = Math.min(i7 / (i6 == 0 ? 1 : i6), this.inactiveItemMaxWidth);
            int i8 = i7 - (i6 * min3);
            int i9 = 0;
            while (i9 < childCount) {
                if (getChildAt(i9).getVisibility() != 8) {
                    this.tempChildWidths[i9] = i9 == this.selectedItemPosition ? min2 : min3;
                    if (i8 > 0) {
                        int[] iArr2 = this.tempChildWidths;
                        iArr2[i9] = iArr2[i9] + 1;
                        i8--;
                    }
                } else {
                    this.tempChildWidths[i9] = 0;
                }
                i9++;
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.tempChildWidths[i11], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i10 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i10, View.MeasureSpec.makeMeasureSpec(i10, 1073741824), 0), View.resolveSizeAndState(this.itemHeight, makeMeasureSpec, 0));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i9 = i5 - i7;
                    childAt.layout(i9 - childAt.getMeasuredWidth(), 0, i9, i6);
                } else {
                    childAt.layout(i7, 0, childAt.getMeasuredWidth() + i7, i6);
                }
                i7 += childAt.getMeasuredWidth();
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        if (this.buttons != null) {
            for (BottomNavigationItemView iconTintList : this.buttons) {
                iconTintList.setIconTintList(colorStateList);
            }
        }
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public void setItemIconSize(@Dimension int i) {
        this.itemIconSize = i;
        if (this.buttons != null) {
            for (BottomNavigationItemView iconSize : this.buttons) {
                iconSize.setIconSize(i);
            }
        }
    }

    @Dimension
    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        if (this.buttons != null) {
            for (BottomNavigationItemView textColor : this.buttons) {
                textColor.setTextColor(colorStateList);
            }
        }
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public void setItemTextAppearanceInactive(@StyleRes int i) {
        this.itemTextAppearanceInactive = i;
        if (this.buttons != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.buttons) {
                bottomNavigationItemView.setTextAppearanceInactive(i);
                if (this.itemTextColorFromUser != null) {
                    bottomNavigationItemView.setTextColor(this.itemTextColorFromUser);
                }
            }
        }
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public void setItemTextAppearanceActive(@StyleRes int i) {
        this.itemTextAppearanceActive = i;
        if (this.buttons != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.buttons) {
                bottomNavigationItemView.setTextAppearanceActive(i);
                if (this.itemTextColorFromUser != null) {
                    bottomNavigationItemView.setTextColor(this.itemTextColorFromUser);
                }
            }
        }
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public void setItemBackgroundRes(int i) {
        this.itemBackgroundRes = i;
        if (this.buttons != null) {
            for (BottomNavigationItemView itemBackground2 : this.buttons) {
                itemBackground2.setItemBackground(i);
            }
        }
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.itemBackground = drawable;
        if (this.buttons != null) {
            for (BottomNavigationItemView itemBackground2 : this.buttons) {
                itemBackground2.setItemBackground(drawable);
            }
        }
    }

    @Nullable
    public Drawable getItemBackground() {
        if (this.buttons == null || this.buttons.length <= 0) {
            return this.itemBackground;
        }
        return this.buttons[0].getBackground();
    }

    public void setLabelVisibilityMode(int i) {
        this.labelVisibilityMode = i;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.itemHorizontalTranslationEnabled = z;
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.itemHorizontalTranslationEnabled;
    }

    @Nullable
    public ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(C0064R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.presenter = bottomNavigationPresenter;
    }

    public void buildMenuView() {
        removeAllViews();
        if (this.buttons != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.buttons) {
                if (bottomNavigationItemView != null) {
                    this.itemPool.release(bottomNavigationItemView);
                    bottomNavigationItemView.removeBadge();
                }
            }
        }
        if (this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }
        removeUnusedBadges();
        this.buttons = new BottomNavigationItemView[this.menu.size()];
        boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for (int i = 0; i < this.menu.size(); i++) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(i).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            BottomNavigationItemView newItem = getNewItem();
            this.buttons[i] = newItem;
            newItem.setIconTintList(this.itemIconTint);
            newItem.setIconSize(this.itemIconSize);
            newItem.setTextColor(this.itemTextColorDefault);
            newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
            newItem.setTextColor(this.itemTextColorFromUser);
            if (this.itemBackground != null) {
                newItem.setItemBackground(this.itemBackground);
            } else {
                newItem.setItemBackground(this.itemBackgroundRes);
            }
            newItem.setShifting(isShifting);
            newItem.setLabelVisibilityMode(this.labelVisibilityMode);
            newItem.initialize((MenuItemImpl) this.menu.getItem(i), 0);
            newItem.setItemPosition(i);
            newItem.setOnClickListener(this.onClickListener);
            if (this.selectedItemId != 0 && this.menu.getItem(i).getItemId() == this.selectedItemId) {
                this.selectedItemPosition = i;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        this.selectedItemPosition = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.menu.getItem(this.selectedItemPosition).setChecked(true);
    }

    public void updateMenuView() {
        if (this.menu != null && this.buttons != null) {
            int size = this.menu.size();
            if (size != this.buttons.length) {
                buildMenuView();
                return;
            }
            int i = this.selectedItemId;
            for (int i2 = 0; i2 < size; i2++) {
                MenuItem item = this.menu.getItem(i2);
                if (item.isChecked()) {
                    this.selectedItemId = item.getItemId();
                    this.selectedItemPosition = i2;
                }
            }
            if (i != this.selectedItemId) {
                TransitionManager.beginDelayedTransition(this, this.set);
            }
            boolean isShifting = isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
            for (int i3 = 0; i3 < size; i3++) {
                this.presenter.setUpdateSuspended(true);
                this.buttons[i3].setLabelVisibilityMode(this.labelVisibilityMode);
                this.buttons[i3].setShifting(isShifting);
                this.buttons[i3].initialize((MenuItemImpl) this.menu.getItem(i3), 0);
                this.presenter.setUpdateSuspended(false);
            }
        }
    }

    private BottomNavigationItemView getNewItem() {
        BottomNavigationItemView acquire = this.itemPool.acquire();
        return acquire == null ? new BottomNavigationItemView(getContext()) : acquire;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    /* access modifiers changed from: package-private */
    public void tryRestoreSelectedItemId(int i) {
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = this.menu.getItem(i2);
            if (i == item.getItemId()) {
                this.selectedItemId = i;
                this.selectedItemPosition = i2;
                item.setChecked(true);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    /* access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.badgeDrawables = sparseArray;
        if (this.buttons != null) {
            for (BottomNavigationItemView bottomNavigationItemView : this.buttons) {
                bottomNavigationItemView.setBadge(sparseArray.get(bottomNavigationItemView.getId()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public BadgeDrawable getBadge(int i) {
        return this.badgeDrawables.get(i);
    }

    /* access modifiers changed from: package-private */
    public BadgeDrawable getOrCreateBadge(int i) {
        validateMenuItemId(i);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i, badgeDrawable);
        }
        BottomNavigationItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    /* access modifiers changed from: package-private */
    public void removeBadge(int i) {
        validateMenuItemId(i);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i);
        BottomNavigationItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        if (badgeDrawable != null) {
            this.badgeDrawables.remove(i);
        }
    }

    private void setBadgeIfNeeded(@NonNull BottomNavigationItemView bottomNavigationItemView) {
        BadgeDrawable badgeDrawable;
        int id = bottomNavigationItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            bottomNavigationItemView.setBadge(badgeDrawable);
        }
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.menu.size(); i++) {
            hashSet.add(Integer.valueOf(this.menu.getItem(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int keyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public BottomNavigationItemView findItemView(int i) {
        validateMenuItemId(i);
        if (this.buttons == null) {
            return null;
        }
        for (BottomNavigationItemView bottomNavigationItemView : this.buttons) {
            if (bottomNavigationItemView.getId() == i) {
                return bottomNavigationItemView;
            }
        }
        return null;
    }

    private void validateMenuItemId(int i) {
        if (!isValidId(i)) {
            throw new IllegalArgumentException(i + " is not a valid view id");
        }
    }
}
