package com.yjc.www.po;

public class Shop {
    private int id;
    private String name;
    private double turnover;
    private String phone;
    private String address;
    private String password;
    private String evaluation;

    public Shop(Integer id, String name, double turnover, String phone, String address, String password, String evaluation) {
        this.id = id;
        this.name = name;
        this.turnover = turnover;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.evaluation = evaluation;
    }

    public Shop(Integer shopId, String username, String password, String address, String phone) {
        this.id = shopId;
        this.name = username;
        this.phone = phone;
        this.address = address;
        this.password = password;
    }

    public Shop() {

    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
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

    public double getTurnover() {
        return turnover;
    }

    public void setTurnover(double turnover) {
        this.turnover = turnover;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", turnover=" + turnover +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", evaluation='" + evaluation + '\'' +
                '}';
    }
}
