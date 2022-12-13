package hcmute.vn.service;

import hcmute.vn.entity.CartItem;
import hcmute.vn.entity.Product;

public interface ICartItemService {
    public void insert(CartItem cartItem);
    public void update(CartItem cartItem);
    public void delete(CartItem cartItem) throws Exception;
    public CartItem findById(int id);
    public CartItem findByProdId (CartItem cartItem);
    public boolean existCartItem(CartItem cartItem);
}
