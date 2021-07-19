package br.com.wishlist.service.impl;

import br.com.wishlist.model.Wishlist;
import br.com.wishlist.repository.WishlistRepository;
import br.com.wishlist.resource.exception.UnauthorizedException;
import br.com.wishlist.service.WishlistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class WishlistServiceImpl implements WishlistService {


    @Autowired
    WishlistRepository repository;

    @Override
    public List<Wishlist> findAll(String customerId) {
        return repository.findByCustomerId(customerId);
    }

    @Override
    public Wishlist insertItem(String customerId, String productId) {
        checkWishlistSize(customerId);
        checkCustomerItem(customerId, productId);
        Wishlist wishlist = new Wishlist();
        wishlist.setCustomerId(customerId);
        wishlist.setProductId(productId);
        return repository.save(wishlist);
    }

    @Override
    public String deleteItem(String id) {
        repository.deleteById(id);
        return "Item deletado com sucesso";
    }

    @Override
    public Wishlist findItemByCustomer(String customerId, String productId) {
        Wishlist wishlist = repository.findByCustomerIdAndProductId(customerId, productId);
        if(wishlist != null) {
            return wishlist;
        } else {
            return null;
        }
    }

    private void checkWishlistSize(String customerId) {
        List<Wishlist> wishlist = findAll(customerId);
        if(wishlist.size() == 20) {
            throw new UnauthorizedException("Wishlist do cliente atingiu o maximo de itens.");
        }
    }

    private void checkCustomerItem(String customerId, String productId) {
        Wishlist wishlist = findItemByCustomer(customerId, productId);
        if(wishlist != null) {
            throw new UnauthorizedException("Item ja cadastrado na wishlist do cliente");
        }
    }


}
