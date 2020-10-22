package com.RNFetchBlob.Utils;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.RNFetchBlob.RNFetchBlobUtils;
import com.facebook.common.util.UriUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.apache.logging.log4j.message.ParameterizedMessage;

public class PathResolver {
    @TargetApi(19)
    public static String getRealPathFromURI(Context context, Uri uri) {
        String contentName;
        Uri uri2 = null;
        if (!(Build.VERSION.SDK_INT >= 19) || !DocumentsContract.isDocumentUri(context, uri)) {
            if (UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
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
            try {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (documentId == null || !documentId.startsWith("raw:/")) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(documentId).longValue()), (String) null, (String[]) null);
                }
                return Uri.parse(documentId).getPath();
            } catch (Exception unused) {
                return null;
            }
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
        } else if (!UriUtil.LOCAL_CONTENT_SCHEME.equalsIgnoreCase(uri.getScheme())) {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                if (!(openInputStream == null || (contentName = getContentName(context.getContentResolver(), uri)) == null)) {
                    File file = new File(context.getCacheDir(), contentName);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1024];
                    while (openInputStream.read(bArr) > 0) {
                        fileOutputStream.write(bArr);
                    }
                    fileOutputStream.close();
                    openInputStream.close();
                    return file.getAbsolutePath();
                }
            } catch (Exception e) {
                RNFetchBlobUtils.emitWarningEvent(e.toString());
                return null;
            }
        } else if (isGooglePhotosUri(uri)) {
            return uri.getLastPathSegment();
        } else {
            return getDataColumn(context, uri, (String) null, (String[]) null);
        }
        return null;
    }

    private static String getContentName(ContentResolver contentResolver, Uri uri) {
        Cursor query = contentResolver.query(uri, (String[]) null, (String) null, (String[]) null, (String) null);
        query.moveToFirst();
        int columnIndex = query.getColumnIndex("_display_name");
        if (columnIndex < 0) {
            return null;
        }
        String string = query.getString(columnIndex);
        query.close();
        return string;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDataColumn(android.content.Context r7, android.net.Uri r8, java.lang.String r9, java.lang.String[] r10) {
        /*
            java.lang.String r0 = "_data"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r0 = 0
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            r6 = 0
            r2 = r8
            r4 = r9
            r5 = r10
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0032, all -> 0x002f }
            if (r7 == 0) goto L_0x0028
            boolean r8 = r7.moveToFirst()     // Catch:{ Exception -> 0x0026 }
            if (r8 == 0) goto L_0x0028
            java.lang.String r8 = "_data"
            int r8 = r7.getColumnIndexOrThrow(r8)     // Catch:{ Exception -> 0x0026 }
            java.lang.String r8 = r7.getString(r8)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r8 = move-exception
            goto L_0x0034
        L_0x0028:
            r8 = r0
        L_0x0029:
            if (r7 == 0) goto L_0x002e
            r7.close()
        L_0x002e:
            return r8
        L_0x002f:
            r8 = move-exception
            r7 = r0
            goto L_0x003e
        L_0x0032:
            r8 = move-exception
            r7 = r0
        L_0x0034:
            r8.printStackTrace()     // Catch:{ all -> 0x003d }
            if (r7 == 0) goto L_0x003c
            r7.close()
        L_0x003c:
            return r0
        L_0x003d:
            r8 = move-exception
        L_0x003e:
            if (r7 == 0) goto L_0x0043
            r7.close()
        L_0x0043:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.RNFetchBlob.Utils.PathResolver.getDataColumn(android.content.Context, android.net.Uri, java.lang.String, java.lang.String[]):java.lang.String");
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

    public static boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
}
