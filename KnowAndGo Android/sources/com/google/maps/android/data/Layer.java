package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.geojson.GeoJsonRenderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlRenderer;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

public abstract class Layer {
    private Renderer mRenderer;

    public interface OnFeatureClickListener {
        void onFeatureClick(Feature feature);
    }

    /* access modifiers changed from: protected */
    public void addKMLToMap() throws IOException, XmlPullParserException {
        if (this.mRenderer instanceof KmlRenderer) {
            ((KmlRenderer) this.mRenderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    /* access modifiers changed from: protected */
    public void addGeoJsonToMap() {
        if (this.mRenderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) this.mRenderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a GeoJsonRenderer");
    }

    public void removeLayerFromMap() {
        if (this.mRenderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) this.mRenderer).removeLayerFromMap();
        } else if (this.mRenderer instanceof KmlRenderer) {
            ((KmlRenderer) this.mRenderer).removeLayerFromMap();
        }
    }

    public void setOnFeatureClickListener(final OnFeatureClickListener onFeatureClickListener) {
        GoogleMap map = getMap();
        map.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
            public void onPolygonClick(Polygon polygon) {
                if (Layer.this.getFeature(polygon) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(polygon));
                } else if (Layer.this.getContainerFeature(polygon) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getContainerFeature(polygon));
                } else {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(Layer.this.multiObjectHandler(polygon)));
                }
            }
        });
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            public boolean onMarkerClick(Marker marker) {
                if (Layer.this.getFeature(marker) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(marker));
                    return false;
                } else if (Layer.this.getContainerFeature(marker) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getContainerFeature(marker));
                    return false;
                } else {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(Layer.this.multiObjectHandler(marker)));
                    return false;
                }
            }
        });
        map.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
            public void onPolylineClick(Polyline polyline) {
                if (Layer.this.getFeature(polyline) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(polyline));
                } else if (Layer.this.getContainerFeature(polyline) != null) {
                    onFeatureClickListener.onFeatureClick(Layer.this.getContainerFeature(polyline));
                } else {
                    onFeatureClickListener.onFeatureClick(Layer.this.getFeature(Layer.this.multiObjectHandler(polyline)));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public ArrayList<?> multiObjectHandler(Object obj) {
        for (Object next : this.mRenderer.getValues()) {
            if (next.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<?> arrayList = (ArrayList) next;
                if (arrayList.contains(obj)) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void storeRenderer(Renderer renderer) {
        this.mRenderer = renderer;
    }

    public Iterable<? extends Feature> getFeatures() {
        return this.mRenderer.getFeatures();
    }

    public Feature getFeature(Object obj) {
        return this.mRenderer.getFeature(obj);
    }

    public Feature getContainerFeature(Object obj) {
        return this.mRenderer.getContainerFeature(obj);
    }

    /* access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mRenderer.hasFeatures();
    }

    /* access modifiers changed from: protected */
    public boolean hasContainers() {
        if (this.mRenderer instanceof KmlRenderer) {
            return ((KmlRenderer) this.mRenderer).hasNestedContainers();
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Iterable<KmlContainer> getContainers() {
        if (this.mRenderer instanceof KmlRenderer) {
            return ((KmlRenderer) this.mRenderer).getNestedContainers();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        if (this.mRenderer instanceof KmlRenderer) {
            return ((KmlRenderer) this.mRenderer).getGroundOverlays();
        }
        return null;
    }

    public GoogleMap getMap() {
        return this.mRenderer.getMap();
    }

    public void setMap(GoogleMap googleMap) {
        this.mRenderer.setMap(googleMap);
    }

    public boolean isLayerOnMap() {
        return this.mRenderer.isLayerOnMap();
    }

    /* access modifiers changed from: protected */
    public void addFeature(Feature feature) {
        this.mRenderer.addFeature(feature);
    }

    /* access modifiers changed from: protected */
    public void removeFeature(Feature feature) {
        this.mRenderer.removeFeature(feature);
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mRenderer.getDefaultPointStyle();
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mRenderer.getDefaultLineStringStyle();
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mRenderer.getDefaultPolygonStyle();
    }
}
