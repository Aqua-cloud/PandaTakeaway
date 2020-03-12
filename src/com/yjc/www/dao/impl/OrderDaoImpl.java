package com.yjc.www.dao.impl;


import com.yjc.www.dao.IOrderDao;
import com.yjc.www.po.Order;
import com.yjc.www.util.DaoUtil;
import com.yjc.www.util.DruidUtil;

import java.sql.*;

public class OrderDaoImpl implements IOrderDao {

    @Override
    public void save(Order order) {
        String sql = "insert into orders (order_time,customer_id,goods_id,number,total_cost)values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, DaoUtil.timeToString(order.getOrderTime()));
            ps.setInt(2, order.getCustomerId());
            ps.setInt(3, order.getGoodsId());
            ps.setInt(4, order.getNumber());
            ps.setDouble(5, order.getTotalCost());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from orders where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, id);
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }

    }

    @Override
    public void update(Order order) {
        String sql = "update orders set order_time =?,goods_id=?,number=?,total_cost=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            java.sql.Date sqlDate = new java.sql.Date(order.getOrderTime().getTime());
            ps.setDate(1, sqlDate);
            ps.setInt(2, order.getGoodsId());
            ps.setInt(3, order.getNumber());
            ps.setDouble(4, order.getTotalCost());
            ps.setInt(5, order.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public Order get(Integer id) {
        String sql = "SELECT*FROM orders WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, id);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp orderTime = rs.getTimestamp("order_time");
                Integer customerId = rs.getInt("customer_id");
                Integer goodsId = rs.getInt("goods_id");
                Integer number = rs.getInt("number");
                double totalCost = rs.getDouble("total_cost");
                Order od = new Order(id, orderTime, customerId, goodsId, number, totalCost);
                return od;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Double getTotalCost(Integer id) {
        String sql = "SELECT total_cost FROM orders WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, id);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                double totalCost = rs.getDouble("total_cost");
                return totalCost;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

}
