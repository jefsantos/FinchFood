package com.finchFood.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finchFood.model.LancheModel;
import com.finchFood.model.LancheModelDTO;
import com.finchFood.repository.LancheRepository;
import com.finchFood.response.Response;
import com.finchFood.response.ResponseModel;
import com.finchFood.services.Servicos;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/service/lanche")
public class LancheController {

	@Autowired
	private LancheRepository lancheRepository;

	@Autowired
	Servicos servicos;

	@ApiOperation(value = "Cadastrar um novo Lanche", response = ResponseModel.class, notes = "Essa operação salva um novo lanche e seus componentes.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um ResponseModel / Response  com uma mensagem de sucesso", response = ResponseModel.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseModel com a Exception", response = ResponseModel.class)

	})

	@PostMapping
	public @ResponseBody ResponseEntity<Response<LancheModel>> salvar(@RequestBody LancheModel lanche,
			BindingResult result)

	{
		Response<LancheModel> response = new Response<LancheModel>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);

		}

		this.lancheRepository.save(lanche);
		response.setData(lanche);

		return ResponseEntity.ok(response);

	}

	@PutMapping(value = "/{codigo}")
	public @ResponseBody ResponseModel atualizar(@RequestBody LancheModel lanche, @PathVariable Integer codigo) {

		try {

			this.lancheRepository.save(lanche);

			return new ResponseModel(1, "Registro atualizado com sucesso!");

		} catch (Exception e) {

			return new ResponseModel(0, e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity<Object> consultar() {

		return new ResponseEntity<>(this.lancheRepository.findAll(), HttpStatus.OK);

	}

	@GetMapping(value = "/{codigo}")
	public @ResponseBody ResponseEntity<LancheModel> buscar(@PathVariable("codigo") Integer codigo) {

		return lancheRepository.findById(codigo).map(record -> ResponseEntity.ok().body(record))

				.orElse(ResponseEntity.notFound().build());

	}

	@DeleteMapping(value = "/{codigo}")
	public @ResponseBody ResponseModel excluir(@PathVariable("codigo") Integer codigo) {

		Optional<LancheModel> lancheModel = lancheRepository.findById(codigo);

		try {

			lancheRepository.deleteById(codigo);

			return new ResponseModel(1, "Registro excluido com sucesso!");

		} catch (Exception e) {
			return new ResponseModel(0, e.getMessage());
		}
	}

	@PostMapping("/novo")
	public @ResponseBody ResponseEntity<Response<LancheModelDTO>> salvaLanche(@RequestBody LancheModelDTO lancheDto,
			BindingResult result)

	{
		Response<LancheModelDTO> response = new Response<LancheModelDTO>();

		LancheModel obj = servicos.salvaLancheComItens(lancheDto);

		obj = servicos.salvar(obj);

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);

		}

		response.setData(lancheDto);

		return ResponseEntity.ok(response);

	}

}