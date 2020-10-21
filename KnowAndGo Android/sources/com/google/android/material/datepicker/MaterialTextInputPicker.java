package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.Iterator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class MaterialTextInputPicker<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String DATE_SELECTOR_KEY = "DATE_SELECTOR_KEY";
    @Nullable
    private CalendarConstraints calendarConstraints;
    @Nullable
    private DateSelector<S> dateSelector;

    @NonNull
    static <T> MaterialTextInputPicker<T> newInstance(@NonNull DateSelector<T> dateSelector2, @NonNull CalendarConstraints calendarConstraints2) {
        MaterialTextInputPicker<T> materialTextInputPicker = new MaterialTextInputPicker<>();
        Bundle bundle = new Bundle();
        bundle.putParcelable(DATE_SELECTOR_KEY, dateSelector2);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints2);
        materialTextInputPicker.setArguments(bundle);
        return materialTextInputPicker;
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(DATE_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.dateSelector = (DateSelector) bundle.getParcelable(DATE_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) bundle.getParcelable(CALENDAR_CONSTRAINTS_KEY);
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        return this.dateSelector.onCreateTextInputView(layoutInflater, viewGroup, bundle, this.calendarConstraints, new OnSelectionChangedListener<S>() {
            public void onSelectionChanged(S s) {
                Iterator it = MaterialTextInputPicker.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    ((OnSelectionChangedListener) it.next()).onSelectionChanged(s);
                }
            }
        });
    }

    @NonNull
    public DateSelector<S> getDateSelector() {
        if (this.dateSelector != null) {
            return this.dateSelector;
        }
        throw new IllegalStateException("dateSelector should not be null. Use MaterialTextInputPicker#newInstance() to create this fragment with a DateSelector, and call this method after the fragment has been created.");
    }
}
