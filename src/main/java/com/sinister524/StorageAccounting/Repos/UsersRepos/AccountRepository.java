package com.sinister524.StorageAccounting.Repos.UsersRepos;

import com.sinister524.StorageAccounting.Entity.Users.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByName(String name);
}
