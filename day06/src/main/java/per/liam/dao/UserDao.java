package per.liam.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import per.liam.domain.User;
import per.liam.utils.JdbcUtil;


import java.sql.SQLException;
import java.util.List;

/**
 * @author liam
 * @date 2020/6/8 23:21
 */
public class UserDao {
    QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    public List<User> searchUser(String username) {
        String sql = "select * from t_user where name like ?";
        try {
            List<User> users = queryRunner.query(sql, new BeanListHandler<>(User.class), "%" + username + "%");
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
