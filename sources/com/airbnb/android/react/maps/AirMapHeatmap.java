package com.airbnb.android.react.maps;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;
import java.util.Arrays;
import java.util.List;

public class AirMapHeatmap extends AirMapFeature {
    private Gradient gradient;
    private TileOverlay heatmap;
    private TileOverlayOptions heatmapOptions;
    private HeatmapTileProvider heatmapTileProvider;
    private Double opacity;
    private List<WeightedLatLng> points;
    private Integer radius;

    public AirMapHeatmap(Context context) {
        super(context);
    }

    public void setPoints(WeightedLatLng[] weightedLatLngArr) {
        this.points = Arrays.asList(weightedLatLngArr);
        if (this.heatmapTileProvider != null) {
            this.heatmapTileProvider.setWeightedData(this.points);
        }
        if (this.heatmap != null) {
            this.heatmap.clearTileCache();
        }
    }

    public void setGradient(Gradient gradient2) {
        this.gradient = gradient2;
        if (this.heatmapTileProvider != null) {
            this.heatmapTileProvider.setGradient(gradient2);
        }
        if (this.heatmap != null) {
            this.heatmap.clearTileCache();
        }
    }

    public void setOpacity(double d) {
        this.opacity = new Double(d);
        if (this.heatmapTileProvider != null) {
            this.heatmapTileProvider.setOpacity(d);
        }
        if (this.heatmap != null) {
            this.heatmap.clearTileCache();
        }
    }

    public void setRadius(int i) {
        this.radius = new Integer(i);
        if (this.heatmapTileProvider != null) {
            this.heatmapTileProvider.setRadius(i);
        }
        if (this.heatmap != null) {
            this.heatmap.clearTileCache();
        }
    }

    public TileOverlayOptions getHeatmapOptions() {
        if (this.heatmapOptions == null) {
            this.heatmapOptions = createHeatmapOptions();
        }
        return this.heatmapOptions;
    }

    private TileOverlayOptions createHeatmapOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        if (this.heatmapTileProvider == null) {
            HeatmapTileProvider.Builder weightedData = new HeatmapTileProvider.Builder().weightedData(this.points);
            if (this.radius != null) {
                weightedData.radius(this.radius.intValue());
            }
            if (this.opacity != null) {
                weightedData.opacity(this.opacity.doubleValue());
            }
            if (this.gradient != null) {
                weightedData.gradient(this.gradient);
            }
            this.heatmapTileProvider = weightedData.build();
        }
        tileOverlayOptions.tileProvider(this.heatmapTileProvider);
        return tileOverlayOptions;
    }

    public Object getFeature() {
        return this.heatmap;
    }

    public void addToMap(GoogleMap googleMap) {
        Log.d("AirMapHeatmap", "ADD TO MAP");
        this.heatmap = googleMap.addTileOverlay(getHeatmapOptions());
    }

    public void removeFromMap(GoogleMap googleMap) {
        this.heatmap.remove();
    }
}
