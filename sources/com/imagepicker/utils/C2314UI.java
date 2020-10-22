package com.imagepicker.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.facebook.react.bridge.ReadableMap;
import com.imagepicker.C2307R;
import com.imagepicker.ImagePickerModule;
import com.onesignal.OneSignalDbContract;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: com.imagepicker.utils.UI */
public class C2314UI {

    /* renamed from: com.imagepicker.utils.UI$OnAction */
    public interface OnAction {
        void onCancel(@Nullable ImagePickerModule imagePickerModule);

        void onCustomButton(@Nullable ImagePickerModule imagePickerModule, String str);

        void onTakePhoto(@Nullable ImagePickerModule imagePickerModule);

        void onUseLibrary(@Nullable ImagePickerModule imagePickerModule);
    }

    @NonNull
    public static AlertDialog chooseDialog(@Nullable ImagePickerModule imagePickerModule, @NonNull ReadableMap readableMap, @Nullable final OnAction onAction) {
        Activity activity = imagePickerModule.getActivity();
        if (activity == null) {
            return null;
        }
        final WeakReference weakReference = new WeakReference(imagePickerModule);
        ButtonsHelper newInstance = ButtonsHelper.newInstance(readableMap);
        List<String> titles = newInstance.getTitles();
        final List<String> actions = newInstance.getActions();
        ArrayAdapter arrayAdapter = new ArrayAdapter(activity, C2307R.layout.list_item, titles);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, imagePickerModule.getDialogThemeId());
        if (ReadableMapUtils.hasAndNotEmptyString(readableMap, OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE)) {
            builder.setTitle((CharSequence) readableMap.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE));
        }
        builder.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:18:0x004c  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.content.DialogInterface r2, int r3) {
                /*
                    r1 = this;
                    java.util.List r2 = r4
                    java.lang.Object r2 = r2.get(r3)
                    java.lang.String r2 = (java.lang.String) r2
                    int r3 = r2.hashCode()
                    r0 = -1367724422(0xffffffffae7a2e7a, float:-5.68847E-11)
                    if (r3 == r0) goto L_0x0030
                    r0 = 106642994(0x65b3e32, float:4.1235016E-35)
                    if (r3 == r0) goto L_0x0026
                    r0 = 166208699(0x9e824bb, float:5.588651E-33)
                    if (r3 == r0) goto L_0x001c
                    goto L_0x003a
                L_0x001c:
                    java.lang.String r3 = "library"
                    boolean r3 = r2.equals(r3)
                    if (r3 == 0) goto L_0x003a
                    r3 = 1
                    goto L_0x003b
                L_0x0026:
                    java.lang.String r3 = "photo"
                    boolean r3 = r2.equals(r3)
                    if (r3 == 0) goto L_0x003a
                    r3 = 0
                    goto L_0x003b
                L_0x0030:
                    java.lang.String r3 = "cancel"
                    boolean r3 = r2.equals(r3)
                    if (r3 == 0) goto L_0x003a
                    r3 = 2
                    goto L_0x003b
                L_0x003a:
                    r3 = -1
                L_0x003b:
                    switch(r3) {
                        case 0: goto L_0x0068;
                        case 1: goto L_0x005a;
                        case 2: goto L_0x004c;
                        default: goto L_0x003e;
                    }
                L_0x003e:
                    com.imagepicker.utils.UI$OnAction r3 = r9
                    java.lang.ref.WeakReference r0 = r1
                    java.lang.Object r0 = r0.get()
                    com.imagepicker.ImagePickerModule r0 = (com.imagepicker.ImagePickerModule) r0
                    r3.onCustomButton(r0, r2)
                    goto L_0x0075
                L_0x004c:
                    com.imagepicker.utils.UI$OnAction r2 = r9
                    java.lang.ref.WeakReference r3 = r1
                    java.lang.Object r3 = r3.get()
                    com.imagepicker.ImagePickerModule r3 = (com.imagepicker.ImagePickerModule) r3
                    r2.onCancel(r3)
                    goto L_0x0075
                L_0x005a:
                    com.imagepicker.utils.UI$OnAction r2 = r9
                    java.lang.ref.WeakReference r3 = r1
                    java.lang.Object r3 = r3.get()
                    com.imagepicker.ImagePickerModule r3 = (com.imagepicker.ImagePickerModule) r3
                    r2.onUseLibrary(r3)
                    goto L_0x0075
                L_0x0068:
                    com.imagepicker.utils.UI$OnAction r2 = r9
                    java.lang.ref.WeakReference r3 = r1
                    java.lang.Object r3 = r3.get()
                    com.imagepicker.ImagePickerModule r3 = (com.imagepicker.ImagePickerModule) r3
                    r2.onTakePhoto(r3)
                L_0x0075:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.utils.C2314UI.C23151.onClick(android.content.DialogInterface, int):void");
            }
        });
        builder.setNegativeButton((CharSequence) newInstance.btnCancel.title, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                onAction.onCancel((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        AlertDialog create = builder.create();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(@NonNull DialogInterface dialogInterface) {
                onAction.onCancel((ImagePickerModule) weakReference.get());
                dialogInterface.dismiss();
            }
        });
        return create;
    }
}
