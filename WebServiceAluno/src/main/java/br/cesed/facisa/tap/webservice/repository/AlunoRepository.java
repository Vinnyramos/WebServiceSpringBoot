package br.cesed.facisa.tap.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.cesed.facisa.tap.webservice.domain.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

	public Aluno findByName(String name);
	
}
