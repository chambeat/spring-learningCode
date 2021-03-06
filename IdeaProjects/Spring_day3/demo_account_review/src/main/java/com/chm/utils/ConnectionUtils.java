package com.chm.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类：用于从数据源中获取一个连接，并且实现和线程的绑定。
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     *
     * @return
     */
    public Connection getThreadConnection() {
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        //2.判断当前线程上是否有连接
        if (conn == null) {
            try {
                //3.从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //4.返回当前线程上的连接
        return conn;
    }

    /**
     * 把连接和线程解绑
     */
    public void removeThreadConnection() {
        tl.remove();
    }
}
