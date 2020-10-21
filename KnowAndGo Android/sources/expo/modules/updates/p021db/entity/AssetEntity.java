package expo.modules.updates.p021db.entity;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import expo.modules.updates.p021db.enums.HashType;
import java.util.Date;
import org.json.JSONObject;

@Entity(indices = {@Index(unique = true, value = {"key"})}, tableName = "assets")
/* renamed from: expo.modules.updates.db.entity.AssetEntity */
public class AssetEntity {
    @ColumnInfo(name = "download_time")
    public Date downloadTime = null;
    @Ignore
    public String embeddedAssetFilename = null;
    public byte[] hash = null;
    @ColumnInfo(name = "hash_type")
    @NonNull
    public HashType hashType = HashType.SHA256;
    public JSONObject headers = null;
    @PrimaryKey(autoGenerate = true)

    /* renamed from: id */
    public long f2957id = 0;
    @Ignore
    public boolean isLaunchAsset = false;
    @ColumnInfo(name = "key")
    @NonNull
    public String key;
    @ColumnInfo(name = "marked_for_deletion")
    @NonNull
    public boolean markedForDeletion = false;
    public JSONObject metadata = null;
    @ColumnInfo(name = "relative_path")
    public String relativePath = null;
    @Ignore
    public String resourcesFilename = null;
    @Ignore
    public String resourcesFolder = null;
    @Ignore
    public Float scale = null;
    @Ignore
    public Float[] scales = null;
    @NonNull
    public String type;
    public Uri url = null;

    public AssetEntity(String str, String str2) {
        this.key = str;
        this.type = str2;
    }
}
