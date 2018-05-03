package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroFabricanteService implements Serializable {
	private static final long serialVersionUID = -2527119296888404725L;

	@Inject
	private FabricanteDAO fd;
	
	@Transactional
	public void salvar(Fabricante fabricante) throws NegocioException {
		
		if (fabricante.getNome() == null || fabricante.getNome().isEmpty()) {
			throw new NegocioException("Nome do fabricante é obrigatório.");
		}
		fd.salvar(fabricante);
	}
	
}
