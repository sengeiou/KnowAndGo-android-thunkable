package expo.modules.updates.p021db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

@Entity(foreignKeys = {@ForeignKey(childColumns = {"launch_asset_id"}, entity = AssetEntity.class, onDelete = 5, parentColumns = {"id"})}, indices = {@Index({"launch_asset_id"}), @Index(unique = true, value = {"project_identifier", "commit_time"})}, tableName = "updates")
/* renamed from: expo.modules.updates.db.entity.UpdateEntity */
public class UpdateEntity {
    @ColumnInfo(name = "commit_time")
    @NonNull
    public Date commitTime;
    @ColumnInfo(typeAffinity = 5)
    @NonNull
    @PrimaryKey

    /* renamed from: id */
    public UUID f2958id;
    @NonNull
    public boolean keep = false;
    @ColumnInfo(name = "launch_asset_id")
    public Long launchAssetId = null;
    public JSONObject metadata = null;
    @ColumnInfo(name = "project_identifier")
    @NonNull
    public String projectIdentifier;
    @ColumnInfo(name = "runtime_version")
    @NonNull
    public String runtimeVersion;
    @NonNull
    public UpdateStatus status = UpdateStatus.PENDING;

    public UpdateEntity(UUID uuid, Date date, String str, String str2) {
        this.f2958id = uuid;
        this.commitTime = date;
        this.runtimeVersion = str;
        this.projectIdentifier = str2;
    }
}
