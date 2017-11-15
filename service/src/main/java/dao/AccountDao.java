package dao;

import org.springframework.data.repository.CrudRepository;

import entity.Account;

public interface AccountDao extends CrudRepository<Account, Long> {}
