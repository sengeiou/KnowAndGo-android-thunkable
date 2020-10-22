package com.facebook.react.fabric;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.events.FabricEventEmitter;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchStringCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveDeleteMultiMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.SendAccessibilityEvent;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePaddingMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateStateMountItem;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.ReactRootViewTagGenerator;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManagerPropertyUpdater;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SuppressLint({"MissingNativeLoadLibrary"})
public class FabricUIManager implements UIManager, LifecycleEventListener {
    public static final boolean ENABLE_FABRIC_LOGS = (ReactFeatureFlags.enableFabricLogs || PrinterHolder.getPrinter().shouldDisplayLogMessage(ReactDebugOverlayTags.FABRIC_UI_MANAGER));
    private static final int FRAME_TIME_MS = 16;
    public static final boolean IS_DEVELOPMENT_ENVIRONMENT = false;
    private static final int MAX_TIME_IN_FRAME_FOR_NON_BATCHED_OPERATIONS_MS = 8;
    private static final int PRE_MOUNT_ITEMS_INITIAL_SIZE_ARRAY = 250;
    public static final String TAG = "FabricUIManager";
    private long mBatchedExecutionTime = 0;
    @Nullable
    private Binding mBinding;
    private long mCommitStartTime = 0;
    private int mCurrentSynchronousCommitNumber = 10000;
    /* access modifiers changed from: private */
    public volatile boolean mDestroyed = false;
    /* access modifiers changed from: private */
    @NonNull
    @ThreadConfined("UI")
    public final DispatchUIFrameCallback mDispatchUIFrameCallback;
    private long mDispatchViewUpdatesTime = 0;
    @NonNull
    private final EventBeatManager mEventBeatManager;
    @NonNull
    private final EventDispatcher mEventDispatcher;
    private long mFinishTransactionCPPTime = 0;
    private long mFinishTransactionTime = 0;
    @ThreadConfined("UI")
    private boolean mImmediatelyExecutedMountItemsOnUI = true;
    private long mLayoutTime = 0;
    @GuardedBy("mMountItemsLock")
    @NonNull
    private List<MountItem> mMountItems = new ArrayList();
    @NonNull
    private final Object mMountItemsLock = new Object();
    @NonNull
    private final MountingManager mMountingManager;
    @GuardedBy("mPreMountItemsLock")
    @NonNull
    private ArrayDeque<MountItem> mPreMountItems = new ArrayDeque<>(250);
    @NonNull
    private final Object mPreMountItemsLock = new Object();
    @NonNull
    private final ReactApplicationContext mReactApplicationContext;
    @NonNull
    private final ConcurrentHashMap<Integer, ThemedReactContext> mReactContextForRootTag = new ConcurrentHashMap<>();
    private long mRunStartTime = 0;

    public void onHostDestroy() {
    }

    public void profileNextBatch() {
    }

    static {
        FabricSoLoader.staticInit();
    }

    public FabricUIManager(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, EventBeatManager eventBeatManager) {
        this.mDispatchUIFrameCallback = new DispatchUIFrameCallback(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mMountingManager = new MountingManager(viewManagerRegistry);
        this.mEventDispatcher = eventDispatcher;
        this.mEventBeatManager = eventBeatManager;
        this.mReactApplicationContext.addLifecycleEventListener(this);
    }

    @UiThread
    @ThreadConfined("UI")
    public <T extends View> int addRootView(T t, WritableMap writableMap, @Nullable String str) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ReactRoot reactRoot = (ReactRoot) t;
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext(), reactRoot.getSurfaceID());
        this.mMountingManager.addRootView(nextRootViewTag, t);
        String jSModuleName = reactRoot.getJSModuleName();
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        if (ENABLE_FABRIC_LOGS) {
            FLog.m52d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) jSModuleName, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mBinding.startSurface(nextRootViewTag, jSModuleName, (NativeMap) writableMap);
        if (str != null) {
            this.mBinding.renderTemplateToSurface(nextRootViewTag, str);
        }
        return nextRootViewTag;
    }

    @ThreadConfined("ANY")
    @AnyThread
    public <T extends View> int startSurface(T t, String str, WritableMap writableMap, int i, int i2) {
        int nextRootViewTag = ReactRootViewTagGenerator.getNextRootViewTag();
        ThemedReactContext themedReactContext = new ThemedReactContext(this.mReactApplicationContext, t.getContext(), str);
        if (ENABLE_FABRIC_LOGS) {
            FLog.m52d(TAG, "Starting surface for module: %s and reactTag: %d", (Object) str, (Object) Integer.valueOf(nextRootViewTag));
        }
        this.mMountingManager.addRootView(nextRootViewTag, t);
        this.mReactContextForRootTag.put(Integer.valueOf(nextRootViewTag), themedReactContext);
        this.mBinding.startSurfaceWithConstraints(nextRootViewTag, str, (NativeMap) writableMap, LayoutMetricsConversions.getMinSize(i), LayoutMetricsConversions.getMaxSize(i), LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2));
        return nextRootViewTag;
    }

    @DoNotStrip
    public void onRequestEventBeat() {
        this.mEventDispatcher.dispatchAllEvents();
    }

    @ThreadConfined("ANY")
    @AnyThread
    public void stopSurface(int i) {
        this.mBinding.stopSurface(i);
    }

    public void initialize() {
        this.mEventDispatcher.registerEventEmitter(2, new FabricEventEmitter(this));
        this.mEventDispatcher.addBatchEventDispatchedListener(this.mEventBeatManager);
    }

    @ThreadConfined("ANY")
    @AnyThread
    public void onCatalystInstanceDestroy() {
        FLog.m74i(TAG, "FabricUIManager.onCatalystInstanceDestroy");
        if (this.mDestroyed) {
            ReactSoftException.logSoftException(TAG, new IllegalStateException("Cannot double-destroy FabricUIManager"));
            return;
        }
        this.mDestroyed = true;
        this.mDispatchUIFrameCallback.stop();
        this.mEventDispatcher.removeBatchEventDispatchedListener(this.mEventBeatManager);
        this.mEventDispatcher.unregisterEventEmitter(2);
        this.mReactApplicationContext.removeLifecycleEventListener(this);
        onHostPause();
        this.mDispatchUIFrameCallback.stop();
        this.mBinding.unregister();
        this.mBinding = null;
        ViewManagerPropertyUpdater.clear();
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private void preallocateView(int i, int i2, String str, @Nullable ReadableMap readableMap, @Nullable Object obj, boolean z) {
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        synchronized (this.mPreMountItemsLock) {
            this.mPreMountItems.add(new PreAllocateViewMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z));
        }
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem createMountItem(String str, @Nullable ReadableMap readableMap, @Nullable Object obj, int i, int i2, boolean z) {
        String fabricComponentName = FabricComponents.getFabricComponentName(str);
        ThemedReactContext themedReactContext = this.mReactContextForRootTag.get(Integer.valueOf(i));
        if (themedReactContext != null) {
            return new CreateMountItem(themedReactContext, i, i2, fabricComponentName, readableMap, (StateWrapper) obj, z);
        }
        throw new IllegalArgumentException("Unable to find ReactContext for root: " + i);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem removeMountItem(int i, int i2, int i3) {
        return new RemoveMountItem(i, i2, i3);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem insertMountItem(int i, int i2, int i3) {
        return new InsertMountItem(i, i2, i3);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem deleteMountItem(int i) {
        return new DeleteMountItem(i);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem removeDeleteMultiMountItem(int[] iArr) {
        return new RemoveDeleteMultiMountItem(iArr);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updateLayoutMountItem(int i, int i2, int i3, int i4, int i5, int i6) {
        return new UpdateLayoutMountItem(i, i2, i3, i4, i5, i6);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updatePaddingMountItem(int i, int i2, int i3, int i4, int i5) {
        return new UpdatePaddingMountItem(i, i2, i3, i4, i5);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updatePropsMountItem(int i, ReadableMap readableMap) {
        return new UpdatePropsMountItem(i, readableMap);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updateLocalDataMountItem(int i, ReadableMap readableMap) {
        return new UpdateLocalDataMountItem(i, readableMap);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updateStateMountItem(int i, @Nullable Object obj) {
        return new UpdateStateMountItem(i, (StateWrapper) obj);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem updateEventEmitterMountItem(int i, Object obj) {
        return new UpdateEventEmitterMountItem(i, (EventEmitterWrapper) obj);
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private MountItem createBatchMountItem(MountItem[] mountItemArr, int i, int i2) {
        return new BatchMountItem(mountItemArr, i, i2);
    }

    @DoNotStrip
    private long measure(int i, String str, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, float f2, float f3, float f4) {
        return this.mMountingManager.measure(this.mReactContextForRootTag.get(Integer.valueOf(i)), str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4));
    }

    @DoNotStrip
    private long measure(String str, @NonNull ReadableMap readableMap, @NonNull ReadableMap readableMap2, @NonNull ReadableMap readableMap3, float f, float f2, float f3, float f4) {
        return this.mMountingManager.measure(this.mReactApplicationContext, str, readableMap, readableMap2, readableMap3, LayoutMetricsConversions.getYogaSize(f, f2), LayoutMetricsConversions.getYogaMeasureMode(f, f2), LayoutMetricsConversions.getYogaSize(f3, f4), LayoutMetricsConversions.getYogaMeasureMode(f3, f4));
    }

    @UiThread
    @ThreadConfined("UI")
    public void synchronouslyUpdateViewOnUIThread(int i, @NonNull ReadableMap readableMap) {
        String str;
        int i2;
        ReactMarkerConstants reactMarkerConstants;
        String str2;
        int i3;
        UiThreadUtil.assertOnUiThread();
        long uptimeMillis = SystemClock.uptimeMillis();
        int i4 = this.mCurrentSynchronousCommitNumber;
        this.mCurrentSynchronousCommitNumber = i4 + 1;
        try {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_START, (String) null, i4);
            if (ENABLE_FABRIC_LOGS) {
                FLog.m51d(TAG, "SynchronouslyUpdateViewOnUIThread for tag %d", (Object) Integer.valueOf(i));
            }
            int i5 = i4;
            try {
                scheduleMountItem(updatePropsMountItem(i, readableMap), i4, uptimeMillis, 0, 0, 0, 0, 0, 0);
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                i2 = i5;
                str = null;
            } catch (Exception unused) {
                i2 = i5;
                str = null;
                reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
                ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
            } catch (Throwable th) {
                th = th;
                i3 = i5;
                str2 = null;
                ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
                throw th;
            }
        } catch (Exception unused2) {
            str = null;
            i2 = i4;
            reactMarkerConstants = ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END;
            ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            i3 = i4;
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_UPDATE_UI_MAIN_THREAD_END, str2, i3);
            throw th;
        }
        ReactMarker.logFabricMarker(reactMarkerConstants, str, i2);
    }

    @UiThread
    @ThreadConfined("UI")
    public void setAllowImmediateUIOperationExecution(boolean z) {
        this.mImmediatelyExecutedMountItemsOnUI = z;
    }

    @DoNotStrip
    @ThreadConfined("ANY")
    @AnyThread
    private void scheduleMountItem(@NonNull MountItem mountItem, int i, long j, long j2, long j3, long j4, long j5, long j6, long j7) {
        MountItem mountItem2 = mountItem;
        int i2 = i;
        long j8 = j;
        long j9 = j4;
        long j10 = j5;
        long j11 = j6;
        long j12 = j7;
        boolean z = mountItem2 instanceof BatchMountItem;
        if (z) {
            this.mCommitStartTime = j8;
            this.mLayoutTime = j10 - j9;
            this.mFinishTransactionCPPTime = j12 - j11;
            this.mFinishTransactionTime = SystemClock.uptimeMillis() - j11;
            this.mDispatchViewUpdatesTime = SystemClock.uptimeMillis();
        }
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(mountItem2);
        }
        if (UiThreadUtil.isOnUiThread()) {
            if (!ReactFeatureFlags.allowDisablingImmediateExecutionOfScheduleMountItems || this.mImmediatelyExecutedMountItemsOnUI) {
                dispatchMountItems();
            }
        }
        if (z) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_START, (String) null, i2, j8);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_START, (String) null, i2, j11);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_FINISH_TRANSACTION_END, (String) null, i2, j12);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_START, (String) null, i2, j2);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_DIFF_END, (String) null, i2, j3);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_START, (String) null, i2, j9);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_LAYOUT_END, (String) null, i2, j10);
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_COMMIT_END, (String) null, i2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r13.mPreMountItems.isEmpty() != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0 = r13.mPreMountItems;
        r13.mPreMountItems = new java.util.ArrayDeque<>(250);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0037, code lost:
        if (r0 == null) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews preMountItems to execute: " + r0.size());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0055, code lost:
        if (r0.isEmpty() != false) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        r0.pollFirst().execute(r13.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0063, code lost:
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0066, code lost:
        com.facebook.systrace.Systrace.beginSection(0, "FabricUIManager::mountViews mountItems to execute: " + r1.size());
        r4 = android.os.SystemClock.uptimeMillis();
        r0 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r0.hasNext() == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        r1 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
        if (ENABLE_FABRIC_LOGS == false) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0096, code lost:
        r6 = r1.toString().split("\n");
        r7 = r6.length;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a2, code lost:
        if (r8 >= r7) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a4, code lost:
        r9 = r6[r8];
        com.facebook.common.logging.FLog.m50d(TAG, "dispatchMountItems: Executing mountItem: " + r9);
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00bf, code lost:
        r1.execute(r13.mMountingManager);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c5, code lost:
        r13.mBatchedExecutionTime = android.os.SystemClock.uptimeMillis() - r4;
        com.facebook.systrace.Systrace.endSection(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cf, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        r0 = null;
        r2 = r13.mPreMountItemsLock;
     */
    @androidx.annotation.UiThread
    @com.facebook.infer.annotation.ThreadConfined("UI")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchMountItems() {
        /*
            r13 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            r13.mRunStartTime = r0
            java.lang.Object r0 = r13.mMountItemsLock
            monitor-enter(r0)
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r13.mMountItems     // Catch:{ all -> 0x00d3 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00d3 }
            if (r1 == 0) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x00d3 }
            return
        L_0x0013:
            java.util.List<com.facebook.react.fabric.mounting.mountitems.MountItem> r1 = r13.mMountItems     // Catch:{ all -> 0x00d3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x00d3 }
            r2.<init>()     // Catch:{ all -> 0x00d3 }
            r13.mMountItems = r2     // Catch:{ all -> 0x00d3 }
            monitor-exit(r0)     // Catch:{ all -> 0x00d3 }
            r0 = 0
            java.lang.Object r2 = r13.mPreMountItemsLock
            monitor-enter(r2)
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r3 = r13.mPreMountItems     // Catch:{ all -> 0x00d0 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x00d0 }
            if (r3 != 0) goto L_0x0034
            java.util.ArrayDeque<com.facebook.react.fabric.mounting.mountitems.MountItem> r0 = r13.mPreMountItems     // Catch:{ all -> 0x00d0 }
            java.util.ArrayDeque r3 = new java.util.ArrayDeque     // Catch:{ all -> 0x00d0 }
            r4 = 250(0xfa, float:3.5E-43)
            r3.<init>(r4)     // Catch:{ all -> 0x00d0 }
            r13.mPreMountItems = r3     // Catch:{ all -> 0x00d0 }
        L_0x0034:
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            r2 = 0
            if (r0 == 0) goto L_0x0066
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "FabricUIManager::mountViews preMountItems to execute: "
            r4.append(r5)
            int r5 = r0.size()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r4)
        L_0x0051:
            boolean r4 = r0.isEmpty()
            if (r4 != 0) goto L_0x0063
            java.lang.Object r4 = r0.pollFirst()
            com.facebook.react.fabric.mounting.mountitems.MountItem r4 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r4
            com.facebook.react.fabric.mounting.MountingManager r5 = r13.mMountingManager
            r4.execute(r5)
            goto L_0x0051
        L_0x0063:
            com.facebook.systrace.Systrace.endSection(r2)
        L_0x0066:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "FabricUIManager::mountViews mountItems to execute: "
            r0.append(r4)
            int r4 = r1.size()
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            com.facebook.systrace.Systrace.beginSection(r2, r0)
            long r4 = android.os.SystemClock.uptimeMillis()
            java.util.Iterator r0 = r1.iterator()
        L_0x0086:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00c5
            java.lang.Object r1 = r0.next()
            com.facebook.react.fabric.mounting.mountitems.MountItem r1 = (com.facebook.react.fabric.mounting.mountitems.MountItem) r1
            boolean r6 = ENABLE_FABRIC_LOGS
            if (r6 == 0) goto L_0x00bf
            java.lang.String r6 = r1.toString()
            java.lang.String r7 = "\n"
            java.lang.String[] r6 = r6.split(r7)
            int r7 = r6.length
            r8 = 0
        L_0x00a2:
            if (r8 >= r7) goto L_0x00bf
            r9 = r6[r8]
            java.lang.String r10 = "FabricUIManager"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "dispatchMountItems: Executing mountItem: "
            r11.append(r12)
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            com.facebook.common.logging.FLog.m50d((java.lang.String) r10, (java.lang.String) r9)
            int r8 = r8 + 1
            goto L_0x00a2
        L_0x00bf:
            com.facebook.react.fabric.mounting.MountingManager r6 = r13.mMountingManager
            r1.execute(r6)
            goto L_0x0086
        L_0x00c5:
            long r0 = android.os.SystemClock.uptimeMillis()
            long r0 = r0 - r4
            r13.mBatchedExecutionTime = r0
            com.facebook.systrace.Systrace.endSection(r2)
            return
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00d0 }
            throw r0
        L_0x00d3:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d3 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.fabric.FabricUIManager.dispatchMountItems():void");
    }

    /* access modifiers changed from: private */
    @UiThread
    @ThreadConfined("UI")
    public void dispatchPreMountItems(long j) {
        MountItem pollFirst;
        Systrace.beginSection(0, "FabricUIManager::premountViews");
        while (true) {
            if (16 - ((System.nanoTime() - j) / 1000000) < 8) {
                break;
            }
            synchronized (this.mPreMountItemsLock) {
                if (!this.mPreMountItems.isEmpty()) {
                    pollFirst = this.mPreMountItems.pollFirst();
                }
            }
            pollFirst.execute(this.mMountingManager);
        }
        Systrace.endSection(0);
    }

    public void setBinding(Binding binding) {
        this.mBinding = binding;
    }

    @UiThread
    @ThreadConfined("UI")
    public void updateRootLayoutSpecs(int i, int i2, int i3) {
        if (ENABLE_FABRIC_LOGS) {
            FLog.m50d(TAG, "Updating Root Layout Specs");
        }
        this.mBinding.setConstraints(i, LayoutMetricsConversions.getMinSize(i2), LayoutMetricsConversions.getMaxSize(i2), LayoutMetricsConversions.getMinSize(i3), LayoutMetricsConversions.getMaxSize(i3));
    }

    public void receiveEvent(int i, String str, @Nullable WritableMap writableMap) {
        EventEmitterWrapper eventEmitter = this.mMountingManager.getEventEmitter(i);
        if (eventEmitter == null) {
            FLog.m50d(TAG, "Unable to invoke event: " + str + " for reactTag: " + i);
            return;
        }
        eventEmitter.invoke(str, writableMap);
    }

    public void onHostResume() {
        ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    public void onHostPause() {
        ReactChoreographer.getInstance().removeFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, this.mDispatchUIFrameCallback);
    }

    @ThreadConfined("ANY")
    @Deprecated
    @AnyThread
    public void dispatchCommand(int i, int i2, @Nullable ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchCommandMountItem(i, i2, readableArray));
        }
    }

    @ThreadConfined("ANY")
    @AnyThread
    public void dispatchCommand(int i, String str, @Nullable ReadableArray readableArray) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new DispatchStringCommandMountItem(i, str, readableArray));
        }
    }

    @ThreadConfined("ANY")
    @AnyThread
    public void sendAccessibilityEvent(int i, int i2) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new SendAccessibilityEvent(i, i2));
        }
    }

    @DoNotStrip
    public void setJSResponder(final int i, final int i2, final boolean z) {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                public void execute(MountingManager mountingManager) {
                    mountingManager.setJSResponder(i, i2, z);
                }
            });
        }
    }

    @DoNotStrip
    public void clearJSResponder() {
        synchronized (this.mMountItemsLock) {
            this.mMountItems.add(new MountItem() {
                public void execute(MountingManager mountingManager) {
                    mountingManager.clearJSResponder();
                }
            });
        }
    }

    public Map<String, Long> getPerformanceCounters() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.mCommitStartTime));
        hashMap.put("LayoutTime", Long.valueOf(this.mLayoutTime));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.mDispatchViewUpdatesTime));
        hashMap.put("RunStartTime", Long.valueOf(this.mRunStartTime));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.mBatchedExecutionTime));
        hashMap.put("FinishFabricTransactionTime", Long.valueOf(this.mFinishTransactionTime));
        hashMap.put("FinishFabricTransactionCPPTime", Long.valueOf(this.mFinishTransactionCPPTime));
        return hashMap;
    }

    private class DispatchUIFrameCallback extends GuardedFrameCallback {
        private volatile boolean mIsMountingEnabled;

        private DispatchUIFrameCallback(@NonNull ReactContext reactContext) {
            super(reactContext);
            this.mIsMountingEnabled = true;
        }

        /* access modifiers changed from: package-private */
        @AnyThread
        public void stop() {
            this.mIsMountingEnabled = false;
        }

        @UiThread
        @ThreadConfined("UI")
        public void doFrameGuarded(long j) {
            if (!this.mIsMountingEnabled || FabricUIManager.this.mDestroyed) {
                FLog.m102w(ReactConstants.TAG, "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            try {
                FabricUIManager.this.dispatchPreMountItems(j);
                FabricUIManager.this.dispatchMountItems();
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
            } catch (Exception e) {
                FLog.m79i(ReactConstants.TAG, "Exception thrown when executing UIFrameGuarded", (Throwable) e);
                stop();
                throw e;
            } catch (Throwable th) {
                ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.DISPATCH_UI, FabricUIManager.this.mDispatchUIFrameCallback);
                throw th;
            }
        }
    }
}
