package com.reactcommunity.rndatetimepicker;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import java.util.Locale;

public class RNTimePickerDialogFragment extends DialogFragment {
    @Nullable
    private static DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    private TimePickerDialog instance;
    @Nullable
    private DialogInterface.OnDismissListener mOnDismissListener;
    @Nullable
    private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;

    public Dialog onCreateDialog(Bundle bundle) {
        this.instance = createDialog(getArguments(), getActivity(), this.mOnTimeSetListener);
        return this.instance;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateTime(rNDate.hour(), rNDate.minute());
    }

    static TimePickerDialog getDialog(Bundle bundle, Context context, @Nullable TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int hour = rNDate.hour();
        int minute = rNDate.minute();
        boolean is24HourFormat = DateFormat.is24HourFormat(context);
        RNTimePickerDisplay rNTimePickerDisplay = RNTimePickerDisplay.DEFAULT;
        if (!(bundle == null || bundle.getString("display", (String) null) == null)) {
            rNTimePickerDisplay = RNTimePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        }
        RNTimePickerDisplay rNTimePickerDisplay2 = rNTimePickerDisplay;
        boolean z = bundle != null ? bundle.getBoolean(RNConstants.ARG_IS24HOUR, DateFormat.is24HourFormat(context)) : is24HourFormat;
        if (Build.VERSION.SDK_INT >= 21) {
            switch (rNTimePickerDisplay2) {
                case CLOCK:
                case SPINNER:
                    return new RNDismissableTimePickerDialog(context, context.getResources().getIdentifier(rNTimePickerDisplay2 == RNTimePickerDisplay.CLOCK ? "ClockTimePickerDialog" : "SpinnerTimePickerDialog", TtmlNode.TAG_STYLE, context.getPackageName()), onTimeSetListener, hour, minute, z, rNTimePickerDisplay2);
            }
        }
        return new RNDismissableTimePickerDialog(context, onTimeSetListener, hour, minute, z, rNTimePickerDisplay2);
    }

    static TimePickerDialog createDialog(Bundle bundle, Context context, @Nullable TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        TimePickerDialog dialog = getDialog(bundle, context, onTimeSetListener);
        if (bundle != null && bundle.containsKey(RNConstants.ARG_NEUTRAL_BUTTON_LABEL)) {
            dialog.setButton(-3, bundle.getString(RNConstants.ARG_NEUTRAL_BUTTON_LABEL), mOnNeutralButtonActionListener);
        }
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss(dialogInterface);
        }
    }

    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setOnTimeSetListener(@Nullable TimePickerDialog.OnTimeSetListener onTimeSetListener) {
        this.mOnTimeSetListener = onTimeSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(@Nullable DialogInterface.OnClickListener onClickListener) {
        mOnNeutralButtonActionListener = onClickListener;
    }
}
