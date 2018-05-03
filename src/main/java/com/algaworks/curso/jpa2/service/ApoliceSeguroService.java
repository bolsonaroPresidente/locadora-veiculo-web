package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.ApoliceSeguroDAO;
import com.algaworks.curso.jpa2.model.ApoliceSeguro;

public class ApoliceSeguroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ApoliceSeguroDAO apoliceDAO;
	
	
	public void salvar(ApoliceSeguro as) {
		apoliceDAO.salvar(as);
	}
	
	
}
