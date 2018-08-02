package io.spring.billing.manager;

import io.spring.billing.dao.BillDAO;
import io.spring.billing.entities.Bill;

import java.util.List;

public class BillManager extends AbstractManager<Bill> {

	private static BillManager instance;

	private BillManager() {
	}

	public static BillManager getInstance() {
		if (instance == null) {
			instance = new BillManager();
		}
		return instance;
	}

	@Override
	public BillDAO getDao() {
		return BillDAO.getInstance();
	}

	public List<Bill> findBillByProductAndQuantityGreaterThan(final Long productId, final Integer quantity) {
		return getDao().findBillByProductAndQuantityGreaterThan(productId, quantity);
	}
}
