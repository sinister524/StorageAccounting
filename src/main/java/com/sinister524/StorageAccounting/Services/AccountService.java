package com.sinister524.StorageAccounting.Services;


import com.sinister524.StorageAccounting.Entity.Users.Account;
import com.sinister524.StorageAccounting.Entity.Users.Role;
import com.sinister524.StorageAccounting.Repos.UsersRepos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public AccountService() {
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByName(s);

        if (account == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return account;
    }

    public Account findAccountById(Long accountId) {
        Optional<Account> accountFromDb = accountRepository.findById(accountId);
        return accountFromDb.orElse(new Account());
    }

    public List<Account> allAccounts() {
        return accountRepository.findAll();
    }

    public boolean saveAccount(Account account) {
        Account accountFromDB = accountRepository.findAccountByName(account.getUsername());

        if (accountFromDB != null) {
            return false;
        }

        account.setRoles(Collections.singleton(Role.ROLE_USER));
        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
        accountRepository.save(account);
        return true;
    }

    public void setAccountRole (Account account, Role role) {

    }
}
