package io.spring.billing.manager;

import io.spring.billing.entities.BillingEntity;

import java.util.List;

public abstract class AbstractBillingManager<T extends BillingEntity> extends AbstractManager<T> {


    @Override
    public List<T> findAll() {
        return super.findAll();
    }

    @Override
    public void save(T element) {
        super.save(element);
    }

    @Override
    public void delete(T element) {
        super.delete(element);
    }

    @Override
    public T get(long id) {
        return super.get(id);
    }
}
