package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        public EventMessage createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }

        public EventMessage[] newArray(int i) {
            return new EventMessage[i];
        }
    };
    public final long durationMs;
    private int hashCode;

    /* renamed from: id */
    public final long f140id;
    public final byte[] messageData;
    public final long presentationTimeUs;
    public final String schemeIdUri;
    public final String value;

    public int describeContents() {
        return 0;
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr, long j3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j;
        this.f140id = j2;
        this.messageData = bArr;
        this.presentationTimeUs = j3;
    }

    EventMessage(Parcel parcel) {
        this.schemeIdUri = (String) Util.castNonNull(parcel.readString());
        this.value = (String) Util.castNonNull(parcel.readString());
        this.presentationTimeUs = parcel.readLong();
        this.durationMs = parcel.readLong();
        this.f140id = parcel.readLong();
        this.messageData = (byte[]) Util.castNonNull(parcel.createByteArray());
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int i = 0;
            int hashCode2 = (527 + (this.schemeIdUri != null ? this.schemeIdUri.hashCode() : 0)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            this.hashCode = ((((((((hashCode2 + i) * 31) + ((int) (this.presentationTimeUs ^ (this.presentationTimeUs >>> 32)))) * 31) + ((int) (this.durationMs ^ (this.durationMs >>> 32)))) * 31) + ((int) (this.f140id ^ (this.f140id >>> 32)))) * 31) + Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EventMessage eventMessage = (EventMessage) obj;
        if (this.presentationTimeUs != eventMessage.presentationTimeUs || this.durationMs != eventMessage.durationMs || this.f140id != eventMessage.f140id || !Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) || !Util.areEqual(this.value, eventMessage.value) || !Arrays.equals(this.messageData, eventMessage.messageData)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "EMSG: scheme=" + this.schemeIdUri + ", id=" + this.f140id + ", value=" + this.value;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.presentationTimeUs);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.f140id);
        parcel.writeByteArray(this.messageData);
    }
}
