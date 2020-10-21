package com.android.billingclient.api;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import com.android.billingclient.api.Purchase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class BillingClient {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BillingResponseCode {
        public static final int BILLING_UNAVAILABLE = 3;
        public static final int DEVELOPER_ERROR = 5;
        public static final int ERROR = 6;
        public static final int FEATURE_NOT_SUPPORTED = -2;
        public static final int ITEM_ALREADY_OWNED = 7;
        public static final int ITEM_NOT_OWNED = 8;
        public static final int ITEM_UNAVAILABLE = 4;

        /* renamed from: OK */
        public static final int f53OK = 0;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_TIMEOUT = -3;
        public static final int SERVICE_UNAVAILABLE = 2;
        public static final int USER_CANCELED = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ChildDirected {
        public static final int CHILD_DIRECTED = 1;
        public static final int NOT_CHILD_DIRECTED = 2;
        public static final int UNSPECIFIED = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeatureType {
        public static final String IN_APP_ITEMS_ON_VR = "inAppItemsOnVr";
        public static final String PRICE_CHANGE_CONFIRMATION = "priceChangeConfirmation";
        public static final String SUBSCRIPTIONS = "subscriptions";
        public static final String SUBSCRIPTIONS_ON_VR = "subscriptionsOnVr";
        public static final String SUBSCRIPTIONS_UPDATE = "subscriptionsUpdate";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SkuType {
        public static final String INAPP = "inapp";
        public static final String SUBS = "subs";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface UnderAgeOfConsent {
        public static final int NOT_UNDER_AGE_OF_CONSENT = 2;
        public static final int UNDER_AGE_OF_CONSENT = 1;
        public static final int UNSPECIFIED = 0;
    }

    public abstract void acknowledgePurchase(AcknowledgePurchaseParams acknowledgePurchaseParams, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener);

    public abstract void consumeAsync(ConsumeParams consumeParams, @NonNull ConsumeResponseListener consumeResponseListener);

    @UiThread
    public abstract void endConnection();

    @UiThread
    public abstract BillingResult isFeatureSupported(String str);

    @UiThread
    public abstract boolean isReady();

    @UiThread
    public abstract BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams);

    @UiThread
    public abstract void launchPriceChangeConfirmationFlow(Activity activity, PriceChangeFlowParams priceChangeFlowParams, @NonNull PriceChangeConfirmationListener priceChangeConfirmationListener);

    public abstract void loadRewardedSku(RewardLoadParams rewardLoadParams, @NonNull RewardResponseListener rewardResponseListener);

    public abstract void queryPurchaseHistoryAsync(String str, @NonNull PurchaseHistoryResponseListener purchaseHistoryResponseListener);

    public abstract Purchase.PurchasesResult queryPurchases(String str);

    public abstract void querySkuDetailsAsync(SkuDetailsParams skuDetailsParams, @NonNull SkuDetailsResponseListener skuDetailsResponseListener);

    @UiThread
    public abstract void startConnection(@NonNull BillingClientStateListener billingClientStateListener);

    public static final class Builder {
        private int mChildDirected;
        private final Context mContext;
        private boolean mEnablePendingPurchases;
        private PurchasesUpdatedListener mListener;
        private int mUnderAgeOfConsent;

        private Builder(Context context) {
            this.mChildDirected = 0;
            this.mUnderAgeOfConsent = 0;
            this.mContext = context;
        }

        @UiThread
        public Builder setListener(PurchasesUpdatedListener purchasesUpdatedListener) {
            this.mListener = purchasesUpdatedListener;
            return this;
        }

        @UiThread
        public Builder setChildDirected(int i) {
            this.mChildDirected = i;
            return this;
        }

        @UiThread
        public Builder setUnderAgeOfConsent(int i) {
            this.mUnderAgeOfConsent = i;
            return this;
        }

        @UiThread
        public Builder enablePendingPurchases() {
            this.mEnablePendingPurchases = true;
            return this;
        }

        @UiThread
        public BillingClient build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else if (this.mListener == null) {
                throw new IllegalArgumentException("Please provide a valid listener for purchases updates.");
            } else if (this.mEnablePendingPurchases) {
                return new BillingClientImpl(this.mContext, this.mChildDirected, this.mUnderAgeOfConsent, this.mEnablePendingPurchases, this.mListener);
            } else {
                throw new IllegalArgumentException("Support for pending purchases must be enabled. Enable this by calling 'enablePendingPurchases()' on BillingClientBuilder.");
            }
        }
    }

    @UiThread
    public static Builder newBuilder(@NonNull Context context) {
        return new Builder(context);
    }
}
