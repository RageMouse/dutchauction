package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class Category {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private long categoryId;

    @Getter
    @Setter
    @NotNull
    private String categoryName;
}
