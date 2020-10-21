package com.bugsnag.android;

import androidx.annotation.NonNull;
import com.bugsnag.android.JsonStream;
import com.bugsnag.android.NativeInterface;
import java.io.IOException;
import java.util.Observable;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

class Breadcrumbs extends Observable implements JsonStream.Streamable {
    private static final int MAX_PAYLOAD_SIZE = 4096;
    private final Configuration configuration;
    final Queue<Breadcrumb> store = new ConcurrentLinkedQueue();

    Breadcrumbs(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public void toStream(@NonNull JsonStream jsonStream) throws IOException {
        pruneBreadcrumbs();
        jsonStream.beginArray();
        for (Breadcrumb stream : this.store) {
            stream.toStream(jsonStream);
        }
        jsonStream.endArray();
    }

    /* access modifiers changed from: package-private */
    public void add(@NonNull Breadcrumb breadcrumb) {
        addToStore(breadcrumb);
    }

    /* access modifiers changed from: package-private */
    public void clear() {
        this.store.clear();
        setChanged();
        notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.CLEAR_BREADCRUMBS, (Object) null));
    }

    private void addToStore(@NonNull Breadcrumb breadcrumb) {
        try {
            if (breadcrumb.payloadSize() > 4096) {
                Logger.warn("Dropping breadcrumb because payload exceeds 4KB limit");
                return;
            }
            this.store.add(breadcrumb);
            pruneBreadcrumbs();
            setChanged();
            notifyObservers(new NativeInterface.Message(NativeInterface.MessageType.ADD_BREADCRUMB, breadcrumb));
        } catch (IOException e) {
            Logger.warn("Dropping breadcrumb because it could not be serialized", e);
        }
    }

    private void pruneBreadcrumbs() {
        int maxBreadcrumbs = this.configuration.getMaxBreadcrumbs();
        while (this.store.size() > maxBreadcrumbs) {
            this.store.poll();
        }
    }
}
