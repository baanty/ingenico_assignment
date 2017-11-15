/**
 * 
 */
package requestmodel;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * @author WE43MM
 *
 */
@Data
public class ApiResponse implements Serializable {

    @NotNull
    private final String apiCallResult;
}
