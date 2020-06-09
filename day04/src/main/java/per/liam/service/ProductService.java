package per.liam.service;

import per.liam.dao.ProductDao;
import per.liam.domain.Product;

import java.util.List;

/**
 * @author liam
 * @date 2020/6/4 22:59
 */
public class ProductService {
    public List<Product> getProducts() {
        ProductDao productDao = new ProductDao();
        return productDao.getProducts();
    }
}
