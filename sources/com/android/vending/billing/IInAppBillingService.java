package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface IInAppBillingService extends IInterface {
    Bundle acknowledgePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int consumePurchase(int i, String str, String str2) throws RemoteException;

    Bundle consumePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException;

    Bundle getPurchasesExtraParams(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle getSkuDetailsExtraParams(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException;

    Bundle getSubscriptionManagementIntent(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int isBillingSupported(int i, String str, String str2) throws RemoteException;

    int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int stub(int i, String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements IInAppBillingService {
        private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
        static final int TRANSACTION_acknowledgePurchaseExtraParams = 902;
        static final int TRANSACTION_consumePurchase = 5;
        static final int TRANSACTION_consumePurchaseExtraParams = 12;
        static final int TRANSACTION_getBuyIntent = 3;
        static final int TRANSACTION_getBuyIntentExtraParams = 8;
        static final int TRANSACTION_getBuyIntentToReplaceSkus = 7;
        static final int TRANSACTION_getPurchaseHistory = 9;
        static final int TRANSACTION_getPurchases = 4;
        static final int TRANSACTION_getPurchasesExtraParams = 11;
        static final int TRANSACTION_getSkuDetails = 2;
        static final int TRANSACTION_getSkuDetailsExtraParams = 901;
        static final int TRANSACTION_getSubscriptionManagementIntent = 801;
        static final int TRANSACTION_isBillingSupported = 1;
        static final int TRANSACTION_isBillingSupportedExtraParams = 10;
        static final int TRANSACTION_stub = 6;

        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppBillingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface == null || !(queryLocalInterface instanceof IInAppBillingService)) {
                return new Proxy(iBinder);
            }
            return (IInAppBillingService) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: android.os.Bundle} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r14, android.os.Parcel r15, android.os.Parcel r16, int r17) throws android.os.RemoteException {
            /*
                r13 = this;
                r7 = r13
                r0 = r14
                r1 = r15
                r8 = r16
                java.lang.String r2 = "com.android.vending.billing.IInAppBillingService"
                r3 = 801(0x321, float:1.122E-42)
                r4 = 0
                r9 = 0
                r10 = 1
                if (r0 == r3) goto L_0x02c7
                r3 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r0 == r3) goto L_0x02c3
                switch(r0) {
                    case 1: goto L_0x02a9;
                    case 2: goto L_0x0277;
                    case 3: goto L_0x0246;
                    case 4: goto L_0x021f;
                    case 5: goto L_0x0205;
                    case 6: goto L_0x01eb;
                    case 7: goto L_0x01b5;
                    case 8: goto L_0x0172;
                    case 9: goto L_0x0134;
                    case 10: goto L_0x010b;
                    case 11: goto L_0x00cd;
                    case 12: goto L_0x009b;
                    default: goto L_0x0016;
                }
            L_0x0016:
                switch(r0) {
                    case 901: goto L_0x0050;
                    case 902: goto L_0x001e;
                    default: goto L_0x0019;
                }
            L_0x0019:
                boolean r0 = super.onTransact(r14, r15, r16, r17)
                return r0
            L_0x001e:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x003c
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r4.createFromParcel(r15)
                r4 = r1
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x003c:
                android.os.Bundle r0 = r13.acknowledgePurchaseExtraParams(r0, r2, r3, r4)
                r16.writeNoException()
                if (r0 == 0) goto L_0x004c
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x004f
            L_0x004c:
                r8.writeInt(r9)
            L_0x004f:
                return r10
            L_0x0050:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r5 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x006f
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r6 = r0
                goto L_0x0070
            L_0x006f:
                r6 = r4
            L_0x0070:
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x0080
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x0081
            L_0x0080:
                r11 = r4
            L_0x0081:
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.getSkuDetailsExtraParams(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0097
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x009a
            L_0x0097:
                r8.writeInt(r9)
            L_0x009a:
                return r10
            L_0x009b:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x00b9
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r4.createFromParcel(r15)
                r4 = r1
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x00b9:
                android.os.Bundle r0 = r13.consumePurchaseExtraParams(r0, r2, r3, r4)
                r16.writeNoException()
                if (r0 == 0) goto L_0x00c9
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x00cc
            L_0x00c9:
                r8.writeInt(r9)
            L_0x00cc:
                return r10
            L_0x00cd:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x00f0
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x00f1
            L_0x00f0:
                r11 = r4
            L_0x00f1:
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.getPurchasesExtraParams(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0107
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x010a
            L_0x0107:
                r8.writeInt(r9)
            L_0x010a:
                return r10
            L_0x010b:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x0129
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r4.createFromParcel(r15)
                r4 = r1
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x0129:
                int r0 = r13.isBillingSupportedExtraParams(r0, r2, r3, r4)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x0134:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x0157
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x0158
            L_0x0157:
                r11 = r4
            L_0x0158:
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.getPurchaseHistory(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x016e
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0171
            L_0x016e:
                r8.writeInt(r9)
            L_0x0171:
                return r10
            L_0x0172:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                java.lang.String r11 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x0199
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r12 = r0
                goto L_0x019a
            L_0x0199:
                r12 = r4
            L_0x019a:
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r5
                r4 = r6
                r5 = r11
                r6 = r12
                android.os.Bundle r0 = r0.getBuyIntentExtraParams(r1, r2, r3, r4, r5, r6)
                r16.writeNoException()
                if (r0 == 0) goto L_0x01b1
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x01b4
            L_0x01b1:
                r8.writeInt(r9)
            L_0x01b4:
                return r10
            L_0x01b5:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.util.ArrayList r4 = r15.createStringArrayList()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                java.lang.String r11 = r15.readString()
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                r6 = r11
                android.os.Bundle r0 = r0.getBuyIntentToReplaceSkus(r1, r2, r3, r4, r5, r6)
                r16.writeNoException()
                if (r0 == 0) goto L_0x01e7
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x01ea
            L_0x01e7:
                r8.writeInt(r9)
            L_0x01ea:
                return r10
            L_0x01eb:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.stub(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x0205:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.consumePurchase(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x021f:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                java.lang.String r1 = r15.readString()
                android.os.Bundle r0 = r13.getPurchases(r0, r2, r3, r1)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0242
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0245
            L_0x0242:
                r8.writeInt(r9)
            L_0x0245:
                return r10
            L_0x0246:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r4 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r4
                r4 = r5
                r5 = r6
                android.os.Bundle r0 = r0.getBuyIntent(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0273
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0276
            L_0x0273:
                r8.writeInt(r9)
            L_0x0276:
                return r10
            L_0x0277:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r3 = r15.readString()
                int r5 = r15.readInt()
                if (r5 == 0) goto L_0x0295
                android.os.Parcelable$Creator r4 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r4.createFromParcel(r15)
                r4 = r1
                android.os.Bundle r4 = (android.os.Bundle) r4
            L_0x0295:
                android.os.Bundle r0 = r13.getSkuDetails(r0, r2, r3, r4)
                r16.writeNoException()
                if (r0 == 0) goto L_0x02a5
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x02a8
            L_0x02a5:
                r8.writeInt(r9)
            L_0x02a8:
                return r10
            L_0x02a9:
                r15.enforceInterface(r2)
                int r0 = r15.readInt()
                java.lang.String r2 = r15.readString()
                java.lang.String r1 = r15.readString()
                int r0 = r13.isBillingSupported(r0, r2, r1)
                r16.writeNoException()
                r8.writeInt(r0)
                return r10
            L_0x02c3:
                r8.writeString(r2)
                return r10
            L_0x02c7:
                r15.enforceInterface(r2)
                int r2 = r15.readInt()
                java.lang.String r3 = r15.readString()
                java.lang.String r5 = r15.readString()
                java.lang.String r6 = r15.readString()
                int r0 = r15.readInt()
                if (r0 == 0) goto L_0x02ea
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r15)
                android.os.Bundle r0 = (android.os.Bundle) r0
                r11 = r0
                goto L_0x02eb
            L_0x02ea:
                r11 = r4
            L_0x02eb:
                r0 = r13
                r1 = r2
                r2 = r3
                r3 = r5
                r4 = r6
                r5 = r11
                android.os.Bundle r0 = r0.getSubscriptionManagementIntent(r1, r2, r3, r4, r5)
                r16.writeNoException()
                if (r0 == 0) goto L_0x0301
                r8.writeInt(r10)
                r0.writeToParcel(r8, r10)
                goto L_0x0304
            L_0x0301:
                r8.writeInt(r9)
            L_0x0304:
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.vending.billing.IInAppBillingService.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }

        private static class Proxy implements IInAppBillingService {
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            public IBinder asBinder() {
                return this.mRemote;
            }

            public int isBillingSupported(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int consumePurchase(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int stub(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSubscriptionManagementIntent(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_getSubscriptionManagementIntent, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getPurchasesExtraParams(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle consumePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getSkuDetailsExtraParams(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_getSkuDetailsExtraParams, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle acknowledgePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(Stub.TRANSACTION_acknowledgePurchaseExtraParams, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
