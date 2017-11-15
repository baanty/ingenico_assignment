package service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import dao.AccountDao;
import junit.framework.TestCase;
import requestmodel.ApiResponse;
import vo.AccountVo;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest extends TestCase {
    
    @Mock
    private AccountDao accountDao;
    
    @InjectMocks
    private AccountService accountService = new AccountService();
    
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateMonetaryAccount() {
        ApiResponse result = accountService.createMonetaryAccount(new AccountVo(1L, 9.0F, "David"));
        assertEquals("SUCCESS",result.getApiCallResult());
    }

    @Test
    public void testTransferMoney() {
        ApiResponse result = accountService.transferMoney((new AccountVo(1L, 9.0F, "David")) , new AccountVo(1L, 9.0F, "David"), 199F);
        assertEquals("FAILURE",result.getApiCallResult());
    }

}
