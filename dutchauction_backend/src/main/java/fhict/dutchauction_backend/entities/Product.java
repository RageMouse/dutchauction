package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Product {
    @Id
    @GeneratedValue
    private Long productId;

    @NotNull
    private String productName;

    @NotNull
    private String productDescription;

    @NotNull
    private double maxPrice;

    @NotNull
    private String categoryName;

    @NotNull
    private String auctionName;

    public Product(){}

    public Product(String productName, String productDescription, double maxPrice, String categoryName){
        this.productName = productName;
        this.productDescription = productDescription;
        this.maxPrice = maxPrice;
        this.categoryName = categoryName;
    }

    public Product(Long productId, String productName, String productDescription, double maxPrice, String categoryName, String auctionName){
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.maxPrice = maxPrice;
        this.categoryName = categoryName;
        this.auctionName = auctionName;
    }
}
