package com.moulouk.parfums.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moulouk.parfums.entities.Categorie;
import com.moulouk.parfums.entities.Parfum;
import com.moulouk.parfums.repos.ParfumRepository;

@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	ParfumRepository parfumRepository;

	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public Parfum updateParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
	}

	@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
	}

	@Override
	public Parfum getParfum(Long id) {
		return parfumRepository.findById(id).get();
	}

	@Override
	public List<Parfum> getAllParfums() {
		return parfumRepository.findAll();
	}
	
	@Override
	public Page<Parfum> getAllParfumsParPage(int page, int size) {
	return parfumRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Parfum> findByNomParfum(String nom) {
		// TODO Auto-generated method stub
		return parfumRepository.findByNomParfum(nom);
	}

	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
		// TODO Auto-generated method stub
		return  parfumRepository.findByNomParfumContains(nom);
	}

	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
		// TODO Auto-generated method stub
		return parfumRepository.findByNomPrix(nom, prix);

	}

	@Override
	public List<Parfum> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return  parfumRepository.findByCategorie(categorie);
	}

	@Override
	public List<Parfum> findByCategorieIdCat(Long id) {
		// TODO Auto-generated method stub
		return parfumRepository.findByCategorieIdCat(id);

	}

	@Override
	public List<Parfum> findByOrderByNomParfumAsc() {
		// TODO Auto-generated method stub
		return parfumRepository.findByOrderByNomParfumAsc();

	}

	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		// TODO Auto-generated method stub
		return parfumRepository.trierParfumsNomsPrix();
	}
	@Override
	public List<Parfum> findByNomCategorieContains(String categorie) {
		
		return parfumRepository.findByNomCategorieContains(categorie);
	}
}
