package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Product {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private Long productId;

    @Getter
    @Setter
    @NotNull
    private String productName;

    @Getter
    @Setter
    @NotNull
    private String productDescription;

    @Getter
    @Setter
    @NotNull
    private double maxPrice;

    public Product(){}

    public Product(Long productId, String productName, String productDescription, double maxPrice){
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.maxPrice = maxPrice;
    }
}
