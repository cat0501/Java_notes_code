package com.itheima.jdbc;

import com.itheima.pojo.Account;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cat
 * @date 2022/1/28 下午4:18
 */
public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {

        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db01? useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        try {
            // ============开启事务==========
            conn.setAutoCommit(false);
            //5. 执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响的行数
            //6. 处理结果
            System.out.println(count1);
            int i = 3 / 0;
            //5. 执行sql
            int count2 = stmt.executeUpdate(sql2);//受影响的行数
            //6. 处理结果
            System.out.println(count2);
            // ============提交事务==========
            //程序运行到此处，说明没有出现任何问题，则需求提交事务
            conn.commit();
        } catch (Exception e) {
            // ============回滚事务==========
            //程序在出现异常时会执行到这个地方，此时就需要回滚事务
            conn.rollback();
            e.printStackTrace();
        }
        //7. 释放资源
        stmt.close();
        conn.close();
    }


    /**
     *  * 执行DML语句
     *  * @throws Exception
     *  
     */
    @Test
    public void testDML() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///db01? useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "update account set money = 3000 where id = 1";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        int count = stmt.executeUpdate(sql);//执行完DML语句，受影响的行数
        //6. 处理结果
        //System.out.println(count);
        if (count > 0) {
            System.out.println("修改成功~");
        } else {
            System.out.println("修改失败~");
        }
        //7. 释放资源
        stmt.close();
        conn.close();
    }


    /**
     *  * 执行DDL语句(以后开发很少使用java代码操作DDL语句)
     *  * @throws Exception
     *  
     */
    @Test
    public void testDDL() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///db01? useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "drop database db2";
        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        int count = stmt.executeUpdate(sql);//执行完DDL语句，可能是0
        //6. 处理结果
        System.out.println(count);
        //7. 释放资源
        stmt.close();
        conn.close();
    }


    /**
     *  * 执行DQL
     *  * @throws Exception
     *  
     */
    @Test
    public void testResultSet() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///db01?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "select * from account";
        //4. 获取statement对象
        Statement stmt = conn.createStatement();
        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        //6. 处理结果， 遍历rs中的所有数据
        /* // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据 getXxx()
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------------");
        }*/
        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()) {
            //6.2 获取数据 getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            System.out.println(id);
            System.out.println(name);
            System.out.println(money);
            System.out.println("--------------");
        }
        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     *  * 查询account账户表数据，封装为Account对象中，并且存储到ArrayList集合中
     *  * 1. 定义实体类Account
     *  * 2. 查询数据，封装到Account对象中
     *  * 3. 将Account对象存入ArrayList集合中
     *  
     */
    @Test
    public void testResultSet2() throws Exception {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///db01? useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "select * from account";
        //4. 获取statement对象
        Statement stmt = conn.createStatement();
        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 创建集合
        List<Account> list = new ArrayList<>();

        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()) {
            Account account = new Account();
            //6.2 获取数据 getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");
            //赋值
            account.setId(id);
            account.setName(name);
            account.setMoney(money);
            // 存入集合
            list.add(account);
        }

        System.out.println(list);
        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * 代码模拟SQL注入问题
     * @throws Exception
     */
    @Test
    public void testLogin() throws Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name = "sjdljfld";
        String pwd = "' or '1' = '1";
        String sql = "select * from user where username = '" + name + "' and password = '" + pwd + "'";
        // 获取stmt对象
        Statement stmt = conn.createStatement();
        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }
        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

    /**
     * 使用PreparedStatement改进
     * @throws Exception
     */
    @Test
    public void testPreparedStatement() throws
            Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        String url = "jdbc:mysql:///test?useSSL=false";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        // 定义sql
        String sql = "select * from user where username = ? and password = ?";
        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
        // 执行sql
        ResultSet rs = pstmt.executeQuery();
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }
        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

    /**
     *   * PreparedStatement原理
     *   * @throws Exception
     *  
     */
    @Test
    public void testPreparedStatement2() throws Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的3306 可以简化书写
        // useServerPrepStmts=true 参数开启预编译功能
        String url = "jdbc:mysql:///test? useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, username, password);
        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";
        // 定义sql
        String sql = "select * from user where username = ? and password = ?";
        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);
        Thread.sleep(10000);
        // 设置？的值
        pstmt.setString(1, name);
        pstmt.setString(2, pwd);
        ResultSet rs = null;
        // 执行sql
        rs = pstmt.executeQuery();
        // 设置？的值
        pstmt.setString(1, "aaa");
        pstmt.setString(2, "bbb");
        // 执行sql
        rs = pstmt.executeQuery();
        // 判断登录是否成功
        if (rs.next()) {
            System.out.println("登录成功~");
        } else {
            System.out.println("登录失败~");
        }
        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


}
