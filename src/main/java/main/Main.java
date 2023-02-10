package main;

import config.Context;
import dao.inter.UserDaoInter;

public class Main {

    public static void main(String[] args) {
        UserDaoInter udao=Context.instanceUserDao();
        System.out.println(udao.getUsers());

//        EntityManager eman = Config.em();
//        CriteriaBuilder cb = eman.getCriteriaBuilder();
//        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
//        Root<Product> root = cq.from(Product.class);
//        CriteriaQuery<Product> select = cq.select(root);
//        Query q = eman.createQuery(select);
//        System.out.println(q.getResultList());

    }
}
