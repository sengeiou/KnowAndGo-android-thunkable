package expo.modules.updates.p021db.dao;

import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import expo.modules.updates.p021db.entity.AssetEntity;
import expo.modules.updates.p021db.entity.UpdateAssetEntity;
import expo.modules.updates.p021db.entity.UpdateEntity;
import java.util.List;
import java.util.UUID;

@Dao
/* renamed from: expo.modules.updates.db.dao.AssetDao */
public abstract class AssetDao {
    @Query("DELETE FROM assets WHERE marked_for_deletion = 1;")
    public abstract void _deleteAssetsMarkedForDeletion();

    @Insert(onConflict = 1)
    public abstract long _insertAsset(AssetEntity assetEntity);

    @Insert(onConflict = 1)
    public abstract void _insertUpdateAsset(UpdateAssetEntity updateAssetEntity);

    @Query("SELECT * FROM assets WHERE `key` = :key LIMIT 1;")
    public abstract List<AssetEntity> _loadAssetWithKey(String str);

    @Query("SELECT * FROM assets WHERE marked_for_deletion = 1;")
    public abstract List<AssetEntity> _loadAssetsMarkedForDeletion();

    @Query("UPDATE assets SET marked_for_deletion = 1;")
    public abstract void _markAllAssetsForDeletion();

    @Query("UPDATE updates SET launch_asset_id = :assetId WHERE id = :updateId;")
    public abstract void _setUpdateLaunchAsset(long j, UUID uuid);

    @Query("UPDATE assets SET marked_for_deletion = 0 WHERE id IN ( SELECT asset_id FROM updates_assets INNER JOIN updates ON updates_assets.update_id = updates.id WHERE updates.keep);")
    public abstract void _unmarkUsedAssetsFromDeletion();

    @Query("SELECT assets.id, url, `key`, headers, type, assets.metadata, download_time, relative_path, hash, hash_type, marked_for_deletion FROM assets INNER JOIN updates_assets ON updates_assets.asset_id = assets.id INNER JOIN updates ON updates_assets.update_id = updates.id WHERE updates.id = :id;")
    public abstract List<AssetEntity> loadAssetsForUpdate(UUID uuid);

    @Update
    public abstract void updateAsset(AssetEntity assetEntity);

    @Transaction
    public void insertAssets(List<AssetEntity> list, UpdateEntity updateEntity) {
        for (AssetEntity next : list) {
            long _insertAsset = _insertAsset(next);
            _insertUpdateAsset(new UpdateAssetEntity(updateEntity.f2958id, _insertAsset));
            if (next.isLaunchAsset) {
                _setUpdateLaunchAsset(_insertAsset, updateEntity.f2958id);
            }
        }
    }

    @Nullable
    public AssetEntity loadAssetWithKey(String str) {
        List<AssetEntity> _loadAssetWithKey = _loadAssetWithKey(str);
        if (_loadAssetWithKey.size() > 0) {
            return _loadAssetWithKey.get(0);
        }
        return null;
    }

    public void mergeAndUpdateAsset(AssetEntity assetEntity, AssetEntity assetEntity2) {
        if (assetEntity2.url != null && assetEntity.url == null) {
            assetEntity.url = assetEntity2.url;
            updateAsset(assetEntity);
        }
    }

    @Transaction
    public boolean addExistingAssetToUpdate(UpdateEntity updateEntity, AssetEntity assetEntity, boolean z) {
        AssetEntity loadAssetWithKey = loadAssetWithKey(assetEntity.key);
        if (loadAssetWithKey == null) {
            return false;
        }
        long j = loadAssetWithKey.f2957id;
        _insertUpdateAsset(new UpdateAssetEntity(updateEntity.f2958id, j));
        if (!z) {
            return true;
        }
        _setUpdateLaunchAsset(j, updateEntity.f2958id);
        return true;
    }

    @Transaction
    public List<AssetEntity> deleteUnusedAssets() {
        _markAllAssetsForDeletion();
        _unmarkUsedAssetsFromDeletion();
        List<AssetEntity> _loadAssetsMarkedForDeletion = _loadAssetsMarkedForDeletion();
        _deleteAssetsMarkedForDeletion();
        return _loadAssetsMarkedForDeletion;
    }
}
