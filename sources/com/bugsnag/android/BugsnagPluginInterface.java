package com.bugsnag.android;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo39784bv = {1, 0, 3}, mo39785d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0001J\u0012\u0010\u000f\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005J\u0014\u0010\u0010\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0001R\u001e\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, mo39786d2 = {"Lcom/bugsnag/android/BugsnagPluginInterface;", "", "()V", "plugins", "", "Ljava/lang/Class;", "Lcom/bugsnag/android/BugsnagPlugin;", "registeredPluginClasses", "", "loadPlugin", "", "client", "Lcom/bugsnag/android/Client;", "clz", "loadRegisteredPlugins", "registerPlugin", "unloadPlugin", "bugsnag-android-core_release"}, mo39787k = 1, mo39788mv = {1, 1, 16})
/* compiled from: BugsnagPluginInterface.kt */
public final class BugsnagPluginInterface {
    public static final BugsnagPluginInterface INSTANCE = new BugsnagPluginInterface();
    private static Map<Class<?>, BugsnagPlugin> plugins = new LinkedHashMap();
    private static Set<Class<?>> registeredPluginClasses = new LinkedHashSet();

    private BugsnagPluginInterface() {
    }

    public final void registerPlugin(@NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clz");
        registeredPluginClasses.add(cls);
    }

    @JvmName(name = "loadRegisteredPlugins")
    public final void loadRegisteredPlugins(@NotNull Client client) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        for (Class loadPlugin : registeredPluginClasses) {
            INSTANCE.loadPlugin(client, loadPlugin);
        }
    }

    @JvmName(name = "loadPlugin")
    public final void loadPlugin(@NotNull Client client, @NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(client, "client");
        Intrinsics.checkParameterIsNotNull(cls, "clz");
        BugsnagPlugin bugsnagPlugin = plugins.get(cls);
        if (bugsnagPlugin == null) {
            try {
                Object newInstance = cls.newInstance();
                if (newInstance != null) {
                    bugsnagPlugin = (BugsnagPlugin) newInstance;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.bugsnag.android.BugsnagPlugin");
                }
            } catch (Exception unused) {
                bugsnagPlugin = null;
            }
        }
        if (bugsnagPlugin != null && !bugsnagPlugin.getLoaded()) {
            plugins.put(cls, bugsnagPlugin);
            bugsnagPlugin.loadPlugin(client);
            bugsnagPlugin.setLoaded(true);
        }
    }

    @JvmName(name = "unloadPlugin")
    public final void unloadPlugin(@NotNull Class<?> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "clz");
        BugsnagPlugin bugsnagPlugin = plugins.get(cls);
        if (bugsnagPlugin != null && bugsnagPlugin.getLoaded()) {
            bugsnagPlugin.unloadPlugin();
            bugsnagPlugin.setLoaded(false);
        }
    }
}
