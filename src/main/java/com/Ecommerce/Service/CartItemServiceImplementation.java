package com.Ecommerce.Service;

import com.Ecommerce.Exception.CartItemException;
import com.Ecommerce.Exception.UserException;
import com.Ecommerce.Repository.CartItemRepository;
import com.Ecommerce.Repository.CartRepository;
import com.Ecommerce.model.Cart;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.Product;
import com.Ecommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImplementation implements CartItemService{

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public CartItem createCartItem(CartItem cartItem) {

        cartItem.setQuantity(1);
        cartItem.setPrice(cartItem.getProduct().getPrice()*cartItem.getQuantity());
        cartItem.setDiscountedPrice(cartItem.getProduct().getDiscountedPrice()*cartItem.getQuantity());

        CartItem createdCartItem = cartItemRepository.save(cartItem);

        return createdCartItem;
    }

    @Override
    public CartItem updateCartItem(Long cartItemId, CartItem cartItem) throws CartItemException, UserException {

        CartItem item = findCartItemById(cartItemId);
        //User user = userService.findUserById(item.getUserId());

//        if(user.getId().equals(userId))
//        {
            item.setQuantity(cartItem.getQuantity());
            item.setPrice(item.getQuantity()*item.getProduct().getPrice());
            item.setDiscountedPrice(item.getProduct().getDiscountedPrice()*item.getQuantity());

//        }
        return cartItemRepository.save(item);
    }

    @Override
    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId) {

        CartItem cartItem = cartItemRepository.isCartItemExist(cart, product, size, userId);
        return cartItem;
    }

    @Override
    public void removeCartItem(Long cartItemId) throws CartItemException, UserException {

//        CartItem cartItem = findCartItemById(cartItemId);
//
//        User user = userService.findUserById(cartItem.getUserId());
//
//        User reqUser = userService.findUserById(userId);
//
//        if(user.getId().equals(reqUser.getId()))
//        {
//            cartItemRepository.deleteById(cartItemId);
//        }
//        else {
//            throw new UserException("You can't remove another users Item");
//        }

        cartItemRepository.deleteById(cartItemId);

    }

    @Override
    public CartItem findCartItemById(Long cartItemId) throws CartItemException {
        Optional<CartItem> opt = cartItemRepository.findById(cartItemId);

        if(opt.isPresent()){
            return opt.get();
        }
        throw new CartItemException("CartItem not found with id : " + cartItemId);
    }
}
