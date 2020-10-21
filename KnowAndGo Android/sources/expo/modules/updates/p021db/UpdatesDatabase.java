package expo.modules.updates.p021db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import expo.modules.updates.p021db.dao.AssetDao;
import expo.modules.updates.p021db.dao.UpdateDao;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateAssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;

@Database(entities = {UpdateEntity.class, UpdateAssetEntity.class, AssetEntity.class}, exportSchema = false, version = 2)
@TypeConverters({Converters.class})
/* renamed from: expo.modules.updates.db.UpdatesDatabase */
public abstract class UpdatesDatabase extends RoomDatabase {
    private static final String DB_NAME = "updates.db";
    private static final String TAG = "UpdatesDatabase";
    private static UpdatesDatabase sInstance;

    public abstract AssetDao assetDao();

    public abstract UpdateDao updateDao();

    public static synchronized UpdatesDatabase getInstance(Context context) {
        UpdatesDatabase updatesDatabase;
        synchronized (UpdatesDatabase.class) {
            if (sInstance == null) {
                sInstance = Room.databaseBuilder(context, UpdatesDatabase.class, DB_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();
            }
            updatesDatabase = sInstance;
        }
        return updatesDatabase;
    }
}
