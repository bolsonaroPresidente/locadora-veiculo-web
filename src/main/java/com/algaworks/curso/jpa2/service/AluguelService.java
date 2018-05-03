package com.algaworks.curso.jpa2.service;

import java.io.Serializable;
import java.util.Calendar;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Aluguel;

public class AluguelService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AluguelDAO aluguelDAO;
	
	public void salvar(Aluguel aluguel) throws NegocioException {
		if (aluguel.getCarro()==null) {
			throw new NegocioException("Carro é obrigatório.");
		}
		aluguel.setDataPedido(Calendar.getInstance());
		aluguelDAO.salvar(aluguel);
	}

	public Aluguel buscaPeloCodigo(Long codigo) {
		return aluguelDAO.buscaPeloCodigo(codigo);
	}
	
	
	
}































