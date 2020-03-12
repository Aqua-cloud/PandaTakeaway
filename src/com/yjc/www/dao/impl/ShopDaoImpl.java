package com.yjc.www.dao.impl;


import com.yjc.www.dao.IShopDao;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.po.Shop;
import com.yjc.www.util.DruidUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShopDaoImpl implements IShopDao {

    @Override
    public void save(Shop shop) {
        String sql = "insert into shop (shop_name,turnover,phone,address,password,evaluation)values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn =DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, shop.getName());
            ps.setDouble(2, shop.getTurnover());
            ps.setString(3, shop.getPhone());
            ps.setString(4, shop.getAddress());
            ps.setString(5,shop.getPassword());
            ps.setString(6,shop.getEvaluation());
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
        String sql = "delete from shop where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn =DruidUtil.getConn();
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
    public void update(Shop shop) {
        String sql = "update shop set shop_name =?,phone=?,address=?,password=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn =DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, shop.getName());
            ps.setString(2, shop.getPhone());
            ps.setString(3, shop.getAddress());
            ps.setString(4,shop.getPassword());
            ps.setInt(5, shop.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public Shop get(Integer id) {
        String sql ="SELECT*FROM shop WHERE id =?";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn=DruidUtil.getConn();
            // 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, id);
            //执行sql语句
            rs =ps.executeQuery();
            if(rs.next()){
                String name = rs.getString("shop_name");
                Double turnover = rs.getDouble("turnover");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String password = rs.getString("password");
                String evaluation = rs.getString("evaluation");
                Shop sp = new Shop(id,name,turnover,phone,address,password,evaluation);
                return sp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public List<Goods> getGoods(Integer id) {
        String sql ="SELECT goods.`id`,goods_name,price,limit_num FROM shop,goods WHERE goods.`shop_id`=shop.`id` and shop.`id`=?";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        //创建集合goodsList
        List<Goods> goodsList = new ArrayList<>();
        try {
            conn=DruidUtil.getConn();
            // 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, id);
            //执行sql语句
            rs =ps.executeQuery();
            while (rs.next()){
                Integer goodsId = rs.getInt("id");
                String goodsName = rs.getString("goods_name");
                Double price = rs.getDouble("price");
                Integer limitNum = rs.getInt("limit_num");
                Goods goods = new Goods(goodsId,goodsName,price,limitNum);
                goodsList.add(goods);
            }
            return goodsList;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public Integer login(String password, String username) {
        String sql ="SELECT*FROM shop WHERE password =? and shop_name = ?";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn=DruidUtil.getConn();
            // 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1,password);
            ps.setString(2,username);
            //执行sql语句
            rs =ps.executeQuery();
            if(rs.next()){
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public List<Shop> getAll() {
        //创建list集合封装Businesses对象
        List<Shop> shops = new ArrayList<>();
        String sql ="select*from shop";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            conn =DruidUtil.getConn();
            //创建语句对象
            ps =conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();

            //遍历结果集，封装对象
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("shop_name");
                Double turnover = rs.getDouble("turnover");
                String phone = rs.getString("phone");
                String address =rs.getString("address");
                String password = rs.getString("password");
                String evaluation = rs.getString("evaluation");
                Shop sp = new Shop(id,name,turnover,phone,address,password,evaluation);
                //将Businesses对象添加到list集合
                shops.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return shops;
    }

    @Override
    public List<Order> getShopOrder(Integer shopId){
        //创建list集合封装Orders对象
        List<Order> shopOrders = new ArrayList<>();
        String sql = "SELECT\n" +
                "orders.`id`,order_time,customer.`username`,customer.`address`,customer.`phone`,goods_name,number,total_cost\n" +
                "FROM orders,customer,shop,goods\n" +
                "WHERE customer.`id`=orders.`customer_id` AND goods.`id`=orders.`goods_id` AND goods.`shop_id`=shop.`id` AND shop.`id`=?";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs =null;
        try {
            conn =DruidUtil.getConn();
            //创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, shopId);
            //执行sql语句
            rs = ps.executeQuery();
            //遍历结果集，封装对象
            while (rs.next()){
                Integer orderId = rs.getInt("id");
                Timestamp orderTime = rs.getTimestamp("order_time");
                Integer number = rs.getInt("number");
                double totalCost = rs.getDouble("total_cost");
                String goodsName = rs.getString("goods_name");
                String customerName = rs.getString("username");
                String customerAddress = rs.getString("address");
                String customerPhone = rs.getString("phone");
                Order shopOrder = new Order(orderId,orderTime,number,totalCost,customerName,goodsName,customerAddress,customerPhone);
                //将Order对象添加到list集合
                shopOrders.add(shopOrder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return shopOrders;
    }

    @Override
    public boolean checkName(String name) {
        String sql ="SELECT*FROM shop WHERE shop_name =? ";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn=DruidUtil.getConn();
            // 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1,name);
            //执行sql语句
            rs =ps.executeQuery();
            if(rs.next()){
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return true;
    }

    @Override
    public void updateTurnover(Integer shopId, Double turnover) {
        String sql = "update shop set turnover=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn =DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setDouble(1,turnover);
            ps.setInt(2,shopId);
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

}
