package com.moulouk.parfums.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.moulouk.parfums.entities.Categorie;
import com.moulouk.parfums.entities.Parfum;
@RepositoryRestResource(path = "rest")
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	@Query("select p from Parfum p where p.nomParfum like %?1 and p.prixParfum > ?2")
	List<Parfum> findByNomPrix (String nom, Double prix);
	/*@Query("select p from Parfum p where p.nomParfum like %:nom and p.prixParfum > :prix")
	List<Parfum> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
*/
	@Query("select p from Parfum p where p.categorie = ?1")
	List<Parfum> findByCategorie (Categorie categorie);
	List<Parfum> findByCategorieIdCat(Long id);
	List<Parfum> findByOrderByNomParfumAsc();
	@Query("select p from Parfum p order by p.nomParfum ASC, p.prixParfum DESC")
	List<Parfum> trierParfumsNomsPrix ();
	 @Query("select p from Parfum p where p.categorie.nomCat like ?1")
	 List<Parfum> findByNomCategorieContains(String nom);

}