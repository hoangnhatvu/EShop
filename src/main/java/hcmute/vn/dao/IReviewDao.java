package hcmute.vn.dao;

import hcmute.vn.entity.Review;

import java.util.List;

public interface IReviewDao {
    public List<Review> findReviewsByProdId(int prodId);
    public void insert(Review review);
}
