package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Transactional
	public void salvar(Carro carro) throws NegocioException{
		try {
			em.merge(carro);
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}
	
	
	public Carro buscaComModeloPeloCodigo(Long codigo) {
		String fetchJoin ="Select c from Carro c"
						+ " inner join fetch c.modelo"
						+ " where c.codigo = :codigo";
		
		return em.createQuery(fetchJoin, Carro.class)
				.setParameter("codigo", codigo)
				.getSingleResult();
	}
	
	
	public List<Carro> buscarTodos() {
		return em.createQuery("from Carro", Carro.class).getResultList();
	}
	
	public Carro buscarPorCodigo(Long codigo) {
		return em.find(Carro.class, codigo);
	}
	
	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		try {
			carro = buscarPorCodigo(carro.getCodigo());
			em.remove(carro);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException(e.getMessage());
		}
	}


	public Carro buscarCarroComAcessorios(Long codigo) {
		//quando usa mais de uma entidade é necessário dizer qual entidade quer retornar, por isso é necessário colocar o Select *...
		return (Carro) em.createQuery("Select c from Carro c JOIN c.acessorios a where c.codigo = ?")
				.setParameter(1, codigo)
				.getSingleResult();
	}
	
}






















































