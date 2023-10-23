package com.hspedu.furns.test;

import com.hspedu.furns.utils.JDBCUtilsByDruid;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 测试是否连接到数据库
 * @author ZhengLiHua
 * @date 2023-10-22
 */
public class JDBCUtilsByDruidTest {
    @Test
    public void test() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection" + connection);
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
