package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

public abstract class JsonReader implements Closeable {
    private static final String[] REPLACEMENT_CHARS = new String[128];
    boolean failOnUnknown;
    boolean lenient;
    int[] pathIndices = new int[32];
    String[] pathNames = new String[32];
    int[] scopes = new int[32];
    int stackSize;

    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    public abstract void beginArray() throws IOException;

    public abstract void beginObject() throws IOException;

    public abstract void endArray() throws IOException;

    public abstract void endObject() throws IOException;

    public abstract boolean hasNext() throws IOException;

    public abstract boolean nextBoolean() throws IOException;

    public abstract double nextDouble() throws IOException;

    public abstract int nextInt() throws IOException;

    public abstract String nextName() throws IOException;

    public abstract String nextString() throws IOException;

    public abstract Token peek() throws IOException;

    public abstract int selectName(Options options) throws IOException;

    public abstract void skipName() throws IOException;

    public abstract void skipValue() throws IOException;

    static {
        for (int i = 0; i <= 31; i++) {
            REPLACEMENT_CHARS[i] = String.format("\\u%04x", new Object[]{Integer.valueOf(i)});
        }
        REPLACEMENT_CHARS[34] = "\\\"";
        REPLACEMENT_CHARS[92] = "\\\\";
        REPLACEMENT_CHARS[9] = "\\t";
        REPLACEMENT_CHARS[8] = "\\b";
        REPLACEMENT_CHARS[10] = "\\n";
        REPLACEMENT_CHARS[13] = "\\r";
        REPLACEMENT_CHARS[12] = "\\f";
    }

    /* renamed from: of */
    public static JsonReader m18of(BufferedSource bufferedSource) {
        return new JsonUtf8Reader(bufferedSource);
    }

    JsonReader() {
    }

    /* access modifiers changed from: package-private */
    public final void pushScope(int i) {
        if (this.stackSize == this.scopes.length) {
            if (this.stackSize != 256) {
                this.scopes = Arrays.copyOf(this.scopes, this.scopes.length * 2);
                this.pathNames = (String[]) Arrays.copyOf(this.pathNames, this.pathNames.length * 2);
                this.pathIndices = Arrays.copyOf(this.pathIndices, this.pathIndices.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
        }
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr[i2] = i;
    }

    /* access modifiers changed from: package-private */
    public final JsonEncodingException syntaxError(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public static final class Options {
        final okio.Options doubleQuoteSuffix;
        final String[] strings;

        private Options(String[] strArr, okio.Options options) {
            this.strings = strArr;
            this.doubleQuoteSuffix = options;
        }

        /* renamed from: of */
        public static Options m19of(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i = 0; i < strArr.length; i++) {
                    JsonReader.string(buffer, strArr[i]);
                    buffer.readByte();
                    byteStringArr[i] = buffer.readByteString();
                }
                return new Options((String[]) strArr.clone(), okio.Options.m2493of(byteStringArr));
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void string(BufferedSink bufferedSink, String str) throws IOException {
        String str2;
        String[] strArr = REPLACEMENT_CHARS;
        bufferedSink.writeByte(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i < i2) {
                bufferedSink.writeUtf8(str, i, i2);
            }
            bufferedSink.writeUtf8(str2);
            i = i2 + 1;
        }
        if (i < length) {
            bufferedSink.writeUtf8(str, i, length);
        }
        bufferedSink.writeByte(34);
    }
}
