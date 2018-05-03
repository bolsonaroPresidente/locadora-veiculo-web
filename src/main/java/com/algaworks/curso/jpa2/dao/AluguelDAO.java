package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Aluguel;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException{
//		 ModeloCarro mc =  em.find(ModeloCarro.class, aluguel.getCarro().getModelo());
//		 Carro carro = em.find(Carro.class, aluguel.getCarro());
//		 carro.setModelo(mc);
//		 aluguel.setCarro(carro);
//		 
		 em.merge(aluguel);
	}

	public Aluguel buscaPeloCodigo(Long codigo) {
		return em.find(Aluguel.class, codigo);
	}
	

}











































