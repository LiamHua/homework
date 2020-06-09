import org.junit.jupiter.api.Test;
import per.liam.dao.CategoryDao;
import per.liam.domain.Category;

import java.util.List;

/**
 * @author liam
 * @date 2020/6/4 22:29
 */
public class MyTest {
    @Test
    public void test() {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.getCategories();
    }
}
