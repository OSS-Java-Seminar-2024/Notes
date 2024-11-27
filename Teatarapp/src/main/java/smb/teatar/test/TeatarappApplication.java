package smb.teatar.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TeatarappApplication {

	@RequestMapping("/")
	public String homePage() {
		return "Hello from Theater app!\n";
	}

	public static void main(String[] args) {
		SpringApplication.run(TeatarappApplication.class, args);
	}
}