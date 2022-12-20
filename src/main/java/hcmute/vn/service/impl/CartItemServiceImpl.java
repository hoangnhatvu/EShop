package hcmute.vn.service.impl;

import hcmute.vn.dao.ICartItemDao;
import hcmute.vn.dao.impl.CartItemDaoImpl;
import hcmute.vn.entity.CartItem;
import hcmute.vn.entity.Product;
import hcmute.vn.service.ICartItemService;

public class CartItemServiceImpl implements ICartItemService {
    ICartItemDao cartItemDao = new CartItemDaoImpl();
    @Override
    public void insert(CartItem cartItem) {
        cartItemDao.insert(cartItem);
    }
    public void update(CartItem cartItem) {
        cartItemDao.update(cartItem);
    }
    public void delete(CartItem cartItem) throws Exception {
        cartItemDao.delete(cartItem);
    }
    public CartItem findById(int id){
        return cartItemDao.findById(id);
    }
    public CartItem findByProdId (CartItem cartItem) {return cartItemDao.findByProdId(cartItem);}
    public boolean existCartItem(CartItem cartItem) { return cartItemDao.existCartItem(cartItem); }
}
