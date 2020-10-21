package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;

public class MemoryChunkUtil {
    static int adjustByteCount(int i, int i2, int i3) {
        return Math.min(Math.max(0, i3 - i), i2);
    }

    static void checkBounds(int i, int i2, int i3, int i4, int i5) {
        boolean z = false;
        Preconditions.checkArgument(i4 >= 0);
        Preconditions.checkArgument(i >= 0);
        Preconditions.checkArgument(i3 >= 0);
        Preconditions.checkArgument(i + i4 <= i5);
        if (i3 + i4 <= i2) {
            z = true;
        }
        Preconditions.checkArgument(z);
    }
}
