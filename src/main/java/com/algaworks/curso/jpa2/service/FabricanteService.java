package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Fabricante;

public class FabricanteService implements Serializable {
	private static final long serialVersionUID = 121132001582823911L;

	@Inject
	private FabricanteDAO fd;

	public List<Fabricante> buscarTodos() {
		return fd.buscarTodos();
	}

	public void excluir(Fabricante fabricanteSelecionado) throws NegocioException  {
			fd.excluir(fabricanteSelecionado);
	}

	public Fabricante buscarPeloCodigo(Long cod) {
		
		return fd.buscarPeloCodigo(cod);
	}
	
	
	
	
}
