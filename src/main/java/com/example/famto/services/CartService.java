package com.example.famto.services;

import com.example.famto.entity.Cart;
import com.example.famto.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(int id) {
        return cartRepository.findById(id);
    }

    public Cart addCart(Cart cart) {
        // Perform any necessary validations
        // Save the cart entity
        return cartRepository.save(cart);
    }

    public Cart updateCart(int id, Cart cart) {
        // Perform any necessary validations
        // Update the cart entity with the provided ID
        cart.setId(id);
        return cartRepository.save(cart);
    }

    public void deleteCart(int id) {
        // Delete the cart entity with the provided ID
        cartRepository.deleteById(id);
    }
}

