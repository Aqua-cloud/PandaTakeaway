package com.yjc.www.po;

import java.sql.Timestamp;
import java.util.Date;

public class Order {

    private int id;
    private Timestamp orderTime;
    private int customerId;
    private int goodsId;
    private int number;
    private double totalCost;
    private String customerName;
    private String goodsName;
    private String shopName;


    private String customerAddress;
    private String customerPhone;

    public Order(Integer orderId, Timestamp orderTime, Integer number, double totalCost, String customerName, String goodsName, String customerAddress, String customerPhone) {
        this.id = orderId;
        this.orderTime = orderTime;
        this.number = number;
        this.totalCost = totalCost;
        this.customerName = customerName;
        this.goodsName = goodsName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public Order(Timestamp orderTime, int number, double totalCost, String customerName, String goodsName, String customerAddress, String customerPhone) {

        this.orderTime = orderTime;
        this.number = number;
        this.totalCost = totalCost;
        this.customerName = customerName;
        this.goodsName = goodsName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public Order(Timestamp orderTime, Integer customerId, Integer goodsId, Integer number, double totalCost) {
        this.orderTime = orderTime;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.number = number;
        this.totalCost = totalCost;
    }

    public Order(int id, Timestamp orderTime, Integer customerId, Integer goodsId, Integer number, double totalCost) {
        this.id = id;
        this.orderTime = orderTime;
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.number = number;
        this.totalCost = totalCost;
    }

    public Order(Timestamp orderTime, int number, double totalCost, String goodsName, String shopName) {
        this.orderTime = orderTime;
        this.number = number;
        this.totalCost = totalCost;
        this.goodsName = goodsName;
        this.shopName = shopName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setOrderTime(Timestamp oderTime) {
        this.orderTime = oderTime;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }


    @Override
    public String toString() {
        return "Order{orderTime" + orderTime +
                ", number=" + number +
                ", totalCost=" + totalCost +
                ", goodsName='" + goodsName + '\'' +
                ", shopName='" + shopName + '\'' +
                '}';
    }
}

