package br.com.wishlist.resource;


import br.com.wishlist.model.Wishlist;
import br.com.wishlist.service.WishlistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api
@RequestMapping(value = "/api/v1")
public class WishlistController {


    @Autowired
    WishlistService service;


    @ApiOperation("Busca todos os items da wishlist de um cliente")
    @GetMapping(value = "/wishlist/{customerId}")
    public List<Wishlist> findAll(@PathVariable String customerId) {
        return service.findAll(customerId);
    }

    @ApiOperation("Inseri um item na wishlist")
    @PostMapping(value = "/wishlist/{customerId}/{productId}")
    public Wishlist insertWish(@PathVariable String customerId, @PathVariable String productId) {
        return service.insertItem(customerId, productId);
    }

    @ApiOperation("Consulta se um item está na wishlist do cliente")
    @GetMapping(value = "/wishlist/{customerId}/{productId}")
    public Wishlist findItemByCustomer(@PathVariable String customerId, @PathVariable String productId) {
        return service.findItemByCustomer(customerId, productId);
    }

    @ApiOperation("Deleta um item da wishlist do cliente")
    @DeleteMapping(value = "/wishlist/{id}")
    public String deleteWish(@PathVariable String id) {
        return service.deleteItem(id);
    }

}
