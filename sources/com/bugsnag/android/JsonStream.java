package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

public class JsonStream extends JsonWriter {
    private final ObjectJsonStreamer objectJsonStreamer = new ObjectJsonStreamer();
    private final Writer out;

    public interface Streamable {
        void toStream(@NonNull JsonStream jsonStream) throws IOException;
    }

    public /* bridge */ /* synthetic */ JsonWriter beginArray() throws IOException {
        return super.beginArray();
    }

    public /* bridge */ /* synthetic */ JsonWriter beginObject() throws IOException {
        return super.beginObject();
    }

    public /* bridge */ /* synthetic */ void close() throws IOException {
        super.close();
    }

    public /* bridge */ /* synthetic */ JsonWriter endArray() throws IOException {
        return super.endArray();
    }

    public /* bridge */ /* synthetic */ JsonWriter endObject() throws IOException {
        return super.endObject();
    }

    public /* bridge */ /* synthetic */ void flush() throws IOException {
        super.flush();
    }

    public /* bridge */ /* synthetic */ boolean isLenient() {
        return super.isLenient();
    }

    public /* bridge */ /* synthetic */ JsonWriter jsonValue(String str) throws IOException {
        return super.jsonValue(str);
    }

    public /* bridge */ /* synthetic */ JsonWriter nullValue() throws IOException {
        return super.nullValue();
    }

    public /* bridge */ /* synthetic */ JsonWriter value(double d) throws IOException {
        return super.value(d);
    }

    public /* bridge */ /* synthetic */ JsonWriter value(long j) throws IOException {
        return super.value(j);
    }

    public /* bridge */ /* synthetic */ JsonWriter value(Boolean bool) throws IOException {
        return super.value(bool);
    }

    public /* bridge */ /* synthetic */ JsonWriter value(Number number) throws IOException {
        return super.value(number);
    }

    public /* bridge */ /* synthetic */ JsonWriter value(String str) throws IOException {
        return super.value(str);
    }

    public /* bridge */ /* synthetic */ JsonWriter value(boolean z) throws IOException {
        return super.value(z);
    }

    public JsonStream(@NonNull Writer writer) {
        super(writer);
        setSerializeNulls(false);
        this.out = writer;
    }

    @NonNull
    public JsonStream name(@Nullable String str) throws IOException {
        super.name(str);
        return this;
    }

    public void value(@Nullable Streamable streamable) throws IOException {
        if (streamable == null) {
            nullValue();
        } else {
            streamable.toStream(this);
        }
    }

    public void value(@NonNull Object obj) throws IOException {
        this.objectJsonStreamer.objectToStream(obj, this);
    }

    public void value(@NonNull File file) throws IOException {
        if (file != null && file.length() > 0) {
            super.flush();
            beforeValue();
            BufferedReader bufferedReader = null;
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                try {
                    IOUtils.copy(bufferedReader2, this.out);
                    IOUtils.closeQuietly(bufferedReader2);
                    this.out.flush();
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedReader = bufferedReader2;
                    th = th2;
                    IOUtils.closeQuietly(bufferedReader);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.closeQuietly(bufferedReader);
                throw th;
            }
        }
    }
}
