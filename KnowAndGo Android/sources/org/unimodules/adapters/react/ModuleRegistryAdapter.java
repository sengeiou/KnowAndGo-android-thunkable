package org.unimodules.adapters.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.List;
import org.unimodules.adapters.react.views.SimpleViewManagerAdapter;
import org.unimodules.adapters.react.views.ViewGroupManagerAdapter;
import org.unimodules.core.ModuleRegistry;
import org.unimodules.core.interfaces.InternalModule;

public class ModuleRegistryAdapter implements ReactPackage {
    protected ReactModuleRegistryProvider mModuleRegistryProvider;
    protected ReactAdapterPackage mReactAdapterPackage = new ReactAdapterPackage();

    public ModuleRegistryAdapter(ReactModuleRegistryProvider reactModuleRegistryProvider) {
        this.mModuleRegistryProvider = reactModuleRegistryProvider;
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ModuleRegistry moduleRegistry = this.mModuleRegistryProvider.get(reactApplicationContext);
        for (InternalModule registerInternalModule : this.mReactAdapterPackage.createInternalModules(reactApplicationContext)) {
            moduleRegistry.registerInternalModule(registerInternalModule);
        }
        return getNativeModulesFromModuleRegistry(reactApplicationContext, moduleRegistry);
    }

    /* access modifiers changed from: protected */
    public List<NativeModule> getNativeModulesFromModuleRegistry(ReactApplicationContext reactApplicationContext, ModuleRegistry moduleRegistry) {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new NativeModulesProxy(reactApplicationContext, moduleRegistry));
        arrayList.add(new ModuleRegistryReadyNotifier(moduleRegistry));
        for (ReactPackage createNativeModules : ((ReactPackagesProvider) moduleRegistry.getModule(ReactPackagesProvider.class)).getReactPackages()) {
            arrayList.addAll(createNativeModules.createNativeModules(reactApplicationContext));
        }
        return arrayList;
    }

    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList(this.mModuleRegistryProvider.getReactViewManagers(reactApplicationContext));
        for (org.unimodules.core.ViewManager next : this.mModuleRegistryProvider.getViewManagers(reactApplicationContext)) {
            switch (next.getViewManagerType()) {
                case GROUP:
                    arrayList.add(new ViewGroupManagerAdapter(next));
                    break;
                case SIMPLE:
                    arrayList.add(new SimpleViewManagerAdapter(next));
                    break;
            }
        }
        return arrayList;
    }
}
