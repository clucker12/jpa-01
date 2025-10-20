package main.jpa03.app;

import com.example.jpa_01.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import main.jpa03.jpa.EMF;


public class NewUserService {

    public void saveNewUser(User user) {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
        } catch(Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
