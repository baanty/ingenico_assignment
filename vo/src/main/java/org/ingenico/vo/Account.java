/**
 * 
 */
package org.ingenico.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author WE43MM
 *
 */
@Data
public class Account implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7712472935998509936L;
    
    @NotNull
    private final Long accountNumber;
    @NotNull
    private  final Float balance;
    @NotNull
    private  final String accountHolderName;
}
