package hcmute.vn.dao;

import hcmute.vn.entity.Category;

import java.util.List;

public interface ICategoryDao {
    public List<Category> findAll();
    public int countProdByCateId(int cateId);
}
