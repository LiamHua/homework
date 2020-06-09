package per.liam.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author liam
 * @date 2020/6/2 10:48
 */
public class JdbcUtil {
    private static ComboPooledDataSource cpds;

    static {
        cpds = new ComboPooledDataSource();
    }

    public static ComboPooledDataSource getDataSource() {
        return cpds;
    }

    /*public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = getDataSource().getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }*/
}
