package androidx.sqlite.p007db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.File;

/* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper */
public interface SupportSQLiteOpenHelper {

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Factory */
    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    @RequiresApi(api = 16)
    void setWriteAheadLoggingEnabled(boolean z);

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Callback */
    public static abstract class Callback {
        private static final String TAG = "SupportSQLite";
        public final int version;

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2);

        public Callback(int i) {
            this.version = i;
        }

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
            throw new SQLiteException("Can't downgrade database from version " + i + " to " + i2);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
            if (r0 != null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
            r4 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
            if (r4.hasNext() != false) goto L_0x0041;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
            deleteDatabaseFile((java.lang.String) r4.next().second);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004f, code lost:
            deleteDatabaseFile(r4.getPath());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x002f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0031 */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002f A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r0 
          PHI: (r0v9 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r0v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r0v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:5:0x0029, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:5:0x0029] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(androidx.sqlite.p007db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "SupportSQLite"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                r1.append(r2)
                java.lang.String r2 = r4.getPath()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.e(r0, r1)
                boolean r0 = r4.isOpen()
                if (r0 != 0) goto L_0x0028
                java.lang.String r4 = r4.getPath()
                r3.deleteDatabaseFile(r4)
                return
            L_0x0028:
                r0 = 0
                java.util.List r1 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x0031, all -> 0x002f }
                r0 = r1
                goto L_0x0031
            L_0x002f:
                r1 = move-exception
                goto L_0x0035
            L_0x0031:
                r4.close()     // Catch:{ IOException -> 0x0057, all -> 0x002f }
                goto L_0x0057
            L_0x0035:
                if (r0 == 0) goto L_0x004f
                java.util.Iterator r4 = r0.iterator()
            L_0x003b:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0056
                java.lang.Object r0 = r4.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r3.deleteDatabaseFile(r0)
                goto L_0x003b
            L_0x004f:
                java.lang.String r4 = r4.getPath()
                r3.deleteDatabaseFile(r4)
            L_0x0056:
                throw r1
            L_0x0057:
                if (r0 == 0) goto L_0x0071
                java.util.Iterator r4 = r0.iterator()
            L_0x005d:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0078
                java.lang.Object r0 = r4.next()
                android.util.Pair r0 = (android.util.Pair) r0
                java.lang.Object r0 = r0.second
                java.lang.String r0 = (java.lang.String) r0
                r3.deleteDatabaseFile(r0)
                goto L_0x005d
            L_0x0071:
                java.lang.String r4 = r4.getPath()
                r3.deleteDatabaseFile(r4)
            L_0x0078:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.p007db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        private void deleteDatabaseFile(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                Log.w(TAG, "deleting the database file: " + str);
                try {
                    if (Build.VERSION.SDK_INT >= 16) {
                        SQLiteDatabase.deleteDatabase(new File(str));
                        return;
                    }
                    try {
                        if (!new File(str).delete()) {
                            Log.e(TAG, "Could not delete the database file " + str);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "error while deleting corrupted database file", e);
                    }
                } catch (Exception e2) {
                    Log.w(TAG, "delete failed: ", e2);
                }
            }
        }
    }

    /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration */
    public static class Configuration {
        @NonNull
        public final Callback callback;
        @NonNull
        public final Context context;
        @Nullable
        public final String name;

        Configuration(@NonNull Context context2, @Nullable String str, @NonNull Callback callback2) {
            this.context = context2;
            this.name = str;
            this.callback = callback2;
        }

        public static Builder builder(Context context2) {
            return new Builder(context2);
        }

        /* renamed from: androidx.sqlite.db.SupportSQLiteOpenHelper$Configuration$Builder */
        public static class Builder {
            Callback mCallback;
            Context mContext;
            String mName;

            public Configuration build() {
                if (this.mCallback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (this.mContext != null) {
                    return new Configuration(this.mContext, this.mName, this.mCallback);
                } else {
                    throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
                }
            }

            Builder(@NonNull Context context) {
                this.mContext = context;
            }

            public Builder name(@Nullable String str) {
                this.mName = str;
                return this;
            }

            public Builder callback(@NonNull Callback callback) {
                this.mCallback = callback;
                return this;
            }
        }
    }
}
