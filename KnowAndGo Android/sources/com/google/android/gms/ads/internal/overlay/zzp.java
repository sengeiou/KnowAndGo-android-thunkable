package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzazt;
import com.google.android.gms.internal.ads.zzyt;
import javax.annotation.Nullable;

@zzard
public final class zzp extends FrameLayout implements View.OnClickListener {
    private final ImageButton zzdku;
    private final zzx zzdkv;

    public zzp(Context context, zzq zzq, @Nullable zzx zzx) {
        super(context);
        this.zzdkv = zzx;
        setOnClickListener(this);
        this.zzdku = new ImageButton(context);
        this.zzdku.setImageResource(17301527);
        this.zzdku.setBackgroundColor(0);
        this.zzdku.setOnClickListener(this);
        ImageButton imageButton = this.zzdku;
        zzyt.zzpa();
        int zza = zzazt.zza(context, zzq.paddingLeft);
        zzyt.zzpa();
        int zza2 = zzazt.zza(context, 0);
        zzyt.zzpa();
        int zza3 = zzazt.zza(context, zzq.paddingRight);
        zzyt.zzpa();
        imageButton.setPadding(zza, zza2, zza3, zzazt.zza(context, zzq.paddingBottom));
        this.zzdku.setContentDescription("Interstitial close button");
        ImageButton imageButton2 = this.zzdku;
        zzyt.zzpa();
        int zza4 = zzazt.zza(context, zzq.size + zzq.paddingLeft + zzq.paddingRight);
        zzyt.zzpa();
        addView(imageButton2, new FrameLayout.LayoutParams(zza4, zzazt.zza(context, zzq.size + zzq.paddingBottom), 17));
    }

    public final void onClick(View view) {
        if (this.zzdkv != null) {
            this.zzdkv.zztf();
        }
    }

    public final void zzaf(boolean z) {
        if (z) {
            this.zzdku.setVisibility(8);
        } else {
            this.zzdku.setVisibility(0);
        }
    }
}
