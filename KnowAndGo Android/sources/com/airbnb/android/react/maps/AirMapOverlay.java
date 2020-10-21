package com.airbnb.android.react.maps;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.react.bridge.ReadableArray;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class AirMapOverlay extends AirMapFeature implements ImageReadable {
    private LatLngBounds bounds;
    private GroundOverlay groundOverlay;
    private GroundOverlayOptions groundOverlayOptions;
    private Bitmap iconBitmap;
    private BitmapDescriptor iconBitmapDescriptor;
    private final ImageReader mImageReader;
    private GoogleMap map;
    private boolean tappable;
    private float transparency;
    private float zIndex;

    public AirMapOverlay(Context context) {
        super(context);
        this.mImageReader = new ImageReader(context, getResources(), this);
    }

    public void setBounds(ReadableArray readableArray) {
        this.bounds = new LatLngBounds(new LatLng(readableArray.getArray(1).getDouble(0), readableArray.getArray(0).getDouble(1)), new LatLng(readableArray.getArray(0).getDouble(0), readableArray.getArray(1).getDouble(1)));
        if (this.groundOverlay != null) {
            this.groundOverlay.setPositionFromBounds(this.bounds);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.groundOverlay != null) {
            this.groundOverlay.setZIndex(f);
        }
    }

    public void setImage(String str) {
        this.mImageReader.setImage(str);
    }

    public void setTappable(boolean z) {
        this.tappable = z;
        if (this.groundOverlay != null) {
            this.groundOverlay.setClickable(this.tappable);
        }
    }

    public GroundOverlayOptions getGroundOverlayOptions() {
        if (this.groundOverlayOptions == null) {
            this.groundOverlayOptions = createGroundOverlayOptions();
        }
        return this.groundOverlayOptions;
    }

    private GroundOverlayOptions createGroundOverlayOptions() {
        if (this.groundOverlayOptions != null) {
            return this.groundOverlayOptions;
        }
        GroundOverlayOptions groundOverlayOptions2 = new GroundOverlayOptions();
        if (this.iconBitmapDescriptor != null) {
            groundOverlayOptions2.image(this.iconBitmapDescriptor);
        } else {
            groundOverlayOptions2.image(BitmapDescriptorFactory.defaultMarker());
            groundOverlayOptions2.visible(false);
        }
        groundOverlayOptions2.positionFromBounds(this.bounds);
        groundOverlayOptions2.zIndex(this.zIndex);
        return groundOverlayOptions2;
    }

    public Object getFeature() {
        return this.groundOverlay;
    }

    public void addToMap(GoogleMap googleMap) {
        GroundOverlayOptions groundOverlayOptions2 = getGroundOverlayOptions();
        if (groundOverlayOptions2 != null) {
            this.groundOverlay = googleMap.addGroundOverlay(groundOverlayOptions2);
            this.groundOverlay.setClickable(this.tappable);
            return;
        }
        this.map = googleMap;
    }

    public void removeFromMap(GoogleMap googleMap) {
        this.map = null;
        if (this.groundOverlay != null) {
            this.groundOverlay.remove();
            this.groundOverlay = null;
            this.groundOverlayOptions = null;
        }
    }

    public void setIconBitmap(Bitmap bitmap) {
        this.iconBitmap = bitmap;
    }

    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.iconBitmapDescriptor = bitmapDescriptor;
    }

    public void update() {
        this.groundOverlay = getGroundOverlay();
        if (this.groundOverlay != null) {
            this.groundOverlay.setVisible(true);
            this.groundOverlay.setImage(this.iconBitmapDescriptor);
            this.groundOverlay.setClickable(this.tappable);
        }
    }

    private GroundOverlay getGroundOverlay() {
        GroundOverlayOptions groundOverlayOptions2;
        if (this.groundOverlay != null) {
            return this.groundOverlay;
        }
        if (this.map == null || (groundOverlayOptions2 = getGroundOverlayOptions()) == null) {
            return null;
        }
        return this.map.addGroundOverlay(groundOverlayOptions2);
    }
}
