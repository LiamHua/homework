package per.liam.service;

import per.liam.dao.CategoryDao;
import per.liam.domain.Category;

import java.util.List;

/**
 * @author liam
 * @date 2020/6/4 22:42
 */
public class CategoryService {
    public List<Category> getCategories() {
        CategoryDao categoryDao = new CategoryDao();
        return categoryDao.getCategories();
    }
}
