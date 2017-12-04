package com.mojafirma.model.dao;

import com.mojafirma.presenter.ShowingPresenter;
import com.mojafirma.utility.HibernateUtil;
import com.mojafirma.model.Showing;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by HP on 2017-09-24.
 */
public class ShowingDAOImplement implements ShowingPresenter{

    public Integer addShowing(Showing showing) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Integer showingID = null;

        try {
            tx = session.beginTransaction();
            showingID = (Integer)session.save(showing);
            tx.commit();

        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();

        }
        return showingID;
    }

    public void updateShowing(Showing showing) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(showing);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public void removeShowing(Showing showing) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(showing);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Showing> getShowingList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Showing> showing = null;
        try{
            tx = session.beginTransaction();
            showing = session.createQuery("FROM Showing").list();
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

        return showing;
    }

}
