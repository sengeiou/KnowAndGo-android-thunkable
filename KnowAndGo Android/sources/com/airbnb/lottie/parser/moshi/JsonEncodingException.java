package com.airbnb.lottie.parser.moshi;

import androidx.annotation.Nullable;
import java.io.IOException;

final class JsonEncodingException extends IOException {
    JsonEncodingException(@Nullable String str) {
        super(str);
    }
}
