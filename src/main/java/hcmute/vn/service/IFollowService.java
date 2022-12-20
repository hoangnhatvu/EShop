package hcmute.vn.service;

import hcmute.vn.entity.UserFollowProduct;
import hcmute.vn.entity.UserFollowStore;

import java.util.List;

public interface IFollowService {
    public UserFollowProduct findUFPByUIdAndPId(int uId, int pId);
    public UserFollowStore findUFSByUIdAndPId(int uId, int sId);
    public List<UserFollowStore> findUFSByUId(int uId);
    public List<UserFollowProduct> findUFPByUId(int uId);
    public void followStore(UserFollowStore userFollowStore);
    public void unfollowStore(UserFollowStore userFollowStore) throws Exception;
    public void followProduct(UserFollowProduct userFollowProduct);
    public void unfollowProduct(UserFollowProduct userFollowProduct) throws Exception;
}
