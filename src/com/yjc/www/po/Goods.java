package com.yjc.www.po;

public class Goods {
    private int id;
    private String name;
    private int shopId;
    private double price;
    private int limitNum;
    private String shopName;


    public Goods(Integer id, String name, Integer shopId, Double price, Integer limitNum) {
        this.id = id;
        this.name = name;
        this.shopId = shopId;
        this.price = price;
        this.limitNum = limitNum;
    }

    public Goods(Integer goodsId, String goodsName, Double price, Integer limitNum) {
        this.id = goodsId;
        this.name = goodsName;
        this.price = price;
        this.limitNum = limitNum;
    }

    public Goods(String goodsName, Double price, Integer limitNum) {
        this.name = goodsName;
        this.price = price;
        this.limitNum = limitNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + name + '\'' +
                ", shop_id=" + shopId +
                ", price=" + price +
                ", limit_num=" + limitNum +
                '}';
    }
}
