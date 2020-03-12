package com.yjc.www.dao.impl;

import com.yjc.www.dao.ICustomerDao;
import com.yjc.www.po.Customer;

import java.sql.*;

import com.yjc.www.po.Order;
import com.yjc.www.util.DruidUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDaoImpl implements ICustomerDao {

    @Override
    public void save(Customer customer) {
        String sql = "insert into customer (username,balance,phone,address,password)values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, customer.getUsername());
            ps.setDouble(2, customer.getBalance());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getPassword());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public void delete(Customer customer) {
        String sql = "delete from customer where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, customer.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }

    }

    @Override
    public void update(Customer customer) {
        String sql = "update customer set username =?,phone=?,address=?,password=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getAddress());
            ps.setString(4, customer.getPassword());
            ps.setInt(5, customer.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public Customer getById(Integer customerId) {
        String sql = "SELECT*FROM customer WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, customerId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                Double balance = rs.getDouble("balance");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String password = rs.getString("password");
                Customer cm = new Customer(customerId, username, balance, phone, address, password);
                return cm;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Integer login(String username, String password) {
        String sql = "SELECT*FROM customer WHERE password =? and username =? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, password);
            ps.setString(2, username);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public boolean checkUsername(String username) {
        String sql = "SELECT*FROM customer WHERE username =? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, username);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return true;
    }

    @Override
    public Double getBalance(Integer customerId) {
        String sql = "SELECT balance FROM customer WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, customerId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Double balance = rs.getDouble("balance");
                return balance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public void updateBalance(Double totalCost, Double balance, Integer customerId) {
        String sql = "update customer set balance = ? where id = ?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setDouble(1, balance - totalCost);
            ps.setInt(2, customerId);
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public List<Customer> getAll() {
        //创建list集合封装Customers对象
        List<Customer> customers = new ArrayList<>();
        String sql = "select*from customer";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            //创建语句对象
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();

            //遍历结果集，封装对象
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String username = rs.getString("username");
                Double balance = rs.getDouble("balance");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String password = rs.getString("password");
                Customer cm = new Customer(id, username, balance, phone, address, password);
                //将Customer对象添加到list集合
                customers.add(cm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return customers;
    }

    @Override
    public List<Order> getCustomerOrder(Integer customerId) {
        //创建list集合封装Orders对象
        List<Order> shopOrders = new ArrayList<>();
        String sql = "SELECT\n" +
                "order_time,shop_name,goods_name,number,total_cost\n" +
                "FROM orders,customer,shop,goods\n" +
                "WHERE customer.`id`=orders.`customer_id` AND goods.`id`=orders.`goods_id` AND goods.`shop_id`=shop.`id` AND customer.`id`=?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            //创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, customerId);
            //执行sql语句
            rs = ps.executeQuery();
            //遍历结果集，封装对象
            while (rs.next()) {
                Timestamp orderTime = rs.getTimestamp("order_time");
                Integer number = rs.getInt("number");
                double totalCost = rs.getDouble("total_cost");
                String goodsName = rs.getString("goods_name");
                String shopName = rs.getString("shop_name");
                Order customerOrder = new Order(orderTime, number, totalCost, shopName, goodsName);
                //将Order对象添加到list集合
                shopOrders.add(customerOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return shopOrders;
    }
}

