package fhict.dutchauction_backend.entities;

import fhict.dutchauction_backend.DutchauctionBackendApplication;
import fhict.dutchauction_backend.repositories.AuctionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DutchauctionBackendApplication.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuctionTest {

    @Autowired
    private AuctionRepository auctionRepository;


    @Test
    public void givenStudent_whenSave_thenGetOk() {
        Date date = new Date();
        Auction auction = new Auction("10 dozen Erpel", "Erpel speaks for itself.", date);
        auctionRepository.save(auction);

        Auction auction2 = auctionRepository.getOne((long) 1);
        assertEquals("10 dozen Erpel", auction2.getAuctionName());
    }
}
