package com.moulouk.parfums.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Categorie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idCat;
@NotNull
@Size (min = 4,max = 50)
@Column(unique=true)
private String nomCat;
private String descriptionCat;
@JsonIgnore
@OneToMany(mappedBy = "categorie")
private List<Parfum> parfums;
public Categorie() {}
public Categorie(String nomCat, String descriptionCat, List<Parfum> parfums)
{

super();
this.nomCat = nomCat;
this.descriptionCat = descriptionCat;
this.parfums = parfums;
}
public Long getIdCat() {
return idCat;
}
public void setIdCat(Long idCat) {
this.idCat = idCat;
}
public String getNomCat() {
return nomCat;
}
public void setNomCat(String nomCat) {
this.nomCat = nomCat;
}
public String getDescriptionCat() {
return descriptionCat;
}
public void setDescriptionCat(String descriptionCat) {
this.descriptionCat = descriptionCat;
}
public List<Parfum> getProduits() {
return parfums;
}
public void setProduits(List<Parfum> parfums) {
this.parfums = parfums;
}
}
