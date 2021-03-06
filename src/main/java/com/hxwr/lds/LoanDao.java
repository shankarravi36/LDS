/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.lds;

import com.hxwr.lds.entities.Loan;
import java.util.Iterator;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Training
 */
public class LoanDao {

    public void addLoanDetails(Loan loan) throws HibernateException {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateConfig.openSession();

            transaction = session.beginTransaction();

            session.save(loan);
            transaction.commit();
            System.out.println("\n\n Details Added \n");
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Loan getByLoanID(Integer loanID) {
        Session session = null;

        session = HibernateConfig.openSession();

        Query query = session.createQuery("from Loan where loanID = :loanID");

        query.setInteger("loanID", loanID);

        Iterator<Loan> iter = query.iterate();

        if (iter.hasNext()) {
            return iter.next();
        } else {
            return null;
        }
    }
}
