package com.example.myapplication.Activity;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Item implements Parcelable {
    protected String ItemName;
    protected Integer ItemPrice;
    protected Integer ItemQty;
    protected ImageView ItemImage;

    public Item() {
    }
    public Item(String itemName, Integer itemPrice, Integer itemQty) {
        ItemName = itemName;
        ItemPrice = itemPrice;
        ItemQty = itemQty;
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

    public ImageView getItemImage() {
        return ItemImage;
    }

    public void setItemImage(ImageView itemImage) {
        ItemImage = itemImage;
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
    }
}
