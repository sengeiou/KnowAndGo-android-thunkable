package org.apache.commons.p032io.input;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.p032io.input.ObservableInputStream;

/* renamed from: org.apache.commons.io.input.MessageDigestCalculatingInputStream */
public class MessageDigestCalculatingInputStream extends ObservableInputStream {
    private final MessageDigest messageDigest;

    /* renamed from: org.apache.commons.io.input.MessageDigestCalculatingInputStream$MessageDigestMaintainingObserver */
    public static class MessageDigestMaintainingObserver extends ObservableInputStream.Observer {

        /* renamed from: md */
        private final MessageDigest f3027md;

        public MessageDigestMaintainingObserver(MessageDigest messageDigest) {
            this.f3027md = messageDigest;
        }

        /* access modifiers changed from: package-private */
        public void data(int i) throws IOException {
            this.f3027md.update((byte) i);
        }

        /* access modifiers changed from: package-private */
        public void data(byte[] bArr, int i, int i2) throws IOException {
            this.f3027md.update(bArr, i, i2);
        }
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, MessageDigest messageDigest2) {
        super(inputStream);
        this.messageDigest = messageDigest2;
        add(new MessageDigestMaintainingObserver(messageDigest2));
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream, String str) throws NoSuchAlgorithmException {
        this(inputStream, MessageDigest.getInstance(str));
    }

    public MessageDigestCalculatingInputStream(InputStream inputStream) throws NoSuchAlgorithmException {
        this(inputStream, MessageDigest.getInstance(MessageDigestAlgorithms.MD5));
    }

    public MessageDigest getMessageDigest() {
        return this.messageDigest;
    }
}
