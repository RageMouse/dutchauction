package fhict.dutchauction_backend.repositories;

import fhict.dutchauction_backend.entities.Auction;
import fhict.dutchauction_backend.entities.Category;
import fhict.dutchauction_backend.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
//    @Query("SELECT p FROM Product p INNER JOIN Auction a ON p.auctionId = a.auctionId WHERE a.auctionName LIKE %:auctionName% GROUP BY p.categoryName ORDER BY p.categoryName ASC")

//    @Query("SELECT a.accountName FROM Account a ORDER BY a.accountName ASC")
    
    List<Product> findProductsByAuctionNameLike(@Param("auctionName")String auctionName);
}
