package br.com.wishlist.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;

@Document(collection = "wishlist")
@Entity
@Data
@NoArgsConstructor
public class Wishlist {

    @Id
    private String id;
    private String customerId;
    private String productId;

}
