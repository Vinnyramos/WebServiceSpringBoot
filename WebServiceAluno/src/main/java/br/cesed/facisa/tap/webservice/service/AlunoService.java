package br.cesed.facisa.tap.webservice.service;

import java.util.List;
import br.cesed.facisa.tap.webservice.domain.Aluno;

public interface AlunoService {

	Aluno save(Aluno aluno);

	Aluno getById(String id);
	
	List<Aluno> listAllAlunos();
	
	void deleteById(Aluno aluno);
	
	void upDate(Aluno aluno);
}
