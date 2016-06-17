package br.cesed.facisa.tap.webservice.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id
	private String id;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String curso;
	
	public Aluno() {
	}

	public Aluno(String id, String name, String curso) {
		this.id = id;
		this.name = name;
		this.curso = curso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getcurso() {
		return curso;
	}

	public void setcurso(String curso) {
		this.curso = curso;
	}

}
