import org.junit.jupiter.api.Test;
import per.liam.dao.UserDao;
import per.liam.service.AreaService;

/**
 * @author liam
 * @date 2020/6/8 23:26
 */
public class MyTest {
    @Test
    public void test() {
        //UserDao userDao = new UserDao();
        //userDao.searchUser("o");
        String area = new AreaService().getArea();
    }
}
