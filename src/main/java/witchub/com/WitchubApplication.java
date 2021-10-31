package witchub.com;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties	// to encrypt database credentials
public class WitchubApplication {

	public static void main(String[] args) {
		SpringApplication.run(WitchubApplication.class, args);
	}

}
