package expo.modules.updates.p021db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import java.util.UUID;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"update_id"}, entity = UpdateEntity.class, onDelete = 5, parentColumns = {"id"}), @ForeignKey(childColumns = {"asset_id"}, entity = AssetEntity.class, onDelete = 5, parentColumns = {"id"})}, indices = {@Index({"asset_id"})}, primaryKeys = {"update_id", "asset_id"}, tableName = "updates_assets")
/* renamed from: expo.modules.updates.db.entity.UpdateAssetEntity */
public class UpdateAssetEntity {
    @ColumnInfo(name = "asset_id")
    @NonNull
    public long assetId;
    @ColumnInfo(name = "update_id")
    @NonNull
    public UUID updateId;

    public UpdateAssetEntity(UUID uuid, long j) {
        this.updateId = uuid;
        this.assetId = j;
    }
}
