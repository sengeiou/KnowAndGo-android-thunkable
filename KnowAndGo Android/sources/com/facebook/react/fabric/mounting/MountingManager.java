package com.facebook.react.fabric.mounting;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewManager;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.yoga.YogaMeasureMode;
import java.util.concurrent.ConcurrentHashMap;

public class MountingManager {
    public static final String TAG = "MountingManager";
    @NonNull
    private final JSResponderHandler mJSResponderHandler = new JSResponderHandler();
    @NonNull
    private final RootViewManager mRootViewManager = new RootViewManager();
    @NonNull
    private final ConcurrentHashMap<Integer, ViewState> mTagToViewState = new ConcurrentHashMap<>();
    @NonNull
    private final ViewManagerRegistry mViewManagerRegistry;

    public MountingManager(@NonNull ViewManagerRegistry viewManagerRegistry) {
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    @ThreadConfined("UI")
    public void addRootView(int i, @NonNull View view) {
        if (view.getId() == -1) {
            this.mTagToViewState.put(Integer.valueOf(i), new ViewState(i, view, this.mRootViewManager, true));
            view.setId(i);
            return;
        }
        throw new IllegalViewOperationException("Trying to add a root view with an explicit id already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
    }

    @UiThread
    private void dropView(@NonNull View view) {
        UiThreadUtil.assertOnUiThread();
        int id = view.getId();
        ViewState viewState = getViewState(id);
        ViewManager viewManager = viewState.mViewManager;
        if (!viewState.mIsRoot && viewManager != null) {
            viewManager.onDropViewInstance(view);
        }
        if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
            ViewGroup viewGroup = (ViewGroup) view;
            ViewGroupManager<ViewGroup> viewGroupManager = getViewGroupManager(viewState);
            for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                if (getNullableViewState(childAt.getId()) != null) {
                    dropView(childAt);
                }
                viewGroupManager.removeViewAt(viewGroup, childCount);
            }
        }
        this.mTagToViewState.remove(Integer.valueOf(id));
    }

    @UiThread
    public void addViewAt(int i, int i2, int i3) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        ViewGroup viewGroup = (ViewGroup) viewState.mView;
        ViewState viewState2 = getViewState(i2);
        View view = viewState2.mView;
        if (view != null) {
            getViewGroupManager(viewState).addView(viewGroup, view, i3);
            return;
        }
        throw new IllegalStateException("Unable to find view for viewState " + viewState2 + " and tag " + i2);
    }

    @NonNull
    private ViewState getViewState(int i) {
        ViewState viewState = this.mTagToViewState.get(Integer.valueOf(i));
        if (viewState != null) {
            return viewState;
        }
        throw new IllegalStateException("Unable to find viewState view for tag " + i);
    }

    @Nullable
    private ViewState getNullableViewState(int i) {
        return this.mTagToViewState.get(Integer.valueOf(i));
    }

    @Deprecated
    public void receiveCommand(int i, int i2, @Nullable ReadableArray readableArray) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new ReactNoCrashSoftException("Unable to find viewState for tag: " + i + " for commandId: " + i2));
        } else if (nullableViewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewManager for tag " + i);
        } else if (nullableViewState.mView != null) {
            nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, i2, readableArray);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    public void receiveCommand(int i, @NonNull String str, @Nullable ReadableArray readableArray) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str2 = TAG;
            ReactSoftException.logSoftException(str2, new IllegalStateException("Unable to find viewState for tag: " + i + " for commandId: " + str));
        } else if (nullableViewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewState manager for tag " + i);
        } else if (nullableViewState.mView != null) {
            nullableViewState.mViewManager.receiveCommand(nullableViewState.mView, str, readableArray);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    public void sendAccessibilityEvent(int i, int i2) {
        ViewState viewState = getViewState(i);
        if (viewState.mViewManager == null) {
            throw new IllegalStateException("Unable to find viewState manager for tag " + i);
        } else if (viewState.mView != null) {
            viewState.mView.sendAccessibilityEvent(i2);
        } else {
            throw new IllegalStateException("Unable to find viewState view for tag " + i);
        }
    }

    @NonNull
    private static ViewGroupManager<ViewGroup> getViewGroupManager(@NonNull ViewState viewState) {
        if (viewState.mViewManager != null) {
            return (ViewGroupManager) viewState.mViewManager;
        }
        throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
    }

    @UiThread
    public void removeViewAt(int i, int i2) {
        UiThreadUtil.assertOnUiThread();
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for removeViewAt"));
            return;
        }
        ViewGroup viewGroup = (ViewGroup) nullableViewState.mView;
        if (viewGroup != null) {
            getViewGroupManager(nullableViewState).removeViewAt(viewGroup, i2);
            return;
        }
        throw new IllegalStateException("Unable to find view for tag " + i);
    }

    @UiThread
    public void createView(@NonNull ThemedReactContext themedReactContext, @NonNull String str, int i, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        ViewManager viewManager;
        View view;
        if (getNullableViewState(i) == null) {
            ReadableNativeMap readableNativeMap = null;
            ReactStylesDiffMap reactStylesDiffMap = readableMap != null ? new ReactStylesDiffMap(readableMap) : null;
            if (z) {
                viewManager = this.mViewManagerRegistry.get(str);
                view = viewManager.createView(themedReactContext, reactStylesDiffMap, stateWrapper, this.mJSResponderHandler);
                view.setId(i);
            } else {
                view = null;
                viewManager = null;
            }
            ViewState viewState = new ViewState(i, view, viewManager);
            viewState.mCurrentProps = reactStylesDiffMap;
            if (stateWrapper != null) {
                readableNativeMap = stateWrapper.getState();
            }
            viewState.mCurrentState = readableNativeMap;
            this.mTagToViewState.put(Integer.valueOf(i), viewState);
        }
    }

    @UiThread
    public void updateProps(int i, @Nullable ReadableMap readableMap) {
        if (readableMap != null) {
            UiThreadUtil.assertOnUiThread();
            ViewState viewState = getViewState(i);
            viewState.mCurrentProps = new ReactStylesDiffMap(readableMap);
            View view = viewState.mView;
            if (view != null) {
                ((ViewManager) Assertions.assertNotNull(viewState.mViewManager)).updateProperties(view, viewState.mCurrentProps);
                return;
            }
            throw new IllegalStateException("Unable to find view for tag " + i);
        }
    }

    @UiThread
    public void updateLayout(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (!viewState.mIsRoot) {
            View view = viewState.mView;
            if (view != null) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                ViewParent parent = view.getParent();
                if (parent instanceof RootView) {
                    parent.requestLayout();
                }
                view.layout(i2, i3, i4 + i2, i5 + i3);
                return;
            }
            throw new IllegalStateException("Unable to find View for tag: " + i);
        }
    }

    @UiThread
    public void updatePadding(int i, int i2, int i3, int i4, int i5) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (!viewState.mIsRoot) {
            View view = viewState.mView;
            if (view != null) {
                ViewManager viewManager = viewState.mViewManager;
                if (viewManager != null) {
                    viewManager.setPadding(view, i2, i3, i4, i5);
                    return;
                }
                throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
            }
            throw new IllegalStateException("Unable to find View for tag: " + i);
        }
    }

    @UiThread
    public void deleteView(int i) {
        UiThreadUtil.assertOnUiThread();
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            String str = TAG;
            ReactSoftException.logSoftException(str, new IllegalStateException("Unable to find viewState for tag: " + i + " for deleteView"));
            return;
        }
        View view = nullableViewState.mView;
        if (view != null) {
            dropView(view);
        } else {
            this.mTagToViewState.remove(Integer.valueOf(i));
        }
    }

    @UiThread
    public void updateLocalData(int i, @NonNull ReadableMap readableMap) {
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (viewState.mCurrentProps == null) {
            throw new IllegalStateException("Can not update local data to view without props: " + i);
        } else if (viewState.mCurrentLocalData == null || !readableMap.hasKey("hash") || viewState.mCurrentLocalData.getDouble("hash") != readableMap.getDouble("hash") || !viewState.mCurrentLocalData.equals(readableMap)) {
            viewState.mCurrentLocalData = readableMap;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateLocalData = viewManager.updateLocalData(viewState.mView, viewState.mCurrentProps, new ReactStylesDiffMap(viewState.mCurrentLocalData));
                if (updateLocalData != null) {
                    viewManager.updateExtraData(viewState.mView, updateLocalData);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for view: " + viewState);
        }
    }

    @UiThread
    public void updateState(int i, @Nullable StateWrapper stateWrapper) {
        ReadableNativeMap readableNativeMap;
        UiThreadUtil.assertOnUiThread();
        ViewState viewState = getViewState(i);
        if (stateWrapper == null) {
            readableNativeMap = null;
        } else {
            readableNativeMap = stateWrapper.getState();
        }
        if (viewState.mCurrentState != null && viewState.mCurrentState.equals(readableNativeMap)) {
            return;
        }
        if (viewState.mCurrentState != null || stateWrapper != null) {
            viewState.mCurrentState = readableNativeMap;
            ViewManager viewManager = viewState.mViewManager;
            if (viewManager != null) {
                Object updateState = viewManager.updateState(viewState.mView, viewState.mCurrentProps, stateWrapper);
                if (updateState != null) {
                    viewManager.updateExtraData(viewState.mView, updateState);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Unable to find ViewManager for tag: " + i);
        }
    }

    @UiThread
    public void preallocateView(@NonNull ThemedReactContext themedReactContext, String str, int i, @Nullable ReadableMap readableMap, @Nullable StateWrapper stateWrapper, boolean z) {
        if (getNullableViewState(i) == null) {
            createView(themedReactContext, str, i, readableMap, stateWrapper, z);
            return;
        }
        throw new IllegalStateException("View for component " + str + " with tag " + i + " already exists.");
    }

    @UiThread
    public void updateEventEmitter(int i, @NonNull EventEmitterWrapper eventEmitterWrapper) {
        UiThreadUtil.assertOnUiThread();
        getViewState(i).mEventEmitter = eventEmitterWrapper;
    }

    @UiThread
    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (!z) {
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) null);
            return;
        }
        ViewState viewState = getViewState(i);
        View view = viewState.mView;
        if (i2 != i && (view instanceof ViewParent)) {
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
        } else if (view == null) {
            SoftAssertions.assertUnreachable("Cannot find view for tag " + i + ".");
        } else {
            if (viewState.mIsRoot) {
                SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
            }
            this.mJSResponderHandler.setJSResponder(i2, view.getParent());
        }
    }

    @UiThread
    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    @AnyThread
    public long measure(@NonNull Context context, @NonNull String str, @NonNull ReadableMap readableMap, @NonNull ReadableMap readableMap2, @NonNull ReadableMap readableMap3, float f, @NonNull YogaMeasureMode yogaMeasureMode, float f2, @NonNull YogaMeasureMode yogaMeasureMode2) {
        String str2 = str;
        return this.mViewManagerRegistry.get(str).measure(context, readableMap, readableMap2, readableMap3, f, yogaMeasureMode, f2, yogaMeasureMode2);
    }

    @ThreadConfined("ANY")
    @AnyThread
    @Nullable
    public EventEmitterWrapper getEventEmitter(int i) {
        ViewState nullableViewState = getNullableViewState(i);
        if (nullableViewState == null) {
            return null;
        }
        return nullableViewState.mEventEmitter;
    }

    private static class ViewState {
        @Nullable
        public ReadableMap mCurrentLocalData;
        @Nullable
        public ReactStylesDiffMap mCurrentProps;
        @Nullable
        public ReadableMap mCurrentState;
        @Nullable
        public EventEmitterWrapper mEventEmitter;
        final boolean mIsRoot;
        final int mReactTag;
        @Nullable
        final View mView;
        @Nullable
        final ViewManager mViewManager;

        private ViewState(int i, @Nullable View view, @Nullable ViewManager viewManager) {
            this(i, view, viewManager, false);
        }

        private ViewState(int i, @Nullable View view, ViewManager viewManager, boolean z) {
            this.mCurrentProps = null;
            this.mCurrentLocalData = null;
            this.mCurrentState = null;
            this.mEventEmitter = null;
            this.mReactTag = i;
            this.mView = view;
            this.mIsRoot = z;
            this.mViewManager = viewManager;
        }

        public String toString() {
            boolean z = this.mViewManager == null;
            return "ViewState [" + this.mReactTag + "] - isRoot: " + this.mIsRoot + " - props: " + this.mCurrentProps + " - localData: " + this.mCurrentLocalData + " - viewManager: " + this.mViewManager + " - isLayoutOnly: " + z;
        }
    }
}
