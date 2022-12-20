package hcmute.vn.service.impl;

import hcmute.vn.dao.ICartDao;
import hcmute.vn.dao.impl.CartDaoImpl;
import hcmute.vn.entity.Cart;
import hcmute.vn.entity.CartItem;
import hcmute.vn.service.ICartService;

public class CartServiceImpl implements ICartService {
    ICartDao cartDao = new CartDaoImpl();
    @Override
    public boolean existCart(int userId) {
        return cartDao.existCart(userId);
    }

    @Override
    public Cart findCartByUserId(int userId) {
        return cartDao.findCartByUserId(userId);
    }

    @Override
    public void insert(Cart cart) {
        cartDao.insert(cart);
    }

}
