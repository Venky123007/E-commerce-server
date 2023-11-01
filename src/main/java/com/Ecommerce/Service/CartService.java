package com.Ecommerce.Service;

import com.Ecommerce.Exception.ProductException;
import com.Ecommerce.Request.AddItemRequest;
import com.Ecommerce.model.Cart;
import com.Ecommerce.model.User;

public interface CartService {

    public Cart createCart(User user);

    public String addCartItem(Long userId, AddItemRequest req) throws ProductException;

    public Cart findUserCart(Long userId);

}
