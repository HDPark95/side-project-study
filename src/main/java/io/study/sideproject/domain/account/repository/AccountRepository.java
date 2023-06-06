package io.study.sideproject.domain.account.repository;


import io.study.sideproject.domain.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long>, AccountRepositoryCustom {

    Optional<Account> findByUsername(String username);

}
