package expo.modules.imagepicker;

import android.app.Application;
import android.content.ContentResolver;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImagePickerFileUtils {
    public static Uri uriFromFile(File file) {
        return Uri.fromFile(file);
    }

    public static Uri contentUriFromFile(File file, Application application) {
        try {
            return FileProvider.getUriForFile(application, application.getPackageName() + ".ImagePickerFileProvider", file);
        } catch (Exception unused) {
            return Uri.fromFile(file);
        }
    }

    public static File ensureDirExists(File file) throws IOException {
        if (file.isDirectory() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Couldn't create directory '" + file + "'");
    }

    public static String generateOutputPath(File file, String str, String str2) throws IOException {
        File file2 = new File(file + File.separator + str);
        ensureDirExists(file2);
        String uuid = UUID.randomUUID().toString();
        return file2 + File.separator + uuid + str2;
    }

    @Nullable
    public static String getType(ContentResolver contentResolver, Uri uri) {
        String type = contentResolver.getType(uri);
        return type == null ? getTypeFromFileUrl(uri.toString()) : type;
    }

    private static String getTypeFromFileUrl(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (fileExtensionFromUrl != null) {
            return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        }
        return null;
    }
}
