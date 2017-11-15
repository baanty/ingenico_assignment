/**
 * 
 */
package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.AccountDao;
import entity.Account;
import requestmodel.ApiResponse;
import vo.AccountVo;

/**
 * @author WE43MM
 * 
 * This service will do the account servicing 
 * functions.
 *
 */
@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;
    
    /**
     * 
     * @param accountVo : The new account to create
     * @return : The <code>ApiResponse</code> object 
     */
    @Transactional
    public ApiResponse createMonetaryAccount(AccountVo accountVo){
        try{
           Account accountEntity = new Account();
           accountEntity.setAccountHolderName(accountVo.getAccountHolderName());
           accountEntity.setBalance(accountVo.getBalance());
           accountDao.save(accountEntity);
           return new ApiResponse("SUCCESS");
        }catch(Exception e){
            return new ApiResponse("FAILURE");
        }
    }
    
    /**
     * 
     * @param sourceAccountVo : The account, from where onety has to be deducted.
     * @param destinationAccountVo : The account, to which money has to be added.
     * @param amount : The amount of money for transfer.
     * @return : The success or failure of the transaction.
     */
    @Transactional
    public ApiResponse transferMoney(AccountVo sourceAccountVo, AccountVo destinationAccountVo, Float amount){
        Account sourceAccount = accountDao.findOne(sourceAccountVo.getAccountNumber());
        Account destinationAccount = accountDao.findOne(destinationAccountVo.getAccountNumber());
        if((null == sourceAccount) ||
           (null == destinationAccount) ||
           (sourceAccount.getBalance() < amount) ){
            return new ApiResponse("FAILURE");
        }
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount );
        accountDao.save(sourceAccount);
        accountDao.save(destinationAccount);
        return new ApiResponse("SUCCESS");
    }
}
