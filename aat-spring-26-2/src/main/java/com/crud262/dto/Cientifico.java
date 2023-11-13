package com.crud262.dto;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name="cientificos")
public class Cientifico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre ;
	
	 	@ManyToMany(cascade = { CascadeType.ALL })
	    @JoinTable(
	        name = "cientificos_proyectos",
	        joinColumns = { @JoinColumn(name = "cientifico_id") },
	        inverseJoinColumns = { @JoinColumn(name = "proyecto_id") }
	    )
	    	    
	    @JsonIgnoreProperties("cientificos")
	 
	 private List<Proyecto> proyectos;
	
	public Cientifico() {
	}

	public Cientifico(int id, String nombre, List<Proyecto> proyectos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.proyectos = proyectos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	
	

}
