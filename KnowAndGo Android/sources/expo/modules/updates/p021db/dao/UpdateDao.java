package expo.modules.updates.p021db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Dao
/* renamed from: expo.modules.updates.db.dao.UpdateDao */
public abstract class UpdateDao {
    @Query("UPDATE updates SET keep = 1 WHERE id = :id;")
    public abstract void _keepUpdate(UUID uuid);

    @Query("SELECT assets.* FROM assets INNER JOIN updates ON updates.launch_asset_id = assets.id WHERE updates.id = :id;")
    public abstract AssetEntity _loadLaunchAsset(UUID uuid);

    @Query("SELECT * FROM updates WHERE id = :id;")
    public abstract List<UpdateEntity> _loadUpdatesWithId(UUID uuid);

    @Query("SELECT * FROM updates WHERE status IN (:statuses);")
    public abstract List<UpdateEntity> _loadUpdatesWithStatuses(List<UpdateStatus> list);

    @Query("UPDATE updates SET status = :status WHERE id = :id;")
    public abstract void _markUpdateWithStatus(UpdateStatus updateStatus, UUID uuid);

    @Delete
    public abstract void deleteUpdates(List<UpdateEntity> list);

    @Insert
    public abstract void insertUpdate(UpdateEntity updateEntity);

    @Query("SELECT * FROM updates;")
    public abstract List<UpdateEntity> loadAllUpdates();

    public List<UpdateEntity> loadLaunchableUpdates() {
        return _loadUpdatesWithStatuses(Arrays.asList(new UpdateStatus[]{UpdateStatus.READY, UpdateStatus.EMBEDDED}));
    }

    public UpdateEntity loadUpdateWithId(UUID uuid) {
        List<UpdateEntity> _loadUpdatesWithId = _loadUpdatesWithId(uuid);
        if (_loadUpdatesWithId.size() > 0) {
            return _loadUpdatesWithId.get(0);
        }
        return null;
    }

    public AssetEntity loadLaunchAsset(UUID uuid) {
        AssetEntity _loadLaunchAsset = _loadLaunchAsset(uuid);
        _loadLaunchAsset.isLaunchAsset = true;
        return _loadLaunchAsset;
    }

    @Transaction
    public void markUpdateFinished(UpdateEntity updateEntity, boolean z) {
        _markUpdateWithStatus(z ? UpdateStatus.EMBEDDED : UpdateStatus.READY, updateEntity.f2958id);
        _keepUpdate(updateEntity.f2958id);
    }

    public void markUpdateFinished(UpdateEntity updateEntity) {
        markUpdateFinished(updateEntity, false);
    }
}
