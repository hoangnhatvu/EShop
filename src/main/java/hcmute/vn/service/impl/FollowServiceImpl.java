package hcmute.vn.service.impl;

import hcmute.vn.dao.IFollowDao;
import hcmute.vn.dao.impl.FollowDaoImple;
import hcmute.vn.entity.UserFollowProduct;
import hcmute.vn.entity.UserFollowStore;
import hcmute.vn.service.IFollowService;

import java.util.List;

public class FollowServiceImpl implements IFollowService {
    IFollowDao followDao = new FollowDaoImple();

    @Override
    public UserFollowProduct findUFPByUIdAndPId(int uId, int pId) {
        return followDao.findUFPByUIdAndPId(uId, pId);
    }

    @Override
    public UserFollowStore findUFSByUIdAndPId(int uId, int sId) {
        return followDao.findUFSByUIdAndPId(uId, sId);
    }
    public List<UserFollowStore> findUFSByUId(int uId){
        return followDao.findUFSByUId(uId);
    }
    public List<UserFollowProduct> findUFPByUId(int uId){
        return followDao.findUFPByUId(uId);
    }

    @Override
    public void followStore(UserFollowStore userFollowStore) {
        followDao.followStore(userFollowStore);
    }

    @Override
    public void unfollowStore(UserFollowStore userFollowStore) throws Exception {
        followDao.unfollowStore(userFollowStore);
    }

    @Override
    public void followProduct(UserFollowProduct userFollowProduct) {
        followDao.followProduct(userFollowProduct);
    }

    @Override
    public void unfollowProduct(UserFollowProduct userFollowProduct) throws Exception {
        followDao.unfollowProduct(userFollowProduct);
    }
}
