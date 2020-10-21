package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.UIImplementation;
import com.swmansion.reanimated.C2845Utils;
import com.swmansion.reanimated.NodesManager;
import java.util.Map;

public class PropsNode extends Node implements FinalNode {
    private int mConnectedViewTag = -1;
    private final ReactStylesDiffMap mDiffMap;
    private final Map<String, Integer> mMapping;
    private final JavaOnlyMap mPropMap;
    private final UIImplementation mUIImplementation;

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof WritableArray) {
            writableMap.putArray(str, (WritableArray) obj);
        } else if (obj instanceof WritableMap) {
            writableMap.putMap(str, (WritableMap) obj);
        } else {
            throw new IllegalStateException("Unknown type of animated value");
        }
    }

    public PropsNode(int i, ReadableMap readableMap, NodesManager nodesManager, UIImplementation uIImplementation) {
        super(i, readableMap, nodesManager);
        this.mMapping = C2845Utils.processMapping(readableMap.getMap("props"));
        this.mUIImplementation = uIImplementation;
        this.mPropMap = new JavaOnlyMap();
        this.mDiffMap = new ReactStylesDiffMap(this.mPropMap);
    }

    public void connectToView(int i) {
        this.mConnectedViewTag = i;
        dangerouslyRescheduleEvaluate();
    }

    public void disconnectFromView(int i) {
        this.mConnectedViewTag = -1;
    }

    /* access modifiers changed from: protected */
    public Double evaluate() {
        boolean z;
        WritableMap writableMap;
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        for (Map.Entry next : this.mMapping.entrySet()) {
            Node findNodeById = this.mNodesManager.findNodeById(((Integer) next.getValue()).intValue(), Node.class);
            if (findNodeById instanceof StyleNode) {
                WritableMap writableMap2 = (WritableMap) findNodeById.value();
                ReadableMapKeySetIterator keySetIterator = writableMap2.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    if (this.mNodesManager.uiProps.contains(nextKey)) {
                        writableMap = this.mPropMap;
                        z = true;
                    } else if (this.mNodesManager.nativeProps.contains(nextKey)) {
                        z = z2;
                        z3 = true;
                        writableMap = createMap2;
                    } else {
                        z = z2;
                        z4 = true;
                        writableMap = createMap;
                    }
                    ReadableType type = writableMap2.getType(nextKey);
                    switch (type) {
                        case Number:
                            writableMap.putDouble(nextKey, writableMap2.getDouble(nextKey));
                            break;
                        case String:
                            writableMap.putString(nextKey, writableMap2.getString(nextKey));
                            break;
                        case Array:
                            writableMap.putArray(nextKey, (WritableArray) writableMap2.getArray(nextKey));
                            break;
                        default:
                            throw new IllegalArgumentException("Unexpected type " + type);
                    }
                    z2 = z;
                }
                continue;
            } else {
                String str = (String) next.getKey();
                Object value = findNodeById.value();
                if (this.mNodesManager.uiProps.contains(str)) {
                    addProp(this.mPropMap, str, value);
                    z2 = true;
                } else {
                    addProp(createMap2, str, value);
                    z3 = true;
                }
            }
        }
        if (this.mConnectedViewTag != -1) {
            if (z2) {
                this.mUIImplementation.synchronouslyUpdateViewOnUIThread(this.mConnectedViewTag, this.mDiffMap);
            }
            if (z3) {
                this.mNodesManager.enqueueUpdateViewOnNativeThread(this.mConnectedViewTag, createMap2);
            }
            if (z4) {
                WritableMap createMap3 = Arguments.createMap();
                createMap3.putInt("viewTag", this.mConnectedViewTag);
                createMap3.putMap("props", createMap);
                this.mNodesManager.sendEvent("onReanimatedPropsChange", createMap3);
            }
        }
        return ZERO;
    }

    public void update() {
        if (this.mConnectedViewTag != -1) {
            value();
        }
    }
}
