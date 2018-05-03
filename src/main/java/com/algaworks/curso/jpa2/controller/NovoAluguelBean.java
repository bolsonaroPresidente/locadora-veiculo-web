package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.exceptions.NegocioException;
import com.algaworks.curso.jpa2.model.Aluguel;
import com.algaworks.curso.jpa2.model.ApoliceSeguro;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.service.AluguelService;
import com.algaworks.curso.jpa2.service.CarroService;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Aluguel aluguel;
	
	private List<Carro> carros;

	@Inject
	private AluguelService aluguelService;
//    certeza que o problema é o entitymanager, colocar a busca de todos os carros no EM de aluguel, acho que resolve o problema de forma paleativa...
	@Inject
	private CarroService carroService;

//	private Carro carro;
	

	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.carros = this.carroService.buscarTodos();
	}

	private void limpar() {
//		this.carro = new Carro();
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public void salvar() {
		try {
			System.out.println(this.aluguel.getCarro());
//			this.aluguel.setCarro(carro);
			this.aluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel salvo com sucesso!");

			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}

//	public Carro getCarro() {
//		return carro;
//	}
//
//	public void setCarro(Carro carro) {
//		this.carro = carro;
//	}

	

}
