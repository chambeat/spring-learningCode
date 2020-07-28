package com.chm.jdbc;

import java.sql.*;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=GMT", "root", "chm699276");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //4.执行SQL，得到结果集
        ResultSet rs = ps.executeQuery();
        //5.遍历结果集
        while (rs.next()) {
//            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
//            System.out.println(rs.getFloat("money") + "\n");
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
