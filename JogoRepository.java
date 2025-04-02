package br.com.unicuritiba.CadastroJogos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.unicuritiba.CadastroJogos.models.Jogo;
	
	public interface JogoRepository extends JpaRepository<Jogo, Long>{
	}


