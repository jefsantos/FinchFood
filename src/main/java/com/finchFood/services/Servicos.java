package com.finchFood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.finchFood.model.IngredienteModel;
import com.finchFood.model.LancheModel;
import com.finchFood.model.LancheModelDTO;
import com.finchFood.repository.IngredienteRepository;
import com.finchFood.repository.LancheRepository;

@Service
public class Servicos {
	
	@Autowired
	LancheRepository lancheRepository;
	
	@Autowired
	IngredienteRepository ingredienteRepository;
	
	
	LancheModel ListaDeIngredientes = new LancheModel();

	
	
	public LancheModel salvaLancheComItens(LancheModelDTO obj) {
		LancheModel lm = new LancheModel(null, obj.getNome_lanche());
		IngredienteModel im = new IngredienteModel(null, obj.getItem(), obj.getValorItem() );
		
		im.getLanches().add(lm);
		
		lm.getIngredientes().add(im);
		
		
		
		return lm;
	}

	 public  LancheModel salvar(LancheModel obj) {
		 obj.setId_lanche(null);
		 lancheRepository.save(obj);
		 ingredienteRepository.saveAll(obj.getIngredientes());
	        return obj;
	    }
		
	 


	




	

}
