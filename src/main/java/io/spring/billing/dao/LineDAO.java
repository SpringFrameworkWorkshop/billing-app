package io.spring.billing.dao;

import io.spring.billing.entities.Line;

public class LineDAO extends AbstractDAO<Line> {

    private static LineDAO instance;

    private LineDAO() {
        super(Line.class);
    }

    public static LineDAO getInstance() {
        if (instance == null) {
            instance = new LineDAO();
        }
        return instance;
    }

}
