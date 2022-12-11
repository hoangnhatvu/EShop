package hcmute.vn.dao;

import hcmute.vn.entity.CartItem;
import hcmute.vn.entity.Product;

public interface ICartItemDao {
    public void insert(CartItem cartItem);
    public void update(CartItem cartItem);
    public void delete(CartItem cartItem) throws Exception;
    public CartItem findById(int id);
    public CartItem findByProdId (Product product);
    public boolean existCartItem(Product product);
}
