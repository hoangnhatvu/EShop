package hcmute.vn.dao;

import java.util.List;

import hcmute.vn.entity.Style;
import hcmute.vn.entity.StyleValue;

public interface IStyleDao {

	void insert(Style style);

	void delete(int styleId) throws Exception;

	Style findById(int styleId);

	void update(Style style);

	List<Style> findAll();

	

}
