/**
 * 
 */
package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * @author WE43MM
 *
 */
@Data
@Entity
public class Account implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7712472935998509936L;
    
    @Column(name="ACCOUNT_NUMBER")
    private Long accountNumber;
    
    @Column(name="BALANCE")
    private Float balance;
    
    @Column(name="ACCOUNT_HOLDER_NAME")
    private  String accountHolderName;
}
