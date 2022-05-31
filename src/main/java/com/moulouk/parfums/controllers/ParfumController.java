package com.moulouk.parfums.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moulouk.parfums.entities.Categorie;
import com.moulouk.parfums.entities.Parfum;
import com.moulouk.parfums.service.CategorieService;
import com.moulouk.parfums.service.ParfumService;


@Controller
public class ParfumController {
	@Autowired
	ParfumService parfumService;
	@Autowired
	CategorieService categorieService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("parfum", new Parfum());
	modelMap.addAttribute("mode", "new");
	List<Categorie> categorie = categorieService.getAllCategories();

	modelMap.addAttribute("categories", categorie);
	return "formParfum";
	}
	@RequestMapping("/saveParfum")
	public String saveParfum(@Valid Parfum parfum,BindingResult bindingResult)
	{
	if (bindingResult.hasErrors()) return "formParfum";
	
	parfumService.saveParfum(parfum);
	return "redirect:/ListeParfums";
	}
	@RequestMapping("/ListeParfums")
	public String listeParfums(ModelMap modelMap,

	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	Page<Parfum> prods = parfumService.getAllParfumsParPage(page, size);
	modelMap.addAttribute("parfums", prods);

	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	List<Categorie> cats = categorieService.getAllCategories();
	modelMap.addAttribute("categories", cats);

	modelMap.addAttribute("currentPage", page);
	
	
	
	return "listeParfums";
	}
	
	@RequestMapping("/supprimerParfum")
	public String supprimerParfum(@RequestParam("id") Long id,

	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)

	{
	parfumService.deleteParfumById(id);
	Page<Parfum> prods = parfumService.getAllParfumsParPage(page,

	size);

	modelMap.addAttribute("parfums", prods);
	modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	List<Categorie> cats = categorieService.getAllCategories();
	modelMap.addAttribute("categories", cats);
	return "listeParfums";
	}
	
	@RequestMapping("/modifierParfum")
	public String editerParfum(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Parfum p= parfumService.getParfum(id);
		modelMap.addAttribute("parfum", p);
		modelMap.addAttribute("mode", "edit");
		
		List<Categorie> cats = categorieService.getAllCategories();

		modelMap.addAttribute("categories", cats);
		return "formParfum";
	}
	@RequestMapping("/updateParfum")
	public String updateParfum(@ModelAttribute("parfum") Parfum parfum,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException

{
//conversion de la date

SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
Date dateCreation = dateformat.parse(String.valueOf(date));
parfum.setDateCreation(dateCreation);
parfumService.updateParfum(parfum);
List<Parfum> prods = parfumService.getAllParfums();
modelMap.addAttribute("parfums", prods);
List<Categorie> cats = categorieService.getAllCategories();
modelMap.addAttribute("categories", cats);
return "listeParfums";

}
	 @RequestMapping("/chercherNom")
	    public String chercherParfum(@RequestParam("nomParf") String nom,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    
	    
	    {     
		 	
	    	  List <Parfum> prods = parfumService.findByNomParfumContains(nom);
	    	  
	    	  modelMap.addAttribute("Parfums",prods);
	    	  List<Categorie> cats = categorieService.getAllCategories();
	    		modelMap.addAttribute("categories", cats);
	    	  /*Page<Parfum> prod = parfumService.getAllParfumsParPage(page, size);
	    		modelMap.addAttribute("Parfums", prod);

	    		modelMap.addAttribute("pages", new int[prod.getTotalPages()]);

	    		modelMap.addAttribute("currentPage", page);*/
	    	  return "resultat";
	    }  
	
	 @RequestMapping("/chercherCat")
	  public String chercherCat(@RequestParam("idCat") int idCat,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {     
		 	
	    	  List <Parfum> parfums = parfumService.getAllParfums();
	    	  parfums = parfums.stream()
	                  .filter(x -> x.getCategorie().getIdCat() == idCat)
	                  .collect(Collectors.toList());
	    	  modelMap.addAttribute("parfums",parfums);
	    	  List<Categorie> cats = categorieService.getAllCategories();
	    		modelMap.addAttribute("categories", cats);
	    		modelMap.addAttribute("currentPage", page);
	    	  
	    	  return "listeParfums";
	    }  
	    
		  
}