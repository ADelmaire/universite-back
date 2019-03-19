package fr.delmaire.universite.enseignant.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.delmaire.universite.matiere.domain.Matiere;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Enseignant implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="ID")
	private Integer id;

	@Column(name="NUMERO_ENSEIGNANT")
	private Integer numero;

	@Column(name="NOM")
	private String nom;

	@Column(name="PRENOM")
	private String prenom;

	@Column(name="DATE_NAISSANCE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateNaissance;

	@Column(name="SEXE")
	private Character sexe;

	@Column(name="GRADE")
	private String grade;

	@Column(name="DATE_EMBAUCHE")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date DateEmbauche;
	
	@Column(name="PHOTO")
	private String photo;
	
	@OneToMany(mappedBy="enseignant")
	@JsonIgnore
	private List<Matiere>matieres;


	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Character getSexe() {
		return sexe;
	}
	public void setSexe(Character sexe) {
		this.sexe = sexe;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getDateEmbauche() {
		return DateEmbauche;
	}
	public void setDateEmbauche(Date dateEmbauche) {
		DateEmbauche = dateEmbauche;
	}

}
