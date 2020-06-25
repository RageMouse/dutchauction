package fhict.dutchauction_backend.controllers;

import fhict.dutchauction_backend.entities.Auction;
import fhict.dutchauction_backend.entities.Product;
import fhict.dutchauction_backend.models.AuctionCreateModel;
import fhict.dutchauction_backend.models.Greeting;
import fhict.dutchauction_backend.models.ProductCreateModel;
import fhict.dutchauction_backend.repositories.AuctionRepository;
import fhict.dutchauction_backend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping(path = "/" )
    public Iterable<Product> products() {
        return productRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> createProduct(@RequestBody ProductCreateModel model) {
        Product product = new Product(model.getProductName(), model.getProductDescription(), model.getMaxPrice(), model.getCategoryId());
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping(path = "/getProducts" )
    public Iterable<Product> productsByAuction(@RequestParam String auctionName) {
        return productRepository.findProductsByAuctionNameLike(auctionName);
    }
}
