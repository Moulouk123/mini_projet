package com.moulouk.parfums.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.moulouk.parfums.entities.Categorie;


public interface CategorieService {
	List<Categorie> getAllCategories();

	Categorie saveCategorie(Categorie categorie);
	Page<Categorie> getAllCategoriesParPage(int page, int size);
	void deleteCategorieById(Long id);
	Categorie getCategorie(Long id);
	
	Categorie updateCategorie(Categorie c);
}
