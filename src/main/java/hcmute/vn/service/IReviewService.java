package hcmute.vn.service;

import hcmute.vn.entity.Review;

import java.util.List;

public interface IReviewService {
    public List<Review> findReviewsByProdId(int prodId);
    public void insert(Review review);
}
