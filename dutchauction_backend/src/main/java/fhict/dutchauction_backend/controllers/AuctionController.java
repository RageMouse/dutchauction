package fhict.dutchauction_backend.controllers;

import fhict.dutchauction_backend.entities.Auction;
import fhict.dutchauction_backend.models.AuctionCreateModel;
import fhict.dutchauction_backend.models.Greeting;
import fhict.dutchauction_backend.repositories.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
@RequestMapping(value = "/auction")
public class AuctionController {
    @Autowired
    AuctionRepository auctionRepository;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping(path = "/" )
    public Iterable<Auction> auctions() {
        return auctionRepository.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<?> createAuction(@RequestBody AuctionCreateModel auctionCreateModel) {
        if (auctionCreateModel.getAuctionName() == null || auctionCreateModel.getAuctionDescription() == null || auctionCreateModel.getEndDate() == null) {
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }
        Auction auction = new Auction(auctionCreateModel.getAuctionName(), auctionCreateModel.getAuctionDescription(), auctionCreateModel.getEndDate());
        auctionRepository.save(auction);
        return new ResponseEntity<>(auction, HttpStatus.CREATED);
    }


}
