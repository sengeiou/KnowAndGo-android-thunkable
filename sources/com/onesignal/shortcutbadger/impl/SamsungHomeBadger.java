package com.onesignal.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import com.onesignal.shortcutbadger.Badger;
import com.onesignal.shortcutbadger.ShortcutBadgeException;
import com.onesignal.shortcutbadger.util.CloseHelper;
import java.util.Arrays;
import java.util.List;

public class SamsungHomeBadger implements Badger {
    private static final String[] CONTENT_PROJECTION = {"_id", "class"};
    private static final String CONTENT_URI = "content://com.sec.badge/apps?notify=true";
    private DefaultBadger defaultBadger;

    public SamsungHomeBadger() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.defaultBadger = new DefaultBadger();
        }
    }

    public void executeBadge(Context context, ComponentName componentName, int i) throws ShortcutBadgeException {
        Cursor cursor;
        if (this.defaultBadger == null || !this.defaultBadger.isSupported(context)) {
            Uri parse = Uri.parse(CONTENT_URI);
            ContentResolver contentResolver = context.getContentResolver();
            try {
                cursor = contentResolver.query(parse, CONTENT_PROJECTION, "package=?", new String[]{componentName.getPackageName()}, (String) null);
                if (cursor != null) {
                    try {
                        String className = componentName.getClassName();
                        boolean z = false;
                        while (cursor.moveToNext()) {
                            contentResolver.update(parse, getContentValues(componentName, i, false), "_id=?", new String[]{String.valueOf(cursor.getInt(0))});
                            if (className.equals(cursor.getString(cursor.getColumnIndex("class")))) {
                                z = true;
                            }
                        }
                        if (!z) {
                            contentResolver.insert(parse, getContentValues(componentName, i, true));
                        }
                    } catch (Throwable th) {
                        th = th;
                        CloseHelper.close(cursor);
                        throw th;
                    }
                }
                CloseHelper.close(cursor);
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
                CloseHelper.close(cursor);
                throw th;
            }
        } else {
            this.defaultBadger.executeBadge(context, componentName, i);
        }
    }

    private ContentValues getContentValues(ComponentName componentName, int i, boolean z) {
        ContentValues contentValues = new ContentValues();
        if (z) {
            contentValues.put("package", componentName.getPackageName());
            contentValues.put("class", componentName.getClassName());
        }
        contentValues.put("badgecount", Integer.valueOf(i));
        return contentValues;
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList(new String[]{"com.sec.android.app.launcher", "com.sec.android.app.twlauncher"});
    }
}
