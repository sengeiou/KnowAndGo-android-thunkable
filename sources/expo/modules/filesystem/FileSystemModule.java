package expo.modules.filesystem;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.Nullable;
import com.RNFetchBlob.RNFetchBlobConst;
import com.facebook.common.util.UriUtil;
import com.facebook.react.uimanager.ViewProps;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.CookieHandler;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.C3873Response;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.p032io.FileUtils;
import org.apache.commons.p032io.IOUtils;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.unimodules.core.ExportedModule;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.Promise;
import org.unimodules.core.interfaces.ActivityProvider;
import org.unimodules.core.interfaces.ExpoMethod;
import org.unimodules.core.interfaces.services.EventEmitter;
import org.unimodules.interfaces.filesystem.FilePermissionModuleInterface;
import org.unimodules.interfaces.filesystem.Permission;

public class FileSystemModule extends ExportedModule {
    private static final String EXDownloadProgressEventName = "Exponent.downloadProgress";
    private static final String HEADER_KEY = "headers";
    private static final long MIN_EVENT_DT_MS = 100;
    private static final String NAME = "ExponentFileSystem";
    /* access modifiers changed from: private */
    public static final String TAG = "FileSystemModule";
    private OkHttpClient mClient;
    private final Map<String, DownloadResumable> mDownloadResumableMap = new HashMap();
    /* access modifiers changed from: private */
    public ModuleRegistry mModuleRegistry;

    interface ProgressListener {
        void update(long j, long j2, boolean z);
    }

    public String getName() {
        return NAME;
    }

    private enum UploadType {
        INVALID(-1),
        BINARY_CONTENT(0),
        MULTIPART(1);
        
        private int value;

        private UploadType(int i) {
            this.value = i;
        }

        public static UploadType fromInteger(@Nullable Integer num) {
            if (num == null) {
                return INVALID;
            }
            for (UploadType uploadType : values()) {
                if (num.equals(Integer.valueOf(uploadType.value))) {
                    return uploadType;
                }
            }
            return INVALID;
        }
    }

    public FileSystemModule(Context context) {
        super(context);
        try {
            ensureDirExists(getContext().getFilesDir());
            ensureDirExists(getContext().getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("documentDirectory", Uri.fromFile(getContext().getFilesDir()).toString() + "/");
        hashMap.put("cacheDirectory", Uri.fromFile(getContext().getCacheDir()).toString() + "/");
        hashMap.put("bundleDirectory", "asset:///");
        return hashMap;
    }

    /* access modifiers changed from: private */
    public File uriToFile(Uri uri) {
        return new File(uri.getPath());
    }

    private void checkIfFileExists(Uri uri) throws IOException {
        File uriToFile = uriToFile(uri);
        if (!uriToFile.exists()) {
            throw new IOException("Directory for " + uriToFile.getPath() + " doesn't exist.");
        }
    }

    private void checkIfFileDirExists(Uri uri) throws IOException {
        File uriToFile = uriToFile(uri);
        if (!uriToFile.getParentFile().exists()) {
            throw new IOException("Directory for " + uriToFile.getPath() + " doesn't exist. Please make sure directory '" + uriToFile.getParent() + "' exists before calling downloadAsync.");
        }
    }

    private EnumSet<Permission> permissionsForPath(String str) {
        return ((FilePermissionModuleInterface) this.mModuleRegistry.getModule(FilePermissionModuleInterface.class)).getPathPermissions(getContext(), str);
    }

    private EnumSet<Permission> permissionsForUri(Uri uri) {
        if (UriUtil.LOCAL_CONTENT_SCHEME.equals(uri.getScheme())) {
            return EnumSet.of(Permission.READ);
        }
        if (UriUtil.LOCAL_ASSET_SCHEME.equals(uri.getScheme())) {
            return EnumSet.of(Permission.READ);
        }
        if (UriUtil.LOCAL_FILE_SCHEME.equals(uri.getScheme())) {
            return permissionsForPath(uri.getPath());
        }
        if (uri.getScheme() == null) {
            return EnumSet.of(Permission.READ);
        }
        return EnumSet.noneOf(Permission.class);
    }

    private void ensurePermission(Uri uri, Permission permission, String str) throws IOException {
        if (!permissionsForUri(uri).contains(permission)) {
            throw new IOException(str);
        }
    }

    private void ensurePermission(Uri uri, Permission permission) throws IOException {
        if (permission.equals(Permission.READ)) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't readable.");
        }
        if (permission.equals(Permission.WRITE)) {
            ensurePermission(uri, permission, "Location '" + uri + "' isn't writable.");
        }
        ensurePermission(uri, permission, "Location '" + uri + "' doesn't have permission '" + permission.name() + "'.");
    }

    private InputStream openAssetInputStream(Uri uri) throws IOException {
        return getContext().getAssets().open(uri.getPath().substring(1));
    }

    private InputStream openResourceInputStream(String str) throws IOException {
        int identifier = getContext().getResources().getIdentifier(str, "raw", getContext().getPackageName());
        if (identifier != 0 || (identifier = getContext().getResources().getIdentifier(str, "drawable", getContext().getPackageName())) != 0) {
            return getContext().getResources().openRawResource(identifier);
        }
        throw new FileNotFoundException("No resource found with the name " + str);
    }

    @ExpoMethod
    public void getInfoAsync(String str, Map<String, Object> map, Promise promise) {
        InputStream inputStream;
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.READ);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                File uriToFile = uriToFile(parse);
                Bundle bundle = new Bundle();
                if (uriToFile.exists()) {
                    bundle.putBoolean("exists", true);
                    bundle.putBoolean("isDirectory", uriToFile.isDirectory());
                    bundle.putString("uri", Uri.fromFile(uriToFile).toString());
                    if (map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                        bundle.putString("md5", md5(uriToFile));
                    }
                    bundle.putDouble("size", (double) uriToFile.length());
                    bundle.putDouble("modificationTime", ((double) uriToFile.lastModified()) * 0.001d);
                    promise.resolve(bundle);
                    return;
                }
                bundle.putBoolean("exists", false);
                bundle.putBoolean("isDirectory", false);
                promise.resolve(bundle);
                return;
            }
            if (!UriUtil.LOCAL_CONTENT_SCHEME.equals(parse.getScheme()) && !UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                if (parse.getScheme() != null) {
                    throw new IOException("Unsupported scheme for location '" + parse + "'.");
                }
            }
            Bundle bundle2 = new Bundle();
            try {
                if (UriUtil.LOCAL_CONTENT_SCHEME.equals(parse.getScheme())) {
                    inputStream = getContext().getContentResolver().openInputStream(parse);
                } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                    inputStream = openAssetInputStream(parse);
                } else {
                    inputStream = openResourceInputStream(str);
                }
                if (inputStream != null) {
                    bundle2.putBoolean("exists", true);
                    bundle2.putBoolean("isDirectory", false);
                    bundle2.putString("uri", parse.toString());
                    bundle2.putDouble("size", (double) inputStream.available());
                    if (map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                        bundle2.putString("md5", String.valueOf(Hex.encodeHex(DigestUtils.md5(inputStream))));
                    }
                    promise.resolve(bundle2);
                    return;
                }
                throw new FileNotFoundException();
            } catch (FileNotFoundException unused) {
                bundle2.putBoolean("exists", false);
                bundle2.putBoolean("isDirectory", false);
                promise.resolve(bundle2);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void readAsStringAsync(String str, Map<String, Object> map, Promise promise) {
        String str2;
        InputStream inputStream;
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.READ);
            String str3 = RNFetchBlobConst.RNFB_RESPONSE_UTF8;
            if (map.containsKey("encoding") && (map.get("encoding") instanceof String)) {
                str3 = ((String) map.get("encoding")).toLowerCase();
            }
            if (str3.equalsIgnoreCase(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
                if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                    inputStream = new FileInputStream(uriToFile(parse));
                } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                    inputStream = openAssetInputStream(parse);
                } else {
                    throw new IOException("Unsupported scheme for location '" + parse + "'.");
                }
                if (!map.containsKey("length") || !map.containsKey(ViewProps.POSITION)) {
                    str2 = Base64.encodeToString(getInputStreamBytes(inputStream), 2);
                } else {
                    int intValue = ((Number) map.get("length")).intValue();
                    byte[] bArr = new byte[intValue];
                    inputStream.skip((long) ((Number) map.get(ViewProps.POSITION)).intValue());
                    str2 = Base64.encodeToString(bArr, 0, inputStream.read(bArr, 0, intValue), 2);
                }
            } else if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                str2 = IOUtils.toString((InputStream) new FileInputStream(uriToFile(parse)));
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                str2 = IOUtils.toString(openAssetInputStream(parse));
            } else if (parse.getScheme() == null) {
                str2 = IOUtils.toString(openResourceInputStream(str));
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
            promise.resolve(str2);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void writeAsStringAsync(String str, String str2, Map<String, Object> map, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.WRITE);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                String str3 = RNFetchBlobConst.RNFB_RESPONSE_UTF8;
                if (map.containsKey("encoding") && (map.get("encoding") instanceof String)) {
                    str3 = ((String) map.get("encoding")).toLowerCase();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(uriToFile(parse));
                if (str3.equals(RNFetchBlobConst.RNFB_RESPONSE_BASE64)) {
                    fileOutputStream.write(Base64.decode(str2, 0));
                } else {
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(str2);
                    outputStreamWriter.close();
                }
                fileOutputStream.close();
                promise.resolve((Object) null);
                return;
            }
            throw new IOException("Unsupported scheme for location '" + parse + "'.");
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void deleteAsync(String str, Map<String, Object> map, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
            Permission permission = Permission.WRITE;
            ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't deletable.");
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                File uriToFile = uriToFile(parse);
                if (uriToFile.exists()) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        FileUtils.forceDelete(uriToFile);
                    } else {
                        forceDelete(uriToFile);
                    }
                    promise.resolve((Object) null);
                } else if (!map.containsKey("idempotent") || !((Boolean) map.get("idempotent")).booleanValue()) {
                    promise.reject("ERR_FILESYSTEM_CANNOT_FIND_FILE", "File '" + parse + "' could not be deleted because it could not be found");
                } else {
                    promise.resolve((Object) null);
                }
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void moveAsync(Map<String, Object> map, Promise promise) {
        try {
            if (!map.containsKey("from")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
                return;
            }
            Uri parse = Uri.parse((String) map.get("from"));
            Uri withAppendedPath = Uri.withAppendedPath(parse, "..");
            Permission permission = Permission.WRITE;
            ensurePermission(withAppendedPath, permission, "Location '" + parse + "' isn't movable.");
            if (!map.containsKey("to")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            Uri parse2 = Uri.parse((String) map.get("to"));
            ensurePermission(parse2, Permission.WRITE);
            if (!UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            } else if (uriToFile(parse).renameTo(uriToFile(parse2))) {
                promise.resolve((Object) null);
            } else {
                promise.reject("ERR_FILESYSTEM_CANNOT_MOVE_FILE", "File '" + parse + "' could not be moved to '" + parse2 + "'");
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void copyAsync(Map<String, Object> map, Promise promise) {
        try {
            if (!map.containsKey("from")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `from` path.");
                return;
            }
            Uri parse = Uri.parse((String) map.get("from"));
            ensurePermission(parse, Permission.READ);
            if (!map.containsKey("to")) {
                promise.reject("ERR_FILESYSTEM_MISSING_PARAMETER", "`FileSystem.moveAsync` needs a `to` path.");
                return;
            }
            Uri parse2 = Uri.parse((String) map.get("to"));
            ensurePermission(parse2, Permission.WRITE);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                File uriToFile = uriToFile(parse);
                File uriToFile2 = uriToFile(parse2);
                if (uriToFile.isDirectory()) {
                    FileUtils.copyDirectory(uriToFile, uriToFile2);
                    promise.resolve((Object) null);
                    return;
                }
                FileUtils.copyFile(uriToFile, uriToFile2);
                promise.resolve((Object) null);
            } else if (UriUtil.LOCAL_CONTENT_SCHEME.equals(parse.getScheme())) {
                IOUtils.copy(getContext().getContentResolver().openInputStream(parse), (OutputStream) new FileOutputStream(uriToFile(parse2)));
                promise.resolve((Object) null);
            } else if (UriUtil.LOCAL_ASSET_SCHEME.equals(parse.getScheme())) {
                IOUtils.copy(openAssetInputStream(parse), (OutputStream) new FileOutputStream(uriToFile(parse2)));
                promise.resolve((Object) null);
            } else if (parse.getScheme() == null) {
                IOUtils.copy(openResourceInputStream((String) map.get("from")), (OutputStream) new FileOutputStream(uriToFile(parse2)));
                promise.resolve((Object) null);
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void makeDirectoryAsync(String str, Map<String, Object> map, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.WRITE);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                File uriToFile = uriToFile(parse);
                boolean isDirectory = uriToFile.isDirectory();
                boolean z = map.containsKey("intermediates") && ((Boolean) map.get("intermediates")).booleanValue();
                if (!(z ? uriToFile.mkdirs() : uriToFile.mkdir())) {
                    if (!z || !isDirectory) {
                        promise.reject("ERR_FILESYSTEM_CANNOT_CREATE_DIRECTORY", "Directory '" + parse + "' could not be created or already exists.");
                        return;
                    }
                }
                promise.resolve((Object) null);
                return;
            }
            throw new IOException("Unsupported scheme for location '" + parse + "'.");
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void readDirectoryAsync(String str, Map<String, Object> map, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.READ);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                File[] listFiles = uriToFile(parse).listFiles();
                if (listFiles != null) {
                    ArrayList arrayList = new ArrayList();
                    for (File name : listFiles) {
                        arrayList.add(name.getName());
                    }
                    promise.resolve(arrayList);
                    return;
                }
                promise.reject("ERR_FILESYSTEM_CANNOT_READ_DIRECTORY", "Directory '" + parse + "' could not be read.");
                return;
            }
            throw new IOException("Unsupported scheme for location '" + parse + "'.");
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void uploadAsync(String str, String str2, Map<String, Object> map, final Promise promise) {
        String str3;
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.READ);
            checkIfFileExists(parse);
            MediaType mediaType = null;
            if (!map.containsKey("httpMethod")) {
                promise.reject("ERR_FILESYSTEM_MISSING_HTTP_METHOD", "Missing HTTP method.", (Throwable) null);
                return;
            }
            String str4 = (String) map.get("httpMethod");
            if (!map.containsKey("uploadType")) {
                promise.reject("ERR_FILESYSTEM_MISSING_UPLOAD_TYPE", "Missing upload type.", (Throwable) null);
                return;
            }
            UploadType fromInteger = UploadType.fromInteger((Integer) map.get("uploadType"));
            Request.Builder url = new Request.Builder().url(str2);
            if (map.containsKey(HEADER_KEY)) {
                Map map2 = (Map) map.get(HEADER_KEY);
                for (String str5 : map2.keySet()) {
                    url.addHeader(str5, map2.get(str5).toString());
                }
            }
            File uriToFile = uriToFile(parse);
            if (fromInteger == UploadType.BINARY_CONTENT) {
                url.method(str4, RequestBody.create((MediaType) null, uriToFile));
            } else if (fromInteger == UploadType.MULTIPART) {
                MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
                if (map.containsKey("parameters")) {
                    Map map3 = (Map) map.get("parameters");
                    for (String str6 : map3.keySet()) {
                        type.addFormDataPart(str6, String.valueOf(map3.get(str6)));
                    }
                }
                if (map.containsKey("mimeType")) {
                    str3 = (String) map.get("mimeType");
                } else {
                    str3 = URLConnection.guessContentTypeFromName(uriToFile.getName());
                }
                String name = uriToFile.getName();
                if (map.containsKey("fieldName")) {
                    name = (String) map.get("fieldName");
                }
                String name2 = uriToFile.getName();
                if (str3 != null) {
                    mediaType = MediaType.parse(str3);
                }
                type.addFormDataPart(name, name2, RequestBody.create(mediaType, uriToFile));
                url.method(str4, type.build());
            } else {
                promise.reject("ERR_FILESYSTEM_INVALID_UPLOAD_TYPE", String.format("Invalid upload type: %s.", new Object[]{map.get("uploadType")}), (Throwable) null);
                return;
            }
            getOkHttpClient().newCall(url.build()).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    Log.e(FileSystemModule.TAG, String.valueOf(iOException.getMessage()));
                    promise.reject(iOException);
                }

                public void onResponse(Call call, C3873Response response) {
                    Bundle bundle = new Bundle();
                    try {
                        if (response.body() != null) {
                            bundle.putString(TtmlNode.TAG_BODY, response.body().string());
                        } else {
                            bundle.putString(TtmlNode.TAG_BODY, (String) null);
                        }
                        bundle.putInt("status", response.code());
                        bundle.putBundle(FileSystemModule.HEADER_KEY, FileSystemModule.translateHeaders(response.headers()));
                        response.close();
                        promise.resolve(bundle);
                    } catch (IOException e) {
                        promise.reject(e);
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void downloadAsync(String str, String str2, final Map<String, Object> map, final Promise promise) {
        try {
            final Uri parse = Uri.parse(str2);
            ensurePermission(parse, Permission.WRITE);
            checkIfFileDirExists(parse);
            if (!str.contains(ParameterizedMessage.ERROR_MSG_SEPARATOR)) {
                Context context = getContext();
                BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(context.getResources().getIdentifier(str, "raw", context.getPackageName()))));
                File uriToFile = uriToFile(parse);
                uriToFile.delete();
                BufferedSink buffer2 = Okio.buffer(Okio.sink(uriToFile));
                buffer2.writeAll(buffer);
                buffer2.close();
                Bundle bundle = new Bundle();
                bundle.putString("uri", Uri.fromFile(uriToFile).toString());
                if (map != null && map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                    bundle.putString("md5", md5(uriToFile));
                }
                promise.resolve(bundle);
            } else if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                Request.Builder url = new Request.Builder().url(str);
                if (map != null && map.containsKey(HEADER_KEY)) {
                    try {
                        Map map2 = (Map) map.get(HEADER_KEY);
                        for (String str3 : map2.keySet()) {
                            url.addHeader(str3, (String) map2.get(str3));
                        }
                    } catch (ClassCastException e) {
                        promise.reject("ERR_FILESYSTEM_INVALID_HEADERS", "Invalid headers dictionary. Keys and values should be strings.", e);
                        return;
                    }
                }
                getOkHttpClient().newCall(url.build()).enqueue(new Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        Log.e(FileSystemModule.TAG, String.valueOf(iOException.getMessage()));
                        promise.reject(iOException);
                    }

                    public void onResponse(Call call, C3873Response response) throws IOException {
                        File access$200 = FileSystemModule.this.uriToFile(parse);
                        access$200.delete();
                        BufferedSink buffer = Okio.buffer(Okio.sink(access$200));
                        buffer.writeAll(response.body().source());
                        buffer.close();
                        Bundle bundle = new Bundle();
                        bundle.putString("uri", Uri.fromFile(access$200).toString());
                        if (map != null && map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                            bundle.putString("md5", FileSystemModule.this.md5(access$200));
                        }
                        bundle.putInt("status", response.code());
                        bundle.putBundle(FileSystemModule.HEADER_KEY, FileSystemModule.translateHeaders(response.headers()));
                        response.close();
                        promise.resolve(bundle);
                    }
                });
            } else {
                throw new IOException("Unsupported scheme for location '" + parse + "'.");
            }
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage());
            promise.reject(e2);
        }
    }

    @ExpoMethod
    public void getTotalDiskCapacityAsync(Promise promise) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            promise.resolve(Double.valueOf(Math.min(BigInteger.valueOf(statFs.getBlockCountLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1.0d)));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject("ERR_FILESYSTEM_CANNOT_DETERMINE_DISK_CAPACITY", "Unable to access total disk capacity", e);
        }
    }

    @ExpoMethod
    public void getFreeDiskStorageAsync(Promise promise) {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getAbsolutePath());
            promise.resolve(Double.valueOf(Math.min(BigInteger.valueOf(statFs.getAvailableBlocksLong()).multiply(BigInteger.valueOf(statFs.getBlockSizeLong())).doubleValue(), Math.pow(2.0d, 53.0d) - 1.0d)));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject("ERR_FILESYSTEM_CANNOT_DETERMINE_DISK_CAPACITY", "Unable to determine free disk storage capacity", e);
        }
    }

    @ExpoMethod
    public void getContentUriAsync(String str, Promise promise) {
        try {
            Uri parse = Uri.parse(str);
            ensurePermission(parse, Permission.WRITE);
            ensurePermission(parse, Permission.READ);
            checkIfFileDirExists(parse);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                promise.resolve(contentUriFromFile(uriToFile(parse)).toString());
                return;
            }
            promise.reject("ERR_FILESYSTEM_CANNOT_READ_DIRECTORY", "No readable files with the uri: " + str + ". Please use other uri.");
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    private Uri contentUriFromFile(File file) {
        try {
            Application application = ((ActivityProvider) this.mModuleRegistry.getModule(ActivityProvider.class)).getCurrentActivity().getApplication();
            return FileSystemFileProvider.getUriForFile(application, application.getPackageName() + ".FileSystemFileProvider", file);
        } catch (Exception e) {
            throw e;
        }
    }

    @ExpoMethod
    public void downloadResumableStartAsync(String str, String str2, final String str3, Map<String, Object> map, final String str4, Promise promise) {
        try {
            Uri parse = Uri.parse(str2);
            checkIfFileDirExists(parse);
            if (UriUtil.LOCAL_FILE_SCHEME.equals(parse.getScheme())) {
                final boolean z = str4 != null;
                final C34693 r2 = new ProgressListener() {
                    long mLastUpdate = -1;

                    public void update(long j, long j2, boolean z) {
                        EventEmitter eventEmitter = (EventEmitter) FileSystemModule.this.mModuleRegistry.getModule(EventEmitter.class);
                        if (eventEmitter != null) {
                            Bundle bundle = new Bundle();
                            Bundle bundle2 = new Bundle();
                            if (z) {
                                j += Long.parseLong(str4);
                            }
                            if (z) {
                                j2 += Long.parseLong(str4);
                            }
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis > this.mLastUpdate + FileSystemModule.MIN_EVENT_DT_MS || j == j2) {
                                this.mLastUpdate = currentTimeMillis;
                                bundle2.putDouble("totalBytesWritten", (double) j);
                                bundle2.putDouble("totalBytesExpectedToWrite", (double) j2);
                                bundle.putString("uuid", str3);
                                bundle.putBundle("data", bundle2);
                                eventEmitter.emit(FileSystemModule.EXDownloadProgressEventName, bundle);
                            }
                        }
                    }
                };
                OkHttpClient build = getOkHttpClient().newBuilder().addNetworkInterceptor(new Interceptor() {
                    public C3873Response intercept(Interceptor.Chain chain) throws IOException {
                        C3873Response proceed = chain.proceed(chain.request());
                        return proceed.newBuilder().body(new ProgressResponseBody(proceed.body(), r2)).build();
                    }
                }).build();
                Request.Builder builder = new Request.Builder();
                if (z) {
                    builder.addHeader("Range", "bytes=" + str4 + "-");
                }
                if (map != null && map.containsKey(HEADER_KEY)) {
                    Map map2 = (Map) map.get(HEADER_KEY);
                    for (String str5 : map2.keySet()) {
                        builder.addHeader(str5, map2.get(str5).toString());
                    }
                }
                Call newCall = build.newCall(builder.url(str).build());
                this.mDownloadResumableMap.put(str3, new DownloadResumable(str3, str, parse, newCall));
                new DownloadResumableTask().execute(new DownloadResumableTaskParams[]{new DownloadResumableTaskParams(map, newCall, uriToFile(parse), z, promise)});
                return;
            }
            throw new IOException("Unsupported scheme for location '" + parse + "'.");
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            promise.reject(e);
        }
    }

    @ExpoMethod
    public void downloadResumablePauseAsync(String str, Promise promise) {
        DownloadResumable downloadResumable = this.mDownloadResumableMap.get(str);
        if (downloadResumable != null) {
            downloadResumable.call.cancel();
            this.mDownloadResumableMap.remove(downloadResumable.uuid);
            try {
                File uriToFile = uriToFile(downloadResumable.fileUri);
                Bundle bundle = new Bundle();
                bundle.putString("resumeData", String.valueOf(uriToFile.length()));
                promise.resolve(bundle);
            } catch (Exception e) {
                Log.e(TAG, e.getMessage());
                promise.reject(e);
            }
        } else {
            IOException iOException = new IOException("No download object available");
            Log.e(TAG, iOException.getMessage());
            promise.reject(iOException);
        }
    }

    private static byte[] getInputStreamBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static class DownloadResumableTaskParams {
        Call call;
        File file;
        boolean isResume;
        Map<String, Object> options;
        Promise promise;

        DownloadResumableTaskParams(Map<String, Object> map, Call call2, File file2, boolean z, Promise promise2) {
            this.options = map;
            this.call = call2;
            this.file = file2;
            this.isResume = z;
            this.promise = promise2;
        }
    }

    private class DownloadResumableTask extends AsyncTask<DownloadResumableTaskParams, Void, Void> {
        private DownloadResumableTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(DownloadResumableTaskParams... downloadResumableTaskParamsArr) {
            FileOutputStream fileOutputStream;
            Call call = downloadResumableTaskParamsArr[0].call;
            Promise promise = downloadResumableTaskParamsArr[0].promise;
            File file = downloadResumableTaskParamsArr[0].file;
            boolean z = downloadResumableTaskParamsArr[0].isResume;
            Map<String, Object> map = downloadResumableTaskParamsArr[0].options;
            try {
                C3873Response execute = call.execute();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(execute.body().byteStream());
                if (z) {
                    fileOutputStream = new FileOutputStream(file, true);
                } else {
                    fileOutputStream = new FileOutputStream(file, false);
                }
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                Bundle bundle = new Bundle();
                bundle.putString("uri", Uri.fromFile(file).toString());
                if (map != null && map.containsKey("md5") && ((Boolean) map.get("md5")).booleanValue()) {
                    bundle.putString("md5", FileSystemModule.this.md5(file));
                }
                bundle.putInt("status", execute.code());
                bundle.putBundle(FileSystemModule.HEADER_KEY, FileSystemModule.translateHeaders(execute.headers()));
                execute.close();
                promise.resolve(bundle);
                return null;
            } catch (Exception e) {
                Log.e(FileSystemModule.TAG, e.getMessage());
                promise.reject(e);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Bundle translateHeaders(Headers headers) {
        Bundle bundle = new Bundle();
        for (int i = 0; i < headers.size(); i++) {
            String name = headers.name(i);
            if (bundle.get(name) != null) {
                bundle.putString(name, bundle.getString(name) + ", " + headers.value(i));
            } else {
                bundle.putString(name, headers.value(i));
            }
        }
        return bundle;
    }

    private static class DownloadResumable {
        public final Call call;
        public final Uri fileUri;
        public final String url;
        public final String uuid;

        public DownloadResumable(String str, String str2, Uri uri, Call call2) {
            this.uuid = str;
            this.url = str2;
            this.fileUri = uri;
            this.call = call2;
        }
    }

    private static class ProgressResponseBody extends ResponseBody {
        private BufferedSource bufferedSource;
        /* access modifiers changed from: private */
        public final ProgressListener progressListener;
        /* access modifiers changed from: private */
        public final ResponseBody responseBody;

        ProgressResponseBody(ResponseBody responseBody2, ProgressListener progressListener2) {
            this.responseBody = responseBody2;
            this.progressListener = progressListener2;
        }

        public MediaType contentType() {
            return this.responseBody.contentType();
        }

        public long contentLength() {
            return this.responseBody.contentLength();
        }

        public BufferedSource source() {
            if (this.bufferedSource == null) {
                this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
            }
            return this.bufferedSource;
        }

        private Source source(Source source) {
            return new ForwardingSource(source) {
                long totalBytesRead = 0;

                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                    this.totalBytesRead += i != 0 ? read : 0;
                    ProgressResponseBody.this.progressListener.update(this.totalBytesRead, ProgressResponseBody.this.responseBody.contentLength(), i == 0);
                    return read;
                }
            };
        }
    }

    private synchronized OkHttpClient getOkHttpClient() {
        if (this.mClient == null) {
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS);
            CookieHandler cookieHandler = (CookieHandler) this.mModuleRegistry.getModule(CookieHandler.class);
            if (cookieHandler != null) {
                writeTimeout.cookieJar(new JavaNetCookieJar(cookieHandler));
            }
            this.mClient = writeTimeout.build();
        }
        return this.mClient;
    }

    /* access modifiers changed from: private */
    public String md5(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return String.valueOf(Hex.encodeHex(DigestUtils.md5((InputStream) fileInputStream)));
        } finally {
            fileInputStream.close();
        }
    }

    private void ensureDirExists(File file) throws IOException {
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IOException("Couldn't create directory '" + file + "'");
        }
    }

    private void forceDelete(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                IOException e = null;
                for (File forceDelete : listFiles) {
                    try {
                        forceDelete(forceDelete);
                    } catch (IOException e2) {
                        e = e2;
                    }
                }
                if (e != null) {
                    throw e;
                } else if (!file.delete()) {
                    throw new IOException("Unable to delete directory " + file + ".");
                }
            } else {
                throw new IOException("Failed to list contents of " + file);
            }
        } else if (!file.delete()) {
            throw new IOException("Unable to delete file: " + file);
        }
    }
}
