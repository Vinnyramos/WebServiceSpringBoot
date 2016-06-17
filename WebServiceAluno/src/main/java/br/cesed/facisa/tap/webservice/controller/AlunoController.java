package br.cesed.facisa.tap.webservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.cesed.facisa.tap.webservice.domain.Aluno;
import br.cesed.facisa.tap.webservice.service.AlunoService;


@RestController
public class AlunoController {

	private final AlunoService alunoService;

	@Autowired
	public AlunoController(final AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@RequestMapping(value="/aluno", method = RequestMethod.GET)
	public ResponseEntity< List<Aluno> > listAllUsers() {
		return new ResponseEntity< List<Aluno> >
		(alunoService.listAllAlunos(), HttpStatus.OK);
	}

	@RequestMapping(value = "/aluno/{id}",method = RequestMethod.GET)
	public ResponseEntity<Aluno> getUser(@PathVariable String id) {
		
		Aluno aluno = alunoService.getById(id);
		
		return aluno == null ? 
				new ResponseEntity<Aluno>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
	}
	
	@RequestMapping(value="/aluno", method = RequestMethod.POST)
	public ResponseEntity<String> createUser(@RequestBody Aluno aluno) {

		try {
			alunoService.save(aluno);
			return new ResponseEntity<String>(HttpStatus.CREATED);

		 } catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/aluno", method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody Aluno participante) {

		try {
			alunoService.upDate(participante);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@RequestMapping(value = "aluno/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> deleteUserPorId(@PathVariable String id) {
		try {
			Aluno aluno = alunoService.getById(id);
			alunoService.deleteById(aluno);
			
			return new ResponseEntity<Aluno>(aluno, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<Aluno>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public AlunoService getUserService() {
		return alunoService;
	}
}
