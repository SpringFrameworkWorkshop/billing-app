package io.spring.billing.manager;

import io.spring.billing.dao.LineDAO;
import io.spring.billing.entities.Line;

public class LineManager extends AbstractManager<Line> {

	private static LineManager instance;

	private LineManager() {
	}

	public static LineManager getInstance() {
		if (instance == null) {
			instance = new LineManager();
		}
		return instance;
	}

	@Override
	public LineDAO getDao() {
		return LineDAO.getInstance();
	}
}
