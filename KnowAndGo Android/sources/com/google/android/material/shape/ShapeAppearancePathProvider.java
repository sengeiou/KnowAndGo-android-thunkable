package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class ShapeAppearancePathProvider {
    private final ShapePath[] cornerPaths = new ShapePath[4];
    private final Matrix[] cornerTransforms = new Matrix[4];
    private final Matrix[] edgeTransforms = new Matrix[4];
    private final PointF pointF = new PointF();
    private final float[] scratch = new float[2];
    private final float[] scratch2 = new float[2];
    private final ShapePath shapePath = new ShapePath();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface PathListener {
        void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i);

        void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i);
    }

    private float angleOfEdge(int i) {
        return (float) ((i + 1) * 90);
    }

    public ShapeAppearancePathProvider() {
        for (int i = 0; i < 4; i++) {
            this.cornerPaths[i] = new ShapePath();
            this.cornerTransforms[i] = new Matrix();
            this.edgeTransforms[i] = new Matrix();
        }
    }

    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, @NonNull Path path) {
        calculatePath(shapeAppearanceModel, f, rectF, (PathListener) null, path);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void calculatePath(ShapeAppearanceModel shapeAppearanceModel, float f, RectF rectF, PathListener pathListener, @NonNull Path path) {
        path.rewind();
        ShapeAppearancePathSpec shapeAppearancePathSpec = new ShapeAppearancePathSpec(shapeAppearanceModel, f, rectF, pathListener, path);
        for (int i = 0; i < 4; i++) {
            setCornerPathAndTransform(shapeAppearancePathSpec, i);
            setEdgePathAndTransform(i);
        }
        for (int i2 = 0; i2 < 4; i2++) {
            appendCornerPath(shapeAppearancePathSpec, i2);
            appendEdgePath(shapeAppearancePathSpec, i2);
        }
        path.close();
    }

    private void setCornerPathAndTransform(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        getCornerTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getCornerPath(this.cornerPaths[i], 90.0f, shapeAppearancePathSpec.interpolation, shapeAppearancePathSpec.bounds, getCornerSizeForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel));
        float angleOfEdge = angleOfEdge(i);
        this.cornerTransforms[i].reset();
        getCoordinatesOfCorner(i, shapeAppearancePathSpec.bounds, this.pointF);
        this.cornerTransforms[i].setTranslate(this.pointF.x, this.pointF.y);
        this.cornerTransforms[i].preRotate(angleOfEdge);
    }

    private void setEdgePathAndTransform(int i) {
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        float angleOfEdge = angleOfEdge(i);
        this.edgeTransforms[i].reset();
        this.edgeTransforms[i].setTranslate(this.scratch[0], this.scratch[1]);
        this.edgeTransforms[i].preRotate(angleOfEdge);
    }

    private void appendCornerPath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        this.scratch[0] = this.cornerPaths[i].getStartX();
        this.scratch[1] = this.cornerPaths[i].getStartY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 0) {
            shapeAppearancePathSpec.path.moveTo(this.scratch[0], this.scratch[1]);
        } else {
            shapeAppearancePathSpec.path.lineTo(this.scratch[0], this.scratch[1]);
        }
        this.cornerPaths[i].applyToPath(this.cornerTransforms[i], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onCornerPathCreated(this.cornerPaths[i], this.cornerTransforms[i], i);
        }
    }

    private void appendEdgePath(@NonNull ShapeAppearancePathSpec shapeAppearancePathSpec, int i) {
        int i2 = (i + 1) % 4;
        this.scratch[0] = this.cornerPaths[i].getEndX();
        this.scratch[1] = this.cornerPaths[i].getEndY();
        this.cornerTransforms[i].mapPoints(this.scratch);
        this.scratch2[0] = this.cornerPaths[i2].getStartX();
        this.scratch2[1] = this.cornerPaths[i2].getStartY();
        this.cornerTransforms[i2].mapPoints(this.scratch2);
        float max = Math.max(((float) Math.hypot((double) (this.scratch[0] - this.scratch2[0]), (double) (this.scratch[1] - this.scratch2[1]))) - 0.001f, 0.0f);
        float edgeCenterForIndex = getEdgeCenterForIndex(shapeAppearancePathSpec.bounds, i);
        this.shapePath.reset(0.0f, 0.0f);
        getEdgeTreatmentForIndex(i, shapeAppearancePathSpec.shapeAppearanceModel).getEdgePath(max, edgeCenterForIndex, shapeAppearancePathSpec.interpolation, this.shapePath);
        this.shapePath.applyToPath(this.edgeTransforms[i], shapeAppearancePathSpec.path);
        if (shapeAppearancePathSpec.pathListener != null) {
            shapeAppearancePathSpec.pathListener.onEdgePathCreated(this.shapePath, this.edgeTransforms[i], i);
        }
    }

    private float getEdgeCenterForIndex(@NonNull RectF rectF, int i) {
        this.scratch[0] = this.cornerPaths[i].endX;
        this.scratch[1] = this.cornerPaths[i].endY;
        this.cornerTransforms[i].mapPoints(this.scratch);
        if (i == 1 || i == 3) {
            return Math.abs(rectF.centerX() - this.scratch[0]);
        }
        return Math.abs(rectF.centerY() - this.scratch[1]);
    }

    private CornerTreatment getCornerTreatmentForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        switch (i) {
            case 1:
                return shapeAppearanceModel.getBottomRightCorner();
            case 2:
                return shapeAppearanceModel.getBottomLeftCorner();
            case 3:
                return shapeAppearanceModel.getTopLeftCorner();
            default:
                return shapeAppearanceModel.getTopRightCorner();
        }
    }

    private CornerSize getCornerSizeForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        switch (i) {
            case 1:
                return shapeAppearanceModel.getBottomRightCornerSize();
            case 2:
                return shapeAppearanceModel.getBottomLeftCornerSize();
            case 3:
                return shapeAppearanceModel.getTopLeftCornerSize();
            default:
                return shapeAppearanceModel.getTopRightCornerSize();
        }
    }

    private EdgeTreatment getEdgeTreatmentForIndex(int i, @NonNull ShapeAppearanceModel shapeAppearanceModel) {
        switch (i) {
            case 1:
                return shapeAppearanceModel.getBottomEdge();
            case 2:
                return shapeAppearanceModel.getLeftEdge();
            case 3:
                return shapeAppearanceModel.getTopEdge();
            default:
                return shapeAppearanceModel.getRightEdge();
        }
    }

    private void getCoordinatesOfCorner(int i, @NonNull RectF rectF, @NonNull PointF pointF2) {
        switch (i) {
            case 1:
                pointF2.set(rectF.right, rectF.bottom);
                return;
            case 2:
                pointF2.set(rectF.left, rectF.bottom);
                return;
            case 3:
                pointF2.set(rectF.left, rectF.top);
                return;
            default:
                pointF2.set(rectF.right, rectF.top);
                return;
        }
    }

    static final class ShapeAppearancePathSpec {
        @NonNull
        public final RectF bounds;
        public final float interpolation;
        @NonNull
        public final Path path;
        @Nullable
        public final PathListener pathListener;
        @NonNull
        public final ShapeAppearanceModel shapeAppearanceModel;

        ShapeAppearancePathSpec(@NonNull ShapeAppearanceModel shapeAppearanceModel2, float f, RectF rectF, @Nullable PathListener pathListener2, Path path2) {
            this.pathListener = pathListener2;
            this.shapeAppearanceModel = shapeAppearanceModel2;
            this.interpolation = f;
            this.bounds = rectF;
            this.path = path2;
        }
    }
}