package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Auction {
    @Id
    @Getter
    @Setter
    @GeneratedValue
    private long auctionId;

    @Getter
    @Setter
    @NotNull
    private String auctionName;

    @Getter
    @Setter
    @NotNull
    private String auctionDescription;

    @Getter
    @Setter
    @NotNull
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @ElementCollection(targetClass = Category.class)
    private List<Category> categories;

    public Auction(){
    }

    public Auction(Long auctionId, String auctionName, String auctionDescription, Date endDate){
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.auctionDescription = auctionDescription;
        this.endDate = endDate;
    }
}
