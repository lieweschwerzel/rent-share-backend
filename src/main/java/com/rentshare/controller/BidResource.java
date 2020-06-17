package com.rentshare.controller;

import com.rentshare.model.Bid;
import com.rentshare.repository.BidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bid")
public class BidResource {

    @Autowired
    BidRepository bidRepository;

    @GetMapping(value = "/all")
    public List<Bid> getAll() {
        return bidRepository.findAll();
    }

    @RequestMapping(value="/save",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<?> persistResource(@RequestBody final Bid bid) {
        bidRepository.save(bid);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(bid, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateResource(@RequestBody Bid updatedBid,
                                            @PathVariable("id") Long id) {
        Bid existingBid = bidRepository.findBidById(id);

        if (existingBid != null) {
            Bid bid = new Bid();
            bid.setId(id);
            bid.setAdvertId(updatedBid.getAdvertId());
            bid.setUsername(updatedBid.getUsername());
            bid.setAmount(updatedBid.getAmount());
            bid.setCreatedOn(updatedBid.getCreatedOn());

            bidRepository.save(bid);
            return ResponseEntity.ok("resource updated");
        }

        return ResponseEntity.ok("resource NOT updated, ID doesnt exist");

    }

    @GetMapping(value = "/delete")
    public ResponseEntity<?> deleteAll() {
        bidRepository.deleteAll();
        return ResponseEntity.ok("all bids deleted");
    }

    @GetMapping(value = "/search/advertId/{advertId}")
    public List<Bid> findByAdvertId(@PathVariable("advertId") Long advertId) {
        return bidRepository.findBidsByAdvertId(advertId);
    }

    @GetMapping(value = "/search/username/{username}")
    public List<Bid> findByUsername(@PathVariable("username") String username) {
        return bidRepository.findBidsByUsername(username);
    }

}
