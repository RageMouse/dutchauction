package fhict.dutchauction_backend.repositories;

import fhict.dutchauction_backend.DutchauctionBackendApplication;
import fhict.dutchauction_backend.entities.Auction;
import fhict.dutchauction_backend.entities.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DutchauctionBackendApplication.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private AuctionRepository auctionRepository;

    @Test
    public void findProductsByAuctionNameLike() {
        Date date = new Date();
        Auction auction = new Auction(1L,"Boerenland", "Blablabla", date);
        auctionRepository.save(auction);
        Product product = new Product(1L, "10 kratten aardappelen", "sadauidaod", 22.2, "Food", "Boerenland");
        productRepository.save(product);

        List<Product> products = productRepository.findProductsByAuctionNameLike("Boerenland");

        Product actualProduct = products.get(0);

        assertEquals("10 kratten aardappelen", actualProduct.getProductName());
    }
}