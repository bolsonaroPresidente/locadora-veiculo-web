package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.service.CarroService;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private CarroService carroService;

	private Carro carroSelecionado;
	
	private List<Carro> carros;
	
	@PostConstruct
	public void inicializar() {
		this.carros = carroService.buscarTodos();
	}

	
	public void buscarAcessoriosParaCarro() {
		carroSelecionado = carroService.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	
	
	
	
	
	
	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}










































