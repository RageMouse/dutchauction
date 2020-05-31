package fhict.dutchauction_backend.controllers;

import com.sun.net.httpserver.Authenticator;
import fhict.dutchauction_backend.entities.Account;
import fhict.dutchauction_backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @CrossOrigin(origins = "http://localhost:8088", allowedHeaders = "*" , methods = RequestMethod.POST)
    @PostMapping("/createProfile")
    public @ResponseBody
    ResponseEntity<?> createAccount(@RequestParam String accountName, @RequestParam String password){
        if (accountName == null){
            return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
        }

        Account account = new Account(accountName, password);
        accountRepository.save(account);

        return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);
    }
}
