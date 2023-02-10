package dao.inter;

import entity.Category;
import java.util.List;

public interface CategoryDaoInter {

    public List<Category> getAllCategories();

    public Category getCategoryById(int id);

    public boolean deleteCategory(int id);

    public boolean updateCategory(Category c);

    public boolean insertCategory(Category c);
}
