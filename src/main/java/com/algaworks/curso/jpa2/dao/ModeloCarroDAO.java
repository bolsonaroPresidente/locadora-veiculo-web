package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class ModeloCarroDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager em;
	
	@Transactional
	public void salvar(ModeloCarro modeloCarro ) throws NegocioException {
		//em.persist(fabricante);
		//em vez do persiste usa merge para os casos de edição pois o obeto pode ficar desatachado, naõ funciona para o remove
		em.merge(modeloCarro);
	}

	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return em.createQuery("from ModeloCarro").getResultList();
	}

	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException{
		/*
		 * necessário recuperar o objeto do banco antes de remove-lo pq qdo o bjeto recuperado na lista
		 * vai para a web ele perde a conexão com o EntityManager, pois depois de cumprir sua função
		 * o EM fecha, se tentar excluir o objeto diretamente, será apenas um objeto preenchido
		 * e o EM não o reconhece, pois o obj não está mais na adm do EM, então é gerado um erro
		 * dizendo que o obj NÃO ESTÁ ATACHADO:
		 * javax.faces.FacesException: #{pesquisaFabricanteBean.excluir}: java.lang.IllegalArgumentException: Removing a detached instance com.algaworks.curso.jpa2.model.Fabricante#1
		 */
		modeloCarro = em.find(ModeloCarro.class, modeloCarro.getCodigo());
		em.remove(modeloCarro);
		em.flush();//executa agora, pq nem sempre o banco vai executar o comando no mesmo momento
	}

	public ModeloCarro buscarPeloCodigo(Long cod) {
		return em.find(ModeloCarro.class, cod);
	}
	
	
	
	
}




	

