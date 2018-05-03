package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.ApoliceSeguro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ApoliceSeguroDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	@Transactional
	public void salvar(ApoliceSeguro as) {
		em.merge(as);
	}

}
