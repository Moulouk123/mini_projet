package com.moulouk.parfums.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.moulouk.parfums.entities.Categorie;
import com.moulouk.parfums.entities.Parfum;

public interface ParfumService {

	Parfum saveParfum(Parfum p);
	Parfum updateParfum(Parfum p);
	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	Parfum getParfum(Long id);
	List<Parfum> getAllParfums();
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByCategorie (Categorie categorie);
	List<Parfum> findByCategorieIdCat(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	List<Parfum> trierParfumsNomsPrix();
	List<Parfum> findByNomCategorieContains (String nom);

	
	
	Page<Parfum> getAllParfumsParPage(int page, int size);
}
