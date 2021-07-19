package br.com.wishlist.service;

import br.com.wishlist.model.Wishlist;

import java.util.List;

public interface WishlistService {

    List<Wishlist> findAll(String customerId);

    Wishlist insertItem(String customerId, String productId);

    String deleteItem(String id);

    Wishlist findItemByCustomer(String customerId, String productId);

}
