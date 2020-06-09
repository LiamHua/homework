package per.liam.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import per.liam.domain.User;
import per.liam.utils.JdbcUtil;

import java.sql.SQLException;

/**
 * @author liam
 * @date 2020/6/2 10:17
 */
public class UserDao {

    QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());
    public boolean checkUser(User user) {
        /*Connection connection = JdbcUtil.getConnection();*/

        String sql = "select * from user where username = ? and password = ?";

        User u = null;

        try {
            u = queryRunner.query(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u != null;
    }

    public boolean addUser(User user) {
        User u = null;
        /**
         * 首先查询该用户是否已存在
         */
        String checkSql = "select * from user where username = ?";
        try {
            u = queryRunner.query(checkSql, new BeanHandler<>(User.class), user.getUsername());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (u != null) {
            return false;
        }

        String sql = "insert user(username,password) values(?, ?)";

        try {
            u = queryRunner.insert(sql, new BeanHandler<>(User.class), user.getUsername(), user.getPassword());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return u != null;
    }
}
