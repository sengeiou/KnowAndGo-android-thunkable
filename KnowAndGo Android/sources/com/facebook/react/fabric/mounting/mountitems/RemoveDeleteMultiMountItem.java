package com.facebook.react.fabric.mounting.mountitems;

import androidx.annotation.NonNull;
import com.facebook.react.fabric.mounting.MountingManager;
import org.apache.commons.lang3.StringUtils;

public class RemoveDeleteMultiMountItem implements MountItem {
    private static final int DELETE_FLAG = 2;
    private static final int FLAGS_INDEX = 3;
    private static final int INSTRUCTION_FIELDS_LEN = 4;
    private static final int PARENT_TAG_INDEX = 1;
    private static final int REMOVE_FLAG = 1;
    private static final int TAG_INDEX = 0;
    private static final int VIEW_INDEX_INDEX = 2;
    @NonNull
    private int[] mMetadata;

    public RemoveDeleteMultiMountItem(@NonNull int[] iArr) {
        this.mMetadata = iArr;
    }

    public void execute(@NonNull MountingManager mountingManager) {
        for (int i = 0; i < this.mMetadata.length; i += 4) {
            if ((this.mMetadata[i + 3] & 1) != 0) {
                mountingManager.removeViewAt(this.mMetadata[i + 1], this.mMetadata[i + 2]);
            }
        }
        for (int i2 = 0; i2 < this.mMetadata.length; i2 += 4) {
            if ((this.mMetadata[i2 + 3] & 2) != 0) {
                mountingManager.deleteView(this.mMetadata[i2 + 0]);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.mMetadata.length; i += 4) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("RemoveDeleteMultiMountItem (");
            sb.append((i / 4) + 1);
            sb.append("/");
            sb.append(this.mMetadata.length / 4);
            sb.append("): [");
            sb.append(this.mMetadata[i + 0]);
            sb.append("] parent [");
            sb.append(this.mMetadata[i + 1]);
            sb.append("] idx ");
            sb.append(this.mMetadata[i + 2]);
            sb.append(StringUtils.SPACE);
            sb.append(this.mMetadata[i + 3]);
        }
        return sb.toString();
    }
}
