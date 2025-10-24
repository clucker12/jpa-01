package jpa06.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa06.reserve.domain.Grade;
import jpa06.reserve.domain.Hotel;
import main.jpa03.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainNullEmbedded {
    private static Logger logger = LoggerFactory.getLogger(MainNullEmbedded.class);

    public static void main(String[] args) {
        EMF.init();
        saveHotel();
        printHotel();
        EMF.close();
    }

    private static void saveHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(
                    new Hotel("H009", "HN", 2022, Grade.S7, null)
            );
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }

    private static void printHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H009");
            if (hotel != null) {
                logger.info("주소: {}", hotel.getAddress());
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        } finally {
            em.close();
        }
    }
}
