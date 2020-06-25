package fhict.dutchauction_backend.models;

import com.sun.istack.NotNull;
import fhict.dutchauction_backend.entities.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProductCreateModel {
    private Long productId;
    private String productName;
    private String productDescription;
    private double maxPrice;
    private String categoryId;

    public ProductCreateModel(String productName, String productDescription, double maxPrice, String categoryId) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.maxPrice = maxPrice;
        this.categoryId = categoryId;
    }
}
