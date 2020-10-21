package org.apache.commons.p032io.filefilter;

import java.io.File;
import java.io.Serializable;

/* renamed from: org.apache.commons.io.filefilter.FalseFileFilter */
public class FalseFileFilter implements IOFileFilter, Serializable {
    public static final IOFileFilter FALSE = new FalseFileFilter();
    public static final IOFileFilter INSTANCE = FALSE;
    private static final long serialVersionUID = 6210271677940926200L;

    public boolean accept(File file) {
        return false;
    }

    public boolean accept(File file, String str) {
        return false;
    }

    protected FalseFileFilter() {
    }
}
