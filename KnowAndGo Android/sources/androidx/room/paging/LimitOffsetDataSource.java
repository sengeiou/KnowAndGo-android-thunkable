package androidx.room.paging;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.paging.PositionalDataSource;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.p007db.SupportSQLiteQuery;
import java.util.List;
import java.util.Set;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class LimitOffsetDataSource<T> extends PositionalDataSource<T> {
    private final String mCountQuery;
    private final RoomDatabase mDb;
    private final boolean mInTransaction;
    private final String mLimitOffsetQuery;
    private final InvalidationTracker.Observer mObserver;
    private final RoomSQLiteQuery mSourceQuery;

    /* access modifiers changed from: protected */
    public abstract List<T> convertRows(Cursor cursor);

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z, String... strArr) {
        this(roomDatabase, RoomSQLiteQuery.copyFrom(supportSQLiteQuery), z, strArr);
    }

    protected LimitOffsetDataSource(RoomDatabase roomDatabase, RoomSQLiteQuery roomSQLiteQuery, boolean z, String... strArr) {
        this.mDb = roomDatabase;
        this.mSourceQuery = roomSQLiteQuery;
        this.mInTransaction = z;
        this.mCountQuery = "SELECT COUNT(*) FROM ( " + this.mSourceQuery.getSql() + " )";
        this.mLimitOffsetQuery = "SELECT * FROM ( " + this.mSourceQuery.getSql() + " ) LIMIT ? OFFSET ?";
        this.mObserver = new InvalidationTracker.Observer(strArr) {
            public void onInvalidated(@NonNull Set<String> set) {
                LimitOffsetDataSource.this.invalidate();
            }
        };
        roomDatabase.getInvalidationTracker().addWeakObserver(this.mObserver);
    }

    public int countItems() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mCountQuery, this.mSourceQuery.getArgCount());
        acquire.copyArgumentsFrom(this.mSourceQuery);
        Cursor query = this.mDb.query(acquire);
        try {
            if (query.moveToFirst()) {
                return query.getInt(0);
            }
            query.close();
            acquire.release();
            return 0;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public boolean isInvalid() {
        this.mDb.getInvalidationTracker().refreshVersionsSync();
        return LimitOffsetDataSource.super.isInvalid();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadInitial(@androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialParams r7, @androidx.annotation.NonNull androidx.paging.PositionalDataSource.LoadInitialCallback<T> r8) {
        /*
            r6 = this;
            java.util.List r0 = java.util.Collections.emptyList()
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.beginTransaction()
            r1 = 0
            int r2 = r6.countItems()     // Catch:{ all -> 0x004b }
            if (r2 == 0) goto L_0x0035
            int r0 = computeInitialLoadPosition(r7, r2)     // Catch:{ all -> 0x004b }
            int r7 = computeInitialLoadSize(r7, r0, r2)     // Catch:{ all -> 0x004b }
            androidx.room.RoomSQLiteQuery r7 = r6.getSQLiteQuery(r0, r7)     // Catch:{ all -> 0x004b }
            androidx.room.RoomDatabase r3 = r6.mDb     // Catch:{ all -> 0x0033 }
            android.database.Cursor r3 = r3.query(r7)     // Catch:{ all -> 0x0033 }
            java.util.List r1 = r6.convertRows(r3)     // Catch:{ all -> 0x0030 }
            androidx.room.RoomDatabase r4 = r6.mDb     // Catch:{ all -> 0x0030 }
            r4.setTransactionSuccessful()     // Catch:{ all -> 0x0030 }
            r5 = r3
            r3 = r0
            r0 = r1
            r1 = r5
            goto L_0x0038
        L_0x0030:
            r8 = move-exception
            r1 = r3
            goto L_0x004d
        L_0x0033:
            r8 = move-exception
            goto L_0x004d
        L_0x0035:
            r7 = 0
            r7 = r1
            r3 = 0
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()
        L_0x003d:
            androidx.room.RoomDatabase r1 = r6.mDb
            r1.endTransaction()
            if (r7 == 0) goto L_0x0047
            r7.release()
        L_0x0047:
            r8.onResult(r0, r3, r2)
            return
        L_0x004b:
            r8 = move-exception
            r7 = r1
        L_0x004d:
            if (r1 == 0) goto L_0x0052
            r1.close()
        L_0x0052:
            androidx.room.RoomDatabase r0 = r6.mDb
            r0.endTransaction()
            if (r7 == 0) goto L_0x005c
            r7.release()
        L_0x005c:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadInitial(androidx.paging.PositionalDataSource$LoadInitialParams, androidx.paging.PositionalDataSource$LoadInitialCallback):void");
    }

    public void loadRange(@NonNull PositionalDataSource.LoadRangeParams loadRangeParams, @NonNull PositionalDataSource.LoadRangeCallback<T> loadRangeCallback) {
        loadRangeCallback.onResult(loadRange(loadRangeParams.startPosition, loadRangeParams.loadSize));
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<T> loadRange(int r4, int r5) {
        /*
            r3 = this;
            androidx.room.RoomSQLiteQuery r4 = r3.getSQLiteQuery(r4, r5)
            boolean r5 = r3.mInTransaction
            if (r5 == 0) goto L_0x003f
            androidx.room.RoomDatabase r5 = r3.mDb
            r5.beginTransaction()
            r5 = 0
            androidx.room.RoomDatabase r0 = r3.mDb     // Catch:{ all -> 0x002d }
            android.database.Cursor r0 = r0.query(r4)     // Catch:{ all -> 0x002d }
            java.util.List r5 = r3.convertRows(r0)     // Catch:{ all -> 0x002b }
            androidx.room.RoomDatabase r1 = r3.mDb     // Catch:{ all -> 0x002b }
            r1.setTransactionSuccessful()     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0022
            r0.close()
        L_0x0022:
            androidx.room.RoomDatabase r0 = r3.mDb
            r0.endTransaction()
            r4.release()
            return r5
        L_0x002b:
            r5 = move-exception
            goto L_0x0031
        L_0x002d:
            r0 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.close()
        L_0x0036:
            androidx.room.RoomDatabase r0 = r3.mDb
            r0.endTransaction()
            r4.release()
            throw r5
        L_0x003f:
            androidx.room.RoomDatabase r5 = r3.mDb
            android.database.Cursor r5 = r5.query(r4)
            java.util.List r0 = r3.convertRows(r5)     // Catch:{ all -> 0x0050 }
            r5.close()
            r4.release()
            return r0
        L_0x0050:
            r0 = move-exception
            r5.close()
            r4.release()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.paging.LimitOffsetDataSource.loadRange(int, int):java.util.List");
    }

    private RoomSQLiteQuery getSQLiteQuery(int i, int i2) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire(this.mLimitOffsetQuery, this.mSourceQuery.getArgCount() + 2);
        acquire.copyArgumentsFrom(this.mSourceQuery);
        acquire.bindLong(acquire.getArgCount() - 1, (long) i2);
        acquire.bindLong(acquire.getArgCount(), (long) i);
        return acquire;
    }
}
