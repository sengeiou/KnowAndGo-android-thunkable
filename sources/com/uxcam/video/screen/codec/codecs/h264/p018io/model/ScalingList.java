package com.uxcam.video.screen.codec.codecs.h264.p018io.model;

import androidx.core.view.InputDeviceCompat;
import com.uxcam.internals.C3214gk;
import com.uxcam.internals.C3219gp;
import com.uxcam.internals.C3231hb;
import com.uxcam.internals.C3232hc;

/* renamed from: com.uxcam.video.screen.codec.codecs.h264.io.model.ScalingList */
public class ScalingList {
    public int[] scalingList;
    public boolean useDefaultScalingMatrixFlag;

    public static ScalingList read(C3231hb hbVar, int i) {
        ScalingList scalingList2 = new ScalingList();
        scalingList2.scalingList = new int[i];
        int i2 = 0;
        int i3 = 8;
        int i4 = 8;
        while (i2 < i) {
            if (i3 != 0) {
                i3 = ((C3214gk.m2151c(hbVar) + i4) + 256) % 256;
                scalingList2.useDefaultScalingMatrixFlag = i2 == 0 && i3 == 0;
            }
            int[] iArr = scalingList2.scalingList;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i2] = i4;
            i4 = scalingList2.scalingList[i2];
            i2++;
        }
        return scalingList2;
    }

    public void write(C3232hc hcVar) {
        if (this.useDefaultScalingMatrixFlag) {
            C3219gp.m2184b(hcVar, 0);
            return;
        }
        int i = 8;
        for (int i2 = 0; i2 < this.scalingList.length; i2++) {
            C3219gp.m2184b(hcVar, (this.scalingList[i2] - i) + InputDeviceCompat.SOURCE_ANY);
            i = this.scalingList[i2];
        }
    }
}
