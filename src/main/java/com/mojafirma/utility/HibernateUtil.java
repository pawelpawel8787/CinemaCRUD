package com.mojafirma.utility;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.util.List;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    private  static  Session session = sessionFactory.openSession();
    private HibernateUtil(){

    }

    public static SessionFactory getSessionFactory() {
        if (session == null) {
            session = (Session) new HibernateUtil();
        }
        return sessionFactory;
    }
    

    public static void closeSession() throws HibernateException {
        sessionFactory.close();
    }
}

