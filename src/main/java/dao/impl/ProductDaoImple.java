package dao.impl;

import config.Config;
import dao.inter.ProductDaoInter;
import entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProductDaoImple extends Config implements ProductDaoInter {

    @Override
    public List<Product> getAllProduct(/*String name, Integer price*/) {
        EntityManager eman = em();

        String jpql = "select p from Product p where 1=1 ";
//        if (name != null && !name.trim().isEmpty()) {
//            jpql += " and p.product_name=:product_name";
//        }
//        if (price != null) {
//            jpql += " and p.product_price=:product_price";
//        }

        Query q = eman.createQuery(jpql, Product.class);

//        if (name != null && !name.trim().isEmpty()) {
//            q.setParameter("product_name", name);
//        }
//        if (price != null) {
//            q.setParameter("product_price", price);
//        }
        return q.getResultList();
    }

    @Override
    public Product getProductById(int id) {
        EntityManager eman = em();
        Product p = eman.find(Product.class, id);
        closeEM(eman);
        return p;
    }

    @Override
    public boolean removeProduct(int id) {
        EntityManager eMan = em();
        Product p = eMan.find(Product.class, id);
        eMan.getTransaction().begin();
        eMan.remove(p);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true;
    }

    @Override
    public boolean updateProduct(Product p) {
        EntityManager eMan = em();
        eMan.getTransaction().begin();
        eMan.merge(p);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true;
    }

    @Override
    public boolean insertProduct(Product p) {
        EntityManager eMan = em();
        eMan.getTransaction().begin();
        eMan.persist(p);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true;
    }
}
