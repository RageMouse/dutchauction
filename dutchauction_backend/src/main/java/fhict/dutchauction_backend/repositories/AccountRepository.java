package fhict.dutchauction_backend.repositories;

import fhict.dutchauction_backend.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
