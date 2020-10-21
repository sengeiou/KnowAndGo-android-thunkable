package com.bugsnag.android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.NativeInterface;
import java.io.IOException;
import java.util.Observable;

class User extends Observable implements JsonStream.Streamable {
    @Nullable
    private String email;
    @Nullable

    /* renamed from: id */
    private String f66id;
    @Nullable
    private String name;

    User() {
    }

    User(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.f66id = str;
        this.email = str2;
        this.name = str3;
    }

    User(@NonNull User user) {
        this(user.f66id, user.email, user.name);
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        jsonStream.beginObject();
        jsonStream.name("id").value(this.f66id);
        jsonStream.name("email").value(this.email);
        jsonStream.name("name").value(this.name);
        jsonStream.endObject();
    }

    @Nullable
    public String getId() {
        return this.f66id;
    }

    public void setId(@Nullable String str) {
        this.f66id = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_USER_ID, str));
    }

    @Nullable
    public String getEmail() {
        return this.email;
    }

    public void setEmail(@Nullable String str) {
        this.email = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_USER_EMAIL, str));
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public void setName(@Nullable String str) {
        this.name = str;
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.UPDATE_USER_NAME, str));
    }
}
