package com.amplitude.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String CREATE_EVENTS_TABLE = "CREATE TABLE IF NOT EXISTS events (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_IDENTIFYS_TABLE = "CREATE TABLE IF NOT EXISTS identifys (id INTEGER PRIMARY KEY AUTOINCREMENT, event TEXT);";
    private static final String CREATE_LONG_STORE_TABLE = "CREATE TABLE IF NOT EXISTS long_store (key TEXT PRIMARY KEY NOT NULL, value INTEGER);";
    private static final String CREATE_STORE_TABLE = "CREATE TABLE IF NOT EXISTS store (key TEXT PRIMARY KEY NOT NULL, value TEXT);";
    private static final String EVENT_FIELD = "event";
    protected static final String EVENT_TABLE_NAME = "events";
    protected static final String IDENTIFY_TABLE_NAME = "identifys";
    private static final String ID_FIELD = "id";
    private static final String KEY_FIELD = "key";
    protected static final String LONG_STORE_TABLE_NAME = "long_store";
    protected static final String STORE_TABLE_NAME = "store";
    private static final String TAG = "com.amplitude.api.DatabaseHelper";
    private static final String VALUE_FIELD = "value";
    static final Map<String, DatabaseHelper> instances = new HashMap();
    private static final AmplitudeLog logger = AmplitudeLog.getLogger();
    private boolean callResetListenerOnDatabaseReset;
    private DatabaseResetListener databaseResetListener;
    File file;
    private String instanceName;

    @Deprecated
    static DatabaseHelper getDatabaseHelper(Context context) {
        return getDatabaseHelper(context, (String) null);
    }

    static synchronized DatabaseHelper getDatabaseHelper(Context context, String str) {
        DatabaseHelper databaseHelper;
        synchronized (DatabaseHelper.class) {
            String normalizeInstanceName = C0767Utils.normalizeInstanceName(str);
            databaseHelper = instances.get(normalizeInstanceName);
            if (databaseHelper == null) {
                databaseHelper = new DatabaseHelper(context.getApplicationContext(), normalizeInstanceName);
                instances.put(normalizeInstanceName, databaseHelper);
            }
        }
        return databaseHelper;
    }

    private static String getDatabaseName(String str) {
        if (C0767Utils.isEmptyString(str) || str.equals(Constants.DEFAULT_INSTANCE)) {
            return "com.amplitude.api";
        }
        return "com.amplitude.api_" + str;
    }

    protected DatabaseHelper(Context context) {
        this(context, (String) null);
    }

    protected DatabaseHelper(Context context, String str) {
        super(context, getDatabaseName(str), (SQLiteDatabase.CursorFactory) null, 3);
        this.callResetListenerOnDatabaseReset = true;
        this.file = context.getDatabasePath(getDatabaseName(str));
        this.instanceName = C0767Utils.normalizeInstanceName(str);
    }

    /* access modifiers changed from: package-private */
    public void setDatabaseResetListener(DatabaseResetListener databaseResetListener2) {
        this.databaseResetListener = databaseResetListener2;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        sQLiteDatabase.execSQL(CREATE_EVENTS_TABLE);
        sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
        if (this.databaseResetListener != null && this.callResetListenerOnDatabaseReset) {
            try {
                this.callResetListenerOnDatabaseReset = false;
                this.databaseResetListener.onDatabaseReset(sQLiteDatabase);
            } catch (SQLiteException e) {
                logger.mo10497e(TAG, String.format("databaseReset callback failed during onCreate", new Object[0]), e);
                Diagnostics.getLogger().logError(String.format("DB: Failed to run databaseReset callback during onCreate", new Object[0]), e);
            } catch (Throwable th) {
                this.callResetListenerOnDatabaseReset = true;
                throw th;
            }
            this.callResetListenerOnDatabaseReset = true;
        }
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i > i2) {
            logger.mo10496e(TAG, "onUpgrade() with invalid oldVersion and newVersion");
            resetDatabase(sQLiteDatabase);
        } else if (i2 > 1) {
            switch (i) {
                case 1:
                    sQLiteDatabase.execSQL(CREATE_STORE_TABLE);
                    if (i2 <= 2) {
                        return;
                    }
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    AmplitudeLog amplitudeLog = logger;
                    amplitudeLog.mo10496e(TAG, "onUpgrade() with unknown oldVersion " + i);
                    resetDatabase(sQLiteDatabase);
                    return;
            }
            sQLiteDatabase.execSQL(CREATE_IDENTIFYS_TABLE);
            sQLiteDatabase.execSQL(CREATE_LONG_STORE_TABLE);
        }
    }

    private void resetDatabase(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS long_store");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS identifys");
        onCreate(sQLiteDatabase);
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValue(String str, String str2) {
        long j;
        if (str2 == null) {
            try {
                j = deleteKeyFromTable(STORE_TABLE_NAME, str);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = insertOrReplaceKeyValueToTable(STORE_TABLE_NAME, str, str2);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyLongValue(String str, Long l) {
        long j;
        if (l == null) {
            try {
                j = deleteKeyFromTable(LONG_STORE_TABLE_NAME, str);
            } catch (Throwable th) {
                throw th;
            }
        } else {
            j = insertOrReplaceKeyValueToTable(LONG_STORE_TABLE_NAME, str, l);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r2.isOpen() != false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0086, code lost:
        if (r2.isOpen() != false) goto L_0x0056;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050 A[SYNTHETIC, Splitter:B:23:0x0050] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[SYNTHETIC, Splitter:B:31:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008d A[SYNTHETIC, Splitter:B:37:0x008d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0029=Splitter:B:20:0x0029, B:28:0x005b=Splitter:B:28:0x005b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized long insertOrReplaceKeyValueToTable(java.lang.String r10, java.lang.String r11, java.lang.Object r12) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = -1
            r2 = 0
            r3 = 0
            r4 = 1
            android.database.sqlite.SQLiteDatabase r5 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x005a, StackOverflowError -> 0x0028 }
            long r6 = r9.insertOrReplaceKeyValueToTable(r5, r10, r11, r12)     // Catch:{ SQLiteException -> 0x0023, StackOverflowError -> 0x0020, all -> 0x001c }
            if (r5 == 0) goto L_0x0019
            boolean r10 = r5.isOpen()     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x0019
            r9.close()     // Catch:{ all -> 0x0097 }
        L_0x0019:
            r0 = r6
            goto L_0x0089
        L_0x001c:
            r10 = move-exception
            r2 = r5
            goto L_0x008b
        L_0x0020:
            r12 = move-exception
            r2 = r5
            goto L_0x0029
        L_0x0023:
            r12 = move-exception
            r2 = r5
            goto L_0x005b
        L_0x0026:
            r10 = move-exception
            goto L_0x008b
        L_0x0028:
            r12 = move-exception
        L_0x0029:
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r7 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x0026 }
            r8[r3] = r10     // Catch:{ all -> 0x0026 }
            java.lang.String r10 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x0026 }
            r5.mo10497e(r6, r10, r12)     // Catch:{ all -> 0x0026 }
            com.amplitude.api.Diagnostics r10 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = "DB: Failed to insertOrReplaceKeyValue %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0026 }
            r4[r3] = r11     // Catch:{ all -> 0x0026 }
            java.lang.String r11 = java.lang.String.format(r5, r4)     // Catch:{ all -> 0x0026 }
            r10.logError(r11, r12)     // Catch:{ all -> 0x0026 }
            r9.delete()     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0089
            boolean r10 = r2.isOpen()     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x0089
        L_0x0056:
            r9.close()     // Catch:{ all -> 0x0097 }
            goto L_0x0089
        L_0x005a:
            r12 = move-exception
        L_0x005b:
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r7 = "insertOrReplaceKeyValue in %s failed"
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch:{ all -> 0x0026 }
            r8[r3] = r10     // Catch:{ all -> 0x0026 }
            java.lang.String r10 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x0026 }
            r5.mo10497e(r6, r10, r12)     // Catch:{ all -> 0x0026 }
            com.amplitude.api.Diagnostics r10 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0026 }
            java.lang.String r5 = "DB: Failed to insertOrReplaceKeyValue %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0026 }
            r4[r3] = r11     // Catch:{ all -> 0x0026 }
            java.lang.String r11 = java.lang.String.format(r5, r4)     // Catch:{ all -> 0x0026 }
            r10.logError(r11, r12)     // Catch:{ all -> 0x0026 }
            r9.delete()     // Catch:{ all -> 0x0026 }
            if (r2 == 0) goto L_0x0089
            boolean r10 = r2.isOpen()     // Catch:{ all -> 0x0097 }
            if (r10 == 0) goto L_0x0089
            goto L_0x0056
        L_0x0089:
            monitor-exit(r9)
            return r0
        L_0x008b:
            if (r2 == 0) goto L_0x0099
            boolean r11 = r2.isOpen()     // Catch:{ all -> 0x0097 }
            if (r11 == 0) goto L_0x0099
            r9.close()     // Catch:{ all -> 0x0097 }
            goto L_0x0099
        L_0x0097:
            r10 = move-exception
            goto L_0x009a
        L_0x0099:
            throw r10     // Catch:{ all -> 0x0097 }
        L_0x009a:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.insertOrReplaceKeyValueToTable(java.lang.String, java.lang.String, java.lang.Object):long");
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertOrReplaceKeyValueToTable(SQLiteDatabase sQLiteDatabase, String str, String str2, Object obj) throws SQLiteException, StackOverflowError {
        long insertKeyValueContentValuesIntoTable;
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_FIELD, str2);
        if (obj instanceof Long) {
            contentValues.put("value", (Long) obj);
        } else {
            contentValues.put("value", (String) obj);
        }
        insertKeyValueContentValuesIntoTable = insertKeyValueContentValuesIntoTable(sQLiteDatabase, str, contentValues);
        if (insertKeyValueContentValuesIntoTable == -1) {
            logger.mo10507w(TAG, "Insert failed");
        }
        return insertKeyValueContentValuesIntoTable;
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertKeyValueContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insertWithOnConflict(str, (String) null, contentValues, 5);
    }

    /* access modifiers changed from: package-private */
    public synchronized long deleteKeyFromTable(String str, String str2) {
        long j;
        j = -1;
        try {
            j = (long) getWritableDatabase().delete(str, "key=?", new String[]{str2});
            close();
        } catch (SQLiteException e) {
            logger.mo10497e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), e);
            Diagnostics.getLogger().logError(String.format("DB: Failed to deleteKey: %s", new Object[]{str2}), e);
            delete();
            close();
            return j;
        } catch (StackOverflowError e2) {
            try {
                logger.mo10497e(TAG, String.format("deleteKey from %s failed", new Object[]{str}), e2);
                Diagnostics.getLogger().logError(String.format("DB: Failed to deleteKey: %s", new Object[]{str2}), e2);
                delete();
                close();
                return j;
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long addEvent(String str) {
        return addEventToTable(EVENT_TABLE_NAME, str);
    }

    /* access modifiers changed from: package-private */
    public synchronized long addIdentify(String str) {
        return addEventToTable(IDENTIFY_TABLE_NAME, str);
    }

    private synchronized long addEventToTable(String str, String str2) {
        long j;
        SQLiteException e;
        StackOverflowError e2;
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("event", str2);
            j = insertEventContentValuesIntoTable(writableDatabase, str, contentValues);
            if (j == -1) {
                try {
                    logger.mo10507w(TAG, String.format("Insert into %s failed", new Object[]{str}));
                } catch (SQLiteException e3) {
                    e = e3;
                } catch (StackOverflowError e4) {
                    e2 = e4;
                    try {
                        logger.mo10497e(TAG, String.format("addEvent to %s failed", new Object[]{str}), e2);
                        Diagnostics.getLogger().logError(String.format("DB: Failed to addEvent: %s", new Object[]{str2}), e2);
                        delete();
                        close();
                        return j;
                    } catch (Throwable th) {
                        close();
                        throw th;
                    }
                }
            }
        } catch (SQLiteException e5) {
            e = e5;
            j = -1;
            logger.mo10497e(TAG, String.format("addEvent to %s failed", new Object[]{str}), e);
            Diagnostics.getLogger().logError(String.format("DB: Failed to addEvent: %s", new Object[]{str2}), e);
            delete();
            close();
            return j;
        } catch (StackOverflowError e6) {
            e2 = e6;
            j = -1;
            logger.mo10497e(TAG, String.format("addEvent to %s failed", new Object[]{str}), e2);
            Diagnostics.getLogger().logError(String.format("DB: Failed to addEvent: %s", new Object[]{str2}), e2);
            delete();
            close();
            return j;
        }
        close();
        return j;
    }

    /* access modifiers changed from: package-private */
    public synchronized long insertEventContentValuesIntoTable(SQLiteDatabase sQLiteDatabase, String str, ContentValues contentValues) throws SQLiteException, StackOverflowError {
        return sQLiteDatabase.insert(str, (String) null, contentValues);
    }

    /* access modifiers changed from: package-private */
    public synchronized String getValue(String str) {
        return (String) getValueFromTable(STORE_TABLE_NAME, str);
    }

    /* access modifiers changed from: package-private */
    public synchronized Long getLongValue(String str) {
        return (Long) getValueFromTable(LONG_STORE_TABLE_NAME, str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006d A[SYNTHETIC, Splitter:B:27:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[SYNTHETIC, Splitter:B:34:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b6 A[SYNTHETIC, Splitter:B:41:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00e3 A[SYNTHETIC, Splitter:B:48:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ed A[SYNTHETIC, Splitter:B:54:0x00ed] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0073=Splitter:B:31:0x0073, B:24:0x0057=Splitter:B:24:0x0057, B:45:0x00bc=Splitter:B:45:0x00bc, B:38:0x008f=Splitter:B:38:0x008f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.Object getValueFromTable(java.lang.String r14, java.lang.String r15) {
        /*
            r13 = this;
            monitor-enter(r13)
            r0 = 0
            r1 = 0
            r2 = 1
            android.database.sqlite.SQLiteDatabase r4 = r13.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00ba, StackOverflowError -> 0x008d, IllegalStateException -> 0x0071, RuntimeException -> 0x0055, all -> 0x0051 }
            java.lang.String r3 = "key"
            java.lang.String r5 = "value"
            java.lang.String[] r6 = new java.lang.String[]{r3, r5}     // Catch:{ SQLiteException -> 0x00ba, StackOverflowError -> 0x008d, IllegalStateException -> 0x0071, RuntimeException -> 0x0055, all -> 0x0051 }
            java.lang.String r7 = "key = ?"
            java.lang.String[] r8 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00ba, StackOverflowError -> 0x008d, IllegalStateException -> 0x0071, RuntimeException -> 0x0055, all -> 0x0051 }
            r8[r1] = r15     // Catch:{ SQLiteException -> 0x00ba, StackOverflowError -> 0x008d, IllegalStateException -> 0x0071, RuntimeException -> 0x0055, all -> 0x0051 }
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r3 = r13
            r5 = r14
            android.database.Cursor r3 = r3.queryDb(r4, r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ SQLiteException -> 0x00ba, StackOverflowError -> 0x008d, IllegalStateException -> 0x0071, RuntimeException -> 0x0055, all -> 0x0051 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x004e, StackOverflowError -> 0x004c, IllegalStateException -> 0x004a, RuntimeException -> 0x0048 }
            if (r4 == 0) goto L_0x003e
            java.lang.String r4 = "store"
            boolean r4 = r14.equals(r4)     // Catch:{ SQLiteException -> 0x004e, StackOverflowError -> 0x004c, IllegalStateException -> 0x004a, RuntimeException -> 0x0048 }
            if (r4 == 0) goto L_0x0035
            java.lang.String r4 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x004e, StackOverflowError -> 0x004c, IllegalStateException -> 0x004a, RuntimeException -> 0x0048 }
        L_0x0033:
            r0 = r4
            goto L_0x003e
        L_0x0035:
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x004e, StackOverflowError -> 0x004c, IllegalStateException -> 0x004a, RuntimeException -> 0x0048 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x004e, StackOverflowError -> 0x004c, IllegalStateException -> 0x004a, RuntimeException -> 0x0048 }
            goto L_0x0033
        L_0x003e:
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x00f1 }
        L_0x0043:
            r13.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x00e8
        L_0x0048:
            r14 = move-exception
            goto L_0x0057
        L_0x004a:
            r14 = move-exception
            goto L_0x0073
        L_0x004c:
            r4 = move-exception
            goto L_0x008f
        L_0x004e:
            r4 = move-exception
            goto L_0x00bc
        L_0x0051:
            r14 = move-exception
            r3 = r0
            goto L_0x00eb
        L_0x0055:
            r14 = move-exception
            r3 = r0
        L_0x0057:
            com.amplitude.api.Diagnostics r4 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = "DB: Failed to getValue: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r2[r1] = r15     // Catch:{ all -> 0x00ea }
            java.lang.String r15 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x00ea }
            r4.logError(r15, r14)     // Catch:{ all -> 0x00ea }
            convertIfCursorWindowException(r14)     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x0043
        L_0x0071:
            r14 = move-exception
            r3 = r0
        L_0x0073:
            com.amplitude.api.Diagnostics r4 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = "DB: Failed to getValue: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r2[r1] = r15     // Catch:{ all -> 0x00ea }
            java.lang.String r15 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x00ea }
            r4.logError(r15, r14)     // Catch:{ all -> 0x00ea }
            r13.handleIfCursorRowTooLargeException(r14)     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x0043
        L_0x008d:
            r4 = move-exception
            r3 = r0
        L_0x008f:
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x00ea }
            java.lang.String r6 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r7 = "getValue from %s failed"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r8[r1] = r14     // Catch:{ all -> 0x00ea }
            java.lang.String r14 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00ea }
            r5.mo10497e(r6, r14, r4)     // Catch:{ all -> 0x00ea }
            com.amplitude.api.Diagnostics r14 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = "DB: Failed to getValue: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r2[r1] = r15     // Catch:{ all -> 0x00ea }
            java.lang.String r15 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x00ea }
            r14.logError(r15, r4)     // Catch:{ all -> 0x00ea }
            r13.delete()     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x0043
        L_0x00ba:
            r4 = move-exception
            r3 = r0
        L_0x00bc:
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x00ea }
            java.lang.String r6 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r7 = "getValue from %s failed"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r8[r1] = r14     // Catch:{ all -> 0x00ea }
            java.lang.String r14 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00ea }
            r5.mo10497e(r6, r14, r4)     // Catch:{ all -> 0x00ea }
            com.amplitude.api.Diagnostics r14 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x00ea }
            java.lang.String r5 = "DB: Failed to getValue: %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00ea }
            r2[r1] = r15     // Catch:{ all -> 0x00ea }
            java.lang.String r15 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x00ea }
            r14.logError(r15, r4)     // Catch:{ all -> 0x00ea }
            r13.delete()     // Catch:{ all -> 0x00ea }
            if (r3 == 0) goto L_0x0043
            r3.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x0043
        L_0x00e8:
            monitor-exit(r13)
            return r0
        L_0x00ea:
            r14 = move-exception
        L_0x00eb:
            if (r3 == 0) goto L_0x00f3
            r3.close()     // Catch:{ all -> 0x00f1 }
            goto L_0x00f3
        L_0x00f1:
            r14 = move-exception
            goto L_0x00f7
        L_0x00f3:
            r13.close()     // Catch:{ all -> 0x00f1 }
            throw r14     // Catch:{ all -> 0x00f1 }
        L_0x00f7:
            monitor-exit(r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getValueFromTable(java.lang.String, java.lang.String):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    public synchronized List<JSONObject> getEvents(long j, long j2) throws JSONException {
        return getEventsFromTable(EVENT_TABLE_NAME, j, j2);
    }

    /* access modifiers changed from: package-private */
    public synchronized List<JSONObject> getIdentifys(long j, long j2) throws JSONException {
        return getEventsFromTable(IDENTIFY_TABLE_NAME, j, j2);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        r1 = null;
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0037, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0038, code lost:
        r1 = null;
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        r1 = null;
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r1 = null;
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b7, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b8, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bc, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00d9, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00f5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x00f6, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0124, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0125, code lost:
        r13 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b7 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d4 A[SYNTHETIC, Splitter:B:56:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00f1 A[SYNTHETIC, Splitter:B:64:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x011f A[SYNTHETIC, Splitter:B:72:0x011f] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x014e A[SYNTHETIC, Splitter:B:80:0x014e] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0158 A[SYNTHETIC, Splitter:B:86:0x0158] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:77:0x0127=Splitter:B:77:0x0127, B:69:0x00f8=Splitter:B:69:0x00f8, B:61:0x00db=Splitter:B:61:0x00db, B:53:0x00be=Splitter:B:53:0x00be} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<org.json.JSONObject> getEventsFromTable(java.lang.String r19, long r20, long r22) throws org.json.JSONException {
        /*
            r18 = this;
            r11 = r18
            r0 = r20
            r2 = r22
            monitor-enter(r18)
            java.util.LinkedList r12 = new java.util.LinkedList     // Catch:{ all -> 0x015f }
            r12.<init>()     // Catch:{ all -> 0x015f }
            r14 = 0
            r10 = 1
            android.database.sqlite.SQLiteDatabase r4 = r18.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0124, StackOverflowError -> 0x00f5, IllegalStateException -> 0x00d8, RuntimeException -> 0x00bb, all -> 0x00b7 }
            java.lang.String r5 = "id"
            java.lang.String r6 = "event"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6}     // Catch:{ SQLiteException -> 0x0124, StackOverflowError -> 0x00f5, IllegalStateException -> 0x00d8, RuntimeException -> 0x00bb, all -> 0x00b7 }
            r6 = 0
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 < 0) goto L_0x0046
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            r8.<init>()     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            java.lang.String r9 = "id <= "
            r8.append(r9)     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            r8.append(r0)     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            java.lang.String r0 = r8.toString()     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            goto L_0x0047
        L_0x0032:
            r0 = move-exception
            r1 = 0
            r13 = 1
            goto L_0x00be
        L_0x0037:
            r0 = move-exception
            r1 = 0
            r13 = 1
            goto L_0x00db
        L_0x003c:
            r0 = move-exception
            r1 = 0
            r13 = 1
            goto L_0x00f8
        L_0x0041:
            r0 = move-exception
            r1 = 0
            r13 = 1
            goto L_0x0127
        L_0x0046:
            r0 = 0
        L_0x0047:
            r8 = 0
            r9 = 0
            r15 = 0
            java.lang.String r16 = "id ASC"
            int r1 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0064
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            java.lang.String r6 = ""
            r1.append(r6)     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            r1.append(r2)     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            java.lang.String r1 = r1.toString()     // Catch:{ SQLiteException -> 0x0041, StackOverflowError -> 0x003c, IllegalStateException -> 0x0037, RuntimeException -> 0x0032, all -> 0x00b7 }
            r17 = r1
            goto L_0x0066
        L_0x0064:
            r17 = 0
        L_0x0066:
            r1 = r18
            r2 = r4
            r3 = r19
            r4 = r5
            r5 = r0
            r6 = r8
            r7 = r9
            r8 = r15
            r9 = r16
            r13 = 1
            r10 = r17
            android.database.Cursor r1 = r1.queryDb(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00b5, StackOverflowError -> 0x00b3, IllegalStateException -> 0x00b1, RuntimeException -> 0x00af, all -> 0x00b7 }
        L_0x0079:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            if (r0 == 0) goto L_0x009c
            long r2 = r1.getLong(r14)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            java.lang.String r0 = r1.getString(r13)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            boolean r4 = com.amplitude.api.C0767Utils.isEmptyString(r0)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            if (r4 == 0) goto L_0x008e
            goto L_0x0079
        L_0x008e:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            r4.<init>(r0)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            java.lang.String r0 = "event_id"
            r4.put(r0, r2)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            r12.add(r4)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x00aa, IllegalStateException -> 0x00a8, RuntimeException -> 0x00a6 }
            goto L_0x0079
        L_0x009c:
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x015f }
        L_0x00a1:
            r18.close()     // Catch:{ all -> 0x015f }
            goto L_0x0153
        L_0x00a6:
            r0 = move-exception
            goto L_0x00be
        L_0x00a8:
            r0 = move-exception
            goto L_0x00db
        L_0x00aa:
            r0 = move-exception
            goto L_0x00f8
        L_0x00ac:
            r0 = move-exception
            goto L_0x0127
        L_0x00af:
            r0 = move-exception
            goto L_0x00bd
        L_0x00b1:
            r0 = move-exception
            goto L_0x00da
        L_0x00b3:
            r0 = move-exception
            goto L_0x00f7
        L_0x00b5:
            r0 = move-exception
            goto L_0x0126
        L_0x00b7:
            r0 = move-exception
            r1 = 0
            goto L_0x0156
        L_0x00bb:
            r0 = move-exception
            r13 = 1
        L_0x00bd:
            r1 = 0
        L_0x00be:
            com.amplitude.api.Diagnostics r2 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "DB: Failed to getEventsFromTable %s"
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r4[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0155 }
            r2.logError(r3, r0)     // Catch:{ all -> 0x0155 }
            convertIfCursorWindowException(r0)     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x015f }
            goto L_0x00a1
        L_0x00d8:
            r0 = move-exception
            r13 = 1
        L_0x00da:
            r1 = 0
        L_0x00db:
            com.amplitude.api.Diagnostics r2 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "DB: Failed to getEventsFromTable %s"
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r4[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0155 }
            r2.logError(r3, r0)     // Catch:{ all -> 0x0155 }
            r11.handleIfCursorRowTooLargeException(r0)     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x015f }
            goto L_0x00a1
        L_0x00f5:
            r0 = move-exception
            r13 = 1
        L_0x00f7:
            r1 = 0
        L_0x00f8:
            com.amplitude.api.AmplitudeLog r2 = logger     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r4 = "getEvents from %s failed"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r5[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0155 }
            r2.mo10497e(r3, r4, r0)     // Catch:{ all -> 0x0155 }
            com.amplitude.api.Diagnostics r2 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "DB: Failed to getEventsFromTable %s"
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r4[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0155 }
            r2.logError(r3, r0)     // Catch:{ all -> 0x0155 }
            r18.delete()     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x015f }
            goto L_0x00a1
        L_0x0124:
            r0 = move-exception
            r13 = 1
        L_0x0126:
            r1 = 0
        L_0x0127:
            com.amplitude.api.AmplitudeLog r2 = logger     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r4 = "getEvents from %s failed"
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r5[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ all -> 0x0155 }
            r2.mo10497e(r3, r4, r0)     // Catch:{ all -> 0x0155 }
            com.amplitude.api.Diagnostics r2 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "DB: Failed to getEventsFromTable %s"
            java.lang.Object[] r4 = new java.lang.Object[r13]     // Catch:{ all -> 0x0155 }
            r4[r14] = r19     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch:{ all -> 0x0155 }
            r2.logError(r3, r0)     // Catch:{ all -> 0x0155 }
            r18.delete()     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x00a1
            r1.close()     // Catch:{ all -> 0x015f }
            goto L_0x00a1
        L_0x0153:
            monitor-exit(r18)
            return r12
        L_0x0155:
            r0 = move-exception
        L_0x0156:
            if (r1 == 0) goto L_0x015b
            r1.close()     // Catch:{ all -> 0x015f }
        L_0x015b:
            r18.close()     // Catch:{ all -> 0x015f }
            throw r0     // Catch:{ all -> 0x015f }
        L_0x015f:
            r0 = move-exception
            monitor-exit(r18)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventsFromTable(java.lang.String, long, long):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public synchronized long getEventCount() {
        return getEventCountFromTable(EVENT_TABLE_NAME);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getIdentifyCount() {
        return getEventCountFromTable(IDENTIFY_TABLE_NAME);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getTotalEventCount() {
        return getEventCount() + getIdentifyCount();
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0066 A[SYNTHETIC, Splitter:B:22:0x0066] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0095 A[SYNTHETIC, Splitter:B:29:0x0095] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009d A[SYNTHETIC, Splitter:B:34:0x009d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:26:0x006e=Splitter:B:26:0x006e, B:19:0x003f=Splitter:B:19:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long getEventCountFromTable(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 0
            r2 = 0
            r3 = 0
            r4 = 1
            android.database.sqlite.SQLiteDatabase r5 = r11.getReadableDatabase()     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            r6.<init>()     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            java.lang.String r7 = "SELECT COUNT(*) FROM "
            r6.append(r7)     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            r6.append(r12)     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            java.lang.String r6 = r6.toString()     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            android.database.sqlite.SQLiteStatement r5 = r5.compileStatement(r6)     // Catch:{ SQLiteException -> 0x006d, StackOverflowError -> 0x003e }
            long r6 = r5.simpleQueryForLong()     // Catch:{ SQLiteException -> 0x0037, StackOverflowError -> 0x0032, all -> 0x002e }
            if (r5 == 0) goto L_0x0028
            r5.close()     // Catch:{ all -> 0x00a1 }
        L_0x0028:
            r11.close()     // Catch:{ all -> 0x00a1 }
            r0 = r6
            goto L_0x0099
        L_0x002e:
            r12 = move-exception
            r2 = r5
            goto L_0x009b
        L_0x0032:
            r2 = move-exception
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x003f
        L_0x0037:
            r2 = move-exception
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x006e
        L_0x003c:
            r12 = move-exception
            goto L_0x009b
        L_0x003e:
            r5 = move-exception
        L_0x003f:
            com.amplitude.api.AmplitudeLog r6 = logger     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r8 = "getNumberRows for %s failed"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x003c }
            r9[r3] = r12     // Catch:{ all -> 0x003c }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ all -> 0x003c }
            r6.mo10497e(r7, r8, r5)     // Catch:{ all -> 0x003c }
            com.amplitude.api.Diagnostics r6 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "DB: Failed to getNumberRows for table %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x003c }
            r4[r3] = r12     // Catch:{ all -> 0x003c }
            java.lang.String r12 = java.lang.String.format(r7, r4)     // Catch:{ all -> 0x003c }
            r6.logError(r12, r5)     // Catch:{ all -> 0x003c }
            r11.delete()     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x00a1 }
        L_0x0069:
            r11.close()     // Catch:{ all -> 0x00a1 }
            goto L_0x0099
        L_0x006d:
            r5 = move-exception
        L_0x006e:
            com.amplitude.api.AmplitudeLog r6 = logger     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r8 = "getNumberRows for %s failed"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ all -> 0x003c }
            r9[r3] = r12     // Catch:{ all -> 0x003c }
            java.lang.String r8 = java.lang.String.format(r8, r9)     // Catch:{ all -> 0x003c }
            r6.mo10497e(r7, r8, r5)     // Catch:{ all -> 0x003c }
            com.amplitude.api.Diagnostics r6 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x003c }
            java.lang.String r7 = "DB: Failed to getNumberRows for table %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x003c }
            r4[r3] = r12     // Catch:{ all -> 0x003c }
            java.lang.String r12 = java.lang.String.format(r7, r4)     // Catch:{ all -> 0x003c }
            r6.logError(r12, r5)     // Catch:{ all -> 0x003c }
            r11.delete()     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ all -> 0x00a1 }
            goto L_0x0069
        L_0x0099:
            monitor-exit(r11)
            return r0
        L_0x009b:
            if (r2 == 0) goto L_0x00a3
            r2.close()     // Catch:{ all -> 0x00a1 }
            goto L_0x00a3
        L_0x00a1:
            r12 = move-exception
            goto L_0x00a7
        L_0x00a3:
            r11.close()     // Catch:{ all -> 0x00a1 }
            throw r12     // Catch:{ all -> 0x00a1 }
        L_0x00a7:
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getEventCountFromTable(java.lang.String):long");
    }

    /* access modifiers changed from: package-private */
    public synchronized long getNthEventId(long j) {
        return getNthEventIdFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized long getNthIdentifyId(long j) {
        return getNthEventIdFromTable(IDENTIFY_TABLE_NAME, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[SYNTHETIC, Splitter:B:25:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1 A[SYNTHETIC, Splitter:B:31:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a9 A[SYNTHETIC, Splitter:B:36:0x00a9] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x007a=Splitter:B:28:0x007a, B:22:0x004e=Splitter:B:22:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long getNthEventIdFromTable(java.lang.String r10, long r11) {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            r1 = -1
            r3 = 0
            r4 = 1
            android.database.sqlite.SQLiteDatabase r5 = r9.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            java.lang.String r7 = "SELECT id FROM "
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            r6.append(r10)     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            java.lang.String r7 = " LIMIT 1 OFFSET "
            r6.append(r7)     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            r7 = 1
            long r11 = r11 - r7
            r6.append(r11)     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            java.lang.String r11 = r6.toString()     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            android.database.sqlite.SQLiteStatement r11 = r5.compileStatement(r11)     // Catch:{ SQLiteException -> 0x0079, StackOverflowError -> 0x004d }
            long r5 = r11.simpleQueryForLong()     // Catch:{ SQLiteDoneException -> 0x003a }
            r1 = r5
            goto L_0x0042
        L_0x0030:
            r10 = move-exception
            r0 = r11
            goto L_0x00a7
        L_0x0034:
            r12 = move-exception
            r0 = r11
            goto L_0x004e
        L_0x0037:
            r12 = move-exception
            r0 = r11
            goto L_0x007a
        L_0x003a:
            r12 = move-exception
            com.amplitude.api.AmplitudeLog r0 = logger     // Catch:{ SQLiteException -> 0x0037, StackOverflowError -> 0x0034, all -> 0x0030 }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            r0.mo10509w((java.lang.String) r5, (java.lang.Throwable) r12)     // Catch:{ SQLiteException -> 0x0037, StackOverflowError -> 0x0034, all -> 0x0030 }
        L_0x0042:
            if (r11 == 0) goto L_0x0047
            r11.close()     // Catch:{ all -> 0x00ad }
        L_0x0047:
            r9.close()     // Catch:{ all -> 0x00ad }
            goto L_0x00a5
        L_0x004b:
            r10 = move-exception
            goto L_0x00a7
        L_0x004d:
            r12 = move-exception
        L_0x004e:
            com.amplitude.api.AmplitudeLog r11 = logger     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r6 = "getNthEventId from %s failed"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x004b }
            r7[r3] = r10     // Catch:{ all -> 0x004b }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x004b }
            r11.mo10497e(r5, r6, r12)     // Catch:{ all -> 0x004b }
            com.amplitude.api.Diagnostics r11 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "DB: Failed to getNthEventId from table %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x004b }
            r4[r3] = r10     // Catch:{ all -> 0x004b }
            java.lang.String r10 = java.lang.String.format(r5, r4)     // Catch:{ all -> 0x004b }
            r11.logError(r10, r12)     // Catch:{ all -> 0x004b }
            r9.delete()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ all -> 0x00ad }
            goto L_0x0047
        L_0x0079:
            r12 = move-exception
        L_0x007a:
            com.amplitude.api.AmplitudeLog r11 = logger     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r6 = "getNthEventId from %s failed"
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ all -> 0x004b }
            r7[r3] = r10     // Catch:{ all -> 0x004b }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x004b }
            r11.mo10497e(r5, r6, r12)     // Catch:{ all -> 0x004b }
            com.amplitude.api.Diagnostics r11 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x004b }
            java.lang.String r5 = "DB: Failed to getNthEventId from table %s"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x004b }
            r4[r3] = r10     // Catch:{ all -> 0x004b }
            java.lang.String r10 = java.lang.String.format(r5, r4)     // Catch:{ all -> 0x004b }
            r11.logError(r10, r12)     // Catch:{ all -> 0x004b }
            r9.delete()     // Catch:{ all -> 0x004b }
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ all -> 0x00ad }
            goto L_0x0047
        L_0x00a5:
            monitor-exit(r9)
            return r1
        L_0x00a7:
            if (r0 == 0) goto L_0x00af
            r0.close()     // Catch:{ all -> 0x00ad }
            goto L_0x00af
        L_0x00ad:
            r10 = move-exception
            goto L_0x00b3
        L_0x00af:
            r9.close()     // Catch:{ all -> 0x00ad }
            throw r10     // Catch:{ all -> 0x00ad }
        L_0x00b3:
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.getNthEventIdFromTable(java.lang.String, long):long");
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeEvents(long j) {
        removeEventsFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentifys(long j) {
        removeEventsFromTable(IDENTIFY_TABLE_NAME, j);
    }

    private synchronized void removeEventsFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(str, "id <= " + j, (String[]) null);
        } catch (SQLiteException e) {
            logger.mo10497e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), e);
            Diagnostics.getLogger().logError(String.format("DB: Failed to removeEvents from table %s", new Object[]{str}), e);
            delete();
        } catch (StackOverflowError e2) {
            try {
                logger.mo10497e(TAG, String.format("removeEvents from %s failed", new Object[]{str}), e2);
                Diagnostics.getLogger().logError(String.format("DB: Failed to removeEvents from table %s", new Object[]{str}), e2);
                delete();
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeEvent(long j) {
        removeEventFromTable(EVENT_TABLE_NAME, j);
    }

    /* access modifiers changed from: package-private */
    public synchronized void removeIdentify(long j) {
        removeEventFromTable(IDENTIFY_TABLE_NAME, j);
    }

    private synchronized void removeEventFromTable(String str, long j) {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            writableDatabase.delete(str, "id = " + j, (String[]) null);
        } catch (SQLiteException e) {
            logger.mo10497e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), e);
            Diagnostics.getLogger().logError(String.format("DB: Failed to removeEvent from table %s", new Object[]{str}), e);
            delete();
        } catch (StackOverflowError e2) {
            try {
                logger.mo10497e(TAG, String.format("removeEvent from %s failed", new Object[]{str}), e2);
                Diagnostics.getLogger().logError(String.format("DB: Failed to removeEvent from table %s", new Object[]{str}), e2);
                delete();
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0104, code lost:
        if (r4.isOpen() != false) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0106, code lost:
        close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x013c, code lost:
        if (r4.isOpen() != false) goto L_0x0106;
     */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void delete() {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r2 = 0
            r10.close()     // Catch:{ SecurityException -> 0x0073 }
            java.io.File r3 = r10.file     // Catch:{ SecurityException -> 0x0073 }
            r3.delete()     // Catch:{ SecurityException -> 0x0073 }
            com.amplitude.api.DatabaseResetListener r3 = r10.databaseResetListener
            if (r3 == 0) goto L_0x00e8
            boolean r3 = r10.callResetListenerOnDatabaseReset
            if (r3 == 0) goto L_0x00e8
            r10.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r3 = r10.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0035, all -> 0x0031 }
            com.amplitude.api.DatabaseResetListener r0 = r10.databaseResetListener     // Catch:{ SQLiteException -> 0x002f }
            r0.onDatabaseReset(r3)     // Catch:{ SQLiteException -> 0x002f }
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x00e8
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L_0x00e8
        L_0x0028:
            r10.close()
            goto L_0x00e8
        L_0x002d:
            r0 = move-exception
            goto L_0x0062
        L_0x002f:
            r0 = move-exception
            goto L_0x0039
        L_0x0031:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x0062
        L_0x0035:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r9
        L_0x0039:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r6 = "databaseReset callback failed during delete"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x002d }
            r4.mo10497e(r5, r6, r0)     // Catch:{ all -> 0x002d }
            com.amplitude.api.Diagnostics r4 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x002d }
            java.lang.String r5 = "DB: Failed to run databaseReset callback in delete"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x002d }
            java.lang.String r2 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x002d }
            r4.logError(r2, r0)     // Catch:{ all -> 0x002d }
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x00e8
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L_0x00e8
            goto L_0x0028
        L_0x0062:
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x006f
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x006f
            r10.close()
        L_0x006f:
            throw r0
        L_0x0070:
            r3 = move-exception
            goto L_0x00e9
        L_0x0073:
            r3 = move-exception
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x0070 }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r6 = "delete failed"
            r4.mo10497e(r5, r6, r3)     // Catch:{ all -> 0x0070 }
            com.amplitude.api.Diagnostics r3 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x0070 }
            java.lang.String r4 = "DB: Failed to delete database"
            r3.logError(r4)     // Catch:{ all -> 0x0070 }
            com.amplitude.api.DatabaseResetListener r3 = r10.databaseResetListener
            if (r3 == 0) goto L_0x00e8
            boolean r3 = r10.callResetListenerOnDatabaseReset
            if (r3 == 0) goto L_0x00e8
            r10.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r3 = r10.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00ac, all -> 0x00a8 }
            com.amplitude.api.DatabaseResetListener r0 = r10.databaseResetListener     // Catch:{ SQLiteException -> 0x00a6 }
            r0.onDatabaseReset(r3)     // Catch:{ SQLiteException -> 0x00a6 }
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x00e8
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L_0x00e8
            goto L_0x0028
        L_0x00a4:
            r0 = move-exception
            goto L_0x00da
        L_0x00a6:
            r0 = move-exception
            goto L_0x00b0
        L_0x00a8:
            r2 = move-exception
            r3 = r0
            r0 = r2
            goto L_0x00da
        L_0x00ac:
            r3 = move-exception
            r9 = r3
            r3 = r0
            r0 = r9
        L_0x00b0:
            com.amplitude.api.AmplitudeLog r4 = logger     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r6 = "databaseReset callback failed during delete"
            java.lang.Object[] r7 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a4 }
            java.lang.String r6 = java.lang.String.format(r6, r7)     // Catch:{ all -> 0x00a4 }
            r4.mo10497e(r5, r6, r0)     // Catch:{ all -> 0x00a4 }
            com.amplitude.api.Diagnostics r4 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x00a4 }
            java.lang.String r5 = "DB: Failed to run databaseReset callback in delete"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x00a4 }
            r4.logError(r2, r0)     // Catch:{ all -> 0x00a4 }
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x00e8
            boolean r0 = r3.isOpen()
            if (r0 == 0) goto L_0x00e8
            goto L_0x0028
        L_0x00da:
            r10.callResetListenerOnDatabaseReset = r1
            if (r3 == 0) goto L_0x00e7
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x00e7
            r10.close()
        L_0x00e7:
            throw r0
        L_0x00e8:
            return
        L_0x00e9:
            com.amplitude.api.DatabaseResetListener r4 = r10.databaseResetListener
            if (r4 == 0) goto L_0x014d
            boolean r4 = r10.callResetListenerOnDatabaseReset
            if (r4 == 0) goto L_0x014d
            r10.callResetListenerOnDatabaseReset = r2
            android.database.sqlite.SQLiteDatabase r4 = r10.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010e }
            com.amplitude.api.DatabaseResetListener r0 = r10.databaseResetListener     // Catch:{ SQLiteException -> 0x010c }
            r0.onDatabaseReset(r4)     // Catch:{ SQLiteException -> 0x010c }
            r10.callResetListenerOnDatabaseReset = r1
            if (r4 == 0) goto L_0x014d
            boolean r0 = r4.isOpen()
            if (r0 == 0) goto L_0x014d
        L_0x0106:
            r10.close()
            goto L_0x014d
        L_0x010a:
            r0 = move-exception
            goto L_0x013f
        L_0x010c:
            r0 = move-exception
            goto L_0x0116
        L_0x010e:
            r2 = move-exception
            r4 = r0
            r0 = r2
            goto L_0x013f
        L_0x0112:
            r4 = move-exception
            r9 = r4
            r4 = r0
            r0 = r9
        L_0x0116:
            com.amplitude.api.AmplitudeLog r5 = logger     // Catch:{ all -> 0x010a }
            java.lang.String r6 = "com.amplitude.api.DatabaseHelper"
            java.lang.String r7 = "databaseReset callback failed during delete"
            java.lang.Object[] r8 = new java.lang.Object[r2]     // Catch:{ all -> 0x010a }
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x010a }
            r5.mo10497e(r6, r7, r0)     // Catch:{ all -> 0x010a }
            com.amplitude.api.Diagnostics r5 = com.amplitude.api.Diagnostics.getLogger()     // Catch:{ all -> 0x010a }
            java.lang.String r6 = "DB: Failed to run databaseReset callback in delete"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x010a }
            java.lang.String r2 = java.lang.String.format(r6, r2)     // Catch:{ all -> 0x010a }
            r5.logError(r2, r0)     // Catch:{ all -> 0x010a }
            r10.callResetListenerOnDatabaseReset = r1
            if (r4 == 0) goto L_0x014d
            boolean r0 = r4.isOpen()
            if (r0 == 0) goto L_0x014d
            goto L_0x0106
        L_0x013f:
            r10.callResetListenerOnDatabaseReset = r1
            if (r4 == 0) goto L_0x014c
            boolean r1 = r4.isOpen()
            if (r1 == 0) goto L_0x014c
            r10.close()
        L_0x014c:
            throw r0
        L_0x014d:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.api.DatabaseHelper.delete():void");
    }

    /* access modifiers changed from: package-private */
    public boolean dbFileExists() {
        return this.file.exists();
    }

    /* access modifiers changed from: package-private */
    public Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
    }

    private void handleIfCursorRowTooLargeException(IllegalStateException illegalStateException) {
        String message = illegalStateException.getMessage();
        if (C0767Utils.isEmptyString(message) || !message.contains("Couldn't read") || !message.contains("CursorWindow")) {
            throw illegalStateException;
        }
        delete();
    }

    private static void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        if (C0767Utils.isEmptyString(message) || !message.startsWith("Cursor window allocation of")) {
            throw runtimeException;
        }
        throw new CursorWindowAllocationException(message);
    }
}
