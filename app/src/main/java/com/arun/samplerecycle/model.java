package com.arun.samplerecycle;

public class model {
   public String OwnerName,ShopName,ShopID,OwnerMobile,Address;

    public model() {
    }

    public model(String ownerName, String shopName, String shopID, String ownerMobile, String address) {
        OwnerName = ownerName;
        ShopName = shopName;
        ShopID = shopID;
        OwnerMobile = ownerMobile;
        Address = address;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getShopID() {
        return ShopID;
    }

    public void setShopID(String shopID) {
        ShopID = shopID;
    }

    public String getOwnerMobile() {
        return OwnerMobile;
    }

    public void setOwnerMobile(String ownerMobile) {
        OwnerMobile = ownerMobile;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
