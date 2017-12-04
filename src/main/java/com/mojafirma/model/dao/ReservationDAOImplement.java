package com.mojafirma.model.dao;

import com.mojafirma.presenter.ReservationPresenter;
import com.mojafirma.utility.HibernateUtil;
import com.mojafirma.model.Reservation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by HP on 2017-10-08.
 */
public class ReservationDAOImplement implements ReservationPresenter {

    public Integer addReservation(Reservation reservation) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer reservationID = null;

        try {
            tx = session.beginTransaction();
            reservationID = (Integer) session.save(reservation);
            tx.commit();


        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
        return reservationID;
    }
}
