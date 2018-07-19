package io.spring.billing.dao;

import io.spring.billing.entities.Bill;

public class BillDAO extends AbstractDAO<Bill> {

    private static BillDAO instance;

    private BillDAO() {
        super(Bill.class);
    }

    public static BillDAO getInstance() {
        if (instance == null) {
            instance = new BillDAO();
        }
        return instance;
    }

}
