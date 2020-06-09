package per.liam.dao;
import java.sql.SQLException;
import	java.time.Clock;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import per.liam.domain.Category;
import per.liam.utils.JdbcUtil;

import javax.management.Query;

/**
 * @author liam
 * @date 2020/6/4 21:43
 */
public class CategoryDao {
    QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    public List<Category> getCategories() {
        String sql = "select * from category";
        try {
            List<Category> categoryList = queryRunner.query(sql, new BeanListHandler<>(Category.class));
            return categoryList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
