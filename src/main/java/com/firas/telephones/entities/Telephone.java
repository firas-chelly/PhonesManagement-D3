package com.firas.telephones.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telephone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTel;
	private String marqueTel;
	private Double prixTel;
	private Date dateCreation;
	
	@ManyToOne
	private Company company;
	
	
	
	public Telephone() {
		super();
	}
	
	
	
	public Telephone(String marqueTel, Double prixTel, Date dateCreation) {
		super();
		this.marqueTel = marqueTel;
		this.prixTel = prixTel;
		this.dateCreation = dateCreation;
	}



	public Long getIdTel() {
		return idTel;
	}
	public void setIdTel(Long idTel) {
		this.idTel = idTel;
	}
	public String getMarqueTel() {
		return marqueTel;
	}
	public void setMarqueTel(String marqueTel) {
		this.marqueTel = marqueTel;
	}
	public Double getPrixTel() {
		return prixTel;
	}
	public void setPrixTel(Double prixTel) {
		this.prixTel = prixTel;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	@Override
	public String toString() {
		return "Telephone [idTel=" + idTel + ", marqueTel=" + marqueTel + ", prixTel=" + prixTel + ", dateCreation="
				+ dateCreation + "]";
	}



	public Company getCompany() {
		return company;
	}



	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	

}
