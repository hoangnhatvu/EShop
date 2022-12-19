package hcmute.vn.service;

import java.util.List;

import hcmute.vn.entity.Style;
import hcmute.vn.entity.StyleValue;

public interface IStyleService {

	void delete(int styleId) throws Exception;

	void insert(Style style);

	void update(Style style);

	List<Style> findAll();

	Style findById(int styleId);


}
