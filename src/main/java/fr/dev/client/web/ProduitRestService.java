package fr.dev.client.web;

import java.util.List;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.dev.client.dao.ProduitRepository;
import fr.dev.client.entities.Produit;

@RestController
public class ProduitRestService {

	@Autowired
	private ProduitRepository produitRepository;
	
	@RequestMapping(value="/produits", method=RequestMethod.GET)
	public List<Produit> getProduits(){
		return produitRepository.findAll();
	}

	@RequestMapping(value="/produits/{id}", method=RequestMethod.GET)
	public Produit getProduit(@PathVariable(name="id") Long id){
		return produitRepository.findOne(id);
	}
	
	@RequestMapping(value="/produits", method=RequestMethod.POST)
	public Produit save(@RequestBody Produit produit){
		return produitRepository.save(produit);
	}
	
	//Il faut que l'id soit definit dans l'objet
	//sinon, il faut ajouter une variable id dans l'url et ajouter l'id a l'objet avant de save !
	//@RequestMapping(value="/produits/{id}", method=RequestMethod.PUT)
	@RequestMapping(value="/produits", method=RequestMethod.PUT)
	public Produit update(@RequestBody Produit produit){
		return produitRepository.save(produit);
	}
	
	//Si on definit pas le @RequestParam => name = nom de l'attribut
	@RequestMapping(value="/chercher", method=RequestMethod.GET)
	public Page<Produit> chercher(
			@RequestParam(name="mc", defaultValue="") String mc, 
			@RequestParam(name="page", defaultValue="0") int page, 
			@RequestParam(name="size", defaultValue="5") int size){
		return produitRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
}
