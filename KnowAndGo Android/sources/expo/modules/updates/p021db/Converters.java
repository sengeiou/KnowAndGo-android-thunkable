package expo.modules.updates.p021db;

import android.net.Uri;
import android.util.Log;
import androidx.room.TypeConverter;
import expo.modules.updates.p021db.enums.HashType;
import expo.modules.updates.p021db.enums.UpdateStatus;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: expo.modules.updates.db.Converters */
public class Converters {
    private static final String TAG = "Converters";

    @TypeConverter
    public static int hashTypeToInt(HashType hashType) {
        return 0;
    }

    @TypeConverter
    public static Date longToDate(Long l) {
        if (l == null) {
            return null;
        }
        return new Date(l.longValue());
    }

    @TypeConverter
    public static Long dateToLong(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    @TypeConverter
    public static Uri stringToUri(String str) {
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }

    @TypeConverter
    public static String uriToString(Uri uri) {
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    @TypeConverter
    public static JSONObject stringToJsonObject(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e) {
            Log.e(TAG, "Could not convert string to JSONObject", e);
            return new JSONObject();
        }
    }

    @TypeConverter
    public static String jsonObjectToString(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    @TypeConverter
    public static UUID bytesToUuid(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    @TypeConverter
    public static byte[] uuidToBytes(UUID uuid) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        wrap.putLong(uuid.getMostSignificantBits());
        wrap.putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }

    @TypeConverter
    public static UpdateStatus intToStatus(int i) {
        if (i == 5) {
            return UpdateStatus.EMBEDDED;
        }
        switch (i) {
            case 0:
                return UpdateStatus.FAILED;
            case 1:
                return UpdateStatus.READY;
            case 2:
                return UpdateStatus.LAUNCHABLE;
            case 3:
                return UpdateStatus.PENDING;
            default:
                return UpdateStatus.UNUSED;
        }
    }

    @TypeConverter
    public static int statusToInt(UpdateStatus updateStatus) {
        switch (updateStatus) {
            case FAILED:
                return 0;
            case READY:
                return 1;
            case LAUNCHABLE:
                return 2;
            case PENDING:
                return 3;
            case EMBEDDED:
                return 5;
            default:
                return 4;
        }
    }

    @TypeConverter
    public static HashType intToHashType(int i) {
        return HashType.SHA256;
    }
}
