package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Auction {
    @Id
    @GeneratedValue
    private long auctionId;

    @NotNull
    private String auctionName;

    @NotNull
    private String auctionDescription;

    @NotNull
    private Date endDate;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    public Auction(){
    }

    public Auction(String auctionName, String auctionDescription, Date endDate){
        this.auctionName = auctionName;
        this.auctionDescription = auctionDescription;
        this.endDate = endDate;
    }

    public Auction(Long auctionId, String auctionName, String auctionDescription, Date endDate){
        this.auctionId = auctionId;
        this.auctionName = auctionName;
        this.auctionDescription = auctionDescription;
        this.endDate = endDate;
    }
}
