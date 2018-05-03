package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.model.Carro;

public class CarroService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CarroDAO carroDAO;

	public void salvar(Carro carro) throws NegocioException{
		if (StringUtils.isAnyBlank(carro.getPlaca())) {
			throw new NegocioException("Placa do veículo é obrigatória");
		}
		carroDAO.salvar(carro);
	}
	
	
	public List<Carro> buscarTodos() {
		return carroDAO.buscarTodos();
	}
	
	public Carro buscaComModeloPeloCodigo(Long codigo) {
		return carroDAO.buscaComModeloPeloCodigo(codigo);
	}
	
	public Carro buscarPeloCodigo(Long codigo) {
		return carroDAO.buscarPorCodigo(codigo);
	}
	
	public void excluir(Carro carro) throws NegocioException {
		carroDAO.excluir(carro);
	}


	public Carro buscarCarroComAcessorios(Long codigo) {
		return carroDAO.buscarCarroComAcessorios(codigo);
	}


		


	
	

}






























































