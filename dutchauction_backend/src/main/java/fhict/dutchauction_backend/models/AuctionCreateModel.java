package fhict.dutchauction_backend.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AuctionCreateModel {
    private String auctionName;
    private String auctionDescription;
    private Date endDate;

    public AuctionCreateModel(String auctionName, String auctionDescription, Date endDate) {
        this.auctionName = auctionName;
        this.auctionDescription = auctionDescription;
        this.endDate = endDate;
    }
}
