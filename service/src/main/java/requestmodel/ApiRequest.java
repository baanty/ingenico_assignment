/**
 * 
 */
package requestmodel;

import javax.validation.constraints.NotNull;

import enums.RequestType;

import lombok.Data;

/**
 * @author WE43MM
 *
 */
@Data
public class ApiRequest {

    @NotNull
    private final RequestType requestType;
    
    @NotNull
    private  final String sourceAccount;
    
    @NotNull
    private  final String destinationAccount;
    
    @NotNull
    private  final String amount;
    
    @NotNull
    private final String accountHolderName;
    
}
