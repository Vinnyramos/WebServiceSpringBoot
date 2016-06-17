package br.cesed.facisa.tap.webservice.service;

import java.util.List;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.cesed.facisa.tap.webservice.domain.Aluno;
import br.cesed.facisa.tap.webservice.repository.AlunoRepository;

@Service
@Validated
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repository;

    @Autowired
    public AlunoServiceImpl(final AlunoRepository repository) {
        this.repository = repository;
    }
    
    public Aluno getById(String id) {    
    	return repository.findOne(id);
    }
    
	public List<Aluno> listAllAlunos() {
		return repository.findAll();
	}
	
    @Transactional
    public Aluno save(@NotNull @Valid final Aluno participant) {
    	
        Aluno existing;
        boolean idAluno = repository.exists(participant.getId());
        
        if (idAluno) {
        	existing = null;
        	System.out.println("Id ja existe inserir outro id");
			}
        else{
            existing = repository.save(participant);
            }
        
    return existing;
    }      	
       
       

	public AlunoRepository getRepository() {
		return repository;
	}

	@Transactional
	public void deleteById(final Aluno participante) {
		Aluno existing = repository.findOne(participante.getId());
		if(existing != null)
		{repository.delete(participante);
		}
		
	}

	@Transactional
	public void upDate(final Aluno participante) {
		Aluno existing = repository.findOne(participante.getId()); 
		if(existing != null)
		{  repository.save(participante);
		}
		 
	}
}
