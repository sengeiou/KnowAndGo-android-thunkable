package expo.modules.updates.p021db;

import android.os.Build;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.p007db.SupportSQLiteDatabase;
import androidx.sqlite.p007db.SupportSQLiteOpenHelper;
import com.google.android.gms.common.internal.ImagesContract;
import expo.modules.updates.p021db.dao.AssetDao;
import expo.modules.updates.p021db.dao.AssetDao_Impl;
import expo.modules.updates.p021db.dao.UpdateDao;
import expo.modules.updates.p021db.dao.UpdateDao_Impl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: expo.modules.updates.db.UpdatesDatabase_Impl */
public final class UpdatesDatabase_Impl extends UpdatesDatabase {
    private volatile AssetDao _assetDao;
    private volatile UpdateDao _updateDao;

    /* access modifiers changed from: protected */
    public SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(2) {
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `updates` (`id` BLOB NOT NULL, `project_identifier` TEXT NOT NULL, `commit_time` INTEGER NOT NULL, `runtime_version` TEXT NOT NULL, `launch_asset_id` INTEGER, `metadata` TEXT, `status` INTEGER NOT NULL, `keep` INTEGER NOT NULL, PRIMARY KEY(`id`), FOREIGN KEY(`launch_asset_id`) REFERENCES `assets`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_updates_launch_asset_id` ON `updates` (`launch_asset_id`)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX `index_updates_project_identifier_commit_time` ON `updates` (`project_identifier`, `commit_time`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `updates_assets` (`update_id` BLOB NOT NULL, `asset_id` INTEGER NOT NULL, PRIMARY KEY(`update_id`, `asset_id`), FOREIGN KEY(`update_id`) REFERENCES `updates`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`asset_id`) REFERENCES `assets`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
                supportSQLiteDatabase.execSQL("CREATE  INDEX `index_updates_assets_asset_id` ON `updates_assets` (`asset_id`)");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `assets` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `url` TEXT, `key` TEXT NOT NULL, `headers` TEXT, `type` TEXT NOT NULL, `metadata` TEXT, `download_time` INTEGER, `relative_path` TEXT, `hash` BLOB, `hash_type` INTEGER NOT NULL, `marked_for_deletion` INTEGER NOT NULL)");
                supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX `index_assets_key` ON `assets` (`key`)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5e86c0d5cc1f4fb4049c8787d944fb86')");
            }

            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `updates`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `updates_assets`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `assets`");
            }

            /* access modifiers changed from: protected */
            public void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (UpdatesDatabase_Impl.this.mCallbacks != null) {
                    int size = UpdatesDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UpdatesDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase unused = UpdatesDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                supportSQLiteDatabase.execSQL("PRAGMA foreign_keys = ON");
                UpdatesDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (UpdatesDatabase_Impl.this.mCallbacks != null) {
                    int size = UpdatesDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) UpdatesDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            /* access modifiers changed from: protected */
            public void validateMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
                SupportSQLiteDatabase supportSQLiteDatabase2 = supportSQLiteDatabase;
                HashMap hashMap = new HashMap(8);
                hashMap.put("id", new TableInfo.Column("id", "BLOB", true, 1));
                hashMap.put("project_identifier", new TableInfo.Column("project_identifier", "TEXT", true, 0));
                hashMap.put("commit_time", new TableInfo.Column("commit_time", "INTEGER", true, 0));
                hashMap.put("runtime_version", new TableInfo.Column("runtime_version", "TEXT", true, 0));
                hashMap.put("launch_asset_id", new TableInfo.Column("launch_asset_id", "INTEGER", false, 0));
                hashMap.put(TtmlNode.TAG_METADATA, new TableInfo.Column(TtmlNode.TAG_METADATA, "TEXT", false, 0));
                hashMap.put("status", new TableInfo.Column("status", "INTEGER", true, 0));
                hashMap.put("keep", new TableInfo.Column("keep", "INTEGER", true, 0));
                HashSet hashSet = new HashSet(1);
                hashSet.add(new TableInfo.ForeignKey("assets", "CASCADE", "NO ACTION", Arrays.asList(new String[]{"launch_asset_id"}), Arrays.asList(new String[]{"id"})));
                HashSet hashSet2 = new HashSet(2);
                hashSet2.add(new TableInfo.Index("index_updates_launch_asset_id", false, Arrays.asList(new String[]{"launch_asset_id"})));
                hashSet2.add(new TableInfo.Index("index_updates_project_identifier_commit_time", true, Arrays.asList(new String[]{"project_identifier", "commit_time"})));
                TableInfo tableInfo = new TableInfo("updates", hashMap, hashSet, hashSet2);
                TableInfo read = TableInfo.read(supportSQLiteDatabase2, "updates");
                if (tableInfo.equals(read)) {
                    HashMap hashMap2 = new HashMap(2);
                    hashMap2.put("update_id", new TableInfo.Column("update_id", "BLOB", true, 1));
                    hashMap2.put("asset_id", new TableInfo.Column("asset_id", "INTEGER", true, 2));
                    HashSet hashSet3 = new HashSet(2);
                    hashSet3.add(new TableInfo.ForeignKey("updates", "CASCADE", "NO ACTION", Arrays.asList(new String[]{"update_id"}), Arrays.asList(new String[]{"id"})));
                    hashSet3.add(new TableInfo.ForeignKey("assets", "CASCADE", "NO ACTION", Arrays.asList(new String[]{"asset_id"}), Arrays.asList(new String[]{"id"})));
                    HashSet hashSet4 = new HashSet(1);
                    hashSet4.add(new TableInfo.Index("index_updates_assets_asset_id", false, Arrays.asList(new String[]{"asset_id"})));
                    TableInfo tableInfo2 = new TableInfo("updates_assets", hashMap2, hashSet3, hashSet4);
                    TableInfo read2 = TableInfo.read(supportSQLiteDatabase2, "updates_assets");
                    if (tableInfo2.equals(read2)) {
                        HashMap hashMap3 = new HashMap(11);
                        hashMap3.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
                        hashMap3.put(ImagesContract.URL, new TableInfo.Column(ImagesContract.URL, "TEXT", false, 0));
                        hashMap3.put("key", new TableInfo.Column("key", "TEXT", true, 0));
                        hashMap3.put("headers", new TableInfo.Column("headers", "TEXT", false, 0));
                        hashMap3.put("type", new TableInfo.Column("type", "TEXT", true, 0));
                        hashMap3.put(TtmlNode.TAG_METADATA, new TableInfo.Column(TtmlNode.TAG_METADATA, "TEXT", false, 0));
                        hashMap3.put("download_time", new TableInfo.Column("download_time", "INTEGER", false, 0));
                        hashMap3.put("relative_path", new TableInfo.Column("relative_path", "TEXT", false, 0));
                        hashMap3.put("hash", new TableInfo.Column("hash", "BLOB", false, 0));
                        hashMap3.put("hash_type", new TableInfo.Column("hash_type", "INTEGER", true, 0));
                        hashMap3.put("marked_for_deletion", new TableInfo.Column("marked_for_deletion", "INTEGER", true, 0));
                        HashSet hashSet5 = new HashSet(0);
                        HashSet hashSet6 = new HashSet(1);
                        hashSet6.add(new TableInfo.Index("index_assets_key", true, Arrays.asList(new String[]{"key"})));
                        TableInfo tableInfo3 = new TableInfo("assets", hashMap3, hashSet5, hashSet6);
                        TableInfo read3 = TableInfo.read(supportSQLiteDatabase2, "assets");
                        if (!tableInfo3.equals(read3)) {
                            throw new IllegalStateException("Migration didn't properly handle assets(expo.modules.updates.db.entity.AssetEntity).\n Expected:\n" + tableInfo3 + "\n Found:\n" + read3);
                        }
                        return;
                    }
                    throw new IllegalStateException("Migration didn't properly handle updates_assets(expo.modules.updates.db.entity.UpdateAssetEntity).\n Expected:\n" + tableInfo2 + "\n Found:\n" + read2);
                }
                throw new IllegalStateException("Migration didn't properly handle updates(expo.modules.updates.db.entity.UpdateEntity).\n Expected:\n" + tableInfo + "\n Found:\n" + read);
            }
        }, "5e86c0d5cc1f4fb4049c8787d944fb86", "6b3923aab3db035fccfe9a5919d22589")).build());
    }

    /* access modifiers changed from: protected */
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "updates", "updates_assets", "assets");
    }

    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        boolean z = Build.VERSION.SDK_INT >= 21;
        if (!z) {
            try {
                writableDatabase.execSQL("PRAGMA foreign_keys = FALSE");
            } catch (Throwable th) {
                super.endTransaction();
                if (!z) {
                    writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
                }
                writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
                if (!writableDatabase.inTransaction()) {
                    writableDatabase.execSQL("VACUUM");
                }
                throw th;
            }
        }
        super.beginTransaction();
        if (z) {
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
        }
        writableDatabase.execSQL("DELETE FROM `updates`");
        writableDatabase.execSQL("DELETE FROM `updates_assets`");
        writableDatabase.execSQL("DELETE FROM `assets`");
        super.setTransactionSuccessful();
        super.endTransaction();
        if (!z) {
            writableDatabase.execSQL("PRAGMA foreign_keys = TRUE");
        }
        writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
        if (!writableDatabase.inTransaction()) {
            writableDatabase.execSQL("VACUUM");
        }
    }

    public UpdateDao updateDao() {
        UpdateDao updateDao;
        if (this._updateDao != null) {
            return this._updateDao;
        }
        synchronized (this) {
            if (this._updateDao == null) {
                this._updateDao = new UpdateDao_Impl(this);
            }
            updateDao = this._updateDao;
        }
        return updateDao;
    }

    public AssetDao assetDao() {
        AssetDao assetDao;
        if (this._assetDao != null) {
            return this._assetDao;
        }
        synchronized (this) {
            if (this._assetDao == null) {
                this._assetDao = new AssetDao_Impl(this);
            }
            assetDao = this._assetDao;
        }
        return assetDao;
    }
}
