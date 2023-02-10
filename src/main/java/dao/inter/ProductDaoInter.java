package dao.inter;

import entity.Product;
import java.util.List;

public interface ProductDaoInter {

    public List<Product> getAllProduct(/*String name,Integer price*/);

    public Product getProductById(int id);

    public boolean removeProduct(int id);

    public boolean updateProduct(Product p);

    public boolean insertProduct(Product p);
}
