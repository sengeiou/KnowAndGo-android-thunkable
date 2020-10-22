package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@zzard
public final class zzadu extends RelativeLayout {
    private static final float[] zzcyi = {5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f};
    @Nullable
    private AnimationDrawable zzcyj;

    public zzadu(Context context, zzadt zzadt, RelativeLayout.LayoutParams layoutParams) {
        super(context);
        Preconditions.checkNotNull(zzadt);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(zzcyi, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(zzadt.getBackgroundColor());
        setLayoutParams(layoutParams);
        zzk.zzli().setBackground(this, shapeDrawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        if (!TextUtils.isEmpty(zzadt.getText())) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            TextView textView = new TextView(context);
            textView.setLayoutParams(layoutParams3);
            textView.setId(1195835393);
            textView.setTypeface(Typeface.DEFAULT);
            textView.setText(zzadt.getText());
            textView.setTextColor(zzadt.getTextColor());
            textView.setTextSize((float) zzadt.getTextSize());
            zzyt.zzpa();
            int zza = zzazt.zza(context, 4);
            zzyt.zzpa();
            textView.setPadding(zza, 0, zzazt.zza(context, 4), 0);
            addView(textView);
            layoutParams2.addRule(1, textView.getId());
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(layoutParams2);
        imageView.setId(1195835394);
        List<zzadw> zzrb = zzadt.zzrb();
        if (zzrb != null && zzrb.size() > 1) {
            this.zzcyj = new AnimationDrawable();
            for (zzadw zzrf : zzrb) {
                try {
                    this.zzcyj.addFrame((Drawable) ObjectWrapper.unwrap(zzrf.zzrf()), zzadt.zzrc());
                } catch (Exception e) {
                    zzawz.zzc("Error while getting drawable.", e);
                }
            }
            zzk.zzli().setBackground(imageView, this.zzcyj);
        } else if (zzrb.size() == 1) {
            try {
                imageView.setImageDrawable((Drawable) ObjectWrapper.unwrap(zzrb.get(0).zzrf()));
            } catch (Exception e2) {
                zzawz.zzc("Error while getting drawable.", e2);
            }
        }
        addView(imageView);
    }

    public final void onAttachedToWindow() {
        if (this.zzcyj != null) {
            this.zzcyj.start();
        }
        super.onAttachedToWindow();
    }
}
