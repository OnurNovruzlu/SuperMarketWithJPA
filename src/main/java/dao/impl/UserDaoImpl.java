package dao.impl;

import config.Config;
import dao.inter.UserDaoInter;
import entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserDaoImpl extends Config implements UserDaoInter {

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        EntityManager em = em();
        User u = new User(username, password);
        em.find(User.class, u);
        closeEM(em);
        return u;
    }

    @Override
    public User getUserById(int id) {
        EntityManager em = em();
        User u = em.find(User.class, id);
        closeEM(em);
        return u;
    }

    @Override
    public List<User> getUsers() {
        EntityManager eman = em();

        String jpql = "select u from User u ";
        Query q=eman.createQuery(jpql,User.class);
        return q.getResultList();
    }

    @Override
    public boolean updateUser(User u) {
       EntityManager eMan = em();
        eMan.getTransaction().begin();
        eMan.merge(u);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true;
    }

    @Override
    public boolean insertUser(User u) {
        EntityManager eMan = em();
        eMan.getTransaction().begin();
        eMan.persist(u);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true; }

    @Override
    public boolean removeUser(int id) {
        EntityManager eMan = em();
        User p = eMan.find(User.class, id);
        eMan.getTransaction().begin();
        eMan.remove(p);
        eMan.getTransaction().commit();
        closeEM(eMan);
        return true; }
}
