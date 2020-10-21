package expo.modules.camera;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.CamcorderProfile;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.extractor.p012ts.TsExtractor;
import expo.modules.camera.events.BarCodeScannedEvent;
import expo.modules.camera.events.CameraMountErrorEvent;
import expo.modules.camera.events.CameraReadyEvent;
import expo.modules.camera.events.FaceDetectionErrorEvent;
import expo.modules.camera.events.FacesDetectedEvent;
import expo.modules.camera.events.PictureSavedEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.unimodules.core.interfaces.services.EventEmitter;
import org.unimodules.interfaces.barcodescanner.BarCodeScannerResult;
import org.unimodules.interfaces.facedetector.FaceDetector;

public class CameraViewHelper {
    private static final String[][] exifTags;

    public static void emitMountErrorEvent(EventEmitter eventEmitter, ViewGroup viewGroup, String str) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) CameraMountErrorEvent.obtain(str));
    }

    public static void emitCameraReadyEvent(EventEmitter eventEmitter, ViewGroup viewGroup) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) CameraReadyEvent.obtain());
    }

    public static void emitBarCodeReadEvent(EventEmitter eventEmitter, ViewGroup viewGroup, BarCodeScannerResult barCodeScannerResult) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) BarCodeScannedEvent.obtain(viewGroup.getId(), barCodeScannerResult));
    }

    public static void emitFacesDetectedEvent(EventEmitter eventEmitter, ViewGroup viewGroup, List<Bundle> list) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) FacesDetectedEvent.obtain(viewGroup.getId(), list));
    }

    public static void emitFaceDetectionErrorEvent(EventEmitter eventEmitter, ViewGroup viewGroup, FaceDetector faceDetector) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) FaceDetectionErrorEvent.obtain(faceDetector));
    }

    public static void emitPictureSavedEvent(EventEmitter eventEmitter, ViewGroup viewGroup, Bundle bundle) {
        eventEmitter.emit(viewGroup.getId(), (EventEmitter.Event) PictureSavedEvent.obtain(bundle));
    }

    public static int getCorrectCameraRotation(int i, int i2) {
        if (i2 == 1) {
            return ((i - 90) + 360) % 360;
        }
        return (((-i) + 90) + 360) % 360;
    }

    public static CamcorderProfile getCamcorderProfile(int i, int i2) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(i, 1);
        switch (i2) {
            case 0:
                return CamcorderProfile.get(i, 8);
            case 1:
                return CamcorderProfile.get(i, 6);
            case 2:
                return CamcorderProfile.get(i, 5);
            case 3:
                return CamcorderProfile.get(i, 4);
            case 4:
                CamcorderProfile camcorderProfile2 = CamcorderProfile.get(i, 4);
                camcorderProfile2.videoFrameWidth = 640;
                return camcorderProfile2;
            default:
                return camcorderProfile;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        if (r8.equals("int") == false) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle getExifData(androidx.exifinterface.media.ExifInterface r13) {
        /*
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String[][] r1 = exifTags
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x000a:
            r5 = 0
            r7 = 1
            if (r4 >= r2) goto L_0x006c
            r8 = r1[r4]
            r9 = r8[r7]
            java.lang.String r10 = r13.getAttribute(r9)
            if (r10 == 0) goto L_0x0069
            r8 = r8[r3]
            r10 = -1
            int r11 = r8.hashCode()
            r12 = -1325958191(0xffffffffb0f77bd1, float:-1.8006806E-9)
            if (r11 == r12) goto L_0x0043
            r12 = -891985903(0xffffffffcad56011, float:-6991880.5)
            if (r11 == r12) goto L_0x0039
            r12 = 104431(0x197ef, float:1.46339E-40)
            if (r11 == r12) goto L_0x0030
            goto L_0x004d
        L_0x0030:
            java.lang.String r11 = "int"
            boolean r8 = r8.equals(r11)
            if (r8 == 0) goto L_0x004d
            goto L_0x004e
        L_0x0039:
            java.lang.String r7 = "string"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x004d
            r7 = 0
            goto L_0x004e
        L_0x0043:
            java.lang.String r7 = "double"
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x004d
            r7 = 2
            goto L_0x004e
        L_0x004d:
            r7 = -1
        L_0x004e:
            switch(r7) {
                case 0: goto L_0x0062;
                case 1: goto L_0x005a;
                case 2: goto L_0x0052;
                default: goto L_0x0051;
            }
        L_0x0051:
            goto L_0x0069
        L_0x0052:
            double r5 = r13.getAttributeDouble(r9, r5)
            r0.putDouble(r9, r5)
            goto L_0x0069
        L_0x005a:
            int r5 = r13.getAttributeInt(r9, r3)
            r0.putInt(r9, r5)
            goto L_0x0069
        L_0x0062:
            java.lang.String r5 = r13.getAttribute(r9)
            r0.putString(r9, r5)
        L_0x0069:
            int r4 = r4 + 1
            goto L_0x000a
        L_0x006c:
            double[] r1 = r13.getLatLong()
            if (r1 == 0) goto L_0x0089
            java.lang.String r2 = "GPSLatitude"
            r3 = r1[r3]
            r0.putDouble(r2, r3)
            java.lang.String r2 = "GPSLongitude"
            r3 = r1[r7]
            r0.putDouble(r2, r3)
            java.lang.String r1 = "GPSAltitude"
            double r2 = r13.getAltitude(r5)
            r0.putDouble(r1, r2)
        L_0x0089:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.camera.CameraViewHelper.getExifData(androidx.exifinterface.media.ExifInterface):android.os.Bundle");
    }

    public static void addExifData(ExifInterface exifInterface, ExifInterface exifInterface2) throws IOException {
        for (String[] strArr : exifTags) {
            String str = strArr[1];
            String attribute = exifInterface2.getAttribute(str);
            if (attribute != null) {
                exifInterface.setAttribute(str, attribute);
            }
        }
        exifInterface.saveAttributes();
    }

    public static Bitmap generateSimulatorPhoto(int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        float f = (float) i;
        float f2 = (float) i2;
        canvas.drawRect(0.0f, 0.0f, f, f2, paint);
        Paint paint2 = new Paint();
        paint2.setColor(InputDeviceCompat.SOURCE_ANY);
        paint2.setTextSize(35.0f);
        canvas.drawText(new SimpleDateFormat("dd.MM.yy HH:mm:ss", Locale.US).format(Calendar.getInstance().getTime()), f * 0.1f, f2 * 0.9f, paint2);
        return createBitmap;
    }

    static {
        String[][] strArr = new String[TsExtractor.TS_STREAM_TYPE_AC3][];
        strArr[0] = new String[]{"string", ExifInterface.TAG_ARTIST};
        strArr[1] = new String[]{"int", ExifInterface.TAG_BITS_PER_SAMPLE};
        strArr[2] = new String[]{"int", ExifInterface.TAG_COMPRESSION};
        strArr[3] = new String[]{"string", ExifInterface.TAG_COPYRIGHT};
        strArr[4] = new String[]{"string", ExifInterface.TAG_DATETIME};
        strArr[5] = new String[]{"string", ExifInterface.TAG_IMAGE_DESCRIPTION};
        strArr[6] = new String[]{"int", ExifInterface.TAG_IMAGE_LENGTH};
        strArr[7] = new String[]{"int", ExifInterface.TAG_IMAGE_WIDTH};
        strArr[8] = new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT};
        strArr[9] = new String[]{"int", ExifInterface.TAG_JPEG_INTERCHANGE_FORMAT_LENGTH};
        strArr[10] = new String[]{"string", ExifInterface.TAG_MAKE};
        strArr[11] = new String[]{"string", ExifInterface.TAG_MODEL};
        strArr[12] = new String[]{"int", ExifInterface.TAG_ORIENTATION};
        strArr[13] = new String[]{"int", ExifInterface.TAG_PHOTOMETRIC_INTERPRETATION};
        strArr[14] = new String[]{"int", ExifInterface.TAG_PLANAR_CONFIGURATION};
        strArr[15] = new String[]{"double", ExifInterface.TAG_PRIMARY_CHROMATICITIES};
        strArr[16] = new String[]{"double", ExifInterface.TAG_REFERENCE_BLACK_WHITE};
        strArr[17] = new String[]{"int", ExifInterface.TAG_RESOLUTION_UNIT};
        strArr[18] = new String[]{"int", ExifInterface.TAG_ROWS_PER_STRIP};
        strArr[19] = new String[]{"int", ExifInterface.TAG_SAMPLES_PER_PIXEL};
        strArr[20] = new String[]{"string", ExifInterface.TAG_SOFTWARE};
        strArr[21] = new String[]{"int", ExifInterface.TAG_STRIP_BYTE_COUNTS};
        strArr[22] = new String[]{"int", ExifInterface.TAG_STRIP_OFFSETS};
        strArr[23] = new String[]{"int", ExifInterface.TAG_TRANSFER_FUNCTION};
        strArr[24] = new String[]{"double", ExifInterface.TAG_WHITE_POINT};
        strArr[25] = new String[]{"double", ExifInterface.TAG_X_RESOLUTION};
        strArr[26] = new String[]{"double", ExifInterface.TAG_Y_CB_CR_COEFFICIENTS};
        strArr[27] = new String[]{"int", ExifInterface.TAG_Y_CB_CR_POSITIONING};
        strArr[28] = new String[]{"int", ExifInterface.TAG_Y_CB_CR_SUB_SAMPLING};
        strArr[29] = new String[]{"double", ExifInterface.TAG_Y_RESOLUTION};
        strArr[30] = new String[]{"double", ExifInterface.TAG_APERTURE_VALUE};
        strArr[31] = new String[]{"double", ExifInterface.TAG_BRIGHTNESS_VALUE};
        strArr[32] = new String[]{"string", ExifInterface.TAG_CFA_PATTERN};
        strArr[33] = new String[]{"int", ExifInterface.TAG_COLOR_SPACE};
        strArr[34] = new String[]{"string", ExifInterface.TAG_COMPONENTS_CONFIGURATION};
        strArr[35] = new String[]{"double", ExifInterface.TAG_COMPRESSED_BITS_PER_PIXEL};
        strArr[36] = new String[]{"int", ExifInterface.TAG_CONTRAST};
        strArr[37] = new String[]{"int", ExifInterface.TAG_CUSTOM_RENDERED};
        strArr[38] = new String[]{"string", ExifInterface.TAG_DATETIME_DIGITIZED};
        strArr[39] = new String[]{"string", ExifInterface.TAG_DATETIME_ORIGINAL};
        strArr[40] = new String[]{"string", ExifInterface.TAG_DEVICE_SETTING_DESCRIPTION};
        strArr[41] = new String[]{"double", ExifInterface.TAG_DIGITAL_ZOOM_RATIO};
        strArr[42] = new String[]{"string", ExifInterface.TAG_EXIF_VERSION};
        strArr[43] = new String[]{"double", ExifInterface.TAG_EXPOSURE_BIAS_VALUE};
        strArr[44] = new String[]{"double", ExifInterface.TAG_EXPOSURE_INDEX};
        strArr[45] = new String[]{"int", ExifInterface.TAG_EXPOSURE_MODE};
        strArr[46] = new String[]{"int", ExifInterface.TAG_EXPOSURE_PROGRAM};
        strArr[47] = new String[]{"double", ExifInterface.TAG_EXPOSURE_TIME};
        strArr[48] = new String[]{"double", ExifInterface.TAG_F_NUMBER};
        strArr[49] = new String[]{"string", ExifInterface.TAG_FILE_SOURCE};
        strArr[50] = new String[]{"int", ExifInterface.TAG_FLASH};
        strArr[51] = new String[]{"double", ExifInterface.TAG_FLASH_ENERGY};
        strArr[52] = new String[]{"string", ExifInterface.TAG_FLASHPIX_VERSION};
        strArr[53] = new String[]{"double", ExifInterface.TAG_FOCAL_LENGTH};
        strArr[54] = new String[]{"int", ExifInterface.TAG_FOCAL_LENGTH_IN_35MM_FILM};
        strArr[55] = new String[]{"int", ExifInterface.TAG_FOCAL_PLANE_RESOLUTION_UNIT};
        strArr[56] = new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_X_RESOLUTION};
        strArr[57] = new String[]{"double", ExifInterface.TAG_FOCAL_PLANE_Y_RESOLUTION};
        strArr[58] = new String[]{"int", ExifInterface.TAG_GAIN_CONTROL};
        strArr[59] = new String[]{"int", ExifInterface.TAG_ISO_SPEED_RATINGS};
        strArr[60] = new String[]{"string", ExifInterface.TAG_IMAGE_UNIQUE_ID};
        strArr[61] = new String[]{"int", ExifInterface.TAG_LIGHT_SOURCE};
        strArr[62] = new String[]{"string", ExifInterface.TAG_MAKER_NOTE};
        strArr[63] = new String[]{"double", ExifInterface.TAG_MAX_APERTURE_VALUE};
        strArr[64] = new String[]{"int", ExifInterface.TAG_METERING_MODE};
        strArr[65] = new String[]{"int", ExifInterface.TAG_NEW_SUBFILE_TYPE};
        strArr[66] = new String[]{"string", ExifInterface.TAG_OECF};
        strArr[67] = new String[]{"int", ExifInterface.TAG_PIXEL_X_DIMENSION};
        strArr[68] = new String[]{"int", ExifInterface.TAG_PIXEL_Y_DIMENSION};
        strArr[69] = new String[]{"string", ExifInterface.TAG_RELATED_SOUND_FILE};
        strArr[70] = new String[]{"int", ExifInterface.TAG_SATURATION};
        strArr[71] = new String[]{"int", ExifInterface.TAG_SCENE_CAPTURE_TYPE};
        strArr[72] = new String[]{"string", ExifInterface.TAG_SCENE_TYPE};
        strArr[73] = new String[]{"int", ExifInterface.TAG_SENSING_METHOD};
        strArr[74] = new String[]{"int", ExifInterface.TAG_SHARPNESS};
        strArr[75] = new String[]{"double", ExifInterface.TAG_SHUTTER_SPEED_VALUE};
        strArr[76] = new String[]{"string", ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE};
        strArr[77] = new String[]{"string", ExifInterface.TAG_SPECTRAL_SENSITIVITY};
        strArr[78] = new String[]{"int", ExifInterface.TAG_SUBFILE_TYPE};
        strArr[79] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME};
        strArr[80] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_DIGITIZED};
        strArr[81] = new String[]{"string", ExifInterface.TAG_SUBSEC_TIME_ORIGINAL};
        strArr[82] = new String[]{"int", ExifInterface.TAG_SUBJECT_AREA};
        strArr[83] = new String[]{"double", ExifInterface.TAG_SUBJECT_DISTANCE};
        strArr[84] = new String[]{"int", ExifInterface.TAG_SUBJECT_DISTANCE_RANGE};
        strArr[85] = new String[]{"int", ExifInterface.TAG_SUBJECT_LOCATION};
        strArr[86] = new String[]{"string", ExifInterface.TAG_USER_COMMENT};
        strArr[87] = new String[]{"int", ExifInterface.TAG_WHITE_BALANCE};
        strArr[88] = new String[]{"int", ExifInterface.TAG_GPS_ALTITUDE_REF};
        strArr[89] = new String[]{"string", ExifInterface.TAG_GPS_AREA_INFORMATION};
        strArr[90] = new String[]{"double", ExifInterface.TAG_GPS_DOP};
        strArr[91] = new String[]{"string", ExifInterface.TAG_GPS_DATESTAMP};
        strArr[92] = new String[]{"double", ExifInterface.TAG_GPS_DEST_BEARING};
        strArr[93] = new String[]{"string", ExifInterface.TAG_GPS_DEST_BEARING_REF};
        strArr[94] = new String[]{"double", ExifInterface.TAG_GPS_DEST_DISTANCE};
        strArr[95] = new String[]{"string", ExifInterface.TAG_GPS_DEST_DISTANCE_REF};
        strArr[96] = new String[]{"double", ExifInterface.TAG_GPS_DEST_LATITUDE};
        strArr[97] = new String[]{"string", ExifInterface.TAG_GPS_DEST_LATITUDE_REF};
        strArr[98] = new String[]{"double", ExifInterface.TAG_GPS_DEST_LONGITUDE};
        strArr[99] = new String[]{"string", ExifInterface.TAG_GPS_DEST_LONGITUDE_REF};
        strArr[100] = new String[]{"int", ExifInterface.TAG_GPS_DIFFERENTIAL};
        strArr[101] = new String[]{"double", ExifInterface.TAG_GPS_IMG_DIRECTION};
        strArr[102] = new String[]{"string", ExifInterface.TAG_GPS_IMG_DIRECTION_REF};
        strArr[103] = new String[]{"string", ExifInterface.TAG_GPS_LATITUDE_REF};
        strArr[104] = new String[]{"string", ExifInterface.TAG_GPS_LONGITUDE_REF};
        strArr[105] = new String[]{"string", ExifInterface.TAG_GPS_MAP_DATUM};
        strArr[106] = new String[]{"string", ExifInterface.TAG_GPS_MEASURE_MODE};
        strArr[107] = new String[]{"string", ExifInterface.TAG_GPS_PROCESSING_METHOD};
        strArr[108] = new String[]{"string", ExifInterface.TAG_GPS_SATELLITES};
        strArr[109] = new String[]{"double", ExifInterface.TAG_GPS_SPEED};
        strArr[110] = new String[]{"string", ExifInterface.TAG_GPS_SPEED_REF};
        strArr[111] = new String[]{"string", ExifInterface.TAG_GPS_STATUS};
        strArr[112] = new String[]{"string", ExifInterface.TAG_GPS_TIMESTAMP};
        strArr[113] = new String[]{"double", ExifInterface.TAG_GPS_TRACK};
        strArr[114] = new String[]{"string", ExifInterface.TAG_GPS_TRACK_REF};
        strArr[115] = new String[]{"string", ExifInterface.TAG_GPS_VERSION_ID};
        strArr[116] = new String[]{"string", ExifInterface.TAG_INTEROPERABILITY_INDEX};
        strArr[117] = new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_LENGTH};
        strArr[118] = new String[]{"int", ExifInterface.TAG_THUMBNAIL_IMAGE_WIDTH};
        strArr[119] = new String[]{"int", ExifInterface.TAG_DNG_VERSION};
        strArr[120] = new String[]{"int", ExifInterface.TAG_DEFAULT_CROP_SIZE};
        strArr[121] = new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_START};
        strArr[122] = new String[]{"int", ExifInterface.TAG_ORF_PREVIEW_IMAGE_LENGTH};
        strArr[123] = new String[]{"int", ExifInterface.TAG_ORF_ASPECT_FRAME};
        strArr[124] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_BOTTOM_BORDER};
        strArr[125] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_LEFT_BORDER};
        strArr[126] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_RIGHT_BORDER};
        strArr[127] = new String[]{"int", ExifInterface.TAG_RW2_SENSOR_TOP_BORDER};
        strArr[128] = new String[]{"int", ExifInterface.TAG_RW2_ISO};
        exifTags = strArr;
    }
}
