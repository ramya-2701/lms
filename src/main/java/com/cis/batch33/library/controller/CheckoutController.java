package com.cis.batch33.library.controller;
import com.cis.batch33.library.entity.Checkout;
import com.cis.batch33.library.model.BookDTO;
import com.cis.batch33.library.model.CheckoutDTO;
import com.cis.batch33.library.model.Member;
import com.cis.batch33.library.service.BookService;
import com.cis.batch33.library.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/{id}")
    public CheckoutDTO getData(@PathVariable Integer id){
        return checkoutService.getData(id);
    }
    @PostMapping
    public CheckoutDTO createData(@RequestBody CheckoutDTO checkoutDTO){
        return checkoutService.createCheckout(checkoutDTO);
    }
    @PutMapping("/{id}")
    public CheckoutDTO updateCheckout(@RequestBody CheckoutDTO checkoutDTO,@PathVariable Integer id){
        return checkoutService.updateCheckout(id,checkoutDTO);
    }



}
