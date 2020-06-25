package fhict.dutchauction_backend.entities;

import fhict.dutchauction_backend.DutchauctionBackendApplication;
import fhict.dutchauction_backend.repositories.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DutchauctionBackendApplication.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AccountTest {

    @Autowired
    private AccountRepository accountRepository;


    @Test
    public void newAccountTest() {
        Account account = new Account("john", "johnspassword");
        accountRepository.save(account);

        Account account2 = accountRepository.getOne((long) 1);
        assertEquals("john", account2.getAccountName());
    }
}
