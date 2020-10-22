package com.google.android.exoplayer2.upstream;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSource;

public final class DefaultDataSourceFactory implements DataSource.Factory {
    private final DataSource.Factory baseDataSourceFactory;
    private final Context context;
    @Nullable
    private final TransferListener listener;

    public DefaultDataSourceFactory(Context context2, String str) {
        this(context2, str, (TransferListener) null);
    }

    public DefaultDataSourceFactory(Context context2, String str, @Nullable TransferListener transferListener) {
        this(context2, transferListener, (DataSource.Factory) new DefaultHttpDataSourceFactory(str, transferListener));
    }

    public DefaultDataSourceFactory(Context context2, DataSource.Factory factory) {
        this(context2, (TransferListener) null, factory);
    }

    public DefaultDataSourceFactory(Context context2, @Nullable TransferListener transferListener, DataSource.Factory factory) {
        this.context = context2.getApplicationContext();
        this.listener = transferListener;
        this.baseDataSourceFactory = factory;
    }

    public DefaultDataSource createDataSource() {
        DefaultDataSource defaultDataSource = new DefaultDataSource(this.context, this.baseDataSourceFactory.createDataSource());
        if (this.listener != null) {
            defaultDataSource.addTransferListener(this.listener);
        }
        return defaultDataSource;
    }
}