package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Account;

public interface AccountDao extends JpaRepository<Account, Long> {

    /**
     * 
     * @param account : Creates account with the given object
     */
    public void saveAccount(Account account);
    
    /** 
     * 
     * @param account : Updates the given account Object
     */
    public void updateAccount(Account account);
}
