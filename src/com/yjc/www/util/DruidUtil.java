package com.yjc.www.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

@SuppressWarnings("resource")
public class DruidUtil {

	private DruidUtil() {
	}

	private static Properties p = new Properties();
	
	private static DataSource dataSource;
	static {
		try {
			// 获取类加载器
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			// 读取配置文件
			InputStream inputStream = loader.getResourceAsStream("druid.properties");
			p.load(inputStream);
			// 使用连接池工厂创建连接池对象
			dataSource = DruidDataSourceFactory.createDataSource(p);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 获取数据库连接对象
	 * 
	 * @return Connection数据库连接对象
	 */
	public static Connection getConn() {
		try {
			// 获取数据库连接
			return dataSource.getConnection();
		} catch (Exception e) {
			throw new RuntimeException("获取数据库连接失败", e);
		}
	}

	public static void close(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
