package com.kiosite.dao;

import com.kiosite.model.County;
import com.kiosite.orm.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by alexmedinsky on 10.07.17.
 */
public class CountyDAO {

    public List<County> findAllCounties() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        return session.createCriteria(County.class).list();
    }

}
