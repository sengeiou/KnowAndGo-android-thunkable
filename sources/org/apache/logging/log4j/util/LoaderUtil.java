package org.apache.logging.log4j.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Enumeration;
import java.util.LinkedHashSet;

public final class LoaderUtil {
    private static final boolean GET_CLASS_LOADER_DISABLED;
    public static final String IGNORE_TCCL_PROPERTY = "log4j.ignoreTCL";
    private static final SecurityManager SECURITY_MANAGER = System.getSecurityManager();
    private static final PrivilegedAction<ClassLoader> TCCL_GETTER = new ThreadContextClassLoaderGetter();
    private static Boolean ignoreTCCL;

    private LoaderUtil() {
    }

    static {
        boolean z = false;
        if (SECURITY_MANAGER != null) {
            try {
                SECURITY_MANAGER.checkPermission(new RuntimePermission("getClassLoader"));
            } catch (SecurityException unused) {
                z = true;
            }
            GET_CLASS_LOADER_DISABLED = z;
            return;
        }
        GET_CLASS_LOADER_DISABLED = false;
    }

    public static ClassLoader getThreadContextClassLoader() {
        if (GET_CLASS_LOADER_DISABLED) {
            return LoaderUtil.class.getClassLoader();
        }
        return (ClassLoader) (SECURITY_MANAGER == null ? TCCL_GETTER.run() : AccessController.doPrivileged(TCCL_GETTER));
    }

    private static class ThreadContextClassLoaderGetter implements PrivilegedAction<ClassLoader> {
        private ThreadContextClassLoaderGetter() {
        }

        public ClassLoader run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return contextClassLoader;
            }
            ClassLoader classLoader = LoaderUtil.class.getClassLoader();
            return classLoader == null ? ClassLoader.getSystemClassLoader() : classLoader;
        }
    }

    public static Class<?> loadClass(String str) throws ClassNotFoundException {
        if (isIgnoreTccl()) {
            return Class.forName(str);
        }
        try {
            return getThreadContextClassLoader().loadClass(str);
        } catch (Throwable unused) {
            return Class.forName(str);
        }
    }

    public static Object newInstanceOf(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> loadClass = loadClass(str);
        try {
            return loadClass.getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException unused) {
            return loadClass.newInstance();
        }
    }

    public static <T> T newCheckedInstanceOf(String str, Class<T> cls) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        return cls.cast(newInstanceOf(str));
    }

    private static boolean isIgnoreTccl() {
        if (ignoreTCCL == null) {
            String stringProperty = PropertiesUtil.getProperties().getStringProperty(IGNORE_TCCL_PROPERTY, (String) null);
            ignoreTCCL = Boolean.valueOf(stringProperty != null && !"false".equalsIgnoreCase(stringProperty.trim()));
        }
        return ignoreTCCL.booleanValue();
    }

    public static Collection<URL> findResources(String str) {
        Collection<UrlResource> findUrlResources = findUrlResources(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet(findUrlResources.size());
        for (UrlResource url : findUrlResources) {
            linkedHashSet.add(url.getUrl());
        }
        return linkedHashSet;
    }

    static Collection<UrlResource> findUrlResources(String str) {
        ClassLoader[] classLoaderArr = {getThreadContextClassLoader(), LoaderUtil.class.getClassLoader(), ClassLoader.getSystemClassLoader()};
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (ClassLoader classLoader : classLoaderArr) {
            if (classLoader != null) {
                try {
                    Enumeration<URL> resources = classLoader.getResources(str);
                    while (resources.hasMoreElements()) {
                        linkedHashSet.add(new UrlResource(classLoader, resources.nextElement()));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return linkedHashSet;
    }

    static class UrlResource {
        private final ClassLoader classLoader;
        private final URL url;

        public UrlResource(ClassLoader classLoader2, URL url2) {
            this.classLoader = classLoader2;
            this.url = url2;
        }

        public ClassLoader getClassLoader() {
            return this.classLoader;
        }

        public URL getUrl() {
            return this.url;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            UrlResource urlResource = (UrlResource) obj;
            if (this.classLoader == null ? urlResource.classLoader == null : this.classLoader.equals(urlResource.classLoader)) {
                return this.url == null ? urlResource.url == null : this.url.equals(urlResource.url);
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = (this.classLoader != null ? this.classLoader.hashCode() : 0) * 31;
            if (this.url != null) {
                i = this.url.hashCode();
            }
            return hashCode + i;
        }
    }
}
