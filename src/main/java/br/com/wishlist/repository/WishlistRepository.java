package br.com.wishlist.repository;

import br.com.wishlist.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WishlistRepository extends MongoRepository<Wishlist, String> {


    List<Wishlist> findByCustomerId(String customerId);

    Wishlist findByCustomerIdAndProductId(String customerId, String productId);

}
