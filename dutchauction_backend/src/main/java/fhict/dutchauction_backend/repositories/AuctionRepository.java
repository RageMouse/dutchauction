package fhict.dutchauction_backend.repositories;

import fhict.dutchauction_backend.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
