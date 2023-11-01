package com.Ecommerce.Service;

import com.Ecommerce.Exception.CartItemException;
import com.Ecommerce.Exception.UserException;
import com.Ecommerce.model.Cart;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.Product;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long cartItemId, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
