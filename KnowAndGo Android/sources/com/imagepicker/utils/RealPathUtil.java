package com.imagepicker.utils;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import org.apache.logging.log4j.message.ParameterizedMessage;

public class RealPathUtil {
    @Nullable
    public static Uri compatUriFromFile(@NonNull Context context, @NonNull File file) {
        if (Build.VERSION.SDK_INT < 21) {
            return Uri.fromFile(file);
        }
        try {
            return FileProvider.getUriForFile(context, context.getApplicationContext().getPackageName() + ".provider", file);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    @Nullable
    public static String getRealPathFromURI(@NonNull Context context, @NonNull Uri uri) {
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if (UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                if (isFileProviderUri(context, uri)) {
                    return getFileProviderPath(context, uri);
                }
                return getDataColumn(context, uri, (String) null, (String[]) null);
            } else if (UriUtil.LOCAL_FILE_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        } else if (isExternalStorageDocument(uri)) {
            String[] split = DocumentsContract.getDocumentId(uri).split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            if ("primary".equalsIgnoreCase(split[0])) {
                return Environment.getExternalStorageDirectory() + "/" + split[1];
            }
        } else if (isDownloadsDocument(uri)) {
            return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), (String) null, (String[]) null);
        } else if (isMediaDocument(uri)) {
            String[] split2 = DocumentsContract.getDocumentId(uri).split(ParameterizedMessage.ERROR_MSG_SEPARATOR);
            String str = split2[0];
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if (MimeTypes.BASE_TYPE_VIDEO.equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if (MimeTypes.BASE_TYPE_AUDIO.equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getDataColumn(context, uri2, "_id=?", new String[]{split2[1]});
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r7, android.net.Uri r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ all -> 0x0033 }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0033 }
            if (r7 == 0) goto L_0x002d
            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x002b }
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndexOrThrow(r8)     // Catch:{ all -> 0x002b }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ all -> 0x002b }
            if (r7 == 0) goto L_0x002a
            r7.close()
        L_0x002a:
            return r8
        L_0x002b:
            r8 = move-exception
            goto L_0x0035
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            r7.close()
        L_0x0032:
            return r0
        L_0x0033:
            r8 = move-exception
            r7 = r0
        L_0x0035:
            if (r7 == 0) goto L_0x003a
            r7.close()
        L_0x003a:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.imagepicker.utils.RealPathUtil.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean isGooglePhotosUri(@NonNull Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    public static boolean isFileProviderUri(@NonNull Context context, @NonNull Uri uri) {
        return (context.getPackageName() + ".provider").equals(uri.getAuthority());
    }

    @Nullable
    public static String getFileProviderPath(@NonNull Context context, @NonNull Uri uri) {
        File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), uri.getLastPathSegment());
        if (file.exists()) {
            return file.toString();
        }
        return null;
    }
}
