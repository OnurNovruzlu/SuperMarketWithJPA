/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author HP
 */
public abstract class Config {
      private static EntityManagerFactory emf=null;
      
      public static EntityManager em(){
          if(emf==null){
           emf=Persistence.createEntityManagerFactory("SuperMarketPersistence");
      }
            EntityManager eManager=emf.createEntityManager();
            return eManager;
}
      public static void closeEM(EntityManager eManager){
          eManager.close();
      }
      public static void closeEmf(){
          emf.close();
      }
      
}
