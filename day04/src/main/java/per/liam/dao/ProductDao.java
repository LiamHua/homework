package per.liam.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import per.liam.domain.Product;
import per.liam.utils.JdbcUtil;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * @author liam
 * @date 2020/6/4 21:43
 */
public class ProductDao {
    QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    public List<Product> getProducts() {
        String sql = "select * from product";
        try {
            List<Product> list = queryRunner.query(sql, new BeanListHandler<>(Product.class));
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
