package com.google.android.gms.internal.ads;

import android.graphics.Color;
import com.theartofdev.edmodo.cropper.CropImage;
import java.util.ArrayList;
import java.util.List;

@zzard
public final class zzadt extends zzaeb {
    private static final int zzcxy = Color.rgb(12, 174, 206);
    private static final int zzcxz;
    private static final int zzcya;
    private static final int zzcyb = zzcxy;
    private final int backgroundColor;
    private final int textColor;
    private final int textSize;
    private final String zzcyc;
    private final List<zzadw> zzcyd = new ArrayList();
    private final List<zzaei> zzcye = new ArrayList();
    private final int zzcyf;
    private final int zzcyg;
    private final boolean zzcyh;

    public zzadt(String str, List<zzadw> list, Integer num, Integer num2, Integer num3, int i, int i2, boolean z) {
        this.zzcyc = str;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                zzadw zzadw = list.get(i3);
                this.zzcyd.add(zzadw);
                this.zzcye.add(zzadw);
            }
        }
        this.backgroundColor = num != null ? num.intValue() : zzcya;
        this.textColor = num2 != null ? num2.intValue() : zzcyb;
        this.textSize = num3 != null ? num3.intValue() : 12;
        this.zzcyf = i;
        this.zzcyg = i2;
        this.zzcyh = z;
    }

    public final String getText() {
        return this.zzcyc;
    }

    public final List<zzaei> zzra() {
        return this.zzcye;
    }

    public final List<zzadw> zzrb() {
        return this.zzcyd;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final int zzrc() {
        return this.zzcyf;
    }

    public final int zzrd() {
        return this.zzcyg;
    }

    static {
        int rgb = Color.rgb(CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE);
        zzcxz = rgb;
        zzcya = rgb;
    }
}
