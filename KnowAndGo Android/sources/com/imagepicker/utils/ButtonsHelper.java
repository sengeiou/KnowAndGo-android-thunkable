package com.imagepicker.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.onesignal.OneSignalDbContract;
import java.util.LinkedList;
import java.util.List;

public class ButtonsHelper {
    @Nullable
    public final Item btnCamera;
    @Nullable
    public final Item btnCancel;
    @Nullable
    public final Item btnLibrary;
    public final List<Item> customButtons;

    public static class Item {
        public final String action;
        public final String title;

        public Item(@NonNull String str, @NonNull String str2) {
            this.title = str;
            this.action = str2;
        }
    }

    public ButtonsHelper(@Nullable Item item, @Nullable Item item2, @Nullable Item item3, @NonNull LinkedList<Item> linkedList) {
        this.btnCamera = item;
        this.btnLibrary = item2;
        this.btnCancel = item3;
        this.customButtons = linkedList;
    }

    public List<String> getTitles() {
        LinkedList linkedList = new LinkedList();
        if (this.btnCamera != null) {
            linkedList.add(this.btnCamera.title);
        }
        if (this.btnLibrary != null) {
            linkedList.add(this.btnLibrary.title);
        }
        for (int i = 0; i < this.customButtons.size(); i++) {
            linkedList.add(this.customButtons.get(i).title);
        }
        return linkedList;
    }

    public List<String> getActions() {
        LinkedList linkedList = new LinkedList();
        if (this.btnCamera != null) {
            linkedList.add(this.btnCamera.action);
        }
        if (this.btnLibrary != null) {
            linkedList.add(this.btnLibrary.action);
        }
        for (int i = 0; i < this.customButtons.size(); i++) {
            linkedList.add(this.customButtons.get(i).action);
        }
        return linkedList;
    }

    public static ButtonsHelper newInstance(@NonNull ReadableMap readableMap) {
        return new ButtonsHelper(getItemFromOption(readableMap, "takePhotoButtonTitle", "photo"), getItemFromOption(readableMap, "chooseFromLibraryButtonTitle", "library"), getItemFromOption(readableMap, "cancelButtonTitle", "cancel"), getCustomButtons(readableMap));
    }

    @Nullable
    private static Item getItemFromOption(@NonNull ReadableMap readableMap, @NonNull String str, @NonNull String str2) {
        if (!ReadableMapUtils.hasAndNotEmptyString(readableMap, str)) {
            return null;
        }
        return new Item(readableMap.getString(str), str2);
    }

    @NonNull
    private static LinkedList<Item> getCustomButtons(@NonNull ReadableMap readableMap) {
        LinkedList<Item> linkedList = new LinkedList<>();
        if (!readableMap.hasKey("customButtons")) {
            return linkedList;
        }
        ReadableArray array = readableMap.getArray("customButtons");
        for (int i = 0; i < array.size(); i++) {
            ReadableMap map = array.getMap(i);
            linkedList.add(new Item(map.getString(OneSignalDbContract.NotificationTable.COLUMN_NAME_TITLE), map.getString("name")));
        }
        return linkedList;
    }
}
