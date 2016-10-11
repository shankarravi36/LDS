/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hxwr.ids.service.impl.dummy;

import com.hxwr.ids.service.ICreateReportSrv;
import com.hxwr.lds.entities.Client;
import com.hxwr.lds.entities.Loan;
import com.hxwr.lds.model.LoanReport;
import com.hxwr.lds.model.Payment;

/**
 *
 * @author 35194
 */
public class DummyCRS implements ICreateReportSrv {

    @Override
    public LoanReport CreateReport(Loan loan, Client client) {
        LoanReport lr = new LoanReport();
        lr.setLoan(loan);
        lr.setClient(client);

        lr.getMonthPaymentLst().add(new Payment());
        lr.getMonthPaymentLst().add(new Payment());
        lr.getMonthPaymentLst().add(new Payment());
        lr.getMonthPaymentLst().add(new Payment());
        lr.getMonthPaymentLst().add(new Payment());
        lr.getMonthPaymentLst().add(new Payment());

        return lr;
    }

}
