package per.liam.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import per.liam.domain.Area;
import per.liam.utils.JdbcUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author liam
 * @date 2020/6/9 08:26
 */
public class AreaDao {
    QueryRunner queryRunner = new QueryRunner(JdbcUtil.getDataSource());

    public List<Area> getArea() {
        String sql = "select * from area";
        try {
            List<Area> areaList = queryRunner.query(sql, new BeanListHandler<>(Area.class));
            return areaList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
