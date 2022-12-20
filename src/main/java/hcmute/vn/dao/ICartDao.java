package hcmute.vn.dao;

import hcmute.vn.entity.Cart;

public interface ICartDao {
    public boolean existCart (int userId);
    public Cart findCartByUserId (int userId);
    public void insert (Cart cart);
}
