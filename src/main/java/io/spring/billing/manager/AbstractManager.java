package io.spring.billing.manager;

import io.spring.billing.dao.AbstractDAO;
import io.spring.billing.entities.BillingEntity;

import java.util.List;

public abstract class AbstractManager<T extends BillingEntity> {


    public abstract AbstractDAO<T> getDao();


    public List<T> findAll() {
        return getDao().findAll();
    }

    public void save(final T element) {
        getDao().save(element);
    }

    public void delete(final T element) {
        getDao().delete(element);
    }

    public T get(final long id) {
        return getDao().get(id);
    }
}
