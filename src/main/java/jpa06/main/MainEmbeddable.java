package jpa06.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jpa06.common.Address;
import jpa06.reserve.domain.Grade;
import jpa06.reserve.domain.Hotel;
import main.jpa03.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainEmbeddable {
    private static Logger logger = LoggerFactory.getLogger(MainEmbeddable.class);

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
            Address address = new Address("주소1", "주소2", "12345");
            Hotel hotel = new Hotel("H00", "HN", 2022, Grade.S7, address);
            em.persist(hotel);
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    private static void printHotel() {
        EntityManager em = EMF.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Hotel hotel = em.find(Hotel.class, "H00");
            if (hotel != null) {
                logger.info("주소: {}", hotel.getAddress());
            }
            tx.commit();
        } catch (Exception ex) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
