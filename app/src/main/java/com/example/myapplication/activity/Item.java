package com.example.myapplication.activity;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    protected String ItemName;
    protected Integer ItemPrice;
    protected Integer ItemQty;
    protected Integer ItemImageId;

    public Item() {
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public Integer getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(Integer itemPrice) {
        ItemPrice = itemPrice;
    }

    public Integer getItemQty() {
        return ItemQty;
    }

    public void setItemQty(Integer itemQty) {
        ItemQty = itemQty;
    }

    public Integer getItemImageId() {
        return ItemImageId;
    }

    public void setItemImageId(Integer itemImageId) {
        ItemImageId = itemImageId;
    }

    protected Item(Parcel in) {
        ItemName = in.readString();
        if (in.readByte() == 0) {
            ItemPrice = null;
        } else {
            ItemPrice = in.readInt();
        }
        if (in.readByte() == 0) {
            ItemQty = null;
        } else {
            ItemQty = in.readInt();
        }
        if (in.readByte() == 0) {
            ItemImageId = null;
        } else {
            ItemImageId = in.readInt();
        }
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ItemName);
        if (ItemPrice == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ItemPrice);
        }
        if (ItemQty == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ItemQty);
        }
        if (ItemImageId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ItemImageId);
        }
    }
}
