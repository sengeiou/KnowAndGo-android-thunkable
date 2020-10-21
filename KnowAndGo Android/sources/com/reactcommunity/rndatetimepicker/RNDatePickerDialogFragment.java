package com.reactcommunity.rndatetimepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.room.RoomDatabase;
import java.util.Calendar;
import java.util.Locale;

@SuppressLint({"ValidFragment"})
public class RNDatePickerDialogFragment extends DialogFragment {
    @Nullable
    private static DialogInterface.OnClickListener mOnNeutralButtonActionListener;
    private DatePickerDialog instance;
    @Nullable
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    @Nullable
    private DialogInterface.OnDismissListener mOnDismissListener;

    public Dialog onCreateDialog(Bundle bundle) {
        this.instance = createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
        return this.instance;
    }

    public void update(Bundle bundle) {
        RNDate rNDate = new RNDate(bundle);
        this.instance.updateDate(rNDate.year(), rNDate.month(), rNDate.day());
    }

    @NonNull
    static DatePickerDialog getDialog(Bundle bundle, Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener) {
        RNDate rNDate = new RNDate(bundle);
        int year = rNDate.year();
        int month = rNDate.month();
        int day = rNDate.day();
        RNDatePickerDisplay valueOf = (bundle == null || bundle.getString("display", (String) null) == null) ? RNDatePickerDisplay.DEFAULT : RNDatePickerDisplay.valueOf(bundle.getString("display").toUpperCase(Locale.US));
        if (Build.VERSION.SDK_INT >= 21) {
            switch (valueOf) {
                case CALENDAR:
                case SPINNER:
                    return new RNDismissableDatePickerDialog(context, context.getResources().getIdentifier(valueOf == RNDatePickerDisplay.CALENDAR ? "CalendarDatePickerDialog" : "SpinnerDatePickerDialog", TtmlNode.TAG_STYLE, context.getPackageName()), onDateSetListener, year, month, day, valueOf);
                default:
                    return new RNDismissableDatePickerDialog(context, onDateSetListener, year, month, day, valueOf);
            }
        } else {
            RNDismissableDatePickerDialog rNDismissableDatePickerDialog = new RNDismissableDatePickerDialog(context, onDateSetListener, year, month, day, valueOf);
            switch (valueOf) {
                case CALENDAR:
                    rNDismissableDatePickerDialog.getDatePicker().setCalendarViewShown(true);
                    rNDismissableDatePickerDialog.getDatePicker().setSpinnersShown(false);
                    break;
                case SPINNER:
                    rNDismissableDatePickerDialog.getDatePicker().setCalendarViewShown(false);
                    break;
            }
            return rNDismissableDatePickerDialog;
        }
    }

    static DatePickerDialog createDialog(Bundle bundle, Context context, @Nullable DatePickerDialog.OnDateSetListener onDateSetListener) {
        Calendar instance2 = Calendar.getInstance();
        DatePickerDialog dialog = getDialog(bundle, context, onDateSetListener);
        if (bundle != null && bundle.containsKey(RNConstants.ARG_NEUTRAL_BUTTON_LABEL)) {
            dialog.setButton(-3, bundle.getString(RNConstants.ARG_NEUTRAL_BUTTON_LABEL), mOnNeutralButtonActionListener);
        }
        DatePicker datePicker = dialog.getDatePicker();
        if (bundle == null || !bundle.containsKey(RNConstants.ARG_MINDATE)) {
            datePicker.setMinDate(RNConstants.DEFAULT_MIN_DATE);
        } else {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MINDATE));
            instance2.set(11, 0);
            instance2.set(12, 0);
            instance2.set(13, 0);
            instance2.set(14, 0);
            datePicker.setMinDate(instance2.getTimeInMillis());
        }
        if (bundle != null && bundle.containsKey(RNConstants.ARG_MAXDATE)) {
            instance2.setTimeInMillis(bundle.getLong(RNConstants.ARG_MAXDATE));
            instance2.set(11, 23);
            instance2.set(12, 59);
            instance2.set(13, 59);
            instance2.set(14, RoomDatabase.MAX_BIND_PARAMETER_CNT);
            datePicker.setMaxDate(instance2.getTimeInMillis());
        }
        return dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.mOnDismissListener != null) {
            this.mOnDismissListener.onDismiss(dialogInterface);
        }
    }

    /* access modifiers changed from: package-private */
    public void setOnDateSetListener(@Nullable DatePickerDialog.OnDateSetListener onDateSetListener) {
        this.mOnDateSetListener = onDateSetListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnDismissListener(@Nullable DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    /* access modifiers changed from: package-private */
    public void setOnNeutralButtonActionListener(@Nullable DialogInterface.OnClickListener onClickListener) {
        mOnNeutralButtonActionListener = onClickListener;
    }
}
