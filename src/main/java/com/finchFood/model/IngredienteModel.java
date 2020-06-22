package com.finchFood.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="INGREDIENTES")
public class IngredienteModel implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_ingrediente;
	String item;
	double valorItem;
	
//	@JsonManagedReference
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="INGREDIENTES_LANCHES",joinColumns = @JoinColumn(name="id_ingrediente"), inverseJoinColumns = @JoinColumn(name="id_lanche"))
	private List<LancheModel> lanches = new ArrayList<>();

	
	public IngredienteModel() {
		
	}
	public IngredienteModel(Integer id_ingrediente, String item, double valorItem) {
		super();
		this.id_ingrediente = id_ingrediente;
		this.item = item;
		this.valorItem = valorItem;
	}

	public Integer getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(Integer id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getValorItem() {
		return valorItem;
	}

	public void setValorItem(double valorItem) {
		this.valorItem = valorItem;
	}

	public List<LancheModel> getLanches() {
		return lanches;
	}

	public void setLanches(List<LancheModel> lanches) {
		this.lanches = lanches;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_ingrediente == null) ? 0 : id_ingrediente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredienteModel other = (IngredienteModel) obj;
		if (id_ingrediente == null) {
			if (other.id_ingrediente != null)
				return false;
		} else if (!id_ingrediente.equals(other.id_ingrediente))
			return false;
		return true;
	}
	
	
	
	
}
