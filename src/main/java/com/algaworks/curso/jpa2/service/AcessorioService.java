package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;

public class AcessorioService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AcessorioDAO acessorioDAO;
	
	
	public void salvar(Acessorio acessorio) throws NegocioException{
		acessorioDAO.salvar(acessorio);
	}
	
	public Acessorio buscaPeloCodigo(Long codigo) {
		return acessorioDAO.buscaPeloCodigo(codigo);
	}
	
	public List<Acessorio> buscarTodos() {
		return acessorioDAO.buscarTodos();
	}
	
	public void excluir(Acessorio acessorio) throws NegocioException{
		acessorioDAO.excluir(acessorio);
	}
	
	
	
	
}
