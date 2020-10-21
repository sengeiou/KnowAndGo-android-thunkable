package com.polidea.multiplatformbleadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class Device {

    /* renamed from: id */
    private String f1090id;
    @Nullable
    private Integer mtu;
    private String name;
    @Nullable
    private Integer rssi;
    @Nullable
    private List<Service> services;

    public Device(String str, String str2) {
        this.f1090id = str;
        this.name = str2;
    }

    public String getId() {
        return this.f1090id;
    }

    public void setId(String str) {
        this.f1090id = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    @Nullable
    public Integer getRssi() {
        return this.rssi;
    }

    public void setRssi(Integer num) {
        this.rssi = num;
    }

    @Nullable
    public Integer getMtu() {
        return this.mtu;
    }

    public void setMtu(Integer num) {
        this.mtu = num;
    }

    @Nullable
    public List<Service> getServices() {
        return this.services;
    }

    public void setServices(@Nullable List<Service> list) {
        this.services = list;
    }

    @Nullable
    public Service getServiceByUUID(@NonNull UUID uuid) {
        if (this.services == null) {
            return null;
        }
        for (Service next : this.services) {
            if (uuid.equals(next.getUuid())) {
                return next;
            }
        }
        return null;
    }
}
