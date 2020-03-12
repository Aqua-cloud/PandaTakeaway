package com.yjc.www.dao.impl;


import com.yjc.www.dao.IGoodsDao;
import com.yjc.www.po.Goods;
import com.yjc.www.po.Order;
import com.yjc.www.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsDaoImpl implements IGoodsDao {

    @Override
    public void save(Goods goods) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into goods(goods_name,shop_id,price,limit_num)values(?,?,?,?);";
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, goods.getName());
            ps.setInt(2, goods.getShopId());
            ps.setDouble(3, goods.getPrice());
            ps.setInt(4, goods.getLimitNum());
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
        String sql = "delete from goods where id =?";
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
    public void update(Goods goods) {
        String sql = "update goods set goods_name =?,price=?,limit_num=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, goods.getName());
            ps.setDouble(2, goods.getPrice());
            ps.setInt(3, goods.getLimitNum());
            ps.setInt(4, goods.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public Goods get(Integer id) {
        String sql = "SELECT*FROM goods WHERE id =?";
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
                String name = rs.getString("goods_name");
                Integer shopId = rs.getInt("shop_id");
                Double price = rs.getDouble("price");
                Integer limitNum = rs.getInt("limit_num");
                Goods gd = new Goods(id, name, shopId, price, limitNum);
                return gd;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Integer getLimitNum(Integer goodsId) {
        String sql = "SELECT limit_num FROM goods WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, goodsId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Integer limitNum = rs.getInt("limit_num");
                return limitNum;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Double getPrice(Integer goodsId) {
        String sql = "SELECT price FROM goods WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, goodsId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Double price = rs.getDouble("price");
                return price;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public void updateNum(Integer number, Integer limitNum, Integer goodsId) {
        String sql = "update goods set limit_num=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, limitNum - number);
            ps.setInt(2, goodsId);
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }


    @Override
    public List<Goods> getAll() {
        //创建list集合封装Goods对象
        List<Goods> goods = new ArrayList<>();
        String sql = "select*from goods";
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
                String name = rs.getString("goods_name");
                Integer shop_id = rs.getInt("shop_id");
                Double price = rs.getDouble("price");
                Integer limitNum = rs.getInt("limit_num");
                Goods gd = new Goods(id, name, shop_id, price, limitNum);
                //将Goods对象添加到list集合
                goods.add(gd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return goods;
    }
}
