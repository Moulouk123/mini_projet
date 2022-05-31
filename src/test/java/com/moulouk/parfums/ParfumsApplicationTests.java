package com.moulouk.parfums;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.moulouk.parfums.entities.Categorie;
import com.moulouk.parfums.entities.Parfum;
import com.moulouk.parfums.repos.ParfumRepository;
import com.moulouk.parfums.service.ParfumService;

@SpringBootTest
class ParfumsApplicationTests {
	@Autowired
	private ParfumRepository parfumRepository;
	@Autowired
	private ParfumService parfumService ;

	/*@Test
	public void testCreateParfum() {
		Parfum prod = new Parfum("PARR", 2200.500, new Date());
		parfumRepository.save(prod);
	}*/
	
	@Test
	public void testFindParfum() {
		Parfum p = parfumRepository.findById(1L).get();

		System.out.println(p);
	}

	@Test
	public void testUpdateParfum() {
		Parfum p = parfumRepository.findById(1L).get();
		p.setPrixParfum(1000.0);
		parfumRepository.save(p);
	}
	
	@Test
	public void testDeleteParfum() {
		parfumRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousParfums() {
		List<Parfum> prods = parfumRepository.findAll();
		for (Parfum p : prods) {
			System.out.println(p);
		}

	}
	@Test
	public void testfindByCategorie()
	{
	Categorie cat = new Categorie();
	cat.setIdCat(1L);
	List<Parfum> prods = parfumRepository.findByCategorie(cat);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindByNomParfumContains1()
	{
	Page<Parfum> prods = parfumService.getAllParfumsParPage(0,2);
	System.out.println(prods.getSize());
	System.out.println(prods.getTotalElements());
	System.out.println(prods.getTotalPages());
	prods.getContent().forEach(p -> {System.out.println(p.toString());
	});
	/*ou bien
	for (Parfum p : prods)
	{
	System.out.println(p);
	} */
	}
	@Test
	public void testFindByNomParfum()
	{
	List<Parfum> prods = parfumRepository.findByNomParfum("BOSS");

	for (Parfum p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void testFindByNomParfumContains ()
	{
	List<Parfum> prods=parfumRepository.findByNomParfumContains("BOSS");

	for (Parfum p : prods)
	{
	System.out.println(p);
	} }
	@Test
	public void testfindByNomPrix()
	{
	List<Parfum> prods = parfumRepository.findByNomPrix("BOSS", 220.5);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}

	}
	@Test
	public void findByCategorieIdCat()
	{
	List<Parfum> prods = parfumRepository.findByCategorieIdCat(1L);
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	 }
	@Test
	public void testfindByOrderByNomParfumAsc()
	{
	List<Parfum> prods = 
	parfumRepository.findByOrderByNomParfumAsc();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	@Test
	public void testTrierParfumsNomsPrix()
	{
	List<Parfum> prods = parfumRepository.trierParfumsNomsPrix();
	for (Parfum p : prods)
	{
	System.out.println(p);
	}
	}
	
	
}