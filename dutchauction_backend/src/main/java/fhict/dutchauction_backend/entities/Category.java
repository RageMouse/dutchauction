package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table
public class Category {
    @Id
    @GeneratedValue
    private long categoryId;

    @NotNull
    private String categoryName;

    @OneToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "category_product",
            joinColumns = {@JoinColumn(name = "categoryId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> products;
}
