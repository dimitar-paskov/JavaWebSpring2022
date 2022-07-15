package bg.softuni.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Sp2022L06CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sp2022L06CacheApplication.class, args);
	}

}
