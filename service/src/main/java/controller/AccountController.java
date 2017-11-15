package controller;

import org.ingenico.vo.ApiRequest;
import org.ingenico.vo.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import service.AccountService;
import vo.AccountVo;

/**
 * 
 * @author Pijush
 * 
 * This class will ac as the 
 * front end Restful service for the account 
 * activities.
 *
 */

@RestController
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    
    @RequestMapping(method=RequestMethod.POST, value="/createMonetaryAccount")
    public ApiResponse createMonetaryAccount(@RequestBody final ApiRequest request){
        AccountVo accountVo = new AccountVo(null, Float.valueOf(request.getAmount()), request.getAccountHolderName()) ;
        return accountService.createMonetaryAccount(accountVo);
    }
    
    @RequestMapping(method=RequestMethod.POST, value="/transferMoney")
    public ApiResponse transferMoney(@RequestBody final ApiRequest request){
        AccountVo sourceAccount = new AccountVo(Long.valueOf(request.getSourceAccount()), null, null);
        AccountVo destinationAccount = new AccountVo(Long.valueOf(request.getDestinationAccount()), null, null);
        return accountService.transferMoney(sourceAccount, destinationAccount, Float.valueOf(request.getAmount()));
    }
}
