package com.rentshare.repository;

import com.rentshare.model.Advert;
import com.rentshare.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {

    Bid findBidById(Long id);
    List<Bid> findBidsByAdvertId(Long advertId);
    List<Bid> findBidsByUsername(String username);
}
