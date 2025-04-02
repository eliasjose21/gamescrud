package br.com.unicuritiba.CadastroJogos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.unicuritiba.CadastroJogos.models.Jogo;
import br.com.unicuritiba.CadastroJogos.repositories.JogoRepository;

@RestController
public class JogoController {
	
	@Autowired
	JogoRepository repository;
	
	@GetMapping("/jogos")
	public ResponseEntity<List<Jogo>> getJogos(){
		return ResponseEntity.ok(repository.findAll());	
	}

	
	@PostMapping("/jogos")
	public ResponseEntity<Jogo> saveJogos(
			@RequestBody Jogo jogo){
		Jogo jogoSalvo = repository.save(jogo);
		return ResponseEntity.ok(jogoSalvo);
	}
	
	@PutMapping("/jogos/{id}")
	public ResponseEntity<Jogo> updateJogo(@PathVariable long id, @RequestBody Jogo jogo) {
		  	jogo.setId(id);
		    Jogo jogoAtualizado = repository.save(jogo);
		    return ResponseEntity.ok(jogoAtualizado);
		}

	
	@DeleteMapping("/jogos/{id}")
	public void removeJogo(@PathVariable long id) {
		 repository.deleteById(id);
	}
	
}
