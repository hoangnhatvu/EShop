package hcmute.vn.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hcmute.vn.config.JPAConfig;
import hcmute.vn.dao.ICategoryDao;
import hcmute.vn.entity.Category;

public class CategoryDaoImpl implements ICategoryDao{
	public List<Category> findAll() {

		EntityManager enma = JPAConfig.getEntityManager();

		TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);

		return query.getResultList();

	}
	
	public Category findById(int categoryid) {
		EntityManager enma = JPAConfig.getEntityManager();

		Category category = enma.find(Category.class, categoryid);

		return category;
	}
}
