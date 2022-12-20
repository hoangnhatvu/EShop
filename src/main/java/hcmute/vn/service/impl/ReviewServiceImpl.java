package hcmute.vn.service.impl;

import hcmute.vn.dao.IReviewDao;
import hcmute.vn.dao.impl.ReviewDaoImpl;
import hcmute.vn.entity.Review;
import hcmute.vn.service.IReviewService;

import java.util.List;

public class ReviewServiceImpl implements IReviewService {
    IReviewDao reviewDao = new ReviewDaoImpl();
    @Override
    public List<Review> findReviewsByProdId(int prodId) {
        return reviewDao.findReviewsByProdId(prodId);
    }

    @Override
    public void insert(Review review) {
        reviewDao.insert(review);
    }
}
