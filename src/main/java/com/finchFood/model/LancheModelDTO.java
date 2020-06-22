package com.finchFood.model;

import java.io.Serializable;


public class LancheModelDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String nome_lanche;
	
	String item;
	double valorItem;
	
	
	public LancheModelDTO () {
		
	}


	public String getNome_lanche() {
		return nome_lanche;
	}


	public void setNome_lanche(String nome_lanche) {
		this.nome_lanche = nome_lanche;
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
	
	
	

}