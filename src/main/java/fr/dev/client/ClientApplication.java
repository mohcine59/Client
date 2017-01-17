package fr.dev.client;

import fr.dev.client.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.dev.client.dao.ProduitRepository;

@SpringBootApplication
public class ClientApplication implements CommandLineRunner{

	@Autowired
	private ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		produitRepository.save(new Produit("PC11", 400, 5));
		produitRepository.save(new Produit("PC22", 500, 3));
		produitRepository.save(new Produit("PC33", 600, 12));
		produitRepository.save(new Produit("PC44", 700, 15));
		
	}
	
	
}
