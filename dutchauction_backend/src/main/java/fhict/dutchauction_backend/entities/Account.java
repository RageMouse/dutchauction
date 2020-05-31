package fhict.dutchauction_backend.entities;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Account {
    @Id
    @GeneratedValue
    private long accountId;

    //Account name
    @NotNull
    private String accountName;

    //Account password
    @NotNull
    private String password;

    @ManyToMany
    @ElementCollection(targetClass = Auction.class)
    public List<Auction> auctions;

    public Account(){
    }

    public Account(String accountName, String password){
        this.accountName = accountName;
        this.password = password;
    }
}
