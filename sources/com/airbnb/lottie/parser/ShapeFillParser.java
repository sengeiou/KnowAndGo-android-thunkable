package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.m19of("nm", "c", NotificationBundleProcessor.PUSH_MINIFIED_BUTTONS_LIST, "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
                    break;
                case 2:
                    animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
                    break;
                case 3:
                    z = jsonReader.nextBoolean();
                    break;
                case 4:
                    i = jsonReader.nextInt();
                    break;
                case 5:
                    z2 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
