package com.finchFood.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finchFood.model.IngredienteModel;
import com.finchFood.repository.IngredienteRepository;
import com.finchFood.response.ResponseModel;

@RestController
@RequestMapping("/service")
public class IngredienteController {
	@Autowired
	private IngredienteRepository ingredienteRepository;

	

	//inserir n
	@RequestMapping(value = "/ingrediente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel salvar(@RequestBody IngredienteModel ingrediente) {
		try {
			this.ingredienteRepository.save(ingrediente);
			return new ResponseModel(0, "Salvo com Sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}

	}

	//atualizar 
	@RequestMapping(value = "/ingrediente", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseModel atualizar(@RequestBody IngredienteModel ingrediente) {

		try {
			this.ingredienteRepository.save(ingrediente);

			return new ResponseModel(0, "Salvo com sucesso");
		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}

	}

	//Selecionar todos Os Passeios
	@RequestMapping(value = "/ingrediente", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	ResponseEntity<Object> consultar() {
		

		return new ResponseEntity<>(this.ingredienteRepository.findAll(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/ingrediente/{id_ingrediente}", method =RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Optional<IngredienteModel> buscar(@PathVariable("id_ingrediente") Integer id_ingrediente) {
		
		return this.ingredienteRepository.findById(id_ingrediente);
	}
	
	
	@RequestMapping(value = "/ingrediente/{id_ingrediente}", method =RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ ResponseBody ResponseModel deletar (@PathVariable("id_ingrediente") Integer id_ingrediente) {
		 Optional<IngredienteModel> ingredienteModel = ingredienteRepository.findById(id_ingrediente);
		 try {
			 
			 ingredienteRepository.deleteById(ingredienteModel.get().getId_ingrediente());
			 
			 return new ResponseModel(1, "Registro deletado");
			 
		 }catch (Exception e) {
			
			 return new ResponseModel(0, e.getMessage());
		}
	}
	
	

	

	
	}


