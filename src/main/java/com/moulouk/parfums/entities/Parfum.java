package com.moulouk.parfums.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Parfum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParfum;
	@NotNull
	@Size (min = 4,max = 15)
	@Column(unique=true)
	private String nomParfum;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixParfum;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateCreation;
	@ManyToOne
private Categorie categorie;
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Parfum() {
		super();
	}

	public Parfum(String nomParfum, Double prixParfum, Date dateCreation,Categorie cat) {
		super();
		this.nomParfum = nomParfum;
		this.prixParfum= prixParfum;
		this.dateCreation = dateCreation;
		categorie=cat;
	}

	public Long getIdParfum() {
		return idParfum;
	}

	public void setIdParfum(Long idParfum) {
		this.idParfum = idParfum;
	}

	public String getNomParfum() {
		return nomParfum;
	}

	public void setNomParfum(String nomParfum) {
		this.nomParfum = nomParfum;
	}

	public Double getPrixParfum() {
		return prixParfum;
	}

	public void setPrixParfum(Double prixParfum) {
		this.prixParfum = prixParfum;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Parfum [idParfum=" + idParfum + ", nomParfum=" + nomParfum + ", prixParfum=" + prixParfum
				+ ", dateCreation=" + dateCreation + ", categorie=" + categorie + "]";
	}

	
	
	
}