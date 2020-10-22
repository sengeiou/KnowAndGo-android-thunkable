package p023fr.bamlab.rnimageresizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.imagepipeline.common.RotationOptions;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.p032io.IOUtils;

/* renamed from: fr.bamlab.rnimageresizer.ImageResizer */
public class ImageResizer {
    private static final String[] EXIF_TO_COPY_ROTATED = {ExifInterface.TAG_APERTURE_VALUE, ExifInterface.TAG_MAX_APERTURE_VALUE, ExifInterface.TAG_METERING_MODE, ExifInterface.TAG_ARTIST, ExifInterface.TAG_BITS_PER_SAMPLE, ExifInterface.TAG_COMPRESSION, ExifInterface.TAG_BODY_SERIAL_NUMBER, ExifInterface.TAG_BRIGHTNESS_VALUE, ExifInterface.TAG_CONTRAST, "CameraOwnerName", ExifInterface.TAG_COLOR_SPACE, ExifInterface.TAG_COPYRIGHT, ExifInterface.TAG_DATETIME, ExifInterface.TAG_DATETIME_DIGITIZED, ExifInterface.TAG_DATETIME_ORIGINAL, ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION, ExifInterface.TAG_DIGITAL_ZOOM_RATIO, ExifInterface.TAG_EXIF_VERSION, ExifInterface.TAG_EXPOSURE_BIAS_VALUE, ExifInterface.TAG_EXPOSURE_INDEX, ExifInterface.TAG_EXPOSURE_MODE, ExifInterface.TAG_EXPOSURE_TIME, ExifInterface.TAG_EXPOSURE_PROGRAM, ExifInterface.TAG_FLASH, ExifInterface.TAG_FLASH_ENERGY, ExifInterface.TAG_FOCAL_LENGTH, ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM, ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT, ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION, ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION, ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION, ExifInterface.TAG_PLANAR_CONFIGURATION, ExifInterface.TAG_F_NUMBER, ExifInterface.TAG_GAIN_CONTROL, ExifInterface.TAG_GAMMA, ExifInterface.TAG_GPS_ALTITUDE, ExifInterface.TAG_GPS_ALTITUDE_REF, ExifInterface.TAG_GPS_AREA_INFORMATION, ExifInterface.TAG_GPS_DATESTAMP, ExifInterface.TAG_GPS_DOP, ExifInterface.TAG_GPS_LATITUDE, ExifInterface.TAG_GPS_LATITUDE_REF, ExifInterface.TAG_GPS_LONGITUDE, ExifInterface.TAG_GPS_LONGITUDE_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_DEST_BEARING, ExifInterface.TAG_GPS_DEST_BEARING_REF, ExifInterface.TAG_GPS_DEST_DISTANCE, ExifInterface.TAG_GPS_DEST_DISTANCE_REF, ExifInterface.TAG_GPS_DEST_LATITUDE, ExifInterface.TAG_GPS_DEST_LATITUDE_REF, ExifInterface.TAG_GPS_DEST_LONGITUDE, ExifInterface.TAG_GPS_DEST_LONGITUDE_REF, ExifInterface.TAG_GPS_DIFFERENTIAL, ExifInterface.TAG_GPS_IMG_DIRECTION, ExifInterface.TAG_GPS_IMG_DIRECTION_REF, ExifInterface.TAG_GPS_MAP_DATUM, ExifInterface.TAG_GPS_MEASURE_MODE, ExifInterface.TAG_GPS_PROCESSING_METHOD, ExifInterface.TAG_GPS_SATELLITES, ExifInterface.TAG_GPS_SPEED, ExifInterface.TAG_GPS_SPEED_REF, ExifInterface.TAG_GPS_STATUS, ExifInterface.TAG_GPS_TIMESTAMP, ExifInterface.TAG_GPS_TRACK, ExifInterface.TAG_GPS_TRACK_REF, ExifInterface.TAG_GPS_VERSION_ID, ExifInterface.TAG_IMAGE_DESCRIPTION, ExifInterface.TAG_IMAGE_UNIQUE_ID, ExifInterface.TAG_ISO_SPEED, ExifInterface.TAG_PHOTOGRAPHIC_SENSITIVITY, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT, ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH, ExifInterface.TAG_LENS_MAKE, ExifInterface.TAG_LENS_MODEL, ExifInterface.TAG_LENS_SERIAL_NUMBER, ExifInterface.TAG_LENS_SPECIFICATION, ExifInterface.TAG_LIGHT_SOURCE, ExifInterface.TAG_MAKE, ExifInterface.TAG_MAKER_NOTE, ExifInterface.TAG_MODEL, ExifInterface.TAG_SATURATION, ExifInterface.TAG_SHARPNESS, ExifInterface.TAG_SHUTTER_SPEED_VALUE, ExifInterface.TAG_SOFTWARE, ExifInterface.TAG_SUBJECT_DISTANCE, ExifInterface.TAG_SUBJECT_DISTANCE_RANGE, ExifInterface.TAG_SUBJECT_LOCATION, ExifInterface.TAG_USER_COMMENT, ExifInterface.TAG_WHITE_BALANCE};
    private static final String IMAGE_JPEG = "image/jpeg";
    private static final String IMAGE_PNG = "image/png";
    private static final String SCHEME_CONTENT = "content";
    private static final String SCHEME_DATA = "data";
    private static final String SCHEME_FILE = "file";

    private static Bitmap resizeImage(Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        if (i2 <= 0 || i <= 0) {
            return null;
        }
        float width = (float) bitmap.getWidth();
        float height = (float) bitmap.getHeight();
        float min = Math.min(((float) i) / width, ((float) i2) / height);
        try {
            return Bitmap.createScaledBitmap(bitmap, (int) (width * min), (int) (height * min), true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static Bitmap rotateImage(Bitmap bitmap, float f) {
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    public static File saveImage(Bitmap bitmap, File file, String str, Bitmap.CompressFormat compressFormat, int i) throws IOException {
        if (bitmap != null) {
            File file2 = new File(file, str + "." + compressFormat.name());
            if (file2.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(compressFormat, i, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                fileOutputStream.write(byteArray);
                fileOutputStream.flush();
                fileOutputStream.close();
                return file2;
            }
            throw new IOException("The file already exists");
        }
        throw new IOException("The bitmap couldn't be resized");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File getFileFromUri(android.content.Context r9, android.net.Uri r10) {
        /*
            java.io.File r0 = new java.io.File
            java.lang.String r1 = r10.getPath()
            r0.<init>(r1)
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x0010
            return r0
        L_0x0010:
            r1 = 0
            java.lang.String r2 = "_data"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x0048, all -> 0x0040 }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ Exception -> 0x0048, all -> 0x0040 }
            r6 = 0
            r7 = 0
            r8 = 0
            r4 = r10
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0048, all -> 0x0040 }
            java.lang.String r10 = "_data"
            int r10 = r9.getColumnIndexOrThrow(r10)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r9.moveToFirst()     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            r1.<init>(r10)     // Catch:{ Exception -> 0x003e, all -> 0x003c }
            if (r9 == 0) goto L_0x003a
            r9.close()
        L_0x003a:
            r0 = r1
            goto L_0x004e
        L_0x003c:
            r10 = move-exception
            goto L_0x0042
        L_0x003e:
            goto L_0x0049
        L_0x0040:
            r10 = move-exception
            r9 = r1
        L_0x0042:
            if (r9 == 0) goto L_0x0047
            r9.close()
        L_0x0047:
            throw r10
        L_0x0048:
            r9 = r1
        L_0x0049:
            if (r9 == 0) goto L_0x004e
            r9.close()
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p023fr.bamlab.rnimageresizer.ImageResizer.getFileFromUri(android.content.Context, android.net.Uri):java.io.File");
    }

    public static boolean copyExif(Context context, Uri uri, String str) {
        ExifInterface exifInterface;
        ExifInterface exifInterface2;
        try {
            File fileFromUri = getFileFromUri(context, uri);
            if (!fileFromUri.exists()) {
                return false;
            }
            exifInterface = new ExifInterface(fileFromUri.getAbsolutePath());
            try {
                exifInterface2 = new ExifInterface(str);
            } catch (Exception e) {
                e = e;
            }
            if (exifInterface != null || exifInterface2 == null) {
                return false;
            }
            try {
                for (String str2 : EXIF_TO_COPY_ROTATED) {
                    String attribute = exifInterface.getAttribute(str2);
                    if (attribute != null) {
                        exifInterface2.setAttribute(str2, attribute);
                    }
                }
                exifInterface2.saveAttributes();
                return true;
            } catch (Exception e2) {
                Log.e("ImageResizer::copyExif", "EXIF copy failed", e2);
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            exifInterface = null;
            Log.e("ImageResizer::copyExif", "EXIF read failed", e);
            exifInterface2 = null;
            if (exifInterface != null) {
            }
            return false;
        }
    }

    public static int getOrientation(Context context, Uri uri) {
        try {
            File fileFromUri = getFileFromUri(context, uri);
            if (fileFromUri.exists()) {
                return getOrientation(new ExifInterface(fileFromUri.getAbsolutePath()));
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getOrientation(ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (attributeInt == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
            int i6 = i3 / 2;
            int i7 = i4 / 2;
            while (i6 / i5 >= i2 && i7 / i5 >= i) {
                i5 *= 2;
            }
        }
        return i5;
    }

    private static Bitmap loadBitmap(Context context, Uri uri, BitmapFactory.Options options) throws IOException {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equalsIgnoreCase("content")) {
            try {
                return BitmapFactory.decodeFile(uri.getPath(), options);
            } catch (Exception e) {
                e.printStackTrace();
                throw new IOException("Error decoding image file");
            }
        } else {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                return null;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
            openInputStream.close();
            return decodeStream;
        }
    }

    private static Bitmap loadBitmapFromFile(Context context, Uri uri, int i, int i2) throws IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        loadBitmap(context, uri, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        return loadBitmap(context, uri, options);
    }

    private static Bitmap loadBitmapFromBase64(Uri uri) {
        String schemeSpecificPart = uri.getSchemeSpecificPart();
        int indexOf = schemeSpecificPart.indexOf(44);
        if (indexOf != -1) {
            String lowerCase = schemeSpecificPart.substring(0, indexOf).replace(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_UNIX).toLowerCase();
            boolean startsWith = lowerCase.startsWith(IMAGE_JPEG);
            boolean z = !startsWith && lowerCase.startsWith(IMAGE_PNG);
            if (startsWith || z) {
                byte[] decode = Base64.decode(schemeSpecificPart.substring(indexOf + 1), 0);
                return BitmapFactory.decodeByteArray(decode, 0, decode.length);
            }
        }
        return null;
    }

    public static Bitmap createResizedImage(Context context, Uri uri, int i, int i2, int i3, int i4) throws IOException {
        Bitmap bitmap;
        String scheme = uri.getScheme();
        if (scheme == null || scheme.equalsIgnoreCase("file") || scheme.equalsIgnoreCase("content")) {
            bitmap = loadBitmapFromFile(context, uri, i, i2);
        } else {
            bitmap = scheme.equalsIgnoreCase("data") ? loadBitmapFromBase64(uri) : null;
        }
        if (bitmap != null) {
            Bitmap rotateImage = rotateImage(bitmap, (float) (getOrientation(context, uri) + i4));
            if (rotateImage != null) {
                if (rotateImage != rotateImage) {
                    bitmap.recycle();
                }
                Bitmap resizeImage = resizeImage(rotateImage, i, i2);
                if (resizeImage != null) {
                    if (resizeImage != rotateImage) {
                        rotateImage.recycle();
                    }
                    return resizeImage;
                }
                throw new IOException("Unable to resize image. Most likely due to not enough memory.");
            }
            throw new IOException("Unable to rotate image. Most likely due to not enough memory.");
        }
        throw new IOException("Unable to load source image from path");
    }
}
