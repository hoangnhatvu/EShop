package hcmute.vn.service.impl;

import java.util.List;

import hcmute.vn.dao.IStyleDao;
import hcmute.vn.dao.impl.StyleDaoImpl;
import hcmute.vn.entity.Style;
import hcmute.vn.service.IStyleService;

public class StyleServiceImpl implements IStyleService {

	IStyleDao styleDao = new StyleDaoImpl();

	
	@Override
	public Style findById(int styleId) {
		return styleDao.findById(styleId);
	}

	
	@Override
	public List<Style> findAll() {
		return styleDao.findAll();
	}

	
	@Override
	public void update(Style style) {
		styleDao.update(style);
	}

	
	@Override
	public void insert(Style style) {
		styleDao.update(style);
	}

	
	@Override
	public void delete(int styleId) throws Exception {
		styleDao.delete(styleId);
	}

}
