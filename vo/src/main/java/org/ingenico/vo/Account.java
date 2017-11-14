/**
 * 
 */
package org.ingenico.vo;

import java.io.Serializable;

/**
 * @author WE43MM
 *
 */
public class Account implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7712472935998509936L;
    
    @NotNull
    private Long accountNumber;
    @NotNull
    private Float balance;
    @NotNull
    private String accountHolderName;
}
