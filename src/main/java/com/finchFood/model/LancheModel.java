package com.finchFood.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "LANCHES")
public class LancheModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_lanche;
	String nome_lanche;

	double soma = 0.0;
	double somaPromocaoLight = 0.0;
	String todosItens = "";

	@ManyToMany(mappedBy = "lanches")
	private List<IngredienteModel> ingredientes = new ArrayList<>();

	public LancheModel() {

	}

	public LancheModel(Integer id_lanche, String nome_lanche) {
		super();
		this.id_lanche = id_lanche;
		this.nome_lanche = nome_lanche;

	}

	public double getTotalDoLanche() {
		int quantidadeCarne = 0;
		int quantidadeQueijo = 0;

		for (IngredienteModel in : ingredientes) {
			soma = soma + in.getValorItem();

			todosItens = todosItens + "-" + in.getItem();
			System.out.println(todosItens);

			if (!todosItens.contains("bacon") && todosItens.contains("alface")) {
				somaPromocaoLight = soma - (soma * 10) / 100;
				return somaPromocaoLight;

			}

			while (todosItens.contains("hamburguer")) {
				double promoMuitaCarne = 0.0;
				double aplicaDesconto = in.getValorItem();
				quantidadeCarne = quantidadeCarne + in.getItem().length() / 10;

				System.out.println("Seu Lanche tem: " + quantidadeCarne + " Hamburguers");

				for (int i = 0; i < in.getItem().length(); i++) {
					while (quantidadeCarne % 3 == 0) {
						promoMuitaCarne = soma - aplicaDesconto;
						return promoMuitaCarne;
					}
				}

				break;

			}
			while (todosItens.contains("queijo")) {
				double promoMuitoQueijo = 0.0;
				double aplicaDesconto = in.getValorItem();
				quantidadeQueijo = quantidadeQueijo + in.getItem().length() / 10;


				for (int i = 0; i < in.getItem().length(); i++) {
					while (quantidadeCarne % 3 == 0) {
						promoMuitoQueijo = soma + aplicaDesconto;
						return promoMuitoQueijo;
					}
				}

				break;

			}

		}

		return soma;
	}

	public Integer getId_lanche() {
		return id_lanche;
	}

	public void setId_lanche(Integer id_lanche) {
		this.id_lanche = id_lanche;
	}

	public String getNome_lanche() {
		return nome_lanche;
	}

	public void setNome_lanche(String nome_lanche) {
		this.nome_lanche = nome_lanche;
	}

	public List<IngredienteModel> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredienteModel> ingredientes) {
		this.ingredientes = ingredientes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_lanche == null) ? 0 : id_lanche.hashCode());
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
		LancheModel other = (LancheModel) obj;
		if (id_lanche == null) {
			if (other.id_lanche != null)
				return false;
		} else if (!id_lanche.equals(other.id_lanche))
			return false;
		return true;
	}

}

