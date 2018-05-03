package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Transactional
	public void salvar(Acessorio acessorio) throws NegocioException {
		try {
			em.merge(acessorio);
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	public Acessorio buscaPeloCodigo(Long codigo) {
		return em.find(Acessorio.class,codigo);
	}
	
	public List<Acessorio> buscarTodos() {
		return em.createQuery("from Acessorio", Acessorio.class).getResultList();
	}
	
	@Transactional
	public void excluir(Acessorio acessorio) throws NegocioException{
		acessorio = buscaPeloCodigo(acessorio.getCodigo());
		try {
			em.remove(acessorio);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Acessório não pode ser removido");
		}
	}
	
}


































