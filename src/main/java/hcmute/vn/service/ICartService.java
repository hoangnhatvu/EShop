package hcmute.vn.service;

import hcmute.vn.entity.Cart;
import hcmute.vn.entity.Product;

public interface ICartService {
    public boolean existCart (int userId);
    public Cart findCartByUserId (int userId);
    public void insert (Cart cart);
}
