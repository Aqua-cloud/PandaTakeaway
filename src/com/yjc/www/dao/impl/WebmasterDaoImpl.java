package com.yjc.www.dao.impl;


import com.yjc.www.dao.IWebmasterDao;
import com.yjc.www.po.Webmaster;
import com.yjc.www.util.DruidUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WebmasterDaoImpl implements IWebmasterDao {

    @Override
    public void save(Webmaster webmaster) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into webmaster(username,password)values(?,?)";
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, webmaster.getUsername());
            ps.setString(2, webmaster.getPassword());
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
            String sql = "delete from webmaster where id =?";
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
    public void update(Webmaster webmaster) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String sql = "update webmaster set username =?,password=? where id=?";
            conn = DruidUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, webmaster.getUsername());
            ps.setString(2, webmaster.getPassword());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, null);
        }
    }

    @Override
    public Webmaster get(Integer id) {
        String sql ="SELECT*FROM webmaster WHERE id =?";
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
                String username = rs.getString("username");
                String password = rs.getString("password");
                Webmaster wm = new Webmaster(id,username,password);
                return wm;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtil.close(conn,ps,rs);
        }
        return null;
    }

    @Override
    public Integer login(String password, String username) {
        String sql ="SELECT*FROM webmaster WHERE username =? and password = ?";
        Connection conn =null;
        PreparedStatement ps =null;
        ResultSet rs = null;
        try {
            conn=DruidUtil.getConn();
            // 创建语句对象
            ps =conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1,username);
            ps.setString(2,password);
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
    public List<Webmaster> getAll() {
        //创建list集合封装Webmaster对象
        List<Webmaster> webmasters = new ArrayList<>();
        String sql = "select*from webmaster";
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
                String password = rs.getString("password");
                Webmaster wm = new Webmaster(id, username, password);
                //将Webmaster对象添加到list集合
                webmasters.add(wm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close(conn, ps, rs);
        }
        return webmasters;
    }
}





