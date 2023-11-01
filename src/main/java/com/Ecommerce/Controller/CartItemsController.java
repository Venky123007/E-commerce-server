package com.Ecommerce.Controller;

import com.Ecommerce.Exception.CartItemException;
import com.Ecommerce.Exception.UserException;
import com.Ecommerce.Service.CartItemService;
import com.Ecommerce.model.Cart;
import com.Ecommerce.model.CartItem;
import com.Ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart_items")
public class CartItemsController {

    private final CartItemService cartItemService;

    @Autowired
    public CartItemsController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItem cartItem) {
        CartItem createdCartItem = cartItemService.createCartItem(cartItem);
        return new ResponseEntity<>(createdCartItem, HttpStatus.CREATED);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<CartItem> updateCartItem(
            //@PathVariable Long userId,
            @PathVariable Long cartItemId,
            @RequestBody CartItem cartItem
    ) {
        try {
            CartItem updatedCartItem = cartItemService.updateCartItem(cartItemId, cartItem);
            return new ResponseEntity<>(updatedCartItem, HttpStatus.OK);
        } catch (CartItemException | UserException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/check")
    public ResponseEntity<CartItem> isCartItemExist(
            @RequestBody Cart cart,
            @RequestBody Product product,
            @RequestParam String size,
            @RequestParam Long userId) throws CartItemException, UserException
    {
        CartItem cartItem = cartItemService.isCartItemExist(cart, product, size, userId);
        if (cartItem != null) {
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<String> removeCartItem(
            //@PathVariable Long userId,
            @PathVariable Long cartItemId
    ) {
        try {
            cartItemService.removeCartItem(cartItemId);
            return new ResponseEntity<>("CartItem removed successfully", HttpStatus.OK);
        } catch (CartItemException | UserException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItem> getCartItem(@PathVariable Long cartItemId) {
        try {
            CartItem cartItem = cartItemService.findCartItemById(cartItemId);
            return new ResponseEntity<>(cartItem, HttpStatus.OK);
        } catch (CartItemException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

