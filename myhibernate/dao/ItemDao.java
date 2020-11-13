package myhibernate.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import myhibernate.model.*;
import myhibernate.util.*; //fix

public class ItemDao {

    public void saveItem(myItem item) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.save(item);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public boolean checkBase(String barcode) {

        Transaction transaction = null;
        myItem item = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            item = (myItem) session.createQuery("from myItem I where I.items_id =:items_id").setParameter("items_id", barcode).uniqueResult();
           
            if (item == null ) {
            	System.out.println("Hibernate Java Config serviceRegistry created~~~~~~~~~");
            	transaction.commit();
                return true;    // an dn uparxei sthn vash epistrefw true
            }
            System.out.println("pamekarkino");
            // commit transaction
            transaction.commit();   ///wtf
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }

}