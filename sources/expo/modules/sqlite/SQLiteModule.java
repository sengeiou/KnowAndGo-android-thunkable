package expo.modules.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ExpoMethod;

public class SQLiteModule extends ExportedModule {
    private static final Map<String, SQLiteDatabase> DATABASES = new HashMap();
    private static final boolean DEBUG_MODE = false;
    private static final String[] EMPTY_COLUMNS = new String[0];
    private static final SQLitePluginResult EMPTY_RESULT = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, (Throwable) null);
    private static final Object[][] EMPTY_ROWS = new Object[0][];
    private static final String TAG = "SQLiteModule";
    private Context mContext;

    public String getName() {
        return "ExponentSQLite";
    }

    public SQLiteModule(Context context) {
        super(context);
        this.mContext = context;
    }

    @ExpoMethod
    public void exec(String str, ArrayList<ArrayList<Object>> arrayList, Boolean bool, Promise promise) {
        Promise promise2 = promise;
        try {
            int size = arrayList.size();
            SQLitePluginResult[] sQLitePluginResultArr = new SQLitePluginResult[size];
            SQLiteDatabase database = getDatabase(str);
            for (int i = 0; i < size; i++) {
                ArrayList arrayList2 = arrayList.get(i);
                String str2 = (String) arrayList2.get(0);
                String[] convertParamsToStringArray = convertParamsToStringArray(arrayList2.get(1));
                try {
                    if (isSelect(str2)) {
                        sQLitePluginResultArr[i] = doSelectInBackgroundAndPossiblyThrow(str2, convertParamsToStringArray, database);
                    } else if (bool.booleanValue()) {
                        sQLitePluginResultArr[i] = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, new ReadOnlyException());
                    } else {
                        sQLitePluginResultArr[i] = doUpdateInBackgroundAndPossiblyThrow(str2, convertParamsToStringArray, database);
                    }
                } catch (Throwable th) {
                    sQLitePluginResultArr[i] = new SQLitePluginResult(EMPTY_ROWS, EMPTY_COLUMNS, 0, 0, th);
                }
            }
            promise2.resolve(pluginResultsToPrimitiveData(sQLitePluginResultArr));
        } catch (Exception e) {
            promise2.reject("SQLiteError", (Throwable) e);
        }
    }

    @ExpoMethod
    public void close(String str, Promise promise) {
        DATABASES.get(str).close();
        DATABASES.remove(str);
        promise.resolve((Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private expo.modules.sqlite.SQLiteModule.SQLitePluginResult doUpdateInBackgroundAndPossiblyThrow(java.lang.String r8, java.lang.String[] r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            r7 = this;
            android.database.sqlite.SQLiteStatement r10 = r10.compileStatement(r8)     // Catch:{ all -> 0x0072 }
            if (r9 == 0) goto L_0x001d
            int r0 = r9.length     // Catch:{ all -> 0x001b }
        L_0x0007:
            if (r0 == 0) goto L_0x001d
            int r1 = r0 + -1
            r2 = r9[r1]     // Catch:{ all -> 0x001b }
            if (r2 != 0) goto L_0x0013
            r10.bindNull(r0)     // Catch:{ all -> 0x001b }
            goto L_0x0018
        L_0x0013:
            r1 = r9[r1]     // Catch:{ all -> 0x001b }
            r10.bindString(r0, r1)     // Catch:{ all -> 0x001b }
        L_0x0018:
            int r0 = r0 + -1
            goto L_0x0007
        L_0x001b:
            r8 = move-exception
            goto L_0x0074
        L_0x001d:
            boolean r9 = isInsert(r8)     // Catch:{ all -> 0x001b }
            if (r9 == 0) goto L_0x0043
            long r4 = r10.executeInsert()     // Catch:{ all -> 0x001b }
            r8 = 0
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x0030
            r8 = 1
            r3 = 1
            goto L_0x0032
        L_0x0030:
            r8 = 0
            r3 = 0
        L_0x0032:
            expo.modules.sqlite.SQLiteModule$SQLitePluginResult r8 = new expo.modules.sqlite.SQLiteModule$SQLitePluginResult     // Catch:{ all -> 0x001b }
            java.lang.Object[][] r1 = EMPTY_ROWS     // Catch:{ all -> 0x001b }
            java.lang.String[] r2 = EMPTY_COLUMNS     // Catch:{ all -> 0x001b }
            r6 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x0042
            r10.close()
        L_0x0042:
            return r8
        L_0x0043:
            boolean r9 = isDelete(r8)     // Catch:{ all -> 0x001b }
            if (r9 != 0) goto L_0x005b
            boolean r8 = isUpdate(r8)     // Catch:{ all -> 0x001b }
            if (r8 == 0) goto L_0x0050
            goto L_0x005b
        L_0x0050:
            r10.execute()     // Catch:{ all -> 0x001b }
            expo.modules.sqlite.SQLiteModule$SQLitePluginResult r8 = EMPTY_RESULT     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x005a
            r10.close()
        L_0x005a:
            return r8
        L_0x005b:
            int r3 = r10.executeUpdateDelete()     // Catch:{ all -> 0x001b }
            expo.modules.sqlite.SQLiteModule$SQLitePluginResult r8 = new expo.modules.sqlite.SQLiteModule$SQLitePluginResult     // Catch:{ all -> 0x001b }
            java.lang.Object[][] r1 = EMPTY_ROWS     // Catch:{ all -> 0x001b }
            java.lang.String[] r2 = EMPTY_COLUMNS     // Catch:{ all -> 0x001b }
            r4 = 0
            r6 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x001b }
            if (r10 == 0) goto L_0x0071
            r10.close()
        L_0x0071:
            return r8
        L_0x0072:
            r8 = move-exception
            r10 = 0
        L_0x0074:
            if (r10 == 0) goto L_0x0079
            r10.close()
        L_0x0079:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.sqlite.SQLiteModule.doUpdateInBackgroundAndPossiblyThrow(java.lang.String, java.lang.String[], android.database.sqlite.SQLiteDatabase):expo.modules.sqlite.SQLiteModule$SQLitePluginResult");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private expo.modules.sqlite.SQLiteModule.SQLitePluginResult doSelectInBackgroundAndPossiblyThrow(java.lang.String r8, java.lang.String[] r9, android.database.sqlite.SQLiteDatabase r10) {
        /*
            r7 = this;
            android.database.Cursor r8 = r10.rawQuery(r8, r9)     // Catch:{ all -> 0x004d }
            int r9 = r8.getCount()     // Catch:{ all -> 0x004b }
            if (r9 != 0) goto L_0x0012
            expo.modules.sqlite.SQLiteModule$SQLitePluginResult r9 = EMPTY_RESULT     // Catch:{ all -> 0x004b }
            if (r8 == 0) goto L_0x0011
            r8.close()
        L_0x0011:
            return r9
        L_0x0012:
            int r10 = r8.getColumnCount()     // Catch:{ all -> 0x004b }
            java.lang.Object[][] r1 = new java.lang.Object[r9][]     // Catch:{ all -> 0x004b }
            java.lang.String[] r2 = r8.getColumnNames()     // Catch:{ all -> 0x004b }
            r9 = 0
            r0 = 0
        L_0x001e:
            boolean r3 = r8.moveToNext()     // Catch:{ all -> 0x004b }
            if (r3 == 0) goto L_0x003b
            java.lang.Object[] r3 = new java.lang.Object[r10]     // Catch:{ all -> 0x004b }
            r4 = 0
        L_0x0027:
            if (r4 >= r10) goto L_0x0036
            int r5 = r8.getType(r4)     // Catch:{ all -> 0x004b }
            java.lang.Object r5 = r7.getValueFromCursor(r8, r4, r5)     // Catch:{ all -> 0x004b }
            r3[r4] = r5     // Catch:{ all -> 0x004b }
            int r4 = r4 + 1
            goto L_0x0027
        L_0x0036:
            r1[r0] = r3     // Catch:{ all -> 0x004b }
            int r0 = r0 + 1
            goto L_0x001e
        L_0x003b:
            expo.modules.sqlite.SQLiteModule$SQLitePluginResult r9 = new expo.modules.sqlite.SQLiteModule$SQLitePluginResult     // Catch:{ all -> 0x004b }
            r3 = 0
            r4 = 0
            r6 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x004b }
            if (r8 == 0) goto L_0x004a
            r8.close()
        L_0x004a:
            return r9
        L_0x004b:
            r9 = move-exception
            goto L_0x004f
        L_0x004d:
            r9 = move-exception
            r8 = 0
        L_0x004f:
            if (r8 == 0) goto L_0x0054
            r8.close()
        L_0x0054:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.sqlite.SQLiteModule.doSelectInBackgroundAndPossiblyThrow(java.lang.String, java.lang.String[], android.database.sqlite.SQLiteDatabase):expo.modules.sqlite.SQLiteModule$SQLitePluginResult");
    }

    private Object getValueFromCursor(Cursor cursor, int i, int i2) {
        switch (i2) {
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                return new String(cursor.getBlob(i));
            default:
                return null;
        }
    }

    private static File ensureDirExists(File file) throws IOException {
        if (!file.isDirectory()) {
            if (file.isFile()) {
                throw new IOException("Path '" + file + "' points to a file, but must point to a directory.");
            } else if (!file.mkdirs()) {
                String str = null;
                if (file.exists()) {
                    str = "Path already points to a non-normal file.";
                }
                if (file.getParentFile() == null) {
                    str = "Parent directory is null.";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't create directory '");
                sb.append(file);
                sb.append("'. ");
                if (str == null) {
                    str = "";
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
        }
        return file;
    }

    private String pathForDatabaseName(String str) throws IOException {
        File file = new File(this.mContext.getFilesDir() + File.separator + "SQLite");
        ensureDirExists(file);
        return file + File.separator + str;
    }

    private SQLiteDatabase getDatabase(String str) throws IOException {
        String pathForDatabaseName = pathForDatabaseName(str);
        SQLiteDatabase sQLiteDatabase = new File(pathForDatabaseName).exists() ? DATABASES.get(str) : null;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        DATABASES.remove(str);
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(pathForDatabaseName, (SQLiteDatabase.CursorFactory) null);
        DATABASES.put(str, openOrCreateDatabase);
        return openOrCreateDatabase;
    }

    private static List<Object> pluginResultsToPrimitiveData(SQLitePluginResult[] sQLitePluginResultArr) {
        ArrayList arrayList = new ArrayList();
        for (SQLitePluginResult convertPluginResultToArray : sQLitePluginResultArr) {
            arrayList.add(convertPluginResultToArray(convertPluginResultToArray));
        }
        return arrayList;
    }

    private static List<Object> convertPluginResultToArray(SQLitePluginResult sQLitePluginResult) {
        ArrayList arrayList = new ArrayList();
        if (sQLitePluginResult.error != null) {
            arrayList.add(sQLitePluginResult.error.getMessage());
        } else {
            arrayList.add((Object) null);
        }
        arrayList.add(Integer.valueOf((int) sQLitePluginResult.insertId));
        arrayList.add(Integer.valueOf(sQLitePluginResult.rowsAffected));
        ArrayList arrayList2 = new ArrayList();
        for (String add : sQLitePluginResult.columns) {
            arrayList2.add(add);
        }
        arrayList.add(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        for (Object[] objArr : sQLitePluginResult.rows) {
            ArrayList arrayList4 = new ArrayList();
            for (Object obj : objArr) {
                if (obj == null) {
                    arrayList4.add((Object) null);
                } else if (obj instanceof String) {
                    arrayList4.add((String) obj);
                } else if (obj instanceof Boolean) {
                    arrayList4.add((Boolean) obj);
                } else {
                    arrayList4.add(Double.valueOf(((Number) obj).doubleValue()));
                }
            }
            arrayList3.add(arrayList4);
        }
        arrayList.add(arrayList3);
        return arrayList;
    }

    private static boolean isPragma(String str) {
        return startsWithCaseInsensitive(str, "pragma");
    }

    private static boolean isPragmaReadOnly(String str) {
        if (isPragma(str) && !str.matches(".*=.*")) {
            return true;
        }
        return false;
    }

    private static boolean isSelect(String str) {
        return startsWithCaseInsensitive(str, "select") || isPragmaReadOnly(str);
    }

    private static boolean isInsert(String str) {
        return startsWithCaseInsensitive(str, "insert");
    }

    private static boolean isUpdate(String str) {
        return startsWithCaseInsensitive(str, "update");
    }

    private static boolean isDelete(String str) {
        return startsWithCaseInsensitive(str, "delete");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0030 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean startsWithCaseInsensitive(java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = r8.length()
            r1 = -1
            r2 = -1
        L_0x0006:
            r3 = 1
            int r2 = r2 + r3
            if (r2 >= r0) goto L_0x0014
            char r4 = r8.charAt(r2)
            boolean r4 = java.lang.Character.isWhitespace(r4)
            if (r4 != 0) goto L_0x0006
        L_0x0014:
            int r4 = r9.length()
        L_0x0018:
            int r1 = r1 + r3
            if (r1 >= r4) goto L_0x0030
            int r5 = r1 + r2
            r6 = 0
            if (r5 < r0) goto L_0x0021
            return r6
        L_0x0021:
            char r5 = r8.charAt(r5)
            char r5 = java.lang.Character.toLowerCase(r5)
            char r7 = r9.charAt(r1)
            if (r5 == r7) goto L_0x0018
            return r6
        L_0x0030:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.sqlite.SQLiteModule.startsWithCaseInsensitive(java.lang.String, java.lang.String):boolean");
    }

    private static String[] convertParamsToStringArray(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        int size = arrayList.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            Object obj2 = arrayList.get(i);
            strArr[i] = null;
            if (obj2 instanceof String) {
                strArr[i] = unescapeBlob((String) obj2);
            } else if (obj2 instanceof Boolean) {
                strArr[i] = ((Boolean) obj2).booleanValue() ? "1" : "0";
            } else if (obj2 instanceof Double) {
                strArr[i] = obj2.toString();
            } else if (obj2 != null) {
                throw new ClassCastException("Could not find proper SQLite data type for argument: " + obj2.toString());
            }
        }
        return strArr;
    }

    private static String unescapeBlob(String str) {
        return str.replaceAll("\u0001\u0001", "\u0000").replaceAll("\u0001\u0002", "\u0001").replaceAll("\u0002\u0002", "\u0002");
    }

    private static class SQLitePluginResult {
        public final String[] columns;
        public final Throwable error;
        public final long insertId;
        public final Object[][] rows;
        public final int rowsAffected;

        public SQLitePluginResult(Object[][] objArr, String[] strArr, int i, long j, Throwable th) {
            this.rows = objArr;
            this.columns = strArr;
            this.rowsAffected = i;
            this.insertId = j;
            this.error = th;
        }
    }

    private static class ReadOnlyException extends Exception {
        public ReadOnlyException() {
            super("could not prepare statement (23 not authorized)");
        }
    }
}
