package fr.adaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.adaming.services.IRoleService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

//	@Autowired
//	IRoleService roleServ;
	
//	@Autowired
//	IAnimalService animalServ;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Override en marche");
		
//		Role r = new Role();
//		r.setLibelle("félins");
//		roleServ.saveRole(r);
	}

}
