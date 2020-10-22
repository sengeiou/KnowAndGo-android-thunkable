package com.polidea.rxandroidble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import bleshadow.dagger.internal.DelegateFactory;
import bleshadow.dagger.internal.DoubleCheck;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.dagger.internal.SetBuilder;
import bleshadow.javax.inject.Provider;
import com.jakewharton.rxrelay.BehaviorRelay;
import com.polidea.rxandroidble.ClientComponent;
import com.polidea.rxandroidble.RxBleConnection;
import com.polidea.rxandroidble.helpers.LocationServicesOkObservable;
import com.polidea.rxandroidble.helpers.LocationServicesOkObservable_Factory;
import com.polidea.rxandroidble.internal.DeviceComponent;
import com.polidea.rxandroidble.internal.DeviceModule;
import com.polidea.rxandroidble.internal.DeviceModule_ProvideBluetoothDeviceFactory;
import com.polidea.rxandroidble.internal.DeviceModule_ProvideConnectionStateChangeListenerFactory;
import com.polidea.rxandroidble.internal.DeviceModule_ProvideConnectionStateRelayFactory;
import com.polidea.rxandroidble.internal.DeviceModule_ProvideMacAddressFactory;
import com.polidea.rxandroidble.internal.DeviceModule_ProvidesConnectTimeoutConfFactory;
import com.polidea.rxandroidble.internal.DeviceModule_ProvidesDisconnectTimeoutConfFactory;
import com.polidea.rxandroidble.internal.RxBleDeviceImpl_Factory;
import com.polidea.rxandroidble.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble.internal.RxBleDeviceProvider_Factory;
import com.polidea.rxandroidble.internal.cache.DeviceComponentCache;
import com.polidea.rxandroidble.internal.cache.DeviceComponentCache_Factory;
import com.polidea.rxandroidble.internal.connection.BluetoothGattProvider;
import com.polidea.rxandroidble.internal.connection.BluetoothGattProvider_Factory;
import com.polidea.rxandroidble.internal.connection.ConnectionComponent;
import com.polidea.rxandroidble.internal.connection.ConnectionModule;
import com.polidea.rxandroidble.internal.connection.ConnectionModuleBinder_GattWriteMtuOverheadFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModuleBinder_MinimumMtuFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModuleBinder_ProvideBluetoothGattFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModule_ProvideAutoConnectFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModule_ProvideCharacteristicPropertiesParserFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModule_ProvideIllegalOperationHandlerFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionModule_ProvidesOperationTimeoutConfFactory;
import com.polidea.rxandroidble.internal.connection.ConnectionStateChangeListener;
import com.polidea.rxandroidble.internal.connection.ConnectionSubscriptionWatcher;
import com.polidea.rxandroidble.internal.connection.ConnectorImpl_Factory;
import com.polidea.rxandroidble.internal.connection.DescriptorWriter_Factory;
import com.polidea.rxandroidble.internal.connection.DisconnectAction_Factory;
import com.polidea.rxandroidble.internal.connection.DisconnectionRouter_Factory;
import com.polidea.rxandroidble.internal.connection.IllegalOperationChecker_Factory;
import com.polidea.rxandroidble.internal.connection.IllegalOperationMessageCreator_Factory;
import com.polidea.rxandroidble.internal.connection.LoggingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble.internal.connection.LongWriteOperationBuilderImpl_Factory;
import com.polidea.rxandroidble.internal.connection.MtuBasedPayloadSizeLimit_Factory;
import com.polidea.rxandroidble.internal.connection.MtuWatcher_Factory;
import com.polidea.rxandroidble.internal.connection.NativeCallbackDispatcher_Factory;
import com.polidea.rxandroidble.internal.connection.NotificationAndIndicationManager_Factory;
import com.polidea.rxandroidble.internal.connection.RxBleConnectionImpl;
import com.polidea.rxandroidble.internal.connection.RxBleConnectionImpl_Factory;
import com.polidea.rxandroidble.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble.internal.connection.RxBleGattCallback_Factory;
import com.polidea.rxandroidble.internal.connection.ServiceDiscoveryManager_Factory;
import com.polidea.rxandroidble.internal.connection.ThrowingIllegalOperationHandler_Factory;
import com.polidea.rxandroidble.internal.operations.ConnectOperation;
import com.polidea.rxandroidble.internal.operations.ConnectOperation_Factory;
import com.polidea.rxandroidble.internal.operations.DisconnectOperation_Factory;
import com.polidea.rxandroidble.internal.operations.OperationsProviderImpl_Factory;
import com.polidea.rxandroidble.internal.operations.ReadRssiOperation_Factory;
import com.polidea.rxandroidble.internal.operations.TimeoutConfiguration;
import com.polidea.rxandroidble.internal.scan.AndroidScanObjectsConverter_Factory;
import com.polidea.rxandroidble.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble.internal.scan.InternalScanResultCreator_Factory;
import com.polidea.rxandroidble.internal.scan.InternalToExternalScanResultConverter_Factory;
import com.polidea.rxandroidble.internal.scan.ScanPreconditionsVerifierApi18_Factory;
import com.polidea.rxandroidble.internal.scan.ScanPreconditionsVerifierApi24_Factory;
import com.polidea.rxandroidble.internal.scan.ScanSettingsEmulator_Factory;
import com.polidea.rxandroidble.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble.internal.scan.ScanSetupBuilderImplApi18_Factory;
import com.polidea.rxandroidble.internal.scan.ScanSetupBuilderImplApi21_Factory;
import com.polidea.rxandroidble.internal.scan.ScanSetupBuilderImplApi23_Factory;
import com.polidea.rxandroidble.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble.internal.serialization.ClientOperationQueueImpl_Factory;
import com.polidea.rxandroidble.internal.serialization.ConnectionOperationQueueImpl;
import com.polidea.rxandroidble.internal.serialization.ConnectionOperationQueueImpl_Factory;
import com.polidea.rxandroidble.internal.util.BleConnectionCompat;
import com.polidea.rxandroidble.internal.util.CheckerLocationPermission_Factory;
import com.polidea.rxandroidble.internal.util.CheckerLocationProvider_Factory;
import com.polidea.rxandroidble.internal.util.ClientStateObservable_Factory;
import com.polidea.rxandroidble.internal.util.LocationServicesOkObservableApi23_Factory;
import com.polidea.rxandroidble.internal.util.LocationServicesStatusApi18_Factory;
import com.polidea.rxandroidble.internal.util.LocationServicesStatusApi23_Factory;
import com.polidea.rxandroidble.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble.internal.util.RxBleAdapterWrapper_Factory;
import com.polidea.rxandroidble.internal.util.RxBleServicesLogger_Factory;
import com.polidea.rxandroidble.internal.util.UUIDUtil_Factory;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import p033rx.Observable;
import p033rx.Scheduler;

public final class DaggerClientComponent implements ClientComponent {
    private AndroidScanObjectsConverter_Factory androidScanObjectsConverterProvider;
    /* access modifiers changed from: private */
    public Provider<ClientOperationQueue> bindClientOperationQueueProvider;
    private Provider<RxBleClient> bindRxBleClientProvider;
    private CheckerLocationPermission_Factory checkerLocationPermissionProvider;
    private CheckerLocationProvider_Factory checkerLocationProvider;
    /* access modifiers changed from: private */
    public ClientComponent.ClientModule clientModule;
    private ClientOperationQueueImpl_Factory clientOperationQueueImplProvider;
    private ClientStateObservable_Factory clientStateObservableProvider;
    private Provider<DeviceComponent.Builder> deviceComponentBuilderProvider;
    private Provider<DeviceComponentCache> deviceComponentCacheProvider;
    private Provider<InternalScanResultCreator> internalScanResultCreatorProvider;
    private InternalToExternalScanResultConverter_Factory internalToExternalScanResultConverterProvider;
    private LocationServicesOkObservableApi23_Factory locationServicesOkObservableApi23Provider;
    private LocationServicesStatusApi23_Factory locationServicesStatusApi23Provider;
    private ClientComponent_ClientModule_ProvideApplicationContextFactory provideApplicationContextProvider;
    private Provider<ExecutorService> provideBluetoothCallbacksExecutorServiceProvider;
    /* access modifiers changed from: private */
    public Provider<Scheduler> provideBluetoothCallbacksSchedulerProvider;
    private Provider<ExecutorService> provideBluetoothInteractionExecutorServiceProvider;
    /* access modifiers changed from: private */
    public Provider<Scheduler> provideBluetoothInteractionSchedulerProvider;
    /* access modifiers changed from: private */
    public ClientComponent_ClientModule_ProvideBluetoothManagerFactory provideBluetoothManagerProvider;
    /* access modifiers changed from: private */
    public Provider<ExecutorService> provideConnectionQueueExecutorServiceProvider;
    private ClientComponent_ClientModule_ProvideContentResolverFactory provideContentResolverProvider;
    private ClientComponent_ClientModule_ProvideFinalizationCloseableFactory provideFinalizationCloseableProvider;
    private ClientComponent_ClientModule_ProvideIsAndroidWearFactory provideIsAndroidWearProvider;
    private ClientComponent_ClientModule_ProvideLocationManagerFactory provideLocationManagerProvider;
    private C2607x61f40e72 provideLocationServicesOkObservableProvider;
    private C2608x9cd4449f provideLocationServicesStatusProvider;
    private C2609x8de81979 provideScanPreconditionVerifierProvider;
    private Provider<ScanSetupBuilder> provideScanSetupProvider;
    private ClientComponent_ClientModule_ProvideTargetSdkFactory provideTargetSdkProvider;
    /* access modifiers changed from: private */
    public RxBleAdapterStateObservable_Factory rxBleAdapterStateObservableProvider;
    /* access modifiers changed from: private */
    public RxBleAdapterWrapper_Factory rxBleAdapterWrapperProvider;
    private RxBleClientImpl_Factory rxBleClientImplProvider;
    private Provider<RxBleDeviceProvider> rxBleDeviceProvider;
    private ScanPreconditionsVerifierApi18_Factory scanPreconditionsVerifierApi18Provider;
    private ScanPreconditionsVerifierApi24_Factory scanPreconditionsVerifierApi24Provider;
    private ScanSettingsEmulator_Factory scanSettingsEmulatorProvider;
    private ScanSetupBuilderImplApi18_Factory scanSetupBuilderImplApi18Provider;
    private ScanSetupBuilderImplApi21_Factory scanSetupBuilderImplApi21Provider;
    private ScanSetupBuilderImplApi23_Factory scanSetupBuilderImplApi23Provider;

    private DaggerClientComponent(Builder builder) {
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    private Observable<Boolean> getNamedObservableOfBoolean() {
        return C2607x61f40e72.proxyProvideLocationServicesOkObservable(this.clientModule, ClientComponent.ClientModule.provideDeviceSdk(), this.locationServicesOkObservableApi23Provider);
    }

    /* access modifiers changed from: private */
    public RxBleAdapterWrapper getRxBleAdapterWrapper() {
        return new RxBleAdapterWrapper(ClientComponent.ClientModule.provideBluetoothAdapter());
    }

    private void initialize(Builder builder) {
        this.clientModule = builder.clientModule;
        this.provideApplicationContextProvider = ClientComponent_ClientModule_ProvideApplicationContextFactory.create(builder.clientModule);
        this.provideContentResolverProvider = ClientComponent_ClientModule_ProvideContentResolverFactory.create(builder.clientModule);
        this.provideLocationManagerProvider = ClientComponent_ClientModule_ProvideLocationManagerFactory.create(builder.clientModule);
        this.checkerLocationProvider = CheckerLocationProvider_Factory.create(this.provideContentResolverProvider, this.provideLocationManagerProvider);
        this.checkerLocationPermissionProvider = CheckerLocationPermission_Factory.create(this.provideApplicationContextProvider);
        this.provideTargetSdkProvider = ClientComponent_ClientModule_ProvideTargetSdkFactory.create(builder.clientModule);
        this.provideIsAndroidWearProvider = ClientComponent_ClientModule_ProvideIsAndroidWearFactory.create(builder.clientModule, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
        this.locationServicesStatusApi23Provider = LocationServicesStatusApi23_Factory.create(this.checkerLocationProvider, this.checkerLocationPermissionProvider, this.provideTargetSdkProvider, this.provideIsAndroidWearProvider);
        this.provideLocationServicesStatusProvider = C2608x9cd4449f.create(builder.clientModule, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), LocationServicesStatusApi18_Factory.create(), this.locationServicesStatusApi23Provider);
        this.locationServicesOkObservableApi23Provider = LocationServicesOkObservableApi23_Factory.create(this.provideApplicationContextProvider, this.provideLocationServicesStatusProvider);
        this.rxBleAdapterWrapperProvider = RxBleAdapterWrapper_Factory.create(ClientComponent_ClientModule_ProvideBluetoothAdapterFactory.create());
        this.provideBluetoothInteractionExecutorServiceProvider = DoubleCheck.provider(C2602xa9312dd2.create());
        this.provideBluetoothInteractionSchedulerProvider = DoubleCheck.provider(C2603xd84c18d9.create(this.provideBluetoothInteractionExecutorServiceProvider));
        this.clientOperationQueueImplProvider = ClientOperationQueueImpl_Factory.create(this.provideBluetoothInteractionSchedulerProvider);
        this.bindClientOperationQueueProvider = DoubleCheck.provider(this.clientOperationQueueImplProvider);
        this.rxBleAdapterStateObservableProvider = RxBleAdapterStateObservable_Factory.create(this.provideApplicationContextProvider);
        this.provideLocationServicesOkObservableProvider = C2607x61f40e72.create(builder.clientModule, ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.locationServicesOkObservableApi23Provider);
        this.clientStateObservableProvider = ClientStateObservable_Factory.create(this.rxBleAdapterWrapperProvider, this.rxBleAdapterStateObservableProvider, this.provideLocationServicesOkObservableProvider, this.provideLocationServicesStatusProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.deviceComponentCacheProvider = DoubleCheck.provider(DeviceComponentCache_Factory.create());
        this.deviceComponentBuilderProvider = new Provider<DeviceComponent.Builder>() {
            public DeviceComponent.Builder get() {
                return new DeviceComponentBuilder();
            }
        };
        this.rxBleDeviceProvider = DoubleCheck.provider(RxBleDeviceProvider_Factory.create(this.deviceComponentCacheProvider, this.deviceComponentBuilderProvider));
        this.internalScanResultCreatorProvider = DoubleCheck.provider(InternalScanResultCreator_Factory.create(UUIDUtil_Factory.create()));
        this.scanSettingsEmulatorProvider = ScanSettingsEmulator_Factory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.scanSetupBuilderImplApi18Provider = ScanSetupBuilderImplApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider);
        this.androidScanObjectsConverterProvider = AndroidScanObjectsConverter_Factory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create());
        this.scanSetupBuilderImplApi21Provider = ScanSetupBuilderImplApi21_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.scanSettingsEmulatorProvider, this.androidScanObjectsConverterProvider);
        this.scanSetupBuilderImplApi23Provider = ScanSetupBuilderImplApi23_Factory.create(this.rxBleAdapterWrapperProvider, this.internalScanResultCreatorProvider, this.androidScanObjectsConverterProvider);
        this.provideScanSetupProvider = DoubleCheck.provider(ClientComponent_ClientModule_ProvideScanSetupProviderFactory.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanSetupBuilderImplApi18Provider, this.scanSetupBuilderImplApi21Provider, this.scanSetupBuilderImplApi23Provider));
        this.scanPreconditionsVerifierApi18Provider = ScanPreconditionsVerifierApi18_Factory.create(this.rxBleAdapterWrapperProvider, this.provideLocationServicesStatusProvider);
        this.scanPreconditionsVerifierApi24Provider = ScanPreconditionsVerifierApi24_Factory.create(this.scanPreconditionsVerifierApi18Provider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        this.provideScanPreconditionVerifierProvider = C2609x8de81979.create(ClientComponent_ClientModule_ProvideDeviceSdkFactory.create(), this.scanPreconditionsVerifierApi18Provider, this.scanPreconditionsVerifierApi24Provider);
        this.internalToExternalScanResultConverterProvider = InternalToExternalScanResultConverter_Factory.create(this.rxBleDeviceProvider);
        this.provideBluetoothCallbacksExecutorServiceProvider = DoubleCheck.provider(C2600x4a2ba98e.create());
        this.provideConnectionQueueExecutorServiceProvider = DoubleCheck.provider(C2604x11ee2f55.create());
        this.provideFinalizationCloseableProvider = ClientComponent_ClientModule_ProvideFinalizationCloseableFactory.create(this.provideBluetoothInteractionExecutorServiceProvider, this.provideBluetoothCallbacksExecutorServiceProvider, this.provideConnectionQueueExecutorServiceProvider);
        this.rxBleClientImplProvider = RxBleClientImpl_Factory.create(this.rxBleAdapterWrapperProvider, this.bindClientOperationQueueProvider, this.rxBleAdapterStateObservableProvider, UUIDUtil_Factory.create(), this.provideLocationServicesStatusProvider, this.clientStateObservableProvider, this.rxBleDeviceProvider, this.provideScanSetupProvider, this.provideScanPreconditionVerifierProvider, this.internalToExternalScanResultConverterProvider, this.provideBluetoothInteractionSchedulerProvider, this.provideFinalizationCloseableProvider);
        this.bindRxBleClientProvider = DoubleCheck.provider(this.rxBleClientImplProvider);
        this.provideBluetoothCallbacksSchedulerProvider = DoubleCheck.provider(C2601x76cd1195.create(this.provideBluetoothCallbacksExecutorServiceProvider));
        this.provideBluetoothManagerProvider = ClientComponent_ClientModule_ProvideBluetoothManagerFactory.create(builder.clientModule);
    }

    public LocationServicesOkObservable locationServicesOkObservable() {
        return LocationServicesOkObservable_Factory.newLocationServicesOkObservable(getNamedObservableOfBoolean());
    }

    public RxBleClient rxBleClient() {
        return this.bindRxBleClientProvider.get();
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public ClientComponent.ClientModule clientModule;

        private Builder() {
        }

        public ClientComponent build() {
            if (this.clientModule != null) {
                return new DaggerClientComponent(this);
            }
            throw new IllegalStateException(ClientComponent.ClientModule.class.getCanonicalName() + " must be set");
        }

        public Builder clientModule(ClientComponent.ClientModule clientModule2) {
            this.clientModule = (ClientComponent.ClientModule) Preconditions.checkNotNull(clientModule2);
            return this;
        }
    }

    private final class DeviceComponentBuilder implements DeviceComponent.Builder {
        /* access modifiers changed from: private */
        public DeviceModule deviceModule;

        private DeviceComponentBuilder() {
        }

        public DeviceComponent build() {
            if (this.deviceModule != null) {
                return new DeviceComponentImpl(this);
            }
            throw new IllegalStateException(DeviceModule.class.getCanonicalName() + " must be set");
        }

        public DeviceComponentBuilder deviceModule(DeviceModule deviceModule2) {
            this.deviceModule = (DeviceModule) Preconditions.checkNotNull(deviceModule2);
            return this;
        }
    }

    private final class DeviceComponentImpl implements DeviceComponent {
        private Provider<ConnectionComponent.Builder> connectionComponentBuilderProvider;
        private ConnectorImpl_Factory connectorImplProvider;
        private DeviceModule deviceModule;
        private DeviceModule_ProvideBluetoothDeviceFactory provideBluetoothDeviceProvider;
        /* access modifiers changed from: private */
        public Provider<ConnectionStateChangeListener> provideConnectionStateChangeListenerProvider;
        private Provider<BehaviorRelay<RxBleConnection.RxBleConnectionState>> provideConnectionStateRelayProvider;
        /* access modifiers changed from: private */
        public DeviceModule_ProvideMacAddressFactory provideMacAddressProvider;
        /* access modifiers changed from: private */
        public DeviceModule_ProvidesDisconnectTimeoutConfFactory providesDisconnectTimeoutConfProvider;
        private Provider rxBleDeviceImplProvider;

        private DeviceComponentImpl(DeviceComponentBuilder deviceComponentBuilder) {
            initialize(deviceComponentBuilder);
        }

        /* access modifiers changed from: private */
        public BluetoothDevice getBluetoothDevice() {
            return DeviceModule_ProvideBluetoothDeviceFactory.proxyProvideBluetoothDevice(this.deviceModule, DaggerClientComponent.this.getRxBleAdapterWrapper());
        }

        /* access modifiers changed from: private */
        public TimeoutConfiguration getNamedTimeoutConfiguration() {
            return DeviceModule_ProvidesConnectTimeoutConfFactory.proxyProvidesConnectTimeoutConf(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.proxyProvideComputationScheduler());
        }

        private void initialize(DeviceComponentBuilder deviceComponentBuilder) {
            this.provideBluetoothDeviceProvider = DeviceModule_ProvideBluetoothDeviceFactory.create(deviceComponentBuilder.deviceModule, DaggerClientComponent.this.rxBleAdapterWrapperProvider);
            this.connectionComponentBuilderProvider = new Provider<ConnectionComponent.Builder>() {
                public ConnectionComponent.Builder get() {
                    return new ConnectionComponentBuilder();
                }
            };
            this.connectorImplProvider = ConnectorImpl_Factory.create(DaggerClientComponent.this.bindClientOperationQueueProvider, this.connectionComponentBuilderProvider, DaggerClientComponent.this.provideBluetoothCallbacksSchedulerProvider);
            this.provideConnectionStateRelayProvider = DoubleCheck.provider(DeviceModule_ProvideConnectionStateRelayFactory.create());
            this.rxBleDeviceImplProvider = DoubleCheck.provider(RxBleDeviceImpl_Factory.create(this.provideBluetoothDeviceProvider, this.connectorImplProvider, this.provideConnectionStateRelayProvider));
            this.deviceModule = deviceComponentBuilder.deviceModule;
            this.provideMacAddressProvider = DeviceModule_ProvideMacAddressFactory.create(deviceComponentBuilder.deviceModule);
            this.provideConnectionStateChangeListenerProvider = DoubleCheck.provider(DeviceModule_ProvideConnectionStateChangeListenerFactory.create(this.provideConnectionStateRelayProvider));
            this.providesDisconnectTimeoutConfProvider = DeviceModule_ProvidesDisconnectTimeoutConfFactory.create(ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
        }

        public RxBleDevice provideDevice() {
            return (RxBleDevice) this.rxBleDeviceImplProvider.get();
        }

        private final class ConnectionComponentBuilder implements ConnectionComponent.Builder {
            /* access modifiers changed from: private */
            public ConnectionModule connectionModule;

            private ConnectionComponentBuilder() {
            }

            public ConnectionComponent build() {
                if (this.connectionModule != null) {
                    return new ConnectionComponentImpl(this);
                }
                throw new IllegalStateException(ConnectionModule.class.getCanonicalName() + " must be set");
            }

            public ConnectionComponentBuilder connectionModule(ConnectionModule connectionModule2) {
                this.connectionModule = (ConnectionModule) Preconditions.checkNotNull(connectionModule2);
                return this;
            }
        }

        private final class ConnectionComponentImpl implements ConnectionComponent {
            private Provider<BluetoothGattProvider> bluetoothGattProvider;
            private Provider<ConnectionOperationQueueImpl> connectionOperationQueueImplProvider;
            private Provider descriptorWriterProvider;
            private Provider disconnectActionProvider;
            private DisconnectOperation_Factory disconnectOperationProvider;
            private Provider disconnectionRouterProvider;
            private IllegalOperationChecker_Factory illegalOperationCheckerProvider;
            private IllegalOperationMessageCreator_Factory illegalOperationMessageCreatorProvider;
            private LoggingIllegalOperationHandler_Factory loggingIllegalOperationHandlerProvider;
            private LongWriteOperationBuilderImpl_Factory longWriteOperationBuilderImplProvider;
            private Provider mtuBasedPayloadSizeLimitProvider;
            private Provider mtuWatcherProvider;
            private Provider notificationAndIndicationManagerProvider;
            private OperationsProviderImpl_Factory operationsProviderImplProvider;
            private Provider<Boolean> provideAutoConnectProvider;
            private Provider<BluetoothGatt> provideBluetoothGattProvider;
            private ConnectionModule_ProvideCharacteristicPropertiesParserFactory provideCharacteristicPropertiesParserProvider;
            private ConnectionModule_ProvideIllegalOperationHandlerFactory provideIllegalOperationHandlerProvider;
            private ConnectionModule_ProvidesOperationTimeoutConfFactory providesOperationTimeoutConfProvider;
            private ReadRssiOperation_Factory readRssiOperationProvider;
            private Provider<RxBleConnectionImpl> rxBleConnectionImplProvider;
            private Provider<RxBleGattCallback> rxBleGattCallbackProvider;
            private RxBleServicesLogger_Factory rxBleServicesLoggerProvider;
            private Provider serviceDiscoveryManagerProvider;
            private ThrowingIllegalOperationHandler_Factory throwingIllegalOperationHandlerProvider;

            private ConnectionComponentImpl(ConnectionComponentBuilder connectionComponentBuilder) {
                initialize(connectionComponentBuilder);
            }

            private BleConnectionCompat getBleConnectionCompat() {
                return new BleConnectionCompat(ClientComponent_ClientModule_ProvideApplicationContextFactory.proxyProvideApplicationContext(DaggerClientComponent.this.clientModule));
            }

            private void initialize(ConnectionComponentBuilder connectionComponentBuilder) {
                this.bluetoothGattProvider = DoubleCheck.provider(BluetoothGattProvider_Factory.create());
                this.disconnectionRouterProvider = DoubleCheck.provider(DisconnectionRouter_Factory.create(DeviceComponentImpl.this.provideMacAddressProvider, DaggerClientComponent.this.rxBleAdapterWrapperProvider, DaggerClientComponent.this.rxBleAdapterStateObservableProvider));
                this.rxBleGattCallbackProvider = DoubleCheck.provider(RxBleGattCallback_Factory.create(DaggerClientComponent.this.provideBluetoothCallbacksSchedulerProvider, this.bluetoothGattProvider, this.disconnectionRouterProvider, NativeCallbackDispatcher_Factory.create()));
                this.provideAutoConnectProvider = DoubleCheck.provider(ConnectionModule_ProvideAutoConnectFactory.create(connectionComponentBuilder.connectionModule));
                this.connectionOperationQueueImplProvider = DoubleCheck.provider(ConnectionOperationQueueImpl_Factory.create(DeviceComponentImpl.this.provideMacAddressProvider, this.disconnectionRouterProvider, DaggerClientComponent.this.provideConnectionQueueExecutorServiceProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider));
                this.provideBluetoothGattProvider = DoubleCheck.provider(ConnectionModuleBinder_ProvideBluetoothGattFactory.create(this.bluetoothGattProvider));
                this.provideCharacteristicPropertiesParserProvider = ConnectionModule_ProvideCharacteristicPropertiesParserFactory.create(connectionComponentBuilder.connectionModule);
                this.rxBleServicesLoggerProvider = RxBleServicesLogger_Factory.create(this.provideCharacteristicPropertiesParserProvider);
                this.providesOperationTimeoutConfProvider = ConnectionModule_ProvidesOperationTimeoutConfFactory.create(connectionComponentBuilder.connectionModule, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create());
                this.readRssiOperationProvider = ReadRssiOperation_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.providesOperationTimeoutConfProvider);
                this.operationsProviderImplProvider = OperationsProviderImpl_Factory.create(this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.rxBleServicesLoggerProvider, this.providesOperationTimeoutConfProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, ClientComponent_ClientModule_ProvideComputationSchedulerFactory.create(), this.readRssiOperationProvider);
                this.serviceDiscoveryManagerProvider = DoubleCheck.provider(ServiceDiscoveryManager_Factory.create(this.connectionOperationQueueImplProvider, this.provideBluetoothGattProvider, this.operationsProviderImplProvider));
                this.descriptorWriterProvider = DoubleCheck.provider(DescriptorWriter_Factory.create(this.connectionOperationQueueImplProvider, this.operationsProviderImplProvider));
                this.notificationAndIndicationManagerProvider = DoubleCheck.provider(NotificationAndIndicationManager_Factory.create(C2606xd399626d.create(), ClientComponent_ClientModule_ProvideEnableIndicationValueFactory.create(), C2605x975cafc6.create(), this.provideBluetoothGattProvider, this.rxBleGattCallbackProvider, this.descriptorWriterProvider));
                this.mtuWatcherProvider = DoubleCheck.provider(MtuWatcher_Factory.create(this.rxBleGattCallbackProvider, ConnectionModuleBinder_MinimumMtuFactory.create()));
                this.rxBleConnectionImplProvider = new DelegateFactory();
                this.mtuBasedPayloadSizeLimitProvider = DoubleCheck.provider(MtuBasedPayloadSizeLimit_Factory.create(this.rxBleConnectionImplProvider, ConnectionModuleBinder_GattWriteMtuOverheadFactory.create()));
                this.longWriteOperationBuilderImplProvider = LongWriteOperationBuilderImpl_Factory.create(this.connectionOperationQueueImplProvider, this.mtuBasedPayloadSizeLimitProvider, this.rxBleConnectionImplProvider, this.operationsProviderImplProvider);
                this.illegalOperationMessageCreatorProvider = IllegalOperationMessageCreator_Factory.create(this.provideCharacteristicPropertiesParserProvider);
                this.loggingIllegalOperationHandlerProvider = LoggingIllegalOperationHandler_Factory.create(this.illegalOperationMessageCreatorProvider);
                this.throwingIllegalOperationHandlerProvider = ThrowingIllegalOperationHandler_Factory.create(this.illegalOperationMessageCreatorProvider);
                this.provideIllegalOperationHandlerProvider = ConnectionModule_ProvideIllegalOperationHandlerFactory.create(connectionComponentBuilder.connectionModule, this.loggingIllegalOperationHandlerProvider, this.throwingIllegalOperationHandlerProvider);
                this.illegalOperationCheckerProvider = IllegalOperationChecker_Factory.create(this.provideIllegalOperationHandlerProvider);
                this.rxBleConnectionImplProvider = DoubleCheck.provider(RxBleConnectionImpl_Factory.create(this.connectionOperationQueueImplProvider, this.rxBleGattCallbackProvider, this.provideBluetoothGattProvider, this.serviceDiscoveryManagerProvider, this.notificationAndIndicationManagerProvider, this.mtuWatcherProvider, this.descriptorWriterProvider, this.operationsProviderImplProvider, this.longWriteOperationBuilderImplProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, this.illegalOperationCheckerProvider));
                ((DelegateFactory) this.rxBleConnectionImplProvider).setDelegatedProvider(this.rxBleConnectionImplProvider);
                this.disconnectOperationProvider = DisconnectOperation_Factory.create(this.rxBleGattCallbackProvider, this.bluetoothGattProvider, DeviceComponentImpl.this.provideMacAddressProvider, DaggerClientComponent.this.provideBluetoothManagerProvider, DaggerClientComponent.this.provideBluetoothInteractionSchedulerProvider, DeviceComponentImpl.this.providesDisconnectTimeoutConfProvider, DeviceComponentImpl.this.provideConnectionStateChangeListenerProvider);
                this.disconnectActionProvider = DoubleCheck.provider(DisconnectAction_Factory.create(DaggerClientComponent.this.bindClientOperationQueueProvider, this.disconnectOperationProvider));
            }

            public ConnectOperation connectOperation() {
                return ConnectOperation_Factory.newConnectOperation(DeviceComponentImpl.this.getBluetoothDevice(), getBleConnectionCompat(), this.rxBleGattCallbackProvider.get(), this.bluetoothGattProvider.get(), DeviceComponentImpl.this.getNamedTimeoutConfiguration(), this.provideAutoConnectProvider.get().booleanValue(), (ConnectionStateChangeListener) DeviceComponentImpl.this.provideConnectionStateChangeListenerProvider.get());
            }

            public RxBleConnection rxBleConnection() {
                return this.rxBleConnectionImplProvider.get();
            }

            public RxBleGattCallback gattCallback() {
                return this.rxBleGattCallbackProvider.get();
            }

            public Set<ConnectionSubscriptionWatcher> connectionSubscriptionWatchers() {
                return SetBuilder.newSetBuilder(3).add((ConnectionSubscriptionWatcher) this.mtuWatcherProvider.get()).add((ConnectionSubscriptionWatcher) this.disconnectActionProvider.get()).add(this.connectionOperationQueueImplProvider.get()).build();
            }
        }
    }
}
