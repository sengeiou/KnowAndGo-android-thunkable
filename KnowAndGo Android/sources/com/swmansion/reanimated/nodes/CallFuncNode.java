package com.swmansion.reanimated.nodes;

import com.facebook.react.bridge.ReadableMap;
import com.swmansion.reanimated.C2845Utils;
import com.swmansion.reanimated.NodesManager;
import com.swmansion.reanimated.UpdateContext;
import org.apache.commons.p032io.IOUtils;

public class CallFuncNode extends Node {
    private final int[] mArgs;
    private final int[] mParams;
    private String mPreviousCallID;
    private final int mWhatNodeID;

    public CallFuncNode(int i, ReadableMap readableMap, NodesManager nodesManager) {
        super(i, readableMap, nodesManager);
        this.mWhatNodeID = readableMap.getInt("what");
        this.mParams = C2845Utils.processIntArray(readableMap.getArray("params"));
        this.mArgs = C2845Utils.processIntArray(readableMap.getArray("args"));
    }

    private void beginContext() {
        this.mPreviousCallID = this.mNodesManager.updateContext.callID;
        UpdateContext updateContext = this.mNodesManager.updateContext;
        updateContext.callID = this.mNodesManager.updateContext.callID + IOUtils.DIR_SEPARATOR_UNIX + String.valueOf(this.mNodeID);
        for (int i = 0; i < this.mParams.length; i++) {
            ((ParamNode) this.mNodesManager.findNodeById(this.mParams[i], ParamNode.class)).beginContext(Integer.valueOf(this.mArgs[i]), this.mPreviousCallID);
        }
    }

    private void endContext() {
        for (int findNodeById : this.mParams) {
            ((ParamNode) this.mNodesManager.findNodeById(findNodeById, ParamNode.class)).endContext();
        }
        this.mNodesManager.updateContext.callID = this.mPreviousCallID;
    }

    /* access modifiers changed from: protected */
    public Object evaluate() {
        beginContext();
        Object value = this.mNodesManager.findNodeById(this.mWhatNodeID, Node.class).value();
        endContext();
        return value;
    }
}
