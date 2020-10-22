package com.airbnb.android.react.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;

public class AirMapCircle extends AirMapFeature {
    private LatLng center;
    private Circle circle;
    private CircleOptions circleOptions;
    private int fillColor;
    private double radius;
    private int strokeColor;
    private float strokeWidth;
    private float zIndex;

    public AirMapCircle(Context context) {
        super(context);
    }

    public void setCenter(LatLng latLng) {
        this.center = latLng;
        if (this.circle != null) {
            this.circle.setCenter(this.center);
        }
    }

    public void setRadius(double d) {
        this.radius = d;
        if (this.circle != null) {
            this.circle.setRadius(this.radius);
        }
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        if (this.circle != null) {
            this.circle.setFillColor(i);
        }
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        if (this.circle != null) {
            this.circle.setStrokeColor(i);
        }
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        if (this.circle != null) {
            this.circle.setStrokeWidth(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        if (this.circle != null) {
            this.circle.setZIndex(f);
        }
    }

    public CircleOptions getCircleOptions() {
        if (this.circleOptions == null) {
            this.circleOptions = createCircleOptions();
        }
        return this.circleOptions;
    }

    private CircleOptions createCircleOptions() {
        CircleOptions circleOptions2 = new CircleOptions();
        circleOptions2.center(this.center);
        circleOptions2.radius(this.radius);
        circleOptions2.fillColor(this.fillColor);
        circleOptions2.strokeColor(this.strokeColor);
        circleOptions2.strokeWidth(this.strokeWidth);
        circleOptions2.zIndex(this.zIndex);
        return circleOptions2;
    }

    public Object getFeature() {
        return this.circle;
    }

    public void addToMap(GoogleMap googleMap) {
        this.circle = googleMap.addCircle(getCircleOptions());
    }

    public void removeFromMap(GoogleMap googleMap) {
        this.circle.remove();
    }
}
