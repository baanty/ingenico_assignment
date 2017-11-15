/**
 * 
 */
package loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import config.AppConfiguration;

/**
 * @author WE43MM
 *
 */
@SpringBootApplication(scanBasePackageClasses={AppConfiguration.class})
public class ContextLoader {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(ContextLoader.class, args);

    }

}
