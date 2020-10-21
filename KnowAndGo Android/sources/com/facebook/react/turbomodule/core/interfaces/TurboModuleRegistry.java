package com.facebook.react.turbomodule.core.interfaces;

import androidx.annotation.Nullable;
import java.util.Collection;
import java.util.List;

public interface TurboModuleRegistry {
    List<String> getEagerInitModuleNames();

    @Nullable
    TurboModule getModule(String str);

    Collection<TurboModule> getModules();

    boolean hasModule(String str);
}
