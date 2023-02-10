package dao.impl;

import config.Config;
import dao.inter.CategoryDaoInter;
import entity.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class CategoryDaoImple extends Config implements CategoryDaoInter {

    @Override
    public List<Category> getAllCategories() {
        EntityManager eman = em();
        Query q = eman.createQuery("Select c from Category c");
        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int id) {
        EntityManager eman = em();
        Category c = eman.find(Category.class, id);
        return c;
    }

    @Override
    public boolean deleteCategory(int id) {
        EntityManager eman = em();
        Category c = eman.find(Category.class, id);
        eman.getTransaction().begin();
        eman.remove(c);
        eman.getTransaction().commit();
        closeEM(eman);
        return true;
    }

    @Override
    public boolean updateCategory(Category c) {
        EntityManager eman = em();
        eman.getTransaction().begin();
        eman.merge(c);
        eman.getTransaction().commit();
        closeEM(eman);
        return true;
    }

    @Override
    public boolean insertCategory(Category c) {
        EntityManager eman = em();
        eman.getTransaction().begin();
        eman.persist(c);
        eman.getTransaction().commit();
        closeEM(eman);
        return true;
    }
}
